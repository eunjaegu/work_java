package com.ej.cafe;

public class CafeClass {
		private String order_id="";
		private String order_date="";
		private String category="";
		private String item="";
		int price=0;

		public CafeClass() {	//�⺻������
			
		}
		
	// �⺻�����ڸ� Overloading �� ������
	public CafeClass(String order_id, String order_date, String category, String item, int price) {
		this.order_id=order_id;
		this.order_date=order_date;
		this.category=category;
		this.item=item;
		this.price=price;	 
	}	//Overloading �� ������ END

	public String getOrder_id() {
		return order_id;
	}

	public String getOrder_date() {
		return order_date;
	}

	public String getCategory() {
		return category;
	}

	public String getItem() {
		return item;
	}

	public int getPrice() {
		return price;
	}

	// private �����鿡 ���� getter �޼����....

	
	
	}

