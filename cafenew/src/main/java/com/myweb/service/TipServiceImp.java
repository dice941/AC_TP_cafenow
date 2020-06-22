package com.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.domain.Criteria;
import com.myweb.domain.TipVO;
import com.myweb.persistence.TipDAO;

@Service
public class TipServiceImp implements TipService {
	@Inject
	private TipDAO tdao;
	
	@Override
	public void write(TipVO tvo) {
		tdao.insert(tvo);
	}

	@Override
	public List<TipVO> list(Criteria cri) {
		return tdao.selectList(cri);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public TipVO detail(Integer tno) {
		tdao.update(tno);
		return tdao.selectOne(tno);
	}

	@Override
	public void modify(TipVO tvo) {
		tdao.update(tvo);
	}

	@Override
	public void remove(Integer tno) {
		tdao.delete(tno);
	}

	@Override
	public void removeImg(Integer tno) {
		tdao.deleteImg(tno);
	}

	@Override
	public int totalCount(Criteria cri) {
		return tdao.selectOne(cri);
	}
}
