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

function saveProductItemAction(productId,quantity){

	try{
	
	
	//var url="product/saveProductItemAction.action?productId="+productId+"&orderQuantity="+quantity;
	 
	 
	 $("#cart_block").slideUp("normal",function(){
												
				 $("#cart_block").load("product/saveProductItemAction.action", {"productId": productId,"orderQuantity":quantity}, function(){
   $("#cart_block").slideDown("normal");
 }); 								
				 								 
			}); 
	//$("#center_column").load(url);
		
	}catch(e){
		alert(e);
	}
}

function shopCartInfoLoadAction(){
		try{
	
	var url="product/shopCartInfoLoadAction.action";
	$("#center_column").load(url);
		
	}catch(e){
		alert(e);
	}
}
