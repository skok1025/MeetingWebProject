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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
   rel="stylesheet">

<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>

   #exp{
      border: 0px solid red;
      padding: 10px;
      margin-bottom: 20px;
   }
   
</style>

<script>
	$(document).ready(function(){
		
		$("#buttonMatch1").click(function(){
			var pseq = $("#buttonMatch1").val();
			child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq="+pseq+"","child", "width=500, height=500");
		});
		$("#buttonMatch2").click(function(){
			var pseq = $("#buttonMatch2").val();
			child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq="+pseq+"","child", "width=500, height=500");
		});
		$("#buttonMatch3").click(function(){
			var pseq = $("#buttonMatch3").val();
			child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq="+pseq+"","child", "width=500, height=500");
		});
		$("#buttonMatch4").click(function(){
			var pseq = $("#buttonMatch4").val();
			child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq="+pseq+"","child", "width=500, height=500");
		});
		$("#buttonMatch5").click(function(){
			var pseq = $("#buttonMatch5").val();
			child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq="+pseq+"","child", "width=500, height=500");
		});
		$("#buttonMatch6").click(function(){
			var pseq = $("#buttonMatch6").val();
			child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq="+pseq+"","child", "width=500, height=500");
		});listCustomer
		$("#buttonMatch7").click(function(){
			var pseq = $("#buttonMatch7").val();
			child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq="+pseq+"","child", "width=500, height=500");
		});
		$("#buttonMatch8").click(function(){
			var pseq = $("#buttonMatch8").val();
			child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq="+pseq+"","child", "width=500, height=500");
		});
		$("#buttonMatch9").click(function(){
			var pseq = $("#buttonMatch9").val();
			child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq="+pseq+"","child", "width=500, height=500");
		}); 
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
		<jsp:include page="/inc/sublist.jsp"></jsp:include>
     
      <div id="content" class="mdl-grid portfolio-max-width">


         <h1>매칭</h1>
         <h2>매니저 매칭</h2>
         
         <div id="exp">
            <h5 style="padding-bottom: 20px;">매니저 추천 목록</h5>
            광민愛듀오 매니저 추천입니다!<br> 추천 목록을 확인한 후, 마음에 드시는 이성에게 <span style=" font-weight: bold; color: #5192C6;">매칭 신청</span>을 해주세요!<br><br>
            <span style="font-size: 1.1em;">좋은 인연을 맺을 수 있기를 <span style="color: #EE3B3E; font-weight: bold;">광민愛듀오</span>가 기원합니다.</span>
         </div>
         
         
         <!-- 카드 전체 div -->
         <div id="matchingExplain" class="#ef9a9a red lighten-3">
            <main class="mdl-layout__content">
            
            
            
            <div class="mdl-grid portfolio-max-width">
            
               <c:forEach var="dto" items="${listCustomer}" varStatus="status">
                  <div class="mdl-cell mdl-card mdl-shadow--4dp portfolio-card">
                  
                     <div class="mdl-card__media" style="text-align: center; background-color: rgba(238,59,62,.4);">                        
                        <div style="border: 0px solid red; width: 60px; height: 60px; float: left;"><img src="/Meeting/images/sangmin/${dto.managerImage }" style="width: 50px; height: 50px; margin-top: 5px; margin-left: 40px;"></div>
                        <div style="border: 0px solid blue; width: 200px; float: left; margin-top: 10px;"><span style="font-weight: bold;">${dto.managerName } 매니저님<br></span> 추천 회원입니다.</div>
                        <div style="clear: both;"></div>
                     </div>

                     <div class="mdl-card__supporting-text">
                        
                        <div style="border: 0px solid red; margin-left: 23px; width: 168px;">
                           <table>
                              <tr>
                                 <th>Name</th>
                                 <td>${dto.name }</td>
                              </tr>
                              <tr>
                                 <th>Nick</th>
                                 <td>${dto.nick }</td>
                              </tr>
                              <tr>
                                 <th>Age</th>
                                 <td>${dto.age }</td>
                              </tr>
                              <tr>
                                 <th>Job</th>
                                 <td>${dto.job }</td>
                              </tr>
                              <tr>
                                 <th>Loc</th>
                                 <td>${dto.bigarea }&nbsp;${dto.smallarea }</td>
                              </tr>
                           </table>
                        </div>
                     </div>
                     <div class="mdl-card__actions mdl-card--border">
					<div style="padding-left: 70px; margin-bottom: 20px;">
						<button class="btn btn-default waves-effect waves-light" value="${dto.seq }" id="buttonMatch${status.count}" type="submit"  name="buttonMatch""> 매칭신청 <i class="material-icons right">send</i></button>
					</div>
                     </div>
                  </div>
               </c:forEach>
                  

            </div>
         </div>

		</div>
		

         <jsp:include page="/inc/footer.jsp"></jsp:include>
      </main>
</div>s
   <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>

</html>