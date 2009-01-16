//------------------------------------------------------------ lightPortalGroup.js
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
	  var userId = Light.getCookie(Light._LOGINED_USER_ID);    
     var opt = {
    	method: 'post',
    	postBody: 'userId='+escape(encodeURIComponent(userId)),
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
     Light.ajax.sendRequest(Light.checkGroupRequest, opt);        
}
LightPortal.prototype.turnOnPortalHandler = function(t){
  var groupId = t.responseText;
  if(groupId != "-1"){
    this.turnOnGroup(groupId);
  }else{
    alert('Error: this Group is not avaliable.');
  }
}
LightPortal.prototype.turnOnGroup = function(groupId){  
  var opt = {
    method: 'post',
    postBody: 'userId='+escape(encodeURIComponent(groupId)),
    onSuccess: function(t) {
        Light.portal.turnOnGroupHandler(t);
    },
    on404: function(t) {
        alert('Error 404: location "' + t.statusText + '" was not found.');
    },
    onFailure: function(t) {
        alert('Error ' + t.status + ' -- ' + t.statusText);
    }
   }
   Light.ajax.sendRequest(Light.groupPortalRequest, opt);   
}
LightPortal.prototype.turnOnGroupHandler = function(t){     
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
      this.getPortalTabs();
      Light.refreshTextColor();      
}
LightPortal.prototype.getPortalTabs = function(){
   var opt = {
    method: 'post',
    postBody: '',
    onSuccess: function(t) {
        Light.portal.getPortalTabsHander(t);
    },
    on404: function(t) {
        alert('Error 404: location "' + t.statusText + '" was not found.');
    },
    onFailure: function(t) {
        alert('Error ' + t.status + ' -- ' + t.statusText);
    }
   }
   Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortalTabsByGroupRequest, opt);
}
LightPortal.prototype.getPortalTabsHander = function(t){  
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
      if(Light.portal.allowAddTab)       
         this.addTabMenu();
      this.tabs[defaultTab].focus(); 
      this.tabs[defaultTab].refresh(); 
      if(portalTabs.length <= 1 && !Light.portal.allowAddTab)
      	this.tabs[0].hide();
      Light.autoListenServer();       
      var loadDiv= document.getElementById("loadingDiv");  
   	  document.body.removeChild(loadDiv);  
}
//------------------------------------------------------------ lightPortalGroup.js
function joinToGroup2(e,id){
   var userId = Light.getCookie(Light._LOGINED_USER_ID);
  //if user if not logined, login first.
  if(userId == null || userId ==""){
     Light.portal.latestAction.event =e;
     Light.portal.latestAction.id = id;
     Light.portal.latestAction.method="joinToGroup2";
     Light.login();
     return;
  }        
   var params = "&responseId="+id;
   Light.ajax.sendRequest(Light.portal.contextPath+Light.joinToGroup, {parameters:params,onSuccess:responseJoinToGroup2}); 
}

function responseJoinToGroup2(t){      
      var params = t.responseText.split(";");  
      if(params[0] == 1){
        window.location.reload(true);
      }else{
       var data = {
    	title : $('_CLOSE').title,
        ok : $('_BUTTON_OK').title,    	
        cancel : $('_BUTTON_CANCEL').title,
        popupName :'joinToGroup'
       };                       
       createPopupDiv('joinToGroup','joinToGroup'+params[0]+'.jst',280,data,null,null); 
     }
}

function uploadGroupPictures2(e,groupId,id){
  var portlet = new PortletPopupWindow(11,300,400,$('_MENU_GROUP_UPLOAD_PICTURE').title,"","","groupPicturePortlet",Light.portal.contextPath+"/groupPicturePortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"groupId="+groupId);    
  portlet.refresh();
}

function groupPrivacy(e,groupId,id){      
       
  var params = "&groupId="+groupId;
  Light.ajax.sendRequest(Light.portal.contextPath+Light.getGroupPrivacy, {parameters:params,onSuccess:responseGroupPrivacy});           
       
}

function responseGroupPrivacy(t){ 
   var params = t.responseText.split(";");    
   var data = {
    	title : $('_CLOSE').title,
        ok : $('_BUTTON_OK').title,    	
        cancel : $('_BUTTON_CANCEL').title,
        popupName :'groupPrivacy',
        groupId : params[0],
        acceptLeaderBulletin : params[1],
        acceptMembersBulletin : params[2]
       };
   createPopupDiv('groupPrivacy','groupPrivacy.jst',280,data,null,null); 
}
function saveGroupPrivacy(id,groupId){ 
   
   var params = "groupId="+groupId;
   if(document.forms['form_'+id]['lBulletin'].checked)
     params+="&lBulletin="+document.forms['form_'+id]['lBulletin'].value;
   if(document.forms['form_'+id]['mBulletin'].checked)
     params+="&mBulletin="+document.forms['form_'+id]['mBulletin'].value;
   Light.ajax.sendRequest(Light.portal.contextPath+Light.saveGroupPrivacy, {parameters:params,onSuccess:responseSaveGroupPrivacy});      
}

function responseSaveGroupPrivacy(t){ 
   var params = t.responseText.split(";");    
   var data = {
    	title : $('_CLOSE').title,
        ok : $('_BUTTON_OK').title,    	
        cancel : $('_BUTTON_CANCEL').title,
        popupName :'savePrivacy' 
       };
   createPopupDiv('savePrivacy','savePrivacy.jst',280,data,null,null); 
}

function responseResignGroup(t){    
  Light.portal.logout();
}

function responseDeleteGroupProfile(t){    
  var params = t.responseText.split(";");    
  if(params[0] != 0)
    Light.portal.logout();
  else
    alert("You cannot delete this group, because this group has members.");
}

function viewGroupCategory(e,categoryId,id){
   var userId = Light.getCookie(Light._LOGINED_USER_ID);
  //if user if not logined, login first.
  if(userId == null || userId ==""){
     Light.portal.latestAction.event =e;
     Light.portal.latestAction.id = id;
     Light.portal.latestAction.method="viewGroupCategory";
     Light.login();
     return;
  }       
  var currentTabId = Light.getCurrentTabId();
  var index = currentTabId.substring(8,currentTabId.length);//tab id perfix tab_page 	
  var portlet = new PortletPopupWindow(11,300,400,$('_MENU_GROUP').title,"","","groupPortlet",Light.portal.contextPath+"/groupPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"type=joinDetail&parameter="+categoryId);    
  portlet.mode =Light._EDIT_MODE;
  portlet.refresh();
}
