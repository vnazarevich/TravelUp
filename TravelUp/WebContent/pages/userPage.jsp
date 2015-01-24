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

<section id="users" class="section wide-fat page">
 <div class="container">
	    <div class="sidebar col-md-3  col-xs-12">

		    <div class="thumbnail">
		      <img src="http://static.comicvine.com/uploads/original/11111/111116692/3213841-7948839370-yoda..jpg" alt="..." class="img-rounded" >
		      <div class="caption">
		      <div class="row editable">
		      <div class="row-same-height">
		      <div class="col-md-9 col-md-height col-top">
		        <h3 class="target">Sergiy Dakhniy</h3>
		        </div>
		        <input type="text" class="changer form-control">
		        <div class="col-md-3 col-md-height col-middle">
		        	<button type="button" class="btn btn-default btn-edit" aria-label="Left Align">
				  <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				</button>
				</div>
				</div>
				</div>
				</div>
		        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
		      </div>
		    </div>


	    </div><!-- sidebar -->


	  <div class="contents grid-contents col-sm-9">



	</div>
	  </div>

	  </div><!--container-->
</section>
 			<!-- Footer -->
           <jsp:include page="/pages/footer.jsp" />
	</div> <!--site-->
<!-- Scripts -->
<script>
$(document).ready(function() {
	$(".changer").hide();
});
</script>
	<jsp:include page="/pages/scripts.jsp" />
</body>
</html>