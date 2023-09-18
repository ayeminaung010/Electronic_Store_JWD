package com.servlet.ai.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ace.ai.web.Make;


public class MakeRepo extends BaseRepo {
	public List<Make> findAll() {
		try {
			Connection conn = getConnection();

			List<Make> makes = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("select * from make;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Make m = new Make();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				makes.add(m);
			}
			return makes;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
