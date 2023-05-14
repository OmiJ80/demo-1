package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String model;
    private String imageName; // Name of the uploaded image file
	public Car(Long id, String name, double price, String model, String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.model = model;
		this.imageName = imageName;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", model=" + model + ", imageName=" + imageName
				+ "]";
	}

    // Constructors, getters, and setters

    // ...
}
