package com.ej.split;

public class MemberClass {
	String name;       		//�̸�
	String joinDate;   		//������
	String lastVisitDate;    //�����湮��
	int numVisit;			//�湮Ƚ��
	String gender;         	//����
	int age;         			//���ɴ�
	
	public MemberClass() {
		
	}

	public void inputRecord(String raw) {
		//Srting.split("������") ==> String[]�� ��ȯ
				String[] split = raw.split(",");
				name = split[0];
				joinDate = split[1];
				lastVisitDate = split[2];
				//Integer.parseInt("123") => ���ڿ����ڸ� ������ ��ȯ!!!!!
				numVisit= Integer.parseInt(split[3]);
				gender = split[4];
				//Sting.substring(���� �ε���, �� �ε���)
				String temp = split[5].substring(0, 2);
				//"�����" ������ ó��
				if (temp.equals("���")) {
					temp= "0";
				}
			
				age = Integer.parseInt(temp);

	}
}
