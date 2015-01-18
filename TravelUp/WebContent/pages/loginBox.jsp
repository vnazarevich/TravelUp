<div class="modal fade" id="loginBox" tabindex="-1" role="dialog"  aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <div class="modal-body">
                            <form action='confirmlogin' method="POST" id="login-form" accept-charset="UTF-8">
                                <div class=" field-row" >


                                    <input  placeholder="${lang.getString("auth.header.login")}" type="text" id="login" name="login"  class="form-control" required>




                                    <input  type="password" placeholder="${lang.getString("auth.header.password")}" id="password" name="password"  class="form-control" required>


                                   



                                </div>
                                <button type="submit" class="button green" id="login-button" value="Login">Login Now</button>
                                <Label id="login-status" class="error-label">${status}</Label>
                            </form>
                        </div>

                    </div>
                </div>
            </div>