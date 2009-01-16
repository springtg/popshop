//------------------------------------------------------------ lightPortalMenu.js
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
   vBody.id = "portalMenu";
   vBody.className = "portal-header-menu"; 
   if(portal.showSearchBar){
	   var vSearch =document.createElement('span');
	   vSearch.className = "portal-header-search";      
	   vSearch.innerHTML = Light.getViewTemplate("searchBar.view",null);   
	   vBody.appendChild(vSearch);
   }    
   var noMenu=true;
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
	   noMenu = false;
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
	   noMenu = false;
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
	   noMenu = false;
   }   
   if(portal.allowSignIn){	   
	   var varE = document.createElement('a');
           var u = Light.getCookie(Light._LOGINED_USER_ID);
	   if(Light.getCookie(Light._LOGINED_USER_ID) != null && Light.getCookie(Light._LOGINED_USER_ID) != ""){
		   varE.innerHTML = $('_MENU_SIGN_OUT').title;
		   varE.href = "javascript:void(0)";
		   varE.onclick = function(){
		  	Light.logout();
		   }
	   }else{
	   	   varE.innerHTML = $('_MENU_SIGN_IN').title;
		   varE.href = "javascript:void(0)";
		   varE.onclick = function(){
		  	Light.loginToMyAccount();
		   }
	   }
	   vSpan.appendChild(varE);    
	   var vLine5 = document.createElement('span');
	   vLine5.className = "portal-header-menu-item-separater";
	   vSpan.appendChild(vLine5);
	   noMenu = false;
   }
   if(portal.allowSignIn && Light.getCookie(Light._LOGINED_USER_ID) != null && Light.getCookie(Light._LOGINED_USER_ID) != ""){	   
	   var varE = document.createElement('a');
	   varE.innerHTML = $('_MENU_MY_PROFILE').title;
	   varE.href = "javascript:void(0)";
	   varE.onclick = function(){
	  	Light.editProfile();
	   }
   	   vSpan.appendChild(varE);      
	   var vLine5 = document.createElement('span');
	   vLine5.className = "portal-header-menu-item-separater";
	   vSpan.appendChild(vLine5);
	   noMenu = false;
   }
   var userId = Light.getCookie(Light._LOGINED_USER_ID);
   if(userId == null || userId == "") 
      userId = Light.getCookie(Light._USER_ID);
   if(userId != null && userId != ""){
		if(noMenu){
			var varF = document.createElement('a');
	   		varF.innerHTML = $('_MENU_MY_ACCOUNT').title;
	   		varF.href = "javascript:void(0)";
	   		varF.onclick = function(){
				Light.toMyAccount();			   	
	   		}
   	   		vSpan.appendChild(varF);
	   		var vLine6 = document.createElement('span');
	   		vLine6.className = "portal-header-menu-item-separater";
	   		vSpan.appendChild(vLine6);
       	}
	   var varUp = document.createElement('a');
	   varUp.innerHTML = "<img src='"+portal.contextPath+"/light/images/collapseAll.gif' style='border: 0px' height='12' width='12' align='top' title='"+$('_MENU_COLLAPSE_ALL').title+"'/>";
	   varUp.href = "javascript:void(0)";
	   varUp.onclick = function(){
	   	  	Light.portal.collapseAll();
	   }
	   vSpan.appendChild(varUp);
	   var varDown = document.createElement('a');
	   varDown.innerHTML = "<img src='"+portal.contextPath+"/light/images/expandAll.gif' style='border: 0px' height='12' width='12' align='top' title='"+$('_MENU_EXPAND_ALL').title+"'/>";
	   varDown.href = "javascript:void(0)";
	   varDown.onclick = function(){
	   	  	Light.portal.expandAll();
	   }
	   vSpan.appendChild(varDown);
	   var vLine = document.createElement('span');
	   vLine.className = "portal-header-menu-item-separater";
	   vSpan.appendChild(vLine);
	}   
   if(portal.allowTurnOff){   	   
	   var varF = document.createElement('a');
	   varF.innerHTML = $('_MENU_TURN_OFF').title;
	   varF.href = "javascript:void(0)";
	   varF.onclick = function(){
	  	Light.switchPortal();
	   }
	   vSpan.appendChild(varF);
   }
   if(portal.allowChangeLocale){
	var varG = document.createElement('a');
	varG.innerHTML = "<img src='"+portal.contextPath+"/light/images/world.gif' style='border: 0px' height='16' width='16' align='top' title='"+$('_TITLE_LANGUAGE').title+"'/>";
	varG.href = "javascript:void(0)";
	varG.onclick = function(){
		Light.showChangeLanguage();
	}
   	vSpan.appendChild(varG);
   }
   vBody.appendChild(vSpan);      
   vBody.style.zIndex= ++Light.maxZIndex;
   vBody.style.width = Light.portal.layout.maxWidth;
   vBody.style.marginLeft = Light.portal.layout.containerLeft;  
   return vBody;
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