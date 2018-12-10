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
  <title>Schedule</title>
  <link rel="stylesheet" href="style.css">

  <!-- CALENDAR DEPENDENCIES -->
  <link rel='stylesheet' href='fullcalendar/fullcalendar.css' />
  <script src='lib/jquery.min.js'></script>
  <script src='lib/moment.min.js'></script>
  <script src='fullcalendar/fullcalendar.js'></script>
  <script src='fullcalendar/calendarinit.js'></script>

</head>

<div class="sidenav">
  <div>
    <h1>Search</h1>
  </div>
  <div id="search">
    <div style="padding-bottom: 25px;">
      <form action="/schedule" method="post" id="requestCourses">
	  	<div>
	      <a>Enter Desired Courses</a>
	      <textarea name="title" rows="1" cols="30" style="width:90%; height:100;"></textarea>
	    </div>
	    <div class="slidecontainer">
	    	<a>Schedule Weight</a>
	    	<p style="color:white;"> CIS ------------------ RMP </p>
	  		<input name="slider" type="range" min="1" max="5" value="2" class="slider" id="myRange">
	  		<h2 id="demo" style="color:white;"></h2>
	  		<script>
	  			var slider = document.getElementById("myRange");
		  		var output = document.getElementById("demo");
		  		output.innerHTML = slider.value; // Display the default slider value
		
		  		// Update the current slider value (each time you drag the slider handle)
		  		slider.oninput = function() {
		  		  output.innerHTML = this.value;
		  		}
	  		</script>
		</div>
        <button class="button">Find Schedule</button>
      </form>
    </div>
  </div>
</div>

<header>
  <!-- HEADER MENU -->
  <div class="grid-container">
    <div id="menu0" style="margin-bottom: 10px; margin-top: 10px;">
			<a href=index.jsp><img id="indexLogo" src="images/logo_no_background.png" alt="littytitty" ></a>
		</div>
    <div id="menu1" class="titleList">
			<a href=professors.jsp style="margin-left:10px;"><p>Professors</p></a>
		</div>
		<div id="menu2" class="titleList">
			<a href=courses.jsp><p>Courses</p></a>
		</div>
		<div id="menu3" class="titleList">
			<a href=schedule.jsp class="curr" style="margin-right:10px;"><p>Schedule</p></a>
		</div>
		<div id="login">
			<%
	  		UserService userService = UserServiceFactory.getUserService();
	    	User user = userService.getCurrentUser();
		    if (user != null) {
		      pageContext.setAttribute("user", user); %>
			<p style="color:white; margin-bottom:5px; margin-top:5px;">User: ${fn:escapeXml(user.nickname)}</p> 
			<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>" style="color:white; align-content:center;">Sign out</a>
			<%
			} else {
			%>
			<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
			<%
		    }
			%>
		</div>
  </div>
</header>

<body align="center">
  <div class="main">
    <div align="center">
      <h2 style="font-size:30px;">Schedule</h2>
      <button onclick="clearSchedule()" class="button" type="button" name="">Clear Schedule</button>
    </div>
    <div align="center">
      <div style="width: 80%; height: 100%" id='calendar'></div>
    </div>
  </div>

  <div class="footer" align="center">
    <div class="footerBlock">
      <a href=index.jsp><img src="images/logo_outlined.png" alt="littytitty" style="width:100px;height:25px;"></a>
    </div>
    <div class="footerBlock">
      <p>© 2018-2019 ofCourse.university, Inc., or its affiliates</p>
    </div>
  </div>
  
  <script>
  var clearSchedule = function() {
	  
	  $('#calendar').fullCalendar('removeEvents');
	  
	  <%
	  	//Call Jonathan's clear contents.txt method
	  
	  
	  
	  %>
	  
  }
  
  </script>

</body>

</html>
