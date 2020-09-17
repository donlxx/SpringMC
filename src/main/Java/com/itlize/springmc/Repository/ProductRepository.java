package com.itlize.springmc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itlize.springmc.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	Product findByName(String name);
}
