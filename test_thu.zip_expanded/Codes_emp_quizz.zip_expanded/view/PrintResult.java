package com.freeflux.view;

import java.util.ArrayList;

import com.freeflux.dto.Employee;

public class PrintResult {

	public PrintResult() {
	}

	public static void printSelectAll(ArrayList<Employee> emps) {
		for (Employee employee : emps) {
		System.out.println(employee);
		}
	}
	
	public static void printJobSelect() {
		System.out.println();
		System.out.println("���ϴ� �۾� ��ȣ�� �Է��� �ּ���..");
		System.out.println("1. ��ü�����ȸ / 2. ����߰� / 3. ����� �޿�10%�ø� / 4. ���� ��å ��� ���� / 5. �۾� ����:  ");
	}
}
