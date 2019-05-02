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

.parallax-window {
    min-height: 400px;
    background: transparent;
}

</style>

<script>
    $(document).ready(function(){
       $('.parallax-window').parallax({imageSrc: '/Meeting/images/example-blog04.jpg'});
   }); 
 
   </script>
</head>

<body>
   <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
      <jsp:include page="/inc/header.jsp">
         <jsp:param value="mypage" name="pageName"/>
      </jsp:include>
         <!-- 페이지 이름 : introduce,matching,community,courtship,lovetest,mypage -->

      <main class="mdl-layout__content"> 
      <jsp:include page="/inc/sub.jsp"></jsp:include>
      <jsp:include page="/inc/sublist.jsp"></jsp:include> 
      <div id="content" class="mdl-grid portfolio-max-width">
         <h1>Main Title</h1>
         <h2>Sub Title</h2>
         
         <div class="parallax-window" data-parallax="scroll" data-image-src="/Meeting/images/example-blog04.jpg"></div>
         <div style="clear: both;"></div>
      </div>
      <jsp:include page="/inc/footer.jsp"></jsp:include> </main>

   </div>
   <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
   <script src="/Meeting/asset/js/parallax.js"></script>
</body>

</html>]