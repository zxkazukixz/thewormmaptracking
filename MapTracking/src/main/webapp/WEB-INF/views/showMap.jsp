<%@page import="java.util.ArrayList"%>
<%@page import="com.theworm.mymap.model.Item"%>
<%@page import="com.theworm.mymap.model.Map"%>
<%@page import="java.util.List"%>
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
			<%
			    Integer hitsCount = (Integer)application.getAttribute("hitCounter");
			    if( hitsCount ==null || hitsCount == 0 ){
			       /* First visit */
			       out.println("Welcome to my website!");
			       hitsCount = 1;
			    }else{
			       /* return visit */
			       out.println("Welcome back to my website!");
			       hitsCount += 1;
			    }
			    application.setAttribute("hitCounter", hitsCount);
			%>
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
	
	<% 
		List<String> latitude = null;
		if (application.getAttribute("latitude") == null) {
			
		}else{
			latitude = (List) application.getAttribute("latitude");
		}
		
	%>
	
	<p>latitude: <%= latitude%></p>
	<p>Total number of visits: <%= hitsCount%></p>

</body>
</html>