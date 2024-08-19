package com.ej;

import com.ej.ex.ChildClass;
import com.ej.ex.ExtendClassOne;
import com.ej.ex.ParentClassOne;

public class MainClass {

	public static void main(String[] args) {
		ExtendsAbstractClass eac = new ExtendsAbstractClass();
		
		//abstract 클래스는 생성자를 가질 수 있지만, 자체 객체 생성불가!
//		AbstractClass ac = new AbstractClass();
		
//		interface는 생성자가 없기 떄문에 객체 생성 불가!!!
//		InterfaceClassOne IN1 = New InterfaceClassOne();
		
/*		Object eco=new ExtendClassOne();	//ParentClassOne
		Object ect=new ExtendClassTwo();	//ParentClassOne
		ExtendClassTwo ect2 = (ExtendClassTwo)ect;	// 형변환(부모는 모르니 형변환 하여 자식변수 나타나게 한다.)
		
		
		Object pco=new ParentClassOne();
		Object cc=new ChildClass();						//ParentClassOne
*/		
	}

}
