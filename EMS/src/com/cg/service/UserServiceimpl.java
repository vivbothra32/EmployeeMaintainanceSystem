package com.cg.service;

import com.cg.beans.User;
import com.cg.dao.UserDao;
import com.cg.dao.UserDaoImpl;

public class UserServiceimpl implements UserService {
	private UserDao dao;
	public UserServiceimpl() {
		dao = new UserDaoImpl();
	}
	@Override
	public User validateUser(User user) {
		System.out.println("In User Service Impl");
		return dao.validateLogin(user);
	}

}
