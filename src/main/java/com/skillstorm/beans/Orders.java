package com.skillstorm.beans;


public class Orders {
	private int id; 
	private String full_name;
	private String product_name;
	private float price;
	private String company;
	private String category;
	private int stock;
	private String order_date;
	private String order_status;
	
	public Orders() {
		super();
	}
	
	

	public Orders(int id, String full_name, String product_name, float price, String company, String category,
			int stock, String order_date, String order_status) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.product_name = product_name;
		this.price = price;
		this.company = company;
		this.category = category;
		this.stock = stock;
		this.order_date = order_date;
		this.order_status = order_status;
	}



	public Orders(String full_name, String product_name, float price, String company, String category, int stock,
			String order_date, String order_status) {
		super();
		this.full_name = full_name;
		this.product_name = product_name;
		this.price = price;
		this.company = company;
		this.category = category;
		this.stock = stock;
		this.order_date = order_date;
		this.order_status = order_status;
	}

	public Orders(int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", full_name=" + full_name + ", product_name=" + product_name + ", price=" + price
				+ ", company=" + company + ", category=" + category + ", stock=" + stock + ", order_date=" + order_date
				+ ", order_status=" + order_status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((full_name == null) ? 0 : full_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((order_date == null) ? 0 : order_date.hashCode());
		result = prime * result + ((order_status == null) ? 0 : order_status.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result + stock;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (full_name == null) {
			if (other.full_name != null)
				return false;
		} else if (!full_name.equals(other.full_name))
			return false;
		if (id != other.id)
			return false;
		if (order_date == null) {
			if (other.order_date != null)
				return false;
		} else if (!order_date.equals(other.order_date))
			return false;
		if (order_status == null) {
			if (other.order_status != null)
				return false;
		} else if (!order_status.equals(other.order_status))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}
	
	


}