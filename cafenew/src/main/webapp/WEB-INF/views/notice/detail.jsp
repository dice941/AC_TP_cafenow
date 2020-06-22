<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2 class="mt-3">공지 내용 상세</h2>
<table class="table">
	<tr>
		<th>공지번호</th>
		<td>${nvo.num }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${nvo.title }</td>
	</tr>
	<tr>
		<th>등록자</th>
		<td>${nvo.writer }</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${nvo.readcount }</td>
	</tr>
	<tr>
		<th>최종수정일</th>
		<td>${nvo.moddate }</td>
	</tr>
	<tr>
		<th>공지 이미지</th>
		<td><c:choose>
				<c:when test="${!nvo.imgfile.equals('NONE') }">
					<img src="/images/${nvo.imgfile }" width="33%">
				</c:when>
				<c:otherwise>
					${nvo.imgfile }
				</c:otherwise>
			</c:choose></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${nvo.content }</td>
	</tr>
	<tr>
		<td colspan="2"><a href="/notice/modify?num=${nvo.num }&pageNum=${cri.pageNum }&amount=${cri.amount }" class="btn btn-outline-warning">수정</a>
			<button type="button" class="btn btn-outline-danger" id="rmBtn">삭제</button> <a href="/notice/list?pageNum=${cri.pageNum }&amount=${cri.amount }" class="btn btn-outline-secondary">목록</a></td>
	</tr>
</table>
<form action="/notice/remove" method="post" id="rmForm">
	<input type="hidden" name="num" value="${nvo.num }"> <input type="hidden" name="imgfile" value="${nvo.imgfile }"> <input type="hidden" name="pageNum" value="${cri.pageNum }"> <input type="hidden" name="amount" value="${cri.amount }">
</form>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script>
	$(function()
	{
		$(document).on("click", "#rmBtn", function()
		{
			$("#rmForm").submit();
		});
	});

	let result = '<c:out value="${result}" />';
	if (result == 'modify_ok')
	{
		alert("공지 수정이 완료되었습니다.");
	}
	result = "";
</script>

<jsp:include page="../90_footer.jsp"></jsp:include>