<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>GM♥DUO</title>
<link rel="stylesheet" href="/Meeting/asset/css/bootstrap.css">
<script src="/Meeting/asset/js/jquery-1.12.4.js"></script>

<style>

@font-face {
   font-family: 'InkLipquid';
   src:
      url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/InkLipquid.woff')
      format('woff');
   font-weight: normal;
   font-style: normal;
}

.youth * {
   font-family: 'InkLipquid', sans-serif;
}

html, body, p, div, span, table, th, td, ul, ol, dl, li, dt, dd, input,
   textarea, select, option, fieldset, legend, h1, h2, h3, h4, h5, h6, a {
   font-family: "InkLipquid";
}

body {
   background: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)),
      url("<%=request.getContextPath()%>/images/main.jpg") no-repeat center
      center fixed;
   -webkit-background-size: cover;
   -moz-background-size: cover;
   -o-background-size: cover;
   background-size: cover;
}

body:after {
   opacity: .4;
}

#ga {
   position: relative;
   color: #E0808F;
   opacity: 0;
   text-align: center;
   margin-top: 120px;
   font-size: 13em;
}

#ga2>span {
   font-variant: small-caps;
}

#btnspan {
   position: relative;
   color: #F0F8FF;
   opacity: 0; 
   text-align: center;
   font-weight: bold;
   margin-top: 100px;
   margin-bottom: 100px;
   cursor: pointer;
}

#flower > img{
   width: 300px;
   height: 200px; 
   display: block;
   padding: 0px;
   margin: 0px auto;
   margin-top: 30px;
}

#footer {
   text-align: center;
}

#btnspan > img{
   width: 300px;
   height: 180px;
}


#btnspan > span{
   display: inline-block;
   border: 0px solid white;
   position: relative;
   top: 50px;
   left: 10px;
}
</style>
<script>
   $(document).ready(function() {

      $("#ga").animate({
         opacity : 0,
      }, 500).animate({
         opacity : 1,
      }, 500);

      $("#btnspan").animate({
         opacity : 0,
      }, 500).animate({
         opacity : 0,
      }, 500).animate({
         opacity : 0,
      }, 500).animate({
         opacity : .9,
      }, 500);
   });
</script>
</head>
<body>

   <div class="container">
      <h1 id="ga">
         <span style="font-size: 1.2em; color: rgba(252,209,181,.6); ">광민</span><span style="font-family: 'SeoulNamsanM'; color: #EE3B3E;">愛</span><span style="font-size: 1.5em;">듀오</span>
      </h1>
      
      <div id="flower">
         <img src="<%= request.getContextPath() %>/images/yeji/gmduo.png">
      </div>
      

      <h3 id="btnspan" onclick="location.href='/Meeting/introduce/mainindex.do';">
         <img src="<%= request.getContextPath() %>/images/yeji/banner.png">
         <span>ENTER</span>
      </h3>

      
      <hr id="line">
      <footer id="footer"> &copy;Copyright 2018 test.com All rights
      free~ </footer>
   </div>
</body>
</html>