 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header id="header" class="wide-fat">

                <div class="container">

                    <div class="col-xs-12 col-sm-4 col-md-3 col-lg-2 no-margin">
                    <div class="branding">

                        <h1 class="site-title">

                            <a href="index"><img src="images/site-logo.png" alt="TravelUp" /> <span style="font-weight: 700;">Travel<span class="higlight">Up</span></span></a>

                        </h1>

                    </div>
                    </div>
                    <div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 no-margin">

                    <div align="center">
					<ul class="nav nav-pills green" style="display: inline-block;">
					<c:choose>
						 <c:when test="${sessionScope.lang.getLocale().getLanguage().equals('ua')}">
						    <li class="active"><a href="language?locale=ua" >Ua</a></li>
					    	<li><a href="language?locale=en" >En</a></li>
						 </c:when>

						 <c:otherwise>
						     <li ><a href="language?locale=ua" >Ua</a></li>
					    	<li class="active"><a href="language?locale=en" >En</a></li>
						 </c:otherwise>
					</c:choose>
					</ul>
					</div>

                    </div>
                    <div class="col-xs-12 col-sm-5 col-md-5 col-lg-5 no-margin">
					<c:if test="${user.isAdmin()==true}">
                     <div id="main-menu">

                        <nav class="navigation">
                            <ul class="hidden-xs hidden-sm hidden-md">

                                <li class="menu-item customers">
                                    <a href="search_user"><i class="fa fa-users"></i> ${lang.getString('hormenu.users')}</a>
                                </li>


                                <li class="menu-item active-tours">
                                    <a href="createtour"><i class="icon_map"></i> ${lang.getString('hormenu.addtour')}</a>
                                </li>

                                <li class="menu-item active-tours">
                                    <a href="addplace"><i class="fa fa-location-arrow"></i> ${lang.getString('hormenu.addplace')}</a>
                                </li>


                            </ul>

                            <select class="top-drop-menu nav visible-sm visible-xs visible-md">
                                 <optgroup label="Admin Panel">

                                    <option value="search_user">
                                        ${lang.getString('hormenu.users')}
                                    </option>

                                    <option value="createtour">
                                        ${lang.getString('hormenu.addtour')}
                                    </option>

                                     <option value="createtour">
                                        ${lang.getString('hormenu.addplace')}
                                    </option>

                              </optgroup>


                          </select>
                      </nav>

                    </div>
					</c:if>

                    </div>
                     <div class="col-xs-12 col-sm-12 col-md-2 col-lg-3 no-margin">

					 <c:if test="${sessionScope.user!=null}">

					<div align="center" class="hidden-xs hidden-sm " style="margin-top:25px;">
					<a href="userpage">
					<c:choose>
						<c:when test="${user.getPicture()=='null'}">
					      <img
	     					 src="images/avatar_default.jpg"
	   					     alt="image" class="img-thumbnail" style="width: 40px; height: 40px;"/>
					     </c:when>
					     <c:otherwise>
					     	<img
	     					 src="${initParam['imagesPath']}${user.getPicture()}"
	   					     alt="image" class="img-thumbnail" style="width: 40px; height: 40px;"/>
					     </c:otherwise>
			    	 </c:choose>
			    	 </a>
					</div>
					<p align="center"><a href="userpage">${lang.getString('login.hello')} ${sessionScope.user.getFirstName()}!</a></p>
					</c:if>
					</div>

                </div>

                <div class="toggle-menu-holder">

                    <a class="toggle-menu" href="#"></a>
                    <div class="menu-body closed">
                        <ul>
                        	<c:choose>
						      <c:when test="${sessionScope.user==null}">
						      	<li><a data-toggle="modal" data-target="#loginBox" href="#"><i class="fa fa-lock"></i> ${lang.getString('menu.login')}</a></li>
						      </c:when>

						      <c:otherwise>
						      	<li><a href="logout"><i class="fa fa-lock"></i> ${lang.getString('menu.logout')}</a></li>
						      </c:otherwise>
							</c:choose>
                            <li><a data-toggle="modal" data-target="#signupBox" href="#"><i class="fa fa-user"></i> ${lang.getString('menu.register')}</a></li>
                            <li><a href="tours"><i class="fa fa-bus"></i> ${lang.getString('menu.tours')}</a></li>
                            <li><a href="request"><i class="fa fa-location-arrow"></i> ${lang.getString('menu.sendrequest')}</a></li>
                            <li><a href="places"><i class="fa fa-map-marker"></i> ${lang.getString('menu.places')}</a></li>
                            <li><a href="gallery"><i class="fa fa-picture-o"></i> ${lang.getString('menu.gallery')}</a></li>

                          <li><a href="about"><i class="fa fa-line-chart"></i> ${lang.getString('menu.about')}</a></li>
                          <c:if test="${sessionScope.user!=null}">
	                          <li><a href="userpage"><i class="fa fa-home"></i> ${lang.getString('menu.userpage')}</a></li>

                          </c:if>
                        </ul>

                    </div>



                </div>


            </header>

		  <jsp:include page="/pages/loginBox.jsp" />
          <jsp:include page="/pages/signupBox.jsp" />
          <jsp:include page="/pages/statusBox.jsp" />
