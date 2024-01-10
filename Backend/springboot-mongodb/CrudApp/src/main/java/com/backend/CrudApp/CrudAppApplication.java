package com.backend.CrudApp;

import com.backend.CrudApp.entity.Role;
import com.backend.CrudApp.entity.User;
import com.backend.CrudApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CrudAppApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	public void run(String... args) {
		User adminAccount = userRepo.findByRole(Role.ADMIN);

		if (adminAccount == null) {
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));

			userRepo.save(user);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

}
