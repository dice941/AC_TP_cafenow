<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<p class="text-right mt-3">
	<a href="/notice/write" class="btn btn-outline-primary">공지사항 작성</a>
</p>
<h2>공지 목록</h2>
<table class="table table-bordered table-striped">
	<thead>
		<tr>
			<th>공지번호</th>
			<th>제목</th>
			<th>등록자</th>
			<th>조회수</th>
			<th>등록날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${list ne null && list.size() != 0 }">
				<c:forEach items="${list }" var="nvo">
					<tr>
						<td>${nvo.num }</td>
						<td><a
							href="/notice/detail?num=${nvo.num }&pageNum=${pgvo.cri.pageNum }&amount=${pgvo.cri.amount }">${nvo.title }</a></td>
						<td>${nvo.writer }</td>
						<td>${nvo.readcount }</td>
						<td>${nvo.moddate }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">
						<h5>등록된 공지가 없습니다.</h5>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
<ul class="pagination justify-content-center">
	<c:if test="${pgvo.prev }">
		<li class="page-item"><a class="page-link"
			href="/notice/list?pageNum=${pgvo.startPage-1 }&amount=${pgvo.cri.amount}">Prev</a></li>
	</c:if>
	<c:forEach var="i" begin="${pgvo.startPage }" end="${pgvo.endPage }">
		<li class="page-item ${pgvo.cri.pageNum == i ? 'active' : '' }"><a
			class="page-link"
			href="/notice/list?pageNum=${i }&amount=${pgvo.cri.amount}">${i }</a></li>
	</c:forEach>
	<c:if test="${pgvo.next }">
		<li class="page-item"><a class="page-link"
			href="/notice/list?pageNum=${pgvo.endPage+1 }&amount=${pgvo.cri.amount}">Next</a></li>
	</c:if>
</ul>
<jsp:include page="../90_footer.jsp"></jsp:include>