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

<img src="https://68.media.tumblr.com/9e9c3f70954ac563e568e0f4001e481a/tumblr_n3467rgV0O1trtuzvo1_500.gif">
<p>정보를 수정합니다ㅏㅏ</p>

<h1>사원 정보 수정</h1>
<form action="update" method="post">
<table>
	<tr>
		<td>사용자 아이디 : </td><td><input type="text" name="userId" value="${user.userId }" readonly></td>
		<!-- readonly를 해주면 읽어오기만 함 그러니까 정보 수정이 안되는 곳에 적용!! -->
	</tr>
	<tr>
		<td>이름 : </td><td><input type="text" name="userName" value="${user.userName }"></td>
	</tr>
	<tr>
		<td>비밀번호 : </td><td><input type="text" name="userPassword" value="${user.userPassword }"></td>
	</tr>
	<tr>
		<td>권한 : </td><td><input type="text" name="userRole" value="${user.userRole }"></td>
	</tr>
</table>
<input type="submit" value=" 저장 ">
<input type="reset" value=" 취소 ">

<a href="view">현재 내 정보</a>
</form>

</body>
</html>