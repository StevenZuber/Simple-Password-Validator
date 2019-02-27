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

		System.out.println("\nPlease enter your password for validation.\n");

		password = sc.next();

		//TODO remove this check
		System.out.println("PASSWORD IS : " + password);

		validator.passwordDoesntContainSpecialCharacters(password);
		validator.passwordIsBetween5and12Characters(password);

	}



}
