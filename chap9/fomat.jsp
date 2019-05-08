<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<fmt:formatNumber value="3.146733" pattern="#.00"></fmt:formatNumber>
	
	<c:set var="num" value="0" scope="request"></c:set>
	<c:set var="num1" value="100" scope="request"></c:set>
	<c:set var="num2" value="10" scope="request"></c:set>
	
	
	<c:if test="${num1>num2 }">
		num1 이 더 큽니다.
	</c:if>
	
	<c:choose>
		<c:when test="${num==0 }">
			처음 뵙겠습니다. <br>
		</c:when>
		<c:when test="${num==1 }">
			반갑습니다. <br>
		</c:when>
		<c:otherwise>
			안녕하세요. <br />
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="str" items="${arr}">
		${str} <br />
	</c:forEach>
	
	<c:forTokens var="pet" items="햄스터-이구아나&소라게" delims="-&">
		${pet} <br />
	</c:forTokens>
	<%-- 
	<c:redirect url="호출할 웹자원">
		<c:param name="code" value="1234"></c:param>
	</c:redirect>
	 --%>
	 
	 <c:out value="<input>은 <form> 의 서브엘리먼트입니다."></c:out>
	 
	 <c:out value="${id }" default="guest"></c:out>
</body>
</html>