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
<title>GMDUO</title>
<jsp:include page="/inc/asset.jsp"></jsp:include>

<style>


#subMenu {
	border: 0px solid blue;
	height: 200px;
	width: 860px;
	position: relative;
	top: -93px;
	left: 0px;
	z-index: 1;
	background-color: rgba(222, 147, 145, .6);
	/* padding-bottom: 20px; */
	border-radius: 10px;
	border-bottom: 10px solid #96759A;
}

#subMenu>div {
	border: 0px solid green;
	width: 210px;
	height: 110px;
	position: absolute;
	top: 0px;
	left: 20px;
	padding: 10px;
	margin-top: 50px;
	margin-left: 60px;
	margin-right: 50px;
	float: left;
	background-color: rgba(252, 209, 181, .4);
	border-radius: 20px;
	box-shadow: 3px 3px 2px #aaaaaa;
}

#subMenu>div:hover {
	transform: scale(1.1);
	cursor: pointer;
}

#subMenu>div>i {
	color: #28343D;
	display: inline-block;
	margin-top: 20px;
	float: left;
}

#subMenu>div:nth-child(2) {
	left: 260px;
}

#subMenu>div:last-child {
	left: 500px;
}

.subDetails {
	border: 0px solid blue;
	padding-top: 8px;
}

.subDetails>span:first-child {
	border: 0px solid green;
	margin-bottom: 2px;
	padding-left: 5px;
	display: block;
	float: left;
	text-decoration: underline;
	font-style: italic;
	font-weight: bold;
	font-size: 1.2em;
}

.subDetails>span:last-child {
	border: 0px solid red;
	display: block;
	width: 130px;
	position: relative;
	top: -35px;
	left: 60px;
}

.slideBox, .slide{
	list-style: none;
	margin: 0px;
	padding: 0px;
}

.slideBox{
	border: 0px solid green;
	width: 800px;
	overflow: hidden;
	position: relative;
	margin-left: 30px;
	top: -15px;
	z-index: 2;
}

.slide{
	border: 0px solid red;
	width: 3200px;
	position: relative;
	left: 0px;
}

.slide li{
	display: inline-block;
	width: 800px;
	margin-right: -5px; 
}

.slide li img{
	border: 0px solid red;
	width: 800px;
	height: 500px;
	display: relative;
	left: -4px;
	top: 100px;
}

#blog{
	border: 0px solid red;
	margin-bottom: 110px;
}

#blog > h1, #customer > h1{
	border: 0px solid blue;
	color: #FCD1B5;
	background-color: #28343D;
	display: block;
	padding-left: 10px;
}

#card{
	border: 0px solid green;
}

#card2{
	border: 0px solid blue;
	margin-left: 53px;
	margin-top: 10px;
	width: 350px;
	float: left;
}

/* ------------------------------------------------------------------ */

.blogslideBox, .bslide{
	list-style: none;
	margin: 0px;
	padding: 0px;
}

.blogslideBox{
	/* 슬라이드가 화면에 보여지는 박스 */
	border: 0px solid orange;
	overflow: hidden; 
	position: relative;
	/* left: 50px; */
	top: 0px;
}

#bslide{
	/* 슬라이드 컨텐츠가 담긴 박스 */
	border: 0px solid purple;
	padding: 30px 0px 30px 0px;
	width: 3440px; /* 컨텐츠 만큼 width 속성 변경 */
	position: relative;
	background-color: #FAEFE7;
	left: 0px;
	margin: 0px;
}

#bslide li{
	display: inline-block;
}

.cardContent{
	border: 1px solid #a9a9a9;
	border-radius: 15px;
	box-shadow: 5px 5px 10px #a9a9a9;
	width: 350px;
	height: 200px;
	margin-right: 45px;
	margin-left: 36px;
	padding: 0px;
	left: -10px; 
	background-color: rgba(240,248,255,.2); 
}

.contentImg{
	border: 0px solid black;
	width: 70px;
	height: 70px;
	float: left;
	margin-top: 45px;
	margin-left: 5px;
}

#description{
	padding:0px;
	padding-bottom: 10px;
	padding-top: 20px;
	padding-left: 15px;
	padding-right: 15px;
}

#description > h6{
	display: block;
	margin-bottom: 15px;
}

#blogLink{
	border: 0px solid blue;
	text-align: right;
	padding: 0px;
	padding-top: 20px;
}

#blogLink > i{
	vertical-align: middle;
	text-align: center;
}

#customer{
	border: 0px solid blue;
}

#customerCard{
	display: relative;
	float: left;
	width: 250px;
	margin: 18px;
}

.card-content > h5{
	display: block;
	margin-bottom: 10px;
	text-align: center;
}

#good{
	text-align: right;
	vertical-align: middle;
}

#tblCustomer > th{
	color: #455B71;
	font-weight: bold;
}

.card-image > img:active{
	transform: scale(1.5);
} 


</style>

<script>

	var index = 0;
	var slidemax = 3;
	var pos = 800;
	
	var bindex = 0;
	var bslidemax = 3;
	var bpos = 860;

   $(document).ready(function(){
	   
	   $.ajax({
		  type: "get",
		  url: "/Meeting/introduce/mainindexdata.do",
		  dataType: "xml",
		  success: function(result){
			  //alert("메롱");
			  $(result).find("item").each(function(index, item){
				 //console.log($(item).find("title").text()); 
				 
				 var title = $(item).find("title").text();
				 var link = $(item).find("link").text();
				 var description = $(item).find("description").text();
				 var blogger = $(item).find("bloggername").text();
				 
				 var content = description.substr(0,45);
				 
				 /* console.log(index); */
				 //console.log("content : " + content);
				 
				 //$("#card").append("<div class='card horizontal' id='card2' ><div class='card-image'><img style='height: 190px; width: 65px;'src='<%=request.getContextPath() %>/images/yeji/loveverti.jpg'></div><div class='card-stacked'><div class='card-content' id='description'><p>"+ description + "</p></div><div class='card-action'><a href='"+ link + "'>link </a></div></div></div><div style='clear: both;'></div>");
				 $("#bslide").append("<li><div class='cardContent'><div class='contentImg'><img src='<%=request.getContextPath() %>/images/yeji/heart (" + index + ").png'></div><div class='card-stacked'><div class='card-content' id='description'><h6>" + title + "</h6><p>"+ content +"... </p></div><div class='card-action' id='blogLink'><a  style='color: #EE3B3E;'href='" + link + "'>more&nbsp;<i class='material-icons'>playlist_add</i></a></div></div></div></li>");	  
			  });
		  },
		  error: function(a,b,c){
			  console.log(a,b,c);
		  }
	   });
	   
   });//ready
   
   
   function sliding(add){
	   index = index + add;
	   bindex = bindex + add;
	   if(index < 0) index = slidemax;
	   else if(index > slidemax) index = 0;
	   
	   if(bindex < 0) bindex = bslidemax;
	   else if(bindex > bslidemax)	bindex = 0;
	   $(".slide").stop().animate({"left":-(index*pos)+"px"}, "slow");
	   $("#bslide").stop().animate({"left":-(bindex*bpos)+"px"},"slow");
   }
   
   autoslide = setInterval(function(){sliding(1)},3000);
   
   function after(){
	   setTimeOut(function(){
		  clearInterval(autoSlide);
		  autoSlide = setInterval(function(){sliding(1)}, 3000);
	   }, 2000);
   }
</script>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="mainPage" name="pageName" />
		</jsp:include>

		<main class="mdl-layout__content"> <jsp:include
			page="/inc/sub.jsp"></jsp:include> <jsp:include
			page="/inc/sublist.jsp"></jsp:include>

		<div id="content" class="mdl-grid portfolio-max-width">

			<!-- <h1>Main Title</h1>
			<h2>Sub Title</h2> -->
			<div class="slideBox">
				<ul class="slide">
					<li><img id="image1" src="<%=request.getContextPath() %>/images/image (18).jpg"></li>
					<li><img id="image2" src="<%=request.getContextPath() %>/images/image (16).jpg"></li>
					<li><img src="<%=request.getContextPath() %>/images/image (11).jpg"></li>
					<li><img src="<%=request.getContextPath() %>/images/image (15).jpg"></li>
				</ul>				
			</div>

			<div id="subMenu">
				<div onclick="location.href='/Meeting/introduce/manager.do';">
					<i class="medium material-icons">assignment_ind</i>
					<div class="subDetails">
						<span>매칭 매니저</span><br>
						<div style="clear: both;"></div>
						<span>매칭 담당 매니저가<br> 궁금하신가요?
						</span>
					</div>
				</div>
				<div onclick="location.href='/Meeting/love/lovetestmain.do';">
					<i class="medium material-icons">format_list_numbered</i>
					<div class="subDetails">
						<span>연애 진단 테스트</span><br>
						<div style="clear: both;"></div>
						<span>간단한 테스트를 통해 진단해드립니다.</span>
					</div>
				</div>

				<div onclick="location.href='/Meeting/community/allcommunity.do';">
					<i class="medium material-icons" style="color: #85a18d;">notifications</i>
					<div class="subDetails">
						<span>문의 및 건의사항</span><br>
						<div style="clear: both;"></div>
						<span>문의사항과 건의사항을 남겨주세요!</span>
					</div>
				</div>
			</div>
			
			<div id="blog">
				<h1>연애의 발견 ${id }</h1>
			
				<p>&nbsp;&nbsp;&nbsp;&nbsp;광민愛듀오가 추천 드리는 좋은 글! <br>&nbsp;&nbsp;실전에 앞선 맛보기를 제공해드립니다.</p>
				<div style="text-align: center; margin-bottom: 10px;"><span style="color: #EE3B3E; font-weight: bold;">더보기</span>를 통해 자세한 글을 살펴보세요!</div>
				<div class="col s12 m7" id="card">							
					<div class="blogslideBox">								
					<ul class="card horizontal" id="bslide">																													
					</ul>
					
				</div>					
			</div>	
		</div>
		
		<!-- 인기 회원 상위 세 명 -->
		<div id="customer">
			<h1>금주의 회원</h1>
			
			<p>&nbsp;&nbsp;&nbsp;&nbsp;광민愛듀오에서 좋아요를 많이 받은 회원 목록입니다. <br>&nbsp;&nbsp;광민愛듀오에서 더 많은 회원을 만나보세요!</p>
			<div style="text-align: center; font-size: 1.1em; margin-bottom: 10px;">프로필 <span style="color: #EE3E3B;">이미지를 꾹 누르면</span> 자세히 볼 수 있어요!</div>
			<div class="row" style="border: 0px solid green;">
				<div class="col s12 m7" style="width: 860px; padding: 0px;">
				
					<c:forEach items="${clist }" var="dto">
					<div class="card" id="customerCard">					
						<div class="card-image">
							<img src="<%=request.getContextPath() %>/profile/${dto.image}" style="width: 200px; height: 200px; margin-left: 25px; margin-top: 10px; margin-bottom: 10px;"> 
							<!-- <span class="card-title">CardTitle</span> -->
						</div>
						
						<div class="card-content" style="padding-top: 15px;">
							<h5>${dto.customerName }</h5>
							<div>
								<table id="tblCustomer" class="highlight">
									<tr>
										<th>Nickname</th>
										<td>${dto.nickname }</td>
									</tr>
									<tr>
										<th>Age</th>
										<td>${dto.age }</td>										
									</tr>
									<tr>
										<th>Job</th>
										<td>${dto.job }</td>
									</tr>
								</table>
							</div>
						</div>	
						<div class="card-action">	
							<div id="good">
							<i class="material-icons" style="color: #EE3B3E;">favorite<a href="#" style="display: inline-block; position: relative; top: -4px; left: 15px;">${dto.cntGood }</a></i></div>
						</div>
					</div>
					</c:forEach>
		
				</div>
			</div>
		</div> <!-- customer -->
			
		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include>
		</main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>