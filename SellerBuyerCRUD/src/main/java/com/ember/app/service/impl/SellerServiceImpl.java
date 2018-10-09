package com.ember.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ember.app.model.Seller;
import com.ember.app.repo.SellerRepository;
import com.ember.app.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository repo;
	
	@Override
	public void delete(long sellerId) {
		repo.deleteById(sellerId);
	}

	@Override
	public Seller getSeller(long sellerId) {
		return repo.getOne(sellerId);
	}

	@Override
	public List<Seller> getSelllerList() {
		return repo.findAll();
	}

	@Override
	public long save(Seller seller) {
		long id=0;
		if(seller!=null){
			try{
			id=repo.save(seller).getId();
			}catch(Exception e){
			id=0;
			}
		}
		return id;
	}

	@Override
	public long update(Seller seller) {
		long id=0;
		if(seller!=null){
			try{
			id=repo.save(seller).getId();
			}catch(Exception e){
			id=0;
			}
		}
		return id;
	
	}

	@Override
	public Page<Seller> findAll(Specification<Seller> spec, Pageable page) {
			 	return repo.findAll(spec,page);
	}

	@Override
	public boolean isExist(long sellerId) {
		return repo.existsById(sellerId);
	}

}
