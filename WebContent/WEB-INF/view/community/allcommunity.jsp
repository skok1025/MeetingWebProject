<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="A portfolio template that uses Material Design Lite.">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<title>Template</title>
		
		<jsp:include page="/inc/asset.jsp"></jsp:include>
		
		<style>
			#content {
				min-height: 1000px;
			}
			
			#explain {
				background-color: rgba(252, 209, 181);
				padding-bottom: 40px;
				height: 180px;
			}
			
			#logo {
				width: 100px;
				height: 100px;
				margin: 40px 40px;
			}
			
			#box {
				margin-top: 40px;
				min-height: 1000px;
			}
			
			#tbl1 {
				margin-top: 50px;
			}
			
			#btns {
				width: 700px;
				margin: 0px 700px;
			}
			
			#search {
				width: 250px;
				margin: 20px auto;
				text-align: center;
			}
			
			#word {
				width: 300px;
			}
			
			#pagebar {
				text-align: center;
				margin-bottom: 25px;
			}
			
			.btn, .btn:focus {
				background-color: #ff8a80;
			}
			
			.btn:hover {
				background-color: #ffab91;
			}
			
			#column {
				
				color: #ff8a80;
			}
			
			.category {
				margin-top : 35px;
				text-align: center;
			}
			
			.category > a {
				margin : 20px;
				font-size: 20px;
				color : #FF8A80;
			}
			
			#allSearch {
				text-align: center;
			}
			
			#allSearch > div {
				float : left;
			}
			
			#pagebar {
				width: 500px;
				margin : 0px auto;
				margin-top : 30px;
			}
			
			#write {
				float : right;
			}
			
			#explain > a {
				font-size : 55px;
			}
			
			#leftbt{
				font-size: 2.5em !important;
				margin-top : 22px;
				color : white;
			}
			
		</style>
		
		<script>
			$(document).ready(function(){
		  		$("#column").formSelect();
		  		
		  		$("#manage").click(function(){
					child = window.open("/Meeting/community/communitymanage.do","child", "width=1000, height=800");
				});
			}); 
		</script>
	</head>
	
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<jsp:include page="/inc/header.jsp">
				<jsp:param value="community" name="pageName" />
			</jsp:include>
			
			<main class="mdl-layout__content"> 
			<jsp:include page="/inc/sub.jsp"></jsp:include>
			<jsp:include page="/inc/sublist.jsp"></jsp:include>
			<div id="content" class="mdl-grid portfolio-max-width">
				<h1>커뮤니티</h1>
				<h2>관리자/회원 게시판</h2>
	
				<div id="box">
					
					<c:if test="${kind == 0}">	
					<div id="explain">
						<img src="../images/logo.png" id="logo"> 
						<span style="font-size: 2em; margin-left: 40px; margin-bottom: 0px;">회원여러분들의 자유로운 게시판입니다</span>
						<a href="/Meeting/community/allcommunity.do?kind=1&category=0&page=1"><i id="leftbt" class="material-icons right">navigate_next</i></a>
					</div>
					</c:if>
					
					<c:if test="${kind == 1}">	
					<div id="explain">
						<img src="../images/logo.png" id="logo"> 
						<span style="font-size: 2em; margin-left: 40px; margin-bottom: 0px;">관리자와 소통 할 수 있는 게시판입니다</span>
						<a href="/Meeting/community/allcommunity.do?kind=0&category=0&page=1"><i id="leftbt" class="material-icons right">navigate_next</i></a>
					</div>
					</c:if>
					
					<div class="category">
						<a href="/Meeting/community/allcommunity.do?kind=0&category=0&page=1">전체</a>
					<c:forEach items="${clist}" var="dto">
						<a href="/Meeting/community/allcommunity.do?kind=0&category=${dto.seq}&page=1">${dto.category}</a>
					</c:forEach>
						<div id="write">
							<input id="manage" type="button" value="글관리" class="btn btn-primary">
							<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='/Meeting/community/communityadd.do?kind=${kind}';">
						</div>
					</div>
					
					<table id="tbl1" class="centered">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>경고</th>
								<th>날짜</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${alist.size() == 0 }">
								<tr>
									<td colspan="5">현재 게시물이 없습니다</td>
								</tr>
							</c:if>
							<c:forEach items="${alist}" var="dto">
								<tr>
									<td>${dto.seq}</td>
									<td>
										<a style="text-decoration: none; color:black;" href="/Meeting/community/communityview.do?seq=${dto.seq}">${dto.title}</a>
									</td>
									<td>
										<c:if test="${dto.warning == 1}">
											<i style="color:red;" class="material-icons">error</i>
										</c:if>
									</td>
									<td>${dto.regdate}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<!-- 검색창 -->
					<form action="/Meeting/community/allcommunity.do" method="get">
						<div id="allSearch" style="margin-top : 50px;">
							<div style="margin-left:250px;">
								<select name="column" id="column">
									<option value="" disabled selected>선택</option>
									<option value="title">제목</option>
								</select>
							</div>
							<input type="text" name="word" id="word" style="width: 300px;" required value="${map.word}">
							<button class="btn btn-default waves-effect waves-light" type="submit"> 검색 <i class="material-icons right">send</i></button>
						</div>
					</form>
					<div style="clear: both;"></div>
					
					<!-- 페이지바 -->
					<div id="pagebar">${pagebar }</div>
	
				</div>
			</div>
			<jsp:include page="/inc/footer.jsp"></jsp:include> </main>
	
		</div>
		<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	
	</body>

</html>