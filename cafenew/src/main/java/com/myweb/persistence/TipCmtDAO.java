package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.TipCommentVO;

public interface TipCmtDAO {
	int insert(TipCommentVO tcvo);
	List<TipCommentVO> selectList(Integer tno, Criteria cri);
	int update(TipCommentVO tcvo);
	int delete(Integer tcno);
	int selectOne(Integer tno);
	int SelectTno(Integer tcno);
}
