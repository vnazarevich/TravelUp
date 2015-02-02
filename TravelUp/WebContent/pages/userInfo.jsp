<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="ex" uri="../WEB-INF/user.tld"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
   <jsp:include page="/pages/styles.jsp" />
   <jsp:include page="/pages/scripts.jsp" />
  <script type="text/javascript" src="inc/js/jquery.object.js"></script>
<title>${customer.getFirstName()} ${customer.getLastName()}</title>
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
                      <h2>${customer.getFirstName()} ${customer.getLastName()}</h2>
                    </div>
                    <div class="col-xs-6">
                        <div class="breadcrumb-holder">
                            <ol class="breadcrumb">
                                <li><a href="search_user">Users</a></li>
                                <li class="active"><a href="">${customer.getLogin()}</a></li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>

 <section id="user-info" class="section wide-fat page">
 <div class="container">
	    <div class="sidebar col-md-3 col-sm-6 col-xs-12">
		    <div class="thumbnail">
				<c:choose>
				<c:when test="${customer.getPicture()==null}">
			      <img id="avatar-main" src="images/avatar_default.jpg" alt="..." class="img-rounded" >
			     </c:when>
			     <c:otherwise>
			     	<img id="avatar-main" src="${initParam['imagesPath']}${customer.getPicture()}" alt="Cannot load image" class="img-rounded" >
			     </c:otherwise>
			     </c:choose>
				<div class="caption">
				<h3>${customer.getFirstName()} ${customer.getLastName()}</h3>
				<h4><b>Login:</b> ${customer.getLogin()}</h4>
				<h4><b>Email:</b> ${customer.getMail()}</h4>
				<h5><b>Registration time:</b> ${customer.dateOfRegistration}</h5>
				</div>

				</div>

		    </div><!-- sidebar -->
	<div class="contents grid-contents col-lg-9 col-sm-6 col-xs-12"><!--page-->
				<c:set var="portfolio" scope="session" value="${customer.getPortfolio()}"/>
		<c:choose>
		<c:when test="${portfolio==null}">
			<h1>No portfolio</h1>
		</c:when>
		<c:otherwise>
		<h3>Occupation:</h3>
		<ul id="occupation-list" >
				<c:if test="${portfolio.isPhotographer()}">
					<li><h4><span class="glyphicon glyphicon-camera" aria-hidden="true"></span> photographrer</h4></li>
				</c:if>
				<c:if test="${portfolio.isGuide()}">
					<li><h4><span class="glyphicon glyphicon-flag" aria-hidden="true"></span> guide</h4></li>
				</c:if>
				<c:if test="${portfolio.isCarrier()}">
					<li><h4><span class="glyphicon glyphicon-road" aria-hidden="true"></span> transporter</h4></li>
				</c:if>
		</ul>
		<h3>About:</h3>
		<p>${portfolio.getDescription()}</p>
		<br>
		 <ul class="row user-gallery">
		 <c:forEach var="customerPhoto" items="${customerPhotos}">
          <li class="col-lg-4 col-md-4 col-sm-6 col-xs-9"><img src="${initParam['imagesPath']}${customerPhoto.getPhotolink()}"/></li>
			</c:forEach>
          </ul>


          <div class="modal fade autoModal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		      <div class="modal-dialog">
		        <div class="modal-content">
		          <div class="modal-body">
		          </div>
		        </div><!-- /.modal-content -->
		      </div><!-- /.modal-dialog -->
		    </div><!-- /.modal -->



		</c:otherwise>
		</c:choose>
		</div>
		</div><!--container-->
		</section>
		<!-- Footer -->
           <jsp:include page="/pages/footer.jsp" />
           </div>
<script>
$('ul.user-gallery li img').on('click',function(){
    var src = $(this).attr('src');
    var img = '<img src="' + src + '" class="img-responsive"/>';
    $('#myModal').modal();
    $('#myModal').on('shown.bs.modal', function(){
        $('#myModal .modal-body').html(img);
    });
    $('#myModal').on('hidden.bs.modal', function(){
        $('#myModal .modal-body').html('');
    });
});
</script>
</body>
</html>