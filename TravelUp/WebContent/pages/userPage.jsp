<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="ex" uri="../WEB-INF/user.tld"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
   <jsp:include page="/pages/styles.jsp" />
  <script type="text/javascript" src="inc/js/jquery.object.js"></script>
<title>Users</title>
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
                      <h2>My page</h2>
                    </div>
                    <div class="col-xs-6">
                        <div class="breadcrumb-holder">
                            <ol class="breadcrumb">
                                <li><a href="index">Home</a></li>
                                <li class="active"><a href="">MyPage</a></li>
                            </ol>
                        </div>
                    </div>
                </div>
            </section>

<section id="user-info" class="section wide-fat page">
 <div class="container">
	    <div class="sidebar col-md-3  col-xs-12">
		    <div class="thumbnail">
		     <form class="form-horizontal" action="userimage" method="post" enctype="multipart/form-data">
				<input type="file" id="fileBrowser" class="form-control" name="image" />
				<input type="submit" value="*баш!!!">
				</form>
		      <img src="http://static.comicvine.com/uploads/original/11111/111116692/3213841-7948839370-yoda..jpg" alt="..." class="img-rounded" >
		      <div class="caption">
		      <div class="row editable">
		      <div class="row-same-height">
		      <label class="error-label" style="color:#b94a48">${sessionScope.lang.getString('auth.message.wrong-name')}</label>
		      <div class="col-md-9 col-md-height col-top">
		        <h4 class="target">${user.getFirstName()}</h4>
		        <input type="text" class="changer form-control" name="first_name">
		        </div>

		        <div class="col-md-3 col-md-height col-middle">
		        <button type="button" class="btn btn-default btn-edit" aria-label="Left Align">
				  <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				</button>
				<button type="button" class="btn btn-default btn-confirm" aria-label="Left Align">
				  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
				</button>
				</div>
				</div>
				</div><!-- editable -->

				<div class="row editable">
		      <div class="row-same-height">
		      <div class="col-md-9 col-md-height col-top">
		      <label class="error-label" style="color:#b94a48">${sessionScope.lang.getString('auth.message.wrong-surname')}</label>
		        <h4 class="target">${user.getLastName()}</h4>
		        <input type="text" class="changer form-control" name="last_name">
		        </div>

		        <div class="col-md-3 col-md-height col-middle">
		        <button type="button" class="btn btn-default btn-edit" aria-label="Left Align">
				  <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				</button>
				<button type="button" class="btn btn-default btn-confirm" aria-label="Left Align">
				  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
				</button>
				</div>
				</div>
				</div><!-- editable -->



				<div class="row editable">
		      <div class="row-same-height">
		      <div class="col-md-12 col-md-height col-top">
		      <div class="form-group">
			      <button type="button" class="btn btn-xs btn-block btn-show-password">
						Change password
						 <span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
					</button>
				</div>
				<form id="password-form" accept-charset="UTF-8">
					<div class="form-group" >
						<input type="password" class="password form-control old-password" placeholder="Currnet password" required>
					</div>
					<div class="form-group" >
						<input type="password" class="password form-control new-password" placeholder="New password" required>
					</div>
					<div class="form-group" >
						<input type="password" class="password form-control confirmed-password" placeholder="Confirm password" required>
					</div>
					<div class="form-group" >
						<input type="submit" class="btn btn-block btn-sm btn-success change-password" value="Change">
						<label class="error-label" style="color:#b94a48"></label>
					</div>
				</form>
				<div id="changedAlert" class="alert alert-success fade" data-alert="alert">Successfully changed</div>
				</div>
				</div>
				</div><!-- editable -->

				</div>

		      </div>
		    </div><!-- sidebar -->
		     <div class="contents grid-contents col-sm-9"><!--page-->
					<ul class="nav nav-tabs" id="tabs">
                    <li class="active"><a href="#portfolio-tab" data-toggle="tab">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                    Portfolio</a></li>
                    <li><a href="#cart-tab" data-toggle="tab">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                    Cart</a></li>
                  </ul>
                  <br/>
                  <div id="myTabContent" class="tab-content">
                    <div class="tab-pane active" id="portfolio-tab">
						<jsp:include page="/pages/portfolio.jsp"/>
                    </div>
                    <div class="tab-pane fade" id="cart-tab">
						Still under construct...
                    </div>
                </div>
			</div>
		</div><!--container-->
		</section>
		<!-- Footer -->
           <jsp:include page="/pages/footer.jsp" />
	    </div><!--site-->




<!-- Scripts -->
<script>

function editUser(attr, value){
	var answer="";
	$.ajaxSetup({async: false});
	  $.post('edituser',{attr:attr,value:value} ,function(responseText) {
          answer=responseText;
          console.log("Answer: "+answer);
      });
	  return answer;
}


$(document).ready(function() {
	function hideAlert() {
	    $("#changedAlert").removeClass("in");
	}
	function showAlert() {
	    $("#changedAlert").show().addClass("in");
	}
	$("#user-info").find(".changer, .btn-confirm, .error-label, #password-form, #changedAlert").hide();
	$(".btn-show-password").click(function(e){
		$("#password-form").toggle();
	});

	$("#password-form").submit(function(){
		var oldPassword=$(".old-password").val();
		var newPassword=$(".new-password").val();
		var confirmedPassword=$(".confirmed-password").val();
		var error=$(this).find(".error-label");
		//error.show();
		if(confirmedPassword!=newPassword){
			console.log(confirmedPassword);
			console.log(newPassword);
			error.html("${sessionScope.lang.getString('auth.message.wrong-password')}");
			error.show();
		}else{
			var answer="";
			$.ajaxSetup({async: false});
			  $.post('editpassword',{oldPassword:oldPassword,newPassword:newPassword} ,function(responseText) {
		          answer=responseText;
		          console.log("Answer: "+answer);
		      });
			if(answer!="ok"){
				error.html("Wrong current password");
				error.show();
			}else{
				$(this).hide();
				showAlert();
				window.setTimeout(function () {
				    hideAlert();
				    window.setTimeout(function () {
				    	$("#changedAlert").hide();
				    },500);
				}, 2000);
			}
		}
		return false;
	});
	$(".password").focus(function(e){
		$("#password-form").find(".error-label").hide();
	});

	$(".btn-edit").click(function(e){
		var parent = $(this).parents(".editable");
		var changer=parent.find(".changer");
		var target=parent.find(".target");
		changer.val(target.html());
		target.hide();
		changer.show();
		console.log(changer);
		$(this).hide();
		var confirmBtn=parent.find(".btn-confirm");
		confirmBtn.show();
	});

	$(".btn-confirm").click(function(e){
		var parent = $(this).parents(".editable");
		var changer=parent.find(".changer");
		var target=parent.find(".target");
		console.log("Attr: "+changer.attr("name"));
		var answer=editUser(changer.attr("name"),changer.val());
		var error=parent.find(".error-label");
		if(answer=="error"){
			error.show();
		}else{
			error.hide();
			target.show();
			console.log(changer);
			$(this).hide();
			changer.hide();
			var editBtn=parent.find(".btn-edit");
			editBtn.show();
			target.html(changer.val());

		}
	});

});
</script>
	<jsp:include page="/pages/scripts.jsp" />
</body>
</html>