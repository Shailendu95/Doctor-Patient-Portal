package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;

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
				String sql = "insert into user_details(full_name, email, password) values(?,?,?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getFullName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPassword());

				pstmt.executeUpdate();

				f = true; // if query execute successfully then f becomes true otherwise false...

			} catch (Exception e) {
				e.printStackTrace();

			}

			return f;
		}

}
