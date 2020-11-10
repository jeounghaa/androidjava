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
	$('#b1').click(function() {
		bid2 = $('#bid').val()
		$.ajax({
			url: "json6.do",
			data: {
				no: bid2
			},
			success: function(result) {
				console.log(result)
				for (var i = 0; i < result.length; i++) {
					no = result[i].no
					title = result[i].title
					content = result[i].content
					writer = result[i].writer
					list = no + ", " + title + ", " + content + ", " + writer + "<br>"
					$('#d1').append(list)
				}
			} // success end
		}) // ajax end
	}) // click end
}) // function end
</script>
</head>
<body>
검색할 번호:<input type="text" id="bid">
<button type="submit" id="b1">검색</button>
<div id="d1">
</div>
</body>
</html>