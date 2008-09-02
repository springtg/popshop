// JavaScript Document

function clientSendMessage(){
	try{
		 
		var queryString = $('#sendMessageForm').formSerialize();
		 
		$.post("clientSendMessage.php",queryString,
  		function(data){
			 
			 alert(data);
   			//$('#sendMessageForm .messageInfo').clearFields();
  		 }); 
		
	}catch(e){
	}
}
	