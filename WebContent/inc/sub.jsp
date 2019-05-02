<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function(){
    $("#sub").css({
    	position:"absolute",
    	left:document.body.clientWidth-300
    });
    
    $.ajax({
		type:"get",
		url:"https://api.openweathermap.org/data/2.5/weather?q=Seoul,kr&appid=cd2e067f3829f95518538cc0f91aa4e1",
		dataType:"json",
		success:function(result){
			console.log(result);
			
			$("#weather").append("<div>현재 기온:   "+parseFloat(result.main.temp-273.15).toFixed(1) +"℃</div>")
			$("#weather").append("<div>일교차:   "+parseFloat(result.main.temp_min-273.15).toFixed(1)+"~"+parseFloat(result.main.temp_max-273.15).toFixed(1) +"℃</div>")
			$("#weather").append("<div>날씨:   "+result.weather[0].description+"</div>")
			$("#weather").append("<div><img src='http://openweathermap.org/img/w/"+result.weather[0].icon+".png'></div>")
			//$("#weather").append("<div>구름:"+result.clouds.all+"%</div>");
			
		},
		error:function(a,b,c){
			console.log(a+b+c);
		}
	});
	 
    
});
</script>
<style>
	#logintitle{
		font-size: 1.3em;
		font-weight: bold;
	}
	p > span{
		font-variant: small-caps;
		font-weight: bold;
	}
	
	#profileImageBox{
		background-color: #DE9391;
		margin-bottom: 20px;
		background-color:#ffcdcd40;
	}
	
	#profileImageBox > img{
		margin-top: 20px;
		margin-left: 20px;
	}
</style>
<div id="sub" style="position: fixed; left: 1500px;">
	<div class="clock" style="margin: 2em;"></div>
	
<c:if test="${not empty isUser || not empty isAdmin || not empty isManager }">	
	<div id="info" class="z-depth-1" style="padding: 20px; margin: 0px auto;">
	<p id="logintitle">
	<i class="material-icons">account_box</i>
	<c:if test="${isUser }">회원로그인</c:if>
	<c:if test="${isAdmin }">관리자로그인</c:if>
	<c:if test="${isManager }">매니저로그인</c:if>
	</p>
	<div id="profileImageBox">
	
	<c:if test="${empty profileimage || profileimage == 'null'}">
	<img style="width: 100px; " src="/Meeting/images/seokhyun/noprofile.png"  />
	</c:if>
	
	<c:if test="${not empty profileimage && profileimage != 'null'}">
		<% if(session.getAttribute("profileimage").toString().startsWith("https:")){ %>
				<img style="width: 100px; " src="${profileimage}"  />		
		<%} else{ %> 
				<img style="width: 100px; " src="/Meeting/profile/${profileimage}"  />
		 <%} %> 
		
	</c:if>
	
	
	</div>
		<p><span>Id:</span><%=session.getAttribute("id") %></p>
		<c:if test="${isUser}">
			<p><span>Name: </span><%=session.getAttribute("name") %></p>
			<p><span>Grade: <img style="width: 50px; margin-top: 20px;" src="/Meeting/images/seokhyun/${badge}.png"/> </span>(${grade}점)</p>
		</c:if>
		<div id="weather">
			<p style="font-weight: bold; font-size: 1.5em;">오늘의 날씨</p>
		</div>
	</div>
	
</c:if>	
<div id="btns" style="padding: 10px 20px 20px 20px;">
	<c:if test="${not empty id}">
		
			<button onclick="location.href='<%=request.getContextPath()%>/main/logout.do';" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
				Logout
			</button>
	</c:if>	
	<c:if test="${empty id}">
	<button onclick="location.href='<%=request.getContextPath()%>/main/login.do';" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
		LogIn
	</button>
	</c:if>
	
	</div>
	
</div>

