<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl core 연결 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p><a href="/'">홈으로</a></p>

<h1>사용자 정보 입력</h1>

<form action="<c:url value='insert'/>" method="post">
<table>
	<tr>
		<td>사용자 아이디 : </td><td><input type="text" name="userId"></td>
	</tr>
	<tr>
		<td>이름 : </td><td><input type="text" name="userName"></td>
	</tr>
	<tr>
		<td>비밀번호 : </td><td><input type="text" name="userPassword"></td>
	</tr>
	
	<!-- 만약 서버에서 비밀번호를 확인받는다면 VO에 코딩 설정 -->
	
	<tr>
		<td>권한 : </td><td><input type="text" name="userRole"></td>
	</tr>
</table>

<input type="submit" value="저장" >
<input type="reset" value="취소" >
</form>


</body>
</html>