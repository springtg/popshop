//------------------------------------------------------------ lightPortalMenuView.js
function LightPortalMenu(){
}
LightPortalMenu.prototype.render= function(){}

LightPortalMenuImpl.prototype = new LightPortalMenu;                // Define main Menu
LightPortalMenuImpl.prototype.constructor = LightPortalMenu;
function LightPortalMenuImpl(){
	LightPortalMenu.call(this);
}
LightPortalMenuImpl.prototype.render = function (portal){
   tab = Light.currentTab;
   var vBody = document.createElement('div');   
   vBody.id = "portalHeaderMenu";
   vBody.className = "portal-header-menu"; 
   if(portal.showSearchBar){
	   var vSearch =document.createElement('span');
	   vSearch.className = "portal-header-search";      
	   vSearch.innerHTML = Light.getViewTemplate("searchBar.view",null); 
	   vBody.appendChild(vSearch);
   }  
   var vSpan = document.createElement('span');
   vSpan.className = "portal-header-menu-item";
   if(portal.allowLookAndFeel){
	   var varA = document.createElement('a');
	   varA.innerHTML = $('_MENU_LOOK_AND_FEEL').title;
	   varA.href = "javascript:void(0)";
	   varA.onclick = function(){
	  	Light.changeOptions();
	   }
	   vSpan.appendChild(varA);
	   var vLine1 = document.createElement('span');
	   vLine1.className = "portal-header-menu-item-separater";
	   vSpan.appendChild(vLine1);
   }
   if(portal.allowLayout && ( tab == null || tab.tabIsEditable)){	   
	   var varB = document.createElement('a');
	   varB.innerHTML = $('_MENU_LAYOUT').title;
	   varB.href = "javascript:void(0)";
	   varB.onclick = function(){
	  	Light.editTab();
	   }
	   vSpan.appendChild(varB);	   
	   var vLine2 = document.createElement('span');
	   vLine2.className = "portal-header-menu-item-separater";
	   vSpan.appendChild(vLine2);
   }    
   if(portal.allowAddContent && ( tab == null || tab.allowAddContent)){  	   
	   var varD = document.createElement('a');
	   varD.innerHTML = $('_MENU_ADD_CONTENT').title;
	   varD.href = "javascript:void(0)";
	   varD.onclick = function(){
	  	Light.addContent();
	   }
	   vSpan.appendChild(varD);	   
	   var vLine4 = document.createElement('span');
	   vLine4.className = "portal-header-menu-item-separater";
	   vSpan.appendChild(vLine4);
   }  
   if(portal.allowSignIn){	   
	   var varE = document.createElement('a');
           var u = Light.getCookie(Light._LOGINED_USER_ID);
	   if(Light.getCookie(Light._LOGINED_USER_ID) != null && Light.getCookie(Light._LOGINED_USER_ID) != ""){
		   varE.innerHTML = $('_MENU_SIGN_OUT').title;
		   varE.href = "javascript:void(0)";
		   varE.onclick = function(){
		  	Light.logoutMobile();
		   }
		   vSpan.appendChild(varE);	      
		   var vLine5 = document.createElement('span');
		   vLine5.className = "portal-header-menu-item-separater";
		   vSpan.appendChild(vLine5);
	   }
   }
   vBody.appendChild(vSpan);      
   vBody.style.zIndex= ++Light.maxZIndex;
   vBody.style.width = Light.portal.layout.maxWidth - 10;
   vBody.style.marginLeft = Light.portal.layout.containerLeft;                
   return vBody;
}
Light.logoutMobile = function(){
   Light.deleteCookie(Light._LOGINED_USER_ID);
   Light.deleteCookie(Light._USER_ID);
   Light.deleteCookie(Light._CURRENT_TAB); 
   var date = new Date();      
   date.setFullYear(date.getFullYear()+1);
   Light.setCookie(Light._IS_SIGN_OUT,"true");  
   Light.portal.needReload = true;
   var opt = {
    method: 'get',
	parameters:'',
    onSuccess: function(t) {
       Light.responseLogoutMobile(t);        
    },
    on404: function(t) {
        alert('Error 404: location "' + t.statusText + '" was not found.');
    },
    onFailure: function(t) {
        alert('Error ' + t.status + ' -- ' + t.statusText);
    }
   }
   Light.ajax.sendRequest(Light.portal.contextPath+Light.logoutRequest, opt);  
}
Light.responseLogoutMobile = function(t){  
	window.location.reload( true );
}
Light.getScriptsHandler = function(t){
	var scripts = t.responseText;	
	if(scripts != null){
		var params = scripts.split(",");
		for(var i=0;i<params.length;i++){
			var script =document.createElement("script");
		    script.setAttribute("language", "JavaScript");
		    script.setAttribute("src", params[i]);
		    document.getElementsByTagName("head")[0].appendChild(script); 
		    script = null; 
	    }
	 }
}