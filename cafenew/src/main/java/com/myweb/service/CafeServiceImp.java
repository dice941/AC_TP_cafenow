package com.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myweb.domain.CafeVO;
import com.myweb.domain.Criteria;
import com.myweb.persistence.CafeDAO;

public class CafeServiceImp implements CafeService {
	private static final Logger log = LoggerFactory.getLogger(CafeServiceImp.class);

	
	@Inject
	private CafeDAO cdao;
	
	@Override
	public void write(CafeVO cvo) {
		
	}

	@Override
	public List<CafeVO> list(Criteria cri) {
		return null;
	}

	@Override
	public CafeVO detail(Integer cno) {
		return null;
	}

	@Override
	public void modify(CafeVO cvo) {
		
	}

	@Override
	public void remove(Integer cno) {
		
	}

	@Override
	public void removeImg(Integer cno) {
		
	}

	@Override
	public int totalCount() {
		return 0;
	}
}
