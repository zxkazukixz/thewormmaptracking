<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	function doAjaxPost() {

		// get the form values
		
		var name = $('#name').val();

		var longitude = Math.floor((Math.random() * 191829) + 1);

		var latitude = Math.floor((Math.random() * 191829) + 10);
		
		
		$.ajax({
			type : "GET",

			url : "http://localhost:8080/mymap/Addmap",
			
			data : "name=" + name + "&longitude=" + longitude + "&latitude=" + latitude,
			
			success : function(response) {

				// we have the response
				
				console.log(response);
				
				$('#name').val('');

				$('#longitude').val('');

				$('#latitude').val('');

			},

			error : function(e) {

				alert('Error: ' + e);

			}

		});

	}
</script>

<title>Home</title>
</head>
<body onload="myFunction()">
	<h1>Hello world!</h1>
	<a href="${pageContext.request.contextPath}/showMap">Show Map</a>
	<P>The time on the server is ${serverTime}.</P>
	<div id="">
		<table id="" border="1">
			<tr>
				<th>Dept No</th>
				<th>Dept Name</th>
				<th>Location</th>
			</tr>
			<c:forEach var="map" items="${maps}">
				<tr>
					<td>${map.name}</td>
					<td>${map.longitude}</td>
					<td>${map.latitude}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<button onclick="RemoveRule ();">Remove a rule and refresh the table!</button>


	<input type="text" id="name">
	<input type="text"id="longitude">
	<input type="text" id="latitude">
	<input type="button" value="Add map" id="save" onclick="doAjaxPost()">


</body>
</html>
