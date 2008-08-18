// JavaScript Document

function userLoginAction(){
	
	try{
		var queryString = $('#userLoginForm').formSerialize(); 
		alert(queryString);
		$.post('user/userInfo.php', queryString,function(data){
     			$('#userLoginArea').before(data);
				$('#userLoginArea').remove();
				});
		/**
		// validate signup form on keyup and submit
	$("#userLoginForm").validate({
		rules: {
			userName: {
				required: true,
				minlength: 2,
				maxlength: 50,
			},
			userPassword: {
				required: true,
				minlength: 2,
				maxlength: 100,
			}
		},
		messages: {
			userName: {
				required: "please input userName!",
				minlength: "please input  at least tow letters!",
				maxlength:  "please input more than 100 letters!",
			},
			userPassword: {
				required: "please input userPassword!",
				minlength: "please input  at least tow letters!",
				maxlength:  "please input more than 100 letters!",
			}
		}
	});
	**/
	}catch(e){
		alert(e);
	}
}