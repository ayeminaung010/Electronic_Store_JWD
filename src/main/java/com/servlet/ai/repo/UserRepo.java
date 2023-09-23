package com.servlet.ai.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ace.ai.web.User;

public class UserRepo extends BaseRepo {

	public User findUserByEmail(String email) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user where email = ?");

			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPhoneNumber(rs.getString(5));
				return user;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public User findUserById(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPhoneNumber(rs.getString(5));
				return user;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public List<User> findAll() {
		try {
			Connection conn = getConnection();

			List<User> users = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("select * from user");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPhoneNumber(rs.getString(5));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public boolean createUser(User user) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("insert into user (name,password,email,phone_number) values (?,?,?,?);");

			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhoneNumber());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public void updateUser(User user) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update user set phone_number = ? , name = ? , email = ? where id = ?;");
			ps.setString(1, user.getPhoneNumber());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteUser(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("Delete from user where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void ChangePassword(int id, String newPassword) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("update user set password = ? where id = ?;");
			ps.setString(1, newPassword);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
