package com.validation.passwordValidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class PasswordValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordValidatorApplication.class, args);

		Scanner sc = new Scanner(System.in);

		PasswordValidator validator = new PasswordValidator();

		String password;

		System.out.println("\nPasswords must meet the following Criteria:\n" +
				"Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.\n" +
				"Must be between 5 and 12 characters in length.\n" +
				"Must not contain any sequence of characters immediately followed by the same sequence.*/Please enter your password for validation.\n\n" +
				"Enter as many passwords as you like and enter \"exit\" to exit.\n");


		while (true) {
			password = sc.next();
			if (!password.equals("exit")) {
				validator.runAllValidationCases(password);
				System.out.println("\nEnter another password or enter \"exit\" to exit.\n");
			} else {
				break;
			}
		}
	}
}