//------------------------------------------------------------ LightPortlet.js
 function PortletWindow (window,tIndex,serverId,position,title,icon,url,request,requestUrl,closeable,refreshMode,editMode,helpMode,configMode,allowMinimized,allowMaximized,autoRefreshed,refreshAtClient, periodTime,allowJS,barBgColor,barFontColor,contentBgColor,textColor,parameter,initState,initMode,intTransparent)
 {   
   Light.portal.allPortlets[Light.portal.allPortlets.size()]=this;
   this.parent = Light.currentTab;
   this.window = window;   
   this.allowMove = true;
   this.mode = Light._VIEW_MODE;
   if(initMode == 1) this.mode = Light._EDIT_MODE;
   if(initMode == 2) this.mode = Light._HELP_MODE;
   if(initMode == 3) this.mode = Light._CONFIG_MODE;
   this.state = Light._NORMAL_STATE;
   if(initState == 1) this.state = Light._MINIMIZED_STATE;   
   if(initState == 2) this.state = Light._MAXIMIZED_STATE;   
   this.tIndex = tIndex;   
   this.serverId = serverId;
   this.position = position;
   this.title = title;
   this.icon = icon;
   this.url = url;
   this.request = request;
   this.requestUrl = requestUrl;
   this.closeable = closeable;
   this.refreshMode = refreshMode;
   this.editMode = editMode;
   this.helpMode = helpMode;
   this.configMode = configMode;
   this.allowMinimized = allowMinimized;
   this.allowMaximized = allowMaximized;
   this.autoRefreshed = autoRefreshed;
   this.refreshAtClient = refreshAtClient;
   this.periodTime = periodTime;
   this.allowJS = allowJS;
   this.barBgColor = barBgColor;
   this.barFontColor = barFontColor;
   this.contentBgColor = contentBgColor;
   this.textColor = textColor;
   this.parameter = parameter;
   this.transparent= false;
   if(intTransparent == 1) this.transparent= true;
   this.index = this.parent.getPortletIndex(this.position);
   var height = 0;
   var maxIndex = 0;
   var nullNum = 0;        
   for(var i=0;i<this.parent.portlets[this.position].length;i++) {        
      if(i == this.index){
         break;
      }
      if(this.parent.portlets[this.position][i] != null && !this.parent.portlets[this.position][i].maximized){
         height += this.parent.portlets[this.position][i].window.container.clientHeight;   
      } 
      if(this.parent.portlets[this.position][i] == null){
         nullNum++;
      }
      if(this.parent.portlets[this.position][i] != null && this.parent.portlets[this.position][i].maximized){
         height = this.parent.portlets[this.position][i].window.container.clientHeight;     
         maxIndex = i;
         nullNum = 0;
      }              
    }
    this.top  = this.window.top + height + this.window.layout.rowBetween * (i - maxIndex - nullNum);  
    this.width = this.parent.widths[this.position];
    this.left = this.window.left;
    for(var i=0;i<this.position;i++) { 
        this.left += this.parent.widths[i] + this.parent.between;
    }
    
    this.parent.portlets[this.position][this.index] = this;     
   
    this.window.render(this);
    
    this.minimized = false;
    this.maximized = false;       
    this.moveable = false;
    this.autoRefreshWhenMaximized = false;
    this.autoShow = false;
    this.opacity = 0;
    this.fade="in";
    this.myPictureIndex = 0;
    this.myPictures= new Array();
    this.autoShowId = null;
   
    this.mouseDownX = 0;
    this.mouseDownY = 0;
    this.refreshPosition();
    this.loading = Light.getViewTemplate("loadingPortlet.view");
	this.content = null;
    this.window.container.innerHTML = this.loading;
    this.parent.rePositionPortlets(this); 
    if(this.autoRefreshed){
   	  this.firstTimeAutoRefreshed = true;
   	  this.autoRefresh();
    }
    this.refreshPortletTitle();
}
 PortletWindow.prototype.refreshPortletTitle = function(){
   var params = "path="+this.requestUrl
               +"&responseId="+Light._PC_PREFIX+this.serverId;
   Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortletTitle, {parameters:params,onSuccess:setPortletTitle}); 
  
 }  
 
 PortletWindow.prototype.focus = function()
 {
    this.window.focus(this);
 }
 
 PortletWindow.prototype.show = function(){
 	this.window.show(this);
 }
 
 PortletWindow.prototype.hide = function(){
 	this.window.hide(this);
 }
  
 PortletWindow.prototype.moveBegin = function(e)
 {      
  document.body.onselectstart = function() { return false };
  document.body.ondragstart = function() { return false };
  if (document.all) e = event;
  var x = e.clientX;
  var y = e.clientY;
  this.window.focus(this);
  this.moveable = true;
  this.mouseDownX = x;
  this.mouseDownY = y;
  this.moveBeginX = x;
  this.moveBeginY = y;

  Light.portal.moveTimer = 0;
  this.startMoveTimer();
  var vdocument = document.getElementById('panel_'+this.parent.tabServerId);
  Light.portal.highLight.style.visibility = "hidden";
  vdocument.appendChild(Light.portal.highLight); 
 }
 
 PortletWindow.prototype.moveEnd = function()
 {        
    if(this.moveable){
    var xDifference = this.mouseDownX - this.moveBeginX;
    var yDifference = this.mouseDownY - this.moveBeginY;
        
    if(this.moveToColumn != this.position){
	    if(this.moveToColumn > this.position)
	      this.moveRight(this.moveToColumn);
	    else if(this.moveToColumn < this.position)
	      this.moveLeft(this.moveToColumn);
    }
    else {
     if(this.mouseDownY > this.moveBeginY)
        this.moveDown();
      else if(this.mouseDownY < this.moveBeginY)
        this.moveUp();
    }
    this.lastAction = null;
    this.moveable = false;
    var vdocument = document.getElementById('panel_'+this.parent.tabServerId);
    vdocument.removeChild(Light.portal.highLight); 
    if(!this.minimized){ 
    	this.refresh();   
    }
  }	
 }

 PortletWindow.prototype.move = function(e)
 { 	
    if(this.moveable){
    var x = e.clientX;
    var y = e.clientY;
    this.left += x - this.mouseDownX;
    this.top  += y - this.mouseDownY;
    var direction = "left";
    if(x > this.mouseDownX) direction = "right";
    this.refreshPosition(this);
    this.mouseDownX = x;
    this.mouseDownY = y;

    var xDifference = this.mouseDownX - this.moveBeginX;
    var yDifference = this.mouseDownY - this.moveBeginY;
	
	var moveTo= 0;
	var moveToColumn = -1;
	for(var i=0;i<this.parent.widths.length;i++) {  
	  if(i > 0)
	     moveTo+= this.parent.widths[i - 1]+this.parent.between * (i - 1);             
      if(direction =="left"){
	      if(this.left < moveTo + this.parent.widths[i]){       
	         moveToColumn = i;
	         break;
	      }  
      }else{
      	  if(this.left + this.width > moveTo){       
	         moveToColumn = i;
	      }
	  }
    }
    this.moveToColumn = moveToColumn;
    Light.portal.highLight.style.visibility = "visible";
    
    if(moveToColumn != this.position){    
	    if(moveToColumn > this.position)      
	         this.highLightX(1,moveToColumn);//right
	    else if(moveToColumn < this.position)
	         this.highLightX(2,moveToColumn);//left	    
    }else {
     if(this.mouseDownY > this.moveBeginY)
        this.highLight(3);//down
     else if(this.mouseDownY < this.moveBeginY)
        this.highLight(4);//up
    }
  }
 }
 
 PortletWindow.prototype.startMoveTimer = function()
  {
   if (Light.portal.moveTimer>=0 && Light.portal.moveTimer<10){
    Light.portal.moveTimer++;
    setTimeout((function() {this.startMoveTimer ()}).bind(this), 15);
   }
   if (Light.portal.moveTimer == 10) {
    Light.portal.dragDropPortlet = this;
    this.refreshPosition();
    }
  }

 PortletWindow.prototype.refreshPosition = function()
 { 
   this.window.position(this);
 }
 
PortletWindow.prototype.autoRefresh = function()
 {
   if(this.mode != Light._VIEW_MODE) return;
   if(this.autoRefreshed){       
       if(this.firstTimeAutoRefreshed){
       	  this.firstTimeAutoRefreshed = false;
       }else{
       	  this.selfRefresh();
       }
       setTimeout((function() {this.autoRefresh ()}).bind(this), this.periodTime);
    }
 }
 
PortletWindow.prototype.selfRefresh = function()
 {   	
   if(!this.minimized && (!this.maximized || this.autoRefreshWhenMaximized)){
	   if(this.mode == Light._VIEW_MODE){
	    if(this.refreshAtClient){
	      Light.refreshAtClient(this);	        
	    }else{
          this.refreshAction = true;
	      Light.executeRefresh(Light._PC_PREFIX+this.serverId);
	    }
	   }
   }
   if(this.minimized && this.path == "/myMessagePortlet.lp"){
      this.refreshPortletTitle();
   }
 }
PortletWindow.prototype.refresh = function(flag)
 {  
    if(Light.executeAtClient(this)) return;   	    
   	if(flag == null || flag == true){
   		this.window.container.innerHTML = this.loading;
   	}
   	this.parent.rePositionPortlets(this);   
    this.refreshAction = true; 
    this.refreshPortletTitle();
   	Light.executeRefresh(Light._PC_PREFIX+this.serverId);
   	if(this.autoRefreshed){
   	  this.firstTimeAutoRefreshed = true;
   	  this.autoRefresh();
   }  
 }

PortletWindow.prototype.changePosition = function()
{
   var params = "responseId="+Light._PC_PREFIX+this.serverId
      		    +"&tabId="+this.parent.tabServerId
      		    +"&portletId="+this.serverId
                +"&column="+this.position
                +"&row="+this.index;
   Light.ajax.sendRequest(Light.portal.contextPath+Light.changePositionRequest,{parameters:params});   
   this.parent.rePositionPortlets(this);    
 }

PortletWindow.prototype.rememberMode = function(mode){
   var userId = Light.getCookie(Light._LOGINED_USER_ID);
   if(userId == null || userId == "") 
      userId = Light.getCookie(Light._USER_ID);
   if(userId != null && userId != ""){
	  var params = "mode="+mode+"&portletId="+this.serverId;
	  Light.ajax.sendRequest(Light.portal.contextPath+Light.rememberMode, {parameters:params});
   }
}

PortletWindow.prototype.refreshButtons = function()
 {
	this.window.refreshButtons(this);
	if(this.mode == Light._EDIT_MODE){        
		this.rememberMode(1);        
	}else if(this.mode == Light._HELP_MODE){        
		this.rememberMode(2);        
	}else{        
		this.rememberMode(0);
	}                       
 }
 
PortletWindow.prototype.edit = function()
 { 
   if(this.editMode){ 
    if(this.clientCached)
    	this.content = this.window.container.innerHTML;
    this.mode= Light._EDIT_MODE;
    var id = Light._PC_PREFIX+this.serverId;
    Light.executePortlet(id);       	
    this.refreshButtons();
   }
 }

PortletWindow.prototype.cancelEdit = function()
 {
   if(this.editMode){
    this.mode= Light._VIEW_MODE;
    if(this.clientCached && this.content != null)
    	this.window.container.innerHTML = this.content;
    else{
	    var id = Light._PC_PREFIX+this.serverId;
	    Light.executePortlet(id); 
    }
   	this.refreshButtons();
    
   }
 }
 
PortletWindow.prototype.help = function()
 {
	if(this.helpMode){ 
   		if(this.clientCached)
        	this.content = this.window.container.innerHTML;
        this.mode = Light._HELP_MODE;   
        var id = Light._PC_PREFIX+this.serverId;
        Light.executePortlet(id); 
        this.refreshButtons(); 
    }
 }
 
PortletWindow.prototype.cancelHelp = function()
 {
	if(this.helpMode){
		this.mode = Light._VIEW_MODE;
		if(this.clientCached && this.content != null)
    		this.window.container.innerHTML = this.content;
	    else{
		    var id = Light._PC_PREFIX+this.serverId;
		    Light.executePortlet(id); 
	    } 
    	this.refreshButtons();     
	}
 }

PortletWindow.prototype.config = function()
 {
	if(this.configMode){ 
   		if(this.clientCached)
        	this.content = this.window.container.innerHTML;
		this.mode = Light._CONFIG_MODE;           
        var data = {	     
		     id : Light._PC_PREFIX+this.serverId,
		     title : this.title,
		     barBgColor : this.barBgColor,
		     barFontColor :this.barFontColor,
		     contentBgColor : this.contentBgColor,
		     textColor : this.textColor,
		     transparent : this.transparent,
		     skin : 'PortletWindow2'
		   };  
		 this.window.container.innerHTML = TrimPath.processDOMTemplate("configMode.jst",data);
		 Light.responsePortlet(data.id);
		 this.refreshButtons();  
    }
 }
 
PortletWindow.prototype.cancelConfig = function()
 {
	if(this.configMode){
		this.mode = Light._VIEW_MODE;
		if(this.clientCached && this.content != null)
    		this.window.container.innerHTML = this.content;
	    else{
		    this.refresh();
	    } 	    
		this.refreshWindow();  
	}
 }

PortletWindow.prototype.highLightX = function(pos,moveToColumn)
 {
   var temp = null;   
   var temp2 = null;  
   var showHighLight = true;
   var columnLeft=0;
   if(this.parent.portlets[moveToColumn] == null)
       this.parent.portlets[moveToColumn] = new Array();
   if(this.parent.portlets[moveToColumn] != null){
         var column = moveToColumn;              
         var len = this.parent.portlets[column].length;   
         for(var i=0;i<len;i++){
          if(this.parent.portlets[column][i] != null){
             if(columnLeft == 0) columnLeft= this.parent.portlets[column][i].left;
             if(this.top < this.parent.portlets[column][i].top){
            	temp = this.parent.portlets[column][i];         
            	break;
             }              
          }
        } 
        if(temp == null){
        	for(var i=len - 1;i>=0;i--){
	          if(this.parent.portlets[column][i] != null){	             
	            	temp2 = this.parent.portlets[column][i];     
	            	break;                  
	          }
	        } 
        }
     }else
       showHighLight= false;                         

   if(showHighLight){
     var highLeft = columnLeft;
     var highTop = this.window.top + 5; 
     var highWidth = this.parent.widths[moveToColumn];
     var highHeight = 5;
     if(temp != null){           
        highTop = temp.top - this.window.layout.rowBetween + 2;           
        highLeft = temp.left;        
        highWidth = temp.width;             
     }else if(temp2 != null){
        highTop = temp2.top + temp2.window.container.clientHeight + 2; 
     } 
     
     if(temp != null){           
        highTop = temp.top - 5;           
        highLeft = temp.left;        
        highWidth = temp.width;             
     }else if(temp2 != null){
        highTop = temp2.top + temp2.window.container.clientHeight + temp2.window.layout.rowBetween - 5; 
     } 
     
     if (document.all) {	
         Light.portal.highLight.style.posLeft = highLeft;
       	 Light.portal.highLight.style.posTop = highTop;
     }else {        
         Light.portal.highLight.style.left = highLeft;
         Light.portal.highLight.style.top = highTop;
     }
     Light.portal.highLight.style.width = highWidth;
     Light.portal.highLight.style.height= highHeight;
     Light.portal.highLight.style.zIndex= ++Light.maxZIndex; 
     }else
        Light.portal.highLight.style.visibility = "hidden";   
}

PortletWindow.prototype.highLight = function(pos)
 {
   var temp = null;   
   var showHighLight = true;
   if(pos == 1){       
     var columns = this.parent.widths.length;
     if(this.position + 1 < columns 
       && this.parent.portlets[this.position + 1] == null)
       this.parent.portlets[this.position + 1] = new Array();
     if(this.parent.portlets[this.position + 1] != null){
         var column = this.position + 1;              
         var len = this.parent.portlets[column].length;   
         for(var i=0;i<len;i++){
          if(this.parent.portlets[column][i] != null
          && this.top < this.parent.portlets[column][i].top){
            temp = this.parent.portlets[column][i];            
            break;
          }
        } 
     }else
       showHighLight= false;                     
   }     

   if(pos == 2){
     if(this.position > 0){       
     var column = this.position - 1; 
     if(this.parent.portlets[column] == null)
        this.parent.portlets[column] = new Array();
     var len = this.parent.portlets[column].length;   
     for(var i=0;i<len;i++){
       if(this.parent.portlets[column][i] != null 
       && this.top < this.parent.portlets[column][i].top){
            temp = this.parent.portlets[column][i];            
            break;
       }
     }
     }else
       showHighLight= false;                     
    }  
    
    if(pos == 3){
       var started = this.index + 1;                  
       for(var i=started;i<this.parent.portlets[this.position].length;i++){
         if(this.parent.portlets[this.position][i] != null){
           temp = this.parent.portlets[this.position][i];
           break;
         }     
       }
       if(temp == null)
          showHighLight= false;   
     } 

    if(pos == 4){
     if(this.index > 0){
        var started = this.index - 1;                 
        for(var i=started;i>=0;i--){
           if(this.parent.portlets[this.position][i] != null){
             temp = this.parent.portlets[this.position][i];
             break;
           }
        }
        if(temp == null)
          showHighLight= false;
      }else
       showHighLight= false;          
    }  

    if(showHighLight){
     var highLeft;
     var highTop;
     var highWidth;
     var highHeight = 5;
     if(temp != null){   
        if(pos != 3)
          highTop = temp.top - 5; 
        else
          highTop = temp.top + temp.window.container.clientHeight + temp.window.layout.rowBetween - 5;          
        highLeft = temp.left;        
        highWidth = temp.width;             
     }    
     else{
        var temp2= null;
        var column = 0;
        if(pos == 1)
          column = this.position + 1;              
        if(pos == 2)
          column = this.position - 1;              
        
         var len = this.parent.portlets[column].length;   
         for(var i=len - 1;i>=0;i--){
          if(this.parent.portlets[column][i] != null){
            temp2 = this.parent.portlets[column][i];            
            break;
          }
         }
         if(temp2 != null){                
            highLeft = temp2.left;
            highTop = temp2.top + temp2.window.container.clientHeight + this.window.layout.rowBetween; 
            highWidth = temp2.width;             
     	 }else{
            
   	    highLeft = this.parent.between;
            for(var i=0;i<column;i++) { 
              highLeft += this.parent.widths[i] + this.parent.between;
            }
            highTop = this.window.top + this.window.layout.rowBetween;  
            highWidth = this.parent.widths[column];
         }    
        }
   
     if (document.all) {	
         Light.portal.highLight.style.posLeft = highLeft;
       	 Light.portal.highLight.style.posTop = highTop;
     }else {        
         Light.portal.highLight.style.left = highLeft;
         Light.portal.highLight.style.top = highTop;
     }
     Light.portal.highLight.style.width = highWidth;
     Light.portal.highLight.style.height= highHeight;
     Light.portal.highLight.style.zIndex= ++Light.maxZIndex; 
     }else
        Light.portal.highLight.style.visibility = "hidden";  
 }
PortletWindow.prototype.moveCancel = function()
 {    
    this.buttonIsClicked = true;
 }
 
PortletWindow.prototype.moveAllowed = function()
 {    
    this.buttonIsClicked = false;
 }
PortletWindow.prototype.moveUp = function()
 {
   if(this.index > 0){
    var temp = null;
    var upIndex = 0;
    var currentIndex = this.index;
    var started = this.index - 1;                 
    for(var i=started;i>=0;i--){
       if(this.parent.portlets[this.position][i] != null){
         temp = this.parent.portlets[this.position][i];
         upIndex = i;
         break;
       }
    }               
    if(temp != null){
      temp.index = this.index;
      this.index = upIndex;      
      this.parent.portlets[this.position][upIndex] = this;
      this.parent.portlets[this.position][currentIndex] = temp; 
      temp.changePosition(); 
      temp.lastAction = null;
      if(!temp.minimized){ 
	    temp.refresh(false);   
	  }            
      this.left = 0;
	  for(var i=0;i<this.position;i++) { 
    	this.left += this.parent.widths[i] + this.parent.between;
	  }
      this.changePosition();      
    }     
   }
 }
 
 PortletWindow.prototype.moveDown = function()
 {
    var temp = null;
    var downIndex = 0;
    var currentIndex = this.index;
    var started = this.index + 1;                  
    for(var i=started;i<this.parent.portlets[this.position].length;i++){
       if(this.parent.portlets[this.position][i] != null){
         temp = this.parent.portlets[this.position][i];
         downIndex = i;
         break;
       }
    }               
    if(temp != null){
      temp.index = this.index;
      this.index = downIndex;       
      this.parent.portlets[this.position][downIndex] = this;
      this.parent.portlets[this.position][currentIndex] = temp;          
      this.changePosition();
      this.left = 0;
    	  for(var i=0;i<this.position;i++) { 
        	this.left += this.parent.widths[i] + this.parent.between;
    	  }
      temp.changePosition();
      temp.lastAction = null; 
      if(!temp.minimized){ 
	    temp.refresh(false);   
	  }              
    }    
 }
 
  PortletWindow.prototype.moveLeft = function(moveToColumn)
 {
   if(this.position > 0){
     var temp = null;
     var newIndex = 0;
     var currentPosition = this.position;
     var currentIndex = this.index;
     var column = moveToColumn; 
     if(this.parent.portlets[column] == null)
        this.parent.portlets[column] = new Array();
     var len = this.parent.portlets[column].length;   
     for(var i=0;i<len;i++){
       if(this.parent.portlets[column][i] != null 
       && this.top < this.parent.portlets[column][i].top){
            temp = this.parent.portlets[column][i];
            newIndex = temp.index;
            break;
       }
     }                    
                
        if(temp != null){
          for(var i= len - 1;i>=0;i--){
	       if(this.parent.portlets[column][i] != null){
	          var temp2 = this.parent.portlets[column][i];
	          temp2.index++; 
	          this.parent.portlets[column][i + 1]= temp2;
	          this.parent.portlets[column][i + 1].changePosition();
	          this.parent.portlets[column][i]= null;
	          temp2.lastAction = null;
	          if(!temp2.minimized){ 
			    temp2.refresh(false);   
			  }  
              if(temp2.serverId == temp.serverId) break;	         
	       }
	      }   
	      this.position = column;
          this.index = newIndex;                                     
          this.parent.portlets[this.position][this.index] = this;          
          this.parent.portlets[currentPosition][currentIndex] = null; 
          this.left = 0;
    	  for(var i=0;i<this.position;i++) { 
        	this.left += this.parent.widths[i] + this.parent.between;
    	  }
          this.width = this.parent.widths[this.position];  
          this.changePosition();                     
        }else{
          this.position = column;  
          var isEmpty = true;
          for(var i= len - 1;i>=0;i--){
	       if(this.parent.portlets[column][i] != null){
	          var temp3 = this.parent.portlets[column][i];
                  this.index = temp3.index + 1;
                  isEmpty = false;
	          break;	         
	        }
	 	   }          
          if(isEmpty) this.index = 0;
          this.parent.portlets[this.position][this.index] = this;   
          this.parent.portlets[currentPosition][currentIndex] = null;        
          this.left = 0;
    	  for(var i=0;i<this.position;i++) { 
        	this.left += this.parent.widths[i] + this.parent.between;
    	  }
	  	  this.width = this.parent.widths[this.position];
          this.changePosition();        
        }
      var length = this.parent.portlets[currentPosition].length;   
      for(var i=currentIndex+1;i<length;i++){
       if(this.parent.portlets[currentPosition][i] != null){
         var next = this.parent.portlets[currentPosition][i];
         this.parent.rePositionPortlets(next);
         break;
       }
     }          
   }
 }
 
 PortletWindow.prototype.moveRight = function(moveToColumn)
 {      
  columns = this.parent.widths.length;
  if(this.position + 1 < columns 
    && this.parent.portlets[this.position + 1] == null)
    this.parent.portlets[this.position + 1] = new Array();
  if(this.parent.portlets[this.position + 1] != null){
     var temp = null;
     var newIndex = 0;
     var currentPosition = this.position;
     var currentIndex = this.index;
     var column = moveToColumn;              
     var len = this.parent.portlets[column].length;   
     for(var i=0;i<len;i++){
       if(this.parent.portlets[column][i] != null
       && this.top < this.parent.portlets[column][i].top){
            temp = this.parent.portlets[column][i];
            newIndex = temp.index;
            break;
       }
     }               
     if(temp != null){                    
          for(var i= len - 1;i>=0;i--){
	       if(this.parent.portlets[column][i] != null){
	          var temp2 = this.parent.portlets[column][i];
	          temp2.index++;
	          this.parent.portlets[column][i + 1]= temp2;
	          this.parent.portlets[column][i + 1].changePosition();
	          this.parent.portlets[column][i]= null;
	          temp2.lastAction = null;
              if(!temp2.minimized){ 
			    temp2.refresh(false);   
			  }  
              if(temp2.serverId == temp.serverId) break;	         
	       }
	      }   
	      this.position = column;
          this.index = newIndex;                    
          this.parent.portlets[this.position][this.index] = this;          
	  	  this.parent.portlets[currentPosition][currentIndex] = null; 
          this.left = 0;
    	  for(var i=0;i<this.position;i++) { 
        	this.left += this.parent.widths[i] + this.parent.between;
    	  }
          this.width = this.parent.widths[this.position]; 
          this.changePosition();    
        }else{
          this.position = column;
          var isEmpty = true;
          for(var i= len - 1;i>=0;i--){
	       if(this.parent.portlets[column][i] != null){
	          var temp3 = this.parent.portlets[column][i];
                  this.index = temp3.index + 1;
                  isEmpty = false;
	          break;	         
	       }
	  }          
          if(isEmpty) this.index = 0;         
          this.parent.portlets[this.position][this.index] = this;
          this.parent.portlets[currentPosition][currentIndex] = null; 
          this.left = 0;
    	  for(var i=0;i<this.position;i++) { 
        	this.left += this.parent.widths[i] + this.parent.between;
    	  }
	      this.width = this.parent.widths[this.position];
          this.changePosition();          
        }    
     var length = this.parent.portlets[currentPosition].length;   
     for(var i=currentIndex+1;i<length;i++){
       if(this.parent.portlets[currentPosition][i] != null){
         var next = this.parent.portlets[currentPosition][i];
         this.parent.rePositionPortlets(next);
         break;
       }
     }      
   }
 }

 PortletWindow.prototype.minimize = function()
 { 
   if(this.allowMinimized){
	   this.minimized = !this.minimized;
	   if(this.minimized){
	    this.state = Light._MINIMIZED_STATE;
	    if(this.maximized){
	       this.maximize(false);   
	       this.minimized = true;     
	    }
	    var empty = "<br/>";
	    this.window.container.innerHTML = empty;         
	  }else{    
	    this.state = Light._NORMAL_STATE;     
	  }
	   this.window.minimize(this);
	   this.parent.rePositionPortlets(this);  	   	   
	   var userId = Light.getCookie(Light._LOGINED_USER_ID);
       if(userId == null || userId == "") 
          userId = Light.getCookie(Light._USER_ID);
	   if(userId != null && userId != ""){
		   var state = 0;
		   if(this.minimized) state = 1;
		   var params = "state="+state+"&portletId="+this.serverId;
		   Light.ajax.sendRequest(Light.portal.contextPath+Light.rememberState, {parameters:params});     
	   }
	   if(!this.minimized)
	      this.refresh()
   }
 }
 
 PortletWindow.prototype.maximize = function(flag)
 { 
   this.windowMaximize(flag);
   this.refresh(); 
 }  
 PortletWindow.prototype.windowMaximize = function(flag)
 { 
   this.maximized = !this.maximized; 
   if(!this.maximized){  
      this.state = Light._NORMAL_STATE;   
      var height = 0;
      var maxIndex = 0;
      var nullNum = 0;      
      for(var i=0;i<this.parent.portlets[this.position].length;i++) {        
          if(i == this.index){
             break;
          }
 	  	  if(this.parent.portlets[this.position][i] != null && !this.parent.portlets[this.position][i].maximized){
             height += this.parent.portlets[this.position][i].window.container.clientHeight;   
          } 
          if(this.parent.portlets[this.position][i] == null){
             nullNum++;
          }
          if(this.parent.portlets[this.position][i] != null && this.parent.portlets[this.position][i].maximized){
             height = this.parent.portlets[this.position][i].window.container.clientHeight;     
             maxIndex = i;
             nullNum = 0;
          }              
    	}  
    	this.top  = this.window.top + height + this.window.layout.rowBetween * (i - maxIndex - nullNum); 	
    	this.width = this.parent.widths[this.position];
	    this.left = 0;
	    for(var i=0;i<this.position;i++) { 
	        this.left += this.parent.widths[i] + this.parent.between;
	    }  
     	Light.portal.container.style.zIndex= 1;
		this.parent.showOtherPortlets();	
   }else{        
        this.state = Light._MAXIMIZED_STATE;  
        this.parent.hideOtherPortlets(this);        
   	    this.left = Light.portal.layout.maxLeft;
   	    this.top = Light.portal.layout.maxTop;
        this.width = Light.portal.layout.maxWidth;        
	       
        Light.portal.container.style.zIndex= ++Light.maxZIndex; 
        Light.portal.body.style.zIndex= ++Light.maxZIndex;
        Light.portal.footer.style.zIndex= ++Light.maxZIndex;      	
   }        
   this.window.maximize(this);  
   this.parent.rePositionPortlets(this);   
   if(flag == null || flag == true){   	   
	   var userId = Light.getCookie(Light._LOGINED_USER_ID);
       if(userId == null || userId == "") 
          userId = Light.getCookie(Light._USER_ID);
	   if(userId != null && userId != ""){
		   var state = 0;
		   if(this.maximized) state = 2;
		   var params = "state="+state+"&portletId="+this.serverId;
		   Light.ajax.sendRequest(Light.portal.contextPath+Light.rememberState, {parameters:params});     
	   }
	   
   }   
 }

 PortletWindow.prototype.close = function()
 { 
   var closePortlet = confirm($('_COMMAND_CLOSE_PORTLET').title);
   if (!closePortlet) // user cancelled close closePortlet
	{
		return;
	}
   if(this.maximized)   
     this.parent.showOtherPortlets();    
   this.window.close(this);
   this.parent.portlets[this.position][this.index] = null;   
   this.parent.rePositionPortlets(this); 
   Light.ajax.sendRequest(Light.portal.contextPath+Light.deletePortletRequest, {parameters:'portletId='+this.serverId});       
} 
PortletWindow.prototype.refreshWindow= function () { 
	this.window.refreshWindow(this);
}
PortletWindow.prototype.refreshHeader= function () {
 	this.window.refreshHeader(this);
}
PortletWindow.prototype.refreshWindowTransparent = function () {      
   if(Light.portal.portletWindowTransparent == false && this.transparent == false){
      if(this.contentBgColor.length > 0)
   	  	this.window.container.style.backgroundColor = this.contentBgColor;
   	  else
      	this.window.container.style.backgroundColor = "#ffffff";
   }else{
      this.window.container.style.backgroundColor = "transparent";       
   }   
} 
PortletWindow.prototype.refreshTextColor = function () {  
    var id = this.window.container.id;
    if(this.textColor.length > 0){
    	var elements =$$('#'+id+' a', '#'+id+' td', '#'+id+' text', '#'+id+' textarea', '#'+id+' select', '#'+id+' span');
	    for(var i=0;i<elements.length;i++){
	        elements[i].style.color=this.textColor; 
	    }      
	    elements = null;	    
	 }
	 if(this.contentBgColor.length > 0){
	 	var elements =$$('#'+id+' textarea');
	    for(var i=0;i<elements.length;i++){
	        elements[i].style.backgroundColor=this.contentBgColor; 
	    }      
	    elements = null;
	 }
}
PortletWindow.prototype.getTop = function(){
   return this.window.top;
}
PortletWindow.prototype.getHeight = function(){
   return this.window.window.clientHeight;
}
PortletWindow.prototype.setContent = function(content){
	this.window.setContent(content);
}
//------------------------------------------------------------ PortletPopupWindow.js
function PortletPopupWindow (position,left,width,title,icon,url,request,requestUrl,closeable,refreshMode,editMode,helpMode,configMode,autoRefreshed,refreshAtClient,periodTime,allowJS,barBgColor,barFontColor,contentBgColor,parameter,allowMinimized,allowMaximized,allowPopup,location) {
   Light.portal.allPortlets[Light.portal.allPortlets.size()]=this;
   this.parent = Light.currentTab;
   this.window = new WindowAppearance2();
   this.allowMove = true;
   this.popup= true;
   if(typeof allowPopup != "undefined" && !allowPopup)
   	this.popup= false;
   if(typeof location != "undefined"){
   	this.location=location;
    if(this.location ==1){
    	Light.portal.originalLeft = Light.portal.layout.containerLeft;
    	Light.portal.layout.containerLeft = width + 10;
    	Light.portal.body.style.marginLeft = Light.portal.layout.containerLeft + Light.portal.layout.bodyLeft; 
    	this.allowMove = false;
    }	
   }
   this.mode = Light._VIEW_MODE;
   this.state = Light._NORMAL_STATE;
   this.tIndex = this.parent.index;   
   this.serverId = Date.parse(new Date());//serverId;
   this.position = position;
   this.left = left;
   this.width = width;
   this.title = title;
   this.icon = icon;
   this.url = url;
   this.request = request;
   this.requestUrl = requestUrl;
   this.closeable = closeable;
   this.refreshMode = refreshMode;
   this.editMode = editMode;
   this.helpMode = helpMode;
   this.configMode = configMode;
   this.allowMinimized = true; 
   if(allowMinimized != null && !allowMinimized) this.allowMinimized = false;
   this.allowMaximized = true;
   if(allowMaximized != null && !allowMaximized) this.allowMaximized = false;
   this.autoRefreshed = autoRefreshed;
   this.refreshAtClient = refreshAtClient;
   this.periodTime = periodTime;
   this.allowJS = allowJS;
   this.barBgColor = barBgColor;
   this.barFontColor = barFontColor;   
   this.className = "portlet-popup";
   this.contentBgColor ='#EEF6FF';
   if(contentBgColor !='') this.contentBgColor = contentBgColor;
   this.parameter = parameter;   
   this.index = this.parent.getPortletIndex(this.position);
   var height = 0;
   var maxIndex = 0;
   var nullNum = 0;        

   this.originalTop = this.top;
   this.originalWidth = this.width;
   this.originalLeft = this.left;

   this.parent.portlets[this.position][this.index] = this;
   
   this.window.render(this);
   
   this.minimized = false;
   this.maximized = false;   
   this.moveable = false;
   this.autoRefreshWhenMaximized = false;
   this.autoShow = false;
   this.opacity = 0;
   this.fade="in";
   this.myPictureIndex = 0;
   this.myPictures= new Array();
   this.autoShowId = null;   
   this.mouseDownX = 0;
   this.mouseDownY = 0;
   this.refreshPosition();
   this.loading = Light.getViewTemplate("loadingPortlet.view");
   this.window.container.innerHTML = this.loading;
   this.focus();
   if(this.autoRefreshed){
   	  this.firstTimeAutoRefreshed = true;
   	  this.autoRefresh(this);
   }
   if(this.location == null){
  	this.windowMaximize();
  }
 }  
 PortletPopupWindow.prototype.rememberMode = function(mode){  
}
  
 PortletPopupWindow.prototype.focus = function()
 {
    this.window.focus(this);
 }
 
 PortletPopupWindow.prototype.show = function(){
 	this.window.show(this);
 }
 
 PortletPopupWindow.prototype.hide = function(){
 	this.window.hide(this);
 }
  
 PortletPopupWindow.prototype.moveBegin = function(e)
 {  
  document.body.onselectstart = function() { return false };
  document.body.ondragstart = function() { return false };
  if (document.all) e = event;
  var x = e.clientX;
  var y = e.clientY;
  this.focus();
  this.moveable = true;
  this.mouseDownX = x;
  this.mouseDownY = y;
  this.moveBeginX = x;
  this.moveBeginY = y;

  Light.portal.moveTimer = 0;
  this.startMoveTimer(this);
 }
 
 PortletPopupWindow.prototype.moveEnd = function()
 {    
   if(this.moveable){    
    this.moveable = false;  
    this.originalLeft = this.left;
    this.originalTop = this.top; 
    
  }
 }

 PortletPopupWindow.prototype.move = function(e)
 { 	
   if(this.moveable){
    var x = e.clientX;
    var y = e.clientY;
    this.left += x - this.mouseDownX;
    this.top  += y - this.mouseDownY;    
    this.refreshPosition();   
    this.mouseDownX = x;
    this.mouseDownY = y;
  }
 }

 PortletPopupWindow.prototype.startMoveTimer = function(portlet)
  {
   if (Light.portal.moveTimer>=0 && Light.portal.moveTimer<10){
    Light.portal.moveTimer++;
    setTimeout((function() {portlet.startMoveTimer (portlet)}), 15);
   }
   if (Light.portal.moveTimer == 10) {
    Light.portal.dragDropPortlet = this;
    portlet.refreshPosition();
    }
  }

 PortletPopupWindow.prototype.refreshPosition = function()
 { 
	this.window.position(this);
    this.focus();
 }

PortletPopupWindow.prototype.autoRefresh = function(portlet)
 {
   if(portlet.autoRefreshed){       
       if(portlet.firstTimeAutoRefreshed){
       	  portlet.firstTimeAutoRefreshed = false;
       }else{
       	  portlet.selfRefresh();
       }
       setTimeout((function() {portlet.autoRefresh (portlet)}), portlet.periodTime);
    }
 }
 
PortletPopupWindow.prototype.selfRefresh = function()
 {   	
   if(!this.minimized && (!this.maximized || this.autoRefreshWhenMaximized)){
	   if(this.mode == Light._VIEW_MODE){
	    if(this.refreshAtClient){
	      Light.refreshAtClient(this);	        
	    }else{
          this.refreshAction = true;
	      Light.executeRefresh(Light._PC_PREFIX+this.serverId);
	    }
	   }
   }
   if(this.minimized && this.path == "/myMessagePortlet.lp"){
      this.refreshPortletTitle();
   }
 } 
PortletPopupWindow.prototype.refresh = function(flag)
 {   
  if(Light.executeAtClient(this)) return;
  if(flag == null || flag == true){
	this.window.container.innerHTML = this.loading;
  }
  this.parent.rePositionPortlets(this);  	    
  this.refreshAction = true;
  Light.executeRefresh(Light._PC_PREFIX+this.serverId);
 }

PortletPopupWindow.prototype.changePosition = function()
{
   var params = "responseId="+Light._PC_PREFIX+this.serverId
      		    +"&tabId="+this.parent.tabServerId
      		    +"&portletId="+this.serverId
                +"&column="+this.position
                +"&row="+this.index;
   Light.ajax.sendRequest(Light.portal.contextPath+Light.changePositionRequest,{parameters:params});   
   this.parent.rePositionPortlets(this);    
 }

PortletPopupWindow.prototype.edit = function()
 {
   if(this.editMode){ 
        this.mode= Light._EDIT_MODE;
        var id = Light._PC_PREFIX+this.serverId;
        Light.executePortlet(id);
        this.window.refreshButtons(this);
    }
 }

PortletPopupWindow.prototype.cancelEdit = function()
 {
   if(this.editMode){
    this.mode= Light._VIEW_MODE;
    var id = Light._PC_PREFIX+this.serverId;
    Light.executePortlet(id);
	this.window.refreshButtons(this);
   }
 }
 
PortletPopupWindow.prototype.help = function()
 {
   if(this.helpMode){ 
        this.mode = Light._HELP_MODE;   
        var id = Light._PC_PREFIX+this.serverId;
        Light.executePortlet(id);
    	this.window.refreshButtons(this);
    }
 }
 
PortletPopupWindow.prototype.cancelHelp = function()
 {
   if(this.helpMode){
    this.mode = Light._VIEW_MODE;
    var id = Light._PC_PREFIX+this.serverId;
    Light.executePortlet(id);
    this.window.refreshButtons(this);
   }
 }

PortletPopupWindow.prototype.config = function()
 {
   if(this.configMode){ 
        this.mode = Light._CONFIG_MODE;   
    	this.window.refreshButtons(this);
    	var data = {	     
		     id : Light._PC_PREFIX+this.serverId,
		     title : this.title,
		     barBgColor : this.barBgColor,
		     barFontColor :this.barFontColor,
		     contentBgColor : this.contentBgColor,
		     textColor : this.textColor,
		     transparent : this.transparent
		   };
		   
	   this.window.container.innerHTML = TrimPath.processDOMTemplate("configMode.jst",data);
	   Light.responsePortlet(data.id);
    }
 }
 
PortletPopupWindow.prototype.cancelConfig = function()
 {
   if(this.configMode){
    this.mode = Light._VIEW_MODE;
    var id = Light._PC_PREFIX+this.serverId;
    Light.executePortlet(id);
    this.window.refreshButtons(this);
   }
 }
 
PortletPopupWindow.prototype.moveCancel = function()
 {    
    this.buttonIsClicked = true;
 }
 
PortletPopupWindow.prototype.moveAllowed = function()
 {    
    this.buttonIsClicked = false;
 }
 
PortletPopupWindow.prototype.moveUp = function()
 {
   if(this.index > 0){
     var temp = null;
     var upIndex = 0;
     var currentIndex = this.index;
     var started = this.index - 1;                 
        for(var i=started;i>=0;i--){
           if(this.parent.portlets[this.position][i] != null){
             temp = this.parent.portlets[this.position][i];
             upIndex = i;
             break;
           }
        }               
        if(temp != null){
          temp.index = this.index;
          this.index = upIndex; 
          this.parent.portlets[this.position][upIndex] = this;
          this.parent.portlets[this.position][currentIndex] = temp; 
          temp.changePosition();
          temp.lastAction = null;
    	  if(!temp.minimized){ 
		    temp.refresh(false);   
		  }   
          this.left = 0;
    	  for(var i=0;i<this.position;i++) { 
        	this.left += this.parent.widths[i] + this.parent.between;
    	  }
          this.changePosition();      
        }     
   }
 }
 
 PortletPopupWindow.prototype.moveDown = function()
 {
    var temp = null;
    var downIndex = 0;
    var currentIndex = this.index;
    var started = this.index + 1;                  
    for(var i=started;i<this.parent.portlets[this.position].length;i++){
       if(this.parent.portlets[this.position][i] != null){
         temp = this.parent.portlets[this.position][i];
         downIndex = i;
         break;
       }
    }               
    if(temp != null){
      temp.index = this.index;
      this.index = downIndex;        
      this.parent.portlets[this.position][downIndex] = this;
      this.parent.portlets[this.position][currentIndex] = temp;          
      this.changePosition();
      this.left = 0;
    	  for(var i=0;i<this.position;i++) { 
        	this.left += this.parent.widths[i] + this.parent.between;
    	  }
      temp.changePosition(); 
      temp.lastAction = null;
      if(!temp.minimized){ 
	    temp.refresh(false);   
	  }              
    }    
 }
 
 PortletPopupWindow.prototype.moveLeft = function()
 {
   
 }
 
 PortletPopupWindow.prototype.moveRight = function()
 {      
   
 }

 PortletPopupWindow.prototype.minimize = function()
 { 
   this.minimized = !this.minimized;
   if(this.minimized){
    this.state = Light._MINIMIZED_STATE;
    if(this.maximized){
       this.maximize(false);   
       this.minimized = true;     
    }
    var empty = "<br/>";//"<img src='"+Light.portal.contextPath+"/light/images/spacer.gif' height='20' style='border: 0px' width='200' alt='' />";
    this.window.container.innerHTML = empty;         
  }else{    
    this.state = Light._NORMAL_STATE;     
  }
   this.window.minimize(this);
   this.parent.rePositionPortlets(this);      
   if(!this.minimized)
      Light.executeRefresh(Light._PC_PREFIX+this.serverId); 
 }
 
 PortletPopupWindow.prototype.maximize = function(flag)
 { 
   this.windowMaximize(flag);
   this.refresh(); 
 }
  
 PortletPopupWindow.prototype.windowMaximize = function(flag)
 { 
   this.maximized = !this.maximized; 
   if(!this.maximized){  
      this.state = Light._NORMAL_STATE;         
      this.top  = this.originalTop; 	
	  this.width = this.originalWidth;
      this.left = this.originalLeft;    
 	  Light.portal.container.style.zIndex= 1; 	  
 	  this.parent.showOtherPortlets();	
   }else{        
        this.state = Light._MAXIMIZED_STATE;       
   	    this.left = Light.portal.layout.maxLeft;
   	    this.top = Light.portal.layout.maxTop;
        this.width = Light.portal.layout.maxWidth;          
        Light.portal.container.style.zIndex= ++Light.maxZIndex; 
        Light.portal.body.style.zIndex= ++Light.maxZIndex;
        Light.portal.footer.style.zIndex= ++Light.maxZIndex;  
 	  	this.parent.hideOtherPortlets(this);  	      	
   }        
   this.window.maximize(this);  
   this.parent.rePositionPortlets(this);   
   
 } 
 
 PortletPopupWindow.prototype.close = function()
 {      
   this.window.close(this);
   this.parent.portlets[this.position][this.index] = null;  
   if(this.maximized)   
     this.parent.showOtherPortlets();   
   this.parent.rePositionPortlets(this); 
   if(Light.portal.originalLeft != null){
   	Light.portal.layout.containerLeft = Light.portal.originalLeft;
	Light.portal.body.style.marginLeft = Light.portal.layout.containerLeft + Light.portal.layout.bodyLeft;
	Light.portal.originalLeft = null; 
   }
 } 
 
PortletPopupWindow.prototype.refreshButtons = function()
 {
	this.window.refreshButtons(this);
 }
PortletPopupWindow.prototype.refreshWindow= function () { 
	this.window.refreshWindow(this);
 }
 
PortletPopupWindow.prototype.refreshHeader= function () {
 	this.window.refreshHeader(this);
 }
PortletPopupWindow.prototype.refreshWindowTransparent = function () {      
 }
PortletPopupWindow.prototype.refreshTextColor = function () {}
PortletPopupWindow.prototype.getTop = function(){
   return this.window.top;
}
PortletPopupWindow.prototype.getHeight = function(){
   return this.window.container.clientHeight;
}
PortletPopupWindow.prototype.setContent = function(content){
	this.window.container.innerHTML = content;	
}