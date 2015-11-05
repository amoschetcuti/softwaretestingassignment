<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login - KellimniFejnTrid.com</title>
		<link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>

        <div id="wrapper">
            <form id="login" action="login" method="post">
            	<h1>KellimniFejnTrid Login Page</h1>
                <span>Username: <input type="text" name="username" id="username"></span> <br />
                <span>Password: <input type="text" name="password" id="password"></span> <br />

                <input type="submit" class="button" value="Log In">
            </form>
        </div>

    </body>
</html>