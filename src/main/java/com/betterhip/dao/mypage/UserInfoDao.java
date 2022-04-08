package com.betterhip.dao.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserInfoDao {

	
//-------------------field--------------------- 
	
		DataSource dataSource; 	
	
//-------------------constructor----------------
		
		public UserInfoDao() {
			
			try {
				
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/betterhip");
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}	
		}
		
//------------------method---------------------  
		
		
		//회원 탈퇴 
		public void userInfoDelete(String USER_ID) {
			
			Connection connection = null; 
			PreparedStatement preparedStatement = null; 
			
			try {
				//탈퇴 시 user_leave date 현재 시각으로 업데이트 
				connection = dataSource.getConnection();
				String query = "update user set user_leavedate = now() where user_id = ?";
				preparedStatement = connection.prepareStatement(query); 
				preparedStatement.setString(1, USER_ID);
				
				preparedStatement.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
			
				}
			}		
			
		}//userInfoDelete()
		
		
		
		//회원 정보 수정 
		public void userInfoModify(String USER_ID, String new_user_pw, String user_name, String user_email, String user_phone, String user_postcode, String user_address, String user_address_detail) {
			
			Connection connection = null; 
			PreparedStatement preparedStatement = null; 
			
			try {
				//사용자가 수정 입력한 데이터로 디비 업데이트 
				connection = dataSource.getConnection();
				String query = "update user set user_pw = ?, user_name = ?, user_email = ?, user_phone = ?, user_postcode = ?, user_address = ?, user_address_detail = ? where user_id = ?";
				preparedStatement = connection.prepareStatement(query); 
				preparedStatement.setString(1, new_user_pw);
				preparedStatement.setString(2, user_name);				
				preparedStatement.setString(3, user_email);
				preparedStatement.setString(4, user_phone);
				preparedStatement.setString(5, user_postcode);
				preparedStatement.setString(6, user_address);
				preparedStatement.setString(7, user_address_detail);
				preparedStatement.setString(8, USER_ID);
				
				preparedStatement.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
		
			}finally {
				try {
					
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
			
				}
			}		
			
			
		}//userInfoModify
		
	
}//usInfoDao 
