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
</style>

<script>
   $(document).ready(function(){
      
     
      
      $("#password").keydown(function(event) {
          //alert(event.keyCode);
          if(event.keyCode==13){
        	 //alert("Enter");
        	  $("#pwcheck").submit();
          }
      });
      
      
      
      
   });
   </script>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="mypage" name="pageName"/>
		</jsp:include>

		<main class="mdl-layout__content"> 
		<jsp:include page="/inc/sub.jsp"></jsp:include>
		<jsp:include page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>My Page</h1>
			<h2>개인정보수정</h2>
			<form id="pwcheck" action="/Meeting/mypage/updatepwok.do" method="post">
				<div class="row" style="margin-top: 200px;">
					<p style="text-align: center;">비밀번호를 입력해주세요:</p>
					<div class="input-field" style="width: 300px; margin: 0px auto;">
						
						<input id="password" name="password" type="password" class="validate"> <label
							for="password"> <i class="material-icons">https</i><i style="margin-left: 10px;">Password</i></label>
					</div>
				</div>
			</form>

		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>