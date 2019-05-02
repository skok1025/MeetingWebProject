<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="description" content="A portfolio template that uses Material Design Lite.">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
	    <title></title>
	   
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
		  		width : 180px;
		  		margin-bottom: 0px;
		  	}
		  	
		 	#fimg {
		 		width : 300px;
		 		margin: 0px;
		 	}
		 	
		 	#question {
		 		line-height: 2em;
		 		font-size : 15px;
		 	}
		 	
		 	#question > b {
		 		font-size : 20px;
		 	}
		 	
	    </style>
	    
	    <script>
	       
		   $(document).ready(function(){
		   		
		   });
		   
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
	                
	                <p id="question" >
	        			${dto.content}
            		</p>
		               			
		            
					<img src="/Meeting/images/임광민/꽃.png" id="fimg" />						
	                
	            </div>
	            <jsp:include page="/inc/footer.jsp"></jsp:include>
	        </main>
	        
	    </div>
	    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	</body>
</html>














