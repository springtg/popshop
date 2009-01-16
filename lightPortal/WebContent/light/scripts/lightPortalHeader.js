//------------------------------------------------------------ lightPortalHeader.js
function LightPortalHeader(){
}
LightPortalHeader.prototype.render= function(){}

LightPortalHeaderImpl.prototype = new LightPortalHeader;                // Define main header
LightPortalHeaderImpl.prototype.constructor = LightPortalHeader;
function LightPortalHeaderImpl(){
	LightPortalHeader.call(this);
}
LightPortalHeaderImpl.prototype.render = function (portal){
	var vPortalHeader = document.createElement('div');
	vPortalHeader.className = "portal-header";   
	if(portal.headerImage.length > 0){ 
		if(portal.headerImage != "no"){
		    var headerImage = portal.headerImage;
		    if(headerImage.indexOf("http") < 0)
		      	headerImage = Light.portal.contextPath+headerImage;			
			if(portal.headerRepeat == 1)
				vPortalHeader.style.background = "url('"+headerImage+"') no-repeat " + portal.headerPosition;// no-repeat left top";
			else if(portal.headerRepeat == 2)
         		vPortalHeader.style.background = "url('"+headerImage+"') repeat-x right top";
         	else if(portal.headerRepeat == 3)
         		vPortalHeader.style.background = "url('"+headerImage+"') repeat-y left top";
         	else{
				vPortalHeader.style.background= "url('"+headerImage+"')";
				vPortalHeader.style.backgroundRepeat= "repeat-x";
			}
		}else{
			vPortalHeader.style.backgroundColor= "";         
		}  
	}else{
		vPortalHeader.style.backgroundColor= "";         
	}
	var height = parseInt(portal.headerHeight);
	if( height> 0) vPortalHeader.style.height= 60 + parseInt(height);
   
	var userId = Light.getCookie(Light._LOGINED_USER_ID);
	if(userId == null || userId == "") 
		userId = Light.getCookie(Light._USER_ID);
	if(userId != null && userId != ""){   
	   var vTitle =document.createElement('span');
	   vTitle.id = "portal-header-title";  
	   vTitle.className = "portal-header-title";      
	   if(portal.title.trim().length == 0){
	     vTitle.innerHTML = "<input type='text' id='portalTitle' class='portal-header-title-edit' value='' onchange=\"javascript:Light.portal.saveTitle();\" onblur=\"javascript:Light.portal.saveTitle();\"/>";
	   }else{            
	     vTitle.innerHTML = "<span class='portal-header-title-view' onmousemove=\"javascript:if(this.className=='portal-header-title-view'){this.style.backgroundColor ='#EEF6FF';}\" onmouseout=\"javascript:if(this.className=='portal-header-title-view'){Light.portal.viewTitle(this);}\"  onmousedown=\"javascript:if(this.className=='portal-header-title-view'){this.className='portal-header-title-edit'; Light.portal.editTitle(this);}\">"+Light.portal.title+"</span>";
	   }
	   vPortalHeader.appendChild(vTitle);
   }else{
   		vPortalHeader.style.height= 60;
   }
   var vLogo =document.createElement('span');
   vLogo.className = "portal-header-logo";
   var logo = Light.portal.logo;
   if(!logo.startsWith("http")) logo = portal.contextPath + logo;
   var strLogo= "<a href='javascript:void(0)' onclick='javascript:window.location.reload(true);'><img src='"+logo+"' style='border: 0px;'/></a>";      
   vLogo.innerHTML= strLogo;
   if (document.all) {	
       vLogo.style.posLeft = Light.portal.layout.containerLeft;                
   }    
   else {        
       vLogo.style.left = Light.portal.layout.containerLeft;     
   }
   vPortalHeader.appendChild(vLogo);
   vPortalHeader.style.zIndex= ++Light.maxZIndex;              
   return vPortalHeader;
}
