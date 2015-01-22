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
<title>Users</title>
</head>
<body>
<div id="preloader">
    <div id="status">&nbsp;</div>
    <noscript>JavaScript is off. Please enable to view full site.</noscript>
</div>
<div id="site">
	 <jsp:include page="/pages/header.jsp" />

            <jsp:include page="/pages/loginBox.jsp" />

            <section class="page-head-holder">
                <div class="container">
                    <div class="col-xs-6">
                      <h2>Users</h2>
                    </div>
                    <div class="col-xs-6">
                        <div class="breadcrumb-holder">
                            <ol class="breadcrumb">
                                <li><a href="index">Home</a></li>
                                <li class="active"><a href="">Users</a></li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>

<section id="users" class="section wide-fat page">
 <div class="container">
	    <div class="sidebar col-md-3  col-xs-12">
	  	<form class="form-horizontal" action="search_user" method="GET" id="search-form" accept-charset="UTF-8">
	  	 <div class="form-group">

	  		<div class="widget hotel-type-filter-widget">
	  		<div class="destination-field">
	  			<input type="text" class="form-control" placeholder="search" name="key"/>
	  		</div>
			<ul>

			     <li> <input type="checkbox" name="transporters" ><label>transporter</label></li>


			     <li> <input type="checkbox" name="photographers" ><label>photographer</label></li>

			      <li><input type="checkbox" name="guides" ><label>guide</label></li>

			 </ul>
			 <div class="search-field">
				 <button type="submit" class="button wide-fat">Search</button>
			</div>

			</div>
			</div>
	  	</form>
	    </div><!-- sidebar -->


	  <div class="contents grid-contents col-sm-9">


	  <c:forEach items="${users}" var="item">
		<ex:user user="${item}"/>
	  </c:forEach>
	  </div>
	  </div>
</section><!--container-->
	</div> <!--site-->
<!-- Scripts -->
<script>
$(function(){
	$("input[name='key']").val("${param.key}");
	var guides = "${param.guides}";
	if(guides=="on"){
		$("input[name='guides']").attr("checked","true");
	}
	var transporters = "${param.transporters}";
	if(transporters=="on"){
		$("input[name='transporters']").attr("checked","true");
	}

	var photographers = "${param.photographers}";
	if(photographers=="on"){
		$("input[name='photographers']").attr("checked","true");
	}

	$(".ban").click(function(e){
		var userId=$(this).attr("user-id");
		console.log(userId);
	  	$.post('updateuser',{userId:userId,action:"ban"} ,function(responseText) {
	  		location.reload();
		});
	});

	$(".unban").click(function(e){
		var userId=$(this).attr("user-id");
		console.log(userId);
	  	$.post('updateuser',{userId:userId, action:"unban"} ,function() {
	  		location.reload();
		});
	});

	$(".admin").click(function(e){
		var userId=$(this).attr("user-id");
		console.log(userId);
	  	$.post('updateuser',{userId:userId, action:"admin"} ,function() {
	  		location.reload();
		});
	});

});
</script>
	<jsp:include page="/pages/scripts.jsp" />
</body>
</html>