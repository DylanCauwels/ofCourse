<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>


<html>
	     
<head>
  <title>Courses</title>
  <link rel="stylesheet" href="style.css">
</head>

<body onload="document.frm1.submit()">
   <form action="CourseServlet" method="post">
      <input type="hidden" name="purpose" value="PrefixLoad" />
   </form>
</body>

<div class="sidenav">
  <div>
    <h1>Search</h1>
  </div>
  <div id="search">
    <div>
      <a>Field of Study</a>
      <select required name="Prefix" form=getCourses>
        <option value="EE">EE</option>
        <option value="ME">ME</option>
        <option value="BME">BME</option>
        <option value="CE">CE</option>
      </select>
    </div>
    <div>
      <a>Course Number</a>
      <select required name="Number" form=getCourses>
        <option value="313">313</option>
        <option value="316">316</option>
        <option value="411">411</option>
        <option value="422C">422C</option>
      </select>
    </div>
    <div style = "padding-bottom: 15px; border-bottom: 1px dotted white;">
  		<form action="CourseServlet" method="post" id="getCourses">
		  	<div>
		  		<input type="submit" value="Search" class="button"/>
	  		</div>
		    <input type="hidden" name="purpose" value="CourseLoad" />
		</form>
    </div>
  </div>
</div>

<header>
  <!-- HEADER MENU -->
  <div class="grid-container">
    <div id="menu0">
      <a href=index.jsp><img src="images/logo_no_background.png" alt="littytitty" style="width:100px;height:25px;">
    </div>
    <div id="menu1">
      <p><a href=professors.jsp>Professors</a></p>
    </div>
    <div id="menu2" class="curr">
      <p><a href=courses.jsp>Courses</a></p>
    </div>
    <div id="menu3">
      <p><a href=schedule.jsp>Schedule</a></p>
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
  
  <%
  		String ass = (String)pageContext.getAttribute("test");
  %>
  
  
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
