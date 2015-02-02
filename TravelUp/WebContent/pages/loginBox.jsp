<div class="modal fade" id="loginBox" tabindex="-1" role="dialog"  aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-body">
                            <form action='confirmlogin' method="POST" id="login-form" accept-charset="UTF-8">
                                <div class=" field-row" >


                                <Label id="login-status" class="error-label" style="color:#b94a48"></Label>
                                    <input  placeholder="${lang.getString("auth.header.login")}" type="text" id="user-name" name="login"  class="form-control" required>


                                    <input  type="password" placeholder="${lang.getString("auth.header.password")}" id="pass" name="password"  class="form-control" required>

                                </div>
                                <button type="submit" class="button green" id="login-button" value="Login">${lang.getString("login.submit")}</button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

<script>
	$("#login-form").submit(function(e) {
		var login = $("#user-name").val();
		var password = $("#pass").val();
		var answer = "";
		$.ajaxSetup({
			async : false
		});
		$.post('confirmlogin', {
			login : login,
			password : password
		}, function(responseText) {
			answer = responseText;
			console.log("Answer: " + answer);
		});
		if (answer == "error") {
			$("#login-status").html("${lang.getString('login.fail')}");
			return false;
		} else if (answer == "disapproved") {
			$("#login-status").html("${lang.getString('login.disapproved')}");
			return false;
		} else if (answer == "banned") {
			$("#login-status").html("${lang.getString('login.banned')}");
			return false;
		}
		return true;
	});
	$('#user-name, #pass').focus(function(e) {
		$("#login-status").html("");
	});
</script>