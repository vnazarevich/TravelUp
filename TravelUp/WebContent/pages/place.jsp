<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>	
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Плейс: ${place.type.getType(lang.getLocale().getLanguage())} ${place.info.getName(lang.getLocale().getLanguage())}</title>

        <jsp:include page="/pages/styles.jsp" />
		
		 <style>
			 .entry {
			 border: 1px solid #e0e5e9;
			 }  
		 </style>
		
		 <script>
		    var x;
		    var y;
		    function initialize() {
		    	  var myLatlng = new google.maps.LatLng(x,y);
		    	  var mapOptions = {
		    	    zoom: 12,
		    	    center: myLatlng
		    	  };

		    	  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

		    	  var contentString = '<div id="content">'+
		    	      '<div id="siteNotice">'+
		    	      '</div>'+
		    	      '<b>' + $("input[name='placename']").val() +'</b>'+
		    	      '<div id="bodyContent">'+
		    	      $("input[name='placedesc']").val() + '</div>' + '</div>';

		    	  var infowindow = new google.maps.InfoWindow({
		    	      content: contentString
		    	  });

		    	  var marker = new google.maps.Marker({
		    	      position: myLatlng,
		    	      map: map,
		    	      title: $("input[name='placename']").val()
		    	  });
		    	  google.maps.event.addListener(marker, 'click', function() {
		    	    infowindow.open(map,marker);
		    	  });
		    	}

		    function loadScript() {
				  x = parseFloat($("input[name='placexcoord']").val());
				  y = parseFloat($("input[name='placeycoord']").val());
				  var script = document.createElement('script');
				  script.type = 'text/javascript';
				  script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&' +
				      'callback=initialize';
				  document.body.appendChild(script);
				}
				
				window.onload = loadScript;


			    $(function(){	    	
			    	
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
			    });
			    
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
			
			<div class="modal fade autoModal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		      <div class="modal-dialog">
		        <div class="modal-content">
		          <div class="modal-body">
		          </div>
		        </div><!-- /.modal-content -->
		      </div><!-- /.modal-dialog -->
		    </div><!-- /.modal -->

            <section class="page-head-holder">
                <div class="container">
                    <div class="col-xs-6">
                      <h2>${place.type.getType(lang.getLocale().getLanguage())} ${place.info.getName(lang.getLocale().getLanguage())}</h2>
                    </div>
                    <div class="col-xs-6">
                        <div class="breadcrumb-holder">
                            <ol class="breadcrumb">
                                <li><a href="index">${lang.getString("tourpage.page.home")}</a></li>
                                <li><a href="#">Список плейсів</a></li>
                                <li class="active">${place.type.getType(lang.getLocale().getLanguage())} ${place.info.getName(lang.getLocale().getLanguage())}</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>

            <section class="section wide-fat page">
                <div class="container">                 
                    <div class="contents-wrapper">         
                        <div class="row">
							 
                            <div class="sidebar col-md-6  col-xs-12">
								
                                <div class="widget">
									
                                <div id="map-canvas"></div>

                            </div><!-- /.widget -->
								
							

                            </div><!-- /.sidebar -->

                            <div class="contents grid-contents col-md-6 col-xs-12">

							<form id="getdata-form" action="place" method="get">
							<input type="hidden" id="selectedplaceid" name="selectedplace" value="">
							</form>
							<input type="hidden" id="selectedplaceid" name="placexcoord" value="${place.xCoordinate}">
							<input type="hidden" id="selectedplaceid" name="placeycoord" value="${place.yCoordinate}">
							<input type="hidden" id="selectedplaceid" name="placename" value="${place.type.getType(lang.getLocale().getLanguage())} ${place.info.getName(lang.getLocale().getLanguage())}">
							<input type="hidden" id="selectedplaceid" name="placedesc" value="${place.info.getDescription(lang.getLocale().getLanguage())}">
							
                                <div class="row">

                                    <div class="content  wide">

                                        <div class="inner">

										       <div class="entry">
								<article class="entry-content">
								
								<h2>Опис:</h2>										
										<p><c:out value="${place.info.getDescription(lang.getLocale().getLanguage())}"></c:out></p>				
								</article>
							</div>

                                                <div class="entry">
                                                   
                                            <article class="entry-content">
                                            <h2>Фотографії:</h2>       
                                            </article>
                                            <ul class="row user-gallery">                                              
                                        		<c:forEach var="photo" items="${place.photos}">		
                                                		<li class="col-lg-4 col-md-4 col-sm-6 col-xs-6 container image-container"><img src=${photo.getPhotolink()} class="img-responsive"/></li>
		                                     	</c:forEach>		                                   	                                
		                                    </ul>

                                        </div><!-- /.entry -->
 
                                        </div>

                                    </div><!-- /.content -->
		
                         </div><!-- /.row -->


                            </div><!-- /.contents.grid-contents -->

                        </div><!-- /.row -->

                    </div><!-- /.contents-wrapper -->

                </div>

            </section><!-- /#hotels.section -->

            <jsp:include page="/pages/footer_black.jsp" />
           <!-- /#footer -->

        </div><!-- /#site -->


<!-- Scripts -->

	<jsp:include page="/pages/scripts.jsp" />

    </body>
</html>
