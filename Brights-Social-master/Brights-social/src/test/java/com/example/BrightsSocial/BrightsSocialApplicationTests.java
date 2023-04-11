package com.example.BrightsSocial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BrightsSocialApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testUserCreation() {
		People people = new People("Andreas", "Olsson", "Sthlm", "Andreas", "12345678");
		Assertions.assertEquals("Andreas", people.getFirstName());
		Assertions.assertEquals("Andreas", people.getUsername());
		Assertions.assertEquals("Olsson", people.getLastName());
		Assertions.assertEquals("Sthlm", people.getCity());
		Assertions.assertEquals("12345678", people.getPasscode());
	}

}
