<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>







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
  			<h1 class="main_title">WELCOME TO</h1>
			<h1>
				<a href="index.jsp" class="main_title">ofCourse</a>
			</h1>
	  	</div>
	  
	  	<!-- PAGE CONTENT -->	
	  	<div class="body_text">
	  		<p>ofCourse is a course scheduling and class information platform for students at the University of Texas at Austin. ofCourse allows you to choose the classes, professors, and schedule that best suits your needs.</p>
	  	</div>
	  	
	  	<%
	  		UserService userService = UserServiceFactory.getUserService();

	    	User user = userService.getCurrentUser();
		
		    if (user != null) {
		
		      pageContext.setAttribute("user", user);
		
		%>
		
						<p>User: ${fn:escapeXml(user.nickname)}</p>
		
						<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">Sign out</a>
		
		<%
		
		    } else {
		
		%>
						<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
		
		<%
		
		    }
		
		%>
	  	
	  	
	  	





	</body>

</html>
