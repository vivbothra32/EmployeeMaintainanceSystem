package com.cg.service;

import com.cg.beans.Grade;
import com.cg.dao.GradeDao;
import com.cg.dao.GradeDaoImpl;

public class GradeServiceImpl implements GradeService {
	private GradeDao dao;
	
	public GradeServiceImpl(){
		dao = new GradeDaoImpl();
	}
	@Override
	public Grade findGrade(String grade) {
		return dao.fetchGrade(grade);
	}

}
