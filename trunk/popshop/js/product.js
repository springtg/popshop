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

function productInfoLoadAction(productId){
	try{
	
	var url="product/productInfoLoadAction.action?productId="+productId;
	$("#center_column").load(url);
		
	}catch(e){
		alert(e);
	}
}

