package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.CafeVO;

public interface CafeDAO {
	public void insert(CafeVO cvo);

	public List<CafeVO> selectList(Criteria cri);

	public CafeVO selectOne(Integer cno);

	public void update(CafeVO cvo);

	public void delete(Integer cno);

	public int selectOne();
}
