<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="https://m.popkey.co/d4fa7b/3RNK5.gif">
<p>사실은 메타몽이다ㅏㅏㅏㅏㅏㅏㅏㅏ</p>

<h1>회원 정보</h1>
아이디 : ${user.userId }<br>
이름 : ${user.userName }<br>
비밀번호 : ${user.userPassword }<br>
권한 : ${user.userRole }<br>
<a href="update">수정</a>
<a href="list">회원 목록</a>
<a href="delete">탈퇴</a>
<a href="logout">로그아웃</a>

</body>
</html>