package com.example.demo.controller;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Product;

@RestController
public class RestTemplateWebService {
	//Application要加@Bean不然會出錯
	@Autowired
	RestTemplate restTemplate;
	//必須手動配置Bean是因為RestTemplate使用前常需要自訂各種參數，所以Spring Boot不幫我們自動配置。
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value="/template/products")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		return restTemplate.exchange("http://127.0.0.1:8080/products",HttpMethod.GET,entity,String.class).getBody();
	}
	
	@RequestMapping(value = "/template/products", method = RequestMethod.POST)
	public String createProducts(@RequestBody Product product) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
	      
	    return restTemplate.exchange(
	         "http://127.0.0.1:8080/products", HttpMethod.POST, entity, String.class).getBody();
	 }
	
	@RequestMapping(value="/template/products/{id}",method=RequestMethod.PUT)
	public String updateProduct(@PathVariable("id") String id,@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
		
		return restTemplate.exchange(
				"http://127.0.0.1:8080/products/" + id, HttpMethod.PUT,entity,String.class).getBody();
	}
	
	@RequestMapping(value="/template/products/{id}",method=RequestMethod.DELETE)
	public String deleteProduct(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<>(headers);
		
		return restTemplate.exchange(
				"http://127.0.0.1:8080/products/" + id, HttpMethod.DELETE, entity, String.class).getBody();
				
	}

}
