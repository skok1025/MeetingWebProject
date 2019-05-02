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
<script src="/Meeting/asset/js/flotr2.min.js"></script>
<style>
#content {
   display: block;
   min-height: 1000px;
}

#mainbox {
   background-color: #FFE8C7;
   padding: 50px;
}

#bt {
   background-color: #ff8a80 !important;
   margin-bottom: 20px;
}

h2 {
   margin-bottom: 20px;
}

#desc>p {
   padding-left: 60px;
   font-size: 1.8em;
   font-weight: bold;
   font-family: "InkLipquid";
}

#tbl td {
   text-align: center;
   padding-left: 50px;
}

#tbl th {
   font-size: 1.5em;
   font-weight: bold;
}

#tbl {
   width: 500px;
   margin: 10px auto;
}

.content {
   height: 300px;
}

.profilebox{
   float: left;
}

.profilebox > div >img{
   width: 200px;
}

.infobox{
   float:left;
   background-color: #ffab91;
   width: 400px;
   height: 300px;
   padding: 20px;
   font-weight: bold;
   font-family: cursive;
   border-radius: 5px;
   margin-left: 40px;
    margin-top: 50px;
}

.infobox >div > p {
   font-weight: bold;
}

.infobox >div > p > label{
   font-size: 1.5em;
   color: white;
}

.mdl-button--accent.mdl-button--accent.mdl-button--raised{
   background-color: #ffa8a8;
}

.addbt{
   background-color: #ffa8a8 !important;
}
.delbt{
   background-color: ##bb7f7f59 !important;
}

.btn, .btn:focus {
   background-color: #ff8a80 !important;
}

.btn:hover {
   background-color: #ffab91;
}
.modal{
	max-width: 800px;
}

</style>

<script>
$(document).ready(function(){
    $('.modal').modal();
    $('select').formSelect();
    
    
    $(".addbt").click(function(){
    	if(confirm('수락하시겠어요??')){
    		$(this).parent().parent().parent().parent().remove();
    		//  seq -> $(this).val() , accept -> y , cofirm -> middle  
    		$.ajax({
    			type:"get",
    			url:"/Meeting/mypage/meetingresultconfirm.do",
    			data: "seq="+$(this).val()+"&accept=y&confirm=middle",
    			success:function(result){
    				console.log(result);
    				
    			},
    			error:function(a,b,c){
    				console.log(a+b+c);
    			}
    		});
    	
    	}
    	
    });
    
    $(".delbt").click(function(){
if(confirm('거절하시겠어요??')){
	$(this).parent().parent().parent().parent().remove();
    		//  seq -> $(this).val() , accept -> n , cofirm -> middle  
    		$.ajax({
    			type:"get",
    			url:"/Meeting/mypage/meetingresultconfirm.do",
    			data: "seq="+$(this).val()+"&accept=n&confirm=middle",
    			success:function(result){
    				console.log(result);
    				
    			},
    			error:function(a,b,c){
    				console.log(a+b+c);
    			}
    		});
    	
    	}
    });
   
  });
	
</script>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<jsp:include page="/inc/header.jsp">
			<jsp:param value="mypage" name="pageName" />
		</jsp:include>
		<!-- 페이지 이름 : introduce,matching,community,courtship,lovetest,mypage -->

		<main class="mdl-layout__content"> <jsp:include
			page="/inc/sub.jsp"></jsp:include> <jsp:include
			page="/inc/sublist.jsp"></jsp:include>
		<div id="content" class="mdl-grid portfolio-max-width">
			<h1>My Page</h1>
			<h2>오늘의 인연</h2>
			<div id="desc">
				<p>오늘 온 오늘의 인연 리스트입니다!!!!~~~</p>

			</div>
			<div id="mainbox" class="z-depth-3">
				<a href="/Meeting/mypage/mymeetingresultlist.do" id="bt"
					class="btn waves-effect waves-light" name="action"> <i
					class="material-icons">compare_arrows</i> 내가 보낸 매칭결과 보기
				</a>
	 
				 
<c:forEach items="${mlist}" var="dto"  varStatus="status">
				 
					  <!-- Modal Structure -->
					  <div id="modal${status.count}" class="modal">
					    <div class="modal-content" style="width: 800px;">
					      <h4>${dto.pname } 의 프로필 정보</h4>
					      <div class="profilebox" >
					      		<div>
					      		<c:if test="${dto.pimage eq 'null' || empty dto.pimage }">
					      		<img src="/Meeting/images/seokhyun/noprofile.png" />
					      	</c:if>
					      	<c:if test="${not empty dto.pimage && dto.pimage != 'null'}">
					      		<img src="/Meeting/profile/${dto.pimage }" />
					      	</c:if>
								</div>
								<p style="font-weight: bold; font-size: 2em;">자기소개:</p>
								<p>${dto.pintroduce }</p>
					      </div>
					     
					      <div class="infobox z-depth-2">
					      	<div style="float: left; width: 300px;">
						      	<p><label>ID(Name):</label>${dto.pid}(${dto.pname})</p>
						      	<p><label>닉네임:</label>${dto.pnick}</p>
						      	<p><label>나이:</label>${dto.page}</p> 
						      	<p><label>특기:</label>${dto.pability}</p>
						      	<p><label>등급:</label><img style="width: 50px; margin-top: 30px;" src="/Meeting/images/seokhyun/${dto.pbadge}.png"/>(${dto.pgrade}점)</p>
						      	<p><label>"${dto.pname}"의 한마디:</label>${dto.content }</p>
					  		</div>
					  		
				
					      </div>
					      <div style="clear: both;"></div>
					      
					      
					    </div>
					    <div class="modal-footer">
					      <a href="#!" class="modal-close waves-effect waves-green btn-flat">확인</a>
					    </div>
					  </div>
					  <!-- Modal Structure -->
					  
					  
					
						<table id="tbl" class="mdl-data-table mdl-js-data-table">
							
							<tr>
								<th style="text-align: left;"><i class="material-icons">person</i> 오늘의 인연</th>
								<td>
									<p>${dto.pname}(${dto.pid})</p>
								</td>
								<td style="text-align: right;">
									<a href="#modal${status.count}"
									 id="changbt"
									class="btn waves-effect waves-light modal-trigger"
									 name="action" style="margin-left: 10px;"> 회원 프로필 확인<i class="material-icons">compare_arrows</i>
										
									</a>
								</td>
							</tr>
							<tr>
								<th style="width: 30px; text-align: left;"><i class="material-icons">check_circle</i>
									나의 수락여부</th>
								<td><p id="accepttext">선택 전</p></td>
								<td style="text-align: right;">
								<div class="btn-group" role="group">
									
								<button type="button"  style="text-align: center;" value="${dto.seq}"
											class="addbt mdl-button mdl-js-button mdl-button--raised mdl-button--accent">
											수락 <i class="material-icons">favorite</i>
								</button>
								
								<button type="button"  style="text-align: center;" value="${dto.seq }"
											class="delbt mdl-button mdl-js-button mdl-button--raised mdl-button--accent">
											거절 <i class="material-icons">delete_forever</i>
								</button>
								</div>
								</td>
							</tr>
							
							
						</table>
						<input type="hidden" id="seq" name="seq" value="${dto.seq }" />
					
</c:forEach>
				



			</div>

		</div>
		<jsp:include page="/inc/footer.jsp"></jsp:include> </main>

	</div>
	<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	
</body>

</html>