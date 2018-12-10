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
      <select required name="lastName" form="requestProfessors">
        <option value="Eberlein">Eberlein</option>
        <option value="Cuevas">Cuevas</option>
        <option value="Nandakumar">Nandakumar</option>
        <option value="Julien">Julien</option>
      </select>
    </div>
    <div>
      <a href="#services">First Initial</a>
      <select required name="firstInitial" form="requestProfessors">
        <option value="M">M</option>
        <option value="J">J</option>
        <option value="A">A</option>
        <option value="B">B</option>
      </select>
    </div>
    <div style = "padding-bottom: 15px; border-bottom: 1px dotted white;">
      <form action="/professors" method="post" id="requestProfessors">
        <button class = "button">Search</button>
      </form>    </div>
  </div>
</div>

<header>
  <!-- HEADER MENU -->
  <div class="grid-container">
    <div id="menu0">
      <a href=index.jsp id="indexLogoLink"><img id="indexLogo" src="images/logo_no_background.png" alt="littytitty">
    </div>
    <div id="menu1" class="titleList, curr">
			<a href=professors.jsp><p>Professors</p></a>
		</div>
		<div id="menu2" class="titleList">
			<a href=courses.jsp><p>Courses</p></a>
		</div>
		<div id="menu3" class="titleList">
			<a href=schedule.jsp><p>Schedule</p></a>
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


</body>

</html>
