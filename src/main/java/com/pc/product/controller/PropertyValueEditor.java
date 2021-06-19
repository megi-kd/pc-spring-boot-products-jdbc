package com.pc.product.controller;

import java.beans.PropertyEditorSupport;

public class PropertyValueEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		PropertyValue pValue = new PropertyValue();
		pValue.setName(ProductParams.PropertyName.valueOf(text));
		setValue(pValue);
	}
	
	
}
