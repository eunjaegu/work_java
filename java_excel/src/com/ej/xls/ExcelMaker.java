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

	public ExcelMaker() { //�⺻������
	}

	public static void makeExcelFile() {
		String uri = "c:/filetest/data.xls";
		
		File f = new File(uri);			//import==>java.io.File
		
		WritableWorkbook wb = null;   //try catch ������ null ó��
		try {
			wb = Workbook.createWorkbook(f);
			
			WritableSheet s = wb.createSheet("ù��°",0);
			
			for(int i=0; i<10; i++) {
				Label label1 = new Label(0, i, "������=>"+i);  //import==> jxl write~ 
				s.addCell(label1);
				
				Label label2 = new Label(1, i, "������=>"+i);
				s.addCell(label2);
				
			}
			wb.write(); 	// ���� ������ ���� ���� ����..
			wb.close();	// ���� ������ ��, �ش� ���� �ݱ�
			
			System.out.println("���� ���� ���� ����!!!!");
		}catch(IOException ioe) {	// ���� ����� ����
			System.out.println(ioe.getMessage());
			
		}catch(RowsExceededException re) { // ���� ������ ����� ��� ����
			System.out.println(re.getMessage());
			
		}catch(WriteException we) { // ���Ͽ� �����͸� �� �� ����...
			System.out.println(we.getMessage());
		}
	
		
		
		
		
		
	}
	
	
}	//class END
