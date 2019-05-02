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

.profilebox{
	float: left;
}

.infobox{
	float:left;
	background-color: #A4BBC8;
	width: 550px;
	height: 400px;
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

.infobox2{
	width:155px;
	padding: 20px;
	background-color:yellow;
	border:solid red;
	border-width:5px 5px 5px 0px;
	float: left;
	height: 400px;
	
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px; 
}

#chartbox{
	background-color: #F0F8FF;
	width: 200px;
	height:200px;
	float:left;
	padding: 10px;
}
.graph{
		width: 30px;
		height: 30px;
		
}
.graph-title{
		font-size: 1em;
		font-weight: bold;
		text-align: center;
		
}
</style>

<script>
$(document).ready(function(){
    $('.modal').modal();
    $('select').formSelect();
    
    $("#users").change(function(){
    	location.href = "/Meeting/mypage/manager/managersos.do?userid="+$("#users").val();
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
				<p>매니저님 안녕하세요~ 담당회원들의 매니저 SOS 리스트입니다.</p>

			</div>
			<div id="mainbox" class="z-depth-3">
				<a href="/Meeting/mypage/manager/managersoslistdone.do" id="bt"
					class="btn waves-effect waves-light" name="action"> <i
					class="material-icons">compare_arrows</i> 담당회원들에 대한 Manager SOS
					처리내역
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
				 
					  <!-- Modal Structure -->
					  <div id="modal${status.count}" class="modal">
					    <div class="modal-content">
					      <h4>${dto.name}(${dto.id}) 의 프로필 정보</h4>
					      <div class="profilebox" >
					      	<c:if test="${dto.image eq 'null' || empty dto.image }">
					      		<img src="/Meeting/images/seokhyun/noprofile.png" />
					      	</c:if>
					      	<c:if test="${not empty dto.image && dto.image != 'null'}">
					      		<img src="/Meeting/profile/${dto.image }" />
					      	</c:if>
					      </div>
					      
					      <div class="infobox z-depth-2">
					      	<div style="float: left; width: 300px;">
						      	<p><label>ID(Name):</label>${dto.id}(${dto.name})</p>
						      	<p><label>닉네임:</label>${dto.nick}</p>
						      	<p><label>나이:</label>${dto.age}</p>
						      	<p><label>특기:</label>${dto.ability}</p>
						      	<p><label>등급:</label><img style="width: 50px; margin-top: 30px;" src="/Meeting/images/seokhyun/${dto.badge}.png"/>(${dto.grade}점)</p>
						      	<p>${dto.introduce }</p>
					  		</div>
					


					      </div>
					      
					      <div class="infobox2 z-depth-2">
					      	<p>-- 이상형 정보</p>
					      	<p><label>희망 키:</label>${dto.maxheight}~${dto.minheight} cm</p>
					      	<p><label>희망 직업:</label>${dto.pjob }</p>
					      </div>
					      <div style="clear:  both;"></div>
					      
					    </div>
					    <div class="modal-footer">
					      <a href="#!" class="modal-close waves-effect waves-green btn-flat">확인</a>
					    </div>
					  </div>
				
					<form action="/Meeting/mypage/manager/managersosdoneok.do"
						method="post">
						<table id="tbl" class="mdl-data-table mdl-js-data-table">
							<tr>
								<th style="width: 30px;"><i class="material-icons">event</i>
									작성 날짜</th>
								<td>${dto.regdate}</td>
							</tr>
							<tr>
								<th><i class="material-icons">person</i> 작성자(아이디)</th>
								<td>${dto.name}(${dto.id }) <a href="#modal${status.count}"
									 id="changbt"
									class="btn waves-effect waves-light modal-trigger"
									 name="action" style="margin-left: 10px;"> 회원 프로필 확인<i class="material-icons">compare_arrows</i>
										
								</a>
								</td>
							</tr>
							<tr>
								<th style="vertical-align: middle; height: 100px;"><i
									class="material-icons">chat_bubble_outline</i> SOS 내용</th>
								<td>${dto.content }</td>
							</tr>
							<tr>
								<th><i class="material-icons">event_available</i> 처리 여부</th>
								<td>미완료</td>
							</tr>
							<tr>
								<th style="vertical-align: middle;"><i
									class="material-icons">person_pin</i> 처리내용 작성란</th>
								<td><textarea class="materialize-textarea" id="contents"
										name="statuscontent" style="width: 500px; height: 100px;"
										placeholder="내용을 입력해주세요."></textarea></td>
							</tr>
							<tr>
								<td colspan="2">
									<div id="btns" style="margin: 30px auto; text-align: center;">
										<button type="submit" id="addbt" style="text-align: center;"
											class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">
											매니저 SOS 답변하기 <i class="material-icons">perm_phone_msg</i>
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