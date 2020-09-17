package com.itlize.springmc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itlize.springmc.bean.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Integer>{

}
