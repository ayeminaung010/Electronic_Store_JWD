package com.servlet.ai.services;

import java.util.List;

import com.ace.ai.web.Product;

import com.servlet.ai.repo.ProductRepo;

public class ProductService {
	public List<Product> findAll() {
		ProductRepo productRepo = new ProductRepo();
		List<Product> products = productRepo.findAll();
		return products;
	}

	public boolean addProduct(Product product) {
		ProductRepo productRepo = new ProductRepo();
		boolean status = productRepo.createProduct(product);
		if (status) {
			return true;
		}
		return false;
	}

	public void updateProduct(Product product) {
		ProductRepo productRepo = new ProductRepo();
		productRepo.updateProduct(product);
	}

	public void deleteProduct(int id) {
		ProductRepo productRepo = new ProductRepo();
		productRepo.deleteProduct(id);
	}

	public boolean checkModel(String model) {
		ProductRepo productRepo = new ProductRepo();
		boolean status = productRepo.checkModelName(model);
		if (status) {
			return true;
		}
		return false;
	}

	public boolean checkUpdateModel(String model,int id) {
		ProductRepo productRepo = new ProductRepo();
		Product product = productRepo.checkUpdateModel(model);
		if (product == null) {
			return false;
		} else {
			if(id == product.getId()) {
				return false;
			}
			return true;
		}
	}

}
