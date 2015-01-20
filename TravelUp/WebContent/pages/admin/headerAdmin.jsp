 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="header" class="wide-fat">

                <div class="container">

                    <div class="col-xs-12 col-sm-2 no-margin">
                    <div class="branding">

                        <h1 class="site-title">

                            <a href="#"><img src="images/site-logo.png" alt="TravelUp" /> <span>Travel<span class="higlight">Up</span></span></a>

                        </h1>

                    </div>
                    </div>
                    <div class="col-xs-12 col-sm-8 no-margin"> <!-- /#main-menu -->
                    
                    <div id="main-menu">

                        <nav class="navigation">
                            <ul class="hidden-xs hidden-sm hidden-md">
                                
                                <li class="menu-item customers">
                                    <a href="#"><i class="icon_pin"></i> Customers</a>
                                </li>
                                
                                <li class="menu-item suppliers">
                                    <a href="#"><i class="icon_ribbon"></i> Suppliers</a>
                                </li>
                                
                                
                                <li class="menu-item active-tours">
                                    <a href="#"><i class="icon_contacts"></i> Active tours</a>
                                </li>
                                <li class="menu-item proposals"> 
                                <a href="#"><i class="icon_contacts"></i> Proposals</a> </li>

                            </ul>

                            <select class="top-drop-menu nav visible-sm visible-xs visible-md">
                                 <optgroup label="Admin Panel">

                                    <option value="#">
                                        Customers
                                    </option>
                                    <option value="#">
                                        Suppliers
                                    </option>
                                    <option value="#">
                                        Active tours
                                    </option>
                                    <option value="#">
                                        Proposals
                                    </option>

                              </optgroup>
                                

                          </select>
                      </nav>

                    </div><!-- /#main-menu -->
                    
                    </div>
                    <div class="col-xs-12 col-sm-1 no-margin">
                    <c:if test="${sessionScope.user!=null}">
					   <p align="center">${lang.getString('login.hello')} ${sessionScope.user.getFirstName()}!</p>
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
                            <li><a href="#"><i class="fa fa-bus"></i> ${lang.getString('menu.tours')}</a></li>
                            <li><a href="#"><i class="fa fa-location-arrow"></i> ${lang.getString('menu.sendrequest')}</a></li>
                            <li><a href="#"><i class="fa fa-map-marker"></i> ${lang.getString('menu.places')}</a></li>
                            <li><a href="#"><i class="fa fa-picture-o"></i> ${lang.getString('menu.gallery')}</a></li>
                          <li><a href="#"><i class="fa fa-youtube-play"></i> ${lang.getString('menu.video')}</a></li>
                          <li><a href="#"><i class="fa fa-users"></i> ${lang.getString('menu.about')}</a></li>
                          <c:if test="${sessionScope.user!=null}">
	                          <li><a href="#"><i class="fa fa-home"></i> ${lang.getString('menu.userpage')}</a></li>
	                          <li><a href="#"><i class="fa fa-suitcase"></i> ${lang.getString('menu.adminpanel')}</a></li>
                          </c:if>
                        </ul>

                    </div>



                </div>


            </header>