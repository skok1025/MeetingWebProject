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
<link rel="stylesheet"
   href="<%=request.getContextPath()%>/asset/css/nouislider.css" />
<link rel="stylesheet"
   href="<%=request.getContextPath()%>/asset/css/nouislider.min.css" />

<script src="<%=request.getContextPath()%>/asset/js/nouislider.js"></script>

<script src="<%=request.getContextPath()%>/asset/js/nouislider.min.js"></script>



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
   width: 800px;
   min-height: 500px;
}

#h4 {
   font: #ccc;
}

#age {
   /* border: 1px solid black; */
   height: 400px;
   margin: 10px auto;
}

#ageButton    {
   font-family:'SeoulNamsanM';
}

#ageButton>a {
   /* border: 1px solid #eee; */
   /* padding: 0px; */
   width: 100px;
   height: 30px;
   border-radius: 20px;
   margin: 50px;
}

#slider {
   /* border: 1px solid red; */
   width: 500px;
   height: 200px;
   /* float: right; */
   margin: 0px auto;
   padding: 40px;
}

#selectMinAge, #selectMaxAge {
   padding: 7px;
   margin: 15px 5px 5px;
   width: 70px;
}

.area {
   position: absolute;
   background: #fff;
   border: 1px solid #888;
   border-radius: 3px;
   font-size: 12px;
   top: -5px;
   left: 15px;
   padding: 2px;
}

.info {
   font-size: 12px;
   padding: 5px;
}

.info .title {
   font-weight: bold;
}

/* 지역 셀렉트 */
#areaSelect {
   
}

/* 스파이더 그래프 스타일 */
#graph{
   width: 440px;
   height: 250px;
   margin: 0px auto;
}

.screen {
   /* display: none; */
   /* transition:all 2s; */
}

#first{
   display: block;
}

.loading {
   text-align: center;
}

.btn, .btn:focus {
   background-color: #ff8a80;
}

.btn:hover {
   background-color: #ffab91;
}


element.style{
   stroke: #ff8a80;
   color: #ff8a80;
}

.noUi-connect {
    background: #ff8a80;
}


.dropdown-content li > span{
   color: #ff8a80;
}


.select-wrapper input.select-dropdown:focus {
       border-bottom: 1px solid #ff8a80;
}

</style>

<script>
var minAge;
var maxAge;
   $(document).ready(function(){
      
     // $(".screen").fadeIn(2000);
     
     $("#second").hide();
     $("#third").hide();
     $("#loading1").hide();
     $("#loading2").hide();
     $("#loading3").hide();
     $("#fail").hide();
     
      
     $('select').formSelect();
      $(".dropdown-trigger").dropdown();
      
      /* 시간 뛰우기 */
      var clock;
      
        //Grab the current date
        var currentDate = new Date();

        // Set some date in the past. In this case, it's always been since Jan 1
        var pastDate  = new Date(currentDate.getFullYear(), 0, 1);

        // Calculate the difference in seconds between the future and current date
        var diff = currentDate.getTime() / 1000 - pastDate.getTime() / 1000;

        // Instantiate a coutdown FlipClock
        clock = $('.clock').FlipClock({
           clockFace: 'TwelveHourClock'
        });
      
        
     /* 나이 */
     /* 두번째 슬라이더(텍스트 이용) */
      var nonLinearSlider = document.getElementById('test-slider');

      noUiSlider.create(nonLinearSlider, {
          connect: true,
          behaviour: 'tap',
          start: [20, 30],
          range: {
              'min': 20,
              '10%': 21,
              '20%': 22,
              '30%': 23,
              '40%': 24,
              '50%': 25,
              '60%': 26,
              '70%': 27,
              '80%': 28,
              '90%': 29,
              'max': 30
          },
          snap: true,
          start: [20, 30]
      });
      
      var nodes = [
           document.getElementById('minAge'), // 0
           document.getElementById('maxAge')  // 1
       ];
      var node = [
          document.getElementById('min'), // 0
             document.getElementById('max')  // 1 
      ];
      var min;
      var max;
      var age ="";

       // Display the slider value and how far the handle moved
       // from the left edge of the slider.
       nonLinearSlider.noUiSlider.on('update', function (values, handle, unencoded, isTap, positions) {
           nodes[handle].innerHTML = '나이 : ' + parseInt(values[handle]) + '살';
         if(handle ==0){
            min = parseInt(values[handle]);
            $("#min").val(min);
         } else if(handle ==1) {
            max = parseInt(values[handle]);
            $("#max").val(max);
         }
       });
       
       
       
       
       /* 다음맵 */
       
       var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
       mapOption = { 
           center: new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
           level: 10 // 지도의 확대 레벨
       };

      var map = new daum.maps.Map(mapContainer, mapOption),
       customOverlay = new daum.maps.CustomOverlay({}),
       infowindow = new daum.maps.InfoWindow({removable: true});
      
      map.setZoomable(false);
      map.setDraggable(false);
      

      // 지도에 영역데이터를 폴리곤으로 표시합니다 
      for (var i = 0, len = areas.length; i < len; i++) {
          displayArea(areas[i]);
      }

      // 다각형을 생상하고 이벤트를 등록하는 함수입니다
      function displayArea(area) {
   
          // 다각형을 생성합니다 
          var polygon = new daum.maps.Polygon({
              map: map, // 다각형을 표시할 지도 객체
              path: area.path,
              strokeWeight: 2,
              strokeColor: '#ff8a80',
              strokeOpacity: 0.8,
              fillColor: '#fff',
              fillOpacity: 0.7 
          });
   
          // 다각형에 mouseover 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 변경합니다 
          // 지역명을 표시하는 커스텀오버레이를 지도위에 표시합니다
          daum.maps.event.addListener(polygon, 'mouseover', function(mouseEvent) {
              polygon.setOptions({fillColor: '#ffab91'});
            
              var content = '<div class="info">' + 
               '   <div class="title">' + area.name + '</div>' +
               '</div>';
              
              infowindow.setContent(content); 
              infowindow.setPosition(mouseEvent.latLng); 
              infowindow.setMap(map);
              /* customOverlay.setContent('<div class="area">' + area.name + '</div>'); 
              customOverlay.setPosition(mouseEvent.latLng); 
              customOverlay.setMap(map); */
          });
   
          // 다각형에 mousemove 이벤트를 등록하고 이벤트가 발생하면 커스텀 오버레이의 위치를 변경합니다 
          daum.maps.event.addListener(polygon, 'mousemove', function(mouseEvent) {
              
              customOverlay.setPosition(mouseEvent.latLng); 
          });
   
          // 다각형에 mouseout 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 원래색으로 변경합니다
          // 커스텀 오버레이를 지도에서 제거합니다 
          daum.maps.event.addListener(polygon, 'mouseout', function() {
              polygon.setOptions({fillColor: '#fff'});
              customOverlay.setMap(null);
          }); 
         
          var target = document.getElementById('target');
   
          // 다각형에 click 이벤트를 등록하고 이벤트가 발생하면 다각형의 이름과 면적을 인포윈도우에 표시합니다 
          daum.maps.event.addListener(polygon, 'click', function(mouseEvent) {
              /* var content = '<div class="info">' + 
                          '   <div class="title">' + area.name + '</div>' +
              
                          '</div>'; */
              
                          
              /* var data = "data=" + area.name;   */       
              
              $("#bigarea").val(area.name);
                          
            $.ajax({
               type: "get",
               url: "/Meeting/matching/areabig.do",
               data: $("#submit").serialize(),
               dataType: "json",
               success: function(result) {
                  $("#text").val(area.name);
                  $("#areaSelect").html("");
                  
                  $(result).each(function(index, area){
                            // item == {} JSON 객체 1개(1사람 분량의 DTO)
                            $("#areaSelect").append(
                                  "<option value='"+area.smallarea +"'>" +area.smallarea+ "</option>"
                            ); 
                            
                            $("#areaSelect").formSelect();
                            
                     }); 
                  
               },
               error : function(a, b, c) {
                  console.log(a, b, c);
               }
               
               
            });
            
              
            
          });
      }
      
      
        //$(".screen").fadeIn(2000);
      
   
   
       
        
      
   });//ready
   
      //페이지 이동
    function setChildValue(chartList) {
       window.location.href = "chartresult.do?pseq=" + chartList.seq ;
   }


   
   
   function areaClick() {
      
      $("#choiceBigArea").val($("#bigarea").val());
      $("#choiceSmallArea").val($("#areaSelect option:selected").val());
      
      console.log("구:"+$("#choiceBigArea").val());
      console.log("동:"+$("#choiceSmallArea").val());


      
       //$("#first").hide(); 
       $("#first").fadeOut(1000);
       $("#second").fadeIn(4000);
       $("#third").hide();
       
       
       
   };
   
   
   function ageClick() {
      
      //$("#min").val($("#bigarea").val());
      //$("#choiceSmallArea").val($("#areaSelect option:selected").val());
      
      //alert("최소나이 : " +$("#min").val());
      //alert("최대나이 : " +$("#max").val());
      
      $("#second").hide();
      //$("#second").hide();
      //$("#third").fadeIn(2000, redirectPage);
      
      setTimeout(function() { 
         $("#loading1").show();
      }, 1000);
      
      setTimeout(function() {
         $("#loading1").hide();
         $("#loading2").show();
      }, 2000);
      
      setTimeout(function() {
         $("#loading2").hide();
         $("#loading3").show();
         $("#last").hide();
      }, 3000);
      
      
      
      goChart();
      
      setTimeout(function() {
         $("#loading3").hide();
         $("#fail").show();
      }, 3000);
      
   };
   
   function goChart() {
      
      $.ajax({
         type: "get",
         url: "/Meeting/matching/getchart.do",
         data: $("#submitAll").serialize(),
         dataType: "json",
         success: function(result) {
            
            $(result).each(function(index, chartList){
                      // item == {} JSON 객체 1개(1사람 분량의 DTO)
                      
                      //console.log(chartList.seq);
                      //console.log(chartList.id);
                      //console.log(chartList.name);
                     setChildValue(chartList);
                      
               }); 
            
         },
         error : function(a, b, c) {
            console.log(a, b, c);
         }
         
         //차트를 비교
      }); 
   };
   
   
      
      
      
      
      
      
      
      
   
   
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

         <h2 style="margin: 50px;">단계별 매칭</h2>
         
         <div id="matchingExplain" class="#ef9a9a red lighten-3">
            <div style="text-align: center;">
                  <h4 id="last">원하는 이성의 정보를 입력해주세요.</h4>
            </div>
            <br>
            
            <!-- 지역 선택 (다음맵) -->
            <div class= "screen" id="fail">
               <h3>선택한 조건에 만족하는 이성이 없습니다.</h3>
            </div>
            
            
            <div class= "screen" id="first">
               
               <form  method="post" id="submit">
                  <div style="margin-left: 180px;">
                     <div id="map" style="width: 400px; height: 300px;"></div>
                     <input type="hidden" id="bigarea" name="bigarea" />
                  </div>
               </form> 
               
               <!-- <form method="get" id ="submitArea">  -->
                  <div>
                     <input type="text" id="text" disabled/>            
                     <select name="areaSelect" id="areaSelect">
                        
                     </select>
                     <div class="areaButtonBox" style="margin-left: 630px;">
                        <input id ="areaButton" type="button" class="waves-effect waves-red btn"
                              value="지역선택" onclick="areaClick();" />
                     </div>
                  </div>
               <!-- </form> --> 
            </div>

            
            
            <!-- 나이 선택 (최소,최대) -->
            <div class="screen" id="second">
               
               <!-- action="/Meeting/matching/getage.do"  -->
               
               <!-- <form method="get"> -->
                  <div id="age">
                        <div id="slider">
                           <div style="padding: 0px;">
                              <span>원하는 이성의 나이 범위를 지정해주세요.(20세 ~ 30세) </span>
                           </div>
                           <div id="test-slider"></div>
                           <br>
                           <div id="minAge" name="minAge"></div>
                           <div id="maxAge" name="maxAge"></div>
                           <div
                              class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                           </div>
                        </div>
                     
                     <div id="ageselect">
                        <!-- <a class="waves-effect waves-light btn" href>나이</a> -->
                        <input id ="ageButton" type="button" class="waves-effect waves-light btn"
                           value="나이선택" onclick="ageClick();"     style="margin: 10px 320px;"/>
                     </div>
                  </div>
                     <!-- <form method="get" id="submitAge"> -->
                        <!-- <input type="hidden" id="min" name="min" /> 
                        <input type="hidden" id="max" name="max" /> -->
                     <!-- </form> -->
   
               <!-- </form> -->
            </div>
            
            <div id="loading1" class="loading">
               <h3>로딩중.</h3>
            </div>
            <div id="loading2" class="loading">
               <h3>로딩중..</h3>
            </div>
            <div id="loading3" class="loading">
               <h3>로딩중...</h3>
            </div>
            
            
            
         <!-- 구 , 동, 최대 나이, 최소 나이 -->
         <form method="get" id="submitAll">
            <input type="hidden" name="choiceSmallArea" id="choiceSmallArea"/>
            <input type="hidden" name="choiceBigArea" id="choiceBigArea"/>
            <input type="hidden" id="min" name="min" /> 
            <input type="hidden" id="max" name="max" />
         </form>         

         </div>
      </div>
      <jsp:include page="/inc/footer.jsp"></jsp:include> </main>

   </div>
   <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>

</html>