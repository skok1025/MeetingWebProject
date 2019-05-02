<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/MeetingSample/asset/css/bootstrap.css">
<script src="/MeetingSample/asset/js/jquery-1.12.4.js"></script>

<style>
/* @font-face {
	font-family: 'yg-jalnan';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
} */
@font-face {
	font-family: 'Youth';
	font-style: normal;
	font-weight: 400;
	src:
		url('//cdn.jsdelivr.net/korean-webfonts/1/orgs/othrs/kywa/Youth/Youth.woff2')
		format('woff2'),
		url('//cdn.jsdelivr.net/korean-webfonts/1/orgs/othrs/kywa/Youth/Youth.woff')
		format('woff');
}

.youth * {
	font-family: 'Youth', sans-serif;
}

html, body, p, div, span, table, th, td, ul, ol, dl, li, dt, dd, input,
	textarea, select, option, fieldset, legend, h1, h2, h3, h4, h5, h6, a {
	font-family: "Youth";
}

body {
	background: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)),
		url("<%=request.getContextPath()%>/images/main.jpg") no-repeat center
		center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

body:after {
	opacity: .4;
}

#ga {
	position: relative;
	font-weight: bold;
	color: pink;
	opacity: 0;
	text-align: center;
	margin-top: 200px;
}

#ga2 {
	position: relative;
	color: #f01195;
	opacity: 0;
	text-align: center;
	margin-top: 50px;
}

#ga2>span {
	font-variant: small-caps;
}

#btnspan {
	position: relative;
	color: fuchsia;
	opacity: 0;
	text-align: center;
	font-weight: bold;
	margin-top: 150px;
	margin-bottom: 150px;
	cursor: pointer;
}

#footer {
	text-align: center;
}
</style>
<script>
	$(document).ready(function() {

		$("#ga").animate({
			opacity : 0,
		}, 1000).animate({
			opacity : 1,
		}, 2000);

		$("#ga2").animate({
			opacity : 0,
		}, 1000).animate({
			opacity : 0,
		}, 2000).animate({
			opacity : 1,
		}, 2000);

		$("#btnspan").animate({
			opacity : 0,
		}, 1000).animate({
			opacity : 0,
		}, 2000).animate({
			opacity : 0,
		}, 2000).animate({
			opacity : .9,
		}, 2000);
	});
</script>
</head>
<body>

	<div class="container">
		<h1 id="ga" style="font-size: 5em;">
			2019 Genesis g80 SUV <br>2019년 초 출시예정!
		</h1>
		<h2 id="ga2">
			<span>Car</span><span>Community</span>
		</h2>
		<h3 id="btnspan" onclick="location.href='/Car/main.do';">
			<span class="glyphicon glyphicon-search"></span> 둘러보기
		</h3>
		<hr id="line">
		<footer id="footer"> &copy;Copyright 2018 test.com All rights
		free~ </footer>
	</div>
</body>
</html>