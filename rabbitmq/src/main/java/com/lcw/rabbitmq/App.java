package com.lcw.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	
	public final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
			
		SpringApplication.run(App.class, args);
	}

}

