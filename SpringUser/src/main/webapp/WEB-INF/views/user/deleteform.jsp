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

<img src="http://3.bp.blogspot.com/-jWQ07Dv4JTk/UueOL4EG3xI/AAAAAAAAAhY/rMtiNze8HCY/s256/tumblr_mv2wbnAgFG1skql9vo1_r1_500.gif">
<img src="https://68.media.tumblr.com/f519f6e70d11e91979f74f1a36ba1485/tumblr_inline_o8hhq3Mbew1tcruhx_500.gif">
<p>탈퇴하지 마세용ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</p>

<h1>회원 정보 삭제</h1>
<form action="<c:url value='delete'/>" method="post">
<table>
	<tr>
		<td>사용자 아이디 : </td><td><input type="text" name="userId" value="${user.userId }" readonly></td>
	</tr>
	<tr>
		<td>비밀번호 : </td><td><input type="text" name="userPassword" value="${user.userPassword }"></td>
	</tr>
</table>
<input type="submit" value="삭제" >

<a href="view">현재 내 정보</a>
</form>

</body>
</html>