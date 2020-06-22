package com.myweb.persistence;

import java.util.List;

import com.myweb.domain.Criteria;
import com.myweb.domain.NoticeVO;

public interface NoticeDAO {
	public void insert(NoticeVO nvo);
	public List<NoticeVO> selectList(Criteria cri);
	public NoticeVO selectOne(Integer num);
	public void update(NoticeVO nvo);
	public void delete(Integer num);
	public void deleteImg(Integer num);
	public int selectOne();
}
