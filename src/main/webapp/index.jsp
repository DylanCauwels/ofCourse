<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="com.googlecode.objectify.*" %>

<html>

<head>
	<title>OfCourse</title>
	<link rel="stylesheet" href="style.css">
</head>


<body align="center">
	<div class="header">
		<h1 id="logo"><a class="menu" href=index.jsp>ofCourse</a></h1>
		<ul>
			<li><a class="menu" href=professors.jsp>Professors</a></li>
			<li><a class="menu" href=courses.jsp>Courses</a></li>
			<li><a class="menu" href=schedule.jsp>Schedule</a></li>
			<li><a>Contact Us</a></li>
		</ul>
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
	  	<%	String test = request.getParameter("test");
	  		pageContext.setAttribute("test", test);   %> 	
	  	<%
	  		UserService userService = UserServiceFactory.getUserService();
	    	User user = userService.getCurrentUser();
		    if (user != null) {
		      pageContext.setAttribute("user", user);
		%>
			<p id="user" >User: ${fn:escapeXml(user.nickname)}</p>
			<a id="user" href="<%= userService.createLogoutURL(request.getRequestURI()) %>">Sign out</a>
		<%
		    } else {
		%>
			<a id="user" href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
		<%
		    }
		%>
	    <form action="/professors" method="post">
	      <div><input type="submit" value="Post" /></div>
	    </form>
		<p> test: ${fn:escapeXml(test)} </p>
	</body>
</html>
