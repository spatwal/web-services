package com.master.webServices.webServices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.master.webServices.webServices.entity.HelloWorldBean;

@RestController
public class HelloWorldController {

//@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
	@GetMapping(path = "/helloWorld")
	public String printHello() {
		return "Hello World";

	}

	@GetMapping(path = "/helloWorldBean")
	public HelloWorldBean printHelloBean() {
		return new HelloWorldBean("Hello World");

	}

	@GetMapping(path = "/helloWorldBean/pathVariable/{name}")
	public HelloWorldBean printHelloBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s ", name));

	}

}
