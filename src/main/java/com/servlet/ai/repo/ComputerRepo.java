package com.servlet.ai.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ace.ai.web.Computer;

public class ComputerRepo extends BaseRepo {
	public List<Computer> findAll() {
		try {
			Connection conn = getConnection();

			List<Computer> computers = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(
					"select c.*,p.model,m.name as makeName,tc.name as computerType from computer c\r\n"
							+ "INNER JOIN products p  ON p.id=c.product_id\r\n"
							+ "INNER JOIN make m  ON p.maker_id=m.id\r\n"
							+ "INNER JOIN type_computer tc  ON c.type_computer_id=tc.id;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Computer computer = new Computer();
				computer.setId(rs.getInt(1));
				computer.setProduct_id(rs.getInt(2));
				computer.setType_computer_id(rs.getInt(3));
				computer.setSpeed(rs.getString(4));
				computer.setRam(rs.getString(5));
				computer.setHd(rs.getString(6));
				computer.setPrice(rs.getString(7));
				computer.setModelName(rs.getString(8));
				computer.setMakeName(rs.getString(9));
				computer.setComputer_type(rs.getString(10));
				computers.add(computer);
			}
			return computers;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public boolean createComputer(Computer computer) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"insert into computer (product_id,type_computer_id,speed,ram,hd,price) values (?,?,?,?,?,?);");
			ps.setInt(1, computer.getProduct_id());
			ps.setInt(2, computer.getType_computer_id());
			ps.setString(3, computer.getSpeed());
			ps.setString(4, computer.getRam());
			ps.setString(5, computer.getHd());
			ps.setDouble(6, Double.parseDouble(computer.getPrice()));

			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public void updateComputer(Computer computer) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"update computer set product_id = ? ,type_computer_id = ? , speed = ? ,ram = ? ,hd = ? , price=? where id = ?;");

			ps.setInt(1, computer.getProduct_id());
			ps.setInt(2, computer.getType_computer_id());
			ps.setString(3, computer.getSpeed());
			ps.setString(4, computer.getRam());
			ps.setString(5, computer.getHd());
			ps.setString(6, computer.getPrice());
			ps.setInt(7, computer.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteComputer(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("Delete from computer where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
