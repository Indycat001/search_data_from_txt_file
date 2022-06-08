package com.pps.app.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pps.app.dto.IncomeDto;
import com.pps.app.dto.IncomeTb1Dto;
import com.pps.app.dto.IncomeTb2Dto;
import com.pps.app.dto.ResponseDto;

@RestController
@RequestMapping("/income")
public class IncomeController extends BaseController {
	
	@Value("${app.file-storage.file-domestic-dir}")
	private String domesticPath;

	@Value("${app.file-storage.file-cross-border-dir}")
	private String crossborderPath;

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> searchIncome(@RequestBody IncomeDto incomeDto) throws FileNotFoundException {


		@SuppressWarnings("rawtypes")
		ResponseDto response = new ResponseDto();
		String fileNameTable1 = null;
		String fileNameTable2 = null;

		// for test local!!
		/*String pathFile1 = "C:\\Users\\snoop\\Downloads\\edc_domestic_income_type.txt";
		String pathFile2 = "C:\\Users\\snoop\\Downloads\\edc_cross_border_income_type.txt";*/

		File fileTb1 = null;
		Scanner myReader = null;

		File fileTb2 = null;
		Scanner myReader2 = null;

		try {

			// get file table1.
//			fileTb1 = new File(pathFile1);
			fileTb1 = new File(domesticPath);
			fileNameTable1 = fileTb1.getName();

			// read file table1.
			myReader = new Scanner(fileTb1);

			List<IncomeTb1Dto> tb1list = new ArrayList<>();
			IncomeDto dto = new IncomeDto();

			if (myReader != null) {
				while (myReader.hasNextLine()) {
					String[] data = myReader.nextLine().trim().split("\\|");
					if (data.length < 3) {
						response.setMessage("เกิดข้อผิดพลาด กรุณาตรวจสอบ file : " + fileNameTable1);
						return new ResponseEntity<>(getExceptionMessage(response, null, response.getMessage()),
								HttpStatus.INTERNAL_SERVER_ERROR);
					} else {
						dto = new IncomeDto();
						IncomeTb1Dto tb1 = new IncomeTb1Dto();
						tb1.setCodeIncomeTb1(data[0]);
						tb1.setNameThIncomeTb1(data[1]);
						tb1.setNameEngIncomeTb1(data[2]);
						tb1list.add(tb1);
					}
				}
			}

			// search table1.
			if ((incomeDto.getCodeIncome() != null && !incomeDto.getCodeIncome().equals(""))
					&& (incomeDto.getNameIncome() != null && !incomeDto.getNameIncome().equals(""))) {// not null && not
																										// null

				List<IncomeTb1Dto> result = tb1list.stream()
						.filter(item -> item.getCodeIncomeTb1().contains(incomeDto.getCodeIncome())
								&& (item.getNameThIncomeTb1().contains(incomeDto.getNameIncome())
										&& item.getNameEngIncomeTb1().contains(incomeDto.getNameIncome())))
						.collect(Collectors.toList());
				if (result.isEmpty()) {
					dto.setIncomeTb1(null);
				} else {
					dto.setIncomeTb1(result);
				}
			} else if ((incomeDto.getCodeIncome() != null && !incomeDto.getCodeIncome().equals(""))
					&& (incomeDto.getNameIncome() == null || incomeDto.getNameIncome().isEmpty())) { // not null && null
				List<IncomeTb1Dto> result = tb1list.stream()
						.filter(item -> item.getCodeIncomeTb1().contains(incomeDto.getCodeIncome()))
						.collect(Collectors.toList());
				if (result.isEmpty()) {
					dto.setIncomeTb1(null);
				} else {
					dto.setIncomeTb1(result);
				}
			} else if ((incomeDto.getCodeIncome() == null || incomeDto.getCodeIncome().isEmpty())
					&& (incomeDto.getNameIncome() != null && !incomeDto.getNameIncome().equals(""))) { // null && not
																										// null
				List<IncomeTb1Dto> result = tb1list.stream()
						.filter(item -> (item.getNameThIncomeTb1().contains(incomeDto.getNameIncome())
								|| item.getNameEngIncomeTb1().contains(incomeDto.getNameIncome())))
						.collect(Collectors.toList());
				if (result.isEmpty()) {
					dto.setIncomeTb1(null);
				} else {
					dto.setIncomeTb1(result);
				}
			} else { // null && null
				dto.setIncomeTb1(tb1list);
			}
			// get file table2.
//			fileTb2 = new File(pathFile2);
			fileTb2 = new File(crossborderPath);
			fileNameTable2 = fileTb2.getName();

			// read file table2.
			myReader2 = new Scanner(fileTb2);

			List<IncomeTb2Dto> tb2list = new ArrayList<>();
			if (myReader2 != null) {
				while (myReader2.hasNextLine()) {
					String[] data = myReader2.nextLine().trim().split("\\|");
					if (data.length < 3) {
						response.setMessage("เกิดข้อผิดพลาด กรุณาตรวจสอบ file : " + fileNameTable2);
						return new ResponseEntity<>(getExceptionMessage(response, null, response.getMessage()),
								HttpStatus.INTERNAL_SERVER_ERROR);
					} else {
						IncomeTb2Dto tb2 = new IncomeTb2Dto();
						tb2.setCodeIncomeTb2(data[0]);
						tb2.setNameThIncomeTb2(data[1]);
						tb2.setNameEngIncomeTb2(data[2]);
						tb2list.add(tb2);
					}

				}
			}

			// search table2.
			if ((incomeDto.getCodeIncome() != null && !incomeDto.getCodeIncome().equals(""))
					&& (incomeDto.getNameIncome() != null && !incomeDto.getNameIncome().equals(""))) {// not null && not
																										// null

				List<IncomeTb2Dto> result = tb2list.stream()
						.filter(item -> item.getCodeIncomeTb2().contains(incomeDto.getCodeIncome())
								&& (item.getNameThIncomeTb2().contains(incomeDto.getNameIncome())
										&& item.getNameEngIncomeTb2().contains(incomeDto.getNameIncome())))
						.collect(Collectors.toList());
				if (result.isEmpty()) {
					dto.setIncomeTb2(null);
				} else {
					dto.setIncomeTb2(result);
				}
			} else if ((incomeDto.getCodeIncome() != null && !incomeDto.getCodeIncome().equals(""))
					&& (incomeDto.getNameIncome() == null || incomeDto.getNameIncome().isEmpty())) { // not null && null
				List<IncomeTb2Dto> result = tb2list.stream()
						.filter(item -> item.getCodeIncomeTb2().contains(incomeDto.getCodeIncome()))
						.collect(Collectors.toList());
				if (result.isEmpty()) {
					dto.setIncomeTb2(null);
				} else {
					dto.setIncomeTb2(result);
				}
			} else if ((incomeDto.getCodeIncome() == null || incomeDto.getCodeIncome().isEmpty())
					&& (incomeDto.getNameIncome() != null && !incomeDto.getNameIncome().equals(""))) { // null && not
																										// null
				List<IncomeTb2Dto> result = tb2list.stream()
						.filter(item -> (item.getNameThIncomeTb2().contains(incomeDto.getNameIncome())
								|| item.getNameEngIncomeTb2().contains(incomeDto.getNameIncome())))
						.collect(Collectors.toList());
				if (result.isEmpty()) {
					dto.setIncomeTb2(null);
				} else {
					dto.setIncomeTb2(result);
				}
			} else { // null && null
				dto.setIncomeTb2(tb2list);
			}
			response.setStatus(200);
			response.setMessage(HttpStatus.OK.name());
			response.setData(dto);
			return new ResponseEntity<>(getOkMessage(response, null), HttpStatus.OK);

		} catch (Exception e) {
			// e.printStackTrace();
			response.setData(null);
			response.setMessage("file " + fileNameTable1 + " หรือ  " + fileNameTable1 + " ไม่มีการวางไฟล์");
			return new ResponseEntity<>(getExceptionMessage(response, null, response.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			if (myReader != null) {
				myReader.close();
			}

			if (myReader2 != null) {
				myReader2.close();
			}
		}

	}
}
