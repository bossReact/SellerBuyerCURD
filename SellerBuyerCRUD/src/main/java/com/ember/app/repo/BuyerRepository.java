package com.ember.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ember.app.model.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

}
