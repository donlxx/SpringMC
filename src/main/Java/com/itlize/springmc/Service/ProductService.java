package com.itlize.springmc.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itlize.springmc.Repository.ProductImageRepository;
import com.itlize.springmc.Repository.ProductRepository;
import com.itlize.springmc.bean.Product;
import com.itlize.springmc.bean.ProductImage;
import com.itlize.springmc.http.Response;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductImageRepository productImageRepository;
	
	public Response save(Product product) {
		List<ProductImage> images = product.getProductImage();
			for (int i = 0; i < images.size(); i++) {
					images.get(i).setProduct(product);
					productImageRepository.save(images.get(i));
			}

			productRepository.save(product);
			return new Response(true);
	}

	public Response edit(Product product) {
		try {
			Product p = productRepository.findById(product.getId()).get();
			List<ProductImage> images = p.getProductImage();
			
			List<ProductImage> images2 = product.getProductImage();
			// handled update and add products in order
			images2.forEach((i) -> {
				Product product1 = (Product) productRepository.findById(product.getId()).get();
				i.setProduct(product1);
			});
			
			// handle remove products in order
			if(images2.size() > 0) {
				images = images.stream().filter((i) -> {
					return !images2.contains(i);
				}).collect(Collectors.toList());
			}
			
			p.setProductImage(images2);
									
			return new Response(true);
		} catch (Exception e) {
			System.out.println(e);
			return new Response(false);
		}
	}

	public Response delete(Product product) {
		List<ProductImage> images = product.getProductImage();
		for (int i = 0; i < images.size(); i++) {
				productImageRepository.deleteById(images.get(i).getId());
		}

		productRepository.deleteById(product.getId());
		return new Response(true);
	}
	
	public List<Product> getAllProducts() {
		 
        return productRepository.findAll();
    }
	public Product getById(int id) {
		return productRepository.findById(id).get();
	}

}
