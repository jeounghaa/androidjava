<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	// 콜백함수(call-back)함수
	// 특정한 이벤트를 기다렸다가 그 이벤트가 발생하면
	// 함수가 정의되어있는 곳으로 돌아가 자동 호출되는 함수
	// body의 하위 엘리먼트를 먼저 브라우저가 dom-tree를 구성한 후
	// 콜백함수를 정의하게 되어있음
	// 브라우저가 스크립트를 먼저 실행하고 인식하는것이 아니라 
	// body부분을 먼저 읽어서 dom-tree를 만들도록 해야함
	$(function() {
		$('#b1').click(function() { // b1버튼을 클릭하면
			$.ajax({ // 실행
				url: "data/member.xml", // 입력한 url파일을 가져옴
				success: function(doc) { // 가져오는것을 성공하면
					console.log('XML요청 성공') // console에 출력
					console.log('XML결과: ' + doc) // console에 가져온 결과 출력
					list = $(doc).find('record') // 파일의 record 값들을 list라는 변수에 저장
					console.log('레코드의 개수: ' + list.length) // console에 list의 개수 출력
					if (list.length > 0) { // list의 개수가 0보다 크면
						$(list).each(function(index, item) { // list의 값을 하나씩 꺼내옴
							id = $(item).find('id').text() // list의 id값의 텍스트를 변수에 저장
							first_name = $(item).find('first_name').text() // first_name값의 텍스트를 변수에 저장
							last_name = $(item).find('last_name').text() // last_name값의 텍스트를 변수에 저장
							email = $(item).find('email').text() // email값의 텍스트를 변수에 저장
							gender = $(item).find('gender').text() // gender값의 텍스트를 변수에 저장
							ip_address = $(item).find('ip_address').text() // ip_address값의 텍스트를 변수에 저장
							total = 'id: ' + id + 
								', first_name: ' + first_name + 
								', last_name: ' + last_name + 
								', email: ' + email + 
								', gender: ' + gender + 
								', ip_address: ' + ip_address // total이라는 변수에 가져온 값들을 저장
							$('#d1').append(total + '<br>') // d1이라는 div태그에 total 출력
							$.ajax({ // 실행
								url: 'db1.jsp', // url파일을 가져옴
								data: { // 가져올 데이터
									id: id, // id값을 가져옴
									first_name: first_name, // first_name값을 가져옴
									last_name: last_name, // last_name값을 가져옴
									email: email, // email값을 가져옴
									gender: gender, // gender값을 가져옴
									ip_address: ip_address // ip_address값을 가져옴
								},
								success: function(result) { // url파일을 가져오는데 성공하면
									console.log('db1.jsp를 통해서 db에 넣기-성공적으로 전송함') // console에 출력
									console.log('db1.jsp의 결과: ' + result) // console에 결과값 출력
								}
							})
						})
					}
				}
			})
		})
		$('#b2').click(function() { // b2버튼 클릭하면
			$.ajax({ // 실행
				url: "data/member.json", // url 파일을 가져옴
				success: function(doc) { // 가져오는데 성공하면
					// alert('JSON요청 성공') // alert창으로 띄움
					console.log(doc)
					$(doc).each(function(index, item) {
						console.log(index + ": " + item)
						id = $(item).find('id').text() // list의 id값의 텍스트를 변수에 저장
						first_name = $(item).find('first_name').text() // first_name값의 텍스트를 변수에 저장
						last_name = $(item).find('last_name').text() // last_name값의 텍스트를 변수에 저장
						email = $(item).find('email').text() // email값의 텍스트를 변수에 저장
						gender = $(item).find('gender').text() // gender값의 텍스트를 변수에 저장
						ip_address = $(item).find('ip_address').text() // ip_address값의 텍스트를 변수에 저장
						total = 'id: ' + id + 
						', first_name: ' + first_name + 
						', last_name: ' + last_name + 
						', email: ' + email + 
						', gender: ' + gender + 
						', ip_address: ' + ip_address
						$('#d1').append(total + '<br>')
					})
				}
			})
		})
		$('#b3').click(function() {
			
		})
	})
</script>
</head>
<body>
	<button id="b1">XML 읽어오기</button>
	<button id="b2">JSON 읽어오기</button>
	<button id="b3">DB에 넣기</button>
	<hr>
	<div id="d1">
	</div>
</body>
</html>