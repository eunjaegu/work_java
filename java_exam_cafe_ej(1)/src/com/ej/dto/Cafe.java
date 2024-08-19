package com.ej.dto;

public class Cafe {
	
	private String order_id="";
	private String order_date="";
	private String category="";
	private String item="";
	int price=0;
	
	public Cafe() {	//기본 생성자
	}
	
	public Cafe(String order_id, String order_date, String category, String item, int price) {
		this.order_id=order_id;
		this.order_date=order_date;
		this.category=category;
		this.item=item;
		this.price=price;
		}

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

	@Override
	public String toString() {
		return "Cafe [order_id=" + order_id + ", order_date=" + order_date + ", category=" + category + ", item=" + item
				+ ", price=" + price + "]";
	}	
	
	
		

}	// end class Cafe
