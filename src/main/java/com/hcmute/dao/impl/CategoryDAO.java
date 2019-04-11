package com.hcmute.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hcmute.dao.ICategoryDAO;
import com.hcmute.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/mini";
			String userName = "root";
			String password = "root";
			return DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> results = new ArrayList<CategoryModel>();
		String sql = "select * from category";
		// open connection
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				// init parameter if have where in sql
				// execute
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					CategoryModel categoryModel = new CategoryModel();
					categoryModel.setId(resultSet.getLong("id"));
					categoryModel.setCode(resultSet.getString("name"));
					results.add(categoryModel);
				}
				return results;
				
			} catch (Exception e) {
				return null;
			} finally {
				try {
					if(connection != null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close();
					}
				} catch (Exception e2) {
					return null;
				}
			}
		}
		return null;
	}

}
