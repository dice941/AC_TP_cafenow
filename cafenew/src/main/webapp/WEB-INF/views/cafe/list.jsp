<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2 class="float-left">
	카페 목록<a href="/cafe/write" class="btn btn-outline-primary">카페등록</a>
</h2>
<div class="float-right form-group">
	<form class="form-inline" action="/cafe/list">
		<select class="form-control" name="type">
			<option value="TCW">검색범위</option>
			<option value="T">카페이름</option>
			<option value="W">주소</option>
			<option value="C">내용</option>
			<option value="TW">카페이름or주소</option>
			<option value="TC">카페이름or내용</option>
			<option value="CW">주소or내용</option>
		</select> 
		<input type="text" class="form-control" placeholder="Search" name="keyword"> 
		<input type="hidden" name="pageNum" value="1"> 
		<input type="hidden" name="amount" value="<c:out value='${pgvo.cri.amount }' />">
		<div class="input-group-append">
			<button class="btn btn-success" type="submit">검색</button>
		</div>
	</form>
</div>
<table class="table table-bordered table-striped">
	<thead>
		<tr>
			<th>장소번호</th>
			<th>카페이름</th>
			<th>도로명주소</th>
			<%-- RADDR --%>
			<th>지번주소</th>
			<%-- ADDR --%>
			<th>24시간여부</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${list ne null && list.size() != 0 }">
				<c:forEach items="${list }" var="cvo">
					<tr>
						<td>${cvo.cno }</td>
						<td><a href="/cafe/detail?cno=${cvo.cno }&pageNum=${pgvo.cri.pageNum }&amount=${pgvo.cri.amount }">${cvo.title }</a></td>
						<td>${cvo.address }</td>
						<td>${cvo.status }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">
						<h5>등록된 카페가 없습니다.</h5>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<ul class="pagination justify-content-center">
	<c:if test="${pgvo.prev }">
		<li class="page-item"><a class="page-link" href="/product/list?pageNum=${pgvo.startPage - 1 }&amount=${pgvo.cri.amount }">Prev</a></li>
	</c:if>
	<c:forEach var="i" begin="${pgvo.startPage }" end="${pgvo.endPage }">
		<li class="page-item ${pgvo.cri.pageNum == i ? 'active' : '' }"><a class="page-link" href="/product/list?pageNum=${i }&amount=${pgvo.cri.amount }">${i }</a></li>
	</c:forEach>
	<c:if test="${pgvo.next }">
		<li class="page-item"><a class="page-link" href="/product/list?pageNum=${pgvo.endPage + 1 }&amount=${pgvo.cri.amount }">Next</a></li>
	</c:if>
</ul>

<script>
	let result = '<c:out value="${result}" />';
	if (result == 'write_ok')
	{
		alert("카페 등록이 완료되었습니다.");
	}
	else if (result == 'remove_ok')
	{
		alert("카페 삭제가 완료되었습니다.");
	}
	result = ""; //재사용을 위한 초기화
</script>

<jsp:include page="../90_footer.jsp"></jsp:include>