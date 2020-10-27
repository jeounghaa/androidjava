<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/out.css">
<script src="resources/js/jquery-3.5.1.js"></script>
<script>
$(function() { // dom tree로딩후
	//alert("환영합니다.")
	// 아이디 중복 확인
	$('#b1').click(function() {
		idValue = $('#idid').val()
		$.ajax({
			url: "idid.do",
			data: {
				idid: idValue
			},
			success: function(result) {
				$('#d1').html(result)
			}
		})
	})
	$('#b2').click(function() {
		replyValue = $('#reply').val()
		$.ajax({
			url: "reply.do",
			data: {
				reply: replyValue
			},
			success: function(result) {
				//alert(result)
				$('#d2').append(result)
			}
		})
	})
})
</script>
</head>
<body>
<form action="movie.do">
영화제목: <input type="text" name="title"><br>
영화관람료: <input type="text" name="price"><br>
<button type="submit">확인</button>
</form>
<hr color="blue">
아이디: <input type="text" id="idid">
<button id="b1">아이디 중복확인</button>
<hr>
<div id="d1"></div>
<hr color="red">
댓글: <input type="text" id="reply">

<button id="b2">댓글달기</button>
<hr color="blue">
<div id="d2"></div>
</body>
</html>