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
			<h2>Courses</h2>
	  	</div>
	  
	  	<!-- PAGE CONTENT -->	
	  	<p>Search here for a specific Course here:</p>	
	  	<input/>
	  	<button>Search</button>
	  	
	  	<ul align="left">
	  		<li>EE 422C</li>
	  		<li>EE 461L</li>
	  		<li>E 379R</li>
	  		<li>PED 106C</li>
	  	</ul>
	  	


		
  	</body>

</html>
