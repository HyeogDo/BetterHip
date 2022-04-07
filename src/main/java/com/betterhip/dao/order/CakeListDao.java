package com.betterhip.dao.order;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public ArrayList<CakeListDto> list() {
		
		ArrayList<CakeListDto> dtos = new ArrayList<CakeListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select cake_id, cake_name, cake_saleprice, cake_status, cake_img from cake";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int cake_id = resultSet.getInt("cake_id");
				String cake_name = resultSet.getString("cake_name");
				int cake_saleprice = resultSet.getInt("cake_saleprice");
				String cake_status = resultSet.getString("cake_status");
				Blob cake_img = resultSet.getBlob("cake_img");
				
				CakeListDto cakeListDto = new CakeListDto(cake_id, cake_name, cake_saleprice, cake_status, cake_img);
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
}
