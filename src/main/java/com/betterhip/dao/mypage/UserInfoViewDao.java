package com.betterhip.dao.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.betterhip.dto.mypage.UserInfoDto;

public class UserInfoViewDao {

	
	//field 
	
	
	DataSource dataSource; 	

	//constructor 
	
	public UserInfoViewDao() {
		
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/betterhip");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
	
	//method 
	
	public UserInfoDto userInfoView(String USER_ID){
		
		
		UserInfoDto dto = null;
		
		Connection connection = null; 
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null; 

		try {
			connection = dataSource.getConnection();
			String query = "select user_id, user_pw, user_name, user_phone, user_email, user_postcode, user_address, user_address_detail from user where user_id = ?";
			preparedStatement = connection.prepareStatement(query); 
			preparedStatement.setString(1, USER_ID);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String user_id = resultSet.getString("user_id");
				String user_pw = resultSet.getString("user_pw"); 
				String user_name = resultSet.getString("user_name"); 
				String user_phone = resultSet.getString("user_phone"); 
				String user_email = resultSet.getString("user_email"); 
				String user_postcode = resultSet.getString("user_postcode"); 
				String user_address = resultSet.getString("user_address"); 
				String user_address_detail = resultSet.getString("user_address_detail");
				
				
				dto = new UserInfoDto(user_id, user_pw, user_name, user_phone, user_email, user_postcode, user_address, user_address_detail);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		//메모리 정리 해주는 게 좋기 때문에 finally 필요 
		}finally {
			try {
				//보통 연 순서의 역으로 닫음 
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
		
			}
		}
		
		return dto;
		
		
		
	}//userinfoview()
	
	
	
}//dao 
