<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TravelUp</title>

        <!-- Styles -->
        <jsp:include page="/pages/styles.jsp" />
        
        <!-- Scripts -->
        <jsp:include page="/pages/scripts.jsp" />
    </head>
    <body>

<div id="preloader">
    <div id="status">&nbsp;</div>
    <noscript>JavaScript is off. Please enable to view full site.</noscript>
</div>
        <div id="site">

        <div class="overlayup"></div>

        <!-- VideoBG -->
<video class="video-on-bg" autoplay loop poster="images/karpaty.jpg" id="video-on-bg">
    <source src="video/UkrainianCarpathians.mp4" type="video/mp4">
</video>
<!--[if lt IE 9]>
<script>
    document.createElement('video');
</script>
<![endif]-->

         <!-- / VideoBG -->

          <jsp:include page="/pages/header.jsp" />
          <jsp:include page="/pages/loginBox.jsp" />
          <jsp:include page="/pages/signupBox.jsp" />





            <section id="travelup" class="section wide-fat">


                <div class="container">


                    <article id="post-6" class="contact section-intro">

                        <h1 class="page-title">Travel<span class="higlight">Up</span></h1>
                        <div class="entry-content">

                            <p>Integer sollicitudin ligula non enim sodales, non lacinia nunc ornare. Sed commodo tempor dapibus.<br /> Duis convallis turpis in tortor volutpat, eget rhoncus nisi fringilla. Phasellus ornare risus in euismod varius nullam feugiat ultrices.<br /> Sed condimentum est libero, aliquet iaculis diam bibendum ullamcorper.</p>
<br /><br /><br /><br /><br /><br /><br />
                        </div>

                    </article><!-- /#post-6.contact -->


                    <center><a class="button" href="#">${lang.getString("mainpage.startbutton")}</a></center>



                </div>


            </section><!-- /#contact.section -->






           <!-- Footer -->
           <jsp:include page="/pages/footer.jsp" />




        </div><!-- /#site -->



        

    </body>
</html>