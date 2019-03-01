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
		assertTrue(this.validator.passwordDoesNotContainSpecialCharacters(password));
	}

	@Test
	public void passwordContainingSpecialCharactersIsNotValid() {
		String password = "abcd1234!";
		String password2 = "abcd1234";
		assertFalse(this.validator.passwordDoesNotContainSpecialCharacters(password));
		assertTrue(this.validator.passwordDoesNotContainSpecialCharacters(password2));
	}

	@Test
	public void passwordContainingAnEmptySpaceIsNotValid() {
		String password = "abcd 1234";
		assertFalse(this.validator.passwordDoesNotContainSpecialCharacters(password));
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

	@Test
	public void nullPasswordIsNotValid() {
		String password = null;
		assertFalse(this.validator.passwordIsNotEmptyStringOrNull(password));
	}

	@Test
	public void passwordNotContainingANumberIsNotValid() {
		String password = "abcdefg";
		assertFalse(this.validator.passwordContainsUpperCaseAndLowerCaseLetterAndNumber(password));
	}

	@Test
	public void passwordContainingUpperCaseAndLowerCaseLetterAndNumberIsValid() {
		String password = "abcABC123";
		String password2 = "abcabc123";
		assertTrue(this.validator.passwordContainsUpperCaseAndLowerCaseLetterAndNumber(password));
		assertFalse(this.validator.passwordContainsUpperCaseAndLowerCaseLetterAndNumber(password2));
	}
	@Test
	public void passwordContainingNoImmediatelyRepeatingSequenceOfCharactersIsValid() {
		String password = "abcabc123";
		String password2 = "abc123abc";
		String password3 = "abcABC123";
		String password4 = "123ABCABC";
		String password5 = "ABC123abc!@#";

		assertFalse(this.validator.passwordContainsNoImmediatelyRepeatingSequencesOfCharacters(password));
		assertTrue(this.validator.passwordContainsNoImmediatelyRepeatingSequencesOfCharacters(password2));
		assertTrue(this.validator.passwordContainsNoImmediatelyRepeatingSequencesOfCharacters(password3));
		assertFalse(this.validator.passwordContainsNoImmediatelyRepeatingSequencesOfCharacters(password4));
		assertTrue(this.validator.passwordContainsNoImmediatelyRepeatingSequencesOfCharacters(password5));
	}

	public void passwordMeetsAllRequirements() {
		String goodPassword = "abcABC123";
		String noSpecialCharacters = "abcABC123";
		String noNumbers = "abcABC";
		String noLowerCaseLetters = "ABC123";
		String noUpperCaseLetters = "abc123";
		String noLetters = "123456";
		String tooShort = "aB1";
		String tooLong = "abcdeABCDE12345";
		String hasSpecialCharacter = "abcABC123!";

		assertTrue(this.validator.runAllValidationCases(goodPassword));
		assertFalse(this.validator.runAllValidationCases(noSpecialCharacters));
		assertFalse(this.validator.runAllValidationCases(noNumbers));
		assertFalse(this.validator.runAllValidationCases(noLowerCaseLetters));
		assertFalse(this.validator.runAllValidationCases(noUpperCaseLetters));
		assertFalse(this.validator.runAllValidationCases(noLetters));
		assertFalse(this.validator.runAllValidationCases(tooShort));
		assertFalse(this.validator.runAllValidationCases(tooLong));
		assertFalse(this.validator.runAllValidationCases(hasSpecialCharacter));
	}

}
