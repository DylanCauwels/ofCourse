<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="com.googlecode.objectify.*" %>

<%@ page import="ofCourse.LegacySection"%>

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
      <select id="lastName" name="name" form="requestProfessors">
	      <%
	      	Set<String> names = (Set<String>)session.getAttribute("names");
  			if(names != null) {	
		      	for(String curr: names) {
		      		%> 	<option value="<%=curr%>"><%=curr%></option>
		      		<% 
		      	}      	
  			}
	      %>
      </select>
    </div>
    <div>
      <a>First Initial</a>
      <select required name="initial" form="requestProfessors">
	      <%
	      	Set<String> initials = (Set<String>)session.getAttribute("initials");
	      	if(initials != null) {
	    		for(String curr: initials) {
		      		%> 	<option value="<%=curr%>"><%=curr%></option>
		      		<% 
		      	}
	      	}
	      %>
      </select>
      <form action="/names" method="post" id="getNames" name="getNames"></form>
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
			<p id="email">${fn:escapeXml(user.nickname)}</p> 
			<a id="signout" href="<%=userService.createLogoutURL(request.getRequestURI())%>">Sign Out</a>
			<%
			} else {
			%>
			<a id="signin" href="<%= userService.createLoginURL(request.getRequestURI()) %>">Log In</a>
			<%
		    }
			%>
		</div>
  </div>
</header>

<body align="center">

  <div class="main">
    <h2 style="font-size:30px;"><% if(request.getParameter("initial") != null) { %> <%= request.getParameter("name") %>, <%= request.getParameter("initial") %> <%} %>Sections</h1>
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
       	ObjectifyService.register(Algorithm.Section.class);
 			List<Algorithm.Section> sections = ObjectifyService.ofy().load().type(Algorithm.Section.class)
		    .filter("initial", request.getParameter("initial"))
		    .filter("name", request.getParameter("name"))
		    .list();
 			if(sections != null) {
    		Iterator<Algorithm.Section> iter = sections.iterator();
	      	while(iter.hasNext()) {
	      		Algorithm.Section curr = iter.next();
	      		pageContext.setAttribute("unique", curr.getUnique());
	      		pageContext.setAttribute("prefix", curr.getPrefix());
	      		pageContext.setAttribute("number", curr.getNumber());
	      		pageContext.setAttribute("rmp", curr.getRMP());
	      		pageContext.setAttribute("gpa", curr.getGPA());
	      		%> 	<tr>
	      				<td> ${fn:escapeXml(unique)} </td>
	      				<td>  ${fn:escapeXml(prefix)} </td>
						<td>  ${fn:escapeXml(number)} </td>
						<td>  ${fn:escapeXml(rmp)} </td>
						<td>  ${fn:escapeXml(gpa)} </td>

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
	
	<% if (session.getAttribute("initials") == null || session.getAttribute("names") == null) { %>
	  <script language="javascript" type="text/javascript">
	  	document.forms["getNames"].submit();
/*         alert("Getting Initial Data");
 */ 	  </script>
	<% } %>
</body>

</html>
