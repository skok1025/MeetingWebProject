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

.content{
	height:300px;
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
				<a href="/Meeting/mypage/managersoslist.do" id="bt" class="btn waves-effect waves-light"
					name="action"> <i class="material-icons">compare_arrows</i> 나의
					Manager SOS 처리내역
				</a>
				<form action="/Meeting/mypage/managersosaddok.do" method="post">
				<table id="tbl" class="mdl-data-table mdl-js-data-table">
					<tr>
						<th style="width: 30px;"><i class="material-icons">person</i> 작성자(이름)</th>
						<td>${name}(${id })</td>
					</tr>
					<tr>
						<th style="vertical-align: middle;"><i class="material-icons">chat_bubble_outline</i> SOS 내용</th>
						<td><textarea class="materialize-textarea" id="contents" name="content"
								style="width: 500px; height: 300px;" placeholder="내용을 입력해주세요."></textarea>

						</td>
					</tr>
					<tr>
						<th><i class="material-icons">person_pin</i> 담당 매니저</th>
						<td>${mdto.name}(${mdto.id })</td>
					</tr>
				</table>

				<div id="btns" style="margin: 30px auto; text-align: center;">
					<button type="submit" id="addbt" style="text-align: center;"
						class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">
						매니저 SOS 보내기 <i class="material-icons">perm_phone_msg</i></button>
				</div>
				
				<input type="hidden" name="cseq" value="${cseq}" />
				<input type="hidden" name="mseq" value="${mdto.seq}" />
				</form>
			</div>

		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>