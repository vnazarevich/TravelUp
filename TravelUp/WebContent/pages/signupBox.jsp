<div class="modal fade" id="signupBox" tabindex="-1" role="dialog"  aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-body">
                            <form  id="signup-form" action="confirmsignup" method="post" accept-charset="UTF-8">
                                <div class=" field-row" >
                                    <label id="login-label" class="error-label" style="color:#b94a48"></label>
                                    <input  placeholder="${sessionScope.lang.getString('auth.header.login')}" id="login" type="text" class="form-control" required name="login">

                                    <label id="password-label" class="error-label" style="color:#b94a48"></label>
                                    <input  type="password" placeholder="${sessionScope.lang.getString('auth.header.password')}" id="password" name="password"  class="form-control" required>

	                                <label id="confirmed-password-label" class="error-label" style="color:#b94a48"></label>
	                                <input placeholder="${sessionScope.lang.getString('auth.header.confirm-password')}" id="confirmed-password" type="password"  name="confirmed-password" required  class="form-control">

	                                <label id="name-label" class="error-label" style="color:#b94a48"></label>
	                                <input placeholder="${sessionScope.lang.getString('auth.header.first-name')}" id="name" type="text" class="form-control" required name="name">

                             	    <label id="surname-label" class="error-label" style="color:#b94a48"></label>
                             	    <input placeholder="${sessionScope.lang.getString('auth.header.second-name')}" id="surname" type="text" required class="form-control" name="surname">

	                                <label id="email-label" class="error-label" style="color:#b94a48"></label>
	                                <input placeholder="${sessionScope.lang.getString('auth.header.email')}" id="email" type="text" required class="form-control" name="email">

                                </div>
                                <button type="submit" class="button green">${sessionScope.lang.getString('auth.submit')}</button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
<script>
	function check(element, value) {
		console.log("check");
		var answer = "";
		console.log(element);
		if (value != "") {
			$.ajaxSetup({
				async : false
			});
			$.post('verifyuser', {
				attr : element,
				value : value
			}, function(responseText) {
				answer = responseText;
				console.log("Answer: " + answer);
			});
		}
		return answer;
	}
	$(function() {
		console.log("Doc ready")
		$(".form-control").val("");
		$(".form-control").focus(function(e) {
			var name = $(this).attr("name");
			name += "-label";
			$("#" + name).html("");
		});
		$("#login")
				.blur(
						function(e) {
							console.log("login blur");
							var element = "login";
							var value = $(this).val();
							var answer = check(element, value);
							if (answer == "error") {
								console.log(answer);
								var message = "${sessionScope.lang.getString('auth.message.wrong-login')}";
								$("#login-label").html(message);
							}
						});
		$("#name")
				.blur(
						function(e) {
							console.log("name blur");
							var element = $(this).attr("name");
							var value = $(this).val();
							var answer = check(element, value);
							if (answer == "error") {
								console.log(answer);
								var message = "${sessionScope.lang.getString('auth.message.wrong-name')}";
								$("#name-label").html(message);
							}
						});
		$("#surname")
				.blur(
						function(e) {
							console.log("surname blur");
							var element = $(this).attr("name");
							var value = $(this).val();
							var answer = check(element, value);
							if (answer == "error") {
								console.log(answer);
								var message = "${sessionScope.lang.getString('auth.message.wrong-surname')}";
								$("#surname-label").html(message);
							}
						});
		$("#email")
				.blur(
						function(e) {
							console.log("surname blur");
							var element = "email";
							var value = $(this).val();
							var answer = check(element, value);
							if (answer == "error") {
								console.log(answer);
								var message = "${sessionScope.lang.getString('auth.message.wrong-email')}";
								$("#email-label").html(message);
							}
						});
		$('#signup-form').submit(function() {
			var flag = true;
			$(".error-label").each(function(index) {
				if ($(this).html() != "") {
					flag = false;
					return false;
				}
			});
			return flag;
		})
		$("#password, #confirmed-password")
				.blur(
						function(e) {
							var passw1 = $("#password").val();
							var passw2 = $("#confirmed-password").val();
							if (passw1 != passw2 && passw1 != ""
									&& passw2 != "") {
								$("#confirmed-password-label")
										.html(
												"${sessionScope.lang.getString('auth.message.wrong-password')}");
							} else {
								$("#confirmed-password-label").html("");
							}
						});
	});
</script>