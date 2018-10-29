<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>

<%@ page import="com.google.appengine.api.users.User" %>

<%@ page import="com.google.appengine.api.users.UserService" %>

<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>

<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>

<%@ page import="com.google.appengine.api.datastore.Query" %>

<%@ page import="com.google.appengine.api.datastore.Entity" %>

<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>

<%@ page import="com.google.appengine.api.datastore.Key" %>

<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<html>


  <head>
  	<title>Dylan and Jack's Foreign Forum</title>
  	<link rel="stylesheet" href="style.css">
  </head>



  <body align="center">
  	<div id="title_tab" align="center">
  		<img src="logo.png" alt="globe" height=42px width=42px align="center">
		<h1>
			<a href="index.jsp" id="main_title">Dylan and Jack's Foreign Forum</a>
		</h1>
	</div>



<%

    String guestbookName = request.getParameter("guestbookName");

    if (guestbookName == null) {

        guestbookName = "default";

    }

    pageContext.setAttribute("guestbookName", guestbookName);

    UserService userService = UserServiceFactory.getUserService();

    User user = userService.getCurrentUser();

    if (user != null) {

      pageContext.setAttribute("user", user);

%>

<p>Hello, ${fn:escapeXml(user.nickname)}! (You can

<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">sign out</a>.)</p>

<%

    } else {

%>

<p>Hello!

<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>

to be able to post your own content.</p>

<%

    }

%>
<%
	if(user != null){
%>
	    <form action="/ofyblog" method="post">

		  <div><p>Title</p><textarea name="title" rows="1" cols="30"></textarea></div>
	      <div><p>Content</p><textarea name="content" rows="6" cols="60"></textarea></div>

	      <div><input type="submit" value="Post" class="button"/></div>

	      <input type="hidden" name="guestbookName" value="${fn:escapeXml(guestbookName)}"/>

	    </form>

	    <a href="createblogpost.jsp"><button class="button">Clear</button></a>
	    <a href="index.jsp"><button class="button">Cancel</button></a>

	<%
	}
	%>



  </body>

</html>
