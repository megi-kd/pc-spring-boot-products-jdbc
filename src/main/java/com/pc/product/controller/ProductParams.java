package com.pc.product.controller;

public class ProductParams {

	public enum ProductType {
		phone, subscription
	}
	
	public enum PropertyName {
		color, gb_limit
	}
	
	private ProductType type;
	private Double min_price;
	private Double max_price;
	private String city;
	private PropertyValue property;

	public ProductParams() {
	}

	public ProductParams(ProductType type, Double min_price, Double max_price, String city, PropertyValue property) {
		super();
		this.type = type;
		this.min_price = min_price;
		this.max_price = max_price;
		this.city = city;
		this.property = property;
	}


	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public Double getMin_price() {
		return min_price;
	}

	public void setMin_price(Double min_price) {
		this.min_price = min_price;
	}

	public Double getMax_price() {
		return max_price;
	}

	public void setMax_price(Double max_price) {
		this.max_price = max_price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PropertyValue getProperty() {
		return property;
	}

	public void setProperty(PropertyValue property) {
		this.property = property;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ProductParams {");
		sb.append(" type='" + type).append("'");
		sb.append(", max_price=" + max_price);
		sb.append(", min_price=" + min_price);
		sb.append(", city='" + city).append("'");
		sb.append(", property=" + property);
		sb.append("}");
		return sb.toString();
	}

}
