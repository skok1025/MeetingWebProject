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
<title>Greeting</title>

<jsp:include page="/inc/asset.jsp"></jsp:include>

<style>
	#introduce{
		border: 0px solid red;
		width: auto;
		padding-top: 0px;
		/* height: auto; */
	}
	
	#introduce > img{
		margin-left: 50px; 
		margin-top: 50px;
		width: 350px;
		height: 220px;
	}
	
	#title{
		border: 0px solid blue;
		margin-right: 45px;
		margin-top: 50px;
	}
	
	#title > h3{
		color: #E0808F;
	}
	
	#title > div{
		padding: 0px;		
		border: 0px solid green;
		text-align: right;
	}
	
	#title > div > h3{
		font-size: 2.5em;
	}
	
	#comment{
		font-style: italic; 
		margin-top: 95px;
		font-size: 1.3em;
	}
	
	#greeting{
		border: 0px solid green;
	}
	
	#greeting > div{
		padding: 15px;
		margin: 35px;
		margin-top: 20px;
		background-color: rgba(169,169,169,.5);
		border-radius: 20px;
	}
	
</style>

<script>
	   $(document).ready(function(){
	      $(".dropdown-trigger").dropdown();
	      
	      var clock;
	
	      $(document).ready(function() {
	
	         // Grab the current date
	         var currentDate = new Date();
	
	         // Set some date in the past. In this case, it's always been since Jan 1
	         var pastDate  = new Date(currentDate.getFullYear(), 0, 1);
	
	         // Calculate the difference in seconds between the future and current date
	         var diff = currentDate.getTime() / 1000 - pastDate.getTime() / 1000;
	
	         // Instantiate a coutdown FlipClock
	         clock = $('.clock').FlipClock({
	            clockFace: 'TwelveHourClock'
	         });
	      });
	   });
	   </script>
</head>

<body>
	<!-- intro.jsp -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="Introduce" name="pageName"/>
		</jsp:include>
			<!-- 페이지 이름 : introduce,matching,community,courtship,lovetest,mypage -->
		<main class="mdl-layout__content"> 
		<jsp:include page="/inc/sub.jsp"></jsp:include>
		<jsp:include page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>회사소개</h1>
			<h2>대표 인사말</h2>
			
			<div>
				<div id="introduce">
					<img src="<%=request.getContextPath() %>/images/yeji/gmimage.jpg">
					<div id="title" style="float:right;">
						<h3>광민<span style="color: #EE3B3E;">愛</span>듀오 대표이사</h3>
						<div>
							<h3>임광민</h3>
						</div>
						<div id="comment">
							<span style="font-size: 3em;">"</span><span style=" font-size: 1.7em; font-family: InkLipquid;">사랑은 먼곳에 있지 않아요, 여러분.</span><span style="font-size: 3em;">"</span>
						</div>
					</div>					
					<div style="clear:both;"></div>
				</div>
				
				<div id="greeting">
					<div>
						<div style="margin-top: 30px;">
							<span style="font-size: 3em;">"</span>
							<span style="color: #EE3B3E; font-size: 2.5em; font-family: InkLipquid; font-style: italic;">
								언제나 당신 곁에 있어요. 
							</span>
							<span style="font-size: 3em; font-family: SeoulNamsanM;">"</span><br><br>
							<p>
								&nbsp;&nbsp;안녕하세요, 광민愛듀오 대표이사 임광민입니다.<br>
								남녀가 만나 사랑을 하고 소중한 인연을 맺는 것은 인생에서 더할 나위 없이 행복하고 소중한 일입니다.
								광민愛듀오는, 아름다운 만남을 시작으로 행복한 인연이 되기까지 이끌어 드린다는 신념으로 달려왔습니다.<br><br>
								
								&nbsp;&nbsp;참으로 각박한 세상에서 나의 소중한 인연을 만나는 일은 생각보다 쉽지 않습니다.
								여러분들의 소중하고 아름다운 인연을 찾아드리기 위해 저를 비롯한 광민愛듀오 매니저들은 진심을 다해 노력하겠습니다.<br><br>
								
								&nbsp;&nbsp;고객 여러분들의 행복은 곧 우리 광민愛듀오의 행복입니다. 고객 한분 한분을 저의 소중한 가족처럼 여겨, 
								아름답고 소중한 인연을 찾는 그 날까지 노력하겠습니다. <br><br><br>
								
								<span style="font-size: 16px;">&nbsp;&nbsp;&nbsp;사랑이 가득한 광민愛듀오, 지금부터 함께해주세요.<br><br></span>
								<span style="display: block; text-align: right;font-size: 18px;">대표이사 임 광민 올림&nbsp;&nbsp;&nbsp;&nbsp;
								<br><span style="display: block; margin-top: 30px; font-family: InkLipquid; font-style:italic; font-size: 2.8em;">임광민 &nbsp;&nbsp;</span>
								</span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>

</body>

</html>