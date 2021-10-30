package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;


@RestController
public class RestTemplateWebService2 {
	//在RestTmplApplicationTests有測試
	
	List<Message> messages = new ArrayList<Message>() {{
		add(new Message("msg1"));
		add(new Message("msg2"));
	}};
	
	//@GetMapping在Spring4.3時才有的,位置只能在class之內，可在method層面上用作處理 http 的請求，
		//SpringMVC以前版本的@RequestMapping。
	@GetMapping("messages")
	public List<Message> index() {
		return messages;
	}
	
	@GetMapping("messages/{id}")
	public Message show(@PathVariable("id") String id) {
		return messages.get(Integer.parseInt(id) - 1);
	}
	
	@PostMapping("messages")
	public Message create(@RequestBody Message message) {
		messages.add(message);
		return message;
	}
	
	@DeleteMapping("messages/{id}")
	public Message delete(@PathVariable("id") String id) {
		return messages.remove(Integer.parseInt(id) - 1);
	}
}
