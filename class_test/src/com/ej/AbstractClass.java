package com.ej;

//����ο� abstract�� �ݵ�� �ʿ�
public abstract class AbstractClass {
	public int var1 = 1000;			//�Ϲݺ���
	public final int var2 = 1000;		//���

	public AbstractClass() {	//������ 
		System.out.println("AbstractClass() ������ ȣ���!");
	}

	public void test() {					// �Ϲ� �޼��� ����
		
	}
	
	public abstract void sum(); 		//�߻� �޼���� ����
	
}
