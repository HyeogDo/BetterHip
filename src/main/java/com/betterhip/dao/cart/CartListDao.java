package com.betterhip.dao.cart;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.betterhip.dto.cart.CartListDto;

public class CartListDao {
	
	DataSource dataSource;
	
	// Constructor
	public CartListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/betterhip");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method - 실패시 메세지 처리 확인필요
	public ArrayList<CartListDto> cartList(String user_id) {
		ArrayList<CartListDto> dtos = new ArrayList<CartListDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;	
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		
		try {
			String query = "select * from purchase where purchase_user_id = '" + user_id + "'";
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				// purchase table
				int purchase_id = resultSet.getInt("purchase_id");
				int purchase_cake_id = resultSet.getInt("purchase_cake_id");
				int purchase_customize_id = resultSet.getInt("purchase_customize_id");
				int purchase_price = resultSet.getInt("purchase_price");
				int purchase_quantity = resultSet.getInt("purchase_quantity");
				String purchase_text = resultSet.getString("purchase_text");
				String purchase_cake_name = null;
				String purchase_custom = null;
				Blob purchase_img = null;
				
				// cake table
				String query2 = "select (cake_name, cake_img) from cake where cake_id = " + purchase_cake_id;
				preparedStatement = connection.prepareStatement(query2);
				resultSet2 = preparedStatement.executeQuery();
				
				if(resultSet2.next()) {
					purchase_cake_name = resultSet2.getString("cake_name");
					purchase_img = resultSet.getBlob("cake_img");
				}
				
				// customize table
				String query3 = "select * from customize where customize_id = " + purchase_customize_id;
				preparedStatement = connection.prepareStatement(query3);
				resultSet3 = preparedStatement.executeQuery();
				
				if(resultSet3.next()) {
					purchase_custom = resultSet3.getString("customize_taste") + resultSet3.getString("customize_size") +
							resultSet3.getString("customize_cream_type") + resultSet3.getString("customize_cream_color");  
				}
				
				CartListDto dto = new CartListDto(purchase_id, purchase_cake_name, purchase_img, purchase_custom, purchase_text, purchase_text, purchase_custom);
				dtos.add(dto);
				
			} // while;
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet3 != null) resultSet3.close();
				if(resultSet2 != null) resultSet2.close();
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		return dtos;
	} // cartList

}
