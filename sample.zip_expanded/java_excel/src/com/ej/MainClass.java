package com.ej;

import com.ej.xls.ExcelMaker;
import com.ej.xls.ExcelReader;

public class MainClass {

	public static void main(String[] args) {
//		ExcelMaker em = new ExcelMaker();
//		em.makeExcelFile();
//		ExcelMaker.makeExcelFile(); 		// 클래스.생성자
		ExcelReader.readExcelFile();
	}

}
