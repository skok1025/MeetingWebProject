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

#tbl tr:nth-child(3) {
	height: 500px;
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
}

#btnAdd {
	float: right;
}

.ui-dialog {
	width: 700px !important;
}

.map_wrap a, .map_wrap a:hover, .map_wrap a:active {
	color: #000;
	text-decoration: none;
}

.map_wrap {
	position: relative;
	width: 100%;
	height: 500px;
}

#menu_wrap {
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	width: 220px;
	margin: 10px 0 30px 10px;
	padding: 5px;
	overflow-y: auto;
	background: rgba(255, 255, 255, 0.7);
	z-index: 1;
	font-size: 12px;
	border-radius: 10px;
}

.bg_white {
	background: #fff;
}

#menu_wrap hr {
	display: block;
	height: 1px;
	border: 0;
	border-top: 2px solid #5F5F5F;
	margin: 3px 0;
}

#menu_wrap .option {
	text-align: center;
}

#menu_wrap .option p {
	margin: 10px 0;
}

#menu_wrap .option button {
	margin-left: 5px;
}

.ui-widget input, .ui-widget select, .ui-widget textarea, .ui-widget button{
	font-family: 'SeoulNamsanM' !important;
}

#placesList li {
	list-style: none;
}

#placesList .item {
	position: relative;
	border-bottom: 1px solid #888;
	overflow: hidden;
	cursor: pointer;
	min-height: 65px;
}

#placesList .item span {
	display: block;
	margin-top: 4px;
}

#placesList .item h5, #placesList .item .info {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

#placesList .item h5{
	font-size: 15px;
}

#placesList .item .info {
	padding: 10px 0 10px 55px;
}

#placesList .info .gray {
	color: #8a8a8a;
}
#placesList .info .jibun {padding-left:26px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}

#placesList .info .tel {
	color: #009900;
}

#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}

#placesList .item .marker_1 {
	background-position: 0 -10px;
}

#placesList .item .marker_2 {
	background-position: 0 -56px;
}

#placesList .item .marker_3 {
	background-position: 0 -102px
}

#placesList .item .marker_4 {
	background-position: 0 -148px;
}

#placesList .item .marker_5 {
	background-position: 0 -194px;
}

#placesList .item .marker_6 {
	background-position: 0 -240px;
}

#placesList .item .marker_7 {
	background-position: 0 -286px;
}

#placesList .item .marker_8 {
	background-position: 0 -332px;
}

#placesList .item .marker_9 {
	background-position: 0 -378px;
}

#placesList .item .marker_10 {
	background-position: 0 -423px;
}

#placesList .item .marker_11 {
	background-position: 0 -470px;
}

#placesList .item .marker_12 {
	background-position: 0 -516px;
}

#placesList .item .marker_13 {
	background-position: 0 -562px;
}

#placesList .item .marker_14 {
	background-position: 0 -608px;
}

#placesList .item .marker_15 {
	background-position: 0 -654px;
}

#pagination {
	margin: 10px auto;
	text-align: center;
}

#pagination a {
	display: inline-block;
	margin-right: 10px;
}

#pagination .on {
	font-weight: bold;
	cursor: default;
	color: #777;
}

#searchbtn{
	border: none;
	background-color:#ff8a80;
	color: white;
	width: 70px;
	height: 20px;
	border-radius: 2px;
}

.ui-widget-header{
	border: 1px solid #ffcdd2 !important;
    background: #ffcdd2 !important;
    color: #757575 !important;
    font-weight: bold;
}

.tel{
	color: #f06292  !important;
}

/* input[type=text]:not(.browser-default){
	border-bottom: 1px solid #E0808F;
}

#menu_wrap hr{
	border-top: 2px solid #E0808F;
} */
</style>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3919423ec1f03841e45a52955ec35149&libraries=services"></script>

<script>
	var flag = false;//true(마커 존재O), false(마커 존재X)
	var tempMarker = null; //마커 임시 변수

	var map = "";
	var ps = "";
	var infowindow = "";
	var mapContainer = "";
	var markers = [];
	var placePosition = "";
	var content = "";

	$(document).ready(function() {
  		$("#category").formSelect();
  		
		$("#dialog").dialog({
			autoOpen : false,
			show : {
			/* effect: "blind",
			duration: 1000 */
			},
			hide : {
			/* effect: "explode",
			duration: 1000 */
			}
		});

		$("#opener").on("click", function() {
			$("#dialog").dialog("open");

			mapContainer = document.getElementById('map'), // 지도를 표시할 div 

			mapOption = {
				center : new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
				level : 3
			// 지도의 확대 레벨
			};

			// 지도를 생성합니다    
			map = new daum.maps.Map(mapContainer, mapOption);

			// 장소 검색 객체를 생성합니다
			ps = new daum.maps.services.Places();

			// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
			infowindow = new daum.maps.InfoWindow({
				zIndex : 1
			});

			// 키워드로 장소를 검색합니다
			searchPlaces();

		});

		//버튼 클릭
		$("#btnAdd").click(function() {

			$("#dialog").dialog("close");

		});


	});//ready

	// 키워드 검색을 요청하는 함수입니다
	function searchPlaces() {

		var keyword = document.getElementById('keyword').value;

		if (!keyword.replace(/^\s+|\s+$/g, '')) {
			alert('키워드를 입력해주세요!');
			return false;
		}

		// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
		ps.keywordSearch(keyword, placesSearchCB);
	}

	// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
	function placesSearchCB(data, status, pagination) {
		if (status === daum.maps.services.Status.OK) {

			// 정상적으로 검색이 완료됐으면
			// 검색 목록과 마커를 표출합니다
			displayPlaces(data);

			// 페이지 번호를 표출합니다
			displayPagination(pagination);

		} /* else if (status === daum.maps.services.Status.ZERO_RESULT) {

			alert('검색 결과가 존재하지 않습니다.');
			return;

		}  */else if (status === daum.maps.services.Status.ERROR) {

			alert('검색 결과 중 오류가 발생했습니다.');
			return;

		}
	}

	// 검색 결과 목록과 마커를 표출하는 함수입니다
	function displayPlaces(places) {

		var listEl = document.getElementById('placesList'), menuEl = document
				.getElementById('menu_wrap'), fragment = document
				.createDocumentFragment(), bounds = new daum.maps.LatLngBounds(), listStr = '';

		// 검색 결과 목록에 추가된 항목들을 제거합니다
		removeAllChildNods(listEl);

		// 지도에 표시되고 있는 마커를 제거합니다
		removeMarker();

		for (var i = 0; i < places.length; i++) {

			// 마커를 생성하고 지도에 표시합니다
			placePosition = new daum.maps.LatLng(places[i].y, places[i].x),
					marker = addMarker(placePosition, i), itemEl = getListItem(
							i, places[i]); // 검색 결과 항목 Element를 생성합니다

			// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
			// LatLngBounds 객체에 좌표를 추가합니다
			bounds.extend(placePosition);

			// 마커와 검색결과 항목에 mouseover 했을때
			// 해당 장소에 인포윈도우에 장소명을 표시합니다
			// mouseout 했을 때는 인포윈도우를 닫습니다
			(function(marker, title) {
				daum.maps.event.addListener(marker, 'click', function() {
					displayInfowindow(marker, title);
					coordinate(marker, title);
				});

				/* daum.maps.event.addListener(marker, 'mouseout', function() {
					infowindow.close();
				}); */

				itemEl.onmouseover = function() {
					displayInfowindow(marker, title);
				};

				itemEl.onmouseout = function() {
					infowindow.close();
				};
			})(marker, places[i].place_name);

			fragment.appendChild(itemEl);
		}

		// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
		listEl.appendChild(fragment);
		menuEl.scrollTop = 0;

		// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
		map.setBounds(bounds);
	}

	// 검색결과 항목을 Element로 반환하는 함수입니다
	function getListItem(index, places) {

		var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
				+ (index + 1)
				+ '"></span>'
				+ '<div class="info">'
				+ '   <h5>'
				+ places.place_name + '</h5>';

		if (places.road_address_name) {
			itemStr += '    <span>' + places.road_address_name + '</span>'
					+ '   <span class="jibun gray">' + places.address_name
					+ '</span>';
		} else {
			itemStr += '    <span>' + places.address_name + '</span>';
		}

		itemStr += '  <span class="tel">' + places.phone + '</span>' + '</div>';

		el.innerHTML = itemStr;
		el.className = 'item';

		return el;
	}

	// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
	function addMarker(position, idx, title) {
		var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
		imageSize = new daum.maps.Size(36, 37), // 마커 이미지의 크기
		imgOptions = {
			spriteSize : new daum.maps.Size(36, 691), // 스프라이트 이미지의 크기
			spriteOrigin : new daum.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
			offset : new daum.maps.Point(13, 37)
		// 마커 좌표에 일치시킬 이미지 내에서의 좌표
		}, markerImage = new daum.maps.MarkerImage(imageSrc, imageSize,
				imgOptions), marker = new daum.maps.Marker({
			position : position, // 마커의 위치
			image : markerImage

		});

		marker.setMap(map); // 지도 위에 마커를 표출합니다
		markers.push(marker); // 배열에 생성된 마커를 추가합니다

		return marker;
	}

	// 지도 위에 표시되고 있는 마커를 모두 제거합니다
	function removeMarker() {
		for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(null);
		}
		markers = [];
	}

	// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
	function displayPagination(pagination) {
		var paginationEl = document.getElementById('pagination'), fragment = document
				.createDocumentFragment(), i;

		// 기존에 추가된 페이지번호를 삭제합니다
		while (paginationEl.hasChildNodes()) {
			paginationEl.removeChild(paginationEl.lastChild);
		}

		for (i = 1; i <= pagination.last; i++) {
			var el = document.createElement('a');
			el.href = "#";
			el.innerHTML = i;

			if (i === pagination.current) {
				el.className = 'on';
			} else {
				el.onclick = (function(i) {
					return function() {
						pagination.gotoPage(i);
					}
				})(i);
			}

			fragment.appendChild(el);
		}
		paginationEl.appendChild(fragment);
	}

	// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
	// 인포윈도우에 장소명을 표시합니다
	function displayInfowindow(marker, title) {
		content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

		infowindow.setContent(content);
		infowindow.open(map, marker);
	}

	function coordinate(marker, title) {

		//클릭한 좌표 객체
		//alert(placePosition.getLat().toFixed(6));
		//alert(placePosition.getLng().toFixed(6));
		var lat = placePosition.getLat().toFixed(6);
		var lng = placePosition.getLng().toFixed(6);
		//alert(title);

		//전송용(ajax)
		$("#lat").val(placePosition.getLat().toFixed(6));
		$("#lng").val(placePosition.getLng().toFixed(6));

	}

	// 검색결과 목록의 자식 Element를 제거하는 함수입니다
	function removeAllChildNods(el) {
		while (el.hasChildNodes()) {
			el.removeChild(el.lastChild);
		}
	}
</script>
</head>

<body>

	<!-- daterecommendadd.do -->

	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">

		<jsp:include page="/inc/header.jsp">
				<jsp:param value="community" name="pageName" />
			</jsp:include>

		<main class="mdl-layout__content"> <jsp:include
			page="/inc/sub.jsp"></jsp:include>
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

				<form method="post"
					action="/Meeting/community/daterecommendaddok.do">

					<!-- 입력폼 -->
					<table id="tbl" class="table table-bordered">
						<tr>
							<th>이름</th>
							<td>${name}(${id})</td>
						</tr>
						<tr>
							<th>가게명</th>
							<td><input type="text" name="title" id="title"
								class="form-control" required /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content" id="content"
									class="form-control" required
									placeholder="글 마지막에 '위치 - '로 동과 번지수를 입력해주세요"></textarea></td>
						</tr>
						<tr>
							<th>지역</th>
							<td><input type="text" name="area" id="area"
								class="form-control" required placeholder="oo시oo구oo동" /></td>
						</tr>

						<tr>
							<th>카테고리</th>
							<td><select name="category" id="category"
								class="form-control">
									<option value="1">음식점</option>
									<option value="2">카페</option>
									<option value="3">산책로</option>
									<option value="4">이색데이트</option>
							</select></td>
						</tr>

						<tr>
							<th></th>
							<td>
								<!-- <a class="waves-effect waves-light btn modal-trigger" data-toggle="modal" data-target="#modal1">장소추가하기</a> -->
								<!-- <button id="opener" class="waves-effect waves-red btn">장소
									추가하기</button> --> <input type="button" id="opener"
								class="waves-effect waves-red btn" value="장소추가하기" style="color: white !important;" />
							</td>
						</tr>
					</table>

					<div id="btns">
						<input type="submit" value="쓰기" class="btn btn-primary" /> <input
							type="button" value="뒤로" class="btn btn-default"
							onclick="location.href='/Meeting/community/daterecommend.do'" />
					</div>

					<input type="hidden" name="mode" value="${mode}"> <input
						type="hidden" name="lat" id="lat"> <input type="hidden"
						name="lng" id="lng">


				</form>

				<div id="addressbox">
					<div id="dialog" title="Basic dialog">


						<table class="table table-bordered">
							<tr>
								<td colspan="2">
									<div class="map_wrap">
										<div id="map"
											style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

										<div id="menu_wrap" class="bg_white">
											<div class="option">
												<div>
													<form onsubmit="searchPlaces(); return false;">
														키워드 : <input type="text" value="keyword" id="keyword"
															size="10">
														<button  id="searchbtn" type="submit">검색하기</button>
													</form>
												</div>
											</div>
											<hr>
											<ul id="placesList"></ul>
											<div id="pagination"></div>
										</div>
									</div>
								</td>
							</tr>

							<tr>
								<td colspan="2"><a id="btnAdd"
									class="modal-close waves-effect waves-orange btn-flat">장소
										추가</a></td>
							</tr>
						</table>





					</div>
				</div>


				<div style="clear: both;"></div>



			</div>

		</div>

		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>