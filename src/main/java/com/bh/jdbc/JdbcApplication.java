package com.bh.jdbc;

import com.bh.jdbc.domain.Customer;
import com.bh.jdbc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... strings) throws Exception {
		//데이터 추가
		Customer created = customerRepository.save(new Customer(null, "Jordan","Kwang"));
		System.out.println("created : " + created);

		//데이터 표시
		customerRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

}
