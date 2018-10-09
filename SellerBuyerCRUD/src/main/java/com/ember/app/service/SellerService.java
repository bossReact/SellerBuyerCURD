package com.ember.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.ember.app.model.Seller;

public interface SellerService {
	
	public long save(Seller seller);
	
	public long update(Seller seller);

	public void delete(long sellerId);
	
	public Seller getSeller(long sellerId);
	
	public List<Seller> getSelllerList();
	
	public boolean isExist(long sellerId);

	public Page<Seller> findAll(Specification<Seller> spec, Pageable page);
}
