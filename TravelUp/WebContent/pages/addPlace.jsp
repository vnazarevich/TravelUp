<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <jsp:include page="/pages/styles.jsp" />
 

 <script type="text/javascript">
var files=1;
function readURL(input) {
	console.log('changed');
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
        	var file=$(input).val();
        	var extension=file.split('.').pop().toLowerCase();
        	if(extension.match(/(jpg|jpeg|png|gif|bmp)$/)){
	            $('#lastimage').attr('src', e.target.result);
	            $("#lastimage").removeAttr('id');
	            $("#lastinput").removeAttr("id");
        	}else{
        		$(input).parent().remove();
        	}
        }
        files++;
        reader.readAsDataURL(input.files[0]);
    }

}
function removeImage(mask){
	files--;
	$(mask).parent().remove();
}

function removeExistingImage(mask){
	$(mask).parent().parent().find("input[type='hidden']").val("deleted");
	$(mask).parent().remove();
}

function loadFile(){
	$("#lastinput").trigger('click');
}

$(function(){
	
	$("#createPlace").click(function(e){
		e.preventDefault();
		$("#place-form").submit();
	});
	
	$("#add-file").click(function(e) {
		$('<div class="view third-effect" ><input type="file" onchange="readURL(this);" name="file'+files+'" id="lastinput" style="display:none" accept="image/*"><img src="" id="lastimage" style="cursor:pointer;height:140px;"/> <div class="mask" onclick="removeImage(this);"><a class="info" title="Remove">Remove</a></div></div>').insertBefore(this);
		loadFile();
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
                      <h2>Додавалка плейсу</h2>
                    </div>
                    <div class="col-xs-6">
                        <div class="breadcrumb-holder">
                            <ol class="breadcrumb">
                                <li><a href="index">${lang.getString("tourpage.page.home")}</a></li>              
                                <li class="active">Новий плейс</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>

            <section class="section wide-fat page">
                <div class="container">                 
                    <div class="contents-wrapper">         
							 <form id="place-form" action="addplace" method="POST">
                            <div class=" grid-contents col-lg-6 col-sm-6 col-md-6 col-xs-12">		
                       		 <div class="row">
							
                                
								<div class="col-md-6 col-sm-6 col-xs-12">
									<h3>English name :</h3>
									<input type="text" class="form-control" name="enplacename" required>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<h3>Ukrainian name :</h3>
									<input type="text" class="form-control" name="uaplacename" required>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<h3>English description :</h3>
									<input type="text" class="form-control" name="enplacedescription" required>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<h3>Ukrainian description :</h3>
									<input type="text" class="form-control" name="uaplacedescription" required>
								</div>
								<div class="col-md-3 col-sm-6 col-xs-12">
									<h3>Coordinates</h3>
									<input type="text" class="form-control" name="xcoordinate" required>
								</div>
								<div class="col-md-3 col-sm-6 col-xs-12">
									<h3>: </h3>
									<input type="text" class="form-control" name="ycoordinate" required>
								</div>	
								<div class="col-md-6 col-sm-6 col-xs-12">
									<h3>Region :</h3>
									<input type="text" class="form-control" name="region" required>
								</div>									
							</div>

                            </div><!-- /.contents.grid-contents -->
                            </form>
							
								<div class="grid-contents col-lg-6 col-sm-6 col-md-6 col-xs-12 ">		
                                <div class="row">
                                    <div class="content  wide">

                                        <div class="inner">					

                                        <div class="entry">
                                                   
                                            <article class="entry-content">
                                            <h3>Change your gallery:</h3>
												<div id="images-root">
													<c:forEach var="userPhoto" items="${userPhotos}">
													<div class="existing-image">
														<input type="hidden" name="photo${userPhoto.getId()}" value="exist">
														<div class="view third-effect" >
														<img src="${initParam['imagesPath']}${userPhoto.getPhotolink()}" style="cursor:pointer;height:140px;"/>
														<div class="mask" onclick="removeExistingImage(this);">
														<a class="info" title="Remove">Remove</a>
														</div>
														</div>
													</div>
													</c:forEach>
													<div id="add-file">
														<img src="images/add-file.png" style="cursor:pointer;width:140px;height:140px;"/>
													</div>
												<br>
												</div>     
                                            </article>

                                        </div><!-- /.entry -->
 
                                        </div>

                                    
		
                         </div><!-- /.row -->


                            </div><!-- /.contents.grid-contents -->

                        </div><!-- /.row -->

                    </div><!-- /.contents-wrapper -->

                </div>
				<div class="center-button">
					<a id="createPlace" class="create-place button btn-block"><span class="glyphicon glyphicon-ok"></span> Створити</a>
				</div>
            </section><!-- /#hotels.section -->

            <jsp:include page="/pages/footer_black.jsp" />
           <!-- /#footer -->

        </div><!-- /#site -->


<!-- Scripts -->

	<jsp:include page="/pages/scripts.jsp" />

</body>
</html>