<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="https://s-media-cache-ak0.pinimg.com/originals/fa/ea/a9/faeaa9acfef010b25b2d483ecbc8a1ab.gif">
<p>과연 아이디랑 비밀번호가 기억날 것인가</p>

<h1>로그인 ${message }</h1>
<form action="<c:url value='login'/>" method="post">
<table>
	<tr>
		<td>사용자 아이디 : </td><td><input type="text" name="userId" value="${user.userId }"></td>
	</tr>
	<tr>
		<td>비밀번호 : </td><td><input type="text" name="userPassword" value="${user.userPassword }"></td>
		<!-- 원랜 비밀번호는 수정시에 안보이는게 좋음 -->
	</tr>
	</table>
<input type="submit" value=" 로그인 하기">
<input type="reset" value=" 취소 ">

<p><a href="<c:url value='/'/>">홈으로</a></p>
</form>
</body>
</html>