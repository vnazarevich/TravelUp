<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<div class="modal fade" id="loginBox" tabindex="-1" role="dialog"  aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-body">
                            <form action='confirmlogin' method="POST" id="login-form" accept-charset="UTF-8">
                                <div class=" field-row" >


                                    <input  placeholder="${lang.getString("auth.header.login")}" type="text" id="login" name="login"  class="form-control" required>


                                    <input  type="password" placeholder="${lang.getString("auth.header.password")}" id="password" name="password"  class="form-control" required>

                                </div>
                                <button type="submit" class="button green" id="login-button" value="Login">${lang.getString("login.submit")}</button>
                                <Label id="login-status" class="error-label"></Label>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
<script>
	$("#login-form").submit(function(e){
		var login = $("#login").val();
		var password = $("#password").val();
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
	  	return true;
	});
	$('#login, #password').focus(function(e){
		$("#login-status").html("");
	});
</script>