package com.myweb.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.myweb.domain.Criteria;
import com.myweb.domain.TipCommentVO;

@Repository
public class TipCmtDAOImp implements TipCmtDAO {
	private static final Logger log = LoggerFactory.getLogger(TipCmtDAOImp.class);
	private static String ns = "TipCmtMapper.";
	
	@Inject
	private SqlSession sql;
	
	@Override
	public int insert(TipCommentVO tcvo) {
		return sql.insert(ns+"add", tcvo);
	}

	@Override
	public List<TipCommentVO> selectList(Integer tno, Criteria cri) {
		Map<String, Object> map = new HashMap<>();
		map.put("tno", tno);
		map.put("cri", cri);
		return sql.selectList(ns+"list", map);
	}

	@Override
	public int update(TipCommentVO tcvo) {
		return sql.update(ns+"modify", tcvo);
	}

	@Override
	public int delete(Integer tcno) {
		return sql.delete(ns+"remove", tcno);
	}

	@Override
	public int selectOne(Integer tno) {
		return sql.selectOne(ns+"total", tno);
	}

	@Override
	public int SelectTno(Integer tcno) {
		return sql.selectOne(ns+"getTno", tcno);
	}
}
