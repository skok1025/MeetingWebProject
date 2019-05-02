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
	display: block;
	min-height: 1000px;
}

#mainbox {
	background-color: #FFE8C7;
	padding: 50px;
}

#bt {
	background-color: #FFB2D9;
	margin-bottom: 20px;
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

#mainbox>p {
	font-size: 1.8em;
	font-weight: bold;
}



#tbl td{
	text-align: center;
}

#notyet{
	font-size: 3em;
}
</style>

<script>
	$(document).ready(function() {

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
			<h2>manager SOS</h2>
			<div id="desc">
				<p>우리 광민해 듀오는, 매칭에 어려움을 갖는 회원을 위해 매니저 SOS</p>
				<p>기능을 제공합니다. 해당 글은 작성 회원과 매니저만 열람 가능하니,</p>
				<p>걱정하지 말고 자유롭게 SOS 글을 남겨주세요~~</p>
			</div>
			<div id="mainbox" class="z-depth-3">
				<p>나의 Manager SOS 처리내역</p>

			<c:if test="${empty mList }">
					<p style="font-weight: bold; font-size: 1.5em; margin:50px 0px 0px 30px;">매니저 SOS 처리내역 정보가 없습니다.</p>
				</c:if>
			<c:forEach items="${mList}" var="dto">

				<div class="col s12 m8 offset-m2 l6 offset-l3">
					<div class="card-panel grey lighten-5 z-depth-1">
						<div class="row valign-wrapper">
							<table id="tbl" class="mdl-data-table mdl-js-data-table">
								<tr>
									<th style=" width:30px; vertical-align: middle; text-align: left;"><i
										class="material-icons">insert_invitation</i> SOS 작성날짜</th>
									<td style="width: 100px; text-align: left;">${dto.regdate }</td>
								</tr>
								<tr>
									<th style=" width:30px; vertical-align: middle; text-align: left;"><i
										class="material-icons">chat_bubble_outline</i> SOS 내용</th>
									<td style="width: 100px; text-align: left;">${dto.content }</td>
								</tr>
								
							</table>
						</div>
				<c:if test="${dto.status eq '처리중' }">
					<div class="row valign-wrapper">
					<div class="col s10">
						<p id="notyet"><i class="material-icons" style="color: red; font-size: 0.7em;">error</i> 처리 미완료</p>
					</div>
					</div>
				</c:if>
				<c:if test="${dto.status eq 'done'}">
						<div class="row valign-wrapper">
							<div class="col s2">
								<img src="/Meeting/images/seokhyun/yuna.jpg" alt=""
									class="circle responsive-img">
								<!-- notice the "circle" class -->
							</div>
							<div class="col s10">
								<span><i class="material-icons">person_pin</i> 담당 매니저:${mdto.name}(${mdto.id })</span><hr />
								<span class="black-text"> ${dto.statuscontent} </span> <hr /> <span>처리날짜_${dto.statusregdate }</span>
							</div>
						</div>
				</c:if>		
						
						
					</div>
				</div>

			</c:forEach>



			</div>

		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>