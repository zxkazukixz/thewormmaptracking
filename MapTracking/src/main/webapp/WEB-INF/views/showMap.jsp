<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<P>Show Map Online Tracking</P>
	<div id="">
		<table id="" border="1">
			<tr>
				<th>Name</th>
				<th>Longitude</th>
				<th>Latitude</th>
			</tr>
			<c:forEach var="map" items="${maps}">
				<tr>
					<td>${map.name}</td>
					<td>${map.longitude}</td>
					<td>${map.latitude}</td>
					<td><a href="${pageContext.request.contextPath}/addMap/${map.mapid}">Add Map</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
</body>
</html>