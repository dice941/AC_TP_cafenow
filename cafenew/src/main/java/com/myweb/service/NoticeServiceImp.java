package com.myweb.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.domain.Criteria;
import com.myweb.domain.NoticeVO;
import com.myweb.persistence.NoticeDAO;

@Service
public class NoticeServiceImp implements NoticeService {
	@Inject
	private NoticeDAO ndao;
	
	@Override
	public void write(NoticeVO nvo) {
		ndao.insert(nvo);
	}

	@Override
	public List<NoticeVO> list(Criteria cri) {
		return ndao.selectList(cri);
	}

	@Override
	public NoticeVO detail(Integer num) {
		return ndao.selectOne(num);
	}

	@Override
	public void modify(NoticeVO nvo) {
		ndao.update(nvo);
	}

	@Override
	public void remove(Integer num) {
		ndao.delete(num);
	}

	@Override
	public void removeImg(Integer num) {
		ndao.deleteImg(num);
	}

	@Override
	public int totalCount() {
		return ndao.selectOne();
	}
}
