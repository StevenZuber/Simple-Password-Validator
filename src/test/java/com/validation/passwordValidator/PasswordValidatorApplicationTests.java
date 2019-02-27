package com.validation.passwordValidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordValidatorApplicationTests {

	PasswordValidator validator;

	@Before
	public void setUp() {
		this.validator = new PasswordValidator();
	}

	@Test
	public void passwordContainingLettersAndNumbersIsValid() {
		String password = "abcd1234";
		assertTrue(this.validator.passwordDoesntContainSpecialCharacters(password));
	}

	@Test
	public void passwordContainingSpecialCharactersIsNotValid() {
		String password = "abcd1234!";
		assertFalse(this.validator.passwordDoesntContainSpecialCharacters(password));
	}

	@Test
	public void passwordContainingAnEmptySpaceIsNotValid() {
		String password = "abcd 1234";
		assertFalse(this.validator.passwordDoesntContainSpecialCharacters(password));
	}

	@Test
	public void passwordShorterThan5CharactersIsNotValid() {
		String password = "ab12";
		assertFalse(this.validator.passwordIsBetween5and12Characters(password));
	}

	@Test
	public void passwordLongerThan12CharactersIsNotValid() {
		String password = "abcdefg1234567";
		assertFalse(this.validator.passwordIsBetween5and12Characters(password));
	}

	@Test
	public void passwordBetween5and12CharactersIsValid() {
		String password = "abcdef123456";
		assertTrue(this.validator.passwordIsBetween5and12Characters(password));
	}


}
