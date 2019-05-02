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
	min-height: 1000px;
}

#explain {
	background-color: rgba(252, 209, 181);
	padding-bottom: 40px;
}

#logo {
	width: 100px;
	height: 100px;
	margin: 40px 40px;
}

#box {
	/* border: 1px solid gray; */
	margin-top: 40px;
	min-height: 1000px;
} 

#search { 
	height : 60px;
	width: 550px;
	text-align: right;
	display: inline-block;
	margin-left: 300px;
	margin-top: 30px;
}

.btn, .btn:focus {
	background-color: #ff8a80;
}

.btn:hover {
	background-color: #ffab91;
}

#column {
	width: 90px;
	color: #ff8a80;
	/* border: 1px solid #ff8a80; */
}

.card {
	width: 270px;
	height: 230px;
}

.card-image {
	margin: 0px 0px;
	width: 120px;
	height: 230px;
	/* border: 1px solid green; */
}

.card-image > img {
	width: 120px !important;
	height: 230px !important;
}

.col .card {
	/* display: inline-block; */
	float: left;
	margin-left: 12px;
}


#pagebar{
	/* text-align: center; */
	display: inline-block;
	margin-top: 100px;
	margin-left: 250px;
}

#btns{
	float: right;
	margin: 20px;
	width: 500px;
	/* border: 1px solid blue; */
	padding-left: 350px;
}
.card.horizontal .card-image {
  max-width: 100%;
}
#column {
	width : 150px;
}
</style>

<script>
	$(document).ready(function() {
		$("#column").formSelect();
		console.log(pagebar);

		$("#sub").css({
			position : "fixed",
			left : window.innerWidth - 300
		})

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
			<h2>추천 데이트 코스</h2>


			<div id="box">

				<div id="explain">
					<img src="../images/logo.png" id="logo"> <span
						style="font-size: 2em; margin-bottom: 0px;">"광민愛듀오"가 추천하는
						데이트 코스<i class="small material-icons" style="color: #ff1744;">&nbsp;wb_sunny</i>
					</span>
					<div
						style="margin-left: 180px; font-size: 20px; margin-bottom: 10px;">"광민愛듀오"는
						여러분을 위해 여러 코스를 추천해드립니다.</div>
					<div style="margin-left: 180px; font-size: 20px;">"광민愛듀오"가
						추천하는 데이트 코스를 통해 데이트 한 후, 후기를 남겨주세요!</div>
				</div>

				<div id="search">

					<form class="form-inline" action="/Meeting/community/daterecommend.do" method="get">
						<select name="column" id="column" class="browser-dafault">
							<option value="" disabled selected>카테고리</option>
							<option value="음식점">음식점</option>
							<option value="카페">카페</option>
							<option value="산책로">산책로</option>
							<option value="이색데이트">이색데이트</option>
						</select>
	
						<script>
							<c:if test="${isSearch}">
							$("#column").val("${map.column}");
							</c:if>
						</script>
	
						<input type="text" name="word" id="word" style="width: 250px;"
							required value="${map.word}">
	
						<button class="btn btn-default waves-effect waves-light"
							type="submit" name="action">
							검색 <i class="material-icons right">send</i>
						</button>
					</form>
				</div>

				<c:set var="i" value="1" />
				<c:forEach items="${dclist }" var="dto" >
					<div class="col s12 m7">
						<div class="card horizontal">
							<div class="card-image">
								<c:if test="${dto.category == '음식점'}">
									<div class="card-image">
										<img src="../images/미령_image/음식점${i}.jpg">
										<c:if test="${i == 9}">
										
											<c:set var="i" value="1" />
											
										</c:if>
									</div>
									
								</c:if>
								<c:if test="${dto.category == '카페'}">
									<div class="card-image">
										<img src="../images/미령_image/카페${i}.jpg">
										<c:if test="${i == 9}">
										
											<c:set var="i" value="1" />
											
										</c:if>
									</div>
								</c:if>
								<c:if test="${dto.category == '산책로'}">
									<div class="card-image">
										<img src="../images/미령_image/산책로${i}.jpg">
										<c:if test="${i == 9}">
										
											<c:set var="i" value="1" />
											
										</c:if>
									</div>
								</c:if>
								<c:if test="${dto.category == '이색 데이트'}">					
									<div class="card-image">
										<img src="../images/미령_image/이색데이트${i}.png">
										<c:if test="${i == 9}">
										
											<c:set var="i" value="1" />
											
										</c:if>
									</div>
								</c:if>
							</div>
							

							<div class="card-stacked">
								<div class="card-content">
									<p>
										<b>가게명</b><br>${dto.title }
									</p>
									<p>
										<b>지역</b><br>${dto.area }
									</p>
								</div>
								<div class="card-action"
									style="padding: 0px; text-align: center; height: 32px;">
									<a href="/Meeting/community/daterecommenddetail.do?seq=${dto.seq}&column=${map.column}&word=${map.word}">상세 보기</a>
								</div>
							</div>
						</div>
					</div>
					<c:set var="i" value="${i+1}" />
				</c:forEach>
		
				<div id="pagebar">${pagebar }</div>	
						
				<div id="btns">
				<c:if test="${iswho}">
					<input type="button" value="쓰기"
						class="btn btn-primary"
						onclick="location.href='/Meeting/community/daterecommendadd.do?mode=new';">
				</c:if>
					<input type="button" value="목록"
						class="btn btn-default"
						onclick="location.href='/Meeting/community/daterecommend.do';">
				</div>
				
				<div style="clear: both;"></div>
				
			</div>

			
		</div>

		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>