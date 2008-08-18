// JavaScript Document

function loadProductMainAction(){
	
	try{
			var url='product/productMain.php'
			$.get(url, function(data){
     			$('#mainInfoTD').append(data);
				$("#tabsEx1 > ul").tabs();
  		 } 
	); 
		
	}catch(e){
			alert(e);
	}
}