package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	//使用 Thymeleaf 模板在 Spring Boot 中創建 Web 應用程序
	//index.html文件應該放在templates目錄下，所有的JS和CSS文件
	//都應該放在classpath的static目錄下。
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
}
