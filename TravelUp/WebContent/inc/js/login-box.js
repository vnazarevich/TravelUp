	$("#login-form").submit(function(e){
		var login = $("#user-name").val();
		var password = $("#pass").val();
		var answer="";
		$.ajaxSetup({async: false});
	  	  $.post('confirmlogin',{login:login,password:password} ,function(responseText) {
	            answer=responseText;
	            console.log("Answer: "+answer);
	        });
	  	if(answer=="error"){
	  		$("#login-status").html("${lang.getString('login.fail')}");
	  		return false;
	  	}
	  	else
  			if(answer=="disapproved"){
  		  		$("#login-status").html("${lang.getString('login.disapproved')}");
  		  		return false;
  			}
  			else
  	  			if(answer=="banned"){
  	  		  		$("#login-status").html("${lang.getString('login.banned')}");
  	  		  		return false;
  	  			}
	  	
	  	return true;
	});
	$('#user-name, #pass').focus(function(e){
		$("#login-status").html("");
	});
