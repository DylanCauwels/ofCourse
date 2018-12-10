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
      <a>Last Name</a>
      <select id="lastName" name="lastName" form="requestProfessors">
	      <%
	      	ArrayList<String> names = (ArrayList<String>)session.getAttribute("names");
	      	if(names != null) {
 		      	for(int i = 0; i < names.size(); i++) {
		      		%> 	<option value="<%=names.get(i)%>"${fn:escapeXml(selected)}><%=names.get(i)%></option>
		      		<% 
		      	}	      	
	      	}
	      %>
      </select>
    </div>
    <div>
      <a>First Initial</a>
      <select required name="firstInitial" form="requestProfessors">
	      <%
	      	ArrayList<String> initials = (ArrayList<String>)session.getAttribute("initials");
	      	if(initials != null) {
 		      	for(int i = 0; i < initials.size(); i++) {
		      		%> 	<option value="<%=initials.get(i)%>"><%=initials.get(i)%></option>
		      		<%
		      	}
	      	}
	      %>
      </select>
      <form action="/names" method="get" id="getName" name="getName"></form>
      <form action="/names" method="post" id="getLast" name="getLast"></form>
    </div>
    <div style = "padding-bottom: 25px;">
      <form action="/professors" method="post" id="requestProfessors">
        <button class="button">Search</button>
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
			<a href=professors.jsp class="curr" style="margin-left:10px;"><p>Professors</p></a>
		</div>
		<div id="menu2" class="titleList">
			<a href=courses.jsp><p>Courses</p></a>
		</div>
		<div id="menu3" class="titleList">
			<a href=schedule.jsp style="margin-right:10px;"><p>Schedule</p></a>
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
    <h2 style="font-size:30px;"><% if(request.getParameter("firstInitial") != null) { %> <%= request.getParameter("lastName") %>, <%= request.getParameter("firstInitial") %> <%} %>Sections</h1>
    <!-- PAGE CONTENT -->
    <table align="center" id="displaytable">
      <tr id="tableheader">
        <th>Unique Number</th>
        <th>Prefix</th>
        <th>Number</th>
        <th>RMP Rating</th>
        <th>Average Grade</th>
      </tr>
      <%
      	ArrayList<String> sections = (ArrayList<String>)session.getAttribute("professors");
      	if(sections != null) {
      		pageContext.setAttribute("professors", sections);
	      	int sectionNum = sections.size()/5;
	      	for(int i = 0; i < sectionNum; i++) {
	      		pageContext.setAttribute("first", sections.get(5*i));
	      		pageContext.setAttribute("second", sections.get((5*i)+1));
	      		pageContext.setAttribute("third", sections.get((5*i)+2));
	      		pageContext.setAttribute("fourth", sections.get((5*i)+3));
	      		pageContext.setAttribute("fifth", sections.get((5*i)+4));
	      		%> 	<tr>
	      				<td> ${fn:escapeXml(first)} </td>
	      				<td>  ${fn:escapeXml(second)} </td>
						<td>  ${fn:escapeXml(third)} </td>
						<td>  ${fn:escapeXml(fourth)} </td>
						<td>  ${fn:escapeXml(fifth)} </td>

	      			</tr>
	      		<%
	      	}
      	}
      %>
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
	
	<% if (session.getAttribute("names") == null) { %>
	  <script language="javascript" type="text/javascript">
	  	document.forms["getLast"].submit();
        alert("Getting Initial Data- Names");
 	  </script>
	<% } %>

	<% if (session.getAttribute("initials") == null) { %>
	  <script language="javascript" type="text/javascript">
	  	document.forms["getName"].submit();
        alert("Getting Initial Data= Initials");
 	  </script>
	<% } %>
</body>

</html>
