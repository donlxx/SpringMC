package com.itlize.springmc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ita_product_image")
public class ProductImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="image")
	String image;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="product_id",nullable=false)
	@JsonIgnore
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductImage(int id, String image, Product product) {
		super();
		this.id = id;
		this.image = image;
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", image=" + image + ", product=" + product + "]";
	}
	
	}