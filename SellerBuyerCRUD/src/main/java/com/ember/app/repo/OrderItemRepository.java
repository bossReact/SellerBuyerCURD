package com.ember.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ember.app.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
