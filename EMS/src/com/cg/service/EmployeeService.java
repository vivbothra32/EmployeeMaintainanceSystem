package com.cg.service;

import java.util.Date;

import com.cg.beans.Department;
import com.cg.beans.Grade;

public interface EmployeeService {

	boolean validateFirstName(String firstName);

	boolean validateLastName(String lastName);

	boolean validateEmpId(String empId);

	boolean validateGender(String gender);

	boolean validateMaritalStatus(String maritalStatus);

	boolean validateDateOfBirth(String sdob);

	boolean validateDateOfJoining(String sdoj);
	

}
