package com.pc.product.controller;

import com.pc.product.controller.ProductParams.PropertyName;

public class PropertyValue {

	private PropertyName name;
	private String color;
	private Integer gb_limit_max;
	private Integer gb_limit_min;

	public PropertyValue() {
	}

	public PropertyValue(PropertyName name, String color, Integer gb_limit_max, Integer gb_limit_min) {
		super();
		this.name = name;
		this.color = color;
		this.gb_limit_max = gb_limit_max;
		this.gb_limit_min = gb_limit_min;
	}



	public PropertyName getName() {
		return name;
	}

	public void setName(PropertyName name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getGb_limit_max() {
		return gb_limit_max;
	}

	public void setGb_limit_max(Integer gb_limit_max) {
		this.gb_limit_max = gb_limit_max;
	}

	public Integer getGb_limit_min() {
		return gb_limit_min;
	}

	public void setGb_limit_min(Integer gb_limit_min) {
		this.gb_limit_min = gb_limit_min;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ name='" + name).append("'");
		sb.append(", color='" + color).append("'");
		sb.append(", gb_limit_max=" + gb_limit_max);
		sb.append(", gb_limit_min=" + gb_limit_min);
		sb.append("]");
		return sb.toString();
	}

}
