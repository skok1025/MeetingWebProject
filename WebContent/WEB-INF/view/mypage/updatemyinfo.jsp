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
						
							 row+="<p><label><input name='csmallarea' type='radio' value='"+item.smallarea+"' /><span>"+item.smallarea+"</span></label></p>"
						
							
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

		<main class="mdl-layout__content"> <jsp:include
			page="/inc/sub.jsp"></jsp:include> <jsp:include
			page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>My Page</h1>
			<h2>개인정보수정</h2>


<form action="/Meeting/mypage/updatemyinfook.do" method="post">
		<input type="hidden" id="cid" name="cid" value="${id}" />
			<div id="mainbox" class="z-depth-3">
				<div class="txtbox1">
					<p>1. 이름</p>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" name="cname" id="cname"
							value="${name }"> <label class="mdl-textfield__label"
							for="sample3">name</label>
					</div>
				</div>

				<div class="txtbox1">
					<p>2. 닉네임</p>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
						style="float: left;">
						<input class="mdl-textfield__input" type="text" name="cnick" id="cnick"
							value="${nick}"> <label class="mdl-textfield__label"
							for="sample3">nick</label>
					</div>
				</div>
				<div style="clear: both;">



					<div class="txtbox1">
						<p>3.수정할 비밀번호</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<input class="mdl-textfield__input" type="password" name="cpw" id="cpw"
								value="${pw}"> <label class="mdl-textfield__label"
								for="sample3">pw</label>
						</div>
					</div>

					<div class="txtbox1">
						<p>4.수정할 비밀번호 확인</p>
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
							style="float: left;">
							<input class="mdl-textfield__input" type="password" name="cpwcheck" id="cpwcheck"
								value="${pw}"> <label class="mdl-textfield__label"
								for="sample3">pwcheck</label>
						</div>
					</div>
					<div style="clear: both;">


						<div class="txtbox1">
							<p>5. 전화번호</p>
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" name="ctel" id="ctel"
									value="${tel}"> <label class="mdl-textfield__label"
									for="sample3">tel</label>
							</div>
						</div>

						<div class="txtbox1">
							<p>6. 나이</p>
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
								style="float: left;">
								<input class="mdl-textfield__input" type="number" name="cage" id="cage"
									value="${age}"> <label class="mdl-textfield__label"
									for="sample3">age(only number)</label>
							</div>
						</div>
						<div style="clear: both;">


							<div class="txtbox1">
								<p>7. 키</p>
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<input class="mdl-textfield__input" type="number" name="cheight" id="cheight"
										value="${height}"> <label class="mdl-textfield__label"
										for="sample3">height(cm)</label>
								</div>
							</div>

							<div class="txtbox1">
								<p>8. 장점</p>
								<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<input class="mdl-textfield__input" type="text" name="cability" id="cability"
										value="${ability}"> <label
										class="mdl-textfield__label" for="sample3">ability</label>
								</div>
							</div>
							<div style="clear: both;">




								<div class="txtbox1">
									<p>9. 취미</p>
									<div
										class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
										<input class="mdl-textfield__input" type="text" name="csmallhobby" id="csmallhobby"
											value="${smallhobby }"> <label
											class="mdl-textfield__label" for="sample3">smallhobby</label>
									</div>
								</div>

								<div class="txtbox1">
									<p>10. 직업</p>
									<div
										class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
										<input class="mdl-textfield__input" type="text" name="cjob" id="cjob"
											value="${job }"> <label class="mdl-textfield__label"
											for="sample3">job</label>
									</div>
								</div>
								<div style="clear: both;">



									<div class="txtbox1">
										<p>10. 대지역</p>
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
											style="float: left;">
											<select id="cbigarea" name="cbigarea">
												
												<c:forEach items="${bigareaList}" var="bigArea">
													<c:if test="${bigArea == mybigarea }">
													<option value="${bigArea}" selected>${bigArea}</option>		
													</c:if>	
													<c:if test="${bigArea != bigarea }">
													<option value="${bigArea}" >${bigArea}</option>		
													</c:if>				
												</c:forEach>
											
											</select> <label>Materialize Select</label>
										</div>
									</div>

									<div class="txtbox1">
										<p>11. 소지역</p>
										<!-- <div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
											style="float: left;">
											<select id="csmallarea" name="csmallarea">
											<option value="오곡동">오곡동</option>	
											</select> <label>Materialize Select</label>
										</div> -->
										<div id="smallareaBox">
										<p>
									      <label>
									        <input name="csmallarea" type="radio" value="${mysmallarea}" checked />
									        <span>${mysmallarea }</span>
									      </label>
									    </p>
    									</div>
									</div>
									<div style="clear: both;"></div>

									<div class="txtbox1">
										<p>12. 자기소개-</p>
										<div
											class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
											style="float: left;">
											<textarea class="materialize-textarea" id="cintroduce" name="cintroduce"
												style="width: 650px; height: 300px;">${introduce }</textarea>
										</div>
									</div>
									<div style="clear: both;"></div>

									<div id="editbtns" style="margin: 10px auto; text-align: center;">
										<button type="submit"
											id="editbt" style="text-align: center;" class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">
											수정하기</button>
									</div>
								</div>
</form>
								<jsp:include page="/inc/footer.jsp"></jsp:include>
		</main>
	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>