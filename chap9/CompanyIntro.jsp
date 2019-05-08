<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="Intro"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="TITLE"/></title>
</head>
<body>
	<h3><fmt:message key="TITLE"/></h3>
	<fmt:message key="GREETING" var="greeting"/> <br><br>
	<fmt:message key="BODY" var="body"/> <br><br>
	<font size="2"><fmt:message key="COMPANY_NAME" var="companyName"/></font>
	
</body>
</html>