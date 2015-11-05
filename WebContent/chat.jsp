<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Chat - KellimniFejnTrid.com</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>	
	<body>
		
		<div id="wrapper">
            <h1>Welcome!</h1>
            <br />
            <div id="chatFriend">
                <div class="button"> <a href="#" OnClick="showForm()">Add a device</a> </div>
                <form id="addDeviceForm">
                    <h3>Add a new device</h3>
                    <span>Name: <input type="text" name="device_name" id="device_name"></span>
                    <span>Type: 
                        <select id="device_type">
                            <option name="type" value="Appliance">Appliance</option>
                            <option name="type" value="Electronics">Electronics</option>
                            <option name="type" value="Lights">Lights</option>
                            <option name="type" value="Other">Other</option>
                        </select></span>

                    <span>Description:<br />
                        <textarea name="description" id="device_description" rows="2" cols="50"></textarea>
                    </span>

                    <input type="button" class="button" value="Add" onclick=formSubmit()>
                    <input type="reset" class="button" value="Cancel" onclick=hideForm()>
                </form>
            </div>
            <br />
            <h3>Currently connected devices:</h3>
            <div id="content">
            </div>
        </div>
		
	</body>
</html>