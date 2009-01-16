//------------------------------------------------------------ lightPortalTab.js
LightPortalTab = function (index,tabId,tabServerId, tabLabel, tabURL, tabIsCloseable, tabIsEditable, tabIsMoveable, allowAddContent, tabColor, defaulted, between, widths, fitScreen, windowAppearanceType, parentId) {
   Light.portal.allTabs[Light.portal.allTabs.size()]=this;
   this.index = index;
   this.tabId=tabId;
   this.tabServerId = tabServerId;
   this.tabLabel = tabLabel;
   this.tabURL=tabURL;
   this.tabIsCloseable = tabIsCloseable;
   this.tabIsEditable = tabIsEditable;
   this.tabIsMoveable  = tabIsMoveable
   this.allowAddContent = allowAddContent;
   this.tabColor = tabColor;
   this.defaulted = defaulted;
   this.between = between;
   this.widths = widths;
   this.fitScreen = fitScreen;
   var type = windowAppearanceType.substring(windowAppearanceType.length - 1);
   if(!type.charAt(0).isDigit()) { type="1";}
   this.portletWindowAppearance = "WindowAppearance"+type;
   this.parentId = parentId;
   this.portlets = new Array();   
   this.loaded = false;
   this.editTitle= false;
   this.tabs= new Array();  
   var totalWidth = 0;
   for(var i=0;i<widths.length;i++){
		totalWidth+=widths[i]+between;
   }
   if(fitScreen == 1){      
	   totalWidth+=between;
	   if(Light.portal.layout.maxWidth > totalWidth){
	     var diff = Light.portal.layout.maxWidth - totalWidth;
	     var eachD = parseInt(diff / widths.length);
	     for(var i=0;i<widths.length;i++){
	       widths[i]+=eachD;
	     }
	   }
	   if(Light.portal.layout.maxWidth < totalWidth){
	     var diff = totalWidth - Light.portal.layout.maxWidth;
	     var eachD = diff / widths.length;
	     for(var i=0;i<widths.length;i++){
	       widths[i]-=eachD;
	     }
	   }
   }
   this.opened = false;
   log("new portal tab");
}
LightPortalTab.prototype.open = function(portalTab,next){	
	var newLabel = document.createElement('span');
	newLabel.setAttribute("id", "tabSpan" + this.tabServerId);
	newLabel.className = this.tabColor;
	newLabel.setAttribute("tabColor", this.tabColor);
	var vButton = document.createElement('div');
	vButton.className = "portal-tab-handle";
	vButton.innerHTML = this.tabLabel; 
	vButton.onclick = function () { 	   
	   portalTab.focus(); 
	   portalTab.refresh(); 
	}
	newLabel.appendChild(vButton);
	
	var newTab = document.createElement('li');
	newTab.className = this.tabColor;
	newTab.setAttribute("id", this.tabId);
	newTab.setAttribute("tabId", this.tabServerId);
	newTab.setAttribute("tabLabel", this.tabLabel);
	newTab.setAttribute("tabColor", this.tabColor);
	
	newTab.setAttribute("tabIsCloseable", "0");	
	if (this.tabIsCloseable){
		newTab.setAttribute("tabIsCloseable", "1");
	}
	newTab.setAttribute('isFocused','true');	
	newTab.appendChild(newLabel);
	this.tabContainer = newTab;
	var lastOne = document.getElementById('tabMenuAddTab');
	if(portalTab.parentId > 0)	
       lastOne = document.getElementById('tabMenuAddTab'+portalTab.parent.tabServerId);	
	if(next != null){
		document.getElementById(portalTab.tabList).insertBefore(newTab,next.tabContainer);	  
	}else{
		if(lastOne != null)
			document.getElementById(portalTab.tabList).insertBefore(newTab,lastOne);	  
		else
			document.getElementById(portalTab.tabList).appendChild(newTab);		
	}
	// create the panel
	var newPanel = document.createElement('div');
	newPanel.setAttribute('id','panel_' + this.tabServerId);
	newPanel.setAttribute("panelURL", this.tabURL);
	newPanel.setAttribute("tabColor", this.tabColor);
	newPanel.className = this.tabColor + "Panel";	
	/* newPanel.style.display = "none"; */	
	if(next != null){
		document.getElementById(portalTab.tabPanels).insertBefore(newPanel,next.panelContainer);	  
	}else{
		document.getElementById(portalTab.tabPanels).appendChild(newPanel);
	}
	this.panelContainer = newPanel;
	this.opened=true;
}
LightPortalTab.prototype.insert = function(portalTab){
   // create the tab
	var newLabel = document.createElement('span');
	newLabel.setAttribute("id", "tabSpan" + this.tabServerId);
	newLabel.className = this.tabColor;
	newLabel.setAttribute("tabColor", this.tabColor);
	var vButton = document.createElement('div');
	vButton.className = "portal-tab-handle";
	vButton.innerHTML = this.tabLabel;
	vButton.onclick = function () { 	   
	   portalTab.focus(); 
	   portalTab.refresh(); 
	}
	newLabel.appendChild(vButton);
	
	var newTab = document.createElement('li');
	newTab.className = this.tabColor;
	newTab.setAttribute("id", this.tabId);
	newTab.setAttribute("tabId", this.tabServerId);
	newTab.setAttribute("tabLabel", this.tabLabel);
	newTab.setAttribute("tabColor", this.tabColor);
	
	newTab.setAttribute("tabIsCloseable", "0");	
	if (this.tabIsCloseable){
		newTab.setAttribute("tabIsCloseable", "1");
	}
	newTab.setAttribute('isFocused','true');
	newTab.appendChild(newLabel);
    var lastOne = document.getElementById('tabMenuAddTab');
    if(portalTab.parentId > 0)	
       lastOne = document.getElementById('tabMenuAddTab'+portalTab.parent.tabServerId);	
	this.tabContainer = newTab;
	document.getElementById(portalTab.tabList).insertBefore(newTab,lastOne);	  
	// create the panel
	var newPanel = document.createElement('div');
	newPanel.setAttribute('id','panel_' + this.tabServerId);
	newPanel.setAttribute("panelURL", this.tabURL);
	newPanel.setAttribute("tabColor", this.tabColor);
	newPanel.className = this.tabColor + "Panel";	
	/* newPanel.style.display = "none"; */
	document.getElementById(portalTab.tabPanels).appendChild(newPanel);
	this.panelContainer = newPanel;
	portalTab.focus(); 
	portalTab.refresh(); 
}
LightPortalTab.prototype.hide = function(){
   document.getElementById(this.tabList).style.visibility = "hidden"
}
LightPortalTab.prototype.getFocusId = function(){
	if(this.parent == Light.portal){
	   return this.index;
	}else{
	   return this.parent.getFocusId()+"-"+this.index;
	}
}
LightPortalTab.prototype.focus = function(){
   Light.currentTab = this;
   Light.setCookie(Light._CURRENT_TAB,this.getFocusId());
   var currentTabId = Light.getCurrentTabId();
   var tabList = document.getElementById(this.tabList);
   var len = tabList.childNodes.length;
   if(Light.portal.allowAddTab)
	   len = len - 1;
   for (var j=0; j < len; j++){  
       if (tabList.childNodes[j] && tabList.childNodes[j].tagName == "LI" ){
           var className = tabList.childNodes[j].getAttribute("tabColor");
           var currentTabId = tabList.childNodes[j].getAttribute("tabId");
           if (currentTabId == this.tabServerId){
               if(tabList.childNodes[j].className != className + "current"){
                   tabList.childNodes[j].className = className + "current";
                   document.getElementById("tabSpan" + currentTabId).className = className + "current";
                   document.getElementById("panel_" + currentTabId).style.display = "block";
                   if(this.tabIsEditable){
						var addA = document.createElement('img');
						addA.src = Light.getThemePath()+'/images/add.gif';
						addA.title = $('_MENU_ADD_SUBTAB').title;
						addA.className =  "portal-tab-button";
						addA.style.height=16;
						addA.style.width=16;
						addA.align="middle";
						addA.onclick = function(){
							Light.currentTab.addSubPage();
						}
						document.getElementById("tabSpan" + tabList.childNodes[j].getAttribute("tabId")).appendChild(addA);
					}
					if (this.tabIsCloseable){		         
					   var clsA = document.createElement('img');
					   clsA.src = Light.getThemePath()+'/images/closeTab.gif';
					   clsA.title = $('_CLOSE').title;
					   clsA.className =  "portal-tab-button";
					   clsA.onclick = function(){
					       Light.currentTab.close();
					   }
					   document.getElementById("tabSpan" + tabList.childNodes[j].getAttribute("tabId")).appendChild(clsA);
					}
               }else if(this.tabIsEditable && !this.editTitle){
                   this.editTitle = true;
                   document.getElementById("tabSpan" + tabList.childNodes[j].getAttribute("tabId")).innerHTML="<input type='text' id='portalTabTitle' size='12' value=\""+tabList.childNodes[j].getAttribute("tabLabel")+"\" onchange=\"javascript:Light.portal.saveTabTitle("+this.index+");\" onblur=\"javascript:Light.portal.saveTabTitle("+this.index+");\"/>";                            
                   document.getElementById('portalTabTitle').focus();
               }               
           }
           else{
               tabList.childNodes[j].className = className;
               document.getElementById("tabSpan" + tabList.childNodes[j].getAttribute("tabId")).className = className;
               document.getElementById("tabSpan" + tabList.childNodes[j].getAttribute("tabId")).style.paddingBottom=10;
               document.getElementById("panel_" + currentTabId).style.display = "none";
               var nodes = document.getElementById("tabSpan" + tabList.childNodes[j].getAttribute("tabId")).childNodes;
               for (var i=nodes.length - 1; i >=0; i--){
               		if(nodes[i].tagName == "img" || nodes[i].tagName == "IMG")
               		   document.getElementById("tabSpan" + tabList.childNodes[j].getAttribute("tabId")).removeChild(nodes[i]);
               }
           }
       }
   }   
}
LightPortalTab.prototype.refresh = function(){
	if(!this.loaded){
	   	this.getSubTabs(); 
	   	//this.getPortletsByTab(this.index);  
	   this.loaded = true;
	}else{
	   this.rePositionAll();
	}
	Light.portal.refreshPortalMenu(this);
}
LightPortalTab.prototype.close = function(){
	var lastTabId = "";
	var somethingHasFocus = false;
	
	var closeTab = confirm($('_COMMAND_CLOSE_TAB').title);
	if (!closeTab){ // user cancelled close tab
		return;
	}	
	/* Remove the tab */
	var tabList = document.getElementById(this.tabList);
	for (i=0; i < tabList.childNodes.length; i++){
		if (tabList.childNodes[i] && tabList.childNodes[i].tagName == "LI" ){
			if (tabList.childNodes[i].getAttribute('tabId') == this.tabServerId){
				tabList.removeChild(tabList.childNodes[i]);
			}
		}
	}
	/* Remove the panel */
	var panelList = document.getElementById(this.tabPanels);
	for (i=0; i < panelList.childNodes.length; i++){
		if (panelList.childNodes[i] && panelList.childNodes[i].tagName == "DIV" ){
			if (panelList.childNodes[i].getAttribute('id') == "panel_" + this.tabServerId){
				panelList.removeChild(panelList.childNodes[i]);
			}
		}
	}
	// If we closed the tab that had focus, focus on another tab.
	if(tabList.childNodes.length == 1 && Light.portal.allowAddTab){
		tabList.removeChild(tabList.childNodes[0]);
		var focusId = Light.getCookie(Light._CURRENT_TAB);
	    Light.setCookie(Light._CURRENT_TAB,focusId.substring(0,focusId.lastIndexOf("-")));
	    Light.currentTab = Light.getTabById(this.parentId);
	}
	for (i=0; i < tabList.childNodes.length - 1; i++){
		if (tabList.childNodes[i] && tabList.childNodes[i].tagName == "LI" ){
			lastTabId = tabList.childNodes[i].getAttribute('tabId');
			if (tabList.childNodes[i].getAttribute('tabColor') + "current" == tabList.childNodes[i].className){
				somethingHasFocus = true;
			}
		}
	}
	if (!somethingHasFocus && lastTabId != ""){
		var lastTab =Light.getTabById(lastTabId);	    
		Light.getTabById(lastTabId).focus();
		if(!lastTab.loaded){
			lastTab.refresh();
	    }
	}
   Light.ajax.sendRequest(Light.portal.contextPath+Light.deleteTabRequest, {parameters:'tabId='+this.tabServerId});  
}
LightPortalTab.prototype.getSubTabs = function(){
   var tabId = this.tabServerId;
   if($('page'+tabId) != null){
   		this.renderSubTabs($('page'+tabId).title);
   		return;
   }
   var currentTab = this;
   var opt = {
    method: 'post',
    postBody: 'parentId='+tabId,
    onSuccess: function(t) {
        currentTab.getSubTabsHandler(t);
    },
    on404: function(t) {
        alert('Error 404: location "' + t.statusText + '" was not found.');
    },
    onFailure: function(t) {
        alert('Error ' + t.status + ' -- ' + t.statusText);
    }
   }
   Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortalTabsByParentRequest, opt); 
}
LightPortalTab.prototype.getSubTabsHandler = function(t){   
      var subTabs = t.responseText;
      this.renderSubTabs(subTabs);
}
LightPortalTab.prototype.renderSubTabs = function(subTabs){   
      //no sub pages
      if(subTabs.length == 1){
      	 this.getPortletsByTab(this.index);
      	 return;
      }
      if(Light.portal.portletWindowTransparent == false)
	   		this.panelContainer.innerHTML="<div id='tabs"+this.tabServerId+"' class='portal-tabs' ><ul id='tabList"+this.tabServerId+"'></ul></div><div id='tabPanels"+this.tabServerId+"' class='portal-tab-panels' ></div>";
      else
   	   		this.panelContainer.innerHTML="<div id='tabs"+this.tabServerId+"' class='portal-tabs2' ><ul id='tabList"+this.tabServerId+"'></ul></div><div id='tabPanels"+this.tabServerId+"' class='portal-tab-panels' ></div>";  
      var defaultTab = 0;
      var portalTabs = subTabs.split(";");
      for(var i=0;i<portalTabs.length;i++){ 
          var vPortalTab = eval(portalTabs[i]);  
          vPortalTab.parent=this; 
          vPortalTab.tabList = "tabList"+this.tabServerId;
          vPortalTab.tabPanels = "tabPanels"+this.tabServerId;      
          vPortalTab.open(vPortalTab);
          this.tabs[i]=vPortalTab;   
          if(vPortalTab.defaulted)
             defaultTab = i;       
      }          
      this.addTabMenu();
      if(this.defaultTab != null){
         if(this.defaultTab.indexOf("-") > 0){
	         var defaultTabs = this.defaultTab.split("-");
	         if(defaultTabs[0] < portalTabs.length){
	      	     defaultTab = defaultTabs[0];
	      	  }
	      	  if(defaultTabs.length > 1){  
	      	     var defaultSubTabs = "";
	      	     for(var i=1;i<defaultTabs.length;i++){
	      	        if(i == 1)
	      	           defaultSubTabs=defaultTabs[i];
	      	        else
	      	           defaultSubTabs+="-"+defaultTabs[i];
	      	     }
	      	  	 this.tabs[defaultTab].defaultTab = defaultSubTabs;
	      	  }
	      }else{
	          defaultTab = this.defaultTab;
	      }	  
      }    	 
      this.tabs[defaultTab].focus(); 
      this.tabs[defaultTab].refresh(); 
      if(portalTabs.length <= 1 && !Light.portal.allowAddTab)
	  this.tabs[0].hide(); 
}
LightPortalTab.prototype.addTabMenu = function(){
   if(Light.portal.allowAddTab){
	var newLabel = document.createElement('span');
	newLabel.setAttribute("id", "tabSpan" + "");
	newLabel.className = "";
	newLabel.style.paddingBottom=10;
	newLabel.setAttribute("tabColor", "");	         
	var clsA = document.createElement('img');
	clsA.src = Light.getThemePath()+'/images/add.gif';
	clsA.title = $('_MENU_ADD_TAB').title;
	clsA.className =  "portal-tab-button";
	clsA.style.height=16;
	clsA.style.width=16;
	clsA.align="middle";
	newLabel.appendChild(clsA);
	var newTab = document.createElement('li');
	newTab.className = this.tabColor;
	newTab.setAttribute("id", "tabMenuAddTab"+this.tabServerId);
	newTab.setAttribute("tabId", this.tabServerId);
	newTab.setAttribute("parentId", this.parentId);
	newTab.setAttribute("tabLabel", $('_MENU_ADD_TAB').title);
	newTab.setAttribute("tabColor","");	
	newTab.onclick = function () { 	
	   var id = this.getAttribute("tabId");   
	   addAutoTab(id); 
	}
	newTab.setAttribute("tabIsCloseable", "0");		
	newTab.setAttribute('isFocused','true');	
	newTab.appendChild(newLabel);	
	document.getElementById("tabList"+this.tabServerId).appendChild(newTab);	        
    }	
}
LightPortalTab.prototype.getPortletsByTab = function(tIndex){
   var tabId = this.tabServerId;
   if($('page'+tabId+"Portlets") != null){
   		this.renderPortlets($('page'+tabId+"Portlets").title);
   		return;
   }
   var currentTab = this;
   var opt = {
    method: 'post',
    postBody: 'tabId='+tabId,
    onSuccess: function(t) {
        currentTab.responseGetPortletsByTab(t);
    },
    on404: function(t) {
        alert('Error 404: location "' + t.statusText + '" was not found.');
    },
    onFailure: function(t) {
        alert('Error ' + t.status + ' -- ' + t.statusText);
    }
   }
   Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortletsByTabRequest, opt); 
}
LightPortalTab.prototype.responseGetPortletsByTab = function(t){    
      var responseText = t.responseText;
      this.renderPortlets(responseText);
}
LightPortalTab.prototype.renderPortlets = function(responseText){     
      if(responseText.length <=0){
         this.repositionFooter();
         return;
      }
      var portlets = responseText.split(";");
      var portletsCount = portlets.length;
      var maxPortlet = null;
      Light.currentTab = this;
      for(var i=0;i<portletsCount;i++){
     	  var vPortlet = null;  
     	  var windowAppearance = this.portletWindowAppearance;
     	  var params = portlets[i];
     	  var index = params.indexOf(",");     	  
     	  if(index > 0 && params.substring(0,index) != "null"){
     	     windowAppearance = params.substring(0,index);
     	     var type = windowAppearance.substring(windowAppearance.length - 1);
			 if(!type.charAt(0).isDigit()) { type="1";}
   			 windowAppearance = "WindowAppearance"+type;	      	  
	      }  	 
	      var newPortlet = "new PortletWindow(new "+windowAppearance+"(), "+this.index+","+params.slice(index+1)+")";
          var vPortlet = eval(newPortlet);                	      
          if(vPortlet.state !=  Light._MAXIMIZED_STATE)
             vPortlet.refresh();
          else
             maxPortlet = vPortlet;
      } 
      if(maxPortlet != null){
         maxPortlet.refresh();
      }        
}
LightPortalTab.prototype.addSubPage = function(){  
	var params = "tabId="+this.tabServerId;
	//var focusId = Light.getCookie(Light._CURRENT_TAB);
	//Light.setCookie(Light._CURRENT_TAB,focusId+"-0");
    Light.ajax.sendRequest(Light.portal.contextPath+Light.addSubPageRequest,{parameters:params, onSuccess:Light.refreshPortal});
}
LightPortalTab.prototype.resize = function(){  
   var totalWidth = 0;
   for(var i=0;i<this.widths.length;i++){
       totalWidth+=this.widths[i]+this.between;
   }      
   totalWidth+=this.between;

   if(Light.portal.layout.maxWidth > totalWidth){
     var diff = Light.portal.layout.maxWidth - totalWidth;
     var eachD = parseInt(diff / this.widths.length);
     for(var i=0;i<this.widths.length;i++){
       this.widths[i]+=eachD;
     }
   }
   if(Light.portal.layout.maxWidth < totalWidth){
     var diff = totalWidth - Light.portal.layout.maxWidth;
     var eachD = parseInt(diff / this.widths.length);
     for(var i=0;i<this.widths.length;i++){
       this.widths[i]-=eachD;
     }
   }
   this.reLayout();
   Light.portal.refreshPortalMenu(this);
}
LightPortalTab.prototype.reLayout = function(){   
   for(var i=0;i<this.portlets.length;i++) {
       if(this.portlets[i] != null){     
	       for(var j=0;j<this.portlets[i].length;j++) {   
	       	  if(this.portlets[i][j] != null && !this.portlets[i][j].maximized){          	
	          	this.portlets[i][j].width = this.widths[i];
			    this.portlets[i][j].left = 0;
			    for(var k=0;k<this.portlets[i][j].position;k++) { 
			        this.portlets[i][j].left += this.widths[k] + this.between;
			    }
	          }
	       }
	   }
   }   
   this.rePositionAll();
}
LightPortalTab.prototype.rePositionAll = function(){   
   for(var i=0;i<this.portlets.length;i++) {
       if(this.portlets[i] != null){    
	       for(var j=0;j<this.portlets[i].length;j++) {   
	       	  if(this.portlets[i][j] != null && !this.portlets[i][j].maximized){
	          	this.rePositionPortlets(this.portlets[i][j]);
	          	break;
	          }
	       }
	    }
   }   
   this.repositionFooter();
}
LightPortalTab.prototype.getTop = function(){
   if(this.parent != Light.portal)
       return 30 + this.parent.getTop();
   else
       return 0;
}
LightPortalTab.prototype.rePositionPortlets = function(portlet){
   var rowBetween = 10;   
   if(portlet.window.layout != null)
   	 rowBetween = portlet.window.layout.rowBetween;
   else if(portlet.layout != null)
     rowBetween = portlet.layout.rowBetween;
    
   var position = portlet.position;
   var index = portlet.index;
   var height = 0;
   var maxIndex = 0;
   var nullNum = 0;
    for(var i=0;i<this.portlets[position].length;i++) {    
       if(this.portlets[position][i] != null){  
        if(i >= index && !this.portlets[position][i].maximized){
          this.portlets[position][i].top = this.getTop() + this.portlets[position][i].getTop() + height + rowBetween * (i - maxIndex - nullNum);
          this.portlets[position][i].refreshPosition();
        }
		if(!this.portlets[position][i].maximized ){
          height += this.portlets[position][i].getHeight();   
        }            
        if(this.portlets[position][i].maximized){
          height = this.portlets[position][i].getHeight();     
          maxIndex = i;
          nullNum = 0;
        }
       }
       if(this.portlets[position][i] == null){
          nullNum++;
       }        
    }
    this.repositionFooter();
}
LightPortalTab.prototype.repositionFooter = function(){
   var currentTabId = Light.getCurrentTabId();
   if(currentTabId != this.tabServerId) return; 	
   var maxHeight = this.getMaxHeight(); 
   if (document.all) {	
       Light.portal.footer.style.posTop = maxHeight;           
   }    
   else {        
       Light.portal.footer.style.top = maxHeight;           
   } 
   if((maxHeight - Light.portal.layout.maxTop) > Light.portal.layout.maxHeight)
      Light.portal.container.style.height = maxHeight - Light.portal.layout.maxTop; 
   
   Light.portal.footer.style.width = Light.portal.layout.maxWidth;
 }
LightPortalTab.prototype.getMaxHeight = function(){
   var heights = new Array();   
   var maxHeight = 0;   
   for(var i=0; i<this.portlets.length;i++) { 
      if(this.portlets[i] != null){
	      for(var j=0;j<this.portlets[i].length;j++) {      
		    if(this.portlets[i][j] != null){
		    	if(this.portlets[i][j].maximized ){ 
			       maxHeight = this.portlets[i][j].top + this.portlets[i][j].window.container.clientHeight;         
			       break;
			    }      
				if(!this.portlets[i][j].maximized ){
			      heights[i] = this.portlets[i][j].top + this.portlets[i][j].window.container.clientHeight;   
			    }
			}
		  }
	  }
	  if(maxHeight > 0)
	  	break;                        
   }    
   if(maxHeight == 0){
       for(var i=0; i<heights.length;i++) {
          if(heights[i] > maxHeight)
             maxHeight = heights[i];
       }	   
   }
   maxHeight = maxHeight + Light.portal.layout.footerHeightMargin;  
   if(maxHeight < 300) maxHeight = 300; 
   return maxHeight;
}
LightPortalTab.prototype.getPortletIndex = function(position){
   var addAfterLast = true;
   var index = 0;
   if(this.portlets[position] != null){
	   for(var i=0;i<this.portlets[position].length;i++) {
		if(this.portlets[position][i] == null){
	           addAfterLast = false;
	           index = i;
	           break;    
	        }
	   }
	   if(addAfterLast) {
	     index = this.portlets[position].length;  
	   }
	}else {
	   this.portlets[position] = new Array();	   
	}
   return index;
 }
LightPortalTab.prototype.showOtherPortlets = function(){
   for(var i=0;i<this.portlets.length;i++) {
       if(this.portlets[i] != null){    
       for(var j=0;j<this.portlets[i].length;j++) {  
          if(this.portlets[i][j] != null && this.portlets[i][j].maximized){       
             this.portlets[i][j].show();
             return;
          }  
       }
       }
   }
   for(var i=0;i<this.portlets.length;i++) {
       if(this.portlets[i] != null){    
       for(var j=0;j<this.portlets[i].length;j++) {  
          if(this.portlets[i][j] != null){       
             this.portlets[i][j].show();
          }  
       }
       }
   }
   Light.portal.menu.style.zIndex= ++Light.maxZIndex;   
}
LightPortalTab.prototype.hideOtherPortlets = function(portlet){
   for(var i=0;i<this.portlets.length;i++) {    
       if(this.portlets[i] != null){ 
       for(var j=0;j<this.portlets[i].length;j++) {  
          if(this.portlets[i][j] != null && this.portlets[i][j].serverId != portlet.serverId){                    
             if(this.portlets[i][j].popup){             	
             	this.portlets[i][j].close(true);
             }else
             	this.portlets[i][j].hide();
          }  
       }
       }
   }      
}
LightPortalTab.prototype.collapseAll = function(){
	for(var i=0;i<this.portlets.length;i++) {
       if(this.portlets[i] != null){     
	       for(var j=0;j<this.portlets[i].length;j++) {   
	       	  if(this.portlets[i][j] != null && !this.portlets[i][j].minimized){          	
			    this.portlets[i][j].minimize();
	          }
	       }
	   }
   } 
} 
LightPortalTab.prototype.expandAll = function(){
	for(var i=0;i<this.portlets.length;i++) {
       if(this.portlets[i] != null){     
	       for(var j=0;j<this.portlets[i].length;j++) {   
	       	  if(this.portlets[i][j] != null && this.portlets[i][j].minimized){          	
			    this.portlets[i][j].minimize();
	          }
	          if(this.portlets[i][j] != null && this.portlets[i][j].maximized){          	
			    this.portlets[i][j].maximize();
	          }
	       }
	   }
   } 
} 
LightPortalTab.prototype.refreshWindowTransparent = function(){
	for(var i=0;i<this.portlets.length;i++) {
       if(this.portlets[i] != null){     
	       for(var j=0;j<this.portlets[i].length;j++) {   
	       	  if(this.portlets[i][j] != null ){          	
			    this.portlets[i][j].refreshWindowTransparent();
	          }	         
	       }
	   }
   } 
} 