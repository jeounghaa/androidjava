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
	$.ajax({
		url: "json2.do",
		dataType: "json",
		success: function(result) {
			console.log(result)
			for (var i = 0; i < result.length; i++) {
				id = result[i].no;
				pw = result[i].title;
				name = result[i].content;
				tel = result[i].writer;
				$('#d1').append(id + ", " + pw + ", " + name + ", " + tel)
			}
			
		}
	})
})
</script>
</head>
<body>
<div id="d1">
</div>
</body>
</html>