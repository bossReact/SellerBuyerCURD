package com.ember.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 
 * @author saurabh
 *
 */
@Entity
@Table(name="ORDER_ITEM",uniqueConstraints=@UniqueConstraint(columnNames="PRODUCT_ID"))
public class OrderItem {
	
	private long id;
	private long quantity;
	
	private Order order;
	private Product product;
	
	public OrderItem(){
		
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ORDER_ID")
	@JsonIgnore
	public Order getOrder() {
		return order;
	}
	
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_ID")
	@JsonIgnore
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name="QUANTITY")
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	

}
