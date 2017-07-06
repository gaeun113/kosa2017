<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="http://31.media.tumblr.com/159d2e8e1f034446d0c2b5665d049cdb/tumblr_myopxjk4AH1rsrk2xo3_500.gif">
<h1>관리자만 보는 목록 도착</h1>

<a href="view">관리자 정보</a>

<table border=1>
<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>비밀번호</th>
	<th>권한</th>
</tr>

<c:forEach var="user" items="${userList }">
<tr>
	<td>${user.userId}</td>
	<td>${user.userName }</td>
	<td>${user.userPassword }</td>
	<td>${user.userRole }</td>
</tr>
</c:forEach>
</table>

</body>
</html>