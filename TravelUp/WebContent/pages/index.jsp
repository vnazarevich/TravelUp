<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TravelUp</title>

        <!-- Scripts -->
        <jsp:include page="/pages/scripts.jsp" />

        <!-- Styles -->
        <jsp:include page="/pages/styles.jsp" />
    </head>
    <body>

<div id="preloader">
    <div id="status">&nbsp;</div>
    <noscript>JavaScript is off. Please enable to view full site.</noscript>
</div>
        <div id="site">

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

 <c:if test="${status!=null}">
 <script type="text/javascript">$("#statusBox").modal('show') </script>
</c:if>




            <section id="travelup" class="section wide-fat">


                <div class="container">


                    <article id="post-6" class="contact section-intro">

                        <h1 class="page-title">Travel<span class="higlight">Up</span></h1>
                        <div class="entry-content">


<br /><br /><br /><br /><br /><br /><br /><br />


                        </div>

                    </article><!-- /#post-6.contact -->


                    <center><a class="button" href="tours">${lang.getString("mainpage.startbutton")}</a></center>
                    <br /><br />



                </div>


            </section><!-- /#contact.section -->






           <!-- Footer -->
           <jsp:include page="/pages/footer.jsp" />




        </div><!-- /#site -->





    </body>
</html>