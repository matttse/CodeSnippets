package codeSnippets;

import dhl.UserInputHandler;
public class simpleSwingPrompt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initialize and declare global vars
		String fname = "";
		String lname = "";
		// instantiate the handler
		UserInputHandler<String> processInput = new UserInputHandler<String>();
		
		String fullName = processInput.getString("First Name: ").concat(" ").concat(processInput.getString("Last Name: "));
		String[] fullNameArray = fullName.split(" ");
		fname = fullNameArray[0];
		lname = fullNameArray[1];
		System.out.println("first name: " + fullNameArray[0]);
		System.out.println("last name: " + fullNameArray[1]);
	}
	
	// standard system exit.
	public static void exit(int status) {
		System.exit(status);
		return;
	}//end system exit

}
