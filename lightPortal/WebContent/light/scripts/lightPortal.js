//------------------------------------------------------------ lightPortal.js
function LightPortal() {
  var screenWidth = document.documentElement.scrollWidth;
  if(screenWidth < 1000) screenWidth = 1000;
  var barWidth = screenWidth / 6;  
  var windowHeight = document.documentElement.scrollHeight;  

  this.layout={
	  	normalTop: 60,
	  	bgLeft: 0,
		bgWidth: screenWidth, 
	  	containerLeft: barWidth / 2,
	  	containerTop : 0, 
	  	bodyLeft : 0,
	  	bodyTop : 80,
	  	footerLeft :10,
	   	maxLeft  : 0,
    	maxTop   : 40, 
    	maxWidth : screenWidth - barWidth,
    	maxHeight : windowHeight,
    	minHeight : 40,
        scrollbarWidth : 21,
        footerHeightMargin : 200,
        barWidth : barWidth    
  }
  
  this.tabs= new Array();  
  this.turnedOn= false;   
  this.moveTimer = -1;
  this.dragDropPortlet = null;

  this.highLight= document.createElement('div'); 
  var color="#ff0000";
  this.highLight.style.borderWidth="1px";
  this.highLight.style.borderStyle="dashed";
  this.highLight.style.borderColor= color;
  if (document.all) {	
           this.highLight.style.posLeft = 0;
       	   this.highLight.style.posTop = 0;
  }else {        
           this.highLight.style.left = 0;
           this.highLight.style.top = 0;
  }
  this.highLight.style.width = 0;
  this.highLight.style.height= 0;
  this.highLight.style.position = "absolute";
  this.userId = null;
  this.allTabs = new Array();
  this.allPortlets = new Array();
  this.currentTab = null;
  this.needReload = false;
  this.latestAction={
	  	event: null,
	  	id: null,
        method: null,
        portlet: null
  } 
}

LightPortal.prototype.turnOn = function(){
  var vLoading= document.createElement('div');   
  vLoading.className = "loading";   
  vLoading.id = "loadingDiv";
  vLoading.innerHTML=Light.getViewTemplate("loading.view");
  document.body.appendChild(vLoading); 
    
  document.body.ondragstart = function() { return false };
  document.body.onmousemove = function(e) {
    if(Light.portal.moveTimer == -1) return;
    if (document.all) e = event;
    if(Light.portal.dragDropPortlet != null) {
      Light.portal.dragDropPortlet.move(e);
    }
    return false;
  };
  document.body.onmouseup = function(e) {
    Light.portal.moveTimer = -1;
    if (document.all) e = event;
    if(Light.portal.dragDropPortlet != null) {
      Light.portal.dragDropPortlet.moveEnd(e);
      Light.portal.dragDropPortlet = null;
      document.body.onselectstart = null;
      document.body.ondragstart = null;
    }
    return false;
  };
  if(this.originalLeft != null){
   	this.layout.containerLeft = this.originalLeft;
	this.originalLeft = null; 
  }
  this.turnOnPortal();
}
LightPortal.prototype.turnOnPortal = function(){ 
	if(this.needReload){
		this.loadPortal();
		this.needLoad = false;
	}else{
	    if($('loginUserId').title != 0){
	    	Light.setCookie(Light._LOGINED_USER_ID, $('loginUserId').title);
		}else{
			Light.deleteCookie(Light._LOGINED_USER_ID);
			Light.deleteCookie(Light._CURRENT_TAB);
		}
		Light.portal.renderPortal($('portalString').title);
		Light.portal.renderPortalTab($('pageRoot').title);   
	}
}
LightPortal.prototype.loadPortal = function(){ 
   var userId = Light.getCookie(Light._REMEMBERED_USER_ID);
   var password = Light.getCookie(Light._REMEMBERED_USER_PASSWORD);
   log("turnOnPortal:"+userId);
   var params = "check=1";
   if( userId != null && userId != "" && password != null && password != "" 
   && (Light.getCookie(Light._IS_SIGN_OUT) == null || Light.getCookie(Light._IS_SIGN_OUT) == "")){
       params = "userId="+escape(encodeURIComponent(userId))  
  	          +"&password="+escape(encodeURIComponent(password));
   }   
   var opt = {
	    method: 'post',
	    parameters: params,
	    onSuccess: function(t) {
	        Light.portal.loadPortalHandler(t);
	    },
	    on404: function(t) {
	        alert('Error 404: location "' + t.statusText + '" was not found.');
	    },
	    onFailure: function(t) {
	        alert('Error ' + t.status + ' -- ' + t.statusText);
	    }
	 }
   Light.ajax.sendRequest(Light.checkLoginRequest, opt);         
}
LightPortal.prototype.loadPortalHandler = function(t){
   var content = t.responseText;
   var params = content.split("|"); 
   if(params[0] != "0"){
      Light.userId = params[0];
   	  Light.setCookie(Light._LOGINED_USER_ID,Light.userId);  
   }else{
   	  Light.deleteCookie(Light._LOGINED_USER_ID);
   }
   Light.portal.renderPortal(params[1]);
   Light.portal.renderPortalTab(params[2]);   
} 

LightPortal.prototype.renderPortal = function(myPortal){ 
      log("renderPortal:"+myPortal);    
      var params = myPortal.split(",");
      Light.portal.contextPath = params[0]; 
      if(Light.portal.contextPath.length == 0)
         Light.portal.contextPath= Light._DEFAULT_CONTEXT_PATH;
      Light.portal.title=params[1];       
      Light.portal.allowLookAndFeel=true;      
      Light.portal.allowLayout=false;
      Light.portal.allowAddTab=true;
      Light.portal.allowAddContent=true;
      Light.portal.allowSignIn=true;
      Light.portal.allowTurnOff=true; 
      Light.portal.allowChangeLocale=true; 
      Light.portal.portletWindowTransparent = true;
      if(params[2] == 0) Light.portal.allowLookAndFeel=false;
      //if(params[3] == 0) Light.portal.allowLayout=false;
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
      Light.portal.showSearchBar = true;
      if(params[19] == 0) Light.portal.showSearchBar=false;
      Light.portal.defaultSearchEngine =  params[20];  
      Light.portal.textColor =  params[21]; 
      Light.portal.textFont =  params[22];  
      Light.portal.theme = params[23];
      if(Light.portal.theme != null){ 
          var themeCss = Light.getThemePath()+'/theme.css';
	      if(document.all)
			themeCss = Light.getThemePath()+'/MSIE/theme.css';      
	      if(document.getElementsByTagName('link')[1] != null &&
	         document.getElementsByTagName('link')[1].href != themeCss)
	      	document.getElementsByTagName('link')[1].href = themeCss;
	  }
	  Light.portal.logo = params[24];
	  if(Light.portal.logo == null || Light.portal.logo.length <=0) Light.portal.logo='/light/images/logo.png';
      this.maxShowTabs = parseInt(params[25]);//10;
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
      this.startTab=0;
      //this.getPortalTabsByUser();	        	  
}

LightPortal.prototype.getPortalTabsByUser = function(){    
   var myPortalTab = Light.getCookie(Light._GUEST_PORTAL_TAB);
   log("getPortalTabsByUser:"+myPortalTab); 
   if(Light.getCookie(Light._LOGINED_USER_ID) != null)
      myPortalTab = Light.getCookie(Light._MY_PORTAL_TAB);
   if(myPortalTab == null){
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
	   Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortalTabsByUserRequest, opt);
	}else{
	   this.renderPortalTab(myPortalTab);
	}
}
LightPortal.prototype.getPortalTabsByUserHandler = function(t){
   Light.portal.renderPortalTab(t.responseText);
   var date = new Date(); 
   var timestamp = Date.parse(date);      
   date.setFullYear(date.getFullYear()+1);
   userId = timestamp;
   if(Light.getCookie(Light._LOGINED_USER_ID) != null)
      Light.setCookie(Light._MY_PORTAL_TAB,t.responseText,date);   
   else
      Light.setCookie(Light._GUEST_PORTAL_TAB,t.responseText,date);   
   
}  
LightPortal.prototype.renderPortalTab = function(myPortalTabs){ 
      log("renderPortalTab:"+myPortalTabs); 
	  var portalTabs = myPortalTabs.split(";");
	  var defaultTab = 0;
	  var defaultTabs = null;
      if(Light.getCookie(Light._CURRENT_TAB) != null && Light.getCookie(Light._CURRENT_TAB) != "" ){
      	  defaultTab = Light.getCookie(Light._CURRENT_TAB);
      	  defaultTabs = defaultTab.split("-");
      	  if(defaultTabs.length > 0 && defaultTabs[0] < portalTabs.length){
      	     defaultTab = parseInt(defaultTabs[0]);
      	  }    	  
      }
      if(defaultTab >= portalTabs.length) defaultTab = 0;
      if(defaultTab >= this.maxShowTabs) this.startTab=defaultTab + 1 - this.maxShowTabs;
      if(portalTabs.length > this.maxShowTabs) this.addLeftButton();
      for(var i=0;i<portalTabs.length;i++){ 
          var vPortalTab = eval(portalTabs[i]);
          vPortalTab.parent = this;
          vPortalTab.tabList = "tabList";
          vPortalTab.tabPanels = "tabPanels";    
          if(i >= this.startTab && i < this.maxShowTabs + this.startTab)      
          	vPortalTab.open(vPortalTab);
          this.tabs[i]=vPortalTab;   
          if(vPortalTab.defaulted)
             defaultTab = i;       
      } 
      if(portalTabs.length > this.maxShowTabs) this.addRightButton();         
      this.addTabMenu();
      
      if(defaultTabs != null && defaultTabs.length > 1){  
  	     var defaultSubTabs = "";
  	     for(var i=1;i<defaultTabs.length;i++){
  	        if(i == 1)
  	           defaultSubTabs=defaultTabs[i];
  	        else
  	           defaultSubTabs+="-"+defaultTabs[i];
  	     }
  	  	 this.tabs[defaultTab].defaultTab = defaultSubTabs;
  	  }
  	  if(!this.tabs[defaultTab].opened) this.tabs[defaultTab].open(this.tabs[defaultTab]);
      this.tabs[defaultTab].focus(); 
      this.tabs[defaultTab].refresh(); 
      if(portalTabs.length <= 1 && !Light.portal.allowAddTab)
      	this.tabs[0].hide(); 
      Light.autoListenServer(); 
     
      var loadDiv= document.getElementById("loadingDiv");  
   	  document.body.removeChild(loadDiv);
   	  Light.refreshTextColor();  
   	  log("renderPortalTab: done"); 
}

LightPortal.prototype.addLeftButton = function(){
   
		var newLabel = document.createElement('span');
		newLabel.setAttribute("id", "tabSpan" + "");
		newLabel.className = "";
		newLabel.style.marginTop="5px";	         		
		var clsA = document.createElement('img');
		clsA.src = Light.getThemePath()+'/images/previous.gif';
		clsA.title = $('_BUTTON_PREVIOUS').title;
		clsA.className =  "portal-tab-button";
		clsA.style.height=16;
		clsA.style.width=16;
		clsA.align="middle";
		newLabel.appendChild(clsA);
		newLabel.onclick = function () { 	   
		    focusLeftTab();
		}
		
		document.getElementById('tabs').insertBefore(newLabel,document.getElementById('tabList'));		
}

LightPortal.prototype.addRightButton = function(){
   
		var newLabel = document.createElement('span');
		newLabel.setAttribute("id", "tabSpan" + "");
		newLabel.className = "";
		newLabel.setAttribute("tabColor", "");	         		
		var clsA = document.createElement('img');
		clsA.src = Light.getThemePath()+'/images/next.gif';
		clsA.title = $('_BUTTON_NEXT').title;
		clsA.className =  "portal-tab-button";
		clsA.style.height=16;
		clsA.style.width=16;
		clsA.align="middle";
		newLabel.appendChild(clsA);
		newLabel.onclick = function () { 	   
		   focusRightTab(); 
		}
		
		document.getElementById('tabs').appendChild(newLabel);		
}

LightPortal.prototype.addTabMenu = function(){
   if(Light.portal.allowAddTab){
		var newLabel = document.createElement('span');
		newLabel.setAttribute("id", "tabSpan" + "");
		newLabel.className = "";
		newLabel.setAttribute("tabColor", "");	         		
		var clsA = document.createElement('img');
		clsA.src = Light.getThemePath()+'/images/add.gif';
		clsA.title = $('_MENU_ADD_TAB').title;
		clsA.className =  "portal-tab-button";
		clsA.style.height=16;
		clsA.style.width=16;
		clsA.align="middle";
		newLabel.appendChild(clsA);
		/*
		var vButton = document.createElement('div');
		vButton.className = "portal-tab-handle";
		vButton.innerHTML = "<a href='javascript:void(0);'>" + $('_MENU_ADD_TAB').title+"</a>";
		newLabel.appendChild(vButton);
	   	*/	
		var newTab = document.createElement('li');
		newTab.className = this.tabColor;
	    newTab.id = "tabMenuAddTab";
		newTab.setAttribute("id", "tabMenuAddTab");
		newTab.setAttribute("tabId", "");
		newTab.setAttribute("tabLabel", $('_MENU_ADD_TAB').title);
		newTab.setAttribute("tabColor","");
		newTab.onclick = function () { 	   
		   addAutoTab(0); 
		}
		newTab.setAttribute("tabIsCloseable", "0");		
		newTab.setAttribute('isFocused','true');
		newTab.appendChild(newLabel);
		document.getElementById('tabList').appendChild(newTab);	
    }	
}
LightPortal.prototype.turnOff = function(){
   this.container.removeChild(this.header);
   this.container.removeChild(this.menu);
   this.container.removeChild(this.body);
   this.container.removeChild(this.footer);
   document.body.removeChild(this.container);      
   Light.deleteCookie(Light._ON);
   for(var i=0;i<this.tabs.length;i++){
      for(var j=0;j<this.tabs[i].portlets.length;j++){
   	      this.tabs[i].portlets[j]= new Array();
   	  }
   }
   this.tabs = new Array();
   this.allTabs = new Array();
   this.allPortlets = new Array();
   this.turnedOn= false;
   document.body.onselectstart = null;
   document.body.ondragstart = null;
   document.body.onmousemove = null;
   document.body.onmouseup = null;
}

LightPortal.prototype.createPortalContainer = function (){ 
   var vPortalContainer= document.createElement('div');   
   vPortalContainer.style.position = "absolute";
   vPortalContainer.className = "portal-container";   
   if(this.bgImage.length > 0){ 
      if(this.bgImage != "no"){
         vPortalContainer.style.backgroundColor= "";//"url('"+Light.portal.contextPath+this.bgImage+"')";
         var backgroundImage = this.bgImage;
         if(this.bgImage.indexOf("http") < 0)
         	backgroundImage = Light.portal.contextPath+this.bgImage;
         if(this.bgRepeat == 1)
	            document.body.style.background = "url('"+backgroundImage+"') no-repeat " + Light.portal.bgPosition;// no-repeat left top";
         else if(this.bgRepeat == 2)
         	document.body.style.background= "url('"+backgroundImage+"') repeat-x right top";
         else if(this.bgRepeat == 3)
         	document.body.style.background= "url('"+backgroundImage+"') repeat-y left top";
         else
         	document.body.style.background= "url('"+backgroundImage+"')";
      }else{
         vPortalContainer.style.backgroundColor= "";//"#ffffff";  
         document.body.style.background= "#ffffff";  
      }
   }
   vPortalContainer.style.fontSize=12 + parseInt(this.fontSize);
   vPortalContainer.style.width = Light.portal.layout.bgWidth;
   vPortalContainer.style.height = Light.portal.layout.maxHeight;
   vPortalContainer.style.zIndex= ++Light.maxZIndex;
   if (document.all) {	
       vPortalContainer.style.posLeft = Light.portal.layout.bgLeft;
       vPortalContainer.style.posTop = Light.portal.layout.containerTop;           
   }    
   else {        
       vPortalContainer.style.left = Light.portal.layout.bgLeft;
       vPortalContainer.style.top = Light.portal.layout.containerTop;      
   }    
   return vPortalContainer;
}
LightPortal.prototype.refreshPortalHeader = function(){
  this.container.removeChild(Light.portal.header);	
  this.header = Light.service.getPortalHeader(this);
  this.container.insertBefore(this.header,Light.portal.menu);
  Light.refreshTextColor();
}
LightPortal.prototype.editTitle = function(title){ 
  title.className= 'portal-header-title-edit';
  title.innerHTML= "<input type='text' id='portalTitle' class='portal-header-title-edit' value=\""+this.title+"\" onchange=\"javascript:Light.portal.saveTitle();\" onblur=\"javascript:Light.portal.saveTitle();\"/>";
  $('portalTitle').focus();
}

LightPortal.prototype.viewTitle = function(title){
  title.className= 'portal-header-title-view';
  title.style.backgroundColor =''; 
  title.innerHTML= this.title;
}

LightPortal.prototype.saveTitle = function(title){
  var title = $('portalTitle').value;
  this.title=title;
  this.refreshPortalHeader();
  var params = "title="+encodeURIComponent(title);
  Light.ajax.sendRequest(Light.portal.contextPath+Light.changeTitle, {parameters:params});
}

LightPortal.prototype.saveTabTitle = function(index){
	if($('portalTabTitle') == null) return;
	var title = $('portalTabTitle').value;
	var currentTab = this.tabs[index];//Light.currentTab;
	currentTab.editTitle=false;
	var vButton = document.createElement('div');
	vButton.className = "portal-tab-handle";
	vButton.innerHTML = title;
	vButton.onclick = function () { 	   
	   currentTab.focus(); 
	   currentTab.refresh(); 
	}
	document.getElementById("tabSpan" + currentTab.tabServerId).innerHTML ="";
	document.getElementById("tabSpan" + currentTab.tabServerId).appendChild(vButton);
	$(currentTab.tabId).setAttribute("tabLabel", title);
	if(currentTab.tabIsEditable){
		var addA = document.createElement('img');
		addA.src = Light.getThemePath()+'/images/add.gif';
		addA.className =  "portal-tab-button";
		addA.style.height=16;
		addA.style.width=16;
		addA.align="middle";
		addA.onclick = function(){
			currentTab.addSubPage();
		}
		document.getElementById("tabSpan" + currentTab.tabServerId).appendChild(addA);
	}
	if(currentTab.tabIsCloseable){
      var clsA = document.createElement('img');
      clsA.src = Light.portal.contextPath+'/light/images/closeTab.gif';
      clsA.className =  "portal-tab-button";
      clsA.onclick = function(){
        currentTab.close();
      }
      document.getElementById("tabSpan" + currentTab.tabServerId).appendChild(clsA);
    }
    var params = "title="+encodeURIComponent(title)
               +"&tabId="+currentTab.tabServerId
               ;
    Light.ajax.sendRequest(Light.portal.contextPath+Light.editTabTitleRequest,{parameters:params});
}
LightPortal.prototype.refreshPortalMenu = function(tab){
	this.container.removeChild(this.menu);
	this.menu = Light.service.getPortalMenu(this); 
	this.container.insertBefore(this.menu,this.body);
}
LightPortal.prototype.createPortalBody = function (){
   var vBody = document.createElement('div');   
   vBody.id = "portalBody";
   vBody.className = "portal-body"; 
   vBody.style.position = "absolute";   
   if(Light.portal.portletWindowTransparent == false)
	   vBody.innerHTML="<div id='tabs' class='portal-tabs' ><ul id='tabList'></ul></div><div id='tabPanels' class='portal-tab-panels' ></div>";
   else
   	   vBody.innerHTML="<div id='tabs' class='portal-tabs2' ><ul id='tabList'></ul></div><div id='tabPanels' class='portal-tab-panels' ></div>";
   vBody.style.zIndex= ++Light.maxZIndex;
   vBody.style.width = Light.portal.layout.maxWidth;
   vBody.style.marginLeft = this.layout.containerLeft + this.layout.bodyLeft;   
   return vBody;
}
LightPortal.prototype.resize = function (){
	var screenWidth = document.documentElement.scrollWidth;
	if(document.all)
		screenWidth = screenWidth - Light.portal.layout.scrollbarWidth;
	var barWidth = screenWidth / 6; 
  	var windowWidth = screenWidth - barWidth;
	if(windowWidth < 1000) windowWidth = 1000;
	Light.portal.layout.maxWidth = windowWidth;
	Light.portal.layout.maxHeight = document.documentElement.scrollHeight;
	Light.portal.layout.bgWidth = screenWidth;
	Light.portal.layout.barWidth = barWidth;
	Light.portal.layout.containerLeft= barWidth / 2;
	Light.portal.container.style.width = Light.portal.layout.bgWidth;
	Light.portal.container.style.height = Light.portal.layout.maxHeight;
	var currentTab = Light.getCurrentTab();  
	this.refreshPortalMenu(currentTab);
	currentTab.resize();
}

LightPortal.prototype.collapseAll = function (){	
 	Light.getCurrentTab().collapseAll(); 	
}

LightPortal.prototype.expandAll = function (){
 	Light.getCurrentTab().expandAll(); 	
}


//------------------------------------------------------------ LightPortalSystemFunction.js
function responseResignGroup(t){    
  var responseId = t.responseText; 
  var portlet = Light.getPortletById(responseId);
  if(portlet != null)
     portlet.refresh(); 
}


function responseDeleteGroupProfile(t){ 
  var params = t.responseText.split(";");    
  if(params[0] != 0){
   var portlet = Light.getPortletById(params[1]);
  if(portlet != null)
     portlet.refresh(); 
  }else
    alert("You cannot delete this group, because this group has members.");   
  var responseId = t.responseText; 
  
}