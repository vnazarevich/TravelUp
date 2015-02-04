<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>	
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Плейси</title>

        <jsp:include page="/pages/styles.jsp" />
		
	<style>
     #map-canvas {
       
        height: 600px;
        width: 100%;
        
        margin: auto;
        padding: 0px

      }
    </style>
		 
		
		 <script>
		 var array = ${placecoordinats};
		 var desc = ${description};
		    var markers = [];
		    
		    function createMarkers() {
		    	for (var i = 0; i < array.length; i+=2) {		
		    		var lat = parseFloat(array[i]);
		    		var lng = parseFloat(array[i+1]);
		    		markers[i] = new google.maps.LatLng(lat, lng);
		    	}
		    }
		    
		    function initialize() {
		    	
					var bounds = new google.maps.LatLngBounds();
					var infowindow = new google.maps.InfoWindow();    

		    	  var map = new google.maps.Map(document.getElementById('map-canvas')); //,mapOptions
							
		    	 createMarkers();
		    	 
		    		for (var i in markers) {
		    		  var marker = new google.maps.Marker({
		    		        position: markers[i],
		    		        map: map,
		    		       
		    		        title: 'test',
		    		    });
		    		  bounds.extend(marker.position);
  			    	console.log("out " + desc[i]);	    		
		    		  google.maps.event.addListener(marker, 'click', (function(marker, i) {
		    			    return function() {
		    			    	console.log("in " + desc[i]);
		    			      infowindow.setContent('<div id="content">'+ desc[i] + '</div>');
		    			      infowindow.open(map, marker);
		    			    }
		    			  })(marker, i));
		    		}
		    		map.fitBounds(bounds);
		    	}

		    function loadScript() {
		    //	console.log(desc);
		  
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
			
            <section class="page-head-holder">
                <div class="container">
                    <div class="col-xs-6">
                      <h2>${place.type.getType(lang.getLocale().getLanguage())} ${place.info.getName(lang.getLocale().getLanguage())}</h2>
                    </div>
                    <div class="col-xs-6">
                        <div class="breadcrumb-holder">
                            <ol class="breadcrumb">
                                <li><a href="index">${lang.getString("tourpage.page.home")}</a></li>  
                                <li class="active">Місця</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>
				
                                <div id="map-canvas"></div>				
            
            <jsp:include page="/pages/footer_black.jsp" />
           <!-- /#footer -->

        </div><!-- /#site -->


<!-- Scripts -->

	<jsp:include page="/pages/scripts.jsp" />

    </body>
</html>
