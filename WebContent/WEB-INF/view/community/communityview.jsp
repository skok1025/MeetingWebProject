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
				color: black; border: 1px solid black; background-color : #F1DBC4;
			}
			
			#tbl td { width: 550px; padding: 8px 15px;  }
			
			#tbl tr:nth-child(3) td textarea {}
			#tbl #content {
				height: 250px;
			}
			
			#tbl #tag {
				width: 150px;
			}
			
			#btns {
				width: 700px;
				margin: 0px auto;
			}
			
			#tbl tr:nth-child(4) td {
				height: 250px;
			}
			
			
			#addComment, #listComment {
				width: 700px;
				margin: 20px auto;
			}
			
			#addComment {
				margin-top : 50px;
				text-align: right;
			}
			
			#comments {
				height: 50px;
				width : 500px;
			}
			
			#tcomments {
				display: inline-block;
			}
			
			#btnAdd {
				margin-bottom: 35px;
				background-color : #FF8A80;
			}
			
			#listComment td {
				text-align: center;
				vertical-align: middle;
			}
			
			#listComment td:nth-child(1) { width: 490x; }
			#listComment td:nth-child(2) { width: 150px; }
			#listComment td:nth-child(3) { width: 60px; }
			
		</style>
		
		<script>
			$(document).ready(function(){
				$("#btnAdd").click(function() {
					
					$.ajax({
						type: "get",
						url: "/Meeting/community/communityaddcomment.do",
						data: $("#cform").serialize(),
						dataType: "json", 
						success: function(result) {
							console.log(result);
							if (result.state == "1") {
								
								var row = "<tr>"
									+ "<td>" 
									+ result.dto.comments
									+ "</td>"
									+ "<td>"+result.dto.id + "<br>" 
									+ result.dto.regdate.substring(0, result.dto.regdate.length-2)+"</td>"
									/* + "<td><a href='#' onclick='cdel(" + result.dto.seq + ");'>[삭제]</a></td> */+"</tr>";
								$("#listComment tbody").prepend(row);
								
								$("#comments").val("");
								
							} else if (result.state == "0" || result.state == "2") {
								alert("Failed");
							}   
							
						},
						error: function(a,b,c) {
							console.log(a,b,c);
						}
					});
					
				});
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
						<table id="tbl" class="table table-bordered">
							<tr>
								<th>번호</th>
								<td>${dto.seq}</td>
							</tr>
							<tr>
								<th>아이디</th>
								<td>${dto.id}</td>
							</tr>
							<tr>
								<th>제목</th>
								<td>${dto.title}</td>
							</tr>
							<tr>
								<th>내용</th>
								<td>
									<div>${dto.content}</div>
								</td>
							</tr>
							<tr>
								<th>날짜</th>
								<td>${dto.regdate}</td>
							</tr>
							<tr>
								<th>파일</th>
								<td>
									<c:if test="${empty dto.attach}">
										첨부 파일 없음.
									</c:if>
									<c:if test="${not empty dto.attach}">
										<a href="/Meeting/community/communitydownload.do?filename=${dto.attach}&orgfilename=${dto.orgfilename}&seq=${dto.seq}">${dto.orgfilename} 파일 다운로드 하기</a>
									</c:if>
								</td>
							</tr>
						</table>
						
						<div id="addComment" class="well well-sm">
							<form action="" id="cform">
								<div id="tcomments"><textarea id="comments" name="comments" class="form-control"></textarea></div>
								<button id="btnAdd" class="btn btn-default waves-effect waves-light" type="button"> 댓글 추가 <i class="material-icons right">send</i></button>
								<input type="hidden" name="pseq" value="${dto.seq}" />
							</form>
						</div>
						
						<table id="listComment" class="table">
							
							<tbody>
							
								<c:forEach items="${clist}" var="cdto">
								
								<tr>
									<td>${cdto.content}</td>
									<td>
										${cdto.name}<br>
										${cdto.regdate}
									</td>
								</tr>
								</c:forEach>					
								
							</tbody>
							
						</table>
						
					</section>
		
				</div>
				<jsp:include page="/inc/footer.jsp"></jsp:include> 
			</main>
		</div>
		<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	
	</body>

</html>



