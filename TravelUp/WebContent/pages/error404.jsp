<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="ex" uri="../WEB-INF/user.tld"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
   <jsp:include page="/pages/styles.jsp" />
  <script type="text/javascript" src="inc/js/jquery.object.js"></script>
<title>Users</title>
</head>
<body>
<div id="preloader">
    <div id="status">&nbsp;</div>
    <noscript>JavaScript is off. Please enable to view full site.</noscript>
</div>
<div id="site">
	 <jsp:include page="/pages/header.jsp" />
<div class="container">
	<img src="images/error404.jpg" class="center-block"/>
</div>

 			<!-- Footer -->
           <jsp:include page="/pages/footer.jsp" />
	</div> <!--site-->
<!-- Scripts -->

	<jsp:include page="/pages/scripts.jsp" />
</body>
</html>