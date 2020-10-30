<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원검색</h3>
<form action="one2.do">
id: <input type="text" name="id"><br>
<button type="submit">확인</button>
</form>
<a href="list2.do">전체 회원 검색</a>

<br><br>
<hr>
<h3>회원등록</h3>
<form action="create2.do">
id: <input type="text" name="id"><br>
pw: <input type="text" name="pw"><br>
name: <input type="text" name="name"><br>
tel: <input type="text" name="tel"><br>
<button type="submit">확인</button>
</form>

<br>
<hr>
<h3>회원삭제</h3>
<form action="delete2.do">
id: <input type="text" name="id"><br>
<button type="submit">확인</button>
</form>

<br>
<hr>
<h3>회원수정</h3>
<form action="update2.do">
id: <input type="text" name="id"><br>
tel: <input type="text" name="tel"><br>
<button type="submit">확인</button>
</form>

</body>
</html>