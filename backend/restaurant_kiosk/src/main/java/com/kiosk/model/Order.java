package com.kiosk.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//note: can't have a SQL table named "order" because that is in fact a keyword in SQL and so it causes errors. 
//		that was a headache to figure out but in retrospect that should have been obvious haha.
@Entity
@Table(name="food_order")
public class Order {

	//=================================Fields=============================================
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id", unique=true, nullable=false)
	private long orderId;
	
	
	@Column(name="order_total_before_tax")
	private double orderTotalBeforeTax;
	
	@Column(name="order_tax")
	private double orderTax;
	
	@Column(name="order_total_after_tax")
	private double orderTotalAfterTax;

    @ManyToMany
    @JoinTable
	private List<Food> orderItems;
	
	
	//=============================Constructor(s)=========================================
	
	
	public Order() {
		
	}

	
	public Order(List<Food> orderItems, double orderTotalBeforeTax, double orderTax, double orderTotalAfterTax) {
		super();
		this.orderItems = orderItems;
		this.orderTotalBeforeTax = orderTotalBeforeTax;
		this.orderTax = orderTax;
		this.orderTotalAfterTax = orderTotalAfterTax;
	}
	

	//=============================Getters/setters========================================
	

	public long getOrderId() {
		return this.orderId;
	}
	
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	
	public double getOrderTotalBeforeTax() {
		return orderTotalBeforeTax;
	}
	
	
	public void setOrderTotalBeforeTax(double orderTotalBeforeTax) {
		this.orderTotalBeforeTax = orderTotalBeforeTax;
	}
	
	
	public double getOrderTax() {
		return orderTax;
	}
	
	
	public void setOrderTax(double orderTax) {
		this.orderTax = orderTax;
	}
	
	
	public double getOrderTotalAfterTax() {
		return orderTotalAfterTax;
	}
	
	
	public void setOrderTotalAfterTax(double orderTotalAfterTax) {
		this.orderTotalAfterTax = orderTotalAfterTax;
	}
	
	
	public List<Food> getOrderItems() {
		return orderItems;
	}
	
	
	public void setOrderItems(List<Food> orderItems) {
		this.orderItems = orderItems;
	}

	
	//==============================toString override===============================
	
	
	@Override
	public String toString() {
		return "Order [OrderId=" + orderId + ", orderTotalBeforeTax=" + orderTotalBeforeTax + ", orderTax=" + orderTax
				+ ", orderTotalAfterTax=" + orderTotalAfterTax + ", orderItems=" + orderItems + "]";
	}
	
}
