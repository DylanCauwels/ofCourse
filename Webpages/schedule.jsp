<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="guestbook.BlogPost" %>

<%@ page import="com.googlecode.objectify.*" %>


<%
	String filteredSearchTerm = request.getParameter("filteredSearchTerm");
	if(filteredSearchTerm==null){
		filteredSearchTerm = "";
	}
%>


<html>


  	<head>
		<title>OfCourse</title>
  		<link rel="stylesheet" href="style.css">
  	</head>



  	<body align="center">
		<!-- HEADER MENU -->
  		<div class="grid-container">
  			<div id="menu1">
  				<p><a href="professors.jsp">Professors</a></p>
  			</div>
  			<div id="menu2">
  				<p><a href="courses.jsp">Courses</a></p>
  			</div>
  			<div id="menu3">
  				<p><a href="schedule.jsp">Schedule</a></p>
  			</div>
  		</div>
  	
  		<div align="center">
			<h1>
				<a href="index.jsp" class="main_title">ofCourse</a>
			</h1>
			<h2>Schedule</h2>
	  	</div>
	  
	  	<!-- PAGE CONTENT -->	
	  	
	  	<div>
	  		<table style="border: 1px solid black" align="center">
	  			<tr>
	  				<th></th>
	  				<th>Monday</th>
	  				<th>Tuesday</th>
	  				<th>Wednesday</th>
	  				<th>Thursday</th>
	  				<th>Friday</th>
	  				<th>Saturday</th>
	  				<th>Sunday</th>
	  			</tr>
	  			<tr>
	  				<th>8:00 am</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>9:00 am</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>10:00 am</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>11:00 am</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>12:00 am</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>1:00 pm</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>2:00 pm</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>3:00 pm</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>4:00 pm</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>5:00 pm</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>6:00 pm</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>7:00 pm</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  			<tr>
	  				<th>8:00 pm</th>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  				<td></td>
	  			</tr>
	  		</table>
	  	</div>


		
  	</body>

</html>