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
  <a href="#about">About</a>
  <a href="#services">Services</a>
  <a href="#clients">Clients</a>
</div>

<header>
  <!-- HEADER MENU -->
  <div class="grid-container">
    <div id="menu0">
      <a href=index.jsp><img src="images/logo_no_background.png" alt="littytitty" style="width:100px;height:25px;">
    </div>
    <div id="menu1" class="titleList">
			<a href=professors.jsp><p>Professors</p></a>
		</div>
		<div id="menu2" class="titleList">
			<a href=courses.jsp><p>Courses</p></a>
		</div>
		<div id="menu3" class="titleList, curr">
			<a href=schedule.jsp><p>Schedule</p></a>
		</div>
  </div>
</header>

<body align="center">
  <div>
    <!--<button onclick="addEvent()" type="button" name="">Add Event</button>-->
  </div>
  <!--<script>
  var addEvent = function() {

    //var text = '{ "events" : [' + '{ "title":"John" , "start":"2018-01-02T12:30:00", "end":"2018-01-02T14:00:00" }]}';
    /*var text = '{ "events" : [' +
'{ "title":"Test" , "start":"2018-01-02T12:30:00", "end":"2018-01-02T14:00:00" },' +
'{ "title":"John" , "start":"2018-01-03T12:30:00", "end":"2018-01-03T14:00:00" }]}';*/

var filePath = 'schedule_events/1.txt';
var xmlhttp = new XMLHttpRequest();
xmlhttp.open("GET",filePath,false);
xmlhttp.send(null);
var fileContent = xmlhttp.responseText;

    var obj = JSON.parse(fileContent);

    for(var i = 0; i < obj.events.length; i++) {
      var testEvent = {
        title  : obj.events[i].title,
        start  : obj.events[i].start,
        end	 : obj.events[i].end
      }

      $('#calendar').fullCalendar('renderEvent', testEvent, true);
    }

    //document.getElementById("testOutput").innerHTML = obj.events[1].title + " " + obj.events[1].title;
  }
</script>-->
  <div class="main">
    <div align="center">
      <h2>Schedule</h2>
    </div>
    <p id="testOutput">hello</p>
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

</body>

</html>
