package com.servlet.ai.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ace.ai.web.Printer;

public class PrinterRepo extends BaseRepo {
	public List<Printer> findAll() {
		try {
			Connection conn = getConnection();

			List<Printer> printers = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("select printer.*,products.model,make.name from printer \r\n"
					+ "INNER JOIN products  ON products.id=printer.product_id\r\n"
					+ "INNER JOIN make   ON products.maker_id=make.id;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Printer p = new Printer();
				p.setId(rs.getInt(1));
				p.setProduct_id(rs.getInt(2));
				p.setColor(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setModelName(rs.getString(5));
				p.setMakeName(rs.getString(6));
				printers.add(p);
			}
			return printers;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	

	public boolean createPrinter(Printer printer) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into printer (product_id,color,price) values(?,?,?);");

			ps.setInt(1, printer.getProduct_id());
			ps.setString(2, printer.getColor());
			ps.setDouble(3, printer.getPrice());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	public void updatePrinter(Printer printer) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("update printer set product_id = ? ,color = ? , price = ? where id = ?;");
			System.out.println(printer.getProduct_id() +  printer.getColor() + printer.getPrice() + printer.getId() );
			ps.setInt(1, printer.getProduct_id());
			ps.setString(2, printer.getColor());
			ps.setDouble(3, printer.getPrice());
			ps.setInt(4, printer.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void deletePrinter(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("Delete from printer where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
}
