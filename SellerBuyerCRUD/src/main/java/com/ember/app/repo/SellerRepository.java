package com.ember.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ember.app.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>,JpaSpecificationExecutor<Seller> {

}
