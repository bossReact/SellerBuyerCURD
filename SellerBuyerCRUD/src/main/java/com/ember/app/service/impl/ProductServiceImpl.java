package com.ember.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ember.app.model.Product;
import com.ember.app.repo.ProductRepository;
import com.ember.app.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repo;
	
	@Override
	public Long save(Product product) {
		return repo.save(product).getId();
	}

	@Override
	public void update(Product product) {
		repo.save(product);
	}

	@Override
	public void delete(Long productId) {
		repo.deleteById(productId);
	}

	@Override
	public Product getOne(Long productId) {
		return repo.getOne(productId);
	}

	@Override
	public List<Product> getAll() {
		return repo.findAll();
	}

	@Override
	public List<Product> findItemsByVendor(Long sellerId) {
		return null;
	}

	@Override
	public boolean isExist(Long productId) {
		return repo.existsById(productId);
	}

}
