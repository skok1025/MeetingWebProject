<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
 .mdl-layout__title{
 	color: black;
 }
</style>	
<script>
	$(document).ready(function() {

	});
</script>
<header
	class="mdl-layout__header mdl-layout__header--waterfall portfolio-header">
	<div class="mdl-layout__header-row portfolio-logo-row">
		<a href="/Meeting/introduce/mainindex.do">
		<span class="mdl-layout__title">
			<div class="portfolio-logo"> </div> <span class="mdl-layout__title"><%=request.getParameter("pageName")%></span>
		</span>
		</a>
	</div>
	<div
		class="mdl-layout__header-row portfolio-navigation-row mdl-layout--large-screen-only">
		<nav
			class="mdl-navigation mdl-typography--body-1-force-preferred-font">
			<%
				if (request.getParameter("pageName") == "introduce") {
			%>
			<a id="introducebt" class="mdl-navigation__link is-active" href="#">Introduce</a>
			<%
				} else {
			%>
			<a id="introducebt" class="mdl-navigation__link" href="#">Introduce</a>
			<%
				}
			%>

			<%
				if (request.getParameter("pageName") == "matching") {
			%>
			<a id="matchingbt" class="mdl-navigation__link is-active" href="#">Matching</a>
			<%
				} else {
			%>
			<a id="matchingbt" class="mdl-navigation__link" href="#">Matching</a>
			<%
				}
			%>

			<%
				if (request.getParameter("pageName") == "community") {
			%>
			<a id="communitybt" class="mdl-navigation__link is-active" href="/Meeting/community/daterecommend.do">Community</a>
			<%
				} else {
			%>
			<a id="communitybt" class="mdl-navigation__link" href="#">Community</a>
			<%
				}
			%>

			<%
				if (request.getParameter("pageName") == "courtship") {
			%>
			<a id="courtshipbt" class="mdl-navigation__link is-active">Courtship</a>
			<%
				} else {
			%>
			<a id="courtshipbt" class="mdl-navigation__link" href="#">Courtship</a>
			<%
				}
			%>

			<%
				if (request.getParameter("pageName").toString().equals("lovetest")) {
			%>
			<a id="lovetestbt" class="mdl-navigation__link is-active" href="/Meeting/love/lovetestmain.do">LoveTest</a>
			<%
				} else {
			%>
			<a id="lovetestbt" class="mdl-navigation__link" href="#">LoveTest</a>
			<%
				}
			%>

			<%
				if (request.getParameter("pageName").toString().equals("mypage")) {
			%>
			<a id="mypagebt" class="mdl-navigation__link is-active" href="#">MyPage</a>
			<%
				} else {
			%>
			<a id="mypagebt" class="mdl-navigation__link " href="#">MyPage</a>
			<%
				}
			%>
		</nav>
	</div>


</header>
<div class="mdl-layout__drawer mdl-layout--small-screen-only">
	<nav class="mdl-navigation mdl-typography--body-1-force-preferred-font">
		<a class="mdl-navigation__link is-active" href="index.html">Portfolio</a>
		<a class="mdl-navigation__link" href="blog.html">Blog</a> <a
			class="mdl-navigation__link" href="about.html">About</a> <a
			class="mdl-navigation__link" href="contact.html">Contact</a>
	</nav>
</div>

