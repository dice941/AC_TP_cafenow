<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2>공지 수정하기</h2>
<form action="/notice/modify" method="post" enctype="multipart/form-data">
<input type="hidden" name="imgfile" value="${nvo.imgfile }">
<input type="hidden" name="pageNum" value="${cri.pageNum }">
<input type="hidden" name="amount" value="${cri.amount }">
	<table class="table table-bordered">
		<tr>
			<th>공지번호</th>
			<td><input type="text" name="num" value="${nvo.num }" readonly class="form-control"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${nvo.title }" class="form-control"></td>
		</tr>
		<tr>
			<th>등록자</th>
			<td>${nvo.writer }</td>
		</tr>
		<tr>
			<th>최종수정일</th>
			<td>${nvo.moddate }</td>
		</tr>
		<tr>
			<th>공지 이미지</th>
			<td id="imgzone">
				<c:choose>
					<c:when test="${!nvo.imgfile.equals('NONE') }">
						<img src="/images/${nvo.imgfile }" width="33%">
					</c:when>
					<c:otherwise>
						${nvo.imgfile }
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>공지 이미지 수정</th>
			<td><input class="form-control" type="file" name="new_imgfile" value="${nvo.imgfile }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" rows="5" name="content">${nvo.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" class="text-center">
				<button type="submit" class="btn btn-primary">수정</button>
			</td>
		</tr>
	</table>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function(){
		$(document).on("click", "img", function(){
			let innum = '<c:out value="${nvo.num}" />';
			let inimgfile = '<c:out value="${pvo.imgfile}" />';
			if(confirm("삭제하시겠습니까?")){
				$.ajax({
					url: "/notice/rmimg",
					type: "POST",
					data: {num: innum, imgfile: inimgfile}
				}).done(function(result) {
					alert("이미지 삭제에 성공했습니다!");
					$("img").remove();
					$("#imgzone").append().text("NONE");
					location.replace("/notice/detail?num="+innum);
				}).fail(function() {
					alert("이미지 삭제에 실패했습니다!");
				}).always(function() {
					//location.replace("/product/detail?pno="+inpno);
				});
			}else{
				
			}
		});
	});
</script>

<jsp:include page="../90_footer.jsp"></jsp:include>