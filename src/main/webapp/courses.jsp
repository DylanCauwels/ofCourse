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
	<div class="header">
		<h1 id="logo"><a class="menu" href=index.jsp>ofCourse</a></h1>
		<ul>
			<li id="home"><a class="menu" href=professors.jsp>Professors</a></li>
			<li><a class="menu" href=courses.jsp>Courses</a></li>
			<li><a class="menu" href=schedule.jsp>Schedule</a></li>
			<li><a>Contact Us</a></li>
		</ul>
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
