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

#tbl td{
	width: 300px;
}

.content {
	height: 300px;
}
</style>

<script>
$(document).ready(function(){
    $('.modal').modal();
    $('select').formSelect();
    
    $("#users").change(function(){
    	location.href = "/Meeting/mypage/manager/managersoslistdone.do?userid="+$("#users").val();
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
			<h2>manager SOS</h2>
			<div id="desc">
				<p>담당회원들의 처리된 SOS 리스트입니다.</p>

			</div>
			<div id="mainbox" class="z-depth-3">
				<a href="/Meeting/mypage/manager/managersos.do" id="bt"
					class="btn waves-effect waves-light" name="action"> <i
					class="material-icons">compare_arrows</i> 처리해야할 Manager SOS 내역
				</a>
				 
				<div style="width: 300px;" >
					<p style="font-size: 2em;">작성자</p>
					<select name="users" id="users">
						<option value="">전체</option>
						<c:forEach items="${clist }" var="dto">
							<option value="${dto.id }">${dto.name}(${dto.id })</option>
						</c:forEach>
						
					</select>
					<script>
						$("#users").val("${suserid}");
					</script>
				</div>
				<c:forEach items="${mlist }" var="dto" varStatus="status">
				 
					  
				
					<form action="/Meeting/mypage/manager/managersosdelok.do"
						method="post">
						<table id="tbl" class="mdl-data-table mdl-js-data-table">
							<tr>
								<th style="width: 30px;"><i class="material-icons">event</i>
									작성 날짜</th>
								<td>${dto.regdate}</td>
							</tr>
							<tr>
								<th><i class="material-icons">person</i> 작성자(아이디)</th>
								<td>${dto.name}(${dto.id })</td>
							</tr>
							<tr>
								<th style="vertical-align: middle; height: 100px;"><i
									class="material-icons">chat_bubble_outline</i> SOS 내용</th>
								<td>${dto.content }</td>
							</tr>
							<tr>
								<th><i class="material-icons">event_available</i> 처리 여부</th>
								<td>완료</td>
							</tr>
							<tr>
								<th style="vertical-align: middle;"><i
									class="material-icons">person_pin</i> 처리내용 작성란</th>
								<td>${dto.statuscontent }</td>
							</tr>
							<tr>
								<td colspan="2">
									<div id="btns" style="margin: 30px auto; text-align: center;">
										<button type="submit" id="delbt" style="text-align: center;"
											class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">
											매니저 SOS 삭제하기 <i class="material-icons">delete</i>
										</button>
									</div>
								</td>
							</tr>
						</table>
						<input type="hidden" id="seq" name="seq" value="${dto.seq }" />
					</form>

				</c:forEach>



			</div>

		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	
</body>

</html>