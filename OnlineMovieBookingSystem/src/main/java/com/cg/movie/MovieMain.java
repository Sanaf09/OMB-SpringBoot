package com.cg.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieMain {

	public static void main(String[] args) {
		System.out.println("Online Movie Management System ");
		SpringApplication.run(MovieMain.class, args);
		System.out.println("Server running");


	}

}
