package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

	public class UserDao  {

		private Connection conn;

		public UserDao(Connection conn) {
			super();
			this.conn = conn;
		}

		public boolean userRegister(User user) {

			boolean f = false;

			try {
				// insert user in db
				String sql = "insert into users(full_name, email, password) values(?,?,?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getFullName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPassword());

				int i=pstmt.executeUpdate();

				if(i==1)
				{
				f = true;
				} // if query execute successfully then f becomes true otherwise false...

			} catch (Exception e) {
				e.printStackTrace();

			}

			return f;
		}
		
		public User loginUser(String email, String password) {

			User user = null;

			try {
				String sql = "select * from user_dtls where email=? and password=?";

				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, password);

				ResultSet resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
					// if any row available, then fetch the data of that row...

					// create new user object
					user = new User();

					// fetch data one by one from db table and set it/bind it to user's objects.
					// e.g fetch id and set to user object
					// user.setId(resultSet.getInt(1));or below line both are same
					// (1) means db table colm index number 1 which is id
					// getString() takes both column indexNumber or columnLabel name...
					user.setId(resultSet.getInt("id"));
					user.setFullName(resultSet.getString("full_name"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return user;

		}

}
