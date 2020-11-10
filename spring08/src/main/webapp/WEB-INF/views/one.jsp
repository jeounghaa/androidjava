<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#reply').click(function() {
			contentValue = $('#content').val()
			$.ajax({
				url: "create.do",
				data: {
					content: contentValue,
					original: '${one.no}', // one.get~~
					writer: '${id}'
				},
				success: function(result) {
					// alert(result)
					$('#tab').append(result)
					location.reload()
					$('#test').html('${one.no}')
				}
			})
		})
	})
</script>
</head>
<body>
<h3>게시물 하나 검색화면</h3>
<table border="1">
	<tr>
		<th width="100">no</th>
		<th width="100">title</th>
		<th width="100">content</th>
		<th width="100">writer</th>
	</tr>
	<tr>
		<td height="50">${one.no}</td>
		<td>${one.title}</td>
		<td>${one.content}</td>
		<td id="test">${one.writer}</td>
	</tr>
</table>
<hr color="red">
<input type="text" id="content"><button id="reply">댓글달기</button>
	<div id="d1">
	<table border="1" style="background: lightgray" id="tab">
		<c:forEach items="${list}" var="vo" varStatus="status">
		<!-- ${status.index + 1}: 순번찍기 -->
		<!-- ${total - status.index}: 역순찍기 -->
			<tr>
				<td width="100">${status.index + 1}</td>
				<td width="200">${vo.content }</td>
				<td width="100">${vo.writer }</td>
				<td><!-- one.no, vo.original -->
					<a href="delete3.do?no=${vo.no}&original=${vo.original}">
						<button style="background: orange">삭제</button>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>