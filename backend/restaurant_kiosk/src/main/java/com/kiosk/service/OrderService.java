package com.kiosk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kiosk.dao.OrderDao;
import com.kiosk.model.Order;

@Service
public class OrderService {
	
	private OrderDao orderDao;
	
	@Autowired
	public OrderService(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	
	
	public Order insertOrder(Order order) {
		Order newOrder = orderDao.save(order);
		return newOrder;
	}
	
	public List<Order> getAllOrders(){
//		System.out.println("inside get all order in orderservice");
		List<Order> orderList = new ArrayList<>();
		orderList = orderDao.findAll();
//		System.out.println("this ist he full order list: \n    "+orderList);
		return orderList;
	}
	
	public Order getOrderById(long id) {
//		System.out.println("orderService, id being searched: "+id);
		Order order;
		order = orderDao.findByOrderId(id);
//		System.out.println("orderService, order found: "+order);
		return order;
	}
	
	public void removeOrder(Order order) {
		orderDao.delete(order);
	}

}
