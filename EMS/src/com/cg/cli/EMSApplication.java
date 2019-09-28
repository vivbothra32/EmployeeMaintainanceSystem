package com.cg.cli;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.beans.User;
import com.cg.service.UserService;
import com.cg.service.UserServiceimpl;

public class EMSApplication {
	private static Scanner scanner;
	static{
		scanner = new Scanner(System.in);
	}
	public static void main(String[] args) {
		int userTypeChoice;
		System.out.println("WELCOME TO FLIGHT RESERVATION SYSTEM.");
		do {
			System.out.println("==============================================");
			System.out.println("Enter 1 to Sign In.");
			System.out.println("Enter 0 to Exit.");
			System.out.println("==============================================");
			while (true) {
				try {
					userTypeChoice = scanner.nextInt();
					break;
				} catch (InputMismatchException exception) {
					scanner.nextLine();
					System.err.println(exception);
					continue;
				}
			}
			switch(userTypeChoice) {
				case 1 : signIn();
				case 0 : System.exit(0);
				default : System.out.println("Invalid choice entered");
			}
		}while(true);
		
		
	}
	
	public static void signIn() {
		System.out.println("==============================================");
		System.out.println("Sign In: ");
		User user = new User();
		String userId;
		String userName;
		String userType;
		String password;
		System.out.println("Enter User ID");
		userId = scanner.next();
		System.out.println("Enter your User Name: ");
		userName = scanner.next();
		System.out.println("Enter your Password: ");
		password = scanner.next();
		while(true){
			System.out.println("Enter user type : Admin/Employee ");
			userType = scanner.next();
			if(userType.equals("Admin")||userType.equals("Employee")
					||userType.equals("admin")||userType.equals("employee")) {
				break;
			} else {
				continue;
			}
		}
		
		user.setUserId(userId);
		user.setPassword(password);
		user.setUserName(userName);
		user.setUserType(userType);
		
		UserService service = new UserServiceimpl();
		User flag = service.validateUser(user);
		if(flag==null) {
			System.out.println("No user found. Login unsuccessful.");
		}else {
			System.out.println(flag.toString());
			System.out.println("User Found. logged in as "+flag.getUserType());
		}
		
	}
}
