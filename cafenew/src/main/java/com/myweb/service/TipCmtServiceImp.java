package com.myweb.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.domain.Criteria;
import com.myweb.domain.TipCommentDTO;
import com.myweb.domain.TipCommentVO;
import com.myweb.persistence.TipCmtDAO;
import com.myweb.persistence.TipDAO;

@Service
public class TipCmtServiceImp implements TipCmtService {
	private static final Logger log = LoggerFactory.getLogger(TipCmtServiceImp.class);
	
	@Inject
	private TipCmtDAO tcdao;
	@Inject
	private TipDAO tdao;
	
	@Transactional
	@Override
	public boolean write(TipCommentVO tcvo) {
		int isOk = tcdao.insert(tcvo);
		int isUp = tdao.update(tcvo.getTno(), 1);
		return isOk == isUp;
	}

	@Override
	public TipCommentDTO list(int tno, Criteria cri) {
		return new TipCommentDTO(tcdao.selectOne(tno), tcdao.selectList(tno, cri));
	}

	@Override
	public int modify(TipCommentVO tcvo) {
		return tcdao.update(tcvo);
	}

	@Override
	public int remove(int tcno) {
		int tno = tcdao.SelectTno(tcno);
		int isRm = tcdao.delete(tcno);
		int isDown = tdao.update(tno, -1);
		return isRm*tno*isDown;
	}
}
