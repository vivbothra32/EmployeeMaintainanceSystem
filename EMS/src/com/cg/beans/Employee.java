package com.cg.beans;

import java.util.Date;

public class Employee {
	private String empId;
	private String firstName;
	private String lastname;
	private Date dateOfBirth;
	private Date dateOfJoining;
	private Department empDept;
	private Grade empGrade;
	private double basic;
	private String gender;
	private String maritalStatus;
	private String homeAddress;
	private String contactNo;
	private String mgrId;
	
	public Employee() {
		
	}
	public Employee(String empId, String firstName, String lastname, Date dateOfBirth, Date dateOfJoining,
			Department empDept, Grade empGrade, double basic, String gender, String maritalStatus, String homeAddress,
			String contactNo, String mgrId) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.empDept = empDept;
		this.empGrade = empGrade;
		this.basic = basic;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.homeAddress = homeAddress;
		this.contactNo = contactNo;
		this.mgrId = mgrId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public Department getEmpDept() {
		return empDept;
	}
	public void setEmpDept(Department empDept) {
		this.empDept = empDept;
	}
	public Grade getEmpGrade() {
		return empGrade;
	}
	public void setEmpGrade(Grade empGrade) {
		this.empGrade = empGrade;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getMgrId() {
		return mgrId;
	}
	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}
	
}
