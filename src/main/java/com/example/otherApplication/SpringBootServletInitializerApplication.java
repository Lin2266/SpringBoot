package com.example.otherApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//繼承SpringBootServletInitializer以支持WAR文件部署。
public class SpringBootServletInitializerApplication extends SpringBootServletInitializer{
	
	//繼承SpringBootServletInitializer的實作方法
	  @Override
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(SpringBootServletInitializerApplication.class);
	   }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServletInitializerApplication.class, args);

	}

}
