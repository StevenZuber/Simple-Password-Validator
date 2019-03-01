#Spring Boot Password Validator 
This is a sample Java Spring Boot application that allows the user to check various passwords to see if they meet the validation criteria specified in the AC.

The acceptance criteria for a password to be valid are: 
* Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
* Must be between 5 and 12 characters in length.
* Must not contain any sequence of characters immediately followed by the same sequence.

##How to Run

* Clone this repository
* Import the project into your IDE and build it. 
* Run the PasswordValidatorApplication to run.

##Challenges faced when I developed this project:
* I spent over an hour trying to find a regex solution for many of the validation cases, but I decided to go ahead and check things more explicitly to save time and enhance readability.

* I spent the most time trying to find a more elegant solution to the third AC, but ended up having to do a series of explicit checks of substrings when I spent too much time on this.

##Things I would have added to this application if given more time/if it was ever to be used in a real-world context
* In a professional context, we'd likely use some sort of encryption and not pass the password around in plain text.