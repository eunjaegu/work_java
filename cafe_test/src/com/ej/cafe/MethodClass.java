package com.ej.cafe;

import java.util.ArrayList;
import java.util.Comparator;

public class MethodClass {
	//CafeClass 객체에서 item 만 추출하여 저장할 ArrayList
	private  ArrayList<String> items = new ArrayList<String>();
	
	// 위의 item에서 중복 제거된 item들만 저장할  ArrayList
	private ArrayList<String> no = new ArrayList<String>();
	
	//위의 중복제거된 item과 count할 수 있도록 각각 객체화하여 저장할 ArrayList
	private ArrayList<ItemCountClass> item_count_list = new ArrayList<ItemCountClass>();
	
	
	public MethodClass() {	//기본생성자
	}

	
	/** CafeClass 객체에서 item 만 추출하여 저장 메서드 **/
	public void item() {
		for(int n=0; n<DataClass.cafe.size(); n++) {
			items.add(DataClass.cafe.get(n).getItem());
		}
		/* 또는
		   for(CafeClass cafe : DataClass.cafe ){
		 	items.add(cafe.getItem());
		  }
		 */ 
	}	//item end
	
	/** items 내의 데이터 중복 제거 메서드 **/
	//private ArrayList<String>no = new ArrayList<String>();
	public void duplicate() {
		String tempString = ""; // 중복제거를 위한 임시저장
		
		// 중복제거 전 데이터 정렬 : ArrayList.sort()		///*****중요
		items.sort(Comparator.naturalOrder());
		
		for(int n=0; n<items.size(); n++) {
			if(!tempString.equals(items.get(n))) {
				tempString = items.get(n);
				no.add(tempString);
				
			}
			
		}
		
	}	//duplicate() end
	
	
	/** no 내의 item값과 count변수를 하나의 객체로 추가 메서드 **/
	//private ArrayList<ItemCountClass> item_count_list = new ArrayList<ItemCountClass>();
	public void item_count_list() {
		for(String item : no) {
			item_count_list.add(new ItemCountClass(item));
			
			
		}
		
	}	//item_count_list() END
	
	
	
	/** ItemCountClass 객체들을 저장한 ArrayList와 전체 데이터를 비교하여 count 하는 메서드**/
	public void counting() {
		for(ItemCountClass itmeObj : item_count_list) {
			
			for(int idx = 0; idx<DataClass.cafe.size(); idx++) {
				
				if(itmeObj.item.equals(DataClass.cafe.get(idx).getItem())) {
					itmeObj.count++;
				}
				
			}	// 전체 데이터 순회
		} 	//중복 제거 데이터 순회
	}	// counting() END
	
	/** count 값이 가장 큰 객체를 찾아서 반환 **/
	public ItemCountClass maxItem() {
		
		
		
		ItemCountClass tempObj = new ItemCountClass(); // 임시저장
		
		for(ItemCountClass item : item_count_list) {
			if(tempObj.count<item.count) {
				tempObj.count = item.count;
				tempObj.item = item.item;
			}
		}
		
		return tempObj;
		
	}
	
	
	
	
	
	
	
	
	//나중에 public(main에서 결과값 확인을 위해) 에서 private(외부접근금지를 위해)로 변경함. 
	
}	//MethodClass {}	END
