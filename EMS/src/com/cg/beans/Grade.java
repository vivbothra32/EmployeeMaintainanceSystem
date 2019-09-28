package com.cg.beans;

public class Grade {
	private String code;
	private String description;
	private double minSalary;
	private double maxSalary;
	
	public Grade() {
		
	}
	
	public Grade(String code, String description, double minSalary, double maxSalary) {
		this.code = code;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}
	public double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}
	
}
