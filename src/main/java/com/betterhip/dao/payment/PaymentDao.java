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
	
	public void paySuccess(String purchase_id, String purchase_kakao_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "update purchase set purchase_status = '결제완료', purchase_kakao_id = ?, purchase_date = now() where purchase_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, purchase_kakao_id);
			preparedStatement.setString(2, purchase_id);
			
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
	

	//-------------------------사용중	
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
		
	//---------------사용중
	
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
	
	
	
		
		
		
	public ArrayList<PaymentDto> payment(int purchase_id) {
		ArrayList<PaymentDto> dtos = new ArrayList<PaymentDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dateSource.getConnection();
			String query = "select cake_name, user_name, user_phone, user_email, user_address, user_address_detail, user_postcode, purchase_price, purchase_quantity from cake, user, purchase where cake_id =(select purchase_cake_id from purchase where purchase_id= ?) and user_id =(select purchase_user_id from purchase where purchase_id= ?) and purchase_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, purchase_id);
			preparedStatement.setInt(2, purchase_id);
			preparedStatement.setInt(3, purchase_id);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("dao");
			
			while(resultSet.next()) {
				int purchase_price = resultSet.getInt("purchase_price");
				int purchase_quantity = resultSet.getInt("purchase_quantity");
				String cake_name = resultSet.getString("cake_name");
				String user_name = resultSet.getString("user_name");
				String user_phone = resultSet.getString("user_phone");
				String user_email = resultSet.getString("user_email");
				String user_address = resultSet.getString("user_address");
				String user_address_detail = resultSet.getString("user_address_detail");
				String user_postcode = resultSet.getString("user_postcode");
				
				
				PaymentDto dto = new PaymentDto(purchase_price, purchase_quantity, cake_name, user_name, user_phone, user_address, user_address_detail, user_postcode, user_email);
				dtos.add(dto);
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
	} // payment()
		
		

		
		
	
	
	

}
