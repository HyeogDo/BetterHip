package com.betterhip.dao.cart;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CartOrderDao {
	
	DataSource dataSource;
	
	// Constructor
	public CartOrderDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/betterhip");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String cartOrder(String[] orderList) {
		
		String orderResult = null;
		
		Connection connection = null;		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			String query = "update purchase set purchase_status = 2 where ";
			for(int i=0; i<orderList.length; i++ ) {
				query += "purchase_id = " + orderList[i];
				if(i < (orderList.length -1)) {
					query += " or ";
				}
			}
			System.out.println("query : " + query);
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			orderResult = "success";
		
		}catch (Exception e) {
			e.printStackTrace();
			orderResult = "fail";
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
				orderResult = "fail";
			}
		}
		
		return orderResult;
	} // cartOrder

} // CartOrderDao