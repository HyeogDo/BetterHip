package com.betterhip.dao.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CartDeleteDao {
	
		DataSource dataSource;
	
	// Constructor
		public CartDeleteDao() {
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/betterhip");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	
		public String cartDelete(String[] deleteList) {
			String deleteResult = null;
					
			Connection connection = null;		
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				
				String query = "delete from purchase where ";
				for(int i=0; i<deleteList.length; i++ ) {
					query += "purchase_id = " + deleteList[i];
					if(i < (deleteList.length -1)) {
						query += " or ";
					}
				}
				System.out.println("query : " + query);
				connection = dataSource.getConnection();
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				deleteResult = "success";
			
			}catch (Exception e) {
				e.printStackTrace();
				deleteResult = "fail";
			}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
					deleteResult = "fail";
				}
			}
			
			return deleteResult;
		} // cartDelete

} // CartDeleteDao