package com.rajat.testgeek;

// import java.util.HashSet;
// import java.util.Set;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import com.rajat.testgeek.models.Role;
// import com.rajat.testgeek.models.User;
// import com.rajat.testgeek.models.UserRole;
// import com.rajat.testgeek.service.UserService;

@SpringBootApplication
public class TestgeekApplication // implements CommandLineRunner
{

	// @Autowired
	// private UserService UserService;

	public static void main(String[] args) {
		SpringApplication.run(TestgeekApplication.class, args);
		System.out.println("Welcom to TestGeek!!!");
	}

	// Test the User Role Model
	// @Override
	// public void run(String... args) throws Exception {

	// User user1 = new User();
	// user1.setEmail("email@test.com");
	// user1.setFirstName("Rajat");
	// user1.setLastName("Garg");
	// user1.setUsername("rajat");
	// user1.setPassword("abc");
	// user1.setProfileImage("photo.jpg");

	// Role role1 = new Role();
	// role1.setRoleName("Admin");
	// Role role2 = new Role();
	// role2.setRoleName("Student");

	// Set<UserRole> userRoles = new HashSet<>();

	// UserRole userRole1 = new UserRole();
	// UserRole userRole2 = new UserRole();
	// userRole1.setRole(role1);
	// userRole1.setUser(user1);
	// userRole2.setRole(role2);
	// userRole2.setUser(user1);

	// userRoles.add(userRole1);
	// userRoles.add(userRole2);

	// user1.setUserRoles(userRoles);

	// User user = this.UserService.addUser(user1, userRoles);

	// System.out.println(user);

	// }

}
