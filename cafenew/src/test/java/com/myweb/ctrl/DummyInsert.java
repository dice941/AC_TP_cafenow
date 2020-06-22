package com.myweb.ctrl;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.domain.NoticeVO;
import com.myweb.domain.TipVO;
import com.myweb.persistence.NoticeDAO;
import com.myweb.persistence.TipDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DummyInsert {
	private static final Logger log = LoggerFactory.getLogger(DummyInsert.class);
	
	@Inject
	private TipDAO tdao;
	@Inject
	private NoticeDAO ndao;
	
	@Test
	public void dummyTest() throws Exception{
		for(int i=0; i<234; i++) {
			TipVO tvo = new TipVO();
			tvo.setTitle(i+"번째 상품명");
			tvo.setWriter("더미 작성자"+i);
			tvo.setContent("더미 상세 내용");
			tvo.setImgfile("NONE");
			tdao.insert(tvo);
		}
	}
	
	@Test
	public void dummyNotice() throws Exception{
		for(int i=0; i<234; i++) {
			NoticeVO nvo = new NoticeVO();
			nvo.setTitle(i+"번째 공지");
			nvo.setWriter("공지 작성자"+i);
			nvo.setContent("공지 상세 내용");
			nvo.setImgfile("NONE");
			ndao.insert(nvo);
		}
	}
}
