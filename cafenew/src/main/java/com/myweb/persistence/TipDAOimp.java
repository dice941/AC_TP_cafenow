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
import com.myweb.domain.TipVO;

@Repository
public class TipDAOimp implements TipDAO {
	private static final Logger log = LoggerFactory.getLogger(TipDAOimp.class);
	private static String ns = "TipMapper.";

	@Inject
	private SqlSession sql;
	
	@Override
	public void insert(TipVO tvo) {
		sql.insert(ns+"add", tvo);
	}

	@Override
	public List<TipVO> selectList(Criteria cri) {
		return sql.selectList(ns+"list", cri);
	}

	@Override
	public TipVO selectOne(Integer tno) {
		return sql.selectOne(ns+"detail", tno);
	}

	@Override
	public void update(TipVO tvo) {
		sql.update(ns+"modify", tvo);
	}

	@Override
	public void delete(Integer tno) {
		sql.delete(ns+"remove", tno);
	}

	@Override
	public void deleteImg(Integer tno) {
		Map<String, Object> map = new HashMap<>();
		map.put("tno", tno);
		map.put("imgfile", "NONE");
		sql.update(ns+"rmImg", map);
	}
	
	@Override
	public int update(Integer tno, Integer sign) {
		Map<String, Object> map = new HashMap<>();
		map.put("tno", tno);
		map.put("sign", sign);
		return sql.update(ns+"upCount", map);
	}

	@Override
	public int selectOne(Criteria cri) {
		return sql.selectOne(ns+"total", cri);
	}

	@Override
	public void update(Integer tno) {
		sql.update(ns+"upReadCount", tno);
	}
}
