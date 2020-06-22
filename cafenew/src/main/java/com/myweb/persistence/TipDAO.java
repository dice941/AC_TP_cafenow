package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.TipVO;

public interface TipDAO {
	public void insert(TipVO tvo);
	public List<TipVO> selectList(Criteria cri);
	public TipVO selectOne(Integer tno);
	public void update(TipVO tvo);
	public void delete(Integer tno);
	public void deleteImg(Integer tno);
	public int selectOne(Criteria cri);
	public int update(Integer tno, Integer sign);
	public void update(Integer tno);
}
