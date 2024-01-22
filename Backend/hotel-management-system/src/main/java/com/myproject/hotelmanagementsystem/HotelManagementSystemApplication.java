package com.myproject.hotelmanagementsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myproject.hotelmanagementsystem.auth.AuthenticationService;
import com.myproject.hotelmanagementsystem.auth.RegisterRequest;
import com.myproject.hotelmanagementsystem.user.Role;

@SpringBootApplication
public class HotelManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementSystemApplication.class, args);
	}

	public CommandLineRunner commandLineRunner(AuthenticationService authService) {
		return args -> {
			var admin = RegisterRequest.builder()
							.firstname("Admin")
							.lastname("Admin")
							.email("admin@gmail.com")
							.password("password")
							.role(Role.ADMIN)
							.build();
			System.out.println("Admin Token : " + authService.register(admin).getToken());

			var manager = RegisterRequest.builder()
							.firstname("Admin")
							.lastname("Admin")
							.email("manager@gmail.com")
							.password("password")
							.role(Role.HOTEL_MANAGER)
							.build();
			System.out.println("Manager Token : " + authService.register(manager).getToken());
		};
	}

}
