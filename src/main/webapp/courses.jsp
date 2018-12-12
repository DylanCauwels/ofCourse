<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.*" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="com.googlecode.objectify.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String filteredSearchTerm = request.getParameter("filteredSearchTerm");
	if(filteredSearchTerm==null){
		filteredSearchTerm = "";
	}
%>


<html>
<script>
	$(document).ready(function(){
	     $("#getPrefix").submit();
	});
</script>

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
      <a>Field of Study</a>
      <select required name="prefix" form="requestCourses">
	      <%
	      	Set<String> prefixes = (Set<String>)session.getAttribute("prefixes");
	      	if(prefixes != null) {
	    		for(String curr: prefixes) {
		      		%> 	<option value="<%=curr%>"><%=curr%></option>
		      		<% 
		      	}
	      	}
	      %>
      </select>
    </div>
    <div>
      <a>Course Number</a>
      <select required name="number" form="requestCourses">
	      <%
	      	Set<String> numbers = (Set<String>)session.getAttribute("numbers");
	      	if(numbers != null) {
	    		for(String curr: numbers) {
		      		%> 	<option value="<%=curr%>"><%=curr%></option>
		      		<% 
		      	}
	      	}
	      %>
      </select>
      <form action="/prefixes" method="post" id="getPrefix" name="getPrefix"></form>
    </div>
    <div style = "padding-bottom: 25px;">
      <form action="/courses" method="post" id="requestCourses">
        <button class="button">Search</button>
      </form>
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
			<a href=professors.jsp style="margin-left:10px;"><p>Professors</p></a>
		</div>
		<div id="menu2" class="titleList">
			<a href=courses.jsp class="curr"><p>Courses</p></a>
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
    <!-- PAGE CONTENT -->
    <table align="center" id="displaytable">
      <h2 style="font-size:30px;"> <% if(request.getParameter("prefix") != null) { %> <%= request.getParameter("prefix") %> <%= request.getParameter("number") %> <%} %> Sections</h1>
      <tr id="tableheader">
        <th>Unique Number</th>
        <th>Last Name</th>
        <th>First Initial</th>
        <th>RMP Rating</th>
        <th>Average Grade</th>
      </tr>
      <%
       	ObjectifyService.register(Algorithm.Section.class);
 			List<Algorithm.Section> sections = ObjectifyService.ofy().load().type(Algorithm.Section.class)
		    .filter("prefix", request.getParameter("prefix"))
		    .filter("number", request.getParameter("number"))
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

	<% if (session.getAttribute("prefixes") == null || session.getAttribute("numbers") == null) { %>
	  <script language="javascript" type="text/javascript">
	  	document.forms["getPrefix"].submit();
/*         alert("Getting Initial Data- Prefixes");
 */	  </script>
	<% } %>

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
