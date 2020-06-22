package com.myweb.service;

import com.myweb.domain.MemberVO;

public interface UserService {

	MemberVO getUserOne(String common, String col);

	int userJoin(MemberVO members);

}