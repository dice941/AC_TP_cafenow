package com.myweb.domain;

public class PagingVO {
	private int totalCnt;	//총 글의 개수
	private Criteria cri;	//데이터베이스로부터 글의 범위를 가져오기 위한 기준을 담는 객체
	private int startPage;	//10개의 페이징 중 페이징 시작번호
	private int endPage;	//10개의 페이징 중 페이징 끝번호
	private boolean prev, next;
	
	public PagingVO() {}
	
	public PagingVO(int totalCnt, Criteria cri) {
		this.totalCnt = totalCnt;
		this.cri = cri;
		//14(찍은 페이징 번호) / 10.0 = 1.4 -> (최대정수화) -> 2*10 = 20 (페이징 14번이 갖는 범위의 끝번호가 20이 됨)
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		//끝번호에서 9를 빼면 무조건 시작번호
		this.startPage = endPage-9;
		//데이터베이스에서 실제 글의 총 갯수를 가져와서 한페이지에 보여줄 글수로 나누고 최대정수화
		int realEndPage = (int)(Math.ceil((totalCnt*1.0)/cri.getAmount()));
		//실제 가질 수 있는 페이징의 최대 번호가 계산된 페이징 마지막 번호보다 클 수 없음 -> 실제 번호로 맞춤
		if(realEndPage <= this.endPage) {
			this.endPage = realEndPage;
		}
		//이전으로 가기 버튼은 페이징 시작 번호가 1보다 크면 무조건 나옴
		this.prev = this.startPage > 1;
		//다음으로 가기 버튼은 실제 가질 수 있는 페이징의 번호보다 계산된 페이징 마지막 번호가 작으면 무조건 나옴
		this.next = this.endPage < realEndPage;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
}