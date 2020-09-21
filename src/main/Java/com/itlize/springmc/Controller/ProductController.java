package com.itlize.springmc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.springmc.Service.ProductService;
import com.itlize.springmc.bean.Product;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*",allowCredentials="true")
@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;
	
    @GetMapping("/product")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Product>> getAllProducts() {
 
        List<Product> products = ps.getAllProducts();
        System.out.println("1233456789");
        System.out.println(products);
        //return new ResponseEntity<>("abc", HttpStatus.OK);
        
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    @GetMapping("/product/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
    	Product product = ps.getById(id);
    	return new ResponseEntity<>(product, HttpStatus.OK);
    }
 
    @PostMapping("/product")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Product> saveProduct(@RequestBody Product p) {
 
        ps.save(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
 
    @PutMapping("/product")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Product> updateProduct(@RequestBody Product p) {
 
        ps.edit(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
 
    @DeleteMapping("/product")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Product> deleteEmployee(@RequestBody Product p) {
 
        ps.delete(p);
        return new ResponseEntity<>(p , HttpStatus.OK);
    }

	
}