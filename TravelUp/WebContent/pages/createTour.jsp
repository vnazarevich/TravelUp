<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="../WEB-INF/user.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/pages/styles.jsp" />
<jsp:include page="/pages/scripts.jsp" />
<script type="text/javascript" src="inc/js/jquery.object.js"></script>
<title>Users</title>
</head>
<body>
	<div id="preloader">
		<div id="status">&nbsp;</div>
		<noscript>JavaScript is off. Please enable to view full
			site.</noscript>
	</div>
	<div id="site">
		<jsp:include page="/pages/header.jsp" />
		<jsp:include page="/pages/loginBox.jsp" />
		<section class="page-head-holder">
		<div class="container">
			<div class="col-xs-6">
				<h2>My page</h2>
			</div>
			<div class="col-xs-6">
				<div class="breadcrumb-holder">
					<ol class="breadcrumb">
						<li><a href="index">Home</a></li>
						<li class="active"><a href="">MyPage</a></li>
					</ol>
				</div>
			</div>
		</div>
		</section>
		<section id="user-info" class="section wide-fat page">
		<div class="container">

		</div>
		</section>