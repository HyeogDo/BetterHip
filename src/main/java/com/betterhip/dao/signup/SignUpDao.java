package com.betterhip.dao.signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.betterhip.dto.signupCheckIdDto.SignupCheckIdDto;

public class SignUpDao {
	
	//datasource 불러오기
	DataSource dataSource;
	
	//생성자
	public SignUpDao() {
		// TODO Auto-generated constructor stub
		
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/betterhip");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//데이터베이스에 입력하는 함수
	public void signup(String user_id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			
			//데이터베이스 입력문
			String query = "insert into user(user_id) values(?)";
			preparedStatement = connection.prepareStatement(query);
			
			//입력문 안에 들어갈 변수 설정
			preparedStatement.setString(1, user_id);
			System.out.println(user_id);
			
			//입력 업데이트
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// 닫아주기
			try {
				if (preparedStatement != null) preparedStatement.close();
				if (connection != null) connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public SignupCheckIdDto signupCheckId(String user_id) {
		SignupCheckIdDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			//데이터베이스 입력문
			String query = "select user_id from user where user_id=?";
			preparedStatement = connection.prepareStatement(query);
			//입력문 안에 들어갈 변수 설정
			preparedStatement.setString(1, user_id);
			System.out.println(user_id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next()) {
				user_id = null;
			}
			
			dto = new SignupCheckIdDto(user_id);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// 닫아주기
			try {
				if (resultSet != null) resultSet.close();
				if (preparedStatement != null) preparedStatement.close();
				if (connection != null) connection.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	
	
}
