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
   /* background-color: #FFE8C7; */
   padding: 50px;
}

#meetingbox{
   /* background-color: #FFB2D9; */
   padding: 50px;
}

#bt {
   /* background-color: #FFB2D9; */
   margin-bottom: 20px;
}

h2 {
   margin-bottom: 20px;
}

#desc>p {
   padding-left: 60px;
   font-size: 1.8em;
   font-weight: bold;
   font-family: "InkLipquid";
}



.content{
   height:300px;
}

.person{
   float: left;
}

#descbox{
   float: right !important;
    height: 300px;
    width: 200px !important;
   margin-left: 50px;
}

table{
   width: 400px;

}

.categoryim{
   width: 200px;
   text-align: center;
   margin-bottom: 0px;
}

.personlabel{
   font-size: 1.2em;
   font-weight: bold;
}
.personname{

}

p > span{
   font-size: 1.2em;
   font-weight: bold;
}

#mybox, #pbox{
   width: 150px;
   /* border: 1px solid; */
}

.person >.personimg{
   width: 150px;
   height: 150px;
}


.z-depth-1, nav, .card-panel, .card, .toast, .btn, .btn-large, .btn-small, .btn-floating, .dropdown-content, .collapsible, .sidenav{
   webkit-box-shadow: none;
   box-shadow: none;

}





</style>

<script>
   $(document).ready(function() {

   });
</script>
</head>

<body>
   <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
      <jsp:include page="/inc/header.jsp">
         <jsp:param value="mypage" name="pageName" />
      </jsp:include>
      <!-- 페이지 이름 : introduce,matching,community,courtship,lovetest,mypage -->

      <main class="mdl-layout__content"> <jsp:include
         page="/inc/sub.jsp"></jsp:include> <jsp:include
         page="/inc/sublist.jsp"></jsp:include>
      <div id="content" class="mdl-grid portfolio-max-width">
         <h1>My Page</h1>
         <h2>미팅현황</h2>
         <div id="desc">
            <p>${name}(${id}) 의 미팅현황입니다. </p>
            
         </div>
         <div id="mainbox" class="z-depth-3">
            <div id="meetingbox" class="z-depth-1">
            <c:if test="${empty meetinglist }">
               <p style="font-weight: bold; font-size: 1.5em;">미팅현황 정보가 없습니다.</p>
            </c:if>
            <c:forEach items="${meetinglist}" var="dto">
               <div id="mybox" class="person z-depth-1">
                  <div>
                     <c:if test="${dto.myimg eq 'null'}">
                     <c:if test="${gender eq '남자'}">
                     <img src="/Meeting/profile/sam.jpg" alt=""
                                    class="circle responsive-img personimg">
                     </c:if>
                     <c:if test="${gender eq '여자'}">
                     <img src="/Meeting/profile/yuna.jpg" alt=""
                                    class="circle responsive-img personimg">
                     </c:if>
                     </c:if>
                     <c:if test="${dto.myimg != 'null'}">
                     <img src="/Meeting/profile/${dto.myimg }" alt=""
                                    class="circle responsive-img personimg">
                     </c:if>
                     <p class="personlabel">MyName: </p>
                     <p class="personname">     ${dto.myname }(${dto.myid })</p>
                  </div>
                  <div style="width: 60px; height: 60px; position: relative; top:-100px; left: 115px;">
                     <img src="../images/미령_image/marry.png">
                  </div>
               </div>
               <!-- <i class="large material-icons" style="margin-top:60px; color: #ff8a80; float: left;">favorite</i> -->
               <!-- <div><img src="../images/미령_image/marry.png" style="width: 60px; height:60px;"></div> -->
               <div id="pbox" style="margin-left : 50px;" class="pbox person z-depth-1">
                  <c:if test="${dto.pimg eq 'null'}">
                  <c:if test="${gender eq '남자'}">
                  <img src="/Meeting/profile/yuna.jpg" alt=""
                                 class="circle responsive-img personimg">
                  </c:if>
                  <c:if test="${gender eq '여자'}">
                  <img src="/Meeting/profile/sam.jpg" alt=""
                                 class="circle responsive-img personimg">
                  </c:if>
                  </c:if>
                  <c:if test="${dto.pimg !='null'}">
                  <img src="/Meeting/profile/${dto.pimg }" alt=""
                                 class="circle responsive-img personimg">
                  </c:if>
                  <p class="personlabel">PartnerName:</p>
                  <p class="personname">     ${dto.pname }(${dto.pid })</p>
               </div>
               <div id="descbox" class="z-depth-1" style="float: left;">
                  <p><span>수락여부:</span> ${dto.accept }</p>
                  <p><span>점수:</span> 나_(${dto.myscore}/10), 파트너 (${dto.pscore }/10)</p>
                  <p><span>나의 코멘트 _</span></p>
                  <p>${dto.mycontent }</p>
                  <p><span>파트너의 코멘트 _</span></p>
                  <p>${dto.pcontent }</p>
               
               </div>
               <div style="clear: both;"></div>
               <table style=" margin-top: -70px;">
                  <tr>
                     <th>데이트 카테고리<p style="text-align: center;">${dto.category }  _</p></th>
                     <td>
                     <c:if test="${dto.category eq '음식점'}">
                     <img class="categoryim" src="/Meeting/images/seokhyun/restaurant.jpg" alt="" />
                     </c:if>
                     <c:if test="${dto.category eq '카페'}">
                     <img class="categoryim" src="/Meeting/images/seokhyun/cafe.png" alt="" />
                     </c:if>
                     <c:if test="${dto.category eq '산책로'}">
                     <img class="categoryim" src="/Meeting/images/seokhyun/work.jpg" alt="" />
                     </c:if>
                     <c:if test="${dto.category eq '이색 데이트'}">
                     <img class="categoryim" src="/Meeting/images/seokhyun/def.jpg" alt="" />
                     </c:if>
                     </td>
                  </tr>
               </table>
               <hr style="border-bottom: 3px solid #ff8a80;">
            </c:forEach>
            </div>
         </div>

      </div>
      <jsp:include page="/inc/footer.jsp"></jsp:include> </main>

   </div>
   <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>