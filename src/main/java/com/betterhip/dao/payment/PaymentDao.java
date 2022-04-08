package com.betterhip.dao.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.betterhip.dto.payment.PaymentDto;

public class PaymentDao {
	
	DataSource dateSource;
	
	public PaymentDao() {
		try {
			Context context = new InitialContext();
			dateSource = (DataSource) context.lookup("java:/comp/env/jdbc/betterhip");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//--------------------------------paySuccess-------------------------------------------
	
	// 매서드 내용 결재 성공시 user_id와 purchase_kakao_id를 가져와 해당user_id에 purchase_status가 2인 곳에 purchase_status를 3으로,purchase_kakao_id를 가져온 값으로,purchase_date를 지금으로 수정함
	
	public void paySuccess(String user_id, String purchase_kakao_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "update purchase,user set purchase_status='3', purchase_kakao_id=?, purchase_date=now() where user_id=purchase_user_id and user_id=? and purchase_status='2'";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, purchase_kakao_id);
			preparedStatement.setString(2, user_id);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // paySuccess()
	
	
	//-----------------payFailure---------
	
	// 매서드 내용 결제 실패시 해당 user_id에 purchase_status가 2인 곳에 purchase_status를 1로 수정하는 매서드
	
	public void payFailure(String user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "update purchase,user set purchase_status='1' where user_id=purchase_user_id and user_id=? and purchase_status='2'";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	} // paySuccess()
	
	
	
	//-----------------------paymentList-----------------------
	
	//매서드 내용 해당 user_id의 purchase_status가 2인 주문의 내용을 리스트로 내보내는 매서드
		
	public ArrayList<PaymentDto> paymentList(String user_id) {
		ArrayList<PaymentDto> dtos = new ArrayList<PaymentDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "select cake_name, purchase_price, purchase_quantity, customize_taste, customize_size, customize_cream_type, customize_cream_color from cake, purchase, customize where purchase_cake_id=cake_id and purchase_customize_id=customize_id and purchase_status='2' and purchase_user_id=?;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("dao");
			
			while(resultSet.next()) {
				int purchase_price = resultSet.getInt("purchase_price");
				int purchase_quantity = resultSet.getInt("purchase_quantity");
				String cake_name = resultSet.getString("cake_name");
				String customize_taste = resultSet.getString("customize_taste");
				String customize_size = resultSet.getString("customize_size");
				String customize_cream_type = resultSet.getString("customize_cream_type");
				String customize_cream_color = resultSet.getString("customize_cream_color");
				
				PaymentDto dto = new PaymentDto(purchase_price, purchase_quantity, cake_name, customize_taste, customize_size, customize_cream_type, customize_cream_color);
				dtos.add(dto);
				System.out.println("1");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	} // paymentList()
	
// 매서드 내용 user_id로 해당 유저의 정보(name, phone, email)을 가져오는 매서드
	
	public PaymentDto paymentUserList(String user_id) {
		PaymentDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "select user_name, user_phone, user_email from user where user_id= ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("dao");
			
			while(resultSet.next()) {
				String user_name = resultSet.getString("user_name");
				String user_phone = resultSet.getString("user_phone");
				String user_email = resultSet.getString("user_email");
				
				
				dto = new PaymentDto(user_name, user_phone, user_email);
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;	
	}// PaymentUserList()	
		
	// 매서드 내용 user_id에 해당하는 유저의  purchase_status가 2인 주문들의 purchase_price 합을 가져오는 매서드 
	
	public int paymentPriceList(String user_id) {
		int total_price =0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "select sum(purchase_price) as total_price from purchase where purchase_status='2' and purchase_user_id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("dao");
			
			
			while(resultSet.next()) {
				total_price = resultSet.getInt("total_price");
				
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return total_price;
	}//paymentPriceList
	
	
	
	//----------------------------------payment method-----------------------------------
	
	
	// 매서드 내용 user_id로 해당 유저의 name,email,phone,address,address_detail,postcode 등을 가져오는 매서드
	
	public PaymentDto paymentUser(String user_id) {
		PaymentDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "select user_name, user_email, user_phone, user_address, user_address_detail, user_postcode from user where user_id=?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("dao");
			
			while(resultSet.next()) {
				String user_name = resultSet.getString("user_name");
				String user_phone = resultSet.getString("user_phone");
				String user_email = resultSet.getString("user_email");
				String user_address = resultSet.getString("user_address");
				String user_address_detail = resultSet.getString("user_address_detail");
				String user_postcode = resultSet.getString("user_postcode");
				
				
				dto = new PaymentDto(user_name, user_phone, user_address, user_address_detail, user_postcode, user_email);
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;	
	}// PaymentUser()	
	
	
	// 매서드 내용 user_id에 해당하는 유저가 결제할 케이크 하나의 이름과 주문 수량을 가져오는 매서드
		
	public PaymentDto paymentCake(String user_id) {
		PaymentDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "select cake_name, purchase_quantity from cake, purchase, user where user_id=purchase_user_id and cake_id=purchase_cake_id and user_id=? limit 1";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("dao");
			
			while(resultSet.next()) {
				String cake_name = resultSet.getString("cake_name");
				int purchase_quantity = resultSet.getInt("purchase_quantity");
				
				
				dto = new PaymentDto(purchase_quantity, cake_name);
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;	
	}// PaymentUser()	
		
	
	// 매서드 내용 user_id에 해당하는 주문 건수를 가져오는 매서드

	public int paymentCount(String user_id) {
		int purchase_count =0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "select count(purchase_id)as purchase_count from purchase, user where user_id=purchase_user_id and user_id=? and purchase_status='2'";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("dao");
			
			
			while(resultSet.next()) {
				purchase_count = resultSet.getInt("purchase_count");
				
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return purchase_count;
	}//paymentCount
		

		
		
	
	
	

}
