// JavaScript Document

function categoriesListAction(){
	try{
	
	$("#categories_block_left").load("product/categoriesListAction.action");
		
	}catch(e){
		alert(e);
	}
}




function manufacturerListAction(){
	try{
	
	$("#manufacturers_block_left").load("product/manufacturerListAction.action");
		
	}catch(e){
		alert(e);
	}
}
