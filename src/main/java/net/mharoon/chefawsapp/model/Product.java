package net.mharoon.chefawsapp.model;

public class Product {
	Long id;
	Long code;
	String name;
	String description;
	double cost;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Product(Long id, Long code, String name, String description, double cost) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}



}
