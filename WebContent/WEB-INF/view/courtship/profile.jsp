<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
   <head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="A portfolio template that uses Material Design Lite.">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<title>Template</title>
		
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
		<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.grey-pink.min.css" />
		<link rel="stylesheet" href="/Meeting/asset/css/materialize.css" />
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="/Meeting/timeasset/flipclock.css">
		<link rel="stylesheet" href="/Meeting/asset/css/styles.css" />
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src="/Meeting/asset/js/clock.js"></script>
		<script src="/Meeting/asset/js/jquery-1.12.4.js"></script>
		<script src="/Meeting/asset/js/materialize.js"></script>
		<script src="/Meeting/timeasset/flipclock.js"></script>

       <jsp:include page="/inc/asset.jsp"></jsp:include>
		<style>
		   #content {
		        min-height: 1000px;
		    }
		    
		    .card {
			     width : 350px;
			     height : 350px;           
		    }
		    
		   	#golink {
		   		float : left;
		   		width : 350px;	
		   		text-align: center;
		   	}
		    
		    .material-icons {
		    	font-size : 50px;
		    	color: #ff8a80;
		    }
		    
		    #fomr1 {
		    	display: inline-block;
		    	float : left;
		    	width : 20px;
		    	margin-left : 10px;
		    }
		    
		    #img {
		    	margin-bottom : 0px;
		    }
		    
		    #graph{
				width: 440px;
				height: 250px;
			}
		  
		  	#chartbox {
		  		float : left;
		  	}
		  	
		  	#btn {
		  		margin-left : 550px;
		  	}
		  	
		</style>
       
		<script>
			$(document).ready(function(){
				$('.carousel').carousel();
				
				$("#mail_outline").click(function(){
					child = window.open("/Meeting/courtship/profilemessage.do?pseq=${seq}&seq=${cseq}","child", "width=500, height=500");
				});
				
				$("#favorite_border").click(function() {
					
					$.ajax({
						
						type: "get",
						url: "/Meeting/courtship/profilegood.do",
						data : "pseq=${seq}&cseq=150",
						
						success: function(result) {
							console.log(result);
							if(result == "2"){
								alert("좋아요");
							} else if(result == "2"){
								alert("시스템 오류");
							} else {
								alert("이미 눌렀습니다.");
							}
						},
						error: function(a,b,c) {
							console.log(a,b,c);
						}
						
						
					});
					
				});
				
			});
			
		</script>
		<script src="<%=request.getContextPath()%>/asset/js/flotr2.min.js"></script>
   </head>
   
   <body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
          
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="courtship" name="pageName" />
		</jsp:include>
		
		<main class="mdl-layout__content">
                   <jsp:include
			page="/inc/sub.jsp"></jsp:include> <jsp:include
			page="/inc/sublist.jsp"></jsp:include>
			 
			<div id="content" class="mdl-grid portfolio-max-width">
                <h1>Profile</h1>
				<h2>이상형 찾기</h2>
			 
				<div class="row">
					<div class="col s12 m7" style="width : 420px; height : 450px;">
						<div class="card">
							<div class="card-image">
							
							<c:if test="${dto.image eq 'null' }">
								<img id="img" src="/Meeting/images/seokhyun/noprofile.png">
							</c:if>
							<c:if test="${dto.image != 'null' }">
							<img id="img" src="/Meeting/profile/${dto.image}">
							</c:if>
								<span class="card-title" style="color:black;">${dto.name}${seq }</span>
							</div>
        					<div class="card-content">
          						<p>${dto.introduce}</p>
        					</div>
        					<div id="golink">
          						<a class="golinka" href="/Meeting/courtship/profilehome.do?seq=${seq}"><i class="material-icons">home</i></a>
          						<a class="golinka" href="#" id="favorite_border"><i class="material-icons">favorite_border</i></a>
        					
	       					   	<form name="form1" id="form1" style="display: inline-block;">
									<a class="golinka"  href="#" id="mail_outline"><i class="material-icons">mail_outline</i></a>
								</form>
							</div>
     					</div>
    				</div> 
    				<div>
    					<p style="font-size : 18px;line-height: 2em;"><b>아이디 : </b>${dto.id}<br>
    					<b>닉네임 : </b>${dto.nick}<br>
    					<b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp스파이더 그래프</b></p>
						<div id="chartbox" class="z-depth-1"> 
							<div id="graph"></div>
							<script>
								(function basic_radar(container) { 
									var s1 = {
										label : "${dto.name }",
										data : [ 
											[ 0, ${dto.cplan} ], 
											[ 1, ${dto.chumor} ], 
											[ 2, ${dto.calacrity} ],
											[ 3, ${dto.csense} ],  
											[ 4, ${dto.cextrovert} ],  
											[ 5, ${dto.cstyle} ]   
										]
									}, s2 = {
										label : "평균",
										data : [ 
											[ 0, 5 ], 
											[ 1, 2 ], 
											[ 2, 1 ],
											[ 3, 5 ], 
											[ 4, 1 ], 
											[ 5, 4 ] 
										]
									}, graph, ticks;
									ticks = [ 
										[ 0, "계획성" ], 
										[ 1, "유머러스" ],
										[ 2, "순발력" ], 
										[ 3, "센스" ], 
										[ 4, "외향적" ],
										[ 5, "스타일" ] 
									];
									graph = Flotr.draw(container, [ s1, s2 ], {
										radar : {
											show : true
										},
										grid : {
											circular : true,
											minorHorizontalLines : true
										},
										yaxis : {
											min : 0,
											max : 10,
											minorTickFreq : 1
										},
										xaxis : {
											ticks : ticks
										}
									});
								})(document.getElementById("graph"));
							</script>
    					</div>
    					<input id="btn" type="submit" class="btn btn-large" value="다음 사람 보기" onclick="location.href='/Meeting/courtship/profile.do?seq=${nseq}';" style="background-color: #ff8a80;">
  					</div>
  				</div>
  				<%-- </c:if> --%>
  				   
              </div>
				<footer class="mdl-mini-footer">
					<div class="mdl-mini-footer__left-section">
      					<div class="mdl-logo">Simple portfolio website</div>
   					</div>
   					<div class="mdl-mini-footer__right-section">
						<ul class="mdl-mini-footer__link-list">
					         <li><a href="#">Help</a></li>
					         <li><a href="#">Privacy & Terms</a></li>
						</ul>
					</div>
				</footer>
           </main>
           
       </div>
       <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
   </body>
</html>




