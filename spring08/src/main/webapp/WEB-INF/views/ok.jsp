<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<tr>
	<td width="100">${status.index + 1}</td>
	<td width="200">${replyVO.content }</td>
	<td width="100">${replyVO.writer }</td>
	<td><!-- one.no, vo.original -->
		<a href="delete3.do?no=${replyVO.no}&original=${replyVO.original}">
			<button style="background: orange">삭제</button>
		</a>
	</td>
</tr>