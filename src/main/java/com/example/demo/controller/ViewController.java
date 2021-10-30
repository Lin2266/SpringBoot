package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//使用 jQuery AJAX 使用 RESTful Web 服務。
@Controller
public class ViewController {
	@RequestMapping("/view-products")
	public String viewProducts() {
		return "view-products";
	}
	
	@RequestMapping("/add-products")
	public String addProducts() {
		return "add-products";
	}
}
