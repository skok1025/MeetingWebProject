<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="A portfolio template that uses Material Design Lite.">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<title>Template</title>
		
		<jsp:include page="/inc/asset.jsp"></jsp:include>
		
		<style>
			#content {
				min-height: 1000px;
			}

			#tbl {
				width: 700px;
				margin: 0px auto 20px auto;
			}
			
			#tbl th {
				width: 150px;
				text-align: center;
				vertical-align: middle;
				color: black;
				border: 1px solid black;
				background-color: #ff8a80;
			}
			
			#context {
				height : 400px;
			}
			
			#tbl td {
				width: 550px;
				padding: 8px 15px;
			}

			#btns {
				width: 700px;
				margin: 0px auto;
				text-align : center;
				margin-top : 20px;
				margin-bottom : 20px;
			}
			
			.btn {
				background-color: #ff8a80;
			}
			
		</style>
		
		<script>
			$(document).ready(function(){
				$("#category").formSelect();
			});
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
				<h2>관리자/회원 게시판</h2>
	
				<section>
					<form action="/Meeting/community/communityaddok.do" method="post" enctype="multipart/form-data">
	
						<table id="tbl" class="table table-bordered">
							<tr>
								<th>아이디</th>
								<td>${id}</td>
							</tr>
							<tr>
								<th>카테고리</th>
								<td>
									<select name="category" id="category">
										<option value="1">프로그램</option>
										<option value="2">데이트코스</option>
										<option value="3">일반</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>
									<input type="text" name="title" id="title" required />
								</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>
									<textarea name="context" id="context" required></textarea>
								</td>
							</tr>
							<tr>
								<th>이미지</th>
								<td>
									<input type="file" name="image" id="image" />
								</td>
							</tr>
							<tr>
								<th>파일</th>
								<td>
									<input type="file" name="attach" id="attach" />
								</td>
							</tr>
						</table>
	
						<div id="btns">
							<button class="btn btn-default waves-effect waves-light" type="submit"> 작성하기 <i class="material-icons right">send</i></button>
							<button class="btn btn-default waves-effect waves-light" type="button"> 돌아가기 </button>
						</div>
						
						<input type="hidden" name="kind" id="kind" value="${kind}" />
	
					</form>
	
				</section>
	
			</div>
			<jsp:include page="/inc/footer.jsp"></jsp:include> </main>
		</div>
		<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	</body>
</html>



