package com.cg.beans;
//edited
public class Department {
	private int id;
	private String dname;
	public Department() {
		
	}
	
	public Department(int id, String dname) {
		this.id = id;
		this.dname = dname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	//add toString() method	
}
