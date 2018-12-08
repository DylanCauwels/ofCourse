<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="com.googlecode.objectify.*" %>

<html>


<head>
  <link rel="stylesheet" href="style.css">
  <title>Professors</title>
</head>


<div class="sidenav">
  <div>
    <h1>Search</h1>
  </div>
  <div id="search">
    <div>
      <a href="#Prefix">Last Name</a>
      <select required >
        <option value="Eberlein">Eberlein</option>
        <option value="Cuevas">Cuevas</option>
        <option value="Nandakumar">Nandakumar</option>
        <option value="Julien">Julien</option>
      </select>
    </div>
    <div>
      <a href="#services">First Initial</a>
      <select required>
        <option value="313">313</option>
        <option value="316">316</option>
        <option value="411">411</option>
        <option value="422C">422C</option>
      </select>
    </div>
    <div style = "padding-bottom: 15px; border-bottom: 1px dotted white;">
      <button class = "button">Find Sections</button>
    </div>
  </div>
</div>

<header>
  <!-- HEADER MENU -->
  <div class="grid-container">
    <div id="menu0">
      <a href=index.html><img src="logo_no_background.png" alt="littytitty" style="width:100px;height:25px;">
    </div>
    <div id="menu1" class="curr">
      <p><a href=professors.html>Professors</a></p>
    </div>
    <div id="menu2">
      <p><a href=courses.html>Courses</a></p>
    </div>
    <div id="menu3">
      <p><a href=schedule.html>Schedule</a></p>
    </div>
  </div>
</header>

<body align="center">

  <div class="main">
    <h2 style="font-size:30px;">Eberlein, M Sections</h1>
    <!-- PAGE CONTENT -->
    <table align="center" id="displaytable">
      <tr id="tableheader">
        <th>Unique Number</th>
        <th>Prefix</th>
        <th>Number</th>
        <th>RMP Rating</th>
        <th>Average Grade</th>
      </tr>
      <tr>
        <td>13050</td>
        <td>EE</td>
        <td>461L</td>
        <td>1.0</td>
        <td>1.0</td>
      </tr>
      <tr>
        <td>13055</td>
        <td>EE</td>
        <td>316</td>
        <td>2.5</td>
        <td>3.0</td>
      </tr>
      <tr>
        <td>13060</td>
        <td>EE</td>
        <td>360C</td>
        <td>3.2</td>
        <td>4.0</td>
      </tr>
    </table>

  </div>

  <div class="footer" align="center">
		<div class = "footerBlock">
			<a href=index.html><img src="images/logo_outlined.png" alt="littytitty" style="width:100px;height:25px;"></a>
		</div>
		<div class = "footerBlock">
			<p>© 2018-2019 ofCourse.university, Inc., or its affiliates</p>
		</div>
	</div>


</body>

</html>