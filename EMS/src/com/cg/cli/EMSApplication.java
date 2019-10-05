package com.cg.cli;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.beans.Department;
import com.cg.beans.Grade;
import com.cg.beans.User;
import com.cg.service.DepartmentService;
import com.cg.service.DepartmentServiceImpl;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;
import com.cg.service.GradeService;
import com.cg.service.GradeServiceImpl;
import com.cg.service.UserService;
import com.cg.service.UserServiceimpl;

public class EMSApplication {
	private static Scanner scanner;
	private static UserService service;
	private static DepartmentService dservice;
	private static GradeService gservice;
	static{
		scanner = new Scanner(System.in);
		service = new UserServiceimpl();
		dservice = new DepartmentServiceImpl();
		gservice = new GradeServiceImpl();
	}
	public static void main(String[] args) {
		int userTypeChoice;
		System.out.println("WELCOME TO EMPLOYEE MAINTENANCE SYSTEM.");
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
		System.out.print("Enter User ID : ");
		userId = scanner.next();
		System.out.print("Enter your User Name : ");
		userName = scanner.next();
		System.out.print("Enter your Password : ");
		password = scanner.next();
		while(true){
			System.out.print("Enter user type : Admin/Employee ");
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
		
		User flag = service.validateUser(user);
		if(flag==null) {
			System.out.println("No user found. Login unsuccessful.");
		}else {
			System.out.println("User Found. logged in as "+flag.getUserType());
			if(flag.getUserType().equalsIgnoreCase("Admin")) {
				adminLogin(flag);
			} else {
				employeeLogin(flag);
			}
		}
		
	}

	private static void employeeLogin(User flag) {
		// TODO Auto-generated method stub
		
	}

	private static void adminLogin(User flag) {
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
		String empId, firstName, lastName, gender, maritalStatus, homeAddress,contactNo, mgrId, deptName, description, gradeCode;
		//Department empDept; 
		//Grade empGrade;
		Date dateOfBirth, dateOfJoining; double basic; int deptId;
		do{
			System.out.print("Enter Employee ID : ");
			empId = scanner.next();
		}while(!service.validateEmpId(empId));
		
		do{
			System.out.print("Enter first name : ");
			firstName = scanner.next();
		}while(service.validateFirstName(firstName));
		
		do{
			System.out.print("Enter last name : ");
			lastName = scanner.next();
		}while(service.validateLastName(lastName));
		Date dob = null;
		 boolean flag = false;
		do {
			String sdob;
			do {
				System.out.print("Enter date of birth in dd-mm-yyyy format: ");
				sdob = scanner.next();
				
			}while(!service.validateDateOfBirth(sdob));
			try {
				dob = new SimpleDateFormat("dd-MM-yyyy").parse(sdob);
				LocalDate date = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate sysdate = LocalDate.now();
				Period period = date.until(sysdate);
				if(period.get(ChronoUnit.YEARS)<18||period.get(ChronoUnit.YEARS)>58) {
					System.out.println("Age of the employee does not conform to the standards. Enter DOB again.");
					sdob = ""; dob = null; date = null; sysdate = null; flag = false;
				}else {
					dateOfBirth = dob;
					flag = true;
				}
			} catch (ParseException e) {
				System.out.println("Date format entered was incorrect. Enter again.");
			}
		}while(flag==false);
		flag = false;
		Date doj = null;
		do {
			String sdoj;
			do {
				System.out.print("Enter date of joining in dd-mm-yyyy format: ");
				sdoj = scanner.next();
				
			}while(!service.validateDateOfJoining(sdoj));
			try {
				doj = new SimpleDateFormat("dd-MM-yyyy").parse(sdoj);
				LocalDate jdate = doj.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate bdate =  dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				Period period = jdate.until(bdate);
				if(period.get(ChronoUnit.YEARS)>0) {
					System.out.println("DAte of Joining of employee does not conform to the standards. Enter DOJ again.");
					sdoj = ""; doj = null; jdate = null; bdate = null; flag = false;
				}else {
					dateOfJoining = doj;
					flag = true;
				}
			} catch (ParseException e) {
				System.out.println("Date format entered was incorrect. Enter again.");
			}
		}while(flag==false);
		
		do {
			System.out.print("Enter Gender : ");
			System.out.print("Male / Female ->");
			gender = scanner.next();
		}while(!service.validateGender(gender));
		
		do{
			System.out.print("Enter the marital status : ");
			System.out.print("Single / Married / Divorced / Separated / Widowed ->");
			maritalStatus = scanner.next();
		}while(!service.validateMaritalStatus(maritalStatus));
		flag = true;
		do {
			System.out.println("Home Address is optional. Enter '-' to leave it blank");
			System.out.print("Enter Home Address : ");
			String address = scanner.next();
			if(address.equals("-")) {
				homeAddress = null;
				break;
			}
			else {
				homeAddress = address;
				break;
			}
		}while(true);
		flag = true;
		do {
			System.out.println("Personal Contact No. is optional. Enter '-' to leave it blank");
			System.out.print("Enter Contact No. : ");
			String number = scanner.next();
			if(number.equals("-")) {
				contactNo = null;
				break;
			}
			else {
				contactNo = number;
				break;
			}
		}while(true);
		flag = false;
		Department d = null;
		do {
			System.out.print("Enter Department Name : ");
			String dname = scanner.next();
			d = dservice.findDepartment(dname);
			if(d != null) {
				//empDept = d;
				deptName = d.getDname();
				deptId = d.getId();
				flag = true;
			} else {
				dname = ""; d = null; flag = false;
			}
				
		}while(flag == false);
		Grade g = null;
		do {
			System.out.print("Enter Grade : ");
			String grade = scanner.next();
			g = gservice.findGrade(grade);
			if(g != null) {
				//empDept = d;
				deptName = g.getDescription();
				gradeCode = g.getCode();
				flag = true;
			} else {
				gradeCode = null; g = null; flag = false;
			}
		}while(flag == false);
		flag = false;
		do{
			System.out.print("Enter Basic salary : ");
			basic = scanner.nextDouble();
			if(basic > g.getMinSalary() && basic < g.getMaxSalary())
				flag = true;
			else {
				System.out.println("Basic salary is not per the slab specified. Enter again. ");
				flag = false;
			}
		}while(flag == false);
		
		    
	}
}

//	private static Grade findGrade(String grade) {
//		List<Grade> grades = Arrays.asList(new Grade("M1", "Analyst", 340000, 450000), new Grade("M2", "Senior Analyst", 450000, 700000), new Grade("M3","Consultant", 700000, 850000), new Grade("M4","Associate Consultant", 850000, 1000000),
//				new Grade("M5","Senior Consultant", 1000000, 1250000),new Grade("M6","Director", 1250000, 1750000),new Grade("M7","Manager",1750000, 2500000));
//		Grade gr = null;
//		for(Grade g : grades) {
//			if(g.getCode().equalsIgnoreCase(grade)) {
//				gr = g;
//				break;
//			}
//		}
//		if(grade == null) 
//			System.out.println("Inavlid grade code entered. Enter again.");
//		return gr;
//	}
//
//	private static Department findDepartment(int id) {
//		List<Department> depts = Arrays.asList(new Department(101, "Sales"), new Department(102, "L&D"), new Department(103,"Management"));
//		Department dept = null; 
//		for(Department d : depts) {
//			if(d.getId()==id) {
//				dept = d;
//				break;
//			}
//		}
//		if(dept == null) 
//			System.out.println("Inavlid department ID entered. Enter again.");
//		return dept;
//		
//	}


	

