package com.itlize.springmc.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ita_product")
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="year")
	private String year;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="hp")
	private int hp;
	
	@Column(name="heatingSurface")
	private int heatingSurface;
	
	@Column(name="pressure")
	private int pressure;
	
	@Column(name="length")
	private int length;
	
	@Column(name="hight")
	private int hight;
	
	@Column (name="model")
	private String model;
	
	@Column (name="color")
	private String color;
	
	
	@Column(name="price")
	private int price;
	
	@Column(name="type")
	private String type;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
//	@JsonIgnore
	private List<ProductImage> productImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHeatingSurface() {
		return heatingSurface;
	}

	public void setHeatingSurface(int heatingSurface) {
		this.heatingSurface = heatingSurface;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ProductImage> getProductImage() {
		return productImage;
	}

	public void setProductImage(List<ProductImage> productImage) {
		this.productImage = productImage;
	}

	public Product(int id, String name, String year, String brand, int hp, int heatingSurface, int pressure, int length,
			int hight, String model, String color, int price, String type, List<ProductImage> productImage) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.brand = brand;
		this.hp = hp;
		this.heatingSurface = heatingSurface;
		this.pressure = pressure;
		this.length = length;
		this.hight = hight;
		this.model = model;
		this.color = color;
		this.price = price;
		this.type = type;
		this.productImage = productImage;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}