
function PortletChatWindow(position,left,width,title,icon,url,request,requestUrl,closeable,refreshMode,editMode,helpMode,configMode,autoRefreshed,refreshAtClient,periodTime,allowJS,barBgColor,barFontColor,contentBgColor,parameter,allowMinimized,allowMaximized){Light.portal.allPortlets[Light.portal.allPortlets.size()]=this;this.parent=Light.currentTab;this.window=new WindowAppearance11();this.popup=true;this.mode=Light._VIEW_MODE;this.state=Light._NORMAL_STATE;this.tIndex=this.parent.index;this.serverId=Date.parse(new Date());this.position=position;this.left=left;this.width=width;this.title=title;this.icon=icon;this.url=url;this.request=request;this.requestUrl=requestUrl;this.closeable=closeable;this.refreshMode=refreshMode;this.editMode=editMode;this.helpMode=helpMode;this.configMode=configMode;this.allowMinimized=true;if(allowMinimized!=null&&!allowMinimized)this.allowMinimized=false;this.allowMaximized=true;if(allowMaximized!=null&&!allowMaximized)this.allowMaximized=false;this.autoRefreshed=autoRefreshed;this.refreshAtClient=refreshAtClient;this.periodTime=periodTime;this.allowJS=allowJS;this.barBgColor=barBgColor;this.barFontColor=barFontColor;this.className="portlet-popup";this.contentBgColor='#EEF6FF';if(contentBgColor!='')this.contentBgColor=contentBgColor;this.parameter=parameter;this.index=this.parent.getPortletIndex(this.position);var height=0;var maxIndex=0;var nullNum=0;this.originalTop=this.top;this.originalWidth=this.width;this.originalLeft=this.left;this.parent.portlets[this.position][this.index]=this;this.window.render(this);this.minimized=false;this.maximized=false;this.moveable=false;this.autoRefreshWhenMaximized=false;this.autoShow=false;this.opacity=0;this.fade="in";this.myPictureIndex=0;this.myPictures=new Array();this.autoShowId=null;this.mouseDownX=0;this.mouseDownY=0;this.refreshPosition();this.focus();if(this.autoRefreshed){this.firstTimeAutoRefreshed=true;this.autoRefresh(this);}}
PortletChatWindow.prototype.rememberMode=function(mode){}
PortletChatWindow.prototype.focus=function()
{this.window.focus(this);}
PortletChatWindow.prototype.show=function(){this.window.show(this);}
PortletChatWindow.prototype.hide=function(){this.window.hide(this);}
PortletChatWindow.prototype.moveBegin=function(e)
{document.body.onselectstart=function(){return false};document.body.ondragstart=function(){return false};if(document.all)e=event;var x=e.clientX;var y=e.clientY;this.focus();this.moveable=true;this.mouseDownX=x;this.mouseDownY=y;this.moveBeginX=x;this.moveBeginY=y;Light.portal.moveTimer=0;this.startMoveTimer(this);}
PortletChatWindow.prototype.moveEnd=function()
{if(this.moveable){this.moveable=false;this.originalLeft=this.left;this.originalTop=this.top;}}
PortletChatWindow.prototype.move=function(e)
{if(this.moveable){var x=e.clientX;var y=e.clientY;this.left+=x-this.mouseDownX;this.top+=y-this.mouseDownY;this.refreshPosition();this.mouseDownX=x;this.mouseDownY=y;}}
PortletChatWindow.prototype.startMoveTimer=function(portlet)
{if(Light.portal.moveTimer>=0&&Light.portal.moveTimer<10){Light.portal.moveTimer++;setTimeout((function(){portlet.startMoveTimer(portlet)}),15);}
if(Light.portal.moveTimer==10){Light.portal.dragDropPortlet=this;portlet.refreshPosition();}}
PortletChatWindow.prototype.refreshPosition=function()
{this.window.position(this);this.focus();}
PortletChatWindow.prototype.autoRefresh=function(portlet)
{if(portlet.autoRefreshed){if(portlet.firstTimeAutoRefreshed){portlet.firstTimeAutoRefreshed=false;}else{portlet.selfRefresh();}
setTimeout((function(){portlet.autoRefresh(portlet)}),portlet.periodTime);}}
PortletChatWindow.prototype.selfRefresh=function()
{if(!this.minimized&&(!this.maximized||this.autoRefreshWhenMaximized)){if(this.mode==Light._VIEW_MODE){this.refresh();}}
if(this.minimized&&this.path=="/myMessagePortlet.lp"){this.refreshPortletTitle();}}
PortletChatWindow.prototype.refresh=function(flag)
{var id=Light._PC_PREFIX+this.serverId;this.refreshAction=true;Light.executeRefresh(id);}
PortletChatWindow.prototype.changePosition=function()
{var params="responseId="+Light._PC_PREFIX+this.serverId
+"&tabId="+this.parent.tabServerId
+"&portletId="+this.serverId
+"&column="+this.position
+"&row="+this.index;Light.ajax.sendRequest(Light.portal.contextPath+Light.changePositionRequest,{parameters:params});this.parent.rePositionPortlets(this);}
PortletChatWindow.prototype.edit=function()
{if(this.editMode){this.mode=Light._EDIT_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletChatWindow.prototype.cancelEdit=function()
{if(this.editMode){this.mode=Light._VIEW_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletChatWindow.prototype.help=function()
{if(this.helpMode){this.mode=Light._HELP_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletChatWindow.prototype.cancelHelp=function()
{if(this.helpMode){this.mode=Light._VIEW_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletChatWindow.prototype.config=function()
{if(this.configMode){this.mode=Light._CONFIG_MODE;this.window.refreshButtons(this);var data={id:Light._PC_PREFIX+this.serverId,title:this.title,barBgColor:this.barBgColor,barFontColor:this.barFontColor,contentBgColor:this.contentBgColor,textColor:this.textColor,transparent:this.transparent};this.window.container.innerHTML=TrimPath.processDOMTemplate("configMode.jst",data);Light.responsePortlet(data.id);}}
PortletChatWindow.prototype.cancelConfig=function()
{if(this.configMode){this.mode=Light._VIEW_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletChatWindow.prototype.moveCancel=function()
{this.buttonIsClicked=true;}
PortletChatWindow.prototype.moveAllowed=function()
{this.buttonIsClicked=false;}
PortletChatWindow.prototype.moveUp=function()
{if(this.index>0){var temp=null;var upIndex=0;var currentIndex=this.index;var started=this.index-1;for(var i=started;i>=0;i--){if(this.parent.portlets[this.position][i]!=null){temp=this.parent.portlets[this.position][i];upIndex=i;break;}}
if(temp!=null){temp.index=this.index;this.index=upIndex;this.parent.portlets[this.position][upIndex]=this;this.parent.portlets[this.position][currentIndex]=temp;temp.changePosition();temp.lastAction=null;if(!temp.minimized){temp.refresh(false);}
this.left=this.parent.between;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
this.changePosition();}}}
PortletChatWindow.prototype.moveDown=function()
{var temp=null;var downIndex=0;var currentIndex=this.index;var started=this.index+1;for(var i=started;i<this.parent.portlets[this.position].length;i++){if(this.parent.portlets[this.position][i]!=null){temp=this.parent.portlets[this.position][i];downIndex=i;break;}}
if(temp!=null){temp.index=this.index;this.index=downIndex;this.parent.portlets[this.position][downIndex]=this;this.parent.portlets[this.position][currentIndex]=temp;this.changePosition();this.left=this.parent.between;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
temp.changePosition();temp.lastAction=null;if(!temp.minimized){temp.refresh(false);}}}
PortletChatWindow.prototype.moveLeft=function(){}
PortletChatWindow.prototype.moveRight=function(){}
PortletChatWindow.prototype.minimize=function()
{this.minimized=!this.minimized;if(this.minimized){this.state=Light._MINIMIZED_STATE;if(this.maximized){this.maximize(false);this.minimized=true;}
var empty="<br/>";this.window.container.innerHTML=empty;}else{this.state=Light._NORMAL_STATE;}
this.window.minimize(this);this.parent.rePositionPortlets(this);if(!this.minimized)
Light.executeRefresh(Light._PC_PREFIX+this.serverId);}
PortletChatWindow.prototype.maximize=function(flag)
{this.windowMaximize(flag);this.refresh();}
PortletChatWindow.prototype.windowMaximize=function(flag)
{this.maximized=!this.maximized;if(!this.maximized){this.state=Light._NORMAL_STATE;this.parent.showOtherPortlets();this.top=this.originalTop;this.width=this.originalWidth;this.left=this.originalLeft;Light.portal.container.style.zIndex=1;}else{this.state=Light._MAXIMIZED_STATE;this.parent.hideOtherPortlets(this);this.left=Light.portal.layout.maxLeft;this.top=Light.portal.layout.maxTop;this.width=Light.portal.layout.maxWidth;Light.portal.container.style.zIndex=++Light.maxZIndex;Light.portal.body.style.zIndex=++Light.maxZIndex;Light.portal.footer.style.zIndex=++Light.maxZIndex;}
this.window.maximize(this);this.parent.rePositionPortlets(this);}
PortletChatWindow.prototype.close=function()
{var closePortlet=confirm($('_COMMAND_CLOSE_POPUP_PORTLET').title);if(!closePortlet)
{return;}
new Ajax.Request(Light.portal.contextPath+Light.closeChat,{parameters:this.parameter});if(this.maximized)
this.parent.showOtherPortlets();this.window.close(this);this.parent.portlets[this.position][this.index]=null;this.parent.rePositionPortlets(this);}
PortletChatWindow.prototype.refreshButtons=function()
{this.window.refreshButtons(this);}
PortletChatWindow.prototype.refreshWindow=function(){this.window.refreshWindow(this);}
PortletChatWindow.prototype.refreshHeader=function(){this.window.refreshHeader(this);}
PortletChatWindow.prototype.refreshWindowTransparent=function(){}
PortletChatWindow.prototype.refreshTextColor=function(){}
PortletChatWindow.prototype.getTop=function(){return this.window.top;}
PortletChatWindow.prototype.getHeight=function(){return this.window.container.clientHeight;}
PortletChatWindow.prototype.setContent=function(content){this.window.container.container.innerHTML=content;}
function AddBuddy(id){var portlet=Light.getPortletById(id);Light.ajax.sendRequest(portlet.request,"responseId="+id,"mode=EDIT","tabId="+portlet.parent.tabServerId,"portletId="+portlet.serverId);}
function showBuddyDetail(e,userId,id){var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft;y=event.clientY+document.body.scrollTop-100;}else{x=e.pageX;y=e.pageY-100;}
var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('buddyDetail');if(old!=null)vdocument.removeChild(old);var vBuddyDetail=document.createElement('span');vBuddyDetail.id="buddyDetail";vBuddyDetail.style.position="absolute";vBuddyDetail.onmouseout=function(){hideBuddyDetail();}
vBuddyDetail.className="portlet-popup";if(document.all){vBuddyDetail.style.posLeft=x;vBuddyDetail.style.posTop=y;}else{vBuddyDetail.style.left=x;vBuddyDetail.style.top=y;}
vdocument.appendChild(vBuddyDetail);var params="userId="+userId
+"&responseId="+id;new Ajax.Request(Light.portal.contextPath+Light.getUserDetail,{parameters:params,onSuccess:responseUserDetail});}
responseUserDetail=function(t){var userDetails=t.responseText.split(",");var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('buddyDetail');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
vdocument.removeChild(old);var vBuddyDetail=document.createElement('span');vBuddyDetail.id="buddyDetail";vBuddyDetail.style.position="absolute";vBuddyDetail.className="portlet-popup";if(document.all){vBuddyDetail.style.posLeft=x;vBuddyDetail.style.posTop=y;}else{vBuddyDetail.style.left=x;vBuddyDetail.style.top=y;}
vBuddyDetail.style.width=360;var inHtml="<span title='"+$('_CLOSE').title+"' width='100%' style='clear: both; display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideBuddyDetail();'><img src='"+Light.getThemePath()+"/images/close_on.gif' style='border: 0px;'/></a></span>"
+"<table border='0' cellpadding='0' cellspacing='0' >"
+"<tr>"
+"<td class='portlet-table-td-left'>"
+"<input type='button' value='"+$('_BUTTON_MESSAGE').title+"' "
+" onclick='javascript:hideBuddyDetail();showSendMessageMember(\""+userDetails[0]+"\",\""+userDetails[1]+"\",\""+userDetails[7]+"\");'class='portlet-form-button'/>"
+"</td>"
+"<td class='portlet-table-td-left'>";if(userDetails[2]=='0'){inHtml+="<input type='button' value='"+$('_BUTTON_ADD_BUDDY').title+"'"
+" class='portlet-form-button'"
+" onclick='javascript:hideBuddyDetail();saveAddBuddy(\""+userDetails[1]+"\",\""+userDetails[0]+"\");'/>"
+"</td>";}else{inHtml+="<input type='button' value='"+$('_BUTTON_CHAT').title+"'";if(userDetails[3]=='0')
inHtml+=" disabled='true' class='portlet-form-button-disabled'";else
inHtml+=" class='portlet-form-button'";inHtml+=" onclick='javascript:hideBuddyDetail();chatWithBuddy(\""+userDetails[1]+"\");'/>"
+"</td>"
+"<td class='portlet-table-td-left'>"
+"<input type='button' value='"+$('_BUTTON_DELETE').title+"'"
+" onclick='javascript:hideBuddyDetail();deleteBuddy(\""+userDetails[1]+"\",\""+userDetails[0]+"\");' class='portlet-form-button'/>"
+"</td>";}
inHtml+="</tr>"
+"</table>"
+"<table border='0' cellpadding='0' cellspacing='0'>"
+"<tr><td class='portlet-table-td-left'>"
+userDetails[4]
+"</td></tr>"
+"<tr><td class='portlet-table-td-left'>"
+userDetails[5]
+"</td></tr>"
+"</table>";if(userDetails.length>8){inHtml+="<form name='buddyDetail_"+userDetails[0]+"'>"
+"<table border='0' cellpadding='0' cellspacing='0'>"
+"<tr><td class='portlet-table-td-left'>"
+userDetails[8]+": ";inHtml+="<select name='friendType' size='1'  class='portlet-form-select'>"
inHtml+="<option ";if(userDetails[9]==0)inHtml+="selected='selected' ";inHtml+="value='0'>Friend</option>";inHtml+="<option ";if(userDetails[9]==1)inHtml+="selected='selected' ";inHtml+="value='1'>Family</option>";inHtml+="<option ";if(userDetails[9]==2)inHtml+="selected='selected' ";inHtml+="value='2'>Close Friend</option>";inHtml+="<option ";if(userDetails[9]==3)inHtml+="selected='selected' ";inHtml+="value='3'>Classmate</option>";inHtml+="<option ";if(userDetails[9]==4)inHtml+="selected='selected' ";inHtml+="value='4'>Colleague</option>";inHtml+="</select>"
inHtml+="<input type='button' value='"+$('_BUTTON_SAVE').title+"'"
+" onclick='javascript:saveBuddyType(\""+userDetails[1]+"\",\""+userDetails[0]+"\");' class='portlet-form-button'/>"
+"</td></tr>"
+"</table>"
+"</form>";}
vBuddyDetail.innerHTML=inHtml;vBuddyDetail.style.zIndex=Light.maxZIndex;vdocument.appendChild(vBuddyDetail);}}
hideBuddyDetail=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('buddyDetail');if(old!=null)vdocument.removeChild(old);}
saveAddBuddy=function(buddyId,id){var params="responseId="+id+"&buddyId="+buddyId;new Ajax.Request(Light.portal.contextPath+Light.addFriendRequest,{parameters:params,onSuccess:responseSaveAddBuddy});}
responseSaveAddBuddy=function(t){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,popupName:'responseAddToFriend'};createPopupDiv('responseAddToFriend','responseAddToFriend.jst',280,data,null,t.responseText);}
saveBuddyType=function(userId,id){var type=document.forms['buddyDetail_'+id]['friendType'].value;var params="userId="+userId
+"&responseId="+id
+"&type="+type;new Ajax.Request(Light.portal.contextPath+Light.saveBuddyType,{parameters:params,onSuccess:responseBuddy});}
deleteBuddy=function(userId,id){var params="userId="+userId
+"&responseId="+id;new Ajax.Request(Light.portal.contextPath+Light.deleteBuddy,{parameters:params,onSuccess:responseBuddy});}
responseBuddy=function(t){hideBuddyDetail();var portlet=Light.getPortletById(t.responseText);portlet.refresh();}
emailToBuddy=function(userId){}
chatWithBuddy=function(userId){hideBuddyDetail();var params="userId="+userId;new Ajax.Request(Light.portal.contextPath+Light.chatWithBuddy,{parameters:params,onSuccess:responseChatWithBuddy});}
responseChatWithBuddy=function(t){var chatParams=t.responseText.split(",");if(chatParams[1]==0){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,userName:chatParams[0],popupName:'isBlockUser'};createPopupDiv('isBlockUser','isBlockUser.jst',360,data,null,null);return;}
if(chatParams[1]=="n"){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,userName:chatParams[0],popupName:'noIM'};createPopupDiv('noIM','noIM.jst',360,data,null,null);return;}
if(chatParams[1]=="f"){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,userName:chatParams[0],popupName:'friendOnlyIM'};createPopupDiv('friendOnlyIM','friendOnlyIM.jst',360,data,null,null);return;}
var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var portlet=new PortletChatWindow(12,200,600,$('_TITLE_CHAT').title+chatParams[0],"","","chattingPortlet",Light.portal.contextPath+"/chattingPortlet.lp",true,false,false,false,false,true,false,5000,true,'','','',"chattingId="+chatParams[1]);portlet.refresh();document.forms['form_'+Light._PC_PREFIX+portlet.serverId]['chat'].focus();}
keyDownChat=function(e,id){var KeyID;if(window.event){keyID=window.event.keyCode;}else{keyID=e.which;}
if(keyID==13){sendChatMessage(id);}
return!(keyID==13);}
sendChatMessage=function(id){var chat=document.forms['form_'+id]['chat'].value;var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+portlet.parent.tabServerId
+"&portletId="+portlet.serverId
+"&action=send"
+"&"+portlet.parameter
+"&chat="+encodeURIComponent(chat);Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:false,parameters:pars});document.forms['form_'+id]['chat'].value="";document.forms['form_'+id]['chat'].focus();}
function acceptChat(param){hideResponseChat();var chatParams=param.split(",");Light.ajax.sendRequest(Light.portal.contextPath+Light.acceptChat,{parameters:"chattingId="+chatParams[2]});var portlet=new PortletChatWindow(12,200,600,$('_TITLE_CHAT').title+chatParams[1],"","","chattingPortlet",Light.portal.contextPath+"/chattingPortlet.lp",true,false,false,false,false,true,false,5000,true,'','','',"chattingId="+chatParams[2]);portlet.refresh();document.forms['form_'+Light._PC_PREFIX+portlet.serverId]['chat'].focus();}
function refuseChat(param){hideResponseChat();var params=param.split(",");Light.ajax.sendRequest(Light.portal.contextPath+Light.refuseChat,{parameters:"chattingId="+params[2]});}
function hideResponseChat(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('instantMessage');if(old!=null)vdocument.removeChild(old);}