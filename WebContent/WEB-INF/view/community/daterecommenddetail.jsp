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

<jsp:include page="/inc/asset.jsp"></jsp:include>

<style>
#content {
	min-height: 1000px;
}

#explain {
	background-color: rgba(252, 209, 181);
	padding-bottom: 40px;
}

#logo {
	width: 100px;
	height: 100px;
	margin: 40px 40px;
}

#box {
	/* border: 1px solid gray; */
	margin-top: 40px;
	min-height: 1000px;
}

#tbl {
	width: 700px;
	margin: 50px auto;
	/* border: 1px solid blue; */
}

#tbl th {
	width: 150px;
	text-align: center;
	vertical-align: middle;
	/* border: 1px solid red; */
}

#tbl td {
	width: 550px;
	/* border: 1px solid green; */
}

#tbl #content {
	height: 250px;
}

#tbl #tag {
	width: 150px;
}

.btn, .btn:focus {
	background-color: #ff8a80;
}

.btn:hover {
	background-color: #ffab91;
}

#btns {
	/* border: 1px solid black; */
	margin-bottom: 30px;
	text-align: center;
	margin-left: 600px;
}

#addComment {
	/* border: 1px solid black; */
	/* text-align: center; */
	float: left;
	margin-left: 80px;
	margin-right: 20px;
}

#commentbtn {
	/* border: 1px solid red; */
	float: right;
	margin-right: 40px;
	margin-top: 13px;
	margin-left: 20px;
}

#comments {
	width: 500px;
	height: 60px;
	margin-bottom: 50px;
	margin-left: 87px;
}

#map{
	height: 300px;
	/* border: 1px solid black; */
	width: 500px;
	margin-left: 20px;
	margin-top : 30px;
	margin-bottom: 30px;
}

#listComment{
	/* border: 1px solid red; */
	width: 700px;
	margin-left: 120px;
	margin-bottom: 50px;
}

</style>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3919423ec1f03841e45a52955ec35149&libraries=services"></script>

<script>
	


	$(document).ready(function() {
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  

		// 지도를 생성합니다    
		var map = new daum.maps.Map(mapContainer, mapOption); 
	
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new daum.maps.services.Geocoder();
	
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch("${dto.location}", function(result, status) {
	
		    // 정상적으로 검색이 완료됐으면 
		     if (status === daum.maps.services.Status.OK) {
	
		        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
	
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new daum.maps.Marker({
		            map: map,
		            position: coords
		        });
	
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new daum.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${dto.title}</div>'
		        });
		        infowindow.open(map, marker);
	
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});
		
		$("#btnAdd").click(function(){
			//alert($("#cform").serialize());
			//Ajax -> 댓글 내용 -> 전송 -> 서블릿 -> insert
			$.ajax({
				type:"post",
				url: "/Meeting/community/daterecommendcommentadd.do",
				//data: "pseq=${dto.seq}&comments=" + $("#comments").val(),
				data: $("#cform").serialize(),
				dataType: "json",  //성공 실패
				success: function(result){
					console.log(result);
					if(result.state=="1"){
						//성공 -> 자바스크립트로 반환받은 dto -> 테이블에 새<tr>로 추가
						//prepend()
						
						var row = "<tr>"
							+ "<td>" 
							+ result.dto.content.replace(/\n/gi, "<br>") 
							+ "</td>"
							+ "<td>" 
							+ result.dto.name 
							/* + "(" + result.dto.id + ")<br>"  */
							+ result.dto.regdate.substring(0, result.dto.regdate.length-2) 
							+ "</td>"
							+ "<td><a href=''>[삭제]</a></td></tr>";
						
						$("#listComment tbody").prepend(row);
						
						//초기화
						$("#comments").val("");
						
					}else if(result.state=="0"||result.state=="2"){
						alert("failed");
					}
				},
				error: function(a,b,c){
					console.log(a,b,c);
				}
			});
		});
		
	});//ready
	
	
	function cdel(seq){
		
		//alert(seq);
		
		var temp = event.srcElement;
		
		$.ajax({
			type: "get",
			url: "/Meeting/community/daterecommendcommentdel.do",
			data: "seq=" + seq, //댓글번호
			dataType: "json",
			success: function(result) {
				
				console.log(result);
				
				if (result.state == "1") {
					//삭제 성공
					// -> 테이블 <tr> 삭제
					$(temp).parent().parent().remove();
					
				} else {
					alert("Failed");
				}
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
		
		event.preventDefault();
	}
	
	
	
</script>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">

		<jsp:include page="/inc/header.jsp">
				<jsp:param value="community" name="pageName" />
			</jsp:include>
		<main class="mdl-layout__content">

		<jsp:include page="/inc/sub.jsp"></jsp:include>
		<jsp:include page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">

			<h1>커뮤니티</h1>
			<h2>추천 데이트 코스</h2>


			<div id="box">

				<div id="explain">
					<img src="../images/logo.png" id="logo"> <span
						style="font-size: 2em; margin-bottom: 0px;">"광민愛듀오"가 추천하는
						데이트 코스<i class="small material-icons" style="color: #ff1744;">&nbsp;wb_sunny</i>
					</span>
					<div
						style="margin-left: 180px; font-size: 20px; margin-bottom: 10px;">"광민愛듀오"는
						여러분을 위해 여러 코스를 추천해드립니다.</div>
					<div style="margin-left: 180px; font-size: 20px;">"광민愛듀오"가
						추천하는 데이트 코스를 통해 데이트 한 후, 후기를 남겨주세요!</div>
				</div>

				<table id="tbl" class="table table-bordered">
					<tr>
						<th>번호</th>
						<td>${dto.seq }</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${dto.managername }(${dto.id })</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${dto.title }</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<div class="card-image" >
								<img src="../images/미령_image/배경.jpg" style="margin-left:40px; height:250px; width:450px;">
							</div>
							<div>${dto.content}</div>

							<div id="map"></div>
						</td>
					</tr>
					<tr>
						<th>위치</th>
						<td>
							<div id="location">${dto.location }</div>
						</td>
					</tr>
				</table>

				<div id="btns">
					<input type="button" value="수정" class="btn btn-primary"
						onclick="location.href='/Meeting/community/daterecommendedit.do?seq=${dto.seq}';" />
					<input type="button" value="삭제" class="btn btn-primary"
						onclick="location.href='/Meeting/community/daterecommenddelok.do?seq=${dto.seq}';" />
					<input type="button" value="뒤로" class="btn btn-default"
						onclick="location.href='/Meeting/community/daterecommend.do'" />
				</div>


				<!-- 댓글(전통 or Ajax(***)) : 이전 수업(7번예제) -->
				<c:if test="${iswho}">
				<div id="addComment" class="well well-sm">
					<form id="cform">
						<textarea id="comments" name="comments" class="form-control"
							style="resize: none;"></textarea>
						<div id="commentbtn">
							<input type="button" value="댓글쓰기" id="btnAdd"
								class="btn btn-default">
						</div>
						<input type="hidden" name="drseq" value="${dto.seq }">
					</form>
				</div>
				</c:if>
				<table id="listComment" class="table table-bordered highlight">
					<tbody>
						<c:forEach items="${clist }" var="cdto">
							<tr>
								<td>${cdto.content }</td>
								<td>${cdto.name }<br> ${cdto.regdate }
								</td>
								<td>
									<a href="#" onclick="cdel(${cdto.seq});" style="color:#ff8a80;">[삭제]</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>



				<div style="clear: both;"></div>



			</div>

		</div>

		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>