<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ShowImg</title>

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

        

          <jsp:include page="/pages/header.jsp" />
          <jsp:include page="/pages/loginBox.jsp" />
          <jsp:include page="/pages/signupBox.jsp" />




            <section id="img-loader" class="section wide-fat">


                <div class="container">

			<img
      src="${initParam['imagesPath']}${loadimage}"
      alt="image" class="img-thumbnail" style="width: 140px; height: 140px;">

				</div>


            </section>






           <!-- Footer -->
           <jsp:include page="/pages/footer.jsp" />




        </div><!-- /#site -->



        

    </body>
</html>