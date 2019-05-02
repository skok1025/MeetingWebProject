<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="description" content="A portfolio template that uses Material Design Lite.">
      <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
      <title>Template</title>
      
      <jsp:include page="/inc/asset.jsp"></jsp:include>
      
      <style>
      .container {
         margin: 0 auto;
         max-width: calc(100% - 50px);
         width: 1200px;
      }

      /* Wrappers */
      .wrapper {
         box-shadow: inset 0px 1px 0px 0px rgba(0, 0, 0, 0.05), inset 0px 2px 3px 0px rgba(0, 0, 0, 0.1);
         padding: 8em 0 8em 0;
         text-align: center;
      }
      
      .wrapper.style1 {
         background-image: none;
         background-color: #FAEFE7;
      }
      
      .wrapper.style2 {
         background-color: #fafafa;
         text-shadow: 1px 1px 0px #fff;
      }

      #graph, #graph1{
         width: 500px;
         height: 250px;
         margin: 30px auto;
      }
      
      .graph-title {
         font-size: 2.5em;
         font-weight: bold;
         text-align: center;
         margin: 20px 0 0;
      }
      
      </style>
      <script>
         $(document).ready(function(){
            $('.carousel').carousel();
         });
      </script>
      <script src="<%=request.getContextPath()%>/asset/js/flotr2.min.js"></script>
   </head>
   <body style="text-align: center;">

      <div class="container">
         <div class="row">
            <div class="carousel">
               <c:forEach items="${imglist}" var="dto">
                <span class="carousel-item"><img src="/Meeting/profiles/${dto.img1}"></span>
                <span class="carousel-item"><img src="/Meeting/profiles/${dto.img2}"></span>
                <span class="carousel-item"><img src="/Meeting/profiles/${dto.img3}"></span>
                <span class="carousel-item"><img src="/Meeting/profiles/${dto.img4}"></span>
                <span class="carousel-item"><img src="/Meeting/profiles/${dto.img5}"></span>
                 </c:forEach>
              </div>
            <div class="col-8 col-7-large col-12-medium">
               <header style="margin-bottom: 25px;">
                  <span style="font-size: 50px; font-weight: bold;">
                     이름 : <strong>${dto.name}</strong>
                  </span>
               </header>
               <p style="line-height: 2.5em; font-size: 25px;">
                  <b>등급 : </b>${dto.grade}<br> 
                  <b>별명 : </b>${dto.nick}<br> 
                  <b>직업 : </b>${dto.job}<br> 
                  <b>키 : </b>${dto.height}cm<br> 
                  <b>나이 : </b>${dto.age}살<br> 
                  <b>자기소개 : </b>${dto.introduce} <br>
               </p>
            </div>
         </div>
      </div>
   
      <!-- Work -->
      <article id="work" class="wrapper style2">
         <div class="container">
            <header>
               <h2>스파이더 그래프</h2>
               <div id="chartbox" class="z-depth-1">
   
                  <p class="graph-title">${dto.name }님 매력 포인트</p>
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
               
               <div id="chartbox1" class="z-depth-1">
   
                  <p class="graph-title">${dto.name }님의 이상형 매력 포인트</p>
                  <div id="graph1"></div>
                  <script>
                     (function basic_radar(container) {
                        var s1 = {
                           label : "${dto.name }",
                           data : [ 
                              [ 0, ${dto.lplan} ], 
                              [ 1, ${dto.lhumor} ], 
                              [ 2, ${dto.lalacrity} ],
                              [ 3, ${dto.lsense} ], 
                              [ 4, ${dto.lextrovert} ], 
                              [ 5, ${dto.lstyle} ]  
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
                     })(document.getElementById("graph1"));
                  </script>
   
               </div>
            </header>
         </div>
      </article>
      <jsp:include page="/inc/footer.jsp"></jsp:include>
   </body>
</html>