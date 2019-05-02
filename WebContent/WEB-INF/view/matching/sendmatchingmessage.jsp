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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<jsp:include page="/inc/asset.jsp"></jsp:include>

<style>
#content {
   min-height: 1000px;
}

#matchingExplain {
   padding: 30px;
   margin: 20px auto;
   /* background-color: #EF9A9A; */
   border: 1px solid #ccc;
   border-radius: 10px;
   width: 700px;
   height: 700px;
}

#h4 {
   font : #ccc;
}

#matchingExplainH1 {
   border-radius: 15px;
   background-color: #F3C8BF;
   font: white;
   width: 130px;
   margin: 16px 16px 0px 0px;
}

#match {
   float: left;
   background-color: #F3C8BF;
   border-radius: 15px;
   width: 80px;
   padding: 3px;
}

#matchImage {
   float: right;
   background-color: #F3C8BF;
   border-radius: 15px;
   width: 30px;
   padding: 3px;
}

/* #stepbystepMatch {
   font-size: 15px;
   height: 40px;
} */

a:visited {
   color: black; 
   text-decoration: none;
}

.matchInfo {
   font-size: 25px; 
   font-family:'InkLipquid';
   line-height: 1.2em;
   margin: 15px auto;
}

#loveSentense {
   <%-- background-image: url("<%= request.getContextPath()%>/images/sangmin/matching.jpg"); --%>
   background-color: #F3C8BF;
   
}

#heart{
   width: 30px;
   height: 30px;
   float: right;
}

#heart > img{
   width: 30px;
   height:30px;
   margin-bottom:0px;
}

#content {
    min-height: 300px;
}

.row .col.s12{
   height:100px;
}

.portfolio-logo-row{
   min-height: 100px;
}

.portfolio-logo{
   height: 100px;
   width: 100px;
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
         <jsp:param value="matching" name="pageName"/>
      </jsp:include>

      <main class="mdl-layout__content">

      <div id="content" class="mdl-grid portfolio-max-width">
         <div class="row">
            <div class="col s12 m6">
               <div class="card blue-grey darken-1">
                  <div class="card-content white-text" style="padding-bottom:0px;">
                     <span class="card-title">매칭 신청</span>
                     
                     <hr />
                     
                     <div class="row">
                        <div class="input-field col s12">
                        좋은 결과를 기다려요~
                        <br /> <br />
                        <div style="width: 210px; height:40px; float:center; font-weight:bold;">매칭신청이 완료 되었습니다.<img id="heart" src="../images/미령_image/KakaoTalk_20181219_180641989.png"></div>
                        </div>
                     </div>
                  </div>
                  <div class="card-action">
                     <a href="javascript:window.open('','_self').close();">닫기</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
      </main>
   </div>
   <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>

</html>