package com.myweb.domain;

import java.util.List;

public class TipCommentDTO {
	private int commentcnt;
	private List<TipCommentVO> list;
	
	public TipCommentDTO() {}

	public TipCommentDTO(int commentcnt, List<TipCommentVO> list) {
		this.commentcnt = commentcnt;
		this.list = list;
	}
	
	public int getCommentcnt() {
		return commentcnt;
	}
	
	public void setCommentcnt(int commentcnt) {
		this.commentcnt = commentcnt;
	}
	
	public List<TipCommentVO> getList() {
		return list;
	}
	
	public void setList(List<TipCommentVO> list) {
		this.list = list;
	}
}
