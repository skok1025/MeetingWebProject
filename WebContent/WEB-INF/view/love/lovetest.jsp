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
	   
	    <jsp:include page="/inc/asset.jsp"></jsp:include>
	    
	    <style>
	    
		    #content {
		   		min-height: 700px;
		   		margin-top : 30px;
				margin-bottom : 30px; 
		   		border : 1px solid black;
		   		background-color: #FCD3D9;
		   		text-align : center;
		  	}
		  	
		  	#content > img {
		  		width : 200px;
		  		margin-bottom: 0px;
		  	}
		  	
		  	.pq {
		  		display: none;
		  	}
		  	
		  	.question {
		  		font-size : 25px;
		  		margin-bottom : 50px;
		  		
		  	}
		  	
		  	.answer_txt { 
		  		font-size : 40px;
		  		color : black;
		  		display: inline-block;
		  		height : 150px;
		  		margin : 30px;
		  		margin-bottom: 0px;
		  	}
		 
		 	.answer_txt > a {
		 		display : inline-block;
		 		width : 150px;
		 		margin : 50px;
		 		margin-bottom : 0px;
		 	}
		 
		 	#fimg {
		 		width : 300px;
		 		margin: 0px;
		 	}
		 	
		 	#btn {
		 		color:black; 
		 		font-weight:bold; 
		 		background-color : pink; 
		 		visibility: hidden;
		 	}
		 	
	    </style>
	    
	    <script>
	       var now = 1;
	       
		   $(document).ready(function(){
		   		 $("#pq" + now).show();
		   });
		   
		   function answer(seq, result) {
			   //hidden value값을 주고
			   //다음 문제로
			   $("#hq" + seq).val(result);
			   
			   now++;
			   
			   $(".pq").hide();
			   
			   $("#pq" + now).show();

			   if(now == 13) {
				   $("#btn").css('visibility','visible');
			   }
			   
		   }
	   </script>
	</head>
	
	<body>
	    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
	       <jsp:include page="/inc/header.jsp">
	       	<jsp:param value="lovetest" name="pageName" />
	       </jsp:include>
	        
	        <main class="mdl-layout__content">
	                
	            <jsp:include page="/inc/sub.jsp"></jsp:include>
<jsp:include page="/inc/sublist.jsp"></jsp:include>
	            <div id="content" class="mdl-grid portfolio-max-width">
	               
	                <img class="article-image" src="/Meeting/images/임광민/하트.PNG">
	                
	                <hr />
	                
	                <form action="/Meeting/love/lovetestresult.do" method="get">
		                
		                <div id="question">
		               		<c:forEach items="${list}" var="list">
		               			<div id="pq${list.seq}" class="pq">
			               			<div class="question" id="q${list.seq}">Q. ${list.content}</div>
			               			
		               				<span class="answer_txt"><a href="javascript:answer(${list.seq},'y');">YES</a></span>
		               				<span class="answer_txt"><a href="javascript:answer(${list.seq},'n');">NO</a></span>
			               			
			               			<hr />
			               			
			               			<input type="hidden" name="hq${list.seq}" id="hq${list.seq}" value="">
		               			</div>
		               			
		               		</c:forEach>
		               		
		               		<input id="btn" type="submit" value="바로 확인하기" class="btn-large" />
		                </div>
		                
					</form>
					
					<img src="/Meeting/images/임광민/꽃.png" id="fimg" />						
	                
	            </div>
	            <jsp:include page="/inc/footer.jsp"></jsp:include>
	        </main>
	        
	    </div>
	    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	</body>
</html>














