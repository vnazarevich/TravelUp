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