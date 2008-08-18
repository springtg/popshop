<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<!--
<script language="javascript" src="../jquery/jquery-1.2.6.js"></script>
<script language="javascript" src="../jquery/jquery.form.js"></script>
<script language="javascript" src="../jquery/jquery.validate.js"></script>
<script language="javascript" src="../jquery/jquery.ui.all.js"></script>

<link rel="stylesheet" type="text/css" href="../jquery/themes/flora/flora.all.css">
-->
<script type="text/javascript">
 

$().ready(function() {
	$("#userRigisterDiv").dialog({ 
    modal: true,
	width:500,
	height:400
});
 
	// validate signup form on keyup and submit
	$("#userRigisterForm").validate({
		rules: {
			userEmail: {
				required: true,
				email: true
			},
			username: {
				required: true,
				minlength: 2
			},
			password: {
				required: true,
				minLength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
	  
			agree: "required"
		},
		messages: {
			userEmail: "Please enter a valid email address",
			username: {
				required: "Please enter a username",
				minLength: "Your username must consist of at least 2 characters"
			},
			password: {
				required: "Please provide a password",
				minLength: "Your password must be at least 5 characters long"
			},
			confirm_password: {
				required: "Please provide a password",
				minLength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			
			agree: "Please accept our policy"
		},
		submitHandler: function() { alert(" aadadf submitted!"); }
	});
 
});
</script>
</head>

<body>
<div id="userRigisterDiv">
<fieldset><legend>用户注册</legend>


 


<form method="post" enctype="multipart/form-data" name="userRigisterForm" id="userRigisterForm">
	 
		<p>
			<label for="userEmail">userEmail</label>
			<input id="userEmail" name="userEmail" />
		</p>
			<label for="username">Username</label>
			<input id="username" name="username" />
		</p>
		<p>
			<label for="password">Password</label>
			<input id="password" name="password" type="password" />
		</p>
		<p>
			<label for="confirm_password">Confirm password</label>
			<input id="confirm_password" name="confirm_password" type="password" />
		</p>

		<p>
			<label for="agree">Please agree to our policy</label>
			<input type="checkbox" id="agree" name="agree" />
		</p>
	 
		<p>
			<input class="submit" type="submit" value="Submit"/>
		</p>
 
</form>



</fieldset>
</div>
</body>
</html>
