package com.betterhip.dto.cart;

import java.sql.Blob;

public class CartListDto {
	
	// Field
	int purchase_id;
	String purchase_cake_name;
	Blob purchase_cake_img;
	String purchase_custom;
	String purchase_text;
	String purchase_quantity;
	String purchase_price;
	
	// Constructor
	public CartListDto() {
		
	}
	
	public CartListDto(int purchase_id, String purchase_cake_name, Blob purchase_cake_img, String purchase_custom,
			String purchase_text, String purchase_quantity, String purchase_price) {
		super();
		this.purchase_id = purchase_id;
		this.purchase_cake_name = purchase_cake_name;
		this.purchase_cake_img = purchase_cake_img;
		this.purchase_custom = purchase_custom;
		this.purchase_text = purchase_text;
		this.purchase_quantity = purchase_quantity;
		this.purchase_price = purchase_price;
	}




	// Method
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getPurchase_cake_name() {
		return purchase_cake_name;
	}
	public void setPurchase_cake_name(String purchase_cake_name) {
		this.purchase_cake_name = purchase_cake_name;
	}
	public Blob getPurchase_cake_img() {
		return purchase_cake_img;
	}
	public void setPurchase_cake_img(Blob purchase_cake_img) {
		this.purchase_cake_img = purchase_cake_img;
	}
	public String getPurchase_custom() {
		return purchase_custom;
	}
	public void setPurchase_custom(String purchase_custom) {
		this.purchase_custom = purchase_custom;
	}
	public String getPurchase_text() {
		return purchase_text;
	}
	public void setPurchase_text(String purchase_text) {
		this.purchase_text = purchase_text;
	}
	public String getPurchase_quantity() {
		return purchase_quantity;
	}
	public void setPurchase_quantity(String purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}
	public String getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(String purchase_price) {
		this.purchase_price = purchase_price;
	}
	
}
