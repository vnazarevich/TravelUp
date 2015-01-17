<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<form class="form-horizontal" action='confirmlogin' method="POST" id="login-form" accept-charset="UTF-8">
            <div class="form-group">
              <!-- Username -->
              <label >${lang.getString("auth.header.login")}</label>
              <div class="controls">
                <input type="text" id="login" name="login"  class="form-control" required>
              </div>

              <!-- Password-->
              <label>${lang.getString("auth.header.password")}</label>
              <div class="controls">
                <input type="password" id="password" name="password"  class="form-control" required>
              </div>
            </div>


            <div class="form-group">

                <input type="submit" class="btn btn-success" id="login-button" value="Login">
                <Label id="login-status" class="error-label">${status}</Label>

            </div>

        </form>
      </div>
</body>
</html>