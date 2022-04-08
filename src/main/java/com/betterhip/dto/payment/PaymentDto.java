package com.betterhip.dto.payment;

import java.awt.Image;
import java.sql.Timestamp;

public class PaymentDto {
	// Field
	int purchase_id;
	String purchase_user_id;
	int purchase_cake_id;
	int purchase_customize_id;
	Timestamp purchase_date;
	int purchase_price;
	String purchase_text;
	Image purchase_img;
	String purchase_status;
	int purchase_quantity;
	String purchase_kakao_id;
	
	int cake_id;
	String cake_name;
	int cake_saleprice;
	int cake_cost;
	String cake_status;
	Image cake_info;
	Image cake_img;
	
	String user_id;
	String user_pw;
	String user_name;
	String user_phone;
	String user_address;
	String user_address_detail;
	String user_postcode;
	String user_email;
	Timestamp user_joindate;
	Timestamp user_leavedate;
	
	int customize_id;
	String customize_taste;
	String customize_size;
	String customize_cream_type;
	String customize_cream_color;
	int customize_saleprice;
	int customize_cost;
	
	// Constructor
	public PaymentDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PaymentDto(String user_name, String user_phone, String user_email) {
		super();
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_email = user_email;
	}	
	

	public PaymentDto(int purchase_price, int purchase_quantity, String cake_name, String customize_taste,
			String customize_size, String customize_cream_type, String customize_cream_color) {
		super();
		this.purchase_price = purchase_price;
		this.purchase_quantity = purchase_quantity;
		this.cake_name = cake_name;
		this.customize_taste = customize_taste;
		this.customize_size = customize_size;
		this.customize_cream_type = customize_cream_type;
		this.customize_cream_color = customize_cream_color;
	}


	public PaymentDto(int purchase_price, int purchase_quantity, String cake_name, String user_name, String user_phone,
			String user_address, String user_address_detail, String user_postcode, String user_email) {
		super();
		this.purchase_price = purchase_price;
		this.purchase_quantity = purchase_quantity;
		this.cake_name = cake_name;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.user_address_detail = user_address_detail;
		this.user_postcode = user_postcode;
		this.user_email = user_email;
	}





	public PaymentDto(int purchase_price, int purchase_quantity, String cake_name, String user_name, String user_phone,
			String user_email, String customize_taste, String customize_size, String customize_cream_type,
			String customize_cream_color) {
		super();
		this.purchase_price = purchase_price;
		this.purchase_quantity = purchase_quantity;
		this.cake_name = cake_name;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.customize_taste = customize_taste;
		this.customize_size = customize_size;
		this.customize_cream_type = customize_cream_type;
		this.customize_cream_color = customize_cream_color;
	}
	
	
	
	
	


	public PaymentDto(int purchase_quantity, String cake_name) {
		super();
		this.purchase_quantity = purchase_quantity;
		this.cake_name = cake_name;
	}


	public PaymentDto(String user_name, String user_phone, String user_address, String user_address_detail,
			String user_postcode, String user_email) {
		super();
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.user_address_detail = user_address_detail;
		this.user_postcode = user_postcode;
		this.user_email = user_email;
	}


	// Method
	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public String getPurchase_user_id() {
		return purchase_user_id;
	}

	public void setPurchase_user_id(String purchase_user_id) {
		this.purchase_user_id = purchase_user_id;
	}

	public int getPurchase_cake_id() {
		return purchase_cake_id;
	}

	public void setPurchase_cake_id(int purchase_cake_id) {
		this.purchase_cake_id = purchase_cake_id;
	}

	public int getPurchase_customize_id() {
		return purchase_customize_id;
	}

	public void setPurchase_customize_id(int purchase_customize_id) {
		this.purchase_customize_id = purchase_customize_id;
	}

	public Timestamp getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Timestamp purchase_date) {
		this.purchase_date = purchase_date;
	}

	public int getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}

	public String getPurchase_text() {
		return purchase_text;
	}

	public void setPurchase_text(String purchase_text) {
		this.purchase_text = purchase_text;
	}

	public Image getPurchase_img() {
		return purchase_img;
	}

	public void setPurchase_img(Image purchase_img) {
		this.purchase_img = purchase_img;
	}

	public String getPurchase_status() {
		return purchase_status;
	}

	public void setPurchase_status(String purchase_status) {
		this.purchase_status = purchase_status;
	}

	public int getPurchase_quantity() {
		return purchase_quantity;
	}

	public void setPurchase_quantity(int purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}

	public String getPurchase_kakao_id() {
		return purchase_kakao_id;
	}

	public void setPurchase_kakao_id(String purchase_kakao_id) {
		this.purchase_kakao_id = purchase_kakao_id;
	}

	public int getCake_id() {
		return cake_id;
	}

	public void setCake_id(int cake_id) {
		this.cake_id = cake_id;
	}

	public String getCake_name() {
		return cake_name;
	}

	public void setCake_name(String cake_name) {
		this.cake_name = cake_name;
	}

	public int getCake_saleprice() {
		return cake_saleprice;
	}

	public void setCake_saleprice(int cake_saleprice) {
		this.cake_saleprice = cake_saleprice;
	}

	public int getCake_cost() {
		return cake_cost;
	}

	public void setCake_cost(int cake_cost) {
		this.cake_cost = cake_cost;
	}

	public String getCake_status() {
		return cake_status;
	}

	public void setCake_status(String cake_status) {
		this.cake_status = cake_status;
	}

	public Image getCake_info() {
		return cake_info;
	}

	public void setCake_info(Image cake_info) {
		this.cake_info = cake_info;
	}

	public Image getCake_img() {
		return cake_img;
	}

	public void setCake_img(Image cake_img) {
		this.cake_img = cake_img;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_address_detail() {
		return user_address_detail;
	}

	public void setUser_address_detail(String user_address_detail) {
		this.user_address_detail = user_address_detail;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Timestamp getUser_joindate() {
		return user_joindate;
	}

	public void setUser_joindate(Timestamp user_joindate) {
		this.user_joindate = user_joindate;
	}

	public Timestamp getUser_leavedate() {
		return user_leavedate;
	}

	public void setUser_leavedate(Timestamp user_leavedate) {
		this.user_leavedate = user_leavedate;
	}

	public int getCustomize_id() {
		return customize_id;
	}

	public void setCustomize_id(int customize_id) {
		this.customize_id = customize_id;
	}

	public String getCustomize_taste() {
		return customize_taste;
	}

	public void setCustomize_taste(String customize_taste) {
		this.customize_taste = customize_taste;
	}

	public String getCustomize_size() {
		return customize_size;
	}

	public void setCustomize_size(String customize_size) {
		this.customize_size = customize_size;
	}

	public String getCustomize_cream_type() {
		return customize_cream_type;
	}

	public void setCustomize_cream_type(String customize_cream_type) {
		this.customize_cream_type = customize_cream_type;
	}

	public String getCustomize_cream_color() {
		return customize_cream_color;
	}

	public void setCustomize_cream_color(String customize_cream_color) {
		this.customize_cream_color = customize_cream_color;
	}

	public int getCustomize_saleprice() {
		return customize_saleprice;
	}

	public void setCustomize_saleprice(int customize_saleprice) {
		this.customize_saleprice = customize_saleprice;
	}

	public int getCustomize_cost() {
		return customize_cost;
	}

	public void setCustomize_cost(int customize_cost) {
		this.customize_cost = customize_cost;
	}

	public String getUser_postcode() {
		return user_postcode;
	}

	public void setUser_postcode(String user_postcode) {
		this.user_postcode = user_postcode;
	}
	
	


}

