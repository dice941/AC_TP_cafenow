package com.myweb.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myweb.domain.Criteria;
import com.myweb.domain.NoticeVO;

@Repository
public class NoticeDAOImp implements NoticeDAO {
	private static String ns = "NoticeMapper.";
	
	@Inject
	private SqlSession sql;
	
	@Override
	public void insert(NoticeVO nvo) {
		sql.insert(ns+"add", nvo);
	}

	@Override
	public List<NoticeVO> selectList(Criteria cri) {
		return sql.selectList(ns+"list", cri);
	}

	@Override
	public NoticeVO selectOne(Integer num) {
		return sql.selectOne(ns+"detail", num);
	}

	@Override
	public void update(NoticeVO nvo) {
		sql.update(ns+"modify", nvo);
	}

	@Override
	public void delete(Integer num) {
		sql.delete(ns+"remove", num);
	}

	@Override
	public void deleteImg(Integer num) {
		Map<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("imgfile", "NONE");
		sql.update(ns+"rmImg", map);
	}

	@Override
	public int selectOne() {
		return sql.selectOne(ns+"total");
	}
}
