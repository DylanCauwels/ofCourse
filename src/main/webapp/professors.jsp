<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
  			<div id="menu0">
  				<a href="index.jsp""><img name="url_logo_index" height=100% src="images/logo.png" alt="ofCourse" /></a>
  			</div>
  			<div id="menu1">
  				<p name="url_professors"><a href="professors.jsp">Professors</a></p>
  			</div>
  			<div id="menu2">
  				<p name="url_courses"><a href="courses.jsp">Courses</a></p>
  			</div>
  			<div id="menu3">
  				<p name="url_schedule"><a href="schedule.jsp">Schedule</a></p>
  			</div>
  		</div>

  		<div align="center">
			<h1>
				<a href="index.jsp" class="main_title">ofCourse</a>
			</h1>
			<h2>Professors</h2>
	  	</div>

	  	<!-- PAGE CONTENT -->
	  	<p>Search here for a specific Professor here:</p>
	  	<input/>
	  	<button>Search</button>

	  	<ul align="left">
	  		<li>Angela A. Aaronson</li>
	  		<li>Brian B. Barksdale</li>
	  		<li>Ciara C. Cortez</li>
	  	</ul>




  	</body>

</html>
