<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2>제보 작성</h2>
<form method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="title">제목 : </label>
		<input type="text" class="form-control" placeholder="제목" id="title" name="title">
	</div>
	<div class="form-group">
		<label for="title">작성자 : </label>
		<input type="text" class="form-control" placeholder="작성자" id="writer" name="writer">
	</div>
	<div class="form-group">
		<label for="content">내용 : </label>
		<textarea class="form-control" rows="5" id="content" name="content"></textarea>
	</div>
	<div class="form-group">
		<label for="file">파일 첨부 : </label>
		<input type="file" class="form-control-file border" id="imgfile" name="imgfile">
	</div>
	<button type="submit" class="btn btn-primary">등록</button>
</form>

<jsp:include page="../90_footer.jsp"></jsp:include>