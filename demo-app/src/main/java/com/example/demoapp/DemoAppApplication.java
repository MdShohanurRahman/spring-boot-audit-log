package com.example.demoapp;

import com.example.demoapp.entity.User;
import com.example.demoapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication  implements CommandLineRunner {

	private final UserRepository userRepository;

	public DemoAppApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create application admin
		User user = new User();
		user.setId(1L);
		user.setEmail("admin@gmail.com");
		user.setPassword("123456");
		userRepository.save(user);

	}
}
