package net.mharoon.chefawsapp.model;

public class Order {
	Long id;
	int quantity;
	Double price;
	Long productId;
	
	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Order(Long id, int quantity, Double price, Long productId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.productId = productId;
	}
	
	

}
