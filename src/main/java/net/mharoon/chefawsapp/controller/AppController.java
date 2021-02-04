package net.mharoon.chefawsapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.mharoon.chefawsapp.model.Order;
import net.mharoon.chefawsapp.model.Product;

@RestController
@RequestMapping("/api")
public class AppController {

	private List<Product> productList() {
		List<Product> list = new ArrayList<Product>(); 
		list.add(new Product(1L, 100L ,"Apples","Honey Crisp Apples", 0.20));
		list.add(new Product(2L, 101L ,"Oranges","Florida Oranges", 0.30));
		list.add(new Product(3L, 103L ,"Pears","California Pears", 0.15));
		return list;
	}
	
	private List<Order> orderList(){
		List<Order> orderList = new ArrayList<Order>();
		List<Product> l = productList();
		double margin = 0.20; // 20%
		for (int i = 0; i < l.size(); i++) {
			Product p = l.get(i);
			Random r = new Random();
			int x = r.nextInt(10);
			Order o = new Order(new Long(i+1),x,(x*margin*p.getCost()) ,p.getId());
			orderList.add(o);
		}
		return orderList;
	}
	
	@GetMapping("/products")
	public List<Product> products(){
		List<Product> l = productList();
		return l;			
	}
	
	@PostMapping("/products")
	public ResponseEntity<List<Product>> addProduct(@RequestBody Product p) {
		List<Product> l = productList();
		l.add(p);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<List<Product>> deleteProduct(@PathVariable Long id) {
		List<Product> l = productList();
		boolean isRemoved = false;
		List<Product> filtered = l.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
		if (filtered.size() == 1) {
			isRemoved =  true;
			l.remove(filtered.get(0));
		}
	    if (!isRemoved) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public List<Order> orders(){
		List<Order> orders = orderList();
		return orders;
	}
	
	@PostMapping("/orders")
	public ResponseEntity<List<Order>> addOrder(@RequestBody Order o) {
		List<Order> list = orderList();
		list.add(o);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<List<Order>> deleteOrder(@PathVariable Long id) {
		List<Order> list = orderList();
		List<Order> filtered = list.stream().filter(o -> o.getId()==id).collect(Collectors.toList());
		if (filtered.size() == 1) {
			list.remove(filtered.get(0));
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
	}
	
	
}
