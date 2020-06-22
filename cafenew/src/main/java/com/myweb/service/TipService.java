package com.myweb.service;

import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.TipVO;

public interface TipService {
	public void write(TipVO tvo);
	public List<TipVO> list(Criteria cri);
	public TipVO detail(Integer tno);
	public void modify(TipVO tvo);
	public void remove(Integer tno);
	public void removeImg(Integer tno);
	public int totalCount(Criteria cri);
}
