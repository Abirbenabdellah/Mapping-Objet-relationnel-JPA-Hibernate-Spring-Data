package com.example.jpa_mtm;

import com.example.jpa_mtm.entities.Role;
import com.example.jpa_mtm.entities.User;
import com.example.jpa_mtm.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaMtmApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpaMtmApplication.class, args);}
	@Bean
	CommandLineRunner start(UserService userService){
		return  args -> {
			User u=new User();
			u.setUsername("user1");
			u.setPassword("1234");
			userService.addNewUser(u);
			User u1=new User();
			u1.setUsername("admin");
			u1.setPassword("12345");
			userService.addNewUser(u1);
			Stream.of("etudiant","user","ADMIN").forEach(r->{
				Role role1=new Role();
				role1.setNom(r);
				userService.addNewRole(role1);
			});
			userService.addRoleToUser("user1","etudiant");
			userService.addRoleToUser("user1","user");
			userService.addRoleToUser("admin","user");
			userService.addRoleToUser("admin","ADMIN");
			try {
				User user=userService.authenticate("user1","1234");
				System.out.println(user.getId());
				System.out.println(user.getUsername());
				System.out.println("roles ");
				user.getRoles().forEach(r->{
					System.out.println("roles "+r);
				});
			}catch(Exception exception){
				exception.printStackTrace();

			}



		};
	}

}
