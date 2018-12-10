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
  <title>Courses</title>
  <link rel="stylesheet" href="style.css">
</head>

<div class="sidenav">
  <div>
    <h1>Search</h1>
  </div>
  <div id="search">
    <div>
      <a href="#Prefix">Field of Study</a>
      <select required >
        <option value="EE">EE</option>
        <option value="ME">ME</option>
        <option value="BME">BME</option>
        <option value="CE">CE</option>
      </select>
    </div>
    <div>
      <a href="#services">Course Number</a>
      <select required>
        <option value="313">313</option>
        <option value="316">316</option>
        <option value="411">411</option>
        <option value="422C">422C</option>
      </select>
    </div>
    <div style = "padding-bottom: 15px; border-bottom: 1px dotted white;">
      <button class = "button">Search</button>
    </div>
  </div>
</div>

<header>
  <!-- HEADER MENU -->
  <div class="grid-container">
    <div id="menu0" style="margin-bottom: 10px; margin-top: 10px">
			<a href=index.jsp><img id="indexLogo" src="images/logo_no_background.png" alt="littytitty"></a>
		</div>
    <div id="menu1" class="titleList">
			<a href=professors.jsp><p>Professors</p></a>
		</div>
		<div id="menu2" class="titleList, curr">
			<a href=courses.jsp><p>Courses</p></a>
		</div>
		<div id="menu3" class="titleList">
			<a href=schedule.jsp><p>Schedule</p></a>
		</div>
  </div>
</header>

<body align="center">
  <div class="main">
    <!-- PAGE CONTENT -->
    <table align="center" id="displaytable">
      <h2 style="font-size:30px;">EE 461L Sections</h1>
      <tr id="tableheader">
        <th>Unique Number</th>
        <th>Last Name</th>
        <th>First Initial</th>
        <th>RMP Rating</th>
        <th>Average Grade</th>
      </tr>
      <tr>
        <td>11001</td>
        <td>Eberlein</td>
        <td>M</td>
        <td>1.0</td>
        <td>1.0</td>
      </tr>
      <tr>
        <td>11050</td>
        <td>Cuevas</td>
        <td>A</td>
        <td>2.5</td>
        <td>3.0</td>
      </tr>
      <tr>
        <td>11010</td>
        <td>Julien</td>
        <td>C</td>
        <td>3.2</td>
        <td>4.0</td>
      </tr>
    </table>

  </div>

  <div class="footer" align="center">
		<div class = "footerBlock">
			<a href=index.jsp><img src="images/logo_outlined.png" alt="littytitty" style="width:100px;height:25px;"></a>
		</div>
		<div class = "footerBlock">
			<p>© 2018-2019 ofCourse.university, Inc., or its affiliates</p>
		</div>
	</div>

</body>

</html>
