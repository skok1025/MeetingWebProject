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
<title>Template</title>

<jsp:include page="/inc/asset.jsp"></jsp:include>

<style>

#content {
	min-height: 1000px;
}

#explain{
	background-color: rgba(252,209,181);
	padding-bottom: 40px;
	height: 180px;
}

#logo{
	width: 100px;
	height: 100px;
	margin: 40px 40px;

}

#box{
	border: 1px solid gray;
	margin-top: 40px;
	min-height: 1000px;
}

#tbl1{
	border: 1px solid tomato;
	margin-top: 50px; 
}


#btns{
		width: 700px;
		margin: 0px 700px;
	}

	
	#search{
		width: 500px;
		margin: 20px auto;
		text-align: center;
	}
	
	#word{ width: 300px; }
	
	#pagebar { text-align: center; margin-bottom: 25px; }
	
	#search {
	border: 1px solid green;
	height: 60px;
	width: 550px;
	text-align: center;
	display: inline-block;
	margin-left: 150px;
	margin-top: 30px;
}

.btn, .btn:focus{
	background-color: #ff8a80;
}

.btn:hover{
	background-color: #ffab91;
}


#column{
	width: 90px;
	color: #ff8a80;
	border: 1px solid #ff8a80;
}
</style>

<script>
   $(document).ready(function(){

      
      
      
   });
   </script>
</head>

<body>

<!-- 회원 자유게시판 -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="community" name="pageName"/>
		</jsp:include>
			<!-- 페이지 이름 : introduce,matching,community,courtship,lovetest,mypage -->

		<main class="mdl-layout__content"> 
		<jsp:include page="/inc/sub.jsp"></jsp:include>
		<jsp:include page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>커뮤니티</h1>
			<h2>회원 자유게시판</h2>
			
			<div id="box">
				
				<div id="explain">
					<img src="../images/logo.png" id="logo">
					<span style="font-size:2em; margin-left:40px; margin-bottom:0px;">회원 여러분들의 자유로운 게시판입니다</span>
				</div>
			
				<table id="tbl1" class="centered">
					<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>이름</th>
						<th>날짜</th>
					</tr>
					</thead>
					<tbody>
					<c:if test = "${blist.size() == 0 }">
						<tr>
							<td colspan="5">현재 게시물이 없습니다</td>
						</tr>
					</c:if>
					<c:forEach items="${blist }" var="dto">
					<tr>
						<td>${dto.seq }</td>
						<td>${dto.title }</td>
						<td>${dto.name }</td>
						<td>${dto.regdate }</td>
					</tr>
					</c:forEach>
					<!-- <td>1</td>
					<td>추천코스가</td>
					<td>송미령</td>
					<td>2018-09-11</td> -->
					</tbody>
				</table>
				
				<!-- 검색창 -->
				<div id="search">
					<select name="column" id="column" class="browser-dafault">
						<option value="" disabled selected>선택</option>
						<option value="title">제목</option>
						<option value="name">작성자</option>
					</select> 
					
					<script>
							<c:if test="${isSearch}">
							$("#column").val("${map.column}");
							</c:if>
					</script>
					
					<input type="text" name="text" id="text"
						style="width: 250px; " required value="${map.word}">
					
					<button class="btn btn-default waves-effect waves-light" type="submit" name="action">검색
	    				<i class="material-icons right">send</i>
	  				</button>
				</div>
				
				<!-- 페이지바 -->
				<div id="pagebar">${pagebar }</div>
				
				
				<div id="btns">
					<input type="button" value="쓰기"
						class="btn btn-primary"
						onclick="location.href='/Meeting/community/freeboardadd.do';">
					<input type="button" value="목록"
						class="btn btn-default"
						onclick="location.href='/Meeting/community/freeboard.do';">
				</div>
			
			</div>

			
		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>