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