<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Gallery</title>

        <!-- Styles -->
        <jsp:include page="/pages/styles.jsp" />
        
        <!-- Scripts -->
        <jsp:include page="/pages/scripts.jsp" />
        
        
<script type="text/javascript" src="inc/gallery/swfobject.js"></script>
<style type="text/css">	
	/* hide from ie on mac \*/
	html {
		height: 100%;
		overflow: hidden;
	}
	
	#flashcontent {
		height: 100%;
	}
	/* end hide */

	body {
		height: 100%;
	}

	a {	
		color:#cccccc;
	}
</style>
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




            <section id="gallery" class="section wide-fat" style="padding-top: 0px; padding-bottom: 0px;">


                <div class="container">
                
               
                
                <div class="col-xs-12 col-sm-12" style="height: 700px;">
                       
                       <div id="flashcontent">TiltViewer requires JavaScript and the latest Flash player. <a href="http://www.macromedia.com/go/getflashplayer/">Get Flash here.</a></div>
	<script type="text/javascript">
	
		var fo = new SWFObject("inc/gallery/TiltViewer.swf", "viewer", "100%", "100%", "9.0.28", "#FFFFFF");			
		
		// TILTVIEWER CONFIGURATION OPTIONS
		// To use an option, uncomment it by removing the "//" at the start of the line
		// For a description of config options, go to: 
		// http://www.airtightinteractive.com/projects/tiltviewer/config_options.html
															
		//FLICKR GALLERY OPTIONS
		// To use images from Flickr, uncomment this block
		//fo.addVariable("useFlickr", "true");
		//fo.addVariable("user_id", "48508968@N00");
		//fo.addVariable("tags", "jump,smile");
		//fo.addVariable("tag_mode", "all");
		//fo.addVariable("showTakenByText", "true");			
		
		// XML GALLERY OPTIONS
		// To use local images defined in an XML document, use this block		
		fo.addVariable("useFlickr", "false");
		fo.addVariable("xmlURL", "inc/gallery/gallery.xml");
		fo.addVariable("maxJPGSize","1200");
		
		//GENERAL OPTIONS		
		fo.addVariable("useReloadButton", "false");
		fo.addVariable("columns", "4");
		fo.addVariable("rows", "4");
		//fo.addVariable("showFullscreenOption", "true");
		//fo.addVariable("showFlipButton", "true");
		fo.addVariable("showLinkButton", "false");		
		//fo.addVariable("linkLabel", "View image info");
		//fo.addVariable("frameColor", "0xFF0000");
		fo.addVariable("backColor", "0x85C616");
		fo.addVariable("bkgndInnerColor", "0x85C616");
		fo.addVariable("bkgndOuterColor", "0xFFFFFF");				
		//fo.addVariable("langAbout", "About");				
		
		// END TILTVIEWER CONFIGURATION OPTIONS
		
		fo.addParam("allowFullScreen","true");
		fo.write("flashcontent");			
	</script>	
                        
                    </div>

                
				</div>


            </section>






           <!-- Footer -->
           <jsp:include page="/pages/footer_black.jsp" />




        </div><!-- /#site -->



        

    </body>
</html>