package com.example.TransactionalDemoProject;

import com.example.TransactionalDemoProject.model.A;
import com.example.TransactionalDemoProject.service.ServiceA;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionalDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalDemoProjectApplication.class, args);


	}
}
