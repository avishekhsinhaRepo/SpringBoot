package com.udemy.spring.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.udemy.spring.product.entities.Product;
import com.udemy.spring.product.repos.ProductRepository;

@RestController
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class) ;
	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	public Product getProduct(@PathVariable("id") int id) {
		LOGGER.info("Finding the product with id="+ id);
		return productRepository.findById(id).get();
	}
	@Transactional
	@Cacheable("product-cache")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}
	@Transactional
	@Cacheable("product-cache")
	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@CacheEvict("product-cache")
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		productRepository.deleteById(id);
	}
}
