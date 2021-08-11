package com.kiosk.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiosk.model.Order;
import com.kiosk.service.OrderService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@CrossOrigin("*")
	@GetMapping("/single")
	@RolesAllowed({"kiosk-admin"})
	@ResponseBody
	public Order get(@RequestParam long id) {
//		System.out.println("requesting single order by the id of: "+id);
		return orderService.getOrderById(id);
	}
	
	@GetMapping("/all")
	@RolesAllowed({"kiosk-admin"})
	@ResponseBody
	public List<Order> getAllOrders(){
		System.out.println("inside get all  odrdercontroller");
		return orderService.getAllOrders();
	}
	
	@PostMapping("/new")
	@RolesAllowed({"kiosk-terminal","kiosk-admin"})
	@ResponseBody
	public Order insertEvent(@RequestBody Order order) {
//		System.out.println("inside orderController, trying to create new order|||||||||||||||||||||||||||||||||||||||||||||||||||");
		Order insertedOrder;
		insertedOrder = orderService.insertOrder(order);
		return insertedOrder;
	}
	
	@DeleteMapping("/remove")
	@RolesAllowed({"kiosk-admin"})
	@ResponseBody
	public void deleteOrder(@RequestBody Order order) {
		orderService.removeOrder(order);;
	}
	
	
	
}
