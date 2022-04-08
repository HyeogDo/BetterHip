package com.betterhip.dao.order;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.betterhip.dto.order.CakeListDto;



public class CakeListDao {
	
	//datasource 불러오기
	DataSource dataSource;
	
	//생성자
	public CakeListDao() {
		// TODO Auto-generated constructor stub
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/betterhip");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<CakeListDto> list(int start, int len, String order) {
		
		ArrayList<CakeListDto> dtos = new ArrayList<CakeListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select cake_id, cake_name, cake_saleprice, cake_status, cake_img from cake order by ? limit ?, ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, order);
			preparedStatement.setInt(2, start);
			preparedStatement.setInt(3, len);
			
			preparedStatement.executeUpdate();
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int cake_id = resultSet.getInt("cake_id");
				String cake_name = resultSet.getString("cake_name");
				int cake_saleprice = resultSet.getInt("cake_saleprice");
				String cake_status = resultSet.getString("cake_status");
				Blob cake_img = resultSet.getBlob("cake_img");
				
				// blob 파일 내용 -> bytes
				InputStream inputStream = cake_img.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				
				byte[] imageBytes = outputStream.toByteArray();
				
				//바이트 -> 문자열
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				
				inputStream.close();
				outputStream.close();
				
				CakeListDto cakeListDto = new CakeListDto(cake_id, cake_name, cake_saleprice, cake_status, base64Image);
				dtos.add(cakeListDto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return dtos;
	}
	
	//데이터 row 개수 구하는 함수
	public int getTotalRows() {
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(cake_id) from cake";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				count = resultSet.getInt("count(cake_id)");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return count;
		
	}
}
 
















