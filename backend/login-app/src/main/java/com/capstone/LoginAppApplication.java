package com.capstone;

import java.util.Optional;

import com.capstone.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.capstone.entity.Login;

import jakarta.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com.capstone")
@EntityScan(basePackages = "com.capstone.entity")
@EnableJpaRepositories(basePackages = "com.capstone.repository")
public class LoginAppApplication {

	@Autowired
	LoginRepository loginRepository;

	@PostConstruct
	public void init() {
		Optional<Login> result = loginRepository.findById("admin@gmail.com");
		if(result.isPresent()) {
			System.out.println("Account present");
		}else {
			Login ll = new Login();
			ll.setEmailid("admin@gmail.com");
			ll.setPassword("admin@123");
			ll.setTypeofuser("admin");
			loginRepository.save(ll);
			System.out.println("Admin account created...");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginAppApplication.class, args);
		System.err.println("spring boot up on port number 9090");
	}

}