package com.cg.dao;

import com.cg.beans.Department;

public interface DepartmentDao {
	
	Department fetchDepartment(String deptName);

}
