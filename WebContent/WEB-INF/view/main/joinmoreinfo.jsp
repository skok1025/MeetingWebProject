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

p {
	font-family: 'SeoulNamsanM';
}

.txtbox1 {
	float: left;
	margin: 20px;
	margin-left: 50px;
}

select {
	width: 300px;
}
</style>

<script>
	$(document).ready(function() {

		$('select').formSelect();
		$('#csmallarea').formSelect();
		
		//$("#cbigarea").val(${bigarea});
		//$("input[name='smallarea']").val();
	
		$("#cbigarea").change(function(){
			//alert($("#cbigarea").val());
			$("#csmallarea").html("");
			$.ajax({
				type:"post",
				url: "/Meeting/mypage/areaget.do",
				data: "bigarea="+$("#cbigarea").val(),
				dataType:"json", // 서버로부터 돌려받을 데이터 타입
				success:function(result){
					console.log(result);
					$("#smallareaBox").html("");
					/* 
					<p>
				      <label>
				        <input name="smallarea" type="radio"  />
				        <span>Red</span>
				      </label>
				    </p>
				     */
					/* 
					var option="";
					$(result).each(function(index,item){
						option += "<option value='"+item.smallarea+"'>"+ item.smallarea + "</option>";
					});
						$("#csmallarea").append(option);
					 */
					/*  
					for(var i=0;i<result.length;i++){
						$("#csmallarea").append("<option value='"+result[i]['smallarea']+"'>"+ result[i]['smallarea'] + "</option>");
					}
					 */
					 
					var row = "";
					 $(result).each(function(index,item){
						
							 row+="<p><label><input name='saseq' type='radio' value='"+item.seq+"' /><span>"+item.smallarea+"</span></label></p>"
						
							
					 });
					 $("#smallareaBox").append(row);
					 
				},
				error:function(a,b,c){
					console.log(a+b+c);
				}
				
			}); 
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
			<h1>Register</h1>
			<h2>개인정보 작성</h2>


<form action="/Meeting/main/joinlovetest.do" method="post">
		
			<div id="mainbox" class="z-depth-3">
				<div class="txtbox1">
					<p>1. 전화번호</p>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" name="tel" id="tel"
							> <label class="mdl-textfield__label"
							for="sample3">tel</label>
					</div>
				</div>

				<div class="txtbox1">
					<p>2. 나이</p>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
						style="float: left;">
						<input class="mdl-textfield__input" type="number" name="age" id="age"
							value=""> <label class="mdl-textfield__label"
							for="sample3">age (only number)</label>
					</div>
				</div>
				<div style="clear: both;">



				<div class="txtbox1">
					<p>3.특기</p>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" name="ability" id="ability"
							> <label class="mdl-textfield__label"
							for="sample3">ability</label>
					</div>
				</div>

				<div class="txtbox1">
					<p>4.키 (단위:cm)</p>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
						style="float: left;">
						<input class="mdl-textfield__input" type="number" name="height" id="height"
							> <label class="mdl-textfield__label"
							for="sample3">height (only number)</label>
					</div>
				</div>
				<div style="clear: both;">


					<div class="txtbox1">
						<p>5. 직업</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<input class="mdl-textfield__input" type="text" name="job" id="job"
								> <label class="mdl-textfield__label"
								for="sample3">job</label>
						</div>
					</div>
					<div class="txtbox1">
						<p>6. 성별</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<select name="gender" id="gender">
								<option value="남자" selected>남자</option>
								<option value="여자">여자</option>
							</select>
						</div>
					</div>

					
					<div style="clear: both;">


					<div class="txtbox1">
						<p>6. 성격유형</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<select id="pseq" name="pseq">
								<c:forEach items="${personalityList}" var="dto">
									<option value="${dto.seq}">${dto.type }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="txtbox1">
					<p>7. 닉네임</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<input class="mdl-textfield__input" type="text" name="nick" id="nick"
								> <label class="mdl-textfield__label"
								for="sample3">nick</label>
						</div>
					</div>

							
					<div style="clear: both;">


					<div class="txtbox1">
						<p>8. 대지역</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
							style="float: left;">
							<select id="cbigarea" name="cbigarea">
								
								<c:forEach items="${bigareaList}" var="bigArea">
									<option value="${bigArea}" >${bigArea}</option>		
								</c:forEach>
							
							</select> <label>Materialize Select</label>
						</div>
					</div>

					<div class="txtbox1">
						<p>9. 소지역</p>
						
						<div id="smallareaBox">
						
									</div>
					</div>
					<div style="clear: both;"></div>

					<div class="txtbox1">
						<p>10. 자기소개-</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
							style="float: left;">
							<textarea class="materialize-textarea" id="introduce" name="introduce"
								style="width: 650px; height: 300px;" placeholder="자기소개를 작성하세요."></textarea>
						</div>
					</div>
					<div style="clear: both;"></div>

					<div id="nextbtns" style="margin: 10px auto; text-align: center;">
						<button type="submit"
							id="nextbt" style="text-align: center;" class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">
							다음단계로</button>
					</div>
					
								
					<div style="clear: both;"></div>
								
								<input type="hidden" name="name" value="${name}" />
								<input type="hidden" name="id" value="${id}" />
								<input type="hidden" name="pw" value="${pw}" />
								<input type="hidden" name="mseq" value="${mseq}" />
</form>
						</div>
								<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>