package com.myweb.service;

import com.myweb.domain.Criteria;
import com.myweb.domain.TipCommentDTO;
import com.myweb.domain.TipCommentVO;

public interface TipCmtService {
	boolean write(TipCommentVO tcvo);
	TipCommentDTO list(int tno, Criteria cri);
	int modify(TipCommentVO tcvo);
	int remove(int tcno);
}
