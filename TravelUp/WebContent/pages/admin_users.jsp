<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="ex" uri="../WEB-INF/user.tld"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<div class="row">

	  <div class="col-xs-4">
	  	<form class="form-horizontal" action="search_user" method="GET" id="search-form" accept-charset="UTF-8">
	  	 <div class="form-group">
	  		<input type="text" class="form-control" placeholder="search" name="key"/>
	  		<div class="checkbox">
			    <label>
			      <input type="checkbox" name="transporters">transporter
			 	</label>
			 </div>
			 <div class="checkbox">
			    <label>
			      <input type="checkbox" name="photographers">photographer
			 	</label>
			 </div>
			 <div class="checkbox">
			    <label>
			      <input type="checkbox" name="guides">guide
			 	</label>
			 </div>
			 <button type="submit" class="btn btn-default">Search</button>
			</div>
	  	</form>
	  </div>


	  <div class="col-xs-6">
	  <c:forEach items="${users}" var="item">
		<ex:user user="${item}"/>
	  </c:forEach>
	  </div>
	</div>
	</div>
</body>
</html>