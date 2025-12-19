package com.jsp.restapiwithvalidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Bottle {

	@Id
	@NotNull(message = "id can not be null")
	int id;
	@NotBlank(message = "color can not be blank")
	String color;
	@Min(value = 30, message = "price should be greater than 30")
	double price;
	public Bottle(int id, String color, double price) {
		super();
		this.id = id;
		this.color = color;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Bottle() {
	}

}
