package com.ej;

public class CafeClass {
	private String order_id = "";
	private String order_date = "";
	private String category = "";
	private String item = "";
	int price = 0;

	public CafeClass() { // 기본생성자
	}

	public CafeClass(String order_id, String order_date, String category, String item, String price) {
		this.order_id = order_id.substring(1);
		this.order_date = order_date.substring(1);
		this.category = category.substring(1);
		this.item = item.substring(1);
		this.price = Integer.parseInt(price);

	} // Overloading 한 생성자 END

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
		return "CafeClass [order_id=" + order_id + ", order_date=" + order_date + ", category=" + category + ", item="
				+ item + ", price=" + price + "]";
	}
} // CafeClass END
