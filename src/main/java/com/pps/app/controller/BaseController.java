package com.pps.app.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.pps.app.dto.ResponseDto;
import com.pps.app.utils.Constants;
import com.pps.enumeration.StatusText;

@Controller
public class BaseController {
	private final Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * objective: get custom message of exception to the screen
	 * 
	 * @param response
	 * @param ex
	 * @return
	 */
	protected ResponseDto getExceptionMessage(ResponseDto response, Exception ex, String message) {
		String returnMsg = StringUtils.isNotEmpty(message) ? message : Constants.MSG_CONSTANT.SAVE_ERROR;

		if (ex instanceof DataIntegrityViolationException) {
			SQLIntegrityConstraintViolationException sqlException = (SQLIntegrityConstraintViolationException) ((DataIntegrityViolationException) ex)
					.getMostSpecificCause();
			if (Constants.DB_ERROR_CODE.DUPLICATE_DATA == sqlException.getErrorCode()) {
				response.setMessage(Constants.MSG_CONSTANT.DUPLICATE_DATA);
			} else {
				response.setMessage(returnMsg);
			}
		} else if (ex instanceof EntityNotFoundException) {
			response.setMessage(Constants.MSG_CONSTANT.DATA_NOT_FOUND);
		} else {
			response.setMessage(returnMsg);
		}
		response.setStatusText(StatusText.ERROR);
		return response;
	}

	/**
	 * objective: return success response to screen
	 * 
	 * @param response
	 * @return
	 */
	protected ResponseDto getOkMessage(ResponseDto response, String message) {
		String returnMsg = StringUtils.isNotEmpty(message) ? message : Constants.MSG_CONSTANT.SAVE_SUCCESS;
		response.setMessage(returnMsg);
		response.setStatusText(StatusText.OK);
		return response;
	}

}
