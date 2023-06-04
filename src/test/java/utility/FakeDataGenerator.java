package utility;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
	
	@Test
	public void generateData() {
		
		Faker faker = new Faker();
		
		String fullname = faker.name().fullName();
		System.out.println("Full name is " + fullname);
		String firstname = faker.name().firstName();
		System.out.println("First name is " + firstname);
		String lastname = faker.name().lastName();
		System.out.println("Last name is " + lastname);
		
		String username = faker.name().username();
		System.out.println("User name is " + username);
		String password = faker.internet().password();
		System.out.println("Password is " + password);
		
		String phonenumber = faker.phoneNumber().cellPhone();
		System.out.println("Phone number is " + phonenumber);
		String emailid = faker.internet().emailAddress();
		System.out.println("Email id is " + emailid);
		
	}
	

}
