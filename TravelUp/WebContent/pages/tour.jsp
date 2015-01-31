<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>	
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${lang.getString("tourpage.page.tourlist")}</title>

        <jsp:include page="/pages/styles.jsp" />
		
		 <style>
		      #map-canvas {
		        height: 300px;
		        width: 450px;
		        margin-left: auto;
		        margin-right: auto;
		 
		        padding: 0px
		      }
		    </style>
		    <script>
		    
			function initialize() {
			   var directionsService = new google.maps.DirectionsService();
			     var directionsDisplay = new google.maps.DirectionsRenderer();
		
			     var map = new google.maps.Map(document.getElementById('map-canvas'), {
			       zoom:7,
			       mapTypeId: google.maps.MapTypeId.ROADMAP
			     });
		
			     directionsDisplay.setMap(map);
			     
		
			     var request = {
			       origin: "${orig}", 
			       destination: "${dest}",
			       waypoints: [
			                   <c:forEach items="${placecoordinats}" var="item">
				    		    {
				    		      location:"${item}",
				    		      stopover:true
				    		    },
				    		    </c:forEach>
				    		    ],
			       travelMode: google.maps.DirectionsTravelMode.WALKING
			     };
		
			     directionsService.route(request, function(response, status) {
			       if (status == google.maps.DirectionsStatus.OK) {
			         directionsDisplay.setDirections(response);
			       }
			     });
		}
		
		function loadScript() {
		  var script = document.createElement('script');
		  script.type = 'text/javascript';
		  script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&' +
		      'callback=initialize';
		  document.body.appendChild(script);
		}
		
		window.onload = loadScript;

    </script>
    </head>
    <body>
<div id="preloader">
    <div id="status">&nbsp;</div>
    <noscript>JavaScript is off. Please enable to view full site.</noscript>
</div>

        <div id="site">

            <jsp:include page="/pages/header.jsp" />
            <jsp:include page="/pages/loginBox.jsp" />
            <jsp:include page="/pages/signupBox.jsp" />
			<jsp:include page="/pages/placeBox.jsp" />
			

            <section class="page-head-holder">
                <div class="container">
                    <div class="col-xs-6">
                      <h2>${lang.getString("tourpage.page.tourlist")}</h2>
                    </div>
                    <div class="col-xs-6">
                        <div class="breadcrumb-holder">
                            <ol class="breadcrumb">
                                <li><a href="index">${lang.getString("tourpage.page.home")}</a></li>
                                <li class="active"><a href="tours">${lang.getString("tourpage.page.tourlist")}</a></li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>

            <section id="hotels" class="section wide-fat page">
                <div class="container">                 
                    <div class="contents-wrapper">         
                        <div class="row">
							 <h2>${tour.name.getName(lang.getLocale().getLanguage())} (<b><i>${tour.status}</i></b>)</h2>
                            <div class="sidebar col-md-5  col-xs-12">

                                <div class="widget">
								
                                     <div id="map-canvas"></div>

                                </div><!-- /.widget -->

						
                            </div><!-- /.sidebar -->

                            <div class="contents grid-contents col-md-7 col-xs-12">

				

                                <div class="row">

                                    <div class="content  wide">

                                        <div class="inner">

                                                <div class="entry">

                                                    <article class="entry-content">
                                                    <c:forEach var="place" items="${tour.places}">
                                                        <a href="#" ><b>${place.info.getName(lang.getLocale().getLanguage())} - </b></a>
														</c:forEach>
                                                        

                                                    </article>

                                                </div><!-- /.entry -->
                                                <c:forEach var="place" items="${tour.places}">
                                        <c:forEach var="photo" items="${place.photos}">
                                      		<div class="col-md-5 col-lg-4 no-margin-left">
                                      			<a class="thumbnailz" href="#">
                                                    <img src=${photo.photolink} alt="Your Hotel Title Here" class="responsive-image" />
                                                </a>
                                                </div>
                                     	</c:forEach>
                                     	</c:forEach>
                                        </div>

                                    </div><!-- /.content -->

                                </div><!-- /.row -->

                            </div><!-- /.contents.grid-contents -->

                        </div><!-- /.row -->

                    </div><!-- /.contents-wrapper -->

                </div>


            </section><!-- /#hotels.section -->

            <jsp:include page="/pages/footer.jsp" />
           <!-- /#footer -->

        </div><!-- /#site -->


<!-- Scripts -->

	<jsp:include page="/pages/scripts.jsp" />

    </body>
</html>
