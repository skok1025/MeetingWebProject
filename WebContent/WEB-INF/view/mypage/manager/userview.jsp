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

#picbox {
	background-color: #DE9391;
	width: 500px;
	margin: 10px auto;
	padding: 10px;
}



#picbox>img {
	margin: 20px;
	width: 200px;
}

p {
	font-family: 'SeoulNamsanM';
}

.txtbox1 {
	float: left;
	margin-top: 30px;
	margin-left: 40px;
}

.left {
	margin-left: 120px;
}

select {
	width: 300px;
}

.bigfont {
	font-size: 20px;
	font-weight: bold;
}

#changbt{
	background-color: #FFB2D9;
	margin-top:-100px;
	width: 150px;
	height: 80px;
}

#profileName{
	color: white;
	font-size: 1.5em;
	font-weight: bold;
	padding-top: 50px;
}

.img_wrap{
	width: 300px;
	margin-top: 50px;
}

.img_wrap img{
	width: 150px; 
}


#chartbox{
	background-color: #F0F8FF;
	width: 500px;
	height:350px;
	margin: 30px auto;
	padding: 10px;
}
#graph{
		width: 500px;
		height: 250px;
		margin: 30px auto;
	}
	
	.graph-title{
		font-size: 2.5em;
		font-weight: bold;
		text-align: center;
		margin: 20px 0 0;
	}

</style>
<script src="/Meeting/asset/js/flotr2.min.js"></script>

<script>
	$(document).ready(function() {
		$('.modal').modal();
		$("#input_img").on("change",handleImgFileSelect);
	});
	
	function handleImgFileSelect(e){
		var files = e.target.files;
		var fileArr = Array.prototype.slice.call(files);
		
		fileArr.forEach(function(f){
			if(!f.type.match("image.*")){
				alert("확장자는 이미지 확장자만 가능합니다.");
				return;
			}
			
			sel_file = f;
			
			var reader = new FileReader();
			reader.onload = function(e){
				$("#img").attr("src",e.target.result);
			}
			reader.readAsDataURL(f);
		});
	}
</script>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="mypage" name="pageName" />
		</jsp:include>

		<main class="mdl-layout__content"> <jsp:include
			page="/inc/sub.jsp"></jsp:include> <jsp:include
			page="/inc/sublist.jsp"></jsp:include>
		
		<!-- Modal Structure -->
  <div id="modal1" class="modal">
    <div class="modal-content">
      <h4>프로필 사진 변경</h4>
      <form action="/Meeting/mypage/manager/addprofileok.do" method="post" enctype="multipart/form-data">
      	<h3>이미지 미리보기</h2>
      	<input type="file" name="profileim" id="input_img" required />
      	<p class="title">변경할 이미지</p>
      	<div>
			<div class="img_wrap">
				<img id="img"/>
			</div>
      	</div>
    </div>
    <div class="modal-footer">
      <button type="submit" class="modal-close waves-effect waves-green btn-flat">Agree</button>
    </div>
  </div>
  <input type="hidden" id="userid" name="userid" value="${userid}" />
      </form>
		
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>My Page</h1>
			<h2>나의 정보</h2>

 
			<input type="hidden" id="cid" name="cid" value="${id}" />
			<div id="mainbox" class="z-depth-3">



				<div id="chartbox" class="z-depth-1">
						
						<p class="graph-title">${dto.name } 님의 매력 포인트</p>
						<div id="graph"></div>
						<script>
						(function basic_radar(container){
							var s1 = {
								label:"${dto.name}", 
								data:[
									[0,${scoredto.plan}],
									[1,${scoredto.humor}],
									[2,${scoredto.alacrity}],
									[3,${scoredto.sense}],
									[4,${scoredto.extrovert}],
									[5,${scoredto.style}]
								]
								},
								s2 = {
										label:"${gender} 평균", 
										data:[
											[0,${avgdto.plan}],
											[1,${avgdto.humor}],
											[2,${avgdto.alacrity}],
											[3,${avgdto.sense}],
											[4,${avgdto.extrovert}],
											[5,${avgdto.style}]
										]
								},
								graph, ticks;
								ticks = [
									[0,"계획성"],
									[1,"유머러스"],
									[2,"순발력"],
									[3,"센스"],
									[4,"외향적"],
									[5,"스타일"]
								];
								graph = Flotr.draw(container,[s1,s2],{
									radar:{
										show:true
									},
									grid:{
										circular:true,
										minorHorizontalLines:true
									},
									yaxis:{
										min:0,
										max:10,
										minorTickFreq:1
									},
									xaxis:{
										ticks:ticks
									}
								});
						})(document.getElementById("graph"));
					
					</script>
				</div>


				<div id="picbox" class="z-depth-1">
					<c:if test="${dto.image eq 'null' }">
						<img style="float:left; " src="/Meeting/images/seokhyun/noprofile.png"> 
					</c:if>
					<c:if test="${dto.image != 'null' }">
					<img style="float:left; " src="/Meeting/profile/${dto.image}"> 
					</c:if>
					<p id="profileName" style="float: left;">${dto.name} 님의 프로필 사진</p>
					<div style="clear: both;"></div>
					<a href="#modal1" style="float:right; " id="changbt" class="btn waves-effect waves-light modal-trigger" type="submit"
						name="action">
						<i class="material-icons">compare_arrows</i><br />
						프로필 사진 교체
					</a>
					
					<div style="clear:both; "></div>
				</div>

				<div class="txtbox1 left">
					<p>1. 이름</p>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<p class="bigfont">${dto.name }</p>
					</div>
				</div>

				<div class="txtbox1">
					<p>2. 닉네임</p>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<p class="bigfont">${dto.nick }</p>
					</div>
				</div>
				<div style="clear: both;">

					<div class="txtbox1 left">
						<p>3. 전화번호</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<p class="bigfont">${dto.tel }</p>
						</div>
					</div>

					<div class="txtbox1">
						<p>4. 나이</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<p class="bigfont">${dto.age}세</p>
						</div>
					</div>
					<div style="clear: both;"></div>


						<div class="txtbox1 left">
							<p>5. 키</p>
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<p class="bigfont">${dto.height}cm</p>
							</div>
						</div>

						<div class="txtbox1">
							<p>6. 특기</p>
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<p class="bigfont">${dto.ability }</p>
							</div>
						</div>
						<div style="clear: both;"></div>




							<div class="txtbox1 left">
								<p>7. 취미</p>
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<p class="bigfont">${dto.smallhobby }</p>
								</div>
							</div>

							<div class="txtbox1">
								<p>8. 직업</p>
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<p class="bigfont">${dto.job }</p>
								</div>
							</div>
							<div style="clear: both;">



								<div class="txtbox1 left">
									<p>9. 대지역</p>
									<div
										class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
										<p class="bigfont">${dto.bigarea }</p>
									</div>
								</div>

								<div class="txtbox1 ">
									<p>10. 소지역</p>
									<div
										class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
										<p class="bigfont">${dto.smallarea }</p>
									</div>
								</div>
								<div style="clear: both;"></div>

								<div class="txtbox1 left z-depth-1" style="border: 1px solid; width: 500px;">
									<p>11. 자기소개-</p>
									<div style="width: 500px; padding: 20px;"
										class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
										<p class="bigfont">${dto.introduce }</p>
									</div>
								</div>
								<div style="clear: both;"></div>


							</div>
							<div style="clear: both;"></div>
							</div>
							</div>
							<jsp:include page="/inc/footer.jsp"></jsp:include>
		</main>
	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>