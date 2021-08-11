package com.udemy.spring.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.udemy.spring.product.entities.Product;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${product.custom.config}")
	private String customConfiguration;
	@Test
	void contextLoads() {
	}

	@Test
	public void testGetProduct() {
		System.out.println("customConfiguration="+customConfiguration);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/productapi/products/1", Product.class);
		assertNotNull(product);
		System.out.println(product);
		assertEquals("IPhone", product.getName());
	}

	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product productToBeCreated = new Product();
		productToBeCreated.setName("Laptop");
		productToBeCreated.setDescription("Lenovo Laptop");
		productToBeCreated.setPrice(6000d);
		Product product = restTemplate.postForObject("http://localhost:8080/productapi/products", productToBeCreated,
				Product.class);
		assertNotNull(product);
		System.out.println(product);
		assertEquals("Laptop", product.getName());
	}

	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product productToBeUpdated = restTemplate.getForObject("http://localhost:8080/productapi/products/1",
				Product.class);
		productToBeUpdated.setPrice(4000d);
		restTemplate.put("http://localhost:8080/productapi/products", productToBeUpdated);
	}
	
	@Test
	public void testDeleteProduct() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8080/productapi/products/9");
	}
}
