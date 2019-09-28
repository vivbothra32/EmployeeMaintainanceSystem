package com.cg.cli;

import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.beans.Department;
import com.cg.beans.Grade;
import com.cg.beans.User;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;
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
			userTypeChoice = scanner.nextInt();		
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
			if(flag.getUserType().equalsIgnoreCase("Admin")) {
				adminLogin(flag);
			} else {
				employeeLogin(flag);
			}
		}
		
	}

	private static void employeeLogin(User flag) {
		int choice;
		do {
			System.out.println("==============================================");
			System.out.println("Enter 1 to Add Employee");
			System.out.println("Enter 2 to Modify Employee Details");
			System.out.println("Enter 3 to Display Employee Details");
			System.out.println("==============================================");
			choice = scanner.nextInt();
			switch(choice) {
				case 1 : addEmployee();
				case 2 : modifyEmployee();
				case 3 : displayEmployee();
				case 0 : System.exit(0);
				default : System.out.println("Invalid choice entered");
			}
		}while(true);
	}

	private static void displayEmployee() {
		
	}

	private static void modifyEmployee() {
		
	}

	private static void addEmployee() {
		EmployeeService service = new EmployeeServiceImpl();
		String empId, firstName, lastName, gender, maritalStatus, homeAddress,contactNo, mgrId;
		Department empDept; 
		Grade empGrade;
		Date dateOfBirth, dateOfJoining; double basic;
		do{
			System.out.print("Enter Employee ID : ");
			empId = scanner.next();
		}while(service.validateEmpId(empId));
		
		do{
			System.out.print("Enter first name : ");
			firstName = scanner.next();
		}while(service.validateFirstName(firstName));
		
		do{
			System.out.print("Enter last name : ");
			lastName = scanner.next();
		}while(service.validateLastName(lastName));
		
		do {
			System.out.print("Enter Gender : ");
			System.out.println("Male / Female ");
			gender = scanner.next();
		}while(service.validateGender(gender));
		
		do{
			System.out.print("Enter the marital status : ");
			System.out.println("Single / Married / Divorced / Separated / Widowed ");
			maritalStatus = scanner.next();
		}while(service.validateMaritalStatus(maritalStatus));

		do {
			System.out.println("Home Address is optional. Enter '-' to leave it blank");;
			System.out.print("Enter Home Address : ");
			String address = scanner.nextLine();
			if(address.equals("-")) {
				homeAddress = null;
				break;
			}
			else {
				homeAddress = address;
				break;
			}
		}while(true);
		do {
			System.out.println("Personal Contact No. is optional. Enter '-' to leave it blank");;
			System.out.print("Enter Contact No. : ");
			String number = scanner.nextLine();
			if(number.equals("-")) {
				contactNo = null;
				break;
			}
			else {
				contactNo = number;
				break;
			}
		}while(true);
		boolean flag = false;
		do {
			System.out.println("Enter dept : ");
			int id = scanner.nextInt();
			List<Department> depts = Arrays.asList(new Department(101, "Sales"), new Department(102, "L&D"), new Department(103,"Management"));
			for(Department d : depts) {
				if(d.getId()==id) {
					flag = true;
					break;
				}else {
					flag = false;
				}
			}
		}while(flag == false);
		
		    
	}

	private static void adminLogin(User flag) {
		
	}
}
