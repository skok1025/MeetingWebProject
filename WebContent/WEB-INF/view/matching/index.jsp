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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<jsp:include page="/inc/asset.jsp"></jsp:include>

<style>
#content {
	min-height: 1400px;
}

#matchingExplain {
	padding: 30px;
	margin: 20px auto;
	/* background-color: #EF9A9A; */
	border: 1px solid #ccc;
	border-radius: 10px;
	width: 700px;
	height: 700px;
}

#h4 {
	font: #ccc;
}

#matchingExplainH1 {
	border-radius: 15px;
	font: white;
	width: 800px; margin-top : 20px;
	padding: 10px;
	margin-top: 20px;
}

#match {
	float: left;
	background-color: #F3C8BF;
	border-radius: 15px;
	width: 80px;
	padding: 3px;
}

#matchImage {
	float: right;
	background-color: #F3C8BF;
	border-radius: 15px;
	width: 30px;
	padding: 3px;
}

a:visited {
	color: black;
	text-decoration: none;
}

.matchInfo {
	font-size: 25px;
	font-family: 'InkLipquid';
	line-height: 1.2em;
	margin: 15px auto;
	font-style: italic;
}

#loveSentense {
	background-color: #F3C8BF;
}

#stepExp{
	border: 0px solid orange;
	padding-left: 10px;
}

#stepExp > ul > li{
	margin-bottom:10px;
	font-size: 15px;
}

.editIcon{
	color: #96759A;
	border: 0px solid blue;
	text-align: right;
	padding: 0px;
	padding-right: 20px;
}



.editIcon > i:hover{
	cursor: pointer;
}

</style>

<script>
   $(document).ready(function(){
      $(".dropdown-trigger").dropdown();
   });
   </script>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="matching" name="pageName" />
		</jsp:include>

		<main class="mdl-layout__content">
		<jsp:include page="/inc/sub.jsp"></jsp:include>
		<jsp:include
			page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>매칭</h1>

			<h2>시스템 설명</h2>
			<div id="loveSentense"
				style="border: solid 1px #ccc; border-radius: 10px; text-align: center;">
				<p class="matchInfo">
					"낱말 하나가 삶의 무게와 고통에서 우리를 해방시킨다.<br> 그말은 사랑이다."<br> 소포클래스
			</div>
			<div>
				<div id="matchingExplainH1" style="float: left;">
					<h4>매칭</h4>
					<br>
					<p style="padding-left: 10px; line-height: 2.5em; font-size:15px;">
						광민愛듀오는 
						<span style="border: 1px solid #a9a9a9; border-radius: 15px; padding: 5px; background-color: #F3C8BF;">단계별 매칭</span>과 
						<span style="border: 1px solid #a9a9a9; border-radius: 15px; padding: 5px; background-color: #F3C8BF;">매니저
							추천 매칭</span>을 통해 회원 여러분들에게 다양한 인연을 소개시켜드립니다.<br>매칭에 대한 설명을 읽어보신 후,
						원하는 매칭 방법을 선택해주세요.
					</p>
				</div>
			</div>
			<div style="clear: both;"></div>
			<hr style="border: solid 1px black;">
			
			
			<div style="border: 0px solid red; margin-bottom: 30px;">
				<h4 style="margin-bottom: 15px;">단계별 매칭</h4>
				<div>
					<h6 style="padding-left: 10px;">단계별 매칭은 다음과 같이 이루어집니다. </h6>
				</div>
				
				<div id="stepExp">
					<ul>
						<li style="list-style: decimal; list-style-position: inside;">나이 별 선택 : 원하는 최대, 최소 나이를 설정할 수 있습니다.</li>
						<li style="list-style: decimal; list-style-position: inside;">지역 별 선택 : 도, 시를 설정하여 원하는 도시를 선택할 수 있습니다.</li>
						<li style="list-style: decimal; list-style-position: inside;">성향 별 선택 : 회원 가입시, 생성된 회원 여러분의 성향과 이상형의 성향 그래프를 분석하여 비교할 수 있습니다.</li>
					</ul>
				</div>
				<div class="editIcon">
					<i class="medium material-icons" onclick="location.href='/Meeting/matching/stepmatching.do';">edit_location</i>
					<div>매칭 이동</div>
				</div>
			</div>
			
			
			<div style="border: 0px solid red;">
				<h4  style="margin-bottom: 15px;">매니저 추천 매칭</h4>
				<div>
					<h6 style="padding-left: 10px;">매니저 추천 매칭은 다음과 같이 이루어집니다. </h6>
				</div>
				
				<div id="stepExp">
					<ul>
						<li style="list-style: decimal; list-style-position: inside;">여러분의 담당 매니저가 랜덤으로 n명의 이성을 소개시켜드립니다.</li>
						<li style="list-style: decimal; list-style-position: inside;">추천받은 n명의 이성 중, 호감가는 이성을 선택합니다.</li>
						<li style="list-style: decimal; list-style-position: inside;">선택시, 상대방에게 수락 및 거절 메시지가 전송됩니다.</li>
						<li style="list-style: decimal; list-style-position: inside;">상대방이 수락하여 매칭이 이루어지면 연락처를 교환할 수 있습니다.</li>
						<li style="list-style: decimal; list-style-position: inside;">상대방이 거절할 경우, 매칭은 이루어지지 않으며 다른 이성을 찾을 수 있습니다.</li>
					</ul>
				</div>
				<div class="editIcon">
					<i class="medium material-icons" onclick="location.href='/Meeting/matching/managermatching.do';">edit_location</i>
					<div>매칭 이동</div>
				</div>
			</div>
		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include>
		</main>
	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>

</html>