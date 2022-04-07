package com.betterhip.dao.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class LoginDao {
	
	DataSource dataSource;
	
	public LoginDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/betterhip");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 로그인시 아이디, 비밀번호 확인 메서드
	// 아이디, 비밀번호 확인하여 리턴값 전달
	// 탈퇴회원은 아이디만 확인하고 리턴
	//  2 : 인증성공
	//  1 : 아이디 틀림
	// -1 : 비밀번호 틀림
	// -2 : 탈퇴회원
	//  0 : DB 연결안됨
	// -3 : 카카오를 사용하여 가입하지 않음
	
	public int Login(String user_id, String user_pw, String loginMethod) {
		
		int result = 0; 			// 아이디, 비밀번호 확인결과 리턴
		String dbPassword = "";     // 해당 아이디로 DB에서 받은 패스워드
		String dbLeaveDate = "";    // 해당 아이디로 DB에서 받은 탈퇴일


		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;		
		
		try {		
			// 카카오 로그인
			if(loginMethod.equals("kakao")) {
				connection = dataSource.getConnection();		
				String query = "select count(user_id) from user where user_id = '" + user_id + "'";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
			
				if(resultSet.next()) {
					if(resultSet.getInt(1) > 0) {
						result = 2;
					}else {
						result = -3;
					}
				}
			}else {
			// 일반 로그인						
				// 입력한 아이디로 비밀번호 조회	
				connection = dataSource.getConnection();
				String query = "select * from user where user_id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, user_id);
				resultSet = preparedStatement.executeQuery();
				
				
				if(resultSet.next()) {  // 입력한 아이디의 비밀번호가 있을 경우
					dbPassword = resultSet.getString("user_pw"); // DB에서 받은 비밀번호
					dbLeaveDate = resultSet.getString("user_leavedate");
					
					if(dbLeaveDate == null) { 
						// 탈퇴회원이 아닌경우
						
						// 비밀번호가 맞으면
						if(dbPassword.equals(user_pw)) {
							// 인증성공
							result = 2; 						
						}else {
							// 비밀번호가 틀리면
							result = -1; 
						}									
					}else { 
						// 탈퇴회원 - 비밀번호 확인하지 않음
						result = -2;				}
				}else { 
					// 해당 아이디가 없는 경우
					result =  1;				
				}
			} // 일반 로그인
		}catch (Exception e) {
			return 0; // DB 연결실패
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		} // Login - try
		
		return result;
		
	} // Login

} // LoginDao
