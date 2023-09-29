package com.servlet.ai.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ace.ai.web.TypeComputer;

public class TypeComputerRepo extends BaseRepo {
	public List<TypeComputer> findAll() {
		try {
			Connection conn = getConnection();

			List<TypeComputer> typeComputers = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("select * from type_computer;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TypeComputer typeComputer = new TypeComputer();
				typeComputer.setId(rs.getInt(1));
				typeComputer.setName(rs.getString(2));
				typeComputers.add(typeComputer);
			}
			return typeComputers;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
