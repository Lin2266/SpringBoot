package com.example.otherApplication;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunnerApplication implements ApplicationRunner {
	
	//實作ApplicationRunner，會在console裡打印
		@Override
		   public void run(ApplicationArguments arg0) throws Exception {
		      System.out.println("Hello World from ApplicationRunnerApplication");
		   }

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunnerApplication.class, args);

	}

}
