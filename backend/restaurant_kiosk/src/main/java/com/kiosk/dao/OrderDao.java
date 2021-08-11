package com.kiosk.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.kiosk.model.Order;

@Transactional
@Repository("orderDao")
public interface OrderDao extends CrudRepository<Order,Long>{
	
	// insert method
	public Order save(Order order);
	
	// find all orders
	public List<Order> findAll();
	
	// find by food ID
	public Order findByOrderId(long id);
	
	// update uses same as save
	
	// remove the list
	public void delete(Order order);

}
