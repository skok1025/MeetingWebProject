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


<style>
#chartbox {
	text-align: center;
	width : 900px;
}

#chartbox > div {
	float : left;
}

#graph {
	
	width: 430px;
	height: 250px;
}

#graph2 {
	width: 430px;
	height: 250px;
	float : right;
}

p {
	font-size: 20px;
	text-align: center;
}

#content {
	min-height: 600px;
}

#content>img {
	width: 180px;
	margin-bottom: 0px;
}

#fimg {
	width: 300px;
	margin: 0px;
}

#buttonMatch {
	
	background-color: #FF8A80;
}
</style>

<script>
$(document).ready(function(){
		$("#buttonMatch").click(function(){
		child = window.open("/Meeting/matching/sendmatchingmessage.do?pseq=${seconddto.seq}&seq=${dto.seq}","child", "width=500, height=500");
	});
}); 
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
			<h2>단계별 매칭</h2>

			<div id="matchingExplain" class="#ef9a9a red lighten-3">

				<br>
				<!-- 스파이더차트(육각형 비교) -->
				<div class="screen" id="third">
					<h4 style="text-align : left;">스파이더 웹</h4>
					<div id="chartbox" style="margin-top : 50px;">
						<div id="graph"></div>
						<div id="graph2"></div>
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

						
					<script>
	                        (function basic_radar(container) {
	                           var s1 = {
	                              label : "${seconddto.name }",
	                              data : [ 
	                                 [ 0, ${seconddto.cplan} ], 
	                                 [ 1, ${seconddto.chumor} ],  
	                                 [ 2, ${seconddto.calacrity} ],
	                                 [ 3, ${seconddto.csense} ],  
	                                 [ 4, ${seconddto.cextrovert} ],  
	                                 [ 5, ${seconddto.cstyle} ] 
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
	                        })(document.getElementById("graph2"));
	                	</script>
	                </div>
	                <div style="clear:both;"></div>

							<div style="margin-top : 50px;" id="content" class="mdl-grid portfolio-max-width">
							<h4>${seconddto.name} Love Test</h4>
							
								<p id="question" style="line-height: 2.5em; font-size: 15px; margin-top:30px;">${seconddto.content}</p>

									<div style="text-align :center;margin-top:50px;">
										<button class="btn btn-default waves-effect waves-light" type="submit" id="buttonMatch" name="buttonMatch""> 매칭신청 <i class="material-icons right">send</i></button>
									</div>

							</div>
					</div>

				</div>
				</div>
				<jsp:include page="/inc/footer.jsp"></jsp:include>
		</main>
	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>

</html>
