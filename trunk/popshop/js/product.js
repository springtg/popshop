// JavaScript Document

function categoriesListAction(){
	try{
	
	$("#categories_block_left").load("product/categoriesListAction.action");
		
	}catch(e){
		alert(e);
	}
}