<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>	
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Тур: ${tour.name.getName(lang.getLocale().getLanguage())}</title>

        <jsp:include page="/pages/styles.jsp" />
		
		 <style>
		 
			 .image-container .img-responsive {      
	           height: 100px;
	 		   width: 160px;
	        }
			 
			 .entry {
			 border: 1px solid #e0e5e9;
			 }  
		 </style>
		    <script>
		    
		    $(function(){
		 
		    	$('#comment-button').click(function(e){
		    		    		e.preventDefault(); 
		    			    	if($("input[name='comment']").val() != ""){
		    			    		var d = new Date();
		    				    		
		    			    		var text = $("input[name='comment']").val();
		    			    		$("input[name='date']").val(d.toLocaleString());

		    			    		$.ajax({type: "POST",url: "addcomment", data: { comment: $("input[name='comment']").val(), tourId: $("input[name='tourId']").val(), date: d.toLocaleString()},success:function(result){ }});
		    			    				    		
		    			    		var text = $("input[name='comment']").val();
		    			       		$(".actionBox ul").prepend('<li><div class="commenterImage"><c:choose><c:when test="${sessionScope.user.picture=='null'}"><img src="images/avatar_default.jpg"/></c:when><c:otherwise><img src="${initParam["imagesPath"]}${sessionScope.user.getPicture()}" /></c:otherwise></c:choose><div class="userNameComment">${sessionScope.user.firstName}</div></div><div class="commentText"><p class="">' + text +'</p><span class="date sub-text">' + d.toLocaleString() + '</span></div></li>');		    		
		    			       		$("input[name='comment']").val("");
		    			    	}
		    			    });
		    				    	
		    	$('.select-place form').click(function(){
					var id = $(this).find('.selectplace').val();

					$("input[name='selectedplace']").val(id);
					$('#getdata-form').submit();
					console.log('_a_' + id);
				})
		    	
		    	
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
                      <h2>${tour.name.getName(lang.getLocale().getLanguage())} (<b><i>${tour.status}</i></b>)</h2>
                    </div>
                    <div class="col-xs-6">
                        <div class="breadcrumb-holder">
                            <ol class="breadcrumb">
                                <li><a href="index">${lang.getString("tourpage.page.home")}</a></li>
                                <li><a href="tours">${lang.getString("tourpage.page.tourlist")}</a></li>
                                <li class="active">${tour.name.getName(lang.getLocale().getLanguage())}</li>
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
								
							<div class="entry">
								<article class="entry-content">
								
								<h2>Опис:</h2>							
								
									<c:forEach var="place" items="${tour.places}"> 
										<p><c:out value="${place.info.getDescription(lang.getLocale().getLanguage())}"></c:out></p>
									</c:forEach>
									<div class="in-same-line">
										<br/><h2>Фотограф: </h2> ${tour.photographRequired}
										<p></p><h2>Гайд: </h2> - 
										<p></p><h2>Спосіб добирання до старту: </h2> ${tour.transport}
										<p></p><h2>Набір: </h2>${tour.minCapacity} ${lang.getString("tourpage.list.people")}
										<p></p><h2>Вік: </h2>${tour.minAge} - ${tour.maxAge} років 
										<p></p><h2>Тривалість: </h2>${tour.minDuration} ${lang.getString("tourpage.list.days")}
										<p></p><h2>Дата: </h2>${tour.startDate} - ${tour.endDate}
										<p></p><h2>Ціна: </h2>${tour.minPrice} ${lang.getString("tourpage.list.money")}
									</div>
								</article>
							</div>

						
                            </div><!-- /.sidebar -->

                            <div class="contents grid-contents col-md-6 col-xs-12">

							<form id="getdata-form" action="place" method="get">
							<input type="hidden" id="selectedplaceid" name="selectedplace" value="">
							</form>

                                <div class="row">

                                    <div class="content  wide">

                                        <div class="inner">

                                                <div class="entry">
                                                    <article class="entry-content select-place">
                                                    <h2>Шлях:</h2>
                                                    &rarr;
                                                    <c:forEach var="place" items="${tour.places}">
                                                        <form style="display: inline-block;">
                                                        <a ><b>${place.type.getType(lang.getLocale().getLanguage())} ${place.info.getName(lang.getLocale().getLanguage())}</b></a> &rarr;
														<input type="hidden" class="selectplace" value="${place.id}">
														</form>
														</c:forEach>
                                                    </article>
                                            <article class="entry-content">
                                            <h2>Фотографії:</h2>       
                                            </article>
                                            <ul class="row user-gallery">
                                             <c:forEach var="place" items="${tour.places}"> 
                                        		<c:forEach var="photo" items="${place.photos}">		
                                                		<li class="col-lg-3 col-md-4 col-sm-6 col-xs-6 container image-container"><img src=${photo.getPhotolink()} class="img-responsive"/></li>
		                                     	</c:forEach>		                                   	
		                                     </c:forEach>
		                                    </ul>

                                        </div><!-- /.entry -->
                                            
                                        </div>

                                    </div><!-- /.content -->

                               

								<div class="detailBox">
					   				 <div class="titleBox">
								      <label>Коментарі</label>
								    </div>
								    <div class="actionBox">
								    	<c:choose>
								     <c:when test="${sessionScope.user==null}">
								     </c:when>
								     <c:otherwise>
								     	<form class="form-inline" id="comment-form" role="form" action="addcomment" method="post">
								            <div class="form-group">
								                <input name="comment" class="form-control" type="text" placeholder="Додайте коментар" />
								                <input name="tourId" value="${tour.id}" type="hidden">
								                <input name="date" type="hidden" value="">
								            </div>
								            <div class="form-group">
								              <button class="btn btn-default" id="comment-button" >Додати</button>
								            </div>
								        </form>
								     </c:otherwise>
								     </c:choose>
								    	<br>
								        <ul class="commentList">
								           <c:forEach var="comment" items="${comments}">
								            <li>
								                <div class="commenterImage">
								                <c:choose>
								                	<c:when test="${comment.userId.picture == 'null'}">
								                	  <img src="images/avatar_default.jpg" />
								                	</c:when>
								                	<c:otherwise>
								                		<img src="${initParam['imagesPath']}${comment.userId.getPicture()}" />
								                	</c:otherwise>
								                </c:choose>
								                <div class="userNameComment">
								                ${comment.userId.firstName}
							                </div>
								                </div>
								                <div class="commentText">
								                    <p class="">${comment.text}</p> <span class="date sub-text">${comment.date}</span>
								
								                </div>
								            </li>
								            </c:forEach>
								        </ul>								       
							    </div>
								</div>
		
                         </div><!-- /.row -->


                            </div><!-- /.contents.grid-contents -->

                        </div><!-- /.row -->

                    </div><!-- /.contents-wrapper -->

                </div>

               <div class="center-button">
						<c:set var="test1" value="${lang.getString('tourpage.list.close')}"/>
                         <c:set var="test2" value="${tour.status}"/>
                         <c:choose>
           					<c:when test="${test1 != test2}">
                         		<a id="addToCartBtn" class="addToCartBtn button btn-block"><span class="glyphicon glyphicon-ok"></span> ${lang.getString("tourpage.list.cart")}</a>
                       		</c:when>
                       	</c:choose>
					</div>

            </section><!-- /#hotels.section -->

            <jsp:include page="/pages/footer_black.jsp" />
           <!-- /#footer -->

        </div><!-- /#site -->


<!-- Scripts -->

	<jsp:include page="/pages/scripts.jsp" />

    </body>
</html>
