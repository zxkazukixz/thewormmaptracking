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
	<table id="" border="1">
		<tr>
			<th>NameSession</th>
			<th>LongitudeSession</th>
			<th>LatitudeSession</th>
			<th>quantity</th>
		</tr>

		<c:forEach var="it" items="${sessionScope.mapsSession}">
			<tr>
				<td>${it.map.name}</td>
				<td>${it.map.longitude}</td>
				<td>${it.map.latitude}</td>
				<td>${it.quantity}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>