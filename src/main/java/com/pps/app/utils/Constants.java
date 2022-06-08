package com.pps.app.utils;

public final class Constants {

	public static interface MSG_CONSTANT{
        public static final String SAVE_SUCCESS = "บันทึกข้อมูลสำเร็จ";
        public static final String SAVE_ERROR = "ไม่สามารถบันทึกข้อมูลได้ กรุณาลองใหม่อีกครั้ง";

        public static final String DELETE_SUCCESS = "ลบข้อมูลสำเร็จ";
        public static final String DELETE_ERROR = "ไม่สามารถลบข้อมูลได้ กรุณาลองใหม่อีกครั้ง";
        public static final String DUPLICATE_DATA = "ไม่สามารถบันทึกข้อมูลได้ เนื่องจากข้อมูลซ้ำ";
        public static final String DATA_NOT_FOUND = "ไม่พบข้อมูล";
    	public static final String SEARCH_SUCCESS = "ค้นหาข้อมูลสำเร็จ";
        public static final String SEARCH_ERROR = "ไม่สามารถค้นหาข้อมูลได้ กรุณาลองใหม่อีกครั้ง";
    }
	
	public static interface DB_ERROR_CODE{
        public static final Integer DUPLICATE_DATA = -803;
    }
}
