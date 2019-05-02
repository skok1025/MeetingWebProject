<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorpage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="A portfolio template that uses Material Design Lite.">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<title>Template</title>
		
		<jsp:include page="/inc/asset.jsp"></jsp:include>
		
		<style>
			#content {
				min-height: 200px;
			}
			
			.card-action{
				text-align: right;
			}
			
			.card-title {
				text-align: center;
			}
		</style>
	
		<script>
			$("#cancel").window.close();
			
		    function formSubmit()
		    {
		    	document.getElementById("frm1").submit();
		    }
		</script>
	</head>
	
	<body>
		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
	
			<header
				class="mdl-layout__header mdl-layout__header--waterfall portfolio-header">
				<div class="mdl-layout__header-row portfolio-logo-row">
					<span class="mdl-layout__title">
						<div class="portfolio-logo"></div> 
						<span class="mdl-layout__title">Simple portfolio website</span>
					</span>
				</div>
			</header>
	
			<main class="mdl-layout__content">
			<div id="content" class="mdl-grid portfolio-max-width">
				<form action="/Meeting/courtship/profilemessagesend.do" method="get" id="frm1" class="col s12">
					<div class="row">
						<div class="col s12 m6">
							<div class="card blue-grey darken-1">
								<div class="card-content white-text" style="padding-bottom:0px;">
									<span class="card-title">쪽지</span>
									
									<hr />
									
									<div class="row">
										<div class="input-field col s12">
											<textarea style="margin-bottom:0px;" id="context" name="context" class="materialize-textarea"></textarea>
											<label for="textarea1">Textarea</label>
										</div>
									</div>
								</div>
								<div class="card-action">
									<a class="button" onclick="formSubmit(); return false;">보내기</a>
									<a href="javascript:window.open('','_self').close();">취소하기</a>
								</div>
							</div>
						</div>
					</div>
					<input type="hidden" name="pseq" id="pseq" value=${pseq} />
					<input type="hidden" name="cseq" id="cseq" value=${cseq} />
				</form>
	
			</div>
		</div>
		<script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	</body>
</html>