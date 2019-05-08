<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="date" value="<%= new Date() %>" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>우리나라의 포맷</h3>
	<fmt:setLocale value="ko_kr"/>
	금액: <fmt:formatNumber value="100000" type="currency"></fmt:formatNumber>
	일시: <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full"/>
	
	<h3>미국의 포맷</h3>
	<fmt:setLocale value="en_us"/>
	금액: <fmt:formatNumber value="100000" type="currency"></fmt:formatNumber>
	일시: <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full"/>
	
	<h3>일본의 포맷</h3>
	<fmt:setLocale value="ja_jp"/>
	금액: <fmt:formatNumber value="100000" type="currency"></fmt:formatNumber>
	일시: <fmt:formatDate value="${date }" type="both" dateStyle="full" timeStyle="full"/>
	
	<br />
	
	<fmt:timeZone value="America/New_York">
		날짜: <fmt:formatDate value="${date }" type="date"/>
		시각: <fmt:formatDate value="${date }" type="time"/>
	</fmt:timeZone>

</body>
</html>