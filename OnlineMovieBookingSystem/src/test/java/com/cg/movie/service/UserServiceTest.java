package com.cg.movie.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.movie.dto.UserDetails;
import com.cg.movie.entities.Customer;
import com.cg.movie.entities.Theater;

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(UserServiceImpl.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserServiceTest {
	// this class will be used to test business logic of student service.
	@Autowired
	private UserServiceImpl service;

	@Test
	public void testRegisterNewUser() {
		Customer cust = service.registerNewUser(new Customer("MAX","max1234",null,"9920765239"));
		Integer id = cust.getCustomerId();
		Customer custFound = service.findById(id);
		System.out.println(custFound);
		Assertions.assertEquals(custFound.getCustomerName(), cust.getCustomerName());
	}
	
	@Test
	public void testLogin() {
		String role = service.login(new UserDetails("sanaf", "sanaf1234", "admin"));
		Assertions.assertEquals("admin", role);
	}
}
