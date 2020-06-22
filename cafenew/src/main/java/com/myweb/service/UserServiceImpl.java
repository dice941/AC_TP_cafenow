package com.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.persistence.UserDAO;
import com.myweb.domain.MemberVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public MemberVO getUserOne(String common,String col) {
		return userDAO.getUserOne(common,col);
	}

	@Override
	public int userJoin(MemberVO members) {
		return userDAO.userJoin(members);
	}
	
}