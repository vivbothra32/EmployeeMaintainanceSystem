package com.cg.service;

import com.cg.beans.Department;
import com.cg.dao.DepartmentDao;
import com.cg.dao.DepartmentDaoImpl;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao dao;
	
	public DepartmentServiceImpl() {
		dao = new DepartmentDaoImpl();
	}
	@Override
	public Department findDepartment(String dname) {
		return dao.fetchDepartment(dname);
	}
	

}
