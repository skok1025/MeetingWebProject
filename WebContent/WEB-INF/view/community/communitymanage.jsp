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
			
			
		</style>
		
		<script>
			$(document).ready(function(){

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
				<table id="tbl1" class="centered">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<c:if test="${id == 'admin1' }">
							<th>경고 해제</th>
							</c:if>
							<th>
								<c:if test="${id == 'admin1' }">
									경고 주기
								</c:if>
								<c:if test="${id != 'admin1' }">
									수정
								</c:if>
							</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${list.size() == 0 }">
							<tr>
								<td colspan="5">현재 작성한 게시물이 없습니다</td>
							</tr>
						</c:if>
						<c:forEach items="${list}" var="dto">
							<tr>
								<td>${dto.seq}</td>
								<td>
									<a style="text-decoration: none; color:black;" href="/Meeting/community/communityview.do?seq=${dto.seq}">${dto.title}</a>
								</td>
								<c:if test="${id == 'admin1'}">
								<td>
									<c:if test="${dto.warning == '1' }">
										<a href="/Meeting/community/communitywarning.do?warning=0&seq=${dto.seq}"><i style="color:red;" class="material-icons">error</i></a>
									</c:if>
								</td>
								</c:if>
								<td>
									<c:if test="${id == 'admin1' }">
										<c:if test="${dto.warning != '1' }">
										<a href="/Meeting/community/communitywarning.do?warning=1&seq=${dto.seq}"><i style="color:black;" class="material-icons">announcement</i></a>
										</c:if>
									</c:if>
									<c:if test="${id != 'admin1' }">
										<a href="/Meeting/community/communityedit.do?seq=${dto.seq}"><i style="color:black;" class="material-icons">create</i></a>
									</c:if>
									
								</td>
								<td>							
									<a href="/Meeting/community/communitydel.do?seq=${dto.seq}"><i style="color:black;"  class="material-icons">cancel</i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<jsp:include page="/inc/footer.jsp"></jsp:include> </main>
	
		</div>
		<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	
	</body>

</html>