package com.myweb.service;

import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.NoticeVO;

public interface NoticeService {
	public void write(NoticeVO nvo);
	public List<NoticeVO> list(Criteria cri);
	public NoticeVO detail(Integer num);
	public void modify(NoticeVO nvo);
	public void remove(Integer num);
	public void removeImg(Integer num);
	public int totalCount();
}
