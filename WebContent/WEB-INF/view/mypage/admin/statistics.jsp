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
<script src="<%= request.getContextPath() %>/asset/js/highcharts.js"></script>
<script src="<%= request.getContextPath() %>/asset/js/sh/export-data.js"></script>
<script src="<%= request.getContextPath() %>/asset/js/sh/exporting.js"></script>
<style>
#content {
	display: block;
	min-height: 1000px;
}
#desc>p {
	padding-left: 60px;
	font-size: 1.8em;
	font-weight: bold;
	font-family: "InkLipquid";
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
			<jsp:param value="mypage" name="pageName"/>
		</jsp:include>
			<!-- 페이지 이름 : introduce,matching,community,courtship,lovetest,mypage -->

		<main class="mdl-layout__content"> 
		<jsp:include page="/inc/sub.jsp"></jsp:include>
		<jsp:include page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>MyPage</h1>
			<h2>Statistics</h2>
			<div id="desc">
				<p>관리자 전용 통계 페이지입니다. </p>
				
				<div id="container" style=" height: 400px; width: 600px; margin: 0 auto"></div>
				<script type="text/javascript">
				 
				   Highcharts.chart('container', {
					    chart: {
					        plotBackgroundColor: null,
					        plotBorderWidth: null,
					        plotShadow: false,
					        type: 'pie'
					    },
					    title: {
					        text: '광민 愛 듀오 성별 비율통계'
					    },
					    tooltip: {
					        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
					    },
					    plotOptions: {
					        pie: {
					            allowPointSelect: true,
					            cursor: 'pointer',
					            dataLabels: {
					                enabled: true,
					                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
					                style: {
					                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
					                }
					            }
					        }
					    },
					    series: [{
					        name: '성비',
					        colorByPoint: true,
					        data: [{
					            name: '남자',
					            y: ${mancnt},
					            sliced: true,
					            selected: false,
					            color:"blue"
					        }, {
					            name: '여자',
					            y: ${womancnt},
					            color:"tomato"
					        }]
					    }]
					});
				</script>
				
				
				<div id="container2" style="width: 600px;  margin: 30px auto;"></div>
				
				<script type="text/javascript">

// Create the chart
Highcharts.chart('container2', {
    chart: {
        type: 'column'
    },
    title: {
        text: '데이트 카테고리 별 비율 및 총 횟수'
    },
    subtitle: {
        text: '광민 愛 듀오 회원들의 데이트 종류에 대한 통계수치입니다.'
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        title: {
            text: '데이트 카테고리별 비율'
        }

    },
    legend: {
        enabled: false
    },
    plotOptions: {
        series: {
            borderWidth: 0,
            dataLabels: {
                enabled: true,
                format: '{point.y:.0f}회'
            }
        }
    },

    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
    },

    "series": [
        {
            "name": "데이트 코스 카테고리",
            "colorByPoint": true,
            "data": ${array}
        }
    ],
    
});
		</script>
				
				
			</div>

		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>