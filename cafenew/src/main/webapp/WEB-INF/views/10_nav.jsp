<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="text-center mt-5">
	<a href="/">cafenow</a>
</h1>
<ul class="nav justify-content-center">
	<li class="nav-item"><a class="nav-link" href="/cafe/list">Cafe List</a></li>
	<li class="nav-item"><a class="nav-link" href="/tip/list">Tips</a></li>
	<li class="nav-item"><a class="nav-link" href="/notice/list">Notice</a></li>
	<li class="nav-item"><a class="nav-link" href="/user/login">Login</a></li>
	<li class="nav-item"><a class="nav-link" href="/user/signUp">Register</a>
	<!-- <li class="nav-item"><a id="kakao-login-btn"></a> <a href="http://developers.kakao.com/login"></a>
		<script type='text/javascript'>
			//<![CDATA[
			// 카카오 로그인 버튼을 생성합니다.
			Kakao.Auth.createLoginButton({
				container : '#kakao-login-btn', 
				size : "small",
				success : function(authObj)
				{
					alert(JSON.stringify(authObj));
				}, 
				fail : function(err)
				{
					alert(JSON.stringify(err));
				}
			});
			//]]>
		</script></li> -->
</ul>

