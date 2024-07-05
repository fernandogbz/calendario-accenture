<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="/css/styles.css" rel="stylesheet">
	</head>
	<body style="width:970px; margin: auto;">
	
		<div>
			<c:forEach items="${events}" var="event" >
			<div class="event-box">
				<p>${event.modality}</p>
				<h2>${event.name}</h2>
				<p>${event.date} * ${event.dateTime}</p>
			</div>
			
			</c:forEach>
		</div>
		
	</body>
</html>