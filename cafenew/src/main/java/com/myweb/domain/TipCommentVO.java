package com.myweb.domain;

import java.util.Date;

public class TipCommentVO {
	private int tcno;
	private int tno;
	private String writer;
	private String content;
	private Date regd8;
	private Date modd8;
	
	public int getTcno() {
		return tcno;
	}
	public void setTcno(int tcno) {
		this.tcno = tcno;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegd8() {
		return regd8;
	}
	public void setRegd8(Date regd8) {
		this.regd8 = regd8;
	}
	public Date getModd8() {
		return modd8;
	}
	public void setModd8(Date modd8) {
		this.modd8 = modd8;
	}
}
