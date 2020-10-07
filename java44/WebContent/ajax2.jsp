<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function() {
		 $('#b1').click(function() {
	     $('#d1').empty()
	      $.ajax({ //api의 주소
	         url : "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Fhealth.chosun.com%2Fsite%2Fdata%2Frss%2Frss.xml&api_key=i1gpgchgw95nhvkorrnuhk4sptjfxy5cpyi40a8i",//member.xml과 연결
	         data : {   //원래 url과 키, contents의양
	            url : 'http://health.chosun.com/site/data/rss/rss.xml',
	            api_key :'dunqgbr9ry5rirpozrs3yjfgulhb3pilmdh8wuji',// 가져올 api의 키를넣어줘야 한다. 
	            count : 20 
	         },
	         success: function(result) {
	         console.log('성공'+result)
	         list = result.items//items의 배열
	         console.log(list.length)
	         if (list.length >0 ) {
	            $(list).each(function(index, news){
	               title = news.title
	               pubDate = news.pubDate
	               link = news.link
	               total = "<b><a href="+link+">"+title+"</a></b> : " + pubDate + "<br>" + "<a>"+link+"</a><br>"
	               $('#d1').append(total+"<hr>")
	               
	               guid = news.guid,
	               author = news.author,
	               thumbnail = news.thumbnail,
	               description = news.description,
	               content = news.content,
	               enclosure = news.enclosure,
	               categories = news.categories
	               
	               $.ajax({//데이터를 보내기위해 ajax안에 ajax
	                  url:"db2.jsp", //db1에 연결
	                  data : { //key : value
	                     title : title,
	                     pubDate : pubDate,
	                     link : link,
	                     guid : guid,
	                     author : author,
	                     thumbnail : thumbnail,
	                     description : description,
	                     content : content,
	                     enclosure : enclosure,
	                     categories : categories
	                  },
	                  success: function(result) {//결과 출력
	                     console.log('db2.jsp를 통해서 db에 넣기- 성공적으로 전송함')
	                     console.log('결과는'+result)
	                  }
	               })//ajax
	            })//each
	         }//if
	      }//success
	      })//ajax
	   })//b1click
		$('#b2').click(function() {
			$('#d1').empty()
			$.ajax({
				url: "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Ftravel.chosun.com%2Fsite%2Fdata%2Frss%2Frss.xml",
				data: {
					url: 'http://travel.chosun.com/site/data/rss/rss.xml', 
					api_key: 'dunqgbr9ry5rirpozrs3yjfgulhb3pilmdh8wuji',
					count: 20
				},
				success: function(result) {
					console.log("성공" + result)
					items = result.items // 키의 값들
					console.log(items.length)
					if (items.length > 0) {
						$(items).each(function(index, news) {
							title = news.title
							pubDate = news.pubDate
							link = news.link
							console.log(title + ", " + pubDate + ", " + link)
							total = "<a href='" + link + "'>" + title + "</a><br>" + pubDate + "<br><hr style=color:red>"
							$('#d1').append(total)
						})
					}
				}
			})
		})
		$('#b3').click(function() {
			$('#d1').empty()
			$.ajax({
				url: "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Fbooks.chosun.com%2Fsite%2Fdata%2Frss%2Frss.xml",
				data: {
					url: 'http://books.chosun.com/site/data/rss/rss.xml', 
					api_key: 'dunqgbr9ry5rirpozrs3yjfgulhb3pilmdh8wuji',
					count: 20
				},
				success: function(result) {
					console.log("성공" + result)
					items = result.items // 키의 값들
					console.log(items.length)
					if (items.length > 0) {
						$(items).each(function(index, news) {
							title = news.title
							pubDate = news.pubDate
							link = news.link
							thumbnail = news.thumbnail
							total = "<a href='" + link + "'>" + title + "</a><br>" + pubDate + "<br><img src='" +thumbnail + "'><hr style=color:red>"
							$('#d1').append(total)
						})
					}
				}
			})
		})
		$('#b4').click(function() {
			$('#d1').empty()
			$.ajax({
				url: "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Frss.hankyung.com%2Fnew%2Fnews_enter.xml&api_key=dunqgbr9ry5rirpozrs3yjfgulhb3pilmdh8wuji",
				data: {
					url: 'http://rss.hankyung.com/new/news_enter.xml', 
					api_key: 'dunqgbr9ry5rirpozrs3yjfgulhb3pilmdh8wuji',
					count: 20
				},
				success: function(result) {
					console.log("성공" + result)
					items = result.items // 키의 값들
					console.log(items.length)
					if (items.length > 0) {
						$(items).each(function(index, news) {
							title = news.title
							pubDate = news.pubDate
							link = news.link
							total = "<a href='" + link + "'>" + title + "</a><br>" + pubDate + "<br><hr style=color:red>"
							$('#d1').append(total)
						})
					}
				}
			})
		})
		$('#b5').click(function() {
			$('#d1').empty()
			$.ajax({
				url: "https://api.rss2json.com/v1/api.json?rss_url=http%3A%2F%2Frss.hankyung.com%2Fnew%2Fnews_photo.xml",
				data: {
					url: 'http://rss.hankyung.com/new/news_photo.xml', 
					api_key: 'dunqgbr9ry5rirpozrs3yjfgulhb3pilmdh8wuji',
					count: 20
				},
				success: function(result) {
					console.log("성공" + result)
					items = result.items // 키의 값들
					console.log(items.length)
					if (items.length > 0) {
						$(items).each(function(index, news) {
							title = news.title
							pubDate = news.pubDate
							link = news.link
							total = "<a href='" + link + "'>" + title + "</a><br>" + pubDate + "<br><hr style=color:red>"
							$('#d1').append(total)
						})
					}
				}
			})
		})
	})
</script>
<style type="text/css">
#b2 {
	background:#F6CEF5; 
}
#b3 {
	background:#8181F7; 
}
#b4 {
	background:#A9F5F2; 
}
#b5 {
	background:#E3F6CE; 
}
</style>
</head>
<body>
	<button id="b1">헬스 연결</button>
	<button id="b2">travel 연결</button>
	<button id="b3">books 연결</button>
	<button id="b4">연예 연결</button>
	<button id="b5">포토 연결</button>
	<hr>
	<div id="d1">
	</div>
</body>
</html>