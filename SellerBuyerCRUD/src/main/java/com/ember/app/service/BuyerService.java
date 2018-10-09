package com.ember.app.service;

import java.util.List;
import com.ember.app.model.Buyer;

public interface BuyerService {
	
	public long save(Buyer buyer);
	
	public long update(Buyer buyer);

	public void delete(long buyerId);
	
	public Buyer getBuyer(long buyerId);
	
	public List<Buyer> getBuyerList();
	
	public boolean isExist(long buyerId);
	

}
