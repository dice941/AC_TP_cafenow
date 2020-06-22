package com.myweb.service;

import java.util.List;

import com.myweb.domain.CafeVO;
import com.myweb.domain.Criteria;

public interface CafeService {
	public void write(CafeVO cvo);
	public List<CafeVO> list(Criteria cri);
	public CafeVO detail(Integer cno);
	public void modify(CafeVO cvo);
	public void remove(Integer cno);
	public void removeImg(Integer cno);
	public int totalCount();
}
