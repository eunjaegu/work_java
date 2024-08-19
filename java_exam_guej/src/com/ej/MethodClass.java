package com.ej;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MethodClass {

	public MethodClass() {
	}

	public void fileReader() {
		String url = ("C:/work_java/java_exam_guej/datas/cafe,.txt");
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(url));

			String line;
			while ((line = br.readLine()) != null) {
				String[] temp = line.split("\", ");
				CafeClass al = new CafeClass(temp[0], temp[1], temp[2], temp[3], temp[4]);
				DataBaseClass.al.add(al);
				;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		} // fileRead() END
	} // fileReader()
} // MethodClass END
