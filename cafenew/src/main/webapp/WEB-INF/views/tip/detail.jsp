<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2>글 상세보기</h2>
<table class="table">
	<tr>
		<th>글번호</th>
		<td>${tvo.tno }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${tvo.title }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${tvo.writer }</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${tvo.readcount }</td>
	</tr>
	<tr>
		<th>최초작성일 / 최종수정일</th>
		<td>${tvo.regd8 } / ${tvo.modd8 }</td>
	</tr>
	<tr>
		<th>이미지</th>
		<td>
			<c:choose>
				<c:when test="${!tvo.imgfile.equals('NONE') }">
					<img src="/images/${tvo.imgfile }" width="33%">
				</c:when>
				<c:otherwise>
					${tvo.imgfile }
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${tvo.content }</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="/tip/modify?tno=${tvo.tno }&pageNum=${cri.pageNum }&amount=${cri.amount }" class="btn btn-outline-warning">수정</a>
			<button type="button" class="btn btn-outline-danger" id="rmBtn">삭제</button>
			<a href="/tip/list?pageNum=${cri.pageNum }&amount=${cri.amount }" class="btn btn-outline-secondary">목록</a>
		</td>
	</tr>
</table>
<h3>댓글<span class="badge badge-primary">${tvo.commentcnt }</span></h3>
<form>
	<div class="input-group mb-3 input-group-lg">
		<div class="input-group-prepend">
			<span class="input-group-text" id="cmtWriter">${tvo.writer }</span>
		</div>
		<input type="text" class="form-control" id="cmtText" placeholder="댓글을 입력하세요!">
		<div class="input-group-append">
			<button class="btn btn-success" type="button" id="cmtSubmit">댓글전송</button>
		</div>
	</div>
</form>
<ul class="list-group list-group-flush" id="cmtListULTag"></ul>
<ul class="pagination pagination-sm justify-content-center mt-3" id="cmtListPaging"></ul>

<form action="/tip/remove" method="post" id="rmForm">
	<input type="hidden" name="tno" value="${tvo.tno }">
	<input type="hidden" name="imgfile" value="${tvo.imgfile }">
	<input type="hidden" name="pageNum" value="${cri.pageNum }">
	<input type="hidden" name="amount" value="${cri.amount }">
</form>

<script src="/resources/js/comment.js"></script>
<script>
	$(function() {
		$(document).on("click", "#rmBtn", function() {
			$("#rmForm").submit();
		});
	
		var tno = '<c:out value="${tvo.tno}" />';
		var writer = '<c:out value="${tvo.writer}" />';
		listComment(tno, 1);
		$(document).on("click", "#cmtSubmit", {tno:tno, writer:writer}, addComment);
		$(document).on("click", "#cmtListPaging li a", function(e) {
			e.preventDefault();
			let clickedPage = $(this).attr("href");
			listComment(tno, clickedPage);
		});
		var thisCno = "";
		$(document).on("click", "#modCmtBtn", function(e) {
			e.preventDefault();
			thisBtn = $(this).clone();
			thisLi = $(this).closest("li");	//소속된 라인
			thisCno = thisLi.data("tcno");
			let thisCmtTextLoc = thisLi.find(".cmtText");	//댓글 텍스트 위치
			let thisCmtContent = thisCmtTextLoc.text();	//댓글 텍스트
			
			thisCmtTextLoc.text("");
			let inTag = '<div class="input-group input-group-sm" id="modInput">';
			inTag += '<input type="text" class="form-control" ';
			inTag += 'id="cmtModText" value="'+thisCmtContent+'">';
			inTag += '<div class="input-group-append">';
			inTag += '<button class="btn btn-success" ';
			inTag += 'type="button" id="cmtModSubmit">전송</button></div></div>';
			thisCmtTextLoc.html(inTag).trigger("create");
			thisLi.find("#modCmtBtn").remove();
		});
		$(document).on("click", "#cmtModSubmit", function(e) {
			e.preventDefault();
			modVal = $("#cmtModText").val();
			modifyComment(thisCno, modVal);
		});
		$(document).on("click", "#delCmtBtn", function(e) {
			e.preventDefault();
			thisLi = $(this).closest("li");
			thisCno = thisLi.data("tcno");
			removeComment(thisCno);
			thisLi.remove();
		});
	});
	let result = '<c:out value="${result}" />';
	if (result == 'modify_ok') {
		alert("게시물 수정이 완료되었습니다~!");
	}
	result = "";
</script>

<jsp:include page="../90_footer.jsp"></jsp:include>