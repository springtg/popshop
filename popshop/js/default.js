// JavaScript Document

function mainInfoLoad(url){
	try{
		$('#mainInfoTD').load(url);
	}catch(e){
			alert(e);
	}
}

function mainLeftInfoAppand(url){
		try{
			$.get(url, function(data){
     			$('#mainLeftInfoTD').append(data);
  		 } 
	); 
		
	}catch(e){
			alert(e);
	}
}