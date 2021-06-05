package com.example.desafioorange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioorangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioorangeApplication.class, args);
	}

}
