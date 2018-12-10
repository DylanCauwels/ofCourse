<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>

<head>
	<title>ofCourse</title>
	<link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="slideshow.css">

</head>

<div class="sidenav">
	<a href="#about">About</a>
	<a href="#services">Services</a>
	<a href="#clients">Clients</a>

</div>

<header>
	<!-- HEADER MENU -->
	<div class="grid-container" id="index-grid-container">

		<div id="menu0">
			<a href=index.jsp><img id="indexLogo" src="images/logo_no_background.png" alt="littytitty" ></a>
		</div>
		<div id="menu1" class="titleList">
			<a href=professors.jsp><p>Professors</p></a>
		</div>
		<div id="menu2" class="titleList">
			<a href=courses.jsp><p>Courses</p></a>
		</div>
		<div id="menu3" class="titleList">
			<a href=schedule.jsp><p>Schedule</p></a>
		</div>
		<div id="login" class="titleList">
			<%
	  		UserService userService = UserServiceFactory.getUserService();
	    	User user = userService.getCurrentUser();
		    if (user != null) {
		      pageContext.setAttribute("user", user); %>
			<p style="color:white;">User: ${fn:escapeXml(user.nickname)}</p>
			<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>" style="color:black; margin-left: 200px;">Sign out</a>
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

<div class="container">
	<!-- Slideshow container -->
<div class="slideshow-container">

  <!-- Full-width images with number and caption text -->
  <div class="mySlides fade">
    <div class="numbertext">1 / 3</div>
    <img class="slideshow" src="images/slideshow_1.jpg" style="width:100%">
    <div class="text">The University of Texas at Austin</div>
  </div>

  <div class="mySlides fade">
    <div class="numbertext">2 / 3</div>
    <img class="slideshow" src="images/slideshow_2.jpg" style="width:100%">
    <div class="text">The University of Texas at Austin</div>
  </div>

  <div class="mySlides fade">
    <div class="numbertext">3 / 3</div>
    <img class="slideshow" src="images/slideshow_3.jpg" style="width:100%">
    <div class="text">The University of Texas at Austin</div>
  </div>
</div>
<div class="centered">
	<div align="center">
		<h1 class="main_title">WELCOME TO</h1>
		<h1>
			<div class="main_title">ofCourse</div>
		</h1>
	</div>
</div>
</div>
<br>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}
  slides[slideIndex-1].style.display = "block";
  setTimeout(showSlides, 4000); // Change image every 2 seconds
}
</script>

	<!-- PAGE CONTENT -->
	<div class="main">
		<p>
			ofCourse is a course scheduling and class information platform for students at the University of Texas at Austin. ofCourse allows you to choose the classes, professors, and schedule that best suits your needs.
		</p>
		<br>
		<h2 id="about">About</h2>
		<p>
			ofCourse started in 2018 at The University of Texas at Austin by five Electrical Engineering students. Fed up with the archaic and unreliable registration system, they sought to create a platform that streamlined the course registration process. ofCourse runs on Google App Engine and is available for use to the public.
		</p>
		<br>
		<h2 id="services">Services</h2>
		<p>
			ofCourse provides a wide range of course scheduling services, allowing you to search courses, their professors, and student ratings. We allow you to build your perfect school schedule, all in a simple, intuitive user interface.
		</p>
		<h2 id="clients">Clients</h2>
		<p>
			Here are some of our more notable clients:
		</p>
		<table align="center"><tr>
			<td><img style="margin: 0px; width:200px; height:200px; overflow: hidden" src="/images/spiderman.jpg"></td>
			<td><img style="margin: 0px; width:200px; height:200px; overflow: hidden" src="/images/obama.jpg"></td>
			<td><img style="margin: 0px; width:200px; height:200px; overflow: hidden" src="/images/oprah.jpg"></td>
		</tr></table>
	</div>

	<!-- PAGE FOOTER -->
	<div class="footer" align="center">
		<div class = "footerBlock">
			<a href=index.jsp><img src="images/logo_outlined.png" alt="littytitty" style="width:100px;height:25px;"></a>
		</div>
		<div class = "footerBlock">
			<p>© 2018-2019 ofCourse.university, Inc., or its affiliates</p>
		</div>
		<!-- DELETE THE LINK BELOW -->
		<a style="color: Black" href=error.html>Error testing link</a>
	</div>







	</body>

</html>
