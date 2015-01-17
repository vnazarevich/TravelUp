<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<script>
function check(element,value){
	console.log("check");
  	  var answer="";
  	  console.log(element);
  	  if(value!=""){
	  	  $.ajaxSetup({async: false});
	  	  $.post('verifyuser',{attr:element,value:value} ,function(responseText) {
	            answer=responseText;
	            console.log("Answer: "+answer);
	        });
  	  }
  	  return answer;
}

$(function(){
	console.log("Doc ready")
  $(".form-control").val("");

	$(".form-control").focus(function(e){
		var name = $(this).attr("name");
		name+="-label";
		$("#"+name).html("");
	});

  $("#login").blur(function(e){
	  console.log("login blur");
	  var element = "login";
	  var value = $(this).val();
	var answer=check(element,value);
	if(answer=="error"){
		console.log(answer);
		var message="${sessionScope.lang.getString('auth.message.wrong-login')}";
		$("#login-label").html(message);
	}
  });

  $("#name").blur(function(e){
	  console.log("name blur");
	  var element = $(this).attr("name");
	  var value = $(this).val();
	var answer=check(element,value);
	if(answer=="error"){
		console.log(answer);
		var message="${sessionScope.lang.getString('auth.message.wrong-name')}";
		$("#name-label").html(message);
	}
  });

  $("#surname").blur(function(e){
	  console.log("surname blur");
	  var element = $(this).attr("name");
	  var value = $(this).val();
	var answer=check(element,value);
	if(answer=="error"){
		console.log(answer);
		var message="${sessionScope.lang.getString('auth.message.wrong-surname')}";
		$("#surname-label").html(message);
	}
  });

  $("#email").blur(function(e){
	  console.log("surname blur");
	  var element = "email";
	  var value = $(this).val();
	var answer=check(element,value);
	if(answer=="error"){
		console.log(answer);
		var message="${sessionScope.lang.getString('auth.message.wrong-email')}";
		$("#email-label").html(message);
	}
  });

  $('#signup-form').submit(function() {
      var flag=true;
	  $(".error-label").each(function(index) {

		    if($(this).html()!=""){
		    	flag=false;
		    	return false;
		    }
	  });

      return flag;
  })

	$("#password, #confirmed-password").blur(function(e){
	  var passw1=$("#password").val();
	  var passw2=$("#confirmed-password").val();
	  if(passw1!=passw2&&passw1!=""&&passw2!=""){
		  $("#confirmed-password-label").html("${sessionScope.lang.getString('auth.message.wrong-password')}");
	  }else{
		  $("#confirmed-password-label").html("");
	  }
  });


});
</script>
<div class="container">
<form class="form-horizontal" id="signup-form" action="confirmsignup" method="post" accept-charset="UTF-8">
	 <div class="form-group" id="fieldcontainer">
	   <label>${sessionScope.lang.getString('auth.header.login')}</label> <label id="login-label" class="error-label"></label>
	   <input id="login" type="text" class="form-control" required name="login">
	   <Label>${sessionScope.lang.getString('auth.header.password')}</Label> <label id="password-label" class="error-label"></label>
	   <input id="password" type="password"  name="password" required  class="form-control">
	   <Label>${sessionScope.lang.getString('auth.header.confirm-password')}</Label> <label id="confirmed-password-label" class="error-label"></label>
	   <input id="confirmed-password" type="password"  name="confirmed-password" required  class="form-control">
	   <label>${sessionScope.lang.getString('auth.header.first-name')}</label> <label id="name-label" class="error-label"></label>
	   <input id="name" type="text" class="form-control" required name="name">
	   <label>${sessionScope.lang.getString('auth.header.second-name')}</label> <label id="surname-label" class="error-label"></label>
	   <input id="surname" type="text" required class="form-control" name="surname">
	   <label>${sessionScope.lang.getString('auth.header.email')}</label> <label id="email-label" class="error-label"></label>
	   <input id="email" type="text" required class="form-control" name="email">
	   </div>
	  <div class="form-group">
	     <input type="submit" class="btn btn-primary" value="${sessionScope.lang.getString('auth.submit')}">
	   </div>
 </form>
 <div>
 <p>${status}</p>
 </div>
 </div>
</body>
</html>