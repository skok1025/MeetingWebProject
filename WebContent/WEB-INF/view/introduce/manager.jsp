<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description"
	content="A portfolio template that uses Material Design Lite.">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Manager Introduce</title>

<jsp:include page="/inc/asset.jsp"></jsp:include>

<style>

	#managerProf{
		border: 0px solid red;
		margin-top: 40px;
		height: 650px;		
		padding-bottom: 20px;
		margin-bottom: 20px;
	}
	
	.profile{
		border: 0px solid green;
		width: 266px;
		margin: 10px;
		height: 500px;
	}
	
	.profileDetail{
		border: 0px solid blue;
		position: absolute;
		top: 250px;
		left: -55px;
		width: 300px;
		height: 250px;
		padding: 10px;
		padding-top: 20px; 
		background-color: rgb(164,187,200);
		border-radius: 20px;
	}
	.carousel .carousel-item{
		top: -200px;
	}
	
	#managerContent td, th{
		padding: 0px;
		padding-bottom: 10px;
		margin-left: 5px;
	}
	
	#managerContent th{
		font-weight: bold;
		padding-left: 15px;
		border-right: 1px solid black;
		text-align: center;
		padding-right: 15px;
		vertical-align: middle;
	}
	
	#managerContent td{
		padding-left: 10px;
		padding-top: 10px;
	}
</style>
<script>

   $(document).ready(function(){
	   //carousel
	   $(".carousel").carousel();
	   
	   $("#managerProf div img").click(function(){
		  //alert("click");
		   //$("#managerProf div img").css("cursor","pointer");
	   });
   });
   </script>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="Manager Introduce" name="pageName"/>
		</jsp:include>
			<!-- 페이지 이름 : introduce,matching,community,courtship,lovetest,mypage -->

		<main class="mdl-layout__content"> 
		<jsp:include page="/inc/sub.jsp"></jsp:include>
		<jsp:include page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>회사소개</h1>
			<h2>매니저 소개</h2>
			<hr>
			
			<div>
				<h5>광민愛듀오 매니저를 소개합니다.</h5><br>
				<div>광민愛듀오 매니저는 여러분의 소중한 인연 찾기에 정성껏 힘쓰겠습니다.</div>
				<br><br>
				<div style="color: #EE3B3E; text-align: center; font-size: 1.1em;"><span style="font-weight: bold;">마우스를 드래그</span> 하여 매니저님들을 알아보세요!</div>
			</div>

			<div id="managerProf" class="carousel">
				<c:forEach items="${ilist}" var="dto">
				
				<div class="profile carousel-item">
					<!-- <img src="/Meeting/images/yeji/profile.png"> -->
					<img src="/Meeting/images/yeji/${dto.image }">
					<div class="profileDetail">
						<table id="managerContent">
							<tr>
								<th>NAME</th>
								<td>${dto.name }</td>
							</tr>
							<tr>
								<th>AGE</th>
								<td>${dto.age }&nbsp;세</td>
							</tr>
							<tr>
								<th>INFO</th>
								<td>${dto.managerInfo }</td>
							</tr>
						</table>
					</div>
				</div>
				</c:forEach>
		</div>

	</div>
	<jsp:include page="/inc/footer.jsp"></jsp:include> </main>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>