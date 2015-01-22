<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Tour list</title>

        <jsp:include page="/pages/styles.jsp" />

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
                      <h2>Tour list</h2>
                    </div>
                    <div class="col-xs-6">
                        <div class="breadcrumb-holder">
                            <ol class="breadcrumb">
                                <li><a href="#">Home</a></li>
                                <li class="active"><a href="#">Tour list</a></li>
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

                                    <h3 class="widget-title">Tour Search</h3>

                                    <div class="location-search-widget">

                                        <form class="location-search"  method="get">

                                            <div class="search-field">
                                                <div class="destination-field">
                                                    <input id="destination" type="text" />
                                                </div>
                                            </div><!-- /.search-field -->

                                            <div class="search-field">

                                                <div class="col-field-left">
                                                    <label for="check-in-date2">Check in date</label>
                                                    <br />
                                                    <input id="check-in-date2" class="traveline_date_input" type="text" value="d MM yy" />
                                                </div>

                                                <div class="col-field-right">
                                                    <label for="check-out-date2">Check out date</label>
                                                    <br />
                                                    <input id="check-out-date2" class="traveline_date_input" type="text" value="d MM yy" />
                                                </div>

                                            </div><!-- /.search-field -->
                                            <!-- /.search-field -->

                                            <div class="search-field">

                                                <input type="submit" class="button wide-fat" value="Search" />

                                            </div><!-- /.search-field -->

                                        </form><!-- /form.location-search -->

                                    </div>

                                </div><!-- /.widget -->
                                <!-- /.widget -->


                                <div class="widget">

                                    <h3 class="widget-title">Price Filter</h3>

                                    <div class="price-range-slider">

                                        <div id="sliderz"></div>

                                    </div><!-- /.price-range-slider -->
                                </div><!-- /.widget -->

                                <div class="widget hotel-type-filter-widget">
                                    <h3 class="widget-title">Type</h3>
                                    <form >
                                        <ul>
                                            <li><input type="checkbox" /><label >All</label></li>
                                            <li><input type="checkbox" /><label >Hotel</label></li>
                                            <li><input type="checkbox" /><label >Resort</label></li>
                                            <li><input type="checkbox" /><label >Bed and Breakfast</label></li>
                                            <li><input type="checkbox" /><label >Appartment</label></li>
                                            <li><input type="checkbox" /><label >Motel</label></li>
                                        </ul>
                                    </form>

                                </div><!-- /.widget -->

						<div class="widget hotel-type-filter-widget">

                                    <h3 class="widget-title">Tour Amenities</h3>

                                    <form >
                                        <ul>
                                            <li><input type="checkbox" /><label >Free Parking (16)</label></li>
                                            <li><input type="checkbox" /><label >Pets Accepted (12)</label></li>
                                            <li><input type="checkbox" /><label >Free Pool (25)</label></li>
                                            <li><input type="checkbox" /><label >Free Breakfast (12)</label></li>
                                            <li><input type="checkbox" /><label >Massage Services (01)</label></li>
                                            <li><input type="checkbox" /><label >Public Bathroom (12)</label></li>
                                            <li><input type="checkbox" /><label >Pay Later (03)</label></li>
                                            <li><input type="checkbox" /><label >Double Bedrooms (13)</label></li>
                                            <li><input type="checkbox" /><label >The Room Gym (14)</label></li>
                                            <li><input type="checkbox" /><label >The Dining Room (12)</label></li>

                                        </ul>
                                    </form>

                                </div><!-- /.widget -->
                            </div><!-- /.sidebar -->

                            <div class="contents grid-contents col-md-9 col-xs-12">

				<c:forEach var="tour" items="${tourList}">

                                <div class="row">

                                    <div class="content  wide">

                                        <div class="inner">
                                            <div class="col-md-5 col-lg-4 no-margin-left">
                                                <a class="thumbnailz" href="#">
                                                    <img src="images/content/post-thumb-1.png" alt="Your Hotel Title Here" class="responsive-image" />
                                                    <span class="overlay">Details</span>
                                                </a>
                                            </div>
                                            <div class=" col-md-5 middle-column col-lg-5 no-margin">

                                                <div class="entry">

                                                    <article class="entry-content">
                                                        <h2 class="post-title"><a href="#" title="Your Hotel Title Here">${tour.name.getName(lang.getLocale().getLanguage())}</a></h2>

                                                        <p>Тривалість подорожі: ${tour.minDuration} днів.</p>

                                                        <b>Дата:</b>
                                                        <p>${tour.startDate} - ${tour.endDate}</p>

                                                    </article>

                                                    <div class="entry-meta"> <span class="review"><a href="#">Коментарі</a></span>
                                                        <span class="go-detail"><a href="#">More</a></span>
                                                    </div>

                                                </div><!-- /.entry -->
                                            </div>

                                             <div class="col-md-2 right-column col-lg-3 no-margin">
                                                 <div class="right-area">
<div class="book-holder">
                         <span class="price">${tour.minCapacity} смертних</span>
                        <span class="price"><span class="higlight emphasize value">${tour.minPrice} грн</span></span>
                         <a href="#" class="button mini">маршрут</a>
                         <p>
                         <a href="#" class="button mini">в кошик</a>
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