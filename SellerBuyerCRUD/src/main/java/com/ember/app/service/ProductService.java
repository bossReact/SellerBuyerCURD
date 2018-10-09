package com.ember.app.service;

import java.util.List;
import com.ember.app.model.Product;
/**
 * 
 * @author saurabh
 *
 */
public interface ProductService {
	public Long save(Product product);
	public void update(Product product);
	public void delete(Long productId);
	public Product getOne(Long productId);
	public List<Product> getAll();
	public boolean isExist(Long productId);
	
	public List<Product> findItemsByVendor(Long sellerId);
}
