package com.betterhip.dao.signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.betterhip.dto.signup.SignupCheckIdDto;
import com.betterhip.dto.signup.SignupCheckPhoneDto;

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
	public void signup(String user_id, int user_pw, String user_name, String user_email, String user_phone, String user_postcode, String user_address, String user_address_detail, boolean user_marketing) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			
			//데이터베이스 입력문
			String query = "insert into user(user_id, user_pw, user_name, user_email, user_phone, user_postcode, user_address, user_address_detail, user_marketing, user_joindate) values(?,?,?,?,?,?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			
			//입력문 안에 들어갈 변수 설정
			preparedStatement.setString(1, user_id);
			preparedStatement.setInt(2, user_pw);
			preparedStatement.setString(3, user_name);
			preparedStatement.setString(4, user_email);
			preparedStatement.setString(5, user_phone);
			preparedStatement.setString(6, user_postcode);
			preparedStatement.setString(7, user_address);
			preparedStatement.setString(8, user_address_detail);
			preparedStatement.setBoolean(9, user_marketing);
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
	
	public SignupCheckPhoneDto signupCheckPhone(String user_phone) {
		SignupCheckPhoneDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			//데이터베이스 입력문
			String query = "select user_phone from user where user_phone=?";
			preparedStatement = connection.prepareStatement(query);
			//입력문 안에 들어갈 변수 설정
			preparedStatement.setString(1, user_phone);
			System.out.println(user_phone);
			
			resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next()) {
				user_phone = null;
			}
			
			dto = new SignupCheckPhoneDto(user_phone);
			
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
