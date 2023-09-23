package com.servlet.ai.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ace.ai.web.Product;

public class ProductRepo extends BaseRepo {
	public List<Product> findAll() {
		try {
			Connection conn = getConnection();

			List<Product> products = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("select p.id,m.name,p.model,p.maker_id from products p \r\n"
					+ "INNER JOIN make m  ON p.maker_id=m.id;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setMake(rs.getString(2));
				p.setModel(rs.getString(3));
				p.setMaker_id(rs.getInt(4));
				products.add(p);
			}
			return products;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public boolean createProduct(Product product) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into products (maker_id,model) values(?,?);");

			ps.setInt(1, product.getMaker_id());
			ps.setString(2, product.getModel());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public void updateProduct(Product product) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("update products set maker_id = ? ,model = ? where id = ?;");
			ps.setInt(1, product.getMaker_id());
			ps.setString(2, product.getModel());
			ps.setInt(3, product.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteProduct(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("Delete from products where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean checkModelName(String model) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from products where model = ?");

			ps.setString(1, model);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public Product checkUpdateModel(String model) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from products where model = ?");

			ps.setString(1, model);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setMaker_id(rs.getInt(2));
				p.setModel(rs.getString(3));

				return p;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
