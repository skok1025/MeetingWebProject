<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description"
			content="A portfolio template that uses Material Design Lite.">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<title>Template</title>
		
		<jsp:include page="/inc/asset.jsp"></jsp:include>
		
		<style>
			#content {
				min-height: 1000px;
				margin-bottom : 15px; 
			}
			
			#test {
				display : inline-block;
				width : 350px;
				height : 350px;
			}
			
			.card {
				width : 400px;
				margin : 10px;
			}
			
		</style>
		
		<script>
			   $(document).ready(function(){
	
			   });
		   </script>
	</head>
	
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<jsp:include page="/inc/header.jsp">
			<jsp:param value="lovetest" name="pageName" />
		</jsp:include>
		
			<main class="mdl-layout__content">
				
				 <jsp:include
			page="/inc/sub.jsp"></jsp:include> <jsp:include
			page="/inc/sublist.jsp"></jsp:include>
				
				<div id="content" class="mdl-grid portfolio-max-width">
					<h1>Love Test</h1>
					<h2>너와 나의 거리</h2>
					<div class="mdl-layout__drawer mdl-layout--small-screen-only">
		            	<nav class="mdl-navigation mdl-typography--body-1-force-preferred-font">
			                <a class="mdl-navigation__link is-active" href="index.html">Portfolio</a>
			                <a class="mdl-navigation__link" href="blog.html">Blog</a>
			                <a class="mdl-navigation__link" href="about.html">About</a>
			                <a class="mdl-navigation__link" href="contact.html">Contact</a>
		           		 </nav>
	        		</div>
	        		
	        		<!-- 카드 전체 div -->
		            <div class="mdl-grid portfolio-max-width allCard">
		            	<!-- 카드 1개 -->
		                <div class="mdl-cell mdl-card mdl-shadow--4dp portfolio-card card">
		                   <div>
		                       <img class="article-image" src="/Meeting/images/임광민/커플1.PNG">
		                   </div>
		                   <div class="mdl-card__title">
		                       <h2 class="mdl-card__title-text">Love 가입 Test</h2>
		                   </div>
		                   <div class="mdl-card__supporting-text">
		                       간단한 테스트를 통해 나의 Love Test를 받아보세요.
		                   </div>
		                   <div class="mdl-card__actions mdl-card--border">
		                       <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="/Meeting/love/lovetest.do">Start</a>
		                   </div>
		                </div>
		                <!-- 카드 1개 -->
		                <div class="mdl-cell mdl-card mdl-shadow--4dp portfolio-card card">
		                   <div>
		                       <img class="article-image" src="/Meeting/images/임광민/커플2.PNG">
		                   </div>
		                   <div class="mdl-card__title">
		                       <h2 class="mdl-card__title-text">바람기 테스트</h2>
		                   </div>
		                   <div class="mdl-card__supporting-text">
		                       바람기 테스트! 솔직하게 대답해야되는거 아시죠?
		                   </div>
		                   <div class="mdl-card__actions mdl-card--border">
		                       <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="#">Start</a>
		                   </div>
		                </div>
		                <!-- 카드 1개 -->
		                <div class="mdl-cell mdl-card mdl-shadow--4dp portfolio-card card">
		                   <div>
		                       <img class="article-image" src="/Meeting/images/임광민/커플3.PNG">
		                   </div>
		                   <div class="mdl-card__title">
		                       <h2 class="mdl-card__title-text">내 연애 상대 찾기!</h2>
		                   </div>
		                   <div class="mdl-card__supporting-text">
		                       대한민국에서 내가 만날 수 있는 연애상대는 몇 명이나 될까?
		                   </div>
		                   <div class="mdl-card__actions mdl-card--border">
		                       <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="#">Start</a>
		                   </div>
		                </div>
		                <!-- 카드 1개 -->
		                <div class="mdl-cell mdl-card mdl-shadow--4dp portfolio-card card">
		                   <div>
		                       <img class="article-image" src="/Meeting/images/임광민/커플4.PNG">
		                   </div>
		                   <div class="mdl-card__title">
		                       <h2 class="mdl-card__title-text">연애 진단 테스트</h2>
		                   </div>
		                   <div class="mdl-card__supporting-text">
		                       나도 모르는 나의 연애 스타일은 어떨까?
		                   </div>
		                   <div class="mdl-card__actions mdl-card--border">
		                       <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="#">Start</a>
		                   </div>
		                </div>
					 </div>
				</div>
				<jsp:include page="/inc/footer.jsp"></jsp:include> </main>
			</main>
		</div>
		<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	</body>
</html>














