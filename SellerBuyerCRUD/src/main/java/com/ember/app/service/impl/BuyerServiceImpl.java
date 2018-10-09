package com.ember.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ember.app.model.Buyer;
import com.ember.app.repo.BuyerRepository;
import com.ember.app.service.BuyerService;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerRepository repo;
	
	@Override
	public void delete(long buyerId) {
		repo.deleteById(buyerId);
	}

	@Override
	public Buyer getBuyer(long buyerId) {
		return repo.getOne(buyerId);
	}

	@Override
	public List<Buyer> getBuyerList() {
		return repo.findAll();
	}

	@Override
	public long save(Buyer buyer) {
		long id=0;
		if(buyer!=null){
			try{
			id=repo.save(buyer).getId();
			}catch(Exception e){
			id=0;
			}
		}
		return id;
	}

	@Override
	public long update(Buyer buyer) {
		long id=0;
		if(buyer!=null){
			try{
			id=repo.save(buyer).getId();
			}catch(Exception e){
			id=0;
			}
		}
		return id;
	
	}

	@Override
	public boolean isExist(long buyerId) {
		return repo.existsById(buyerId);
	}


}
