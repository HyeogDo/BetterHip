package com.betterhip.dao.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserInfoDao {

	
	
	//field 
	
	
		DataSource dataSource; 	
		
	
	//constructor 
		
		public UserInfoDao() {
			
			try {
				
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/betterhip");
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}	
		}
		
		
	//method 
		
		
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
				
				//오류메세지 출력 
			} catch (Exception e) {
				e.printStackTrace();
			//메모리 정리 해주는 게 좋기 때문에 finally 필요 
			}finally {
				try {
					//보통 연 순서의 역으로 닫음 
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
			
				}
			}		
			
		}//userInfoDelete()
		
	
}//userinfoDao 
