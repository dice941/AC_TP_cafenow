package com.myweb.domain;

public class CafeVO {
	private int cno;
	private String cname;
	private String clat;
	private String clng;
	private String addr;
	private String raddr;
	private String cphone;
	private int clstime;

	public CafeVO() {
	}

	public CafeVO(String cname, String clat, String clng, String addr, String raddr, int clstime, String cphone) {
		this.cname = cname;
		this.clat = clat;
		this.clng = clng;
		this.addr = addr;
		this.raddr = raddr;
		this.clstime = clstime;
		this.cphone = cphone;
	}

	public CafeVO(String cname, String clat, String clng, String addr, int clstime, String cphone) {
		this.cname = cname;
		this.clat = clat;
		this.clng = clng;
		this.addr = addr;
		this.clstime = clstime;
		this.cphone = cphone;
	}

	public CafeVO(String cname, String clat, String clng, String addr, int clstime) {
		this.cname = cname;
		this.clat = clat;
		this.clng = clng;
		this.addr = addr;
		this.clstime = clstime;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getClat() {
		return clat;
	}

	public void setClat(String clat) {
		this.clat = clat;
	}

	public String getClng() {
		return clng;
	}

	public void setClng(String clng) {
		this.clng = clng;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRaddr() {
		return raddr;
	}

	public void setRaddr(String raddr) {
		this.raddr = raddr;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public int getClstime() {
		return clstime;
	}

	public void setClstime(int clstime) {
		this.clstime = clstime;
	}

	public CafeVO(String cname, String clat, String clng, int clstime) {
		this.cname = cname;
		this.clat = clat;
		this.clng = clng;
		this.clstime = clstime;
	}

}
