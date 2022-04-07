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
		
		try {
			String query = "select p.purchase_id, p.purchase_quantity, p.purchase_price, c.cake_name, "
					+ "c.cake_img, p.purchase_text, o.customize_size, o.customize_taste, o.customize_cream_type, o.customize_cream_color "
					+ "from purchase p, cake c, customize o " 
					+ "where p.purchase_cake_id = c.cake_id and p.purchase_customize_id = o.customize_id "
					+ " and p.purchase_user_id = ?";
		
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			resultSet = preparedStatement.executeQuery();
		
			
			while(resultSet.next()) {
				int purchase_id = resultSet.getInt("purchase_id");
				int purchase_quantity = resultSet.getInt("purchase_quantity");
				int purchase_price = resultSet.getInt("purchase_price");
				String purchase_custom_size = resultSet.getString("customize_size");
				String Pruchase_custom_taste = resultSet.getString("customize_taste");
				String purchase_custom_cream_type = resultSet.getString("customize_cream_type");
				String purchase_custom_cream_color = resultSet.getString("customize_cream_color");
				String purchase_text = resultSet.getString("purchase_text");
				String purchase_cake_name = resultSet.getString("cake_name");
				Blob purchase_cake_img = resultSet.getBlob("cake_img");
				
				CartListDto dto = new CartListDto(purchase_id, purchase_quantity, purchase_price, 
												purchase_custom_size, Pruchase_custom_taste, purchase_custom_cream_type, 
												purchase_custom_cream_color, purchase_text, purchase_cake_name, purchase_cake_img);
				dtos.add(dto);		
				
			} // while;
		
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception");
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		return dtos;
	} // cartList

} // CartListDao
