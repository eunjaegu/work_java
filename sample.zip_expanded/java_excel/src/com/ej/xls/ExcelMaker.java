package com.ej.xls;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelMaker {

	public ExcelMaker() { //기본생성자
	}

	public static void makeExcelFile() {
		String uri = "c:/filetest/data.xls";
		
		File f = new File(uri);			//import==>java.io.File
		
		WritableWorkbook wb = null;   //try catch 때문에 null 처리
		try {
			wb = Workbook.createWorkbook(f);
			
			WritableSheet s = wb.createSheet("첫번째",0);
			
			for(int i=0; i<10; i++) {
				Label label1 = new Label(0, i, "데이터=>"+i);  //import==> jxl write~ 
				s.addCell(label1);
				
				Label label2 = new Label(1, i, "데이터=>"+i);
				s.addCell(label2);
				
			}
			wb.write(); 	// 위의 내용을 토대로 실제 쓰기..
			wb.close();	// 쓰고 저장한 후, 해당 파일 닫기
			
			System.out.println("엑셀 파일 생성 성공!!!!");
		}catch(IOException ioe) {	// 파일 입출력 오류
			System.out.println(ioe.getMessage());
			
		}catch(RowsExceededException re) { // 행의 범위가 벗어났을 경우 오류
			System.out.println(re.getMessage());
			
		}catch(WriteException we) { // 파일에 데이터를 쓸 때 오류...
			System.out.println(we.getMessage());
		}
	
		
		
		
		
		
	}
	
	
}	//class END
