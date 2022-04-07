package com.betterhip.dto.cart;

import java.sql.Blob;

public class CartListDto {
	
	// Field
	int purchase_id;
	int purchase_quantity;
	int purchase_price;
	String purchase_custom_size; 
	String purchase_custom_taste; 
	String purchase_custom_cream_type; 
	String purchase_custom_cream_color;
	String purchase_text;
	String purchase_cake_name;
	Blob purchase_cake_img;
	
	
	// Constructor
	
	public CartListDto(int purchase_id, int purchase_quantity, int purchase_price, String purchase_custom_size,
			String purchase_custom_taste, String purchase_custom_cream_type, String purchase_custom_cream_color,
			String purchase_text, String purchase_cake_name, Blob purchase_cake_img) {
		super();
		this.purchase_id = purchase_id;
		this.purchase_quantity = purchase_quantity;
		this.purchase_price = purchase_price;
		this.purchase_custom_size = purchase_custom_size;
		this.purchase_custom_taste = purchase_custom_taste;
		this.purchase_custom_cream_type = purchase_custom_cream_type;
		this.purchase_custom_cream_color = purchase_custom_cream_color;
		this.purchase_text = purchase_text;
		this.purchase_cake_name = purchase_cake_name;
		this.purchase_cake_img = purchase_cake_img;
	}


	
	// Method
	public int getPurchase_id() {
		return purchase_id;
	}


	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}


	public int getPurchase_quantity() {
		return purchase_quantity;
	}


	public void setPurchase_quantity(int purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}


	public int getPurchase_price() {
		return purchase_price;
	}


	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}


	public String getPurchase_custom_size() {
		return purchase_custom_size;
	}


	public void setPurchase_custom_size(String purchase_custom_size) {
		this.purchase_custom_size = purchase_custom_size;
	}


	public String getPurchase_custom_taste() {
		return purchase_custom_taste;
	}


	public void setPurchase_custom_taste(String purchase_custom_taste) {
		this.purchase_custom_taste = purchase_custom_taste;
	}


	public String getPurchase_custom_cream_type() {
		return purchase_custom_cream_type;
	}


	public void setPurchase_custom_cream_type(String purchase_custom_cream_type) {
		this.purchase_custom_cream_type = purchase_custom_cream_type;
	}


	public String getPurchase_custom_cream_color() {
		return purchase_custom_cream_color;
	}


	public void setPurchase_custom_cream_color(String purchase_custom_cream_color) {
		this.purchase_custom_cream_color = purchase_custom_cream_color;
	}


	public String getPurchase_text() {
		return purchase_text;
	}


	public void setPurchase_text(String purchase_text) {
		this.purchase_text = purchase_text;
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
	
	
}
