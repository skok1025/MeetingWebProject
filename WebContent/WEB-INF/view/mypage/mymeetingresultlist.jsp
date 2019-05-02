<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="/Meeting/asset/js/flotr2.min.js"></script>
<style>

#bt {
   background-color: #ff8a80 ;
   margin-bottom: 20px;
}


.btn, .btn:focus {
   background-color: #ff8a80 !important;
}

.btn:hover {
   background-color: #ffab91;
}





#content {
	display: block;
	min-height: 1000px;
}

#mainbox {
	background-color: #FFE8C7;
	padding: 50px;
}


h2 {
	margin-bottom: 20px;
}

#desc>p {
	padding-left: 60px;
	font-size: 1.8em;
	font-weight: bold;
	font-family: "InkLipquid";
}

#tbl td {
	text-align: center;
	padding-left: 50px;
}

#tbl th {
	font-size: 1.5em;
	font-weight: bold;
}

#tbl {
	width: 500px;
	margin: 10px auto;
}

.content {
	height: 300px;
}

.profilebox{
	float: left;
}

.profilebox > div >img{
	width: 200px;
}

.infobox{
	float:left;
	background-color: #A4BBC8;
	width: 550px;
	height: 350px;
	padding: 20px;
	font-weight: bold;
	font-family: cursive;
	border-radius: 5px;
}

.infobox >div > p {
	font-weight: bold;
}

.infobox >div > p > label{
	font-size: 1.5em;
	color: white;
}



.addbt{
	
}
.delbt{
	background-color: #28343D !important;
}

.firstshow{
	transition: all 1s;
	opacity: 1;
}

.secondshow{
	transition: all 1s;
	opacity: 0;
}

.resulttxt{
	font-weight: bold;
	font-size: 3em;
	margin-bottom: 50px;
}

#resultbt{
	height: 110px;
	width: 200px;
	font-size: 2.5em;
}

.txt{
	font-size: 2em;
}
</style>

<script>
$(document).ready(function(){
    $('.modal').modal();
    $('select').formSelect();
    
    $("#resultbt").click(function(){
    	$(".secondshow").css("opacity","1");
    });
   
   
  });
	
</script>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="mypage" name="pageName" />
		</jsp:include>
		<!-- 페이지 이름 : introduce,matching,community,courtship,lovetest,mypage -->

		<main class="mdl-layout__content"> <jsp:include
			page="/inc/sub.jsp"></jsp:include> <jsp:include
			page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>My Page</h1>
			<h2>오늘의 인연</h2>
			<div id="desc">
				<p>내가 보낸 매칭결과를 확인하는 페이지입니다!!!~~~</p>

			</div>
			<div id="mainbox" class="z-depth-3">
				<a href="/Meeting/mypage/todaylove.do" id="bt"
					class="btn waves-effect waves-light" name="action"> <i
					class="material-icons">compare_arrows</i> 나에게 온 매칭결과 확인하기
				</a>
	 
				
				<c:forEach items="${list}" var="dto">
					
					<table id="tbl" class="mdl-data-table mdl-js-data-table">
								
								<tr>
									<td>
										<c:if test="${empty dto.myimage || dto.myimage eq 'null'}">
										<img class="firstshow" src="/Meeting/images/seokhyun/noprofile.png" alt="" />
										</c:if>
										<c:if test="${not empty dto.myimage && dto.myimage != 'null'}">
										<img class="firstshow" src="/Meeting/images/profile/${dto.myimage}" alt="" />
										</c:if>
										<p class="firstshow"><p><p style="font-weight: bold; font-size: 2em;">${dto.myname}</p> 님과의 매칭 결과!!</p>
									</td>
									<td >
										<p class="resulttxt secondshow">
											<c:if test="${dto.accept eq 'y'}">수락하셨어요!!<br><br> 매칭에 성공하셨어요~~</c:if>
											<c:if test="${dto.accept eq 'n'}">거절하셨어요ㅠㅠ<br><br>매칭에 실패하셨어요~~</c:if>
										</p>
										<button id="resultbt" type="button"  style="text-align: center;" 
											class="firstshow delbt mdl-button mdl-js-button mdl-button--raised mdl-button--accent">
											결과확인 <i class="material-icons">visibility</i>
										</button>
									</td>
								</tr>
								<tr>
									<td><p class="txt secondshow">
									<c:if test="${dto.accept eq 'y'}">
									<i class="material-icons">face</i>상대 ID : ${dto.myid}
									</c:if>
									<c:if test="${dto.accept eq 'n'}">
									짚신도 짝이 있는거에요...
									</c:if>									
									</p></td>								
									<td><p class="txt secondshow">
									<c:if test="${dto.accept eq 'y'}">
									<i class="material-icons">settings_phone</i>상대방 연락처: ${dto.mytel}
									</c:if>
									<c:if test="${dto.accept eq 'n'}">
									짚신도 짝이 있는거에요...
									</c:if>		
									
									</p></td>
																
								</tr>
								
								
								
					</table>
				</c:forEach>

			</div>

		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	
</body>

</html>