<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#qrmk').click(function() {
		formData = $('#ddd').serialize();
		alert(formData);
		/* $.ajax({
			url: "qrCode.do",
			data: formData,
			success: function() {
				alert("생성.....")
			}
		})  */
		
		
	})
})
</script>
</head>
<body>
<h3>회원 등록 정보입니다.</h3>
<form action="" id="ddd">
회원 id: ${memberVO.id} 
회원 pw: ${memberVO.pw}
회원 name: ${memberVO.name} 
회원 tel: ${memberVO.tel}
<button id="qrmk"></button>
</form>
</body>
</html>