package com.ember.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ember.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
