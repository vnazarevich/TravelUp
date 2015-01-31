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
	<script type="text/javascript">
		// click handler
		$(function(){
			var list1, list2;
			function onClick(event) {

				$('#search-form').submit(function(e){
					var basicSliderBounds = $("#sliderz").rangeSlider("values");
					$("input[name='minprice']").val(basicSliderBounds.min);
					$("input[name='maxprice']").val(basicSliderBounds.max);
					$("input[name='durbox']").val(list1);
					$("input[name='daybox']").val(list2);
					$("input[name='check1']").val($('#check1').is(':checked'));
					$("input[name='check2']").val($('#check2').is(':checked'));
				});

				console.log($("input[name='key']").val());
				console.log($("input[name='start-date']").val());
				console.log($("input[name='end-date']").val());
				var basicSliderBounds = $("#sliderz").rangeSlider("values");
				console.log(basicSliderBounds.min + " " + basicSliderBounds.max);
				console.log(list1);
				console.log(list2);
				console.log($('#check1').is(':checked'));
				console.log($('#check2').is(':checked'));
			}

			$('#durlist a').click(function(e){
				list1 = $(this).html();
				$('#durbutton').html($(this).html() + '<span class="caret"></span>');
			})

			$('#daylist a').click(function(e){
				list2 = $(this).html();
				$('#daybutton').html($(this).html() + '<span class="caret"></span>');
			})

			$('.select-tour form').click(function(){
				var id = $(this).find('.selecttour').val();

				$("input[name='selectedtour']").val(id);
				$('#getdata-form').submit();
				console.log('_a_' + id);
			})

		// attach button click listener on dom ready
			$(function() {
			  $('#but').click(onClick);
			});

			$(".addToCartBtn").click(function(e){
				var response = "";
				$.ajaxSetup({async: false});
			 	$.post('userpage',{} ,function(responseText) {
			 		console.log("responseText " + responseText);
			  		response = responseText;
				});
				if(response=="0"){
					$('#loginModal').modal();
				} else {
					console.log("success");
				}
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

<div class="modal fade autoModal" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
						      <div class="modal-dialog">
						        <div class="modal-content">
						          <div class="modal-body">
						           <div class="row">
					    			<div class="span12" style="text-align: center;">
							          <h4>Log in first</h4>
						          	</div>
						          </div>
						          </div>
						        </div><!-- /.modal-content -->
						      </div><!-- /.modal-dialog -->
						    </div><!-- /.modal -->
						    
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
                    <div class="hotels-filter"> </div><!-- /.hotels-filter -->
                    <div class="contents-wrapper">
                        <div class="row">
                            <div class="sidebar col-md-3  col-xs-12">


                                <div class="widget">


                                    <h3 class="widget-title">${lang.getString("tourpage.page.search")}</h3>

                                    <div class="location-search-widget">
										<form action="search_tour" class="location-search"  method="get"  id="search-form" accept-charset="UTF-8">


                                            <div class="search-field">
                                                <div class="destination-field">
                                                    <input id="destination" type="text" placeholder="search" name="key" />
                                                </div>
                                            </div><!-- /.search-field -->

                                            <div class="search-field">

                                                <div class="col-field-left">
                                                    <label for="check-in-date2">${lang.getString("tourpage.filters.in-date")}</label>
                                                    <br />
                                                    <input id="check-in-date2" class="traveline_date_input" type="text" name="start-date" value="${lang.getString('tourpage.filters.date.value')}" />
                                                </div>

                                                <div class="col-field-right">
                                                    <label for="check-out-date2">${lang.getString("tourpage.filters.out-date")}</label>
                                                    <br />
                                                    <input id="check-out-date2" class="traveline_date_input" type="text" name="end-date" value="${lang.getString('tourpage.filters.date.value')}" />
                                                </div>

                                            </div><!-- /.search-field -->
                                            <!-- /.search-field -->

                                            <div class="search-field">

                                                <input type="submit" class="button wide-fat" value="Search" name="button" id="but" />

                                            </div><!-- /.search-field -->

										<INPUT TYPE="HIDDEN" NAME="minprice" VaLUE="">
										<INPUT TYPE="HIDDEN" NAME="maxprice" VaLUE="">
										<INPUT TYPE="HIDDEN" NAME="durbox" VaLUE="">
										<INPUT TYPE="HIDDEN" NAME="daybox" VaLUE="">
										<INPUT TYPE="HIDDEN" NAME="check1" VaLUE="">
										<INPUT TYPE="HIDDEN" NAME="check2" VaLUE="">

                                      </form>

                                    </div>


                                </div><!-- /.widget -->
                                <!-- /.widget -->


                                <div class="widget">

                                    <h3 class="widget-title">${lang.getString("tourpage.page.search.filters")}</h3>

                                    <div class="price-range-slider">

                                        <div id="sliderz"></div>

                                    </div><!-- /.price-range-slider -->
                                </div><!-- /.widget -->

                                <div class="widget hotel-type-filter-widget">
                                    <h3 class="widget-title">${lang.getString("tourpage.filters.duration")}</h3>

                                    <div class="btn-group btn-input clearfix">
									  <button type="button" id="durbutton" class="btn btn-default dropdown-toggle form-control" data-toggle="dropdown">
									    <span data-bind="label">${lang.getString("tourpage.page.search.choose")}</span> <span class="caret"></span>
									  </button>
									  <ul class="dropdown-menu" id="durlist" role="menu">
									 		  <li><a>1</a></li>
											 <li><a>2</a></li>
											 <li><a>3</a></li>
											 <li><a>4 - 6</a></li>
											 <li><a>7 - 10</a></li>
											 <li><a>11 - 14</a></li>
									  </ul>
									</div>

                                </div><!-- /.widget -->

                                <div class="widget hotel-type-filter-widget">

                                    <h3 class="widget-title">${lang.getString("tourpage.filters.tourdays")}</h3>

									<div class="btn-group btn-input clearfix">
									  <button type="button" id="daybutton" class="btn btn-default dropdown-toggle form-control" data-toggle="dropdown">
									    <span data-bind="label">${lang.getString("tourpage.page.search.choose")}</span> <span class="caret"></span>
									  </button>
									  <ul class="dropdown-menu" id="daylist" role="menu">
									 		  <li><a>${lang.getString("tourpage.filters.tourdays.weekdays")}</a></li>
											 <li><a>${lang.getString("tourpage.filters.tourdays.weekend")}</a></li>
											 <li><a>${lang.getString("tourpage.filters.tourdays.no-matter")}</a></li>
									  </ul>
									</div>

                                </div><!-- /.widget -->

                                <div class="widget hotel-type-filter-widget">
                                    <h3 class="widget-title">${lang.getString("tourpage.filters.region")}</h3>
                                    <form >
                                        <ul>
                                            <li><input id="check1" type="checkbox" /><label>Карпати</label></li>
                                            <li><input id="check2" type="checkbox" /><label>Крим наш</label></li>
                                        </ul>
                                    </form>

                                </div><!-- /.widget -->


                            </div><!-- /.sidebar -->

                            <div class="contents grid-contents col-md-9 col-xs-12">

						<form id="getdata-form" action="tour" method="get">
						<input type="hidden" id="selectedtourid" name="selectedtour" value="">
						</form>

				<c:forEach var="tour" items="${tourList}">

                                <div class="row">

                                    <div class="content  wide">

                                        <div class="inner">
                                            <div class="col-md-5 col-lg-4 no-margin-left">
                                                <a class="thumbnailz" href="#">
                                                    <img src=${tour.places[0].photos[0].photolink} alt="Your Hotel Title Here" class="responsive-image" />
                                                    <span class="overlay">Details</span>
                                                </a>
                                            </div>
                                            <div class=" col-md-5 middle-column col-lg-5 no-margin">

                                                <div class="entry">

                                                    <article class="entry-content select-tour">
                                                    <form>
                                                        <h2 class="post-title"><a href="#" title="Your Tour Title Here">${tour.name.getName(lang.getLocale().getLanguage())} (<b><i>${tour.status}</i></b>)</a></h2>
														<input type="hidden" class="selecttour" value="${tour.id}">
													</form>
														<c:if test="${user.isAdmin()}">
															<button type="button" class="btn btn-default" aria-label="Left Align" >
															  <span class="glyphicon glyphicon-edit" aria-hidden="true"> ${lang.getString("tourpage.page.edit")}</span>
															</button>
                                                        </c:if>
                                                        <p>${lang.getString("tourpage.list.duration")}: ${tour.minDuration} ${lang.getString("tourpage.list.days")}.</p>

                                                        <b>${lang.getString("tourpage.list.date")}:</b>

                                                        <p>${tour.startDate} - ${tour.endDate}</p>

                                                    </article>

                                                    <div class="entry-meta"> <span class="review"><a href="#">${lang.getString("tourpage.list.comments")}</a></span>
                                                        <span class="go-detail"><a href="#">${lang.getString("tourpage.list.more")}</a></span>
                                                    </div>

                                                </div><!-- /.entry -->
                                            </div>

                                             <div class="col-md-2 right-column col-lg-3 no-margin">
                                                 <div class="right-area">
						<div class="book-holder">
                         <span class="price">/ ${tour.minCapacity} ${lang.getString("tourpage.list.people")}</span>
                         <span class="price"><span class="higlight emphasize value">${tour.minPrice} ${lang.getString("tourpage.list.money")}</span></span>
                         <a data-toggle="modal" data-target="#placeBox" value="${tour.id}" class="button mini btn-block path-button">${lang.getString("tourpage.list.path")}</a>

                         <c:set var="test1" value="${lang.getString('tourpage.list.close')}"/>
                         <c:set var="test2" value="${tour.status}"/>
                         <c:choose>
           					<c:when test="${test1 != test2}">
                         		<a id="addToCartBtn" class="addToCartBtn button mini btn-block">${lang.getString("tourpage.list.cart")}</a>
                       		</c:when>
                       	</c:choose>
                       </div>
                                                 </div>
                                             </div>
                                        </div>

                                    </div><!-- /.content -->

                                </div><!-- /.row -->


             </c:forEach>

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
