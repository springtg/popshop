//------------------------------------------------------------ lightPortalView.js
LightPortal.prototype.turnOnPortal = function(){ 
	this.latestAction={
	  	event: null,
	  	id: null,
        method: null,
        portlet: null
	} 
	if($('loginUserId').title != 0){
		Light.setCookie(Light._LOGINED_USER_ID, $('loginUserId').title);
	}
	Light.deleteCookie(Light._CURRENT_TAB); 
	Light.portal.renderPortal($('portalString').title);
	Light.portal.renderPortalTab($('pageRoot').title);   
}
LightPortal.prototype.turnOnPortal2 = function(){
  this.latestAction={
	  	event: null,
	  	id: null,
        method: null,
        portlet: null
  }  
  var opt = {
    method: 'post',
    onSuccess: function(t) {
        Light.portal.turnOnPortalHandler(t);
    },
    on404: function(t) {
        alert('Error 404: location "' + t.statusText + '" was not found.');
    },
    onFailure: function(t) {
        alert('Error ' + t.status + ' -- ' + t.statusText);
    }
   }
   Light.ajax.sendRequest(Light.visitPortalRequest, opt);   
}
LightPortal.prototype.turnOnPortalHandler = function(t){     
      var params = t.responseText.split(",");
      Light.portal.contextPath = params[0]; 
      if(Light.portal.contextPath.length == 0)
         Light.portal.contextPath= Light._DEFAULT_CONTEXT_PATH;
      Light.portal.title=params[1];       
      Light.portal.allowLookAndFeel=true;      
      Light.portal.allowLayout=true;
      Light.portal.allowAddTab=true;
      Light.portal.allowAddContent=true;
      Light.portal.allowSignIn=true;
      Light.portal.allowTurnOff=true; 
      Light.portal.allowChangeLocale=true;       
      Light.portal.portletWindowTransparent = true;
      if(params[2] == 0) Light.portal.allowLookAndFeel=false;
      if(params[3] == 0) Light.portal.allowLayout=false;
      if(params[4] == 0) Light.portal.allowAddTab=false;
      if(params[5] == 0) Light.portal.allowAddContent=false;
      if(params[6] == 0) Light.portal.allowSignIn=false;
      if(params[7] == 0) Light.portal.allowTurnOff=false;
      if(params[8] == 0) Light.portal.allowChangeLocale=false;
      if(params[9] == 0) Light.portal.portletWindowTransparent=false;
      Light.locale = params[10];
      Light.portal.bgImage =  params[11];
      Light.portal.newBgImage = "";  
      Light.portal.bgPosition = params[12]; 
      Light.portal.bgRepeat = params[13]; 
      Light.portal.headerImage =  params[14]; 
      Light.portal.newHeaderImage=""; 
      Light.portal.headerPosition = params[15]; 
      Light.portal.headerRepeat = params[16];  
      Light.portal.headerHeight =  params[17];  
      Light.portal.fontSize =  params[18]; 
      if(params[19] == 0) Light.portal.showSearchBar=false;
      Light.portal.defaultSearchEngine =  params[20];  
      Light.portal.textColor =  params[21];  
      Light.portal.textFont =  params[22];   
      Light.portal.theme = params[23];
      Light.portal.logo = params[24];
	  if(Light.portal.logo == null || Light.portal.logo.length <=0) Light.portal.logo='/light/images/logo.png';
        if(params.length > 25){
	      var musicUrl = params[25];     
	 	  if(musicUrl != "none"){
	 	  	playMusic(musicUrl);
	 	  } 
 	  }	  	   
      Light.setTextFont();
      this.container = this.createPortalContainer();
      this.header = Light.service.getPortalHeader(this); 
      this.menu = Light.service.getPortalMenu(this); 
      this.body = this.createPortalBody();
      this.footer = Light.service.getPortalFooter(this);
      this.container.appendChild(this.header);
      this.container.appendChild(this.menu);      
      this.container.appendChild(this.body);
      this.container.appendChild(this.footer); 
      document.body.appendChild(this.container);      
      Light.setCookie(Light._ON,"on");
      this.turnedOn= true;
      this.getPortalTabsByUser();
      Light.refreshTextColor();   
}
LightPortal.prototype.getPortalTabsByUser = function(){
   var opt = {
    method: 'get',
    onSuccess: function(t) {
        Light.portal.getPortalTabsByUserHandler(t);
    },
    on404: function(t) {
        alert('Error 404: location "' + t.statusText + '" was not found.');
    },
    onFailure: function(t) {
        alert('Error ' + t.status + ' -- ' + t.statusText);
    }
   }
   Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortalTabsByVisitRequest, opt);
}
LightPortal.prototype.getPortalTabsByUserHandler = function(t){  
	  var defaultTab = 0;
      var responseText = t.responseText; 
      var portalTabs = responseText.split(";");
      for(var i=0;i<portalTabs.length;i++){ 
          var vPortalTab = eval(portalTabs[i]); 
          vPortalTab.parent = this;
          vPortalTab.tabList = "tabList";
          vPortalTab.tabPanels = "tabPanels";         
          vPortalTab.open(vPortalTab);
          this.tabs[i]=vPortalTab;   
          if(vPortalTab.defaulted)
             defaultTab = i;       
      }          
      this.tabs[defaultTab].focus(); 
      this.tabs[defaultTab].refresh(); 
      if(portalTabs.length <= 1 && !Light.portal.allowAddTab)
      	this.tabs[0].hide();
      Light.autoListenServer(); 
      
      var loadDiv= document.getElementById("loadingDiv");  
   	  document.body.removeChild(loadDiv);  
}
