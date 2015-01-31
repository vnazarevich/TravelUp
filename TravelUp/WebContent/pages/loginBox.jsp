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