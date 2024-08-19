package com.ej.xls;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelReader {

	public ExcelReader() {	//기본생성자
	}
	
	public static void readExcelFile() {
		String uri = "c:/filetest/data.xls";
		
		File f = null;
		Workbook wb = null;
		
		try{
			f = new File(uri);
			wb = Workbook.getWorkbook(f);
			Sheet s = wb.getSheet(0);
			
			int i = 0;
			while(true) {
				try {
					Cell c1 = s.getCell(0,i);
					Cell c2 = s.getCell(1,i);
					System.out.println(c1.getContents()+":"+c2.getContents());
					i++;
				}catch(Exception e) {
					System.out.println(e.getMessage());
					break;
				}
			}
			wb.close();
		}catch(Exception e) {
			
			
		}

		
		
	}
	
}	//class END
