<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2>게시물 수정하기</h2>
<form action="/tip/modify" method="post" enctype="multipart/form-data">
<input type="hidden" name="imgfile" value="${tvo.imgfile }">
<input type="hidden" name="pageNum" value="${cri.pageNum }">
<input type="hidden" name="amount" value="${cri.amount }">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="tno" value="${tvo.tno }" readonly class="form-control"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${tvo.title }" class="form-control"></td>
		</tr>
		<tr>
			<th>등록자</th>
			<td>${tvo.writer }</td>
		</tr>
		<tr>
			<th>최종수정일</th>
			<td>${tvo.modd8 }</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td id="imgzone">
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
			<th>이미지 수정</th>
			<td><input class="form-control" type="file" name="new_imgfile" value="${tvo.imgfile }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" rows="5" name="content">${tvo.content }</textarea></td>
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
			let innum = '<c:out value="${tvo.tno}" />';
			let inimgfile = '<c:out value="${tvo.imgfile}" />';
			if(confirm("삭제하시겠습니까?")){
				$.ajax({
					url: "/tip/rmimg",
					type: "POST",
					data: {num: innum, imgfile: inimgfile}
				}).done(function(result) {
					alert("이미지 삭제에 성공했습니다!");
					$("img").remove();
					$("#imgzone").append().text("NONE");
					location.replace("/tip/detail?num="+innum);
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