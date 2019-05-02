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

#tbl td {
	text-align: center;
	padding-left: 50px;
}

#tbl th {
	font-size: 1.5em;
	font-weight: bold;
}

#tbl {
	width: 600px;
	margin: 10px auto;
}

.content {
	height: 300px;
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
			<h2>담당 회원 정보리스트</h2>
			<div id="desc">
				<p>매니저님의 담당회원 정보를 담은 리스트 입니다.</p>

			</div>
			<div id="mainbox" class="z-depth-3">

				<table>
					<tr>
						<th>아이디</th>
						<th>회원명</th>
						<th>닉네임</th>
						<th>나이</th>
						<th>성별</th>
						<th>가입날짜</th>
						<th>상세보기</th>
						<th>계정탈퇴</th>
					</tr>

					<c:forEach items="${clist}" var="dto">

						<tr>
							<td>${dto.id }</td>
							<td>${dto.name }</td>
							<td>${dto.nick }</td>
							<td>${dto.age }</td>
							<td>${dto.gender }</td>
							<td>${dto.regdate }</td>
							<td>
								<a type="button" id="bt" style="text-align: center;"
									class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent"
									onclick="location.href='/Meeting/mypage/manager/userview.do?id=${dto.id}';">
									${dto.name}님의 상세정보 <i class="material-icons">arrow_forward</i>
								</a>
							</td>
							<td>
								<a type="button" id="bt" style="text-align: center; background-color: #EE3B3E;"
									class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent"
									onclick="if(confirm('${dto.id}님의 계정을 삭제하시겠습니까?')) location.href='/Meeting/mypage/manager/userdelete.do?id=${dto.id}';">
									<i class="material-icons">delete</i>
								</a>
							</td>
						</tr>
					</c:forEach>

				</table>


			</div>

		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>