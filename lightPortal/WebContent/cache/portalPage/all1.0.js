
var Light={Version:'1.0.0',_ON:"LightPortalOn",_DEFAULT_CONTEXT_PATH:"",_THEME_ROOT:"/light/theme/",_USER_ID:"LightPortalUserId",_LOGINED_USER_ID:"LightPortalLoginedUserId",_REMEMBERED_USER_ID:"LightPortalRememberedUserId",_REMEMBERED_USER_PASSWORD:"LightPortalRememberedUserPassword",_IS_SIGN_OUT:"LightPortalIsSignOut",_USER_LOCALE:"LightPortalUserLocale",_CURRENT_TAB:"LightPortalCurrentTab",_PC_PREFIX:"portletContent_",_VIEW_MODE:"view",_EDIT_MODE:"edit",_HELP_MODE:"help",_CONFIG_MODE:"config",_NORMAL_STATE:"normal",_MINIMIZED_STATE:"minimized",_MAXIMIZED_STATE:"maximized",_GUEST_PORTAL:"guestPortal",_GUEST_PORTAL_TAB:"guestPortalTabs",_MY_PORTAL:"myPortal",_MY_PORTAL_TAB:"myPortalTabs",_SESSION_TIMEOUT:1800000,_SESSION_TIMEOUT_WARNING:120000,maxZIndex:1,checkLoginRequest:"checkLogin.lp",checkVisitRequest:"checkVisit.lp",checkPageRequest:"checkPage.lp",checkGroupRequest:"checkGroup.lp",checkStoreRequest:"checkStore.lp",getPortalRequest:"getPortal.lp",visitPortalRequest:"visitPortal.lp",pagePortalRequest:"pagePortal.lp",groupPortalRequest:"groupPortal.lp",storePortalRequest:"storePortal.lp",businessPortalRequest:"businessPortal.lp",getPortalTabsByUserRequest:"/getPortalTabsByUser.lp",getPortalTabsByVisitRequest:"/getPortalTabsByVisit.lp",getPortalTabsByPageRequest:"/getPortalTabsByPage.lp",getPortalTabsByGroupRequest:"/getPortalTabsByGroup.lp",getPortalTabsByStoreRequest:"/getPortalTabsByStore.lp",getPortalTabsByBusinessRequest:"/getPortalTabsByBusiness.lp",getPortalTabsByParentRequest:"/getPortalTabsByParent.lp",getPortletsByTabRequest:"/getPortletsByTab.lp",getPortletsByVisitTabRequest:"/getPortletsByVisitTab.lp",getPortletsByGroupTabRequest:"/getPortletsByGroupTab.lp",getPortletsByStoreTabRequest:"/getPortletsByStoreTab.lp",getDefaultViewTemplatesRequest:"/getDefaultViewTemplates.lp",getPortalViewTemplatesRequest:"/getPortalViewTemplates.lp",getPortletViewTemplatesRequest:"/getPortletViewTemplates.lp",getScriptsRequest:"/getScripts.lp",addSubPageRequest:"/addSubPage.lp",changeTitle:"/changeTitle.lp",changeLanguageRequest:"/changeLanguage.lp",changeRegion:"/changeRegion.lp",changeTimeZone:"/changeTimeZone.lp",changeGeneral:"/changeGeneral.lp",changeThemeRequest:"/changeTheme.lp",addTabRequest:"/addTab.lp",editTabRequest:"/editTab.lp",manageTabRequest:"/manageTab.lp",editTabTitleRequest:"/editTabTitle.lp",addContentRequest:"/addContent.lp",getPortletTitle:"/getPortletTitle.lp",loginRequest:"/login.lp",logoutRequest:"/logout.lp",signUpRequest:"/signUp.lp",profileRequest:"/profile.lp",deletePortletRequest:"/deletePortlet.lp",deleteTabRequest:"/deleteTab.lp",changePositionRequest:"/changePosition.lp",countDownloadRequest:"/countDownload.lp",getRssDesc:"/getRssDesc.lp",uploadOpml:"/uploadOpml.lp",getFeedbackDesc:"/getFeedbackDesc.lp",getUserDetail:"/getUserDetail.lp",chatWithBuddy:"/chatWithBuddy.lp",chatWithProfile:"/chatWithProfile.lp",acceptChat:"/acceptChat.lp",refuseChat:"/refuseChat.lp",closeChat:"/closeChat.lp",deleteBuddy:"/deleteBuddy.lp",getForumDesc:"/getForumDesc.lp",getForumDetail:"/getForumDetail.lp",saveForumReply:"/saveForumReply.lp",getBlogDesc:"/getBlogDesc.lp",getBlogDetail:"/getBlogDetail.lp",saveBlogComment:"/saveBlogComment.lp",getBlogComments:"/getBlogComments.lp",popBlog:"/popBlog.lp",getTodoDesc:"/getTodoDesc.lp",listenServerRequest:"/listenServer.lp",checkMyUrl:"/checkMyUrl.lp",saveMyUrl:"/saveMyUrl.lp",saveComment:"/saveComment.lp",sendMessageRequest:"/sendMessage.lp",addFriendRequest:"/addFriendRequest.lp",addToFavorites:"/addToFavorites.lp",forwardToFriends:"/forwardToFriends.lp",blockUser:"/blockUser.lp",turnToMyAccount:"/turnToMyAccount.lp",rememberState:"/rememberState.lp",rememberMode:"/rememberMode.lp",joinToGroup:"/joinToGroup.lp",inviteToGroup:"/inviteToGroup.lp",validateGroupUri:"/validateGroupUri.lp",validateUserId:"/validateUserId.lp",validateMyUri:"/validateMyUri.lp",validateMyStoreUri:"/validateMyStoreUri.lp",resignGroup:"/resignGroup.lp",getGroupPrivacy:"/getGroupPrivacy.lp",saveGroupPrivacy:"/saveGroupPrivacy.lp",deleteGroupProfile:"/deleteGroupProfile.lp",chatWithMember:"/chatWithMember.lp",saveNote:"/saveNote.lp",trackRssItem:"/trackRssItem.lp",readRecommendedItem:"/readRecommendedItem.lp",readViewedItem:"/readViewedItem.lp",readPopItem:"/readPopItem.lp",popRssItem:"/popRssItem.lp",popBlogItem:"/popBlogItem.lp",popDeliItem:"/popDeliItem.lp",popBookmarkItem:"/popBookmarkItem.lp",popYouTubeItem:"/popYouTubeItem.lp",popForumItem:"/popForumItem.lp",popTopicItem:"/popTopicItem.lp",popGroupForumItem:"/popGroupForumItem.lp",popGroupTopicItem:"/popGroupTopicItem.lp",forwardRssToFriend:"/forwardRssToFriend.lp",forwardBlogToFriend:"/forwardBlogToFriend.lp",forwardDeliToFriend:"/forwardDeliToFriend.lp",forwardBookmarkToFriend:"/forwardBookmarkToFriend.lp",forwardYouTubeToFriend:"/forwardYouTubeToFriend.lp",forwardForumToFriend:"/forwardForumToFriend.lp",forwardTopicToFriend:"/forwardTopicToFriend.lp",forwardGroupForumToFriend:"/forwardGroupForumToFriend.lp",forwardGroupTopicToFriend:"/forwardGroupTopicToFriend.lp",getPopItemDesc:"/getPopItemDesc.lp",getRecommendedItemDesc:"/getRecommendedItemDesc.lp",getViewedItemDesc:"/getViewedItemDesc.lp",saveToHeader:"/saveToHeader.lp",saveToBackground:"/saveToBackground.lp",saveToBookmark:"/saveToBookmark.lp",saveToMyPicture:"/saveToMyPicture.lp",saveBlogToBookmark:"/saveBlogToBookmark.lp",getBookmarkDesc:"/getBookmarkDesc.lp",getDeliDesc:"/getDeliDesc.lp",getInternalNewsDesc:"/getInternalNewsDesc.lp",getAdDesc:"/getAdDesc.lp",getAdComments:"/getAdComments.lp",saveAdComment:"/saveAdComment.lp",popAd:"/popAd.lp",forwardAdToFriend:"/forwardAdToFriend.lp",saveAdToBookmark:"/saveAdToBookmark.lp",saveYouTubeToBookmark:"/saveYouTubeToBookmark.lp",saveForumToBookmark:"/saveForumToBookmark.lp",saveTopicToBookmark:"/saveTopicToBookmark.lp",saveGroupForumToBookmark:"/saveGroupForumToBookmark.lp",saveGroupTopicToBookmark:"/saveGroupTopicToBookmark.lp",saveItemComment:"/saveItemComment.lp",addKeywords:"/addKeywords.lp",deleteKeywords:"/deleteKeywords.lp",addNotKeywords:"/addNotKeywords.lp",deleteNotKeywords:"/deleteNotKeywords.lp",addNotWords:"/addNotWords.lp",deleteNotWords:"/deleteNotWords.lp",saveBuddyType:"/saveBuddyType.lp",configMyPicture:"/configMyPicture.lp",changeMode:"/changeMode.lp",getProductDesc:"/getProductDesc.lp",logo:"/light/images/logo.png",portal:null,serverError:false,userId:null}
window.onload=function(){Light.switchPortal();Light.cacheArray=new Array();}
window.onresize=function(){if(Light.getCookie(Light._ON)=="on"){Light.portal.resize();}}
document.onmousedown=function(){Light.setSessionTimer();}
document.onkeydown=function(){Light.setSessionTimer();}
Light.reloadPortal=function(){Light.resetCache();window.location.reload(true);}
Light.refreshPortal=function(){Light.switchPortal();Light.switchPortal();}
Light.switchPortal=function(){if(Light.portal==null){Light.ajax=new Light.Ajax();Light.service=new Light.Service();Light.portal=new LightPortal();Light.getPortalViewTemplates();Light.getPortletViewTemplates();Light.getScripts();}
if(Light.portal.turnedOn){Light.portal.turnOff();}else{Light.portal.turnOn();Light.setSessionTimer();}}
Light.getViewTemplate=function(viewId,data){var view="";if(document.getElementById(viewId)!=null)
view=TrimPath.processDOMTemplate(viewId,data);return view;}
Light.getAllViewTemplates=function(){Light.getDefaultViewTemplates();Light.getPortalViewTemplates();Light.getPortletViewTemplates();}
Light.getDefaultViewTemplates=function(){Light.ajax.sendRequest(Light.portal.contextPath+Light.getDefaultViewTemplatesRequest,{method:'get',onSuccess:Light.getDefaultViewTemplatesHandler});}
Light.getDefaultViewTemplatesHandler=function(t){if($("defaultView")!=null)
document.body.removeChild($("defaultView"));var vTemplate=document.createElement('div');vTemplate.id="defaultView";vTemplate.innerHTML=t.responseText;document.body.appendChild(vTemplate);vTemplate=null;if(typeof Light.needRefresh!="undefined"&&Light.needRefresh==true){Light.refreshPortal();Light.needRefresh=false;}}
Light.getPortalViewTemplates=function(){Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortalViewTemplatesRequest,{method:'get',onSuccess:Light.getPortalViewTemplatesHandler});}
Light.getPortalViewTemplatesHandler=function(t){if(document.getElementById("portalView")!=null)
document.body.removeChild(document.getElementById("portalView"));var vTemplate=document.createElement('div');vTemplate.id="portalView";vTemplate.innerHTML=t.responseText;document.body.appendChild(vTemplate);vTemplate=null;}
Light.getPortletViewTemplates=function(){Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortletViewTemplatesRequest,{method:'get',onSuccess:Light.getPortletViewTemplatesHandler});}
Light.getPortletViewTemplatesHandler=function(t){if(document.getElementById("portletView")!=null)
document.body.removeChild(document.getElementById("portletView"));var vTemplate=document.createElement('div');vTemplate.id="portletView";vTemplate.innerHTML=t.responseText;document.body.appendChild(vTemplate);vTemplate=null;}
Light.getScripts=function(){Light.ajax.sendRequest(Light.portal.contextPath+Light.getScriptsRequest,{method:'get',onSuccess:Light.getScriptsHandler});}
Light.getPortletById=function(id){var portletIds=id.split("_");if(portletIds.length>2){var tIndex=portletIds[1];var position=portletIds[2];var index=portletIds[3];var portlet=Light.portal.tabs[tIndex].portlets[position][index];return portlet;}else{for(var i=0;i<Light.portal.allPortlets.length;i++){if(Light.portal.allPortlets[i].serverId==portletIds[1])
return Light.portal.allPortlets[i];}}}
Light.executeAction=function(id,pForm,action,actionName,parameter,mode,state,param){var portlet=Light.getPortletById(id);if(document.state!=null){if(document.state=="maximized"&&!portlet.maximized&&portlet.allowMaximized){portlet.windowMaximize();}
if(document.state==Light._NORMAL_STATE&&portlet.maximized&&portlet.allowMaximized){portlet.windowMaximize();}
if(document.state=="minimized"&&portlet.allowMinimized){portlet.windowMinimize(portlet);}}else{if(state!=null){if(state=="maximized"&&!portlet.maximized&&portlet.allowMaximized){portlet.windowMaximize();}
if(state=="minimized"&&portlet.allowMaximized){portlet.windowMaximize();}}}
var aparams=new Array();var forms=$$('#'+id+' form');if(forms!=null&&forms.length>0)
pForm=forms[0];if(pForm==null){forms=$$('#portlet_'+portlet.serverId+' form');if(forms!=null&&forms.length>0)
pForm=forms[0];}
if(pForm!=null&&pForm.elements!=null){for(var i=0;i<pForm.elements.length;i++){var aName=pForm.elements[i].name;var aValue=pForm.elements[i].value;if(!aName){var len=pForm.elements[i].length;for(var j=0;j<len;j++){if(pForm.elements[i][j].checked){aName=pForm.elements[i][j].name;aValue=pForm.elements[i][j].value;aparams.push(aName+"="+aValue);}}}else if(pForm.elements[i].type=="checkbox"&&!pForm.elements[i].checked){aValue=null;}
if(pForm.elements[i].type=="radio"&&!pForm.elements[i].checked){aValue=null;}
if(aValue!=null&&aValue.length>0){aValue=escape(encodeURIComponent(aValue));if(pForm.elements[i].type!="button"&&pForm.elements[i].type!="submit"){aparams.push(aName+"="+aValue);}else{if(action==null){if(actionName==null)
aparams.push(aName+"="+aValue);else if(actionName==aName)
aparams.push(aName+"="+aValue);}}}}}
var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId;if(portlet.parameter.length>0)
pars=pars+"&"+portlet.parameter;var vMode=null;if(document.mode!=null){vMode=document.mode;portlet.mode=document.mode;}else if(mode!=null&&mode.length>0){vMode=mode;portlet.mode=mode;}else{vMode=Light._VIEW_MODE;portlet.mode=Light._VIEW_MODE;}
portlet.refreshButtons();pars=pars+"&mode="+vMode;if(portlet.maximized)
pars=pars+"&state=maximized";if(action!=null&&action.length>0){pars=pars+"&action="+action;}
if(parameter!=null&&parameter.length>0){pars=pars+"&parameter="+escape(parameter);}
for(var i=0;i<aparams.length;i++){pars=pars+"&"+aparams[i];}
if(param!=null){var serverParam=param.split(";");for(var i=0;i<serverParam.length;i++){if(serverParam[i].length>0)
pars=pars+"&"+serverParam[i];}}
if(document.resetLastAction!=null)
portlet.lastAction=null;Light.ajax.sendRequestAndUpdate(portlet.request,id,{method:'post',evalScripts:portlet.allowJS,parameters:pars});document.currentForm=null;document.pressed=null;document.pressedName=null;document.parameter=null;document.mode=null;document.state=null;document.resetLastAction=null;}
Light.executeProcess=function(id,mode,state,param,parameter){var portlet=Light.getPortletById(id);if(state!=null){if(state=="maximized"&&!portlet.maximized&&portlet.allowMaximized){portlet.windowMaximize();}
if(state=="normal"&&portlet.maximized&&portlet.allowMaximized){portlet.windowMaximize();}
if(state=="minimized"){if(!portlet.maximized&&portlet.allowMinimized)
portlet.windowMaximize();return;}}
if(mode==null||mode.length==0){mode=Light._VIEW_MODE;portlet.mode=mode;}else{portlet.mode=mode;portlet.refreshButtons();}
var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&mode="+mode;if(portlet.parameter.length>0)
pars=pars+"&"+portlet.parameter;if(portlet.maximized)
pars=pars+"&state=maximized";if(param!=null){var serverParam=param.split(";");for(var i=0;i<serverParam.length;i++){if(serverParam[i].length>0)
pars=pars+"&"+serverParam[i];}}
if(parameter!=null&&parameter.length>0){pars=pars+"&parameter="+parameter;}
portlet.lastAction=pars;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});document.parameter=null;}
Light.executeRender=function(id,mode,state,param,parameter,supportRefresh){if(supportRefresh==null)supportRefresh=true;var portlet=Light.getPortletById(id);if(state!=null){if(state=="maximized"&&!portlet.maximized&&portlet.allowMaximized){portlet.windowMaximize();}
if(state=="normal"&&portlet.maximized&&portlet.allowMaximized){portlet.windowMaximize();}
if(state=="minimized"){if(!portlet.maximized&&portlet.allowMinimized)
portlet.windowMaximize();return;}}
if(mode==null||mode.length==0){mode=Light._VIEW_MODE;portlet.mode=mode;}else{portlet.mode=mode;portlet.refreshButtons();}
var viewId=portlet.request+"."+portlet.mode;if(portlet.maximized){if(document.getElementById(portlet.request+".max."+portlet.mode)!=null){viewId=portlet.request+".max."+portlet.mode;var data={id:Light._PC_PREFIX+portlet.serverId,userId:Light.getCookie(Light._REMEMBERED_USER_ID)};portlet.window.container.innerHTML=Light.getViewTemplate(viewId,data);Light.getCurrentTab().rePositionPortlets(Light.getCurrentTab().portlets[portlet.position][portlet.index]);return;}}else{if(document.getElementById(viewId)!=null){var data={id:Light._PC_PREFIX+portlet.serverId,userId:Light.getCookie(Light._REMEMBERED_USER_ID)};portlet.window.container.innerHTML=Light.getViewTemplate(viewId,data);Light.getCurrentTab().rePositionPortlets(Light.getCurrentTab().portlets[portlet.position][portlet.index]);return;}}
var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&mode="+mode
+"&isRenderUrl=true";if(portlet.parameter.length>0)
pars=pars+"&"+portlet.parameter;if(portlet.maximized)
pars=pars+"&state=maximized";if(param!=null){var serverParam=param.split(";");for(var i=0;i<serverParam.length;i++){if(serverParam[i].length>0)
pars=pars+"&"+serverParam[i];}}
if(parameter!=null&&parameter.length>0){pars=pars+"&parameter="+parameter;}
if(supportRefresh)
portlet.lastAction=pars;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});document.parameter=null;}
Light.executeRefresh=function(id){var portlet=Light.getPortletById(id);if(portlet.lastAction!=null){var params=portlet.lastAction.split("&");var pars;var index=-1;var index2=-1;for(var i=0;i<params.length;i++){if(params[i].indexOf("state")>=0){index=i;}
if(params[i].indexOf("portletClientWidth")>=0){index2=i;}}
for(var i=0;i<params.length;i++){if(i==0)
pars=params[i];if(i!=index&&i!=index2)
pars=pars+"&"+params[i];}
if(portlet.maximized)
pars=pars+"&state=maximized";if(portlet.refreshAction){portlet.refreshAction=false;pars=pars+"&refresh=true";}
pars=pars+"&portletClientWidth="+portlet.width;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}else{var data={id:Light._PC_PREFIX+portlet.serverId};var rid=this.request+"."+this.mode;if(this.maximized&&document.getElementById(this.request+".max."+this.mode)!=null){rid=this.request+".max."+this.mode;}
if(document.getElementById(rid)!=null){this.container.innerHTML=Light.getViewTemplate(rid,data);Light.portal.tabs[this.tIndex].rePositionPortlets(Light.portal.tabs[this.tIndex].portlets[this.position][this.index]);;}else
Light.executePortlet(id);}}
Light.executePortlet=function(id){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&mode="+portlet.mode;if(portlet.parameter.length>0)
pars=pars+"&"+portlet.parameter;if(portlet.maximized)
pars=pars+"&state=maximized";if(portlet.refreshAction){portlet.refreshAction=false;pars=pars+"&refresh=true";}
portlet.lastAction=pars;pars=pars+"&portletClientWidth="+portlet.width;if(portlet.state==Light._MINIMIZED_STATE&&!portlet.minimized)
portlet.minimize();else if(portlet.state==Light._MAXIMIZED_STATE&&!portlet.maximized)
portlet.maximize();else{Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}}
Light.executeAtClient=function(portlet){var id="portlet"+portlet.serverId;if(portlet.maximized&&$(id+".max."+portlet.mode)!=null){id=id+".max."+portlet.mode;}else{id=id+"."+portlet.mode;}
if($(id)!=null){portlet.window.container.innerHTML=$(id).value;Light.getCurrentTab().rePositionPortlets(Light.getCurrentTab().portlets[portlet.position][portlet.index]);Light.refreshTextFontSize();$(id).remove();return true;}
id=portlet.requestUrl;if(id.lastIndexOf("/")>=0)id=id.substring(id.lastIndexOf("/")+1);if(id.indexOf(".")>0)id=id.substring(0,id.indexOf("."));if(portlet.maximized&&document.getElementById(id+".max."+portlet.mode)!=null){id=id+".max."+portlet.mode;}else{id=id+"."+portlet.mode;}
if($(id)!=null){var data={id:Light._PC_PREFIX+portlet.serverId,userId:Light.getCookie(Light._REMEMBERED_USER_ID)};portlet.window.container.innerHTML=Light.getViewTemplate(id,data);Light.getCurrentTab().rePositionPortlets(Light.getCurrentTab().portlets[portlet.position][portlet.index]);return true;}else{return false;}}
Light.autoListenServer=function(){if(Light.getCookie(Light._LOGINED_USER_ID)!=null&&Light.getCookie(Light._LOGINED_USER_ID)!=""){Light.listenServer();}}
Light.listenServer=function(){var opt={method:'post',postBody:'',onSuccess:function(t){Light.responseListenServer(t);},on404:function(t){Light.serverError=true;alert('Error 404: location "'+t.statusText+'" was not found.');},onFailure:function(t){Light.serverError=true;alert('Error '+t.status+' -- '+t.statusText);}}
Light.ajax.sendRequest(Light.portal.contextPath+Light.listenServerRequest,opt);}
Light.responseListenServer=function(t){if(!Light.serverError){setTimeout("Light.autoListenServer()",10000);}
if(t.responseText=='<b/>')return;var params=t.responseText.split(",");if(params==null||params.length<=1)return;if(params[0]=="chat"){var ringTone="/ringtone/default.mid";if(params.length>3)
ringTone=params[3];var data={user:params[1],param:t.responseText,ringTone:ringTone,yes:$('_BUTTON_OK').title,no:$('_BUTTON_CANCEL').title};createPopupDiv('instantMessage','instantMessage.jst',280,data,null,null);}}
Light.refreshWindowTransparent=function(){Light.getCurrentTab().refreshWindowTransparent();if(Light.portal.portletWindowTransparent==false){var elements=$$('div[class="portal-tabs"]','div[class="portal-tabs2"]');for(var i=0;i<elements.length;i++){elements[i].className="portal-tabs";}
elements=$$('text','textarea','select');for(var i=0;i<elements.length;i++){elements[i].style.backgroundColor="";}
elements=null;}else{var elements=$$('div[class="portal-tabs"]','div[class="portal-tabs2"]');for(var i=0;i<elements.length;i++){elements[i].className="portal-tabs2";}
elements=$$('text','textarea','select');for(var i=0;i<elements.length;i++){elements[i].style.backgroundColor="transparent";}
elements=null;}}
Light.refreshTextColor=function(){document.fgColor=Light.portal.textColor;var elements=$$('a','text','textarea','select','span');for(var i=0;i<elements.length;i++){elements[i].style.color=Light.portal.textColor;}
elements=null;for(var i=0;i<Light.portal.allPortlets.length;i++){if(Light.portal.allPortlets[i]!=null){Light.portal.allPortlets[i].refreshTextColor();}}}
Light.setTextFont=function(){var size=parseInt(Light.portal.fontSize);var defaultSize=12;var newSize=defaultSize+size;document.body.style.fontSize=newSize+"px";if(Light.portal.textFont!=null)document.body.style.fontFamily=Light.portal.textFont;}
Light.refreshTextFontSize=function(){var size=parseInt(Light.portal.fontSize);var defaultSize=12;var newSize=defaultSize+size;document.body.style.fontSize=newSize+"px";document.body.style.fontFamily=Light.portal.textFont;var elements=$$('a','label','li','td','text','textarea','select');for(var i=0;i<elements.length;i++){elements[i].style.fontSize=newSize+"px";elements[i].style.fontFamily=Light.portal.textFont;}
elements=$$('#portalFooter a','#portalFooter label');for(var i=0;i<elements.length;i++){elements[i].style.fontSize=newSize*0.8+"px";}
elements=null;if($('portal-header-title')!=null)
$('portal-header-title').style.fontSize=newSize*1.5+"px";Light.getCurrentTab().rePositionAll();}
Light.getCurrentTabId=function(){return Light.seekCurrentTabId('tabList');}
Light.seekCurrentTabId=function(id){var tabList=document.getElementById(id);for(i=0;i<tabList.childNodes.length;i++){if(tabList.childNodes[i]&&tabList.childNodes[i].tagName=="LI"){if(tabList.childNodes[i].getAttribute('tabColor')+"current"==tabList.childNodes[i].className){var tabServerId=tabList.childNodes[i].getAttribute('tabId');if(document.getElementById('tabList'+tabServerId)!=null){return Light.seekCurrentTabId('tabList'+tabServerId);}
else{return tabServerId;}}}}}
Light.getCurrentTab=function(){var currentTabId=Light.getCurrentTabId();for(var i=0;i<Light.portal.allTabs.length;i++){if(Light.portal.allTabs[i].tabServerId==currentTabId)
return Light.portal.allTabs[i];}}
Light.getTabById=function(id){for(var i=0;i<Light.portal.allTabs.length;i++){if(Light.portal.allTabs[i].tabServerId==id)
return Light.portal.allTabs[i];}}
Light.setSessionTimer=function(){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId=="")userId=Light.getCookie(Light._USER_ID);if(userId==null||userId=="")return;if(Light.sessionTimer!=null){clearTimeout(Light.sessionTimer);Light.sessionTimer=null;}
Light.sessionStartdate=new Date();Light.sessionTimer=setTimeout((function(){Light.checkSessionTimeout(Light.sessionStartdate)}),Light._SESSION_TIMEOUT);}
Light.checkSessionTimeout=function(date){if(Light.sessionStartdate==date){Light.sessionTimeoutWarningTime=Light._SESSION_TIMEOUT_WARNING;Light.sessionTimeoutWarning();}}
Light.sessionTimeoutWarning=function(){if(Light.sessionTimeoutWarningTime>0){var data={ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,timeLeft:Light.sessionTimeoutWarningTime/1000};hidePopupDiv('sessionTimeoutWarning');createPopupDiv('sessionTimeoutWarning','sessionTimeoutWarning.jst',400,data,null,null);Light.sessionTimeoutWarningTime=Light.sessionTimeoutWarningTime-1000;Light.sessionWarningTimer=setTimeout((function(){Light.sessionTimeoutWarning()}),1000);}else{Light.sessionTimeout();}}
Light.sessionTimeout=function(){Light.logout();}
Light.refreshSessionTiimeout=function(){hidePopupDiv('sessionTimeoutWarning');clearTimeout(Light.sessionWarningTimer);Light.sessionWarningTimer=null;Light.setSessionTimer();}
Light.setPortletContent=function(responseId,inHTML){var portlet=Light.getPortletById(responseId);if(!portlet.minimized){if(portlet.allowJS){var scriptFragment='(?:<script.*?>)((\n|\r|.)*?)(?:<\/script>)';var matchAll=new RegExp(scriptFragment,'img');var scripts=inHTML.match(matchAll);if(scripts!=null){for(var i=0;i<scripts.length;i++){var script=scripts[i];var scriptBegin='(?:<script.*?>)';script=script.replace(new RegExp(scriptBegin,'img'),'');var scriptEnd='(?:<\/script>)';script=script.replace(new RegExp(scriptEnd,'img'),'');try{eval(script);}catch(e){}}}else{var scriptFragment2='(?:<script.*?>)';matchAll=new RegExp(scriptFragment2,'im');var scripts=inHTML.match(matchAll);if(scripts!=null){for(var i=0;i<scripts.length;i++){var script=scripts[i];var s=document.createElement('script');s.type='text/javascript';var indx=script.indexOf("src=");script=script.substring(indx+5);indx=script.indexOf(".js");script=script.substring(0,indx+3);s.src=script;document.getElementsByTagName('head')[0].appendChild(s);}}}
inHTML=inHTML.replace(matchAll,'');}
portlet.setContent(inHTML);portlet.parent.rePositionPortlets(portlet);Light.refreshTextColor();Light.refreshTextFontSize();}}
Light.responsePortlet=function(responseId){var portlet=Light.getPortletById(responseId);Light.getCurrentTab().rePositionPortlets(portlet);Light.portal.resize();Light.refreshTextColor();Light.refreshTextFontSize();}
function setPortletTitle(t){var returnValue=t.responseText;if(returnValue.indexOf(",")>0){var params=returnValue.split(",");var portlet=Light.getPortletById(params[0]);if(params[1].indexOf("(")>=0){if(portlet.title.indexOf("(")>0){var index=portlet.title.indexOf("(");portlet.title=portlet.title.substring(0,index);}
portlet.title=portlet.title+params[1];}else{portlet.title=params[1];}
portlet.refreshHeader();}else{var portlet=Light.getPortletById(returnValue);if(portlet!=null&&portlet.title.indexOf("(")>0){var index=portlet.title.indexOf("(");portlet.title=portlet.title.substring(0,index);portlet.refreshHeader();}}}
Light.getThemePath=function(theme){if(theme==null)theme=Light.portal.theme;return Light.portal.contextPath+Light._THEME_ROOT+theme;}
Light.refreshAtClient=function(portlet){if(portlet==null)return;if(portlet.request=="myPicturePortlet"){Light.refreshMyPicturesAtClient(portlet);}}
Light.afterRefreshAtClient=function(id){var portlet=Light.getPortletById(id);if(portlet!=null)
{Light.getCurrentTab().rePositionPortlets(portlet);}}
Light.refreshMyPicturesAtClient=function(portlet){if(portlet==null)return;var divPictures=document.getElementById("userPictures");if(divPictures==null)return;var count=divPictures.getElementsByTagName("input").length;var id=Light._PC_PREFIX+portlet.serverId;var picSpan=document.getElementById("picture_"+id);if(picSpan==null)return;if(portlet.fade=="out")
portlet.opacity=portlet.opacity-1;else
portlet.opacity=portlet.opacity+1;if(portlet.opacity>=100)
portlet.fade="out";picSpan.style.filter="alpha(opacity="+portlet.opacity+")";picSpan.style.MozOpacity=portlet.opacity/100;if(portlet.opacity<=0){portlet.fade="in";portlet.myPictureIndex++;if(portlet.myPictureIndex>=count)portlet.myPictureIndex=0;var pic=document.getElementById("userPicture_"+portlet.myPictureIndex);var params=pic.name.split(";");portlet.parameter="pictureId="+params[0];var data={swidth:params[1],sheight:params[2],lwidth:params[3],lheight:params[4],url:params[5],id:id,pictureId:params[0],caption:pic.value};picSpan.innerHTML="";if(portlet.myPictures[data.url]==null){portlet.myPictures[data.url]=new Image(data.swidth,data.sheight);portlet.myPictures[data.url].id='currentMyPicture_'+id;portlet.myPictures[data.url].src=data.url;portlet.myPictures[data.url].className='portlet';portlet.myPictures[data.url].style.border="0px";portlet.myPictures[data.url].style.cursor="url('light/images/zoomin.cur'), pointer";}
if(portlet.myPictures[data.url]!=null){portlet.myPictures[data.url].width=data.swidth;portlet.myPictures[data.url].height=data.sheight;portlet.myPictures[data.url].style.cursor="url('light/images/zoomin.cur'), pointer";picSpan.appendChild(portlet.myPictures[data.url]);picSpan.innerHTML+="<br/>"+data.caption;}else
picSpan.innerHTML=Light.getViewTemplate("refreshPicture.jst",data);setTimeout((function(){Light.afterRefreshAtClient(id)}),500);var next=portlet.myPictureIndex+1;if(next>=count)next=0;var pic2=document.getElementById("userPicture_"+next);var params2=pic2.name.split(";");var data2={swidth:params2[1],sheight:params2[2],lwidth:params2[3],lheight:params2[4],url:params2[5],id:id,pictureId:params2[0],caption:pic2.value};if(portlet.myPictures[data2.url]==null){portlet.myPictures[data2.url]=new Image(data2.swidth,data2.sheight);portlet.myPictures[data2.url].id='currentMyPicture_'+id;portlet.myPictures[data2.url].src=data2.url;portlet.myPictures[data2.url].className='portlet';portlet.myPictures[data2.url].style.border="0px";portlet.myPictures[data2.url].style.cursor="url('light/images/zoomin.cur'), pointer";}}}
if(window.DOMParser&&window.XMLSerializer&&window.Node&&Node.prototype&&Node.prototype.__defineGetter__){if(!Document.prototype.loadXML){Document.prototype.loadXML=function(s){var doc2=(new DOMParser()).parseFromString(s,"text/xml");while(this.hasChildNodes())
this.removeChild(this.lastChild);for(var i=0;i<doc2.childNodes.length;i++){this.appendChild(this.importNode(doc2.childNodes[i],true));}};}
Document.prototype.__defineGetter__("xml",function(){return(new XMLSerializer()).serializeToString(this);});}
Light.Ajax=function(){log("initialize Light.Ajax");}
Light.Ajax.prototype.sendRequestAndUpdate=function(requestName,container,options){var portlet=Light.getPortletById(container);var request=this.getXmlHttpObject();if(options.method==null)options.method="post";if(options.asynchronous==null)options.asynchronous=true;request.open(options.method,Light.portal.contextPath+portlet.requestUrl,options.asynchronous);request.onreadystatechange=function(){if(request.readyState==4){Light.ajax.onRequestComplete(request);}};if(options.method=='post')
request.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");else
request.setRequestHeader("Content-Type","text/xml");var parameter=options.parameters;if(options.postBody!=null&&options.postBody.length>0)parameter=options.postBody;request.send(options.method=='post'?parameter:null);}
Light.Ajax.prototype.sendRequest=function(requestName,options){var request=this.getXmlHttpObject();if(options.method==null)options.method="post";if(options.asynchronous==null)options.asynchronous=true;request.open(options.method,requestName,options.asynchronous);request.onreadystatechange=function(){if(request.readyState==4&&request.status==200){if(options.onSuccess!=null)
options.onSuccess(request);}};if(options.method=='post')
request.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");else
request.setRequestHeader("Content-Type","text/xml");var parameter=options.parameters;if(options.postBody!=null&&options.postBody.length>0)parameter=options.postBody;request.send(options.method=='post'?parameter:null);}
Light.Ajax.prototype.onRequestComplete=function(request){if(!request)
return;if(request.status!=200)
return;if(request.responseText!=null){var content=request.responseText;var index=content.indexOf("id='");while(index>0){var portletContent=content.substring(index+4);index=portletContent.indexOf("'")
var responseId=portletContent.substring(0,index);index=portletContent.indexOf("<div>");portletContent=portletContent.substring(index);index=portletContent.indexOf("</response>");var pContent=portletContent.substring(0,index);Light.setPortletContent(responseId,pContent);content=portletContent.substring(index);index=content.indexOf("id='");}}else if(request.responseXML!=null){var response=request.responseXML.getElementsByTagName("ajax-response");if(response==null||response.length!=1)
return;Light.ajax.processAjaxResponse(response[0].childNodes);}}
Light.Ajax.prototype.processAjaxResponse=function(xmlResponseElements){for(var i=0;i<xmlResponseElements.length;i++){var responseElement=xmlResponseElements[i];if(responseElement.nodeType!=1)
continue;var responseId=responseElement.getAttribute("id");Light.setPortletContent(responseId,Light.ajax.getContentAsString(responseElement));}}
Light.Ajax.prototype.getContentAsString=function(parentNode){return parentNode.xml!=undefined?Light.ajax.getContentAsStringIE(parentNode):Light.ajax.getContentAsStringMozilla(parentNode);}
Light.Ajax.prototype.getContentAsStringIE=function(parentNode){var contentStr="";for(var i=0;i<parentNode.childNodes.length;i++){var n=parentNode.childNodes[i];if(n.nodeType==4){contentStr+=n.nodeValue;}
else{contentStr+=n.xml;}}
return contentStr;}
Light.Ajax.prototype.getContentAsStringMozilla=function(parentNode){var xmlSerializer=new XMLSerializer();var contentStr="";for(var i=0;i<parentNode.childNodes.length;i++){var n=parentNode.childNodes[i];if(n.nodeType==4){contentStr+=n.nodeValue;}
else{contentStr+=xmlSerializer.serializeToString(n);}}
return contentStr;}
Light.Ajax.prototype.getXmlHttpObject=function(){var xmlhttp;try{xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");}catch(e){try{xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");}catch(E){xmlhttp=false;}}
if(!xmlhttp&&typeof XMLHttpRequest!='undefined'){try{xmlhttp=new XMLHttpRequest();}catch(e){xmlhttp=false;}}
return xmlhttp;}
function LightPortal(){var screenWidth=document.documentElement.scrollWidth;if(screenWidth<1000)screenWidth=1000;var barWidth=screenWidth/6;var windowHeight=document.documentElement.scrollHeight;this.layout={normalTop:60,bgLeft:0,bgWidth:screenWidth,containerLeft:barWidth/2,containerTop:0,bodyLeft:0,bodyTop:80,footerLeft:10,maxLeft:0,maxTop:40,maxWidth:screenWidth-barWidth,maxHeight:windowHeight,minHeight:40,scrollbarWidth:21,footerHeightMargin:200,barWidth:barWidth}
this.tabs=new Array();this.turnedOn=false;this.moveTimer=-1;this.dragDropPortlet=null;this.highLight=document.createElement('div');var color="#ff0000";this.highLight.style.borderWidth="1px";this.highLight.style.borderStyle="dashed";this.highLight.style.borderColor=color;if(document.all){this.highLight.style.posLeft=0;this.highLight.style.posTop=0;}else{this.highLight.style.left=0;this.highLight.style.top=0;}
this.highLight.style.width=0;this.highLight.style.height=0;this.highLight.style.position="absolute";this.userId=null;this.allTabs=new Array();this.allPortlets=new Array();this.currentTab=null;this.needReload=false;this.latestAction={event:null,id:null,method:null,portlet:null}}
LightPortal.prototype.turnOn=function(){var vLoading=document.createElement('div');vLoading.className="loading";vLoading.id="loadingDiv";vLoading.innerHTML=Light.getViewTemplate("loading.view");document.body.appendChild(vLoading);document.body.ondragstart=function(){return false};document.body.onmousemove=function(e){if(Light.portal.moveTimer==-1)return;if(document.all)e=event;if(Light.portal.dragDropPortlet!=null){Light.portal.dragDropPortlet.move(e);}
return false;};document.body.onmouseup=function(e){Light.portal.moveTimer=-1;if(document.all)e=event;if(Light.portal.dragDropPortlet!=null){Light.portal.dragDropPortlet.moveEnd(e);Light.portal.dragDropPortlet=null;document.body.onselectstart=null;document.body.ondragstart=null;}
return false;};if(this.originalLeft!=null){this.layout.containerLeft=this.originalLeft;this.originalLeft=null;}
this.turnOnPortal();}
LightPortal.prototype.turnOnPortal=function(){if(this.needReload){this.loadPortal();this.needLoad=false;}else{if($('loginUserId').title!=0){Light.setCookie(Light._LOGINED_USER_ID,$('loginUserId').title);}else{Light.deleteCookie(Light._LOGINED_USER_ID);Light.deleteCookie(Light._CURRENT_TAB);}
Light.portal.renderPortal($('portalString').title);Light.portal.renderPortalTab($('pageRoot').title);}}
LightPortal.prototype.loadPortal=function(){var userId=Light.getCookie(Light._REMEMBERED_USER_ID);var password=Light.getCookie(Light._REMEMBERED_USER_PASSWORD);log("turnOnPortal:"+userId);var params="check=1";if(userId!=null&&userId!=""&&password!=null&&password!=""&&(Light.getCookie(Light._IS_SIGN_OUT)==null||Light.getCookie(Light._IS_SIGN_OUT)=="")){params="userId="+escape(encodeURIComponent(userId))
+"&password="+escape(encodeURIComponent(password));}
var opt={method:'post',parameters:params,onSuccess:function(t){Light.portal.loadPortalHandler(t);},on404:function(t){alert('Error 404: location "'+t.statusText+'" was not found.');},onFailure:function(t){alert('Error '+t.status+' -- '+t.statusText);}}
Light.ajax.sendRequest(Light.checkLoginRequest,opt);}
LightPortal.prototype.loadPortalHandler=function(t){var content=t.responseText;var params=content.split("|");if(params[0]!="0"){Light.userId=params[0];Light.setCookie(Light._LOGINED_USER_ID,Light.userId);}else{Light.deleteCookie(Light._LOGINED_USER_ID);}
Light.portal.renderPortal(params[1]);Light.portal.renderPortalTab(params[2]);}
LightPortal.prototype.renderPortal=function(myPortal){log("renderPortal:"+myPortal);var params=myPortal.split(",");Light.portal.contextPath=params[0];if(Light.portal.contextPath.length==0)
Light.portal.contextPath=Light._DEFAULT_CONTEXT_PATH;Light.portal.title=params[1];Light.portal.allowLookAndFeel=true;Light.portal.allowLayout=false;Light.portal.allowAddTab=true;Light.portal.allowAddContent=true;Light.portal.allowSignIn=true;Light.portal.allowTurnOff=true;Light.portal.allowChangeLocale=true;Light.portal.portletWindowTransparent=true;if(params[2]==0)Light.portal.allowLookAndFeel=false;if(params[4]==0)Light.portal.allowAddTab=false;if(params[5]==0)Light.portal.allowAddContent=false;if(params[6]==0)Light.portal.allowSignIn=false;if(params[7]==0)Light.portal.allowTurnOff=false;if(params[8]==0)Light.portal.allowChangeLocale=false;if(params[9]==0)Light.portal.portletWindowTransparent=false;Light.locale=params[10];Light.portal.bgImage=params[11];Light.portal.newBgImage="";Light.portal.bgPosition=params[12];Light.portal.bgRepeat=params[13];Light.portal.headerImage=params[14];Light.portal.newHeaderImage="";Light.portal.headerPosition=params[15];Light.portal.headerRepeat=params[16];Light.portal.headerHeight=params[17];Light.portal.fontSize=params[18];Light.portal.showSearchBar=true;if(params[19]==0)Light.portal.showSearchBar=false;Light.portal.defaultSearchEngine=params[20];Light.portal.textColor=params[21];Light.portal.textFont=params[22];Light.portal.theme=params[23];if(Light.portal.theme!=null){var themeCss=Light.getThemePath()+'/theme.css';if(document.all)
themeCss=Light.getThemePath()+'/MSIE/theme.css';if(document.getElementsByTagName('link')[1]!=null&&document.getElementsByTagName('link')[1].href!=themeCss)
document.getElementsByTagName('link')[1].href=themeCss;}
Light.portal.logo=params[24];if(Light.portal.logo==null||Light.portal.logo.length<=0)Light.portal.logo='/light/images/logo.png';this.maxShowTabs=parseInt(params[25]);Light.setTextFont();this.container=this.createPortalContainer();this.header=Light.service.getPortalHeader(this);this.menu=Light.service.getPortalMenu(this);this.body=this.createPortalBody();this.footer=Light.service.getPortalFooter(this);this.container.appendChild(this.header);this.container.appendChild(this.menu);this.container.appendChild(this.body);this.container.appendChild(this.footer);document.body.appendChild(this.container);Light.setCookie(Light._ON,"on");this.turnedOn=true;this.startTab=0;}
LightPortal.prototype.getPortalTabsByUser=function(){var myPortalTab=Light.getCookie(Light._GUEST_PORTAL_TAB);log("getPortalTabsByUser:"+myPortalTab);if(Light.getCookie(Light._LOGINED_USER_ID)!=null)
myPortalTab=Light.getCookie(Light._MY_PORTAL_TAB);if(myPortalTab==null){var opt={method:'get',onSuccess:function(t){Light.portal.getPortalTabsByUserHandler(t);},on404:function(t){alert('Error 404: location "'+t.statusText+'" was not found.');},onFailure:function(t){alert('Error '+t.status+' -- '+t.statusText);}}
Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortalTabsByUserRequest,opt);}else{this.renderPortalTab(myPortalTab);}}
LightPortal.prototype.getPortalTabsByUserHandler=function(t){Light.portal.renderPortalTab(t.responseText);var date=new Date();var timestamp=Date.parse(date);date.setFullYear(date.getFullYear()+1);userId=timestamp;if(Light.getCookie(Light._LOGINED_USER_ID)!=null)
Light.setCookie(Light._MY_PORTAL_TAB,t.responseText,date);else
Light.setCookie(Light._GUEST_PORTAL_TAB,t.responseText,date);}
LightPortal.prototype.renderPortalTab=function(myPortalTabs){log("renderPortalTab:"+myPortalTabs);var portalTabs=myPortalTabs.split(";");var defaultTab=0;var defaultTabs=null;if(Light.getCookie(Light._CURRENT_TAB)!=null&&Light.getCookie(Light._CURRENT_TAB)!=""){defaultTab=Light.getCookie(Light._CURRENT_TAB);defaultTabs=defaultTab.split("-");if(defaultTabs.length>0&&defaultTabs[0]<portalTabs.length){defaultTab=parseInt(defaultTabs[0]);}}
if(defaultTab>=portalTabs.length)defaultTab=0;if(defaultTab>=this.maxShowTabs)this.startTab=defaultTab+1-this.maxShowTabs;if(portalTabs.length>this.maxShowTabs)this.addLeftButton();for(var i=0;i<portalTabs.length;i++){var vPortalTab=eval(portalTabs[i]);vPortalTab.parent=this;vPortalTab.tabList="tabList";vPortalTab.tabPanels="tabPanels";if(i>=this.startTab&&i<this.maxShowTabs+this.startTab)
vPortalTab.open(vPortalTab);this.tabs[i]=vPortalTab;if(vPortalTab.defaulted)
defaultTab=i;}
if(portalTabs.length>this.maxShowTabs)this.addRightButton();this.addTabMenu();if(defaultTabs!=null&&defaultTabs.length>1){var defaultSubTabs="";for(var i=1;i<defaultTabs.length;i++){if(i==1)
defaultSubTabs=defaultTabs[i];else
defaultSubTabs+="-"+defaultTabs[i];}
this.tabs[defaultTab].defaultTab=defaultSubTabs;}
if(!this.tabs[defaultTab].opened)this.tabs[defaultTab].open(this.tabs[defaultTab]);this.tabs[defaultTab].focus();this.tabs[defaultTab].refresh();if(portalTabs.length<=1&&!Light.portal.allowAddTab)
this.tabs[0].hide();Light.autoListenServer();var loadDiv=document.getElementById("loadingDiv");document.body.removeChild(loadDiv);Light.refreshTextColor();log("renderPortalTab: done");}
LightPortal.prototype.addLeftButton=function(){var newLabel=document.createElement('span');newLabel.setAttribute("id","tabSpan"+"");newLabel.className="";newLabel.style.marginTop="5px";var clsA=document.createElement('img');clsA.src=Light.getThemePath()+'/images/previous.gif';clsA.title=$('_BUTTON_PREVIOUS').title;clsA.className="portal-tab-button";clsA.style.height=16;clsA.style.width=16;clsA.align="middle";newLabel.appendChild(clsA);newLabel.onclick=function(){focusLeftTab();}
document.getElementById('tabs').insertBefore(newLabel,document.getElementById('tabList'));}
LightPortal.prototype.addRightButton=function(){var newLabel=document.createElement('span');newLabel.setAttribute("id","tabSpan"+"");newLabel.className="";newLabel.setAttribute("tabColor","");var clsA=document.createElement('img');clsA.src=Light.getThemePath()+'/images/next.gif';clsA.title=$('_BUTTON_NEXT').title;clsA.className="portal-tab-button";clsA.style.height=16;clsA.style.width=16;clsA.align="middle";newLabel.appendChild(clsA);newLabel.onclick=function(){focusRightTab();}
document.getElementById('tabs').appendChild(newLabel);}
LightPortal.prototype.addTabMenu=function(){if(Light.portal.allowAddTab){var newLabel=document.createElement('span');newLabel.setAttribute("id","tabSpan"+"");newLabel.className="";newLabel.setAttribute("tabColor","");var clsA=document.createElement('img');clsA.src=Light.getThemePath()+'/images/add.gif';clsA.title=$('_MENU_ADD_TAB').title;clsA.className="portal-tab-button";clsA.style.height=16;clsA.style.width=16;clsA.align="middle";newLabel.appendChild(clsA);var newTab=document.createElement('li');newTab.className=this.tabColor;newTab.id="tabMenuAddTab";newTab.setAttribute("id","tabMenuAddTab");newTab.setAttribute("tabId","");newTab.setAttribute("tabLabel",$('_MENU_ADD_TAB').title);newTab.setAttribute("tabColor","");newTab.onclick=function(){addAutoTab(0);}
newTab.setAttribute("tabIsCloseable","0");newTab.setAttribute('isFocused','true');newTab.appendChild(newLabel);document.getElementById('tabList').appendChild(newTab);}}
LightPortal.prototype.turnOff=function(){this.container.removeChild(this.header);this.container.removeChild(this.menu);this.container.removeChild(this.body);this.container.removeChild(this.footer);document.body.removeChild(this.container);Light.deleteCookie(Light._ON);for(var i=0;i<this.tabs.length;i++){for(var j=0;j<this.tabs[i].portlets.length;j++){this.tabs[i].portlets[j]=new Array();}}
this.tabs=new Array();this.allTabs=new Array();this.allPortlets=new Array();this.turnedOn=false;document.body.onselectstart=null;document.body.ondragstart=null;document.body.onmousemove=null;document.body.onmouseup=null;}
LightPortal.prototype.createPortalContainer=function(){var vPortalContainer=document.createElement('div');vPortalContainer.style.position="absolute";vPortalContainer.className="portal-container";if(this.bgImage.length>0){if(this.bgImage!="no"){vPortalContainer.style.backgroundColor="";var backgroundImage=this.bgImage;if(this.bgImage.indexOf("http")<0)
backgroundImage=Light.portal.contextPath+this.bgImage;if(this.bgRepeat==1)
document.body.style.background="url('"+backgroundImage+"') no-repeat "+Light.portal.bgPosition;else if(this.bgRepeat==2)
document.body.style.background="url('"+backgroundImage+"') repeat-x right top";else if(this.bgRepeat==3)
document.body.style.background="url('"+backgroundImage+"') repeat-y left top";else
document.body.style.background="url('"+backgroundImage+"')";}else{vPortalContainer.style.backgroundColor="";document.body.style.background="#ffffff";}}
vPortalContainer.style.fontSize=12+parseInt(this.fontSize);vPortalContainer.style.width=Light.portal.layout.bgWidth;vPortalContainer.style.height=Light.portal.layout.maxHeight;vPortalContainer.style.zIndex=++Light.maxZIndex;if(document.all){vPortalContainer.style.posLeft=Light.portal.layout.bgLeft;vPortalContainer.style.posTop=Light.portal.layout.containerTop;}
else{vPortalContainer.style.left=Light.portal.layout.bgLeft;vPortalContainer.style.top=Light.portal.layout.containerTop;}
return vPortalContainer;}
LightPortal.prototype.refreshPortalHeader=function(){this.container.removeChild(Light.portal.header);this.header=Light.service.getPortalHeader(this);this.container.insertBefore(this.header,Light.portal.menu);Light.refreshTextColor();}
LightPortal.prototype.editTitle=function(title){title.className='portal-header-title-edit';title.innerHTML="<input type='text' id='portalTitle' class='portal-header-title-edit' value=\""+this.title+"\" onchange=\"javascript:Light.portal.saveTitle();\" onblur=\"javascript:Light.portal.saveTitle();\"/>";$('portalTitle').focus();}
LightPortal.prototype.viewTitle=function(title){title.className='portal-header-title-view';title.style.backgroundColor='';title.innerHTML=this.title;}
LightPortal.prototype.saveTitle=function(title){var title=$('portalTitle').value;this.title=title;this.refreshPortalHeader();var params="title="+encodeURIComponent(title);Light.ajax.sendRequest(Light.portal.contextPath+Light.changeTitle,{parameters:params});}
LightPortal.prototype.saveTabTitle=function(index){if($('portalTabTitle')==null)return;var title=$('portalTabTitle').value;var currentTab=this.tabs[index];currentTab.editTitle=false;var vButton=document.createElement('div');vButton.className="portal-tab-handle";vButton.innerHTML=title;vButton.onclick=function(){currentTab.focus();currentTab.refresh();}
document.getElementById("tabSpan"+currentTab.tabServerId).innerHTML="";document.getElementById("tabSpan"+currentTab.tabServerId).appendChild(vButton);$(currentTab.tabId).setAttribute("tabLabel",title);if(currentTab.tabIsEditable){var addA=document.createElement('img');addA.src=Light.getThemePath()+'/images/add.gif';addA.className="portal-tab-button";addA.style.height=16;addA.style.width=16;addA.align="middle";addA.onclick=function(){currentTab.addSubPage();}
document.getElementById("tabSpan"+currentTab.tabServerId).appendChild(addA);}
if(currentTab.tabIsCloseable){var clsA=document.createElement('img');clsA.src=Light.portal.contextPath+'/light/images/closeTab.gif';clsA.className="portal-tab-button";clsA.onclick=function(){currentTab.close();}
document.getElementById("tabSpan"+currentTab.tabServerId).appendChild(clsA);}
var params="title="+encodeURIComponent(title)
+"&tabId="+currentTab.tabServerId;Light.ajax.sendRequest(Light.portal.contextPath+Light.editTabTitleRequest,{parameters:params});}
LightPortal.prototype.refreshPortalMenu=function(tab){this.container.removeChild(this.menu);this.menu=Light.service.getPortalMenu(this);this.container.insertBefore(this.menu,this.body);}
LightPortal.prototype.createPortalBody=function(){var vBody=document.createElement('div');vBody.id="portalBody";vBody.className="portal-body";vBody.style.position="absolute";if(Light.portal.portletWindowTransparent==false)
vBody.innerHTML="<div id='tabs' class='portal-tabs' ><ul id='tabList'></ul></div><div id='tabPanels' class='portal-tab-panels' ></div>";else
vBody.innerHTML="<div id='tabs' class='portal-tabs2' ><ul id='tabList'></ul></div><div id='tabPanels' class='portal-tab-panels' ></div>";vBody.style.zIndex=++Light.maxZIndex;vBody.style.width=Light.portal.layout.maxWidth;vBody.style.marginLeft=this.layout.containerLeft+this.layout.bodyLeft;return vBody;}
LightPortal.prototype.resize=function(){var screenWidth=document.documentElement.scrollWidth;if(document.all)
screenWidth=screenWidth-Light.portal.layout.scrollbarWidth;var barWidth=screenWidth/6;var windowWidth=screenWidth-barWidth;if(windowWidth<1000)windowWidth=1000;Light.portal.layout.maxWidth=windowWidth;Light.portal.layout.maxHeight=document.documentElement.scrollHeight;Light.portal.layout.bgWidth=screenWidth;Light.portal.layout.barWidth=barWidth;Light.portal.layout.containerLeft=barWidth/2;Light.portal.container.style.width=Light.portal.layout.bgWidth;Light.portal.container.style.height=Light.portal.layout.maxHeight;var currentTab=Light.getCurrentTab();this.refreshPortalMenu(currentTab);currentTab.resize();}
LightPortal.prototype.collapseAll=function(){Light.getCurrentTab().collapseAll();}
LightPortal.prototype.expandAll=function(){Light.getCurrentTab().expandAll();}
function responseResignGroup(t){var responseId=t.responseText;var portlet=Light.getPortletById(responseId);if(portlet!=null)
portlet.refresh();}
function responseDeleteGroupProfile(t){var params=t.responseText.split(";");if(params[0]!=0){var portlet=Light.getPortletById(params[1]);if(portlet!=null)
portlet.refresh();}else
alert("You cannot delete this group, because this group has members.");var responseId=t.responseText;}
function LightPortalFooter(){}
LightPortalFooter.prototype.render=function(portal){}
LightPortalFooterImpl.prototype=new LightPortalFooter;LightPortalFooterImpl.prototype.constructor=LightPortalFooter;function LightPortalFooterImpl(){LightPortalFooter.call(this);}
LightPortalFooterImpl.prototype.render=function(portal){var vfooter=document.createElement('div');vfooter.id="portalFooter";vfooter.className="portal-footer";if(document.all){vfooter.style.posLeft=portal.layout.footerLeft;vfooter.style.posTop=portal.layout.bodyTop+portal.layout.footerHeightMargin;}
else{vfooter.style.left=portal.layout.footerLeft;vfooter.style.top=portal.layout.bodyTop+portal.layout.footerHeightMargin;}
vfooter.style.width=portal.layout.maxWidth;vfooter.innerHTML=Light.getViewTemplate("footer.view");vfooter.style.zIndex=1;return vfooter;}
Light.showAbout=function(){Light.showPopupPortlet(150,600,$('_MENU_ABOUT').title,"/light/images/about.gif","aboutPortlet","/aboutPortlet.lp",Light._MAXIMIZED_STATE);}
Light.showFAQ=function(){Light.showPopupPortlet(150,600,$('_MENU_FAQ').title,"/light/images/faq.gif","faqPortlet","/faqPortlet.lp",Light._MAXIMIZED_STATE);}
Light.showTerms=function(){Light.showPopupPortlet(150,600,$('_MENU_TERMS').title,"/light/images/terms.gif","termsPortlet","/termsPortlet.lp",Light._MAXIMIZED_STATE);}
Light.showPrivacy=function(){Light.showPopupPortlet(150,600,$('_MENU_PRIVACY').title,"/light/images/private.gif","privacyPortlet","/privacyPortlet.lp",Light._MAXIMIZED_STATE);}
Light.showContactUs=function(){Light.showPopupPortlet(150,600,$('_MENU_CONTACT_US').title,"/light/images/contact.gif","contactPortlet","/contactPortlet.lp",Light._MAXIMIZED_STATE);}
function LightPortalHeader(){}
LightPortalHeader.prototype.render=function(){}
LightPortalHeaderImpl.prototype=new LightPortalHeader;LightPortalHeaderImpl.prototype.constructor=LightPortalHeader;function LightPortalHeaderImpl(){LightPortalHeader.call(this);}
LightPortalHeaderImpl.prototype.render=function(portal){var vPortalHeader=document.createElement('div');vPortalHeader.className="portal-header";if(portal.headerImage.length>0){if(portal.headerImage!="no"){var headerImage=portal.headerImage;if(headerImage.indexOf("http")<0)
headerImage=Light.portal.contextPath+headerImage;if(portal.headerRepeat==1)
vPortalHeader.style.background="url('"+headerImage+"') no-repeat "+portal.headerPosition;else if(portal.headerRepeat==2)
vPortalHeader.style.background="url('"+headerImage+"') repeat-x right top";else if(portal.headerRepeat==3)
vPortalHeader.style.background="url('"+headerImage+"') repeat-y left top";else{vPortalHeader.style.background="url('"+headerImage+"')";vPortalHeader.style.backgroundRepeat="repeat-x";}}else{vPortalHeader.style.backgroundColor="";}}else{vPortalHeader.style.backgroundColor="";}
var height=parseInt(portal.headerHeight);if(height>0)vPortalHeader.style.height=80+parseInt(height);var vTitle=document.createElement('span');vTitle.id="portal-header-title";vTitle.className="portal-header-title";vTitle.innerHTML="<span class='portal-header-title-view'>"+portal.title+"</span>";vPortalHeader.appendChild(vTitle);var vLogo=document.createElement('span');vLogo.className="portal-header-logo";var logo=Light.portal.logo;if(!logo.startsWith("http"))logo=portal.contextPath+logo;var strLogo="<a href='javascript:void(0)' onclick='javascript:window.location.reload(true);'><img src='"+logo+"' style='border: 0px;'/></a>";vLogo.innerHTML=strLogo;if(document.all){vLogo.style.posLeft=Light.portal.layout.containerLeft;}
else{vLogo.style.left=Light.portal.layout.containerLeft;}
vPortalHeader.appendChild(vLogo);vPortalHeader.style.zIndex=++Light.maxZIndex;return vPortalHeader;}
function LightPortalMenu(){}
LightPortalMenu.prototype.render=function(){}
LightPortalMenuImpl.prototype=new LightPortalMenu;LightPortalMenuImpl.prototype.constructor=LightPortalMenu;function LightPortalMenuImpl(){LightPortalMenu.call(this);}
LightPortalMenuImpl.prototype.render=function(portal){tab=Light.currentTab;var vBody=document.createElement('div');vBody.id="portalHeaderMenu";vBody.className="portal-header-menu";if(portal.showSearchBar){var vSearch=document.createElement('span');vSearch.className="portal-header-search";vSearch.innerHTML=Light.getViewTemplate("searchBar.view",null);vBody.appendChild(vSearch);}
var vSpan=document.createElement('span');vSpan.className="portal-header-menu-item";if(portal.allowLookAndFeel){var varA=document.createElement('a');varA.innerHTML=$('_MENU_LOOK_AND_FEEL').title;varA.href="javascript:void(0)";varA.onclick=function(){Light.changeOptions();}
vSpan.appendChild(varA);var vLine1=document.createElement('span');vLine1.className="portal-header-menu-item-separater";vSpan.appendChild(vLine1);}
if(portal.allowLayout&&(tab==null||tab.tabIsEditable)){var varB=document.createElement('a');varB.innerHTML=$('_MENU_LAYOUT').title;varB.href="javascript:void(0)";varB.onclick=function(){Light.editTab();}
vSpan.appendChild(varB);var vLine2=document.createElement('span');vLine2.className="portal-header-menu-item-separater";vSpan.appendChild(vLine2);}
if(portal.allowAddContent&&(tab==null||tab.allowAddContent)){var varD=document.createElement('a');varD.innerHTML=$('_MENU_ADD_CONTENT').title;varD.href="javascript:void(0)";varD.onclick=function(){Light.addContent();}
vSpan.appendChild(varD);var vLine4=document.createElement('span');vLine4.className="portal-header-menu-item-separater";vSpan.appendChild(vLine4);}
if(portal.allowSignIn){var varE=document.createElement('a');var u=Light.getCookie(Light._LOGINED_USER_ID);if(Light.getCookie(Light._LOGINED_USER_ID)!=null&&Light.getCookie(Light._LOGINED_USER_ID)!=""){varE.innerHTML=$('_MENU_SIGN_OUT').title;varE.href="javascript:void(0)";varE.onclick=function(){Light.logout();}}else{varE.innerHTML=$('_MENU_SIGN_IN').title;varE.href="javascript:void(0)";varE.onclick=function(){Light.login();}}
vSpan.appendChild(varE);var vLine5=document.createElement('span');vLine5.className="portal-header-menu-item-separater";vSpan.appendChild(vLine5);}
if(Light.portal.allowSignIn&&Light.getCookie(Light._LOGINED_USER_ID)!=null&&Light.getCookie(Light._LOGINED_USER_ID)!=""){var varE=document.createElement('a');varE.innerHTML=$('_MENU_MY_ACCOUNT').title;varE.href="javascript:void(0)";varE.onclick=function(){Light.toMyAccount();}
vSpan.appendChild(varE);var vLine5=document.createElement('span');vLine5.className="portal-header-menu-item-separater";vSpan.appendChild(vLine5);}else{var varE=document.createElement('a');varE.innerHTML=$('_MENU_HOME').title;varE.href="javascript:void(0)";varE.onclick=function(){Light.toMyAccount();}
vSpan.appendChild(varE);var vLine5=document.createElement('span');vLine5.className="portal-header-menu-item-separater";vSpan.appendChild(vLine5);}
var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId=="")
userId=Light.getCookie(Light._USER_ID);if(userId!=null&&userId!=""){var varUp=document.createElement('a');varUp.innerHTML="<img src='"+portal.contextPath+"/light/images/collapseAll.gif' style='border: 0px' height='12' width='12' align='top' title='"+$('_MENU_COLLAPSE_ALL').title+"'/>";varUp.href="javascript:void(0)";varUp.onclick=function(){Light.portal.collapseAll();}
vSpan.appendChild(varUp);var varDown=document.createElement('a');varDown.innerHTML="<img src='"+portal.contextPath+"/light/images/expandAll.gif' style='border: 0px' height='12' width='12' align='top' title='"+$('_MENU_EXPAND_ALL').title+"'/>";varDown.href="javascript:void(0)";varDown.onclick=function(){Light.portal.expandAll();}
vSpan.appendChild(varDown);var vLine=document.createElement('span');vLine.className="portal-header-menu-item-separater";vSpan.appendChild(vLine);}
if(portal.allowTurnOff){var varF=document.createElement('a');varF.innerHTML=$('_MENU_TURN_OFF').title;varF.href="javascript:void(0)";varF.onclick=function(){Light.switchPortal();}
vSpan.appendChild(varF);}
if(portal.allowChangeLocale){var varG=document.createElement('a');varG.innerHTML="<img src='"+portal.contextPath+"/light/images/world.gif' style='border: 0px' height='16' width='16' align='top' title='"+$('_TITLE_LANGUAGE').title+"'/>";varG.href="javascript:void(0)";varG.onclick=function(){Light.showChangeLanguage();}
vSpan.appendChild(varG);}
vBody.appendChild(vSpan);vBody.style.zIndex=++Light.maxZIndex;vBody.style.width=Light.portal.layout.maxWidth;vBody.style.marginLeft=Light.portal.layout.containerLeft;return vBody;}
Light.getScriptsHandler=function(t){var scripts=t.responseText;if(scripts!=null){var params=scripts.split(",");for(var i=0;i<params.length;i++){var script=document.createElement("script");script.setAttribute("language","JavaScript");script.setAttribute("src","../"+params[i]);document.getElementsByTagName("head")[0].appendChild(script);script=null;}}}
LightPortal.prototype.turnOnPortal=function(){this.latestAction={event:null,id:null,method:null,portlet:null}
if($('loginUserId').title!=0){Light.setCookie(Light._LOGINED_USER_ID,$('loginUserId').title);}
Light.deleteCookie(Light._CURRENT_TAB);Light.portal.renderPortal($('portalString').title);Light.portal.renderPortalTab($('pageRoot').title);}
LightPortal.prototype.turnOnPortal2=function(){var opt={method:'post',onSuccess:function(t){Light.portal.turnOnPortalHandler(t);},on404:function(t){alert('Error 404: location "'+t.statusText+'" was not found.');},onFailure:function(t){alert('Error '+t.status+' -- '+t.statusText);}}
Light.ajax.sendRequest(Light.pagePortalRequest,opt);}
LightPortal.prototype.turnOnPortalHandler=function(t){var params=t.responseText.split(",");Light.portal.contextPath=params[0];if(Light.portal.contextPath.length==0)
Light.portal.contextPath=Light._DEFAULT_CONTEXT_PATH;Light.portal.title=params[1];Light.portal.allowLookAndFeel=true;Light.portal.allowLayout=true;Light.portal.allowAddTab=true;Light.portal.allowAddContent=true;Light.portal.allowSignIn=true;Light.portal.allowTurnOff=true;Light.portal.allowChangeLocale=true;Light.portal.portletWindowTransparent=true;if(params[2]==0)Light.portal.allowLookAndFeel=false;if(params[3]==0)Light.portal.allowLayout=false;if(params[4]==0)Light.portal.allowAddTab=false;if(params[5]==0)Light.portal.allowAddContent=false;if(params[6]==0)Light.portal.allowSignIn=false;if(params[7]==0)Light.portal.allowTurnOff=false;if(params[8]==0)Light.portal.allowChangeLocale=false;if(params[9]==0)Light.portal.portletWindowTransparent=false;Light.locale=params[10];Light.portal.bgImage=params[11];Light.portal.newBgImage="";Light.portal.bgPosition=params[12];Light.portal.bgRepeat=params[13];Light.portal.headerImage=params[14];Light.portal.newHeaderImage="";Light.portal.headerPosition=params[15];Light.portal.headerRepeat=params[16];Light.portal.headerHeight=params[17];Light.portal.fontSize=params[18];if(params[19]==0)Light.portal.showSearchBar=false;Light.portal.defaultSearchEngine=params[20];Light.portal.textColor=params[21];Light.portal.textFont=params[22];Light.portal.theme=params[23];Light.portal.logo=params[24];if(Light.portal.logo==null||Light.portal.logo.length<=0)Light.portal.logo='/light/images/logo.png';Light.setTextFont();this.container=this.createPortalContainer();this.header=Light.service.getPortalHeader(this);this.menu=Light.service.getPortalMenu(this);this.body=this.createPortalBody();this.footer=Light.service.getPortalFooter(this);this.container.appendChild(this.header);this.container.appendChild(this.menu);this.container.appendChild(this.body);this.container.appendChild(this.footer);document.body.appendChild(this.container);Light.setCookie(Light._ON,"on");this.turnedOn=true;this.getPortalTabs();Light.refreshTextColor();}
LightPortal.prototype.getPortalTabs=function(){var opt={method:'get',onSuccess:function(t){Light.portal.getPortalTabsHandler(t);},on404:function(t){alert('Error 404: location "'+t.statusText+'" was not found.');},onFailure:function(t){alert('Error '+t.status+' -- '+t.statusText);}}
Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortalTabsByPageRequest,opt);}
LightPortal.prototype.getPortalTabsHandler=function(t){var defaultTab=0;var responseText=t.responseText;var portalTabs=responseText.split(";");for(var i=0;i<portalTabs.length;i++){var vPortalTab=eval(portalTabs[i]);vPortalTab.parent=this;vPortalTab.tabList="tabList";vPortalTab.tabPanels="tabPanels";vPortalTab.open(vPortalTab);this.tabs[i]=vPortalTab;if(vPortalTab.defaulted)
defaultTab=i;}
this.tabs[defaultTab].focus();this.tabs[defaultTab].refresh();if(portalTabs.length<=1&&!Light.portal.allowAddTab)
this.tabs[0].hide();Light.autoListenServer();var loadDiv=document.getElementById("loadingDiv");document.body.removeChild(loadDiv);}
LightPortalTab=function(index,tabId,tabServerId,tabLabel,tabURL,tabIsCloseable,tabIsEditable,tabIsMoveable,allowAddContent,tabColor,defaulted,between,widths,fitScreen,windowAppearanceType,parentId){Light.portal.allTabs[Light.portal.allTabs.size()]=this;this.index=index;this.tabId=tabId;this.tabServerId=tabServerId;this.tabLabel=tabLabel;this.tabURL=tabURL;this.tabIsCloseable=tabIsCloseable;this.tabIsEditable=tabIsEditable;this.tabIsMoveable=tabIsMoveable
this.allowAddContent=allowAddContent;this.tabColor=tabColor;this.defaulted=defaulted;this.between=between;this.widths=widths;this.fitScreen=fitScreen;var type=windowAppearanceType.substring(windowAppearanceType.length-1);if(!type.charAt(0).isDigit()){type="1";}
this.portletWindowAppearance="WindowAppearance"+type;this.parentId=parentId;this.portlets=new Array();this.loaded=false;this.editTitle=false;this.tabs=new Array();var totalWidth=0;for(var i=0;i<widths.length;i++){totalWidth+=widths[i]+between;}
if(fitScreen==1){totalWidth+=between;if(Light.portal.layout.maxWidth>totalWidth){var diff=Light.portal.layout.maxWidth-totalWidth;var eachD=parseInt(diff/widths.length);for(var i=0;i<widths.length;i++){widths[i]+=eachD;}}
if(Light.portal.layout.maxWidth<totalWidth){var diff=totalWidth-Light.portal.layout.maxWidth;var eachD=diff/widths.length;for(var i=0;i<widths.length;i++){widths[i]-=eachD;}}}
this.opened=false;log("new portal tab");}
LightPortalTab.prototype.open=function(portalTab,next){var newLabel=document.createElement('span');newLabel.setAttribute("id","tabSpan"+this.tabServerId);newLabel.className=this.tabColor;newLabel.setAttribute("tabColor",this.tabColor);var vButton=document.createElement('div');vButton.className="portal-tab-handle";vButton.innerHTML=this.tabLabel;vButton.onclick=function(){portalTab.focus();portalTab.refresh();}
newLabel.appendChild(vButton);var newTab=document.createElement('li');newTab.className=this.tabColor;newTab.setAttribute("id",this.tabId);newTab.setAttribute("tabId",this.tabServerId);newTab.setAttribute("tabLabel",this.tabLabel);newTab.setAttribute("tabColor",this.tabColor);newTab.setAttribute("tabIsCloseable","0");if(this.tabIsCloseable){newTab.setAttribute("tabIsCloseable","1");}
newTab.setAttribute('isFocused','true');newTab.appendChild(newLabel);this.tabContainer=newTab;var lastOne=document.getElementById('tabMenuAddTab');if(portalTab.parentId>0)
lastOne=document.getElementById('tabMenuAddTab'+portalTab.parent.tabServerId);if(next!=null){document.getElementById(portalTab.tabList).insertBefore(newTab,next.tabContainer);}else{if(lastOne!=null)
document.getElementById(portalTab.tabList).insertBefore(newTab,lastOne);else
document.getElementById(portalTab.tabList).appendChild(newTab);}
var newPanel=document.createElement('div');newPanel.setAttribute('id','panel_'+this.tabServerId);newPanel.setAttribute("panelURL",this.tabURL);newPanel.setAttribute("tabColor",this.tabColor);newPanel.className=this.tabColor+"Panel";if(next!=null){document.getElementById(portalTab.tabPanels).insertBefore(newPanel,next.panelContainer);}else{document.getElementById(portalTab.tabPanels).appendChild(newPanel);}
this.panelContainer=newPanel;this.opened=true;}
LightPortalTab.prototype.insert=function(portalTab){var newLabel=document.createElement('span');newLabel.setAttribute("id","tabSpan"+this.tabServerId);newLabel.className=this.tabColor;newLabel.setAttribute("tabColor",this.tabColor);var vButton=document.createElement('div');vButton.className="portal-tab-handle";vButton.innerHTML=this.tabLabel;vButton.onclick=function(){portalTab.focus();portalTab.refresh();}
newLabel.appendChild(vButton);var newTab=document.createElement('li');newTab.className=this.tabColor;newTab.setAttribute("id",this.tabId);newTab.setAttribute("tabId",this.tabServerId);newTab.setAttribute("tabLabel",this.tabLabel);newTab.setAttribute("tabColor",this.tabColor);newTab.setAttribute("tabIsCloseable","0");if(this.tabIsCloseable){newTab.setAttribute("tabIsCloseable","1");}
newTab.setAttribute('isFocused','true');newTab.appendChild(newLabel);var lastOne=document.getElementById('tabMenuAddTab');if(portalTab.parentId>0)
lastOne=document.getElementById('tabMenuAddTab'+portalTab.parent.tabServerId);this.tabContainer=newTab;document.getElementById(portalTab.tabList).insertBefore(newTab,lastOne);var newPanel=document.createElement('div');newPanel.setAttribute('id','panel_'+this.tabServerId);newPanel.setAttribute("panelURL",this.tabURL);newPanel.setAttribute("tabColor",this.tabColor);newPanel.className=this.tabColor+"Panel";document.getElementById(portalTab.tabPanels).appendChild(newPanel);this.panelContainer=newPanel;portalTab.focus();portalTab.refresh();}
LightPortalTab.prototype.hide=function(){document.getElementById(this.tabList).style.visibility="hidden"}
LightPortalTab.prototype.getFocusId=function(){if(this.parent==Light.portal){return this.index;}else{return this.parent.getFocusId()+"-"+this.index;}}
LightPortalTab.prototype.focus=function(){Light.currentTab=this;Light.setCookie(Light._CURRENT_TAB,this.getFocusId());var currentTabId=Light.getCurrentTabId();var tabList=document.getElementById(this.tabList);var len=tabList.childNodes.length;if(Light.portal.allowAddTab)
len=len-1;for(var j=0;j<len;j++){if(tabList.childNodes[j]&&tabList.childNodes[j].tagName=="LI"){var className=tabList.childNodes[j].getAttribute("tabColor");var currentTabId=tabList.childNodes[j].getAttribute("tabId");if(currentTabId==this.tabServerId){if(tabList.childNodes[j].className!=className+"current"){tabList.childNodes[j].className=className+"current";document.getElementById("tabSpan"+currentTabId).className=className+"current";document.getElementById("panel_"+currentTabId).style.display="block";if(this.tabIsEditable){var addA=document.createElement('img');addA.src=Light.getThemePath()+'/images/add.gif';addA.title=$('_MENU_ADD_SUBTAB').title;addA.className="portal-tab-button";addA.style.height=16;addA.style.width=16;addA.align="middle";addA.onclick=function(){Light.currentTab.addSubPage();}
document.getElementById("tabSpan"+tabList.childNodes[j].getAttribute("tabId")).appendChild(addA);}
if(this.tabIsCloseable){var clsA=document.createElement('img');clsA.src=Light.getThemePath()+'/images/closeTab.gif';clsA.title=$('_CLOSE').title;clsA.className="portal-tab-button";clsA.onclick=function(){Light.currentTab.close();}
document.getElementById("tabSpan"+tabList.childNodes[j].getAttribute("tabId")).appendChild(clsA);}}else if(this.tabIsEditable&&!this.editTitle){this.editTitle=true;document.getElementById("tabSpan"+tabList.childNodes[j].getAttribute("tabId")).innerHTML="<input type='text' id='portalTabTitle' size='12' value=\""+tabList.childNodes[j].getAttribute("tabLabel")+"\" onchange=\"javascript:Light.portal.saveTabTitle("+this.index+");\" onblur=\"javascript:Light.portal.saveTabTitle("+this.index+");\"/>";document.getElementById('portalTabTitle').focus();}}
else{tabList.childNodes[j].className=className;document.getElementById("tabSpan"+tabList.childNodes[j].getAttribute("tabId")).className=className;document.getElementById("tabSpan"+tabList.childNodes[j].getAttribute("tabId")).style.paddingBottom=10;document.getElementById("panel_"+currentTabId).style.display="none";var nodes=document.getElementById("tabSpan"+tabList.childNodes[j].getAttribute("tabId")).childNodes;for(var i=nodes.length-1;i>=0;i--){if(nodes[i].tagName=="img"||nodes[i].tagName=="IMG")
document.getElementById("tabSpan"+tabList.childNodes[j].getAttribute("tabId")).removeChild(nodes[i]);}}}}}
LightPortalTab.prototype.refresh=function(){if(!this.loaded){this.getSubTabs();this.loaded=true;}else{this.rePositionAll();}
Light.portal.refreshPortalMenu(this);}
LightPortalTab.prototype.close=function(){var lastTabId="";var somethingHasFocus=false;var closeTab=confirm($('_COMMAND_CLOSE_TAB').title);if(!closeTab){return;}
var tabList=document.getElementById(this.tabList);for(i=0;i<tabList.childNodes.length;i++){if(tabList.childNodes[i]&&tabList.childNodes[i].tagName=="LI"){if(tabList.childNodes[i].getAttribute('tabId')==this.tabServerId){tabList.removeChild(tabList.childNodes[i]);}}}
var panelList=document.getElementById(this.tabPanels);for(i=0;i<panelList.childNodes.length;i++){if(panelList.childNodes[i]&&panelList.childNodes[i].tagName=="DIV"){if(panelList.childNodes[i].getAttribute('id')=="panel_"+this.tabServerId){panelList.removeChild(panelList.childNodes[i]);}}}
if(tabList.childNodes.length==1&&Light.portal.allowAddTab){tabList.removeChild(tabList.childNodes[0]);var focusId=Light.getCookie(Light._CURRENT_TAB);Light.setCookie(Light._CURRENT_TAB,focusId.substring(0,focusId.lastIndexOf("-")));Light.currentTab=Light.getTabById(this.parentId);}
for(i=0;i<tabList.childNodes.length-1;i++){if(tabList.childNodes[i]&&tabList.childNodes[i].tagName=="LI"){lastTabId=tabList.childNodes[i].getAttribute('tabId');if(tabList.childNodes[i].getAttribute('tabColor')+"current"==tabList.childNodes[i].className){somethingHasFocus=true;}}}
if(!somethingHasFocus&&lastTabId!=""){var lastTab=Light.getTabById(lastTabId);Light.getTabById(lastTabId).focus();if(!lastTab.loaded){lastTab.refresh();}}
Light.ajax.sendRequest(Light.portal.contextPath+Light.deleteTabRequest,{parameters:'tabId='+this.tabServerId});}
LightPortalTab.prototype.getSubTabs=function(){var tabId=this.tabServerId;if($('page'+tabId)!=null){this.renderSubTabs($('page'+tabId).title);return;}
var currentTab=this;var opt={method:'post',postBody:'parentId='+tabId,onSuccess:function(t){currentTab.getSubTabsHandler(t);},on404:function(t){alert('Error 404: location "'+t.statusText+'" was not found.');},onFailure:function(t){alert('Error '+t.status+' -- '+t.statusText);}}
Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortalTabsByParentRequest,opt);}
LightPortalTab.prototype.getSubTabsHandler=function(t){var subTabs=t.responseText;this.renderSubTabs(subTabs);}
LightPortalTab.prototype.renderSubTabs=function(subTabs){if(subTabs.length==1){this.getPortletsByTab(this.index);return;}
if(Light.portal.portletWindowTransparent==false)
this.panelContainer.innerHTML="<div id='tabs"+this.tabServerId+"' class='portal-tabs' ><ul id='tabList"+this.tabServerId+"'></ul></div><div id='tabPanels"+this.tabServerId+"' class='portal-tab-panels' ></div>";else
this.panelContainer.innerHTML="<div id='tabs"+this.tabServerId+"' class='portal-tabs2' ><ul id='tabList"+this.tabServerId+"'></ul></div><div id='tabPanels"+this.tabServerId+"' class='portal-tab-panels' ></div>";var defaultTab=0;var portalTabs=subTabs.split(";");for(var i=0;i<portalTabs.length;i++){var vPortalTab=eval(portalTabs[i]);vPortalTab.parent=this;vPortalTab.tabList="tabList"+this.tabServerId;vPortalTab.tabPanels="tabPanels"+this.tabServerId;vPortalTab.open(vPortalTab);this.tabs[i]=vPortalTab;if(vPortalTab.defaulted)
defaultTab=i;}
this.addTabMenu();if(this.defaultTab!=null){if(this.defaultTab.indexOf("-")>0){var defaultTabs=this.defaultTab.split("-");if(defaultTabs[0]<portalTabs.length){defaultTab=defaultTabs[0];}
if(defaultTabs.length>1){var defaultSubTabs="";for(var i=1;i<defaultTabs.length;i++){if(i==1)
defaultSubTabs=defaultTabs[i];else
defaultSubTabs+="-"+defaultTabs[i];}
this.tabs[defaultTab].defaultTab=defaultSubTabs;}}else{defaultTab=this.defaultTab;}}
this.tabs[defaultTab].focus();this.tabs[defaultTab].refresh();if(portalTabs.length<=1&&!Light.portal.allowAddTab)
this.tabs[0].hide();}
LightPortalTab.prototype.addTabMenu=function(){if(Light.portal.allowAddTab){var newLabel=document.createElement('span');newLabel.setAttribute("id","tabSpan"+"");newLabel.className="";newLabel.style.paddingBottom=10;newLabel.setAttribute("tabColor","");var clsA=document.createElement('img');clsA.src=Light.getThemePath()+'/images/add.gif';clsA.title=$('_MENU_ADD_TAB').title;clsA.className="portal-tab-button";clsA.style.height=16;clsA.style.width=16;clsA.align="middle";newLabel.appendChild(clsA);var newTab=document.createElement('li');newTab.className=this.tabColor;newTab.setAttribute("id","tabMenuAddTab"+this.tabServerId);newTab.setAttribute("tabId",this.tabServerId);newTab.setAttribute("parentId",this.parentId);newTab.setAttribute("tabLabel",$('_MENU_ADD_TAB').title);newTab.setAttribute("tabColor","");newTab.onclick=function(){var id=this.getAttribute("tabId");addAutoTab(id);}
newTab.setAttribute("tabIsCloseable","0");newTab.setAttribute('isFocused','true');newTab.appendChild(newLabel);document.getElementById("tabList"+this.tabServerId).appendChild(newTab);}}
LightPortalTab.prototype.getPortletsByTab=function(tIndex){var tabId=this.tabServerId;if($('page'+tabId+"Portlets")!=null){this.renderPortlets($('page'+tabId+"Portlets").title);return;}
var currentTab=this;var opt={method:'post',postBody:'tabId='+tabId,onSuccess:function(t){currentTab.responseGetPortletsByTab(t);},on404:function(t){alert('Error 404: location "'+t.statusText+'" was not found.');},onFailure:function(t){alert('Error '+t.status+' -- '+t.statusText);}}
Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortletsByTabRequest,opt);}
LightPortalTab.prototype.responseGetPortletsByTab=function(t){var responseText=t.responseText;this.renderPortlets(responseText);}
LightPortalTab.prototype.renderPortlets=function(responseText){if(responseText.length<=0){this.repositionFooter();return;}
var portlets=responseText.split(";");var portletsCount=portlets.length;var maxPortlet=null;Light.currentTab=this;for(var i=0;i<portletsCount;i++){var vPortlet=null;var windowAppearance=this.portletWindowAppearance;var params=portlets[i];var index=params.indexOf(",");if(index>0&&params.substring(0,index)!="null"){windowAppearance=params.substring(0,index);var type=windowAppearance.substring(windowAppearance.length-1);if(!type.charAt(0).isDigit()){type="1";}
windowAppearance="WindowAppearance"+type;}
var newPortlet="new PortletWindow(new "+windowAppearance+"(), "+this.index+","+params.slice(index+1)+")";var vPortlet=eval(newPortlet);if(vPortlet.state!=Light._MAXIMIZED_STATE)
vPortlet.refresh();else
maxPortlet=vPortlet;}
if(maxPortlet!=null){maxPortlet.refresh();}}
LightPortalTab.prototype.addSubPage=function(){var params="tabId="+this.tabServerId;Light.ajax.sendRequest(Light.portal.contextPath+Light.addSubPageRequest,{parameters:params,onSuccess:Light.refreshPortal});}
LightPortalTab.prototype.resize=function(){var totalWidth=0;for(var i=0;i<this.widths.length;i++){totalWidth+=this.widths[i]+this.between;}
totalWidth+=this.between;if(Light.portal.layout.maxWidth>totalWidth){var diff=Light.portal.layout.maxWidth-totalWidth;var eachD=parseInt(diff/this.widths.length);for(var i=0;i<this.widths.length;i++){this.widths[i]+=eachD;}}
if(Light.portal.layout.maxWidth<totalWidth){var diff=totalWidth-Light.portal.layout.maxWidth;var eachD=parseInt(diff/this.widths.length);for(var i=0;i<this.widths.length;i++){this.widths[i]-=eachD;}}
this.reLayout();Light.portal.refreshPortalMenu(this);}
LightPortalTab.prototype.reLayout=function(){for(var i=0;i<this.portlets.length;i++){if(this.portlets[i]!=null){for(var j=0;j<this.portlets[i].length;j++){if(this.portlets[i][j]!=null&&!this.portlets[i][j].maximized){this.portlets[i][j].width=this.widths[i];this.portlets[i][j].left=0;for(var k=0;k<this.portlets[i][j].position;k++){this.portlets[i][j].left+=this.widths[k]+this.between;}}}}}
this.rePositionAll();}
LightPortalTab.prototype.rePositionAll=function(){for(var i=0;i<this.portlets.length;i++){if(this.portlets[i]!=null){for(var j=0;j<this.portlets[i].length;j++){if(this.portlets[i][j]!=null&&!this.portlets[i][j].maximized){this.rePositionPortlets(this.portlets[i][j]);break;}}}}
this.repositionFooter();}
LightPortalTab.prototype.getTop=function(){if(this.parent!=Light.portal)
return 30+this.parent.getTop();else
return 0;}
LightPortalTab.prototype.rePositionPortlets=function(portlet){var rowBetween=10;if(portlet.window.layout!=null)
rowBetween=portlet.window.layout.rowBetween;else if(portlet.layout!=null)
rowBetween=portlet.layout.rowBetween;var position=portlet.position;var index=portlet.index;var height=0;var maxIndex=0;var nullNum=0;for(var i=0;i<this.portlets[position].length;i++){if(this.portlets[position][i]!=null){if(i>=index&&!this.portlets[position][i].maximized){this.portlets[position][i].top=this.getTop()+this.portlets[position][i].getTop()+height+rowBetween*(i-maxIndex-nullNum);this.portlets[position][i].refreshPosition();}
if(!this.portlets[position][i].maximized){height+=this.portlets[position][i].getHeight();}
if(this.portlets[position][i].maximized){height=this.portlets[position][i].getHeight();maxIndex=i;nullNum=0;}}
if(this.portlets[position][i]==null){nullNum++;}}
this.repositionFooter();}
LightPortalTab.prototype.repositionFooter=function(){var currentTabId=Light.getCurrentTabId();if(currentTabId!=this.tabServerId)return;var maxHeight=this.getMaxHeight();if(document.all){Light.portal.footer.style.posTop=maxHeight;}
else{Light.portal.footer.style.top=maxHeight;}
if((maxHeight-Light.portal.layout.maxTop)>Light.portal.layout.maxHeight)
Light.portal.container.style.height=maxHeight-Light.portal.layout.maxTop;Light.portal.footer.style.width=Light.portal.layout.maxWidth;}
LightPortalTab.prototype.getMaxHeight=function(){var heights=new Array();var maxHeight=0;for(var i=0;i<this.portlets.length;i++){if(this.portlets[i]!=null){for(var j=0;j<this.portlets[i].length;j++){if(this.portlets[i][j]!=null){if(this.portlets[i][j].maximized){maxHeight=this.portlets[i][j].top+this.portlets[i][j].window.container.clientHeight;break;}
if(!this.portlets[i][j].maximized){heights[i]=this.portlets[i][j].top+this.portlets[i][j].window.container.clientHeight;}}}}
if(maxHeight>0)
break;}
if(maxHeight==0){for(var i=0;i<heights.length;i++){if(heights[i]>maxHeight)
maxHeight=heights[i];}}
maxHeight=maxHeight+Light.portal.layout.footerHeightMargin;if(maxHeight<300)maxHeight=300;return maxHeight;}
LightPortalTab.prototype.getPortletIndex=function(position){var addAfterLast=true;var index=0;if(this.portlets[position]!=null){for(var i=0;i<this.portlets[position].length;i++){if(this.portlets[position][i]==null){addAfterLast=false;index=i;break;}}
if(addAfterLast){index=this.portlets[position].length;}}else{this.portlets[position]=new Array();}
return index;}
LightPortalTab.prototype.showOtherPortlets=function(){for(var i=0;i<this.portlets.length;i++){if(this.portlets[i]!=null){for(var j=0;j<this.portlets[i].length;j++){if(this.portlets[i][j]!=null&&this.portlets[i][j].maximized){this.portlets[i][j].show();return;}}}}
for(var i=0;i<this.portlets.length;i++){if(this.portlets[i]!=null){for(var j=0;j<this.portlets[i].length;j++){if(this.portlets[i][j]!=null){this.portlets[i][j].show();}}}}
Light.portal.menu.style.zIndex=++Light.maxZIndex;}
LightPortalTab.prototype.hideOtherPortlets=function(portlet){for(var i=0;i<this.portlets.length;i++){if(this.portlets[i]!=null){for(var j=0;j<this.portlets[i].length;j++){if(this.portlets[i][j]!=null&&this.portlets[i][j].serverId!=portlet.serverId){if(this.portlets[i][j].popup){this.portlets[i][j].close(true);}else
this.portlets[i][j].hide();}}}}}
LightPortalTab.prototype.collapseAll=function(){for(var i=0;i<this.portlets.length;i++){if(this.portlets[i]!=null){for(var j=0;j<this.portlets[i].length;j++){if(this.portlets[i][j]!=null&&!this.portlets[i][j].minimized){this.portlets[i][j].minimize();}}}}}
LightPortalTab.prototype.expandAll=function(){for(var i=0;i<this.portlets.length;i++){if(this.portlets[i]!=null){for(var j=0;j<this.portlets[i].length;j++){if(this.portlets[i][j]!=null&&this.portlets[i][j].minimized){this.portlets[i][j].minimize();}
if(this.portlets[i][j]!=null&&this.portlets[i][j].maximized){this.portlets[i][j].maximize();}}}}}
LightPortalTab.prototype.refreshWindowTransparent=function(){for(var i=0;i<this.portlets.length;i++){if(this.portlets[i]!=null){for(var j=0;j<this.portlets[i].length;j++){if(this.portlets[i][j]!=null){this.portlets[i][j].refreshWindowTransparent();}}}}}
function PortletWindow(window,tIndex,serverId,position,title,icon,url,request,requestUrl,closeable,refreshMode,editMode,helpMode,configMode,allowMinimized,allowMaximized,autoRefreshed,refreshAtClient,periodTime,allowJS,barBgColor,barFontColor,contentBgColor,textColor,parameter,initState,initMode,intTransparent)
{Light.portal.allPortlets[Light.portal.allPortlets.size()]=this;this.parent=Light.currentTab;this.window=window;this.allowMove=true;this.mode=Light._VIEW_MODE;if(initMode==1)this.mode=Light._EDIT_MODE;if(initMode==2)this.mode=Light._HELP_MODE;if(initMode==3)this.mode=Light._CONFIG_MODE;this.state=Light._NORMAL_STATE;if(initState==1)this.state=Light._MINIMIZED_STATE;if(initState==2)this.state=Light._MAXIMIZED_STATE;this.tIndex=tIndex;this.serverId=serverId;this.position=position;this.title=title;this.icon=icon;this.url=url;this.request=request;this.requestUrl=requestUrl;this.closeable=closeable;this.refreshMode=refreshMode;this.editMode=editMode;this.helpMode=helpMode;this.configMode=configMode;this.allowMinimized=allowMinimized;this.allowMaximized=allowMaximized;this.autoRefreshed=autoRefreshed;this.refreshAtClient=refreshAtClient;this.periodTime=periodTime;this.allowJS=allowJS;this.barBgColor=barBgColor;this.barFontColor=barFontColor;this.contentBgColor=contentBgColor;this.textColor=textColor;this.parameter=parameter;this.transparent=false;if(intTransparent==1)this.transparent=true;this.index=this.parent.getPortletIndex(this.position);var height=0;var maxIndex=0;var nullNum=0;for(var i=0;i<this.parent.portlets[this.position].length;i++){if(i==this.index){break;}
if(this.parent.portlets[this.position][i]!=null&&!this.parent.portlets[this.position][i].maximized){height+=this.parent.portlets[this.position][i].window.container.clientHeight;}
if(this.parent.portlets[this.position][i]==null){nullNum++;}
if(this.parent.portlets[this.position][i]!=null&&this.parent.portlets[this.position][i].maximized){height=this.parent.portlets[this.position][i].window.container.clientHeight;maxIndex=i;nullNum=0;}}
this.top=this.window.top+height+this.window.layout.rowBetween*(i-maxIndex-nullNum);this.width=this.parent.widths[this.position];this.left=this.window.left;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
this.parent.portlets[this.position][this.index]=this;this.window.render(this);this.minimized=false;this.maximized=false;this.moveable=false;this.autoRefreshWhenMaximized=false;this.autoShow=false;this.opacity=0;this.fade="in";this.myPictureIndex=0;this.myPictures=new Array();this.autoShowId=null;this.mouseDownX=0;this.mouseDownY=0;this.refreshPosition();this.loading=Light.getViewTemplate("loadingPortlet.view");this.content=null;this.window.container.innerHTML=this.loading;this.parent.rePositionPortlets(this);if(this.autoRefreshed){this.firstTimeAutoRefreshed=true;this.autoRefresh();}
this.refreshPortletTitle();}
PortletWindow.prototype.refreshPortletTitle=function(){var params="path="+this.requestUrl
+"&responseId="+Light._PC_PREFIX+this.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.getPortletTitle,{parameters:params,onSuccess:setPortletTitle});}
PortletWindow.prototype.focus=function()
{this.window.focus(this);}
PortletWindow.prototype.show=function(){this.window.show(this);}
PortletWindow.prototype.hide=function(){this.window.hide(this);}
PortletWindow.prototype.moveBegin=function(e)
{document.body.onselectstart=function(){return false};document.body.ondragstart=function(){return false};if(document.all)e=event;var x=e.clientX;var y=e.clientY;this.window.focus(this);this.moveable=true;this.mouseDownX=x;this.mouseDownY=y;this.moveBeginX=x;this.moveBeginY=y;Light.portal.moveTimer=0;this.startMoveTimer();var vdocument=document.getElementById('panel_'+this.parent.tabServerId);Light.portal.highLight.style.visibility="hidden";vdocument.appendChild(Light.portal.highLight);}
PortletWindow.prototype.moveEnd=function()
{if(this.moveable){var xDifference=this.mouseDownX-this.moveBeginX;var yDifference=this.mouseDownY-this.moveBeginY;if(this.moveToColumn!=this.position){if(this.moveToColumn>this.position)
this.moveRight(this.moveToColumn);else if(this.moveToColumn<this.position)
this.moveLeft(this.moveToColumn);}
else{if(this.mouseDownY>this.moveBeginY)
this.moveDown();else if(this.mouseDownY<this.moveBeginY)
this.moveUp();}
this.lastAction=null;this.moveable=false;var vdocument=document.getElementById('panel_'+this.parent.tabServerId);vdocument.removeChild(Light.portal.highLight);if(!this.minimized){this.refresh();}}}
PortletWindow.prototype.move=function(e)
{if(this.moveable){var x=e.clientX;var y=e.clientY;this.left+=x-this.mouseDownX;this.top+=y-this.mouseDownY;var direction="left";if(x>this.mouseDownX)direction="right";this.refreshPosition(this);this.mouseDownX=x;this.mouseDownY=y;var xDifference=this.mouseDownX-this.moveBeginX;var yDifference=this.mouseDownY-this.moveBeginY;var moveTo=0;var moveToColumn=-1;for(var i=0;i<this.parent.widths.length;i++){if(i>0)
moveTo+=this.parent.widths[i-1]+this.parent.between*(i-1);if(direction=="left"){if(this.left<moveTo+this.parent.widths[i]){moveToColumn=i;break;}}else{if(this.left+this.width>moveTo){moveToColumn=i;}}}
this.moveToColumn=moveToColumn;Light.portal.highLight.style.visibility="visible";if(moveToColumn!=this.position){if(moveToColumn>this.position)
this.highLightX(1,moveToColumn);else if(moveToColumn<this.position)
this.highLightX(2,moveToColumn);}else{if(this.mouseDownY>this.moveBeginY)
this.highLight(3);else if(this.mouseDownY<this.moveBeginY)
this.highLight(4);}}}
PortletWindow.prototype.startMoveTimer=function()
{if(Light.portal.moveTimer>=0&&Light.portal.moveTimer<10){Light.portal.moveTimer++;setTimeout((function(){this.startMoveTimer()}).bind(this),15);}
if(Light.portal.moveTimer==10){Light.portal.dragDropPortlet=this;this.refreshPosition();}}
PortletWindow.prototype.refreshPosition=function()
{this.window.position(this);}
PortletWindow.prototype.autoRefresh=function()
{if(this.mode!=Light._VIEW_MODE)return;if(this.autoRefreshed){if(this.firstTimeAutoRefreshed){this.firstTimeAutoRefreshed=false;}else{this.selfRefresh();}
setTimeout((function(){this.autoRefresh()}).bind(this),this.periodTime);}}
PortletWindow.prototype.selfRefresh=function()
{if(!this.minimized&&(!this.maximized||this.autoRefreshWhenMaximized)){if(this.mode==Light._VIEW_MODE){if(this.refreshAtClient){Light.refreshAtClient(this);}else{this.refreshAction=true;Light.executeRefresh(Light._PC_PREFIX+this.serverId);}}}
if(this.minimized&&this.path=="/myMessagePortlet.lp"){this.refreshPortletTitle();}}
PortletWindow.prototype.refresh=function(flag)
{if(Light.executeAtClient(this))return;if(flag==null||flag==true){this.window.container.innerHTML=this.loading;}
this.parent.rePositionPortlets(this);this.refreshAction=true;this.refreshPortletTitle();Light.executeRefresh(Light._PC_PREFIX+this.serverId);if(this.autoRefreshed){this.firstTimeAutoRefreshed=true;this.autoRefresh();}}
PortletWindow.prototype.changePosition=function()
{var params="responseId="+Light._PC_PREFIX+this.serverId
+"&tabId="+this.parent.tabServerId
+"&portletId="+this.serverId
+"&column="+this.position
+"&row="+this.index;Light.ajax.sendRequest(Light.portal.contextPath+Light.changePositionRequest,{parameters:params});this.parent.rePositionPortlets(this);}
PortletWindow.prototype.rememberMode=function(mode){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId=="")
userId=Light.getCookie(Light._USER_ID);if(userId!=null&&userId!=""){var params="mode="+mode+"&portletId="+this.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.rememberMode,{parameters:params});}}
PortletWindow.prototype.refreshButtons=function()
{this.window.refreshButtons(this);if(this.mode==Light._EDIT_MODE){this.rememberMode(1);}else if(this.mode==Light._HELP_MODE){this.rememberMode(2);}else{this.rememberMode(0);}}
PortletWindow.prototype.edit=function()
{if(this.editMode){if(this.clientCached)
this.content=this.window.container.innerHTML;this.mode=Light._EDIT_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.refreshButtons();}}
PortletWindow.prototype.cancelEdit=function()
{if(this.editMode){this.mode=Light._VIEW_MODE;if(this.clientCached&&this.content!=null)
this.window.container.innerHTML=this.content;else{var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);}
this.refreshButtons();}}
PortletWindow.prototype.help=function()
{if(this.helpMode){if(this.clientCached)
this.content=this.window.container.innerHTML;this.mode=Light._HELP_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.refreshButtons();}}
PortletWindow.prototype.cancelHelp=function()
{if(this.helpMode){this.mode=Light._VIEW_MODE;if(this.clientCached&&this.content!=null)
this.window.container.innerHTML=this.content;else{var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);}
this.refreshButtons();}}
PortletWindow.prototype.config=function()
{if(this.configMode){if(this.clientCached)
this.content=this.window.container.innerHTML;this.mode=Light._CONFIG_MODE;var data={id:Light._PC_PREFIX+this.serverId,title:this.title,barBgColor:this.barBgColor,barFontColor:this.barFontColor,contentBgColor:this.contentBgColor,textColor:this.textColor,transparent:this.transparent,skin:'PortletWindow2'};this.window.container.innerHTML=TrimPath.processDOMTemplate("configMode.jst",data);Light.responsePortlet(data.id);this.refreshButtons();}}
PortletWindow.prototype.cancelConfig=function()
{if(this.configMode){this.mode=Light._VIEW_MODE;if(this.clientCached&&this.content!=null)
this.window.container.innerHTML=this.content;else{this.refresh();}
this.refreshWindow();}}
PortletWindow.prototype.highLightX=function(pos,moveToColumn)
{var temp=null;var temp2=null;var showHighLight=true;var columnLeft=0;if(this.parent.portlets[moveToColumn]==null)
this.parent.portlets[moveToColumn]=new Array();if(this.parent.portlets[moveToColumn]!=null){var column=moveToColumn;var len=this.parent.portlets[column].length;for(var i=0;i<len;i++){if(this.parent.portlets[column][i]!=null){if(columnLeft==0)columnLeft=this.parent.portlets[column][i].left;if(this.top<this.parent.portlets[column][i].top){temp=this.parent.portlets[column][i];break;}}}
if(temp==null){for(var i=len-1;i>=0;i--){if(this.parent.portlets[column][i]!=null){temp2=this.parent.portlets[column][i];break;}}}}else
showHighLight=false;if(showHighLight){var highLeft=columnLeft;var highTop=this.window.top+5;var highWidth=this.parent.widths[moveToColumn];var highHeight=5;if(temp!=null){highTop=temp.top-this.window.layout.rowBetween+2;highLeft=temp.left;highWidth=temp.width;}else if(temp2!=null){highTop=temp2.top+temp2.window.container.clientHeight+2;}
if(temp!=null){highTop=temp.top-5;highLeft=temp.left;highWidth=temp.width;}else if(temp2!=null){highTop=temp2.top+temp2.window.container.clientHeight+temp2.window.layout.rowBetween-5;}
if(document.all){Light.portal.highLight.style.posLeft=highLeft;Light.portal.highLight.style.posTop=highTop;}else{Light.portal.highLight.style.left=highLeft;Light.portal.highLight.style.top=highTop;}
Light.portal.highLight.style.width=highWidth;Light.portal.highLight.style.height=highHeight;Light.portal.highLight.style.zIndex=++Light.maxZIndex;}else
Light.portal.highLight.style.visibility="hidden";}
PortletWindow.prototype.highLight=function(pos)
{var temp=null;var showHighLight=true;if(pos==1){var columns=this.parent.widths.length;if(this.position+1<columns&&this.parent.portlets[this.position+1]==null)
this.parent.portlets[this.position+1]=new Array();if(this.parent.portlets[this.position+1]!=null){var column=this.position+1;var len=this.parent.portlets[column].length;for(var i=0;i<len;i++){if(this.parent.portlets[column][i]!=null&&this.top<this.parent.portlets[column][i].top){temp=this.parent.portlets[column][i];break;}}}else
showHighLight=false;}
if(pos==2){if(this.position>0){var column=this.position-1;if(this.parent.portlets[column]==null)
this.parent.portlets[column]=new Array();var len=this.parent.portlets[column].length;for(var i=0;i<len;i++){if(this.parent.portlets[column][i]!=null&&this.top<this.parent.portlets[column][i].top){temp=this.parent.portlets[column][i];break;}}}else
showHighLight=false;}
if(pos==3){var started=this.index+1;for(var i=started;i<this.parent.portlets[this.position].length;i++){if(this.parent.portlets[this.position][i]!=null){temp=this.parent.portlets[this.position][i];break;}}
if(temp==null)
showHighLight=false;}
if(pos==4){if(this.index>0){var started=this.index-1;for(var i=started;i>=0;i--){if(this.parent.portlets[this.position][i]!=null){temp=this.parent.portlets[this.position][i];break;}}
if(temp==null)
showHighLight=false;}else
showHighLight=false;}
if(showHighLight){var highLeft;var highTop;var highWidth;var highHeight=5;if(temp!=null){if(pos!=3)
highTop=temp.top-5;else
highTop=temp.top+temp.window.container.clientHeight+temp.window.layout.rowBetween-5;highLeft=temp.left;highWidth=temp.width;}
else{var temp2=null;var column=0;if(pos==1)
column=this.position+1;if(pos==2)
column=this.position-1;var len=this.parent.portlets[column].length;for(var i=len-1;i>=0;i--){if(this.parent.portlets[column][i]!=null){temp2=this.parent.portlets[column][i];break;}}
if(temp2!=null){highLeft=temp2.left;highTop=temp2.top+temp2.window.container.clientHeight+this.window.layout.rowBetween;highWidth=temp2.width;}else{highLeft=this.parent.between;for(var i=0;i<column;i++){highLeft+=this.parent.widths[i]+this.parent.between;}
highTop=this.window.top+this.window.layout.rowBetween;highWidth=this.parent.widths[column];}}
if(document.all){Light.portal.highLight.style.posLeft=highLeft;Light.portal.highLight.style.posTop=highTop;}else{Light.portal.highLight.style.left=highLeft;Light.portal.highLight.style.top=highTop;}
Light.portal.highLight.style.width=highWidth;Light.portal.highLight.style.height=highHeight;Light.portal.highLight.style.zIndex=++Light.maxZIndex;}else
Light.portal.highLight.style.visibility="hidden";}
PortletWindow.prototype.moveCancel=function()
{this.buttonIsClicked=true;}
PortletWindow.prototype.moveAllowed=function()
{this.buttonIsClicked=false;}
PortletWindow.prototype.moveUp=function()
{if(this.index>0){var temp=null;var upIndex=0;var currentIndex=this.index;var started=this.index-1;for(var i=started;i>=0;i--){if(this.parent.portlets[this.position][i]!=null){temp=this.parent.portlets[this.position][i];upIndex=i;break;}}
if(temp!=null){temp.index=this.index;this.index=upIndex;this.parent.portlets[this.position][upIndex]=this;this.parent.portlets[this.position][currentIndex]=temp;temp.changePosition();temp.lastAction=null;if(!temp.minimized){temp.refresh(false);}
this.left=0;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
this.changePosition();}}}
PortletWindow.prototype.moveDown=function()
{var temp=null;var downIndex=0;var currentIndex=this.index;var started=this.index+1;for(var i=started;i<this.parent.portlets[this.position].length;i++){if(this.parent.portlets[this.position][i]!=null){temp=this.parent.portlets[this.position][i];downIndex=i;break;}}
if(temp!=null){temp.index=this.index;this.index=downIndex;this.parent.portlets[this.position][downIndex]=this;this.parent.portlets[this.position][currentIndex]=temp;this.changePosition();this.left=0;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
temp.changePosition();temp.lastAction=null;if(!temp.minimized){temp.refresh(false);}}}
PortletWindow.prototype.moveLeft=function(moveToColumn)
{if(this.position>0){var temp=null;var newIndex=0;var currentPosition=this.position;var currentIndex=this.index;var column=moveToColumn;if(this.parent.portlets[column]==null)
this.parent.portlets[column]=new Array();var len=this.parent.portlets[column].length;for(var i=0;i<len;i++){if(this.parent.portlets[column][i]!=null&&this.top<this.parent.portlets[column][i].top){temp=this.parent.portlets[column][i];newIndex=temp.index;break;}}
if(temp!=null){for(var i=len-1;i>=0;i--){if(this.parent.portlets[column][i]!=null){var temp2=this.parent.portlets[column][i];temp2.index++;this.parent.portlets[column][i+1]=temp2;this.parent.portlets[column][i+1].changePosition();this.parent.portlets[column][i]=null;temp2.lastAction=null;if(!temp2.minimized){temp2.refresh(false);}
if(temp2.serverId==temp.serverId)break;}}
this.position=column;this.index=newIndex;this.parent.portlets[this.position][this.index]=this;this.parent.portlets[currentPosition][currentIndex]=null;this.left=0;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
this.width=this.parent.widths[this.position];this.changePosition();}else{this.position=column;var isEmpty=true;for(var i=len-1;i>=0;i--){if(this.parent.portlets[column][i]!=null){var temp3=this.parent.portlets[column][i];this.index=temp3.index+1;isEmpty=false;break;}}
if(isEmpty)this.index=0;this.parent.portlets[this.position][this.index]=this;this.parent.portlets[currentPosition][currentIndex]=null;this.left=0;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
this.width=this.parent.widths[this.position];this.changePosition();}
var length=this.parent.portlets[currentPosition].length;for(var i=currentIndex+1;i<length;i++){if(this.parent.portlets[currentPosition][i]!=null){var next=this.parent.portlets[currentPosition][i];this.parent.rePositionPortlets(next);break;}}}}
PortletWindow.prototype.moveRight=function(moveToColumn)
{columns=this.parent.widths.length;if(this.position+1<columns&&this.parent.portlets[this.position+1]==null)
this.parent.portlets[this.position+1]=new Array();if(this.parent.portlets[this.position+1]!=null){var temp=null;var newIndex=0;var currentPosition=this.position;var currentIndex=this.index;var column=moveToColumn;var len=this.parent.portlets[column].length;for(var i=0;i<len;i++){if(this.parent.portlets[column][i]!=null&&this.top<this.parent.portlets[column][i].top){temp=this.parent.portlets[column][i];newIndex=temp.index;break;}}
if(temp!=null){for(var i=len-1;i>=0;i--){if(this.parent.portlets[column][i]!=null){var temp2=this.parent.portlets[column][i];temp2.index++;this.parent.portlets[column][i+1]=temp2;this.parent.portlets[column][i+1].changePosition();this.parent.portlets[column][i]=null;temp2.lastAction=null;if(!temp2.minimized){temp2.refresh(false);}
if(temp2.serverId==temp.serverId)break;}}
this.position=column;this.index=newIndex;this.parent.portlets[this.position][this.index]=this;this.parent.portlets[currentPosition][currentIndex]=null;this.left=0;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
this.width=this.parent.widths[this.position];this.changePosition();}else{this.position=column;var isEmpty=true;for(var i=len-1;i>=0;i--){if(this.parent.portlets[column][i]!=null){var temp3=this.parent.portlets[column][i];this.index=temp3.index+1;isEmpty=false;break;}}
if(isEmpty)this.index=0;this.parent.portlets[this.position][this.index]=this;this.parent.portlets[currentPosition][currentIndex]=null;this.left=0;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
this.width=this.parent.widths[this.position];this.changePosition();}
var length=this.parent.portlets[currentPosition].length;for(var i=currentIndex+1;i<length;i++){if(this.parent.portlets[currentPosition][i]!=null){var next=this.parent.portlets[currentPosition][i];this.parent.rePositionPortlets(next);break;}}}}
PortletWindow.prototype.minimize=function()
{if(this.allowMinimized){this.minimized=!this.minimized;if(this.minimized){this.state=Light._MINIMIZED_STATE;if(this.maximized){this.maximize(false);this.minimized=true;}
var empty="<br/>";this.window.container.innerHTML=empty;}else{this.state=Light._NORMAL_STATE;}
this.window.minimize(this);this.parent.rePositionPortlets(this);var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId=="")
userId=Light.getCookie(Light._USER_ID);if(userId!=null&&userId!=""){var state=0;if(this.minimized)state=1;var params="state="+state+"&portletId="+this.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.rememberState,{parameters:params});}
if(!this.minimized)
this.refresh()}}
PortletWindow.prototype.maximize=function(flag)
{this.windowMaximize(flag);this.refresh();}
PortletWindow.prototype.windowMaximize=function(flag)
{this.maximized=!this.maximized;if(!this.maximized){this.state=Light._NORMAL_STATE;var height=0;var maxIndex=0;var nullNum=0;for(var i=0;i<this.parent.portlets[this.position].length;i++){if(i==this.index){break;}
if(this.parent.portlets[this.position][i]!=null&&!this.parent.portlets[this.position][i].maximized){height+=this.parent.portlets[this.position][i].window.container.clientHeight;}
if(this.parent.portlets[this.position][i]==null){nullNum++;}
if(this.parent.portlets[this.position][i]!=null&&this.parent.portlets[this.position][i].maximized){height=this.parent.portlets[this.position][i].window.container.clientHeight;maxIndex=i;nullNum=0;}}
this.top=this.window.top+height+this.window.layout.rowBetween*(i-maxIndex-nullNum);this.width=this.parent.widths[this.position];this.left=0;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
Light.portal.container.style.zIndex=1;this.parent.showOtherPortlets();}else{this.state=Light._MAXIMIZED_STATE;this.parent.hideOtherPortlets(this);this.left=Light.portal.layout.maxLeft;this.top=Light.portal.layout.maxTop;this.width=Light.portal.layout.maxWidth;Light.portal.container.style.zIndex=++Light.maxZIndex;Light.portal.body.style.zIndex=++Light.maxZIndex;Light.portal.footer.style.zIndex=++Light.maxZIndex;}
this.window.maximize(this);this.parent.rePositionPortlets(this);if(flag==null||flag==true){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId=="")
userId=Light.getCookie(Light._USER_ID);if(userId!=null&&userId!=""){var state=0;if(this.maximized)state=2;var params="state="+state+"&portletId="+this.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.rememberState,{parameters:params});}}}
PortletWindow.prototype.close=function()
{var closePortlet=confirm($('_COMMAND_CLOSE_PORTLET').title);if(!closePortlet)
{return;}
if(this.maximized)
this.parent.showOtherPortlets();this.window.close(this);this.parent.portlets[this.position][this.index]=null;this.parent.rePositionPortlets(this);Light.ajax.sendRequest(Light.portal.contextPath+Light.deletePortletRequest,{parameters:'portletId='+this.serverId});}
PortletWindow.prototype.refreshWindow=function(){this.window.refreshWindow(this);}
PortletWindow.prototype.refreshHeader=function(){this.window.refreshHeader(this);}
PortletWindow.prototype.refreshWindowTransparent=function(){if(Light.portal.portletWindowTransparent==false&&this.transparent==false){if(this.contentBgColor.length>0)
this.window.container.style.backgroundColor=this.contentBgColor;else
this.window.container.style.backgroundColor="#ffffff";}else{this.window.container.style.backgroundColor="transparent";}}
PortletWindow.prototype.refreshTextColor=function(){var id=this.window.container.id;if(this.textColor.length>0){var elements=$$('#'+id+' a','#'+id+' td','#'+id+' text','#'+id+' textarea','#'+id+' select','#'+id+' span');for(var i=0;i<elements.length;i++){elements[i].style.color=this.textColor;}
elements=null;}
if(this.contentBgColor.length>0){var elements=$$('#'+id+' textarea');for(var i=0;i<elements.length;i++){elements[i].style.backgroundColor=this.contentBgColor;}
elements=null;}}
PortletWindow.prototype.getTop=function(){return this.window.top;}
PortletWindow.prototype.getHeight=function(){return this.window.window.clientHeight;}
PortletWindow.prototype.setContent=function(content){this.window.setContent(content);}
function PortletPopupWindow(position,left,width,title,icon,url,request,requestUrl,closeable,refreshMode,editMode,helpMode,configMode,autoRefreshed,refreshAtClient,periodTime,allowJS,barBgColor,barFontColor,contentBgColor,parameter,allowMinimized,allowMaximized,allowPopup,location){Light.portal.allPortlets[Light.portal.allPortlets.size()]=this;this.parent=Light.currentTab;this.window=new WindowAppearance2();this.allowMove=true;this.popup=true;if(typeof allowPopup!="undefined"&&!allowPopup)
this.popup=false;if(typeof location!="undefined"){this.location=location;if(this.location==1){Light.portal.originalLeft=Light.portal.layout.containerLeft;Light.portal.layout.containerLeft=width+10;Light.portal.body.style.marginLeft=Light.portal.layout.containerLeft+Light.portal.layout.bodyLeft;this.allowMove=false;}}
this.mode=Light._VIEW_MODE;this.state=Light._NORMAL_STATE;this.tIndex=this.parent.index;this.serverId=Date.parse(new Date());this.position=position;this.left=left;this.width=width;this.title=title;this.icon=icon;this.url=url;this.request=request;this.requestUrl=requestUrl;this.closeable=closeable;this.refreshMode=refreshMode;this.editMode=editMode;this.helpMode=helpMode;this.configMode=configMode;this.allowMinimized=true;if(allowMinimized!=null&&!allowMinimized)this.allowMinimized=false;this.allowMaximized=true;if(allowMaximized!=null&&!allowMaximized)this.allowMaximized=false;this.autoRefreshed=autoRefreshed;this.refreshAtClient=refreshAtClient;this.periodTime=periodTime;this.allowJS=allowJS;this.barBgColor=barBgColor;this.barFontColor=barFontColor;this.className="portlet-popup";this.contentBgColor='#EEF6FF';if(contentBgColor!='')this.contentBgColor=contentBgColor;this.parameter=parameter;this.index=this.parent.getPortletIndex(this.position);var height=0;var maxIndex=0;var nullNum=0;this.originalTop=this.top;this.originalWidth=this.width;this.originalLeft=this.left;this.parent.portlets[this.position][this.index]=this;this.window.render(this);this.minimized=false;this.maximized=false;this.moveable=false;this.autoRefreshWhenMaximized=false;this.autoShow=false;this.opacity=0;this.fade="in";this.myPictureIndex=0;this.myPictures=new Array();this.autoShowId=null;this.mouseDownX=0;this.mouseDownY=0;this.refreshPosition();this.loading=Light.getViewTemplate("loadingPortlet.view");this.window.container.innerHTML=this.loading;this.focus();if(this.autoRefreshed){this.firstTimeAutoRefreshed=true;this.autoRefresh(this);}
if(this.location==null){this.windowMaximize();}}
PortletPopupWindow.prototype.rememberMode=function(mode){}
PortletPopupWindow.prototype.focus=function()
{this.window.focus(this);}
PortletPopupWindow.prototype.show=function(){this.window.show(this);}
PortletPopupWindow.prototype.hide=function(){this.window.hide(this);}
PortletPopupWindow.prototype.moveBegin=function(e)
{document.body.onselectstart=function(){return false};document.body.ondragstart=function(){return false};if(document.all)e=event;var x=e.clientX;var y=e.clientY;this.focus();this.moveable=true;this.mouseDownX=x;this.mouseDownY=y;this.moveBeginX=x;this.moveBeginY=y;Light.portal.moveTimer=0;this.startMoveTimer(this);}
PortletPopupWindow.prototype.moveEnd=function()
{if(this.moveable){this.moveable=false;this.originalLeft=this.left;this.originalTop=this.top;}}
PortletPopupWindow.prototype.move=function(e)
{if(this.moveable){var x=e.clientX;var y=e.clientY;this.left+=x-this.mouseDownX;this.top+=y-this.mouseDownY;this.refreshPosition();this.mouseDownX=x;this.mouseDownY=y;}}
PortletPopupWindow.prototype.startMoveTimer=function(portlet)
{if(Light.portal.moveTimer>=0&&Light.portal.moveTimer<10){Light.portal.moveTimer++;setTimeout((function(){portlet.startMoveTimer(portlet)}),15);}
if(Light.portal.moveTimer==10){Light.portal.dragDropPortlet=this;portlet.refreshPosition();}}
PortletPopupWindow.prototype.refreshPosition=function()
{this.window.position(this);this.focus();}
PortletPopupWindow.prototype.autoRefresh=function(portlet)
{if(portlet.autoRefreshed){if(portlet.firstTimeAutoRefreshed){portlet.firstTimeAutoRefreshed=false;}else{portlet.selfRefresh();}
setTimeout((function(){portlet.autoRefresh(portlet)}),portlet.periodTime);}}
PortletPopupWindow.prototype.selfRefresh=function()
{if(!this.minimized&&(!this.maximized||this.autoRefreshWhenMaximized)){if(this.mode==Light._VIEW_MODE){if(this.refreshAtClient){Light.refreshAtClient(this);}else{this.refreshAction=true;Light.executeRefresh(Light._PC_PREFIX+this.serverId);}}}
if(this.minimized&&this.path=="/myMessagePortlet.lp"){this.refreshPortletTitle();}}
PortletPopupWindow.prototype.refresh=function(flag)
{if(Light.executeAtClient(this))return;if(flag==null||flag==true){this.window.container.innerHTML=this.loading;}
this.parent.rePositionPortlets(this);this.refreshAction=true;Light.executeRefresh(Light._PC_PREFIX+this.serverId);}
PortletPopupWindow.prototype.changePosition=function()
{var params="responseId="+Light._PC_PREFIX+this.serverId
+"&tabId="+this.parent.tabServerId
+"&portletId="+this.serverId
+"&column="+this.position
+"&row="+this.index;Light.ajax.sendRequest(Light.portal.contextPath+Light.changePositionRequest,{parameters:params});this.parent.rePositionPortlets(this);}
PortletPopupWindow.prototype.edit=function()
{if(this.editMode){this.mode=Light._EDIT_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletPopupWindow.prototype.cancelEdit=function()
{if(this.editMode){this.mode=Light._VIEW_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletPopupWindow.prototype.help=function()
{if(this.helpMode){this.mode=Light._HELP_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletPopupWindow.prototype.cancelHelp=function()
{if(this.helpMode){this.mode=Light._VIEW_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletPopupWindow.prototype.config=function()
{if(this.configMode){this.mode=Light._CONFIG_MODE;this.window.refreshButtons(this);var data={id:Light._PC_PREFIX+this.serverId,title:this.title,barBgColor:this.barBgColor,barFontColor:this.barFontColor,contentBgColor:this.contentBgColor,textColor:this.textColor,transparent:this.transparent};this.window.container.innerHTML=TrimPath.processDOMTemplate("configMode.jst",data);Light.responsePortlet(data.id);}}
PortletPopupWindow.prototype.cancelConfig=function()
{if(this.configMode){this.mode=Light._VIEW_MODE;var id=Light._PC_PREFIX+this.serverId;Light.executePortlet(id);this.window.refreshButtons(this);}}
PortletPopupWindow.prototype.moveCancel=function()
{this.buttonIsClicked=true;}
PortletPopupWindow.prototype.moveAllowed=function()
{this.buttonIsClicked=false;}
PortletPopupWindow.prototype.moveUp=function()
{if(this.index>0){var temp=null;var upIndex=0;var currentIndex=this.index;var started=this.index-1;for(var i=started;i>=0;i--){if(this.parent.portlets[this.position][i]!=null){temp=this.parent.portlets[this.position][i];upIndex=i;break;}}
if(temp!=null){temp.index=this.index;this.index=upIndex;this.parent.portlets[this.position][upIndex]=this;this.parent.portlets[this.position][currentIndex]=temp;temp.changePosition();temp.lastAction=null;if(!temp.minimized){temp.refresh(false);}
this.left=0;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
this.changePosition();}}}
PortletPopupWindow.prototype.moveDown=function()
{var temp=null;var downIndex=0;var currentIndex=this.index;var started=this.index+1;for(var i=started;i<this.parent.portlets[this.position].length;i++){if(this.parent.portlets[this.position][i]!=null){temp=this.parent.portlets[this.position][i];downIndex=i;break;}}
if(temp!=null){temp.index=this.index;this.index=downIndex;this.parent.portlets[this.position][downIndex]=this;this.parent.portlets[this.position][currentIndex]=temp;this.changePosition();this.left=0;for(var i=0;i<this.position;i++){this.left+=this.parent.widths[i]+this.parent.between;}
temp.changePosition();temp.lastAction=null;if(!temp.minimized){temp.refresh(false);}}}
PortletPopupWindow.prototype.moveLeft=function()
{}
PortletPopupWindow.prototype.moveRight=function()
{}
PortletPopupWindow.prototype.minimize=function()
{this.minimized=!this.minimized;if(this.minimized){this.state=Light._MINIMIZED_STATE;if(this.maximized){this.maximize(false);this.minimized=true;}
var empty="<br/>";this.window.container.innerHTML=empty;}else{this.state=Light._NORMAL_STATE;}
this.window.minimize(this);this.parent.rePositionPortlets(this);if(!this.minimized)
Light.executeRefresh(Light._PC_PREFIX+this.serverId);}
PortletPopupWindow.prototype.maximize=function(flag)
{this.windowMaximize(flag);this.refresh();}
PortletPopupWindow.prototype.windowMaximize=function(flag)
{this.maximized=!this.maximized;if(!this.maximized){this.state=Light._NORMAL_STATE;this.top=this.originalTop;this.width=this.originalWidth;this.left=this.originalLeft;Light.portal.container.style.zIndex=1;this.parent.showOtherPortlets();}else{this.state=Light._MAXIMIZED_STATE;this.left=Light.portal.layout.maxLeft;this.top=Light.portal.layout.maxTop;this.width=Light.portal.layout.maxWidth;Light.portal.container.style.zIndex=++Light.maxZIndex;Light.portal.body.style.zIndex=++Light.maxZIndex;Light.portal.footer.style.zIndex=++Light.maxZIndex;this.parent.hideOtherPortlets(this);}
this.window.maximize(this);this.parent.rePositionPortlets(this);}
PortletPopupWindow.prototype.close=function()
{this.window.close(this);this.parent.portlets[this.position][this.index]=null;if(this.maximized)
this.parent.showOtherPortlets();this.parent.rePositionPortlets(this);if(Light.portal.originalLeft!=null){Light.portal.layout.containerLeft=Light.portal.originalLeft;Light.portal.body.style.marginLeft=Light.portal.layout.containerLeft+Light.portal.layout.bodyLeft;Light.portal.originalLeft=null;}}
PortletPopupWindow.prototype.refreshButtons=function()
{this.window.refreshButtons(this);}
PortletPopupWindow.prototype.refreshWindow=function(){this.window.refreshWindow(this);}
PortletPopupWindow.prototype.refreshHeader=function(){this.window.refreshHeader(this);}
PortletPopupWindow.prototype.refreshWindowTransparent=function(){}
PortletPopupWindow.prototype.refreshTextColor=function(){}
PortletPopupWindow.prototype.getTop=function(){return this.window.top;}
PortletPopupWindow.prototype.getHeight=function(){return this.window.container.clientHeight;}
PortletPopupWindow.prototype.setContent=function(content){this.window.container.innerHTML=content;}
Light.Service=function(){log("initialize Light.Service");}
Light.Service.prototype.getPortalHeader=function(portal){return new LightPortalHeaderImpl().render(portal);}
Light.Service.prototype.getPortalMenu=function(portal){return new LightPortalMenuImpl().render(portal);}
Light.Service.prototype.getPortalFooter=function(portal){return new LightPortalFooterImpl().render(portal);}
Light.setCookie=function(name,value,expires,path,domain,secure)
{document.cookie=name+"="+escape(value)+
((expires)?"; expires="+expires.toGMTString():"")+
((path)?"; path="+path:"; path= /")+
((domain)?"; domain="+domain:"")+
((secure)?"; secure":"");}
Light.getCookie=function(name)
{var dc=document.cookie;if(dc==null)return null;var prefix=name+"=";var begin=dc.indexOf("; "+prefix);if(begin==-1)
{begin=dc.indexOf(prefix);if(begin!=0)return null;}
else
{begin+=2;}
var end=document.cookie.indexOf(";",begin);if(end==-1)
{end=dc.length;}
return unescape(dc.substring(begin+prefix.length,end));}
Light.deleteCookie=function(name,path,domain)
{if(Light.getCookie(name))
{document.cookie=name+"="+
((path)?"; path="+path:"; path= /")+
((domain)?"; domain="+domain:"")+"; expires=Thu, 01-Jan-70 00:00:01 GMT";}}
function log(message){}
function logDebug(message){if(!log.window_||log.window_.closed){var win=window.open("",null,"width=400,height=200,"+"scrollbars=yes,resizable=yes,status=no,"+"location=no,menubar=no,toolbar=no");if(!win)return;var doc=win.document;doc.write("<html><head><title>Debug Log</title></head>"+"<body></body></html>");doc.close();log.window_=win;}
var logLine=log.window_.document.createElement("div");logLine.appendChild(log.window_.document.createTextNode(message));log.window_.document.body.appendChild(logLine);logLine=null;}
String.prototype.isDigit=function(){if(this.length>1){return false;}
var string="1234567890";if(string.indexOf(this)!=-1){return true;}
return false;}
String.prototype.trim=function(){return this.replace(/^\s+|\s+$/g,"");}
String.prototype.startsWith=function(str){return this.substring(0,str.length)==str;}
String.prototype.endsWith=function(str){return(this.match(str+"$")==str)}
function isIE()
{return/msie/i.test(navigator.userAgent)&&!/opera/i.test(navigator.userAgent);}
function getX(oElement){var iReturnValue=0;if(!isIE()){while(oElement!=null){iReturnValue+=oElement.offsetLeft;oElement=oElement.offsetParent;}}else{var obj=oElement.getBoundingClientRect();iReturnValue=obj.left;}
return iReturnValue;}
function getY(oElement){var iReturnValue=0;if(!isIE()){while(oElement!=null){iReturnValue+=oElement.offsetTop;oElement=oElement.offsetParent;}}else{var obj=oElement.getBoundingClientRect();iReturnValue=obj.top;}
return iReturnValue;}
initMap=function(id){if(GBrowserIsCompatible()){var divMap=document.getElementById("map");divMap.style.width=280;divMap.style.height=300;var portlet=Light.getPortletById(id);Light.portal.tabs[portlet.tIndex].rePositionPortlets(portlet);map=new GMap2(document.getElementById("map"));map.addControl(new GSmallMapControl());map.addControl(new GMapTypeControl());map.setCenter(new GLatLng(37.4419,-122.1419),13);geocoder=new GClientGeocoder();}}
showAddress=function(address,id){initMap(id);if(geocoder){geocoder.getLatLng(address,function(point){if(!point){alert(address+" not found");}else{map.setCenter(point,13);var marker=new GMarker(point);map.addOverlay(marker);marker.openInfoWindowHtml(address);}});}}
initMaxMap=function(){if(GBrowserIsCompatible()){map=new GMap2(document.getElementById("map"));map.addControl(new GSmallMapControl());map.addControl(new GMapTypeControl());map.setCenter(new GLatLng(37.4419,-122.1419),13);geocoder=new GClientGeocoder();}}
showMaxAddress=function(address){initMaxMap();if(geocoder){geocoder.getLatLng(address,function(point){if(!point){alert(address+" not found");}else{map.setCenter(point,13);var marker=new GMarker(point);map.addOverlay(marker);marker.openInfoWindowHtml(address);}});}}
AIM={portletId:null,frame:function(c){var n='f'+Math.floor(Math.random()*99999);var d=document.createElement('DIV');d.innerHTML='<iframe style="display:none" src="about:blank" id="'+n+'" name="'+n+'" onload="AIM.loaded(\''+n+'\')"></iframe>';document.body.appendChild(d);var i=document.getElementById(n);if(c&&typeof(c.onComplete)=='function'){i.onComplete=c.onComplete;}
return n;},form:function(f,name){f.setAttribute('target',name);},submit:function(f,c,portletId){AIM.portletId=portletId;AIM.form(f,AIM.frame(c));if(c&&typeof(c.onStart)=='function'){return c.onStart(portletId);}else{return true;}},loaded:function(id){var i=document.getElementById(id);if(i.contentDocument){var d=i.contentDocument;}else if(i.contentWindow){var d=i.contentWindow.document;}else{var d=window.frames[id].document;}
if(d.location.href=="about:blank"){return;}
if(typeof(i.onComplete)=='function'){i.onComplete(AIM.portletId);}}}
function WindowAppearance()
{this.left=0;this.top=50;}
WindowAppearance.prototype.render=function(portlet){}
WindowAppearance.prototype.focus=function(portlet){}
WindowAppearance.prototype.show=function(portlet){}
WindowAppearance.prototype.hide=function(portlet){}
WindowAppearance.prototype.position=function(portlet){}
WindowAppearance.prototype.minimize=function(portlet){}
WindowAppearance.prototype.maximize=function(portlet){}
WindowAppearance.prototype.close=function(portlet){}
WindowAppearance.prototype.refreshWindow=function(portlet){}
WindowAppearance.prototype.refreshHeader=function(portlet){}
WindowAppearance.prototype.refreshButtons=function(portlet){}
WindowAppearance.prototype.setContent=function(content){this.container.innerHTML=content;}
WindowAppearance1.prototype=new WindowAppearance;WindowAppearance1.prototype.constructor=WindowAppearance1;function WindowAppearance1(){WindowAppearance.call(this);this.layout={titleRelativeLeft:10,titleRelativeTop:-8,buttonRelative:16,upRelativeRight:94,downRelativeRight:78,minRelativeRight:52,maxRelativeRight:36,closeRelativeRight:20,buttonRelativeTop:-6,rowBetween:12}}
WindowAppearance1.prototype.render=function(portlet)
{this.renderContainer(portlet);this.renderHeader(portlet);}
WindowAppearance1.prototype.renderContainer=function(portlet)
{this.container=this.createPortletContainer(portlet);this.window=this.container;var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);vdocument.appendChild(this.container);}
WindowAppearance1.prototype.renderHeader=function(portlet)
{this.header=this.createPortletHeader(portlet);var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);vdocument.appendChild(this.header);if(portlet.closeable){this.closeButton=this.createPortletCloseButton(portlet);vdocument.appendChild(this.closeButton);}
if(portlet.allowMaximized){this.maxButton=this.createPortletMaxButton(portlet);this.createPortletRestoreMaxButton(portlet);vdocument.appendChild(this.maxButton);}
if(portlet.allowMinimized){this.minButton=this.createPortletMinButton(portlet);this.createPortletRestoreMinButton(portlet);vdocument.appendChild(this.minButton);}
if(portlet.configMode){if(portlet.mode==Light._CONFIG_MODE){this.configButton=this.createPortletCancelConfigButton(portlet);this.createPortletConfigButton(portlet);}else{this.configButton=this.createPortletConfigButton(portlet);this.createPortletCancelConfigButton(portlet);}
vdocument.appendChild(this.configButton);}
if(portlet.helpMode){if(portlet.mode==Light._HELP_MODE){this.helpButton=this.createPortletCancelHelpButton(portlet);this.createPortletHelpButton(portlet);}else{this.helpButton=this.createPortletHelpButton(portlet);this.createPortletCancelHelpButton(portlet);}
vdocument.appendChild(this.helpButton);}
if(portlet.editMode){if(portlet.mode==Light._EDIT_MODE){this.editButton=this.createPortletCancelEditButton(portlet);this.createPortletEditButton(portlet);}else{this.editButton=this.createPortletEditButton(portlet);this.createPortletCancelEditButton(portlet);}
vdocument.appendChild(this.editButton);}
if(portlet.refreshMode){this.refreshButton=this.createPortletRefreshButton(portlet);vdocument.appendChild(this.refreshButton);}}
WindowAppearance1.prototype.focus=function(portlet)
{var index=++Light.maxZIndex;this.container.style.zIndex=index;Light.maxZIndex++;this.header.style.zIndex=++index;if(portlet.refreshMode){this.refreshButton.style.zIndex=index;}
if(portlet.editMode){this.editButton.style.zIndex=index;}
if(portlet.helpMode){this.helpButton.style.zIndex=index;}
if(portlet.configMode){this.configButton.style.zIndex=index;}
if(portlet.allowMinimized){this.minButton.style.zIndex=index;}
if(portlet.allowMaximized){this.maxButton.style.zIndex=index;}
if(portlet.closeable){this.closeButton.style.zIndex=index;}}
WindowAppearance1.prototype.show=function(portlet)
{this.container.style.visibility="visible";this.header.style.visibility="visible";if(portlet.refreshMode){this.refreshButton.style.visibility="visible";}
if(portlet.editMode){this.editButton.style.visibility="visible";}
if(portlet.helpMode){this.helpButton.style.visibility="visible";}
if(portlet.configMode){this.configButton.style.visibility="visible";}
if(portlet.allowMinimized){this.minButton.style.visibility="visible";}
if(portlet.allowMaximized){this.maxButton.style.visibility="visible";}
if(portlet.closeable){this.closeButton.style.visibility="visible";}}
WindowAppearance1.prototype.hide=function(portlet)
{this.container.style.visibility="hidden";this.header.style.visibility="hidden";if(portlet.refreshMode){this.refreshButton.style.visibility="hidden";}
if(portlet.editMode){this.editButton.style.visibility="hidden";}
if(portlet.helpMode){this.helpButton.style.visibility="hidden";}
if(portlet.configMode){this.configButton.style.visibility="hidden";}
if(portlet.allowMinimized){this.minButton.style.visibility="hidden";}
if(portlet.allowMaximized){this.maxButton.style.visibility="hidden";}
if(portlet.closeable){this.closeButton.style.visibility="hidden";}}
WindowAppearance1.prototype.position=function(portlet)
{this.container.style.width=portlet.width;if(document.all){this.container.style.posLeft=portlet.left;if(portlet.popup!=null)
portlet.top=portlet.top-this.layout.rowBetween;this.container.style.posTop=portlet.top;this.header.style.posLeft=portlet.left+this.layout.titleRelativeLeft;this.header.style.posTop=portlet.top+this.layout.titleRelativeTop;var RelativeRight=this.layout.minRelativeRight+this.layout.buttonRelative;if(portlet.configMode){this.configButton.style.posLeft=portlet.left+portlet.width-RelativeRight;this.configButton.style.posTop=portlet.top+this.layout.buttonRelativeTop;RelativeRight=RelativeRight+this.layout.buttonRelative;}
if(portlet.helpMode){this.helpButton.style.posLeft=portlet.left+portlet.width-RelativeRight;this.helpButton.style.posTop=portlet.top+this.layout.buttonRelativeTop;RelativeRight=RelativeRight+this.layout.buttonRelative;}
if(portlet.editMode){this.editButton.style.posLeft=portlet.left+portlet.width-RelativeRight;this.editButton.style.posTop=portlet.top+this.layout.buttonRelativeTop;RelativeRight=RelativeRight+this.layout.buttonRelative;}
if(portlet.refreshMode){this.refreshButton.style.posLeft=portlet.left+portlet.width-RelativeRight;this.refreshButton.style.posTop=portlet.top+this.layout.buttonRelativeTop;}
if(portlet.allowMinimized){this.minButton.style.posLeft=portlet.left+portlet.width-this.layout.minRelativeRight;this.minButton.style.posTop=portlet.top+this.layout.buttonRelativeTop;}
if(portlet.allowMaximized){this.maxButton.style.posLeft=portlet.left+portlet.width-this.layout.maxRelativeRight;this.maxButton.style.posTop=portlet.top+this.layout.buttonRelativeTop;}
if(portlet.closeable){this.closeButton.style.posLeft=portlet.left+portlet.width-this.layout.closeRelativeRight;this.closeButton.style.posTop=portlet.top+this.layout.buttonRelativeTop;}}
else{this.container.style.left=portlet.left;this.container.style.top=portlet.top;this.header.style.left=portlet.left+this.layout.titleRelativeLeft;this.header.style.top=portlet.top+this.layout.titleRelativeTop;var RelativeRight=this.layout.minRelativeRight+this.layout.buttonRelative;if(portlet.configMode){this.configButton.style.left=portlet.left+portlet.width-RelativeRight;this.configButton.style.top=portlet.top+this.layout.buttonRelativeTop;RelativeRight=RelativeRight+this.layout.buttonRelative;}
if(portlet.helpMode){this.helpButton.style.left=portlet.left+portlet.width-RelativeRight;this.helpButton.style.top=portlet.top+this.layout.buttonRelativeTop;RelativeRight=RelativeRight+this.layout.buttonRelative;}
if(portlet.editMode){this.editButton.style.left=portlet.left+portlet.width-RelativeRight;this.editButton.style.top=portlet.top+this.layout.buttonRelativeTop;RelativeRight=RelativeRight+this.layout.buttonRelative;}
if(portlet.refreshMode){this.refreshButton.style.left=portlet.left+portlet.width-RelativeRight;this.refreshButton.style.top=portlet.top+this.layout.buttonRelativeTop;}
if(portlet.allowMinimized){this.minButton.style.left=portlet.left+portlet.width-this.layout.minRelativeRight;this.minButton.style.top=portlet.top+this.layout.buttonRelativeTop;}
if(portlet.allowMaximized){this.maxButton.style.left=portlet.left+portlet.width-this.layout.maxRelativeRight;this.maxButton.style.top=portlet.top+this.layout.buttonRelativeTop;}
if(portlet.closeable){this.closeButton.style.left=portlet.left+portlet.width-this.layout.closeRelativeRight;this.closeButton.style.top=portlet.top+this.layout.buttonRelativeTop;}}
this.focus(portlet);}
WindowAppearance1.prototype.minimize=function(portlet)
{var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);if(portlet.minimized){vdocument.removeChild(this.minButton);this.minButton=this.createPortletRestoreMinButton(portlet);vdocument.appendChild(this.minButton);}else{vdocument.removeChild(this.minButton);this.minButton=this.createPortletMinButton(portlet);vdocument.appendChild(this.minButton);}
this.position(portlet);}
WindowAppearance1.prototype.maximize=function(portlet)
{var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);if(!portlet.maximized){vdocument.removeChild(this.maxButton);this.maxButton=this.createPortletMaxButton(portlet);vdocument.appendChild(this.maxButton);}else{vdocument.removeChild(this.maxButton);this.maxButton=this.createPortletRestoreMaxButton(portlet);vdocument.appendChild(this.maxButton);}
this.position(portlet);}
WindowAppearance1.prototype.close=function(portlet)
{var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);vdocument.removeChild(this.container);vdocument.removeChild(this.header);if(portlet.refreshMode){vdocument.removeChild(this.refreshButton);}
if(portlet.editMode){vdocument.removeChild(this.editButton);}
if(portlet.helpMode){vdocument.removeChild(this.helpButton);}
if(portlet.configMode){vdocument.removeChild(this.configButton);}
if(portlet.allowMinimized){vdocument.removeChild(this.minButton);}
if(portlet.allowMaximized){vdocument.removeChild(this.maxButton);}
vdocument.removeChild(this.closeButton);}
WindowAppearance1.prototype.refreshWindow=function(portlet){var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);vdocument.removeChild(this.container);this.container=this.createPortletContainer(portlet);vdocument.appendChild(this.container);this.refreshHeader(portlet);this.position(portlet);}
WindowAppearance1.prototype.refreshHeader=function(portlet){var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);vdocument.removeChild(this.header);this.header=this.createPortletHeader(portlet);if(document.all){this.header.style.posLeft=portlet.left+this.layout.titleRelativeLeft;this.header.style.posTop=portlet.top+this.layout.titleRelativeTop;}else{this.header.style.left=portlet.left+this.layout.titleRelativeLeft;this.header.style.top=portlet.top+this.layout.titleRelativeTop;}
vdocument.appendChild(this.header);}
WindowAppearance1.prototype.refreshButtons=function(portlet)
{var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);if(portlet.editMode){vdocument.removeChild(this.editButton);if(portlet.mode==Light._EDIT_MODE){this.editButton=this.createPortletCancelEditButton(portlet);}else{this.editButton=this.createPortletEditButton(portlet);}
this.editButton.style.visibility="hidden";}
if(portlet.helpMode){vdocument.removeChild(this.helpButton);if(portlet.mode==Light._HELP_MODE){this.helpButton=this.createPortletCancelHelpButton(portlet);}else{this.helpButton=this.createPortletHelpButton(portlet);}
this.helpButton.style.visibility="hidden";}
if(portlet.configMode){vdocument.removeChild(this.configButton);if(portlet.mode==Light._CONFIG_MODE){this.configButton=this.createPortletCancelConfigButton(portlet);}else{this.configButton=this.createPortletConfigButton(portlet);}
this.configButton.style.visibility="hidden";}
if(portlet.editMode)vdocument.appendChild(this.editButton);if(portlet.helpMode)vdocument.appendChild(this.helpButton);if(portlet.configMode)vdocument.appendChild(this.configButton);this.position(portlet);if(portlet.editMode)this.editButton.style.visibility="visible";if(portlet.helpMode)this.helpButton.style.visibility="visible";if(portlet.configMode)this.configButton.style.visibility="visible";}
WindowAppearance1.prototype.createPortletContainer=function(portlet)
{var vContainer=document.createElement('div');vContainer.id=Light._PC_PREFIX+portlet.serverId;vContainer.style.position="absolute";if(portlet.className!=null)
vContainer.className=portlet.className;else
vContainer.className="portlet";vContainer.style.width=portlet.width;vContainer.style.zIndex=++Light.maxZIndex;if(portlet.contentBgColor.length>0)
vContainer.style.backgroundColor=portlet.contentBgColor;else if(Light.portal.portletWindowTransparent==false&&portlet.transparent==false)
vContainer.style.backgroundColor="#ffffff";return vContainer;}
WindowAppearance1.prototype.createPortletHeader=function(portlet){var vHeader=document.createElement('div');vHeader.style.position="absolute";vHeader.className="portlet-header";if(Light.getCurrentTab().tabIsMoveable){vHeader.onmousedown=function(e){portlet.moveBegin(e);}
vHeader.style.cursor="move";}
var inner="";if(portlet.icon.length>0){if(portlet.icon.substring(0,4)=="http")
inner="<img src='"+portlet.icon+"' style='border: 0px;' height='16' width='16'/>&nbsp;";else
inner="<img src='"+Light.portal.contextPath+portlet.icon+"' style='border: 0px;' height='16' width='16'/>&nbsp;";}
if(portlet.url.length>0){inner=inner+"<a href='"+portlet.url+"' target='_blank'>";if(portlet.barFontColor.length>0)
inner=inner+"<font color='"+portlet.barFontColor+"'>";inner=inner+portlet.title;if(portlet.barFontColor.length>0)
inner=inner+"</font>";inner=inner+"</a>";}else
inner=inner+"<label>"+portlet.title+"</label>";vHeader.innerHTML=inner;vHeader.style.zIndex=Light.maxZIndex++;if(portlet.barBgColor.length>0){vHeader.style.backgroundImage="none";vHeader.style.backgroundColor=portlet.barBgColor;}
if(portlet.barFontColor.length>0)
vHeader.style.color=portlet.barFontColor;return vHeader;}
WindowAppearance1.prototype.createPortletRefreshButton=function(portlet)
{var strIco="<span title='"+$('_REFRESH_PORTLET').title+"'><img src='"+Light.getThemePath()+"/images/refresh_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var varA=document.createElement('a');varA.innerHTML=strIco;varA.href="javascript:void(0)";varA.onclick=function(){portlet.refresh();}
vButton.appendChild(varA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletEditButton=function(portlet)
{var strIco="<span title='"+$('_EDIT_MODE').title+"'><img src='"+Light.getThemePath()+"/images/edit_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var varA=document.createElement('a');varA.innerHTML=strIco;varA.href="javascript:void(0)";varA.onclick=function(){portlet.edit();}
vButton.appendChild(varA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletCancelEditButton=function(portlet)
{var strIco="<span title='"+$('_VIEW_MODE').title+"'><img src='"+Light.getThemePath()+"/images/leave_edit_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var varA=document.createElement('a');varA.innerHTML=strIco;varA.href="javascript:void(0)";varA.onclick=function(){portlet.cancelEdit();}
vButton.appendChild(varA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletHelpButton=function(portlet)
{var strIco="<span title='"+$('_HELP_MODE').title+"'><img src='"+Light.getThemePath()+"/images/help_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var varA=document.createElement('a');varA.innerHTML=strIco;varA.href="javascript:void(0)";varA.onclick=function(){portlet.help();}
vButton.appendChild(varA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletCancelHelpButton=function(portlet)
{var strIco="<span title='"+$('_VIEW_MODE').title+"'><img src='"+Light.getThemePath()+"/images/leave_help_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var varA=document.createElement('a');varA.innerHTML=strIco;varA.href="javascript:void(0)";varA.onclick=function(){portlet.cancelHelp();}
vButton.appendChild(varA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletConfigButton=function(portlet)
{var strIco="<span title='"+$('_CONFIG_MODE').title+"'><img src='"+Light.getThemePath()+"/images/config_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var varA=document.createElement('a');varA.innerHTML=strIco;varA.href="javascript:void(0)";varA.onclick=function(){portlet.config();}
vButton.appendChild(varA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletCancelConfigButton=function(portlet)
{var strIco="<span title='"+$('_VIEW_MODE').title+"'><img src='"+Light.getThemePath()+"/images/leave_config_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var varA=document.createElement('a');varA.innerHTML=strIco;varA.href="javascript:void(0)";varA.onclick=function(){portlet.cancelConfig();}
vButton.appendChild(varA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletMinButton=function(portlet)
{var strIcoMin="<span title='"+$('_MINIMIZED').title+"'><img src='"+Light.getThemePath()+"/images/min_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var minA=document.createElement('a');minA.innerHTML=strIcoMin;minA.href="javascript:void(0)";minA.onclick=function(){portlet.minimize();}
vButton.appendChild(minA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletRestoreMinButton=function(portlet)
{var strIcoMin="<span title='"+$('_RESTORE_MINIMIZED').title+"'><img src='"+Light.getThemePath()+"/images/restore_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var minA=document.createElement('a');minA.innerHTML=strIcoMin;minA.href="javascript:void(0)";minA.onclick=function(){portlet.minimize();}
vButton.appendChild(minA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletMaxButton=function(portlet)
{var strIcoMax="<span title='"+$('_MAXIMIZED').title+"'><img src='"+Light.getThemePath()+"/images/max_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var maxA=document.createElement('a');maxA.innerHTML=strIcoMax;maxA.href="javascript:void(0)";maxA.onclick=function(){portlet.maximize();}
vButton.appendChild(maxA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletRestoreMaxButton=function(portlet)
{var strIcoMax="<span title='"+$('_RESTORE_MAXIMIZED').title+"'><img src='"+Light.getThemePath()+"/images/restore_on.gif' style='border: 0px;' height='14' width='14' /></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var maxA=document.createElement('a');maxA.innerHTML=strIcoMax;maxA.href="javascript:void(0)";maxA.onclick=function(){portlet.maximize();}
vButton.appendChild(maxA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.createPortletCloseButton=function(portlet)
{var strIcoCls="<span title='"+$('_CLOSE').title+"'><img src='"+Light.getThemePath()+"/images/close_on.gif' style='border: 0px;' height='14' width='14'/></span>";var vButton=document.createElement('div');vButton.className="portlet-header-button";var clsA=document.createElement('a');clsA.innerHTML=strIcoCls;clsA.href="javascript:void(0)";clsA.onclick=function(){portlet.close();}
vButton.appendChild(clsA);vButton.style.zIndex=Light.maxZIndex;return vButton;}
WindowAppearance1.prototype.setContent=function(content){this.container.innerHTML="<br/>"+content;}
WindowAppearance11.prototype=new WindowAppearance1;WindowAppearance11.prototype.constructor=WindowAppearance11;function WindowAppearance11(){WindowAppearance1.call(this);}
WindowAppearance11.prototype.createPortletContainer=function(portlet){var vContainer=document.createElement('div');vContainer.id=Light._PC_PREFIX+portlet.serverId+"_container";vContainer.style.position="absolute";vContainer.className="portlet";vContainer.style.width=portlet.width;vContainer.style.zIndex=this.zIndex;if(portlet.contentBgColor.length>0)
vContainer.style.backgroundColor=portlet.contentBgColor;var vContent=document.createElement('div');vContent.id=Light._PC_PREFIX+portlet.serverId;vContainer.container=vContent;vContainer.appendChild(vContent);var vInput=document.createElement('div');vInput.innerHTML="<form name='form_"+vContent.id+"'>"
+"<table border='0' cellpadding='0' cellspacing='0'>"
+"<tr><br/><br/><br/>"
+"<td class='portlet-table-td-left'>"
+"<input type='text' name='chat' class='portlet-form-input-field' size='80' onkeypress=\" return keyDownChat(event,'"+vContent.id+"');\" />"
+"<input type='button' name='action' value='"+$('_BUTTON_SEND').title+"' class='portlet-form-button' onclick=\" sendChatMessage('"+vContent.id+"');\"/>"
+"</td></tr></table></form>";vContainer.appendChild(vInput);return vContainer;}
WindowAppearance2.prototype=new WindowAppearance;WindowAppearance2.prototype.constructor=WindowAppearance2;function WindowAppearance2()
{this.layout={rowBetween:10}}
WindowAppearance2.prototype.render=function(portlet)
{this.window=this.createPortletWindow(portlet);this.container=this.createPortletContainer(portlet);this.header=this.createPortletHeader(portlet,this);this.headerButton=this.createPortletHeaderButton(portlet);if(this.headerButton!=null)
this.header.appendChild(this.headerButton);this.window.appendChild(this.header);this.window.appendChild(this.container);var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);if(typeof portlet.popup!="undefined"&&!portlet.popup)
if(typeof portlet.location!="undefined"&&portlet.location==1)
Light.portal.container.appendChild(this.window);else
Light.portal.container.insertBefore(this.window,Light.portal.body);else
vdocument.appendChild(this.window);}
WindowAppearance2.prototype.focus=function(portlet)
{var index=++Light.maxZIndex;this.window.style.zIndex=index;}
WindowAppearance2.prototype.show=function(portlet)
{this.window.style.visibility="visible";}
WindowAppearance2.prototype.hide=function(portlet)
{this.window.style.visibility="hidden";}
WindowAppearance2.prototype.position=function(portlet)
{this.window.style.width=portlet.width;this.header.style.width=portlet.width;this.container.style.width=portlet.width;var top=portlet.top;if(typeof portlet.popup!="undefined")
if(!portlet.popup){if(typeof portlet.location!="undefined"&&portlet.location==1)
top=portlet.top+20;}
if(document.all){this.window.style.posLeft=portlet.left;this.window.style.posTop=top;}
else{this.window.style.left=portlet.left;this.window.style.top=top;}
this.focus(portlet);}
WindowAppearance2.prototype.minimize=function(portlet)
{this.window.removeChild(this.header);this.header=this.createPortletHeader(portlet,this);this.headerButton=this.createPortletHeaderButton(portlet);this.header.appendChild(this.headerButton);this.window.insertBefore(this.header,this.container);this.position(portlet);}
WindowAppearance2.prototype.maximize=function(portlet)
{this.window.removeChild(this.header);this.header=this.createPortletHeader(portlet,this);this.headerButton=this.createPortletHeaderButton(portlet);this.header.appendChild(this.headerButton);this.window.insertBefore(this.header,this.container);this.position(portlet);}
WindowAppearance2.prototype.close=function(portlet)
{var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);this.window.removeChild(this.header);this.window.removeChild(this.container);if(typeof portlet.popup!="undefined"&&!portlet.popup)
Light.portal.container.removeChild(this.window);else
vdocument.removeChild(this.window);}
WindowAppearance2.prototype.refreshWindow=function(portlet)
{this.window.removeChild(this.header);this.window.removeChild(this.container);this.header=this.createPortletHeader(portlet,this);this.headerButton=this.createPortletHeaderButton(portlet);this.container=this.createPortletContainer(portlet);this.header.appendChild(this.headerButton);this.window.appendChild(this.header);this.window.appendChild(this.container);this.position(portlet);}
WindowAppearance2.prototype.refreshHeader=function(portlet)
{this.window.removeChild(this.header);this.header=this.createPortletHeader(portlet,this);this.headerButton=this.createPortletHeaderButton(portlet);this.header.appendChild(this.headerButton);this.window.insertBefore(this.header,this.container);}
WindowAppearance2.prototype.refreshButtons=function(portlet)
{this.window.removeChild(this.header);this.header=this.createPortletHeader(portlet,this);this.headerButton=this.createPortletHeaderButton(portlet);this.header.appendChild(this.headerButton);this.window.insertBefore(this.header,this.container);this.position(portlet);}
WindowAppearance2.prototype.createPortletWindow=function(portlet)
{var vWindow=document.createElement('div');vWindow.id="portlet_"+portlet.serverId;if(typeof portlet.popup!="undefined"&&!portlet.popup&&typeof portlet.location!="undefined"&&portlet.location!=1)
vWindow.style.margin="0px "+Light.portal.layout.containerLeft+"px";else
vWindow.style.position="absolute";vWindow.className="portlet2";vWindow.style.zIndex=++Light.maxZIndex;if(portlet.contentBgColor.length>0)
vWindow.style.backgroundColor=portlet.contentBgColor;else if(Light.portal.portletWindowTransparent==false&&portlet.transparent==false)
vWindow.style.backgroundColor="#ffffff";return vWindow;}
WindowAppearance2.prototype.createPortletHeader=function(portlet,window)
{var vHeader=document.createElement('div');if(!portlet.minimized){vHeader.className="portlet2-header";if(portlet.barBgColor.length>0){vHeader.style.backgroundImage="none";vHeader.style.backgroundColor=portlet.barBgColor;}}else{vHeader.className="portlet2-header-min";}
if(Light.currentTab.tabIsMoveable&&portlet.allowMove){vHeader.onmousedown=function(e){portlet.focus();portlet.moveBegin(e);}
vHeader.style.cursor="move";}else{vHeader.onmousedown=function(e){portlet.focus();}}
vHeader.onmouseover=function(e){window.headerButton.style.visibility="visible";}
vHeader.onmouseout=function(e){window.headerButton.style.visibility="hidden";}
var vTitle=document.createElement('span');var inner="";if(portlet.icon.length>0){if(portlet.icon.substring(0,4)=="http")
inner="<img src='"+portlet.icon+"' style='border: 0px;' height='16' width='16' />&nbsp;";else
inner="<img src='"+Light.portal.contextPath+portlet.icon+"' style='border: 0px;' height='16' width='16'/>&nbsp;";}
if(portlet.url.length>0){inner=inner+"<a href='"+portlet.url+"' target='_blank'>";if(portlet.barFontColor.length>0)
inner=inner+"<font color='"+portlet.barFontColor+"'>";inner=inner+portlet.title;if(portlet.barFontColor.length>0)
inner=inner+"</font>";inner=inner+"</a>";}else
inner=inner+"<label>"+portlet.title+"</label>";vTitle.innerHTML=inner;vTitle.className="portlet2-header-title";if(portlet.barFontColor.length>0)
vTitle.style.color=portlet.barFontColor;vHeader.appendChild(vTitle);return vHeader;}
WindowAppearance2.prototype.createPortletHeaderButton=function(portlet)
{var strIcoRefresh=" <span title='"+$('_REFRESH_PORTLET').title+"'><img id='pngIcoUp' src='"+Light.getThemePath()+"/images/refresh_on.gif' "
+" style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var strIcoEdit=" <span title='"+$('_EDIT_MODE').title+"'><img id='pngIcoUp' src='"+Light.getThemePath()+"/images/edit_on.gif' "
+" style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14' BORDER='0'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var strIcoCancelEdit=" <span title='"+$('_VIEW_MODE').title+"'><img id='pngIcoUp' src='"+Light.getThemePath()+"/images/leave_edit_on.gif' "
+" style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var strIcoHelp=" <span title='"+$('_HELP_MODE').title+"'><img id='pngIcoUp' src='"+Light.getThemePath()+"/images/help_on.gif' "
+" style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var strIcoCancelHelp=" <img id='pngIcoUp' src='"+Light.getThemePath()+"/images/leave_help_on.gif' "
+" style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/>";var strIcoConfig=" <span title='"+$('_CONFIG_MODE').title+"'><img id='pngIcoUp' src='"+Light.getThemePath()+"/images/config_on.gif' "
+" style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var strIcoCancelConfig=" <span title='"+$('_VIEW_MODE').title+"'><img id='pngIcoUp' src='"+Light.getThemePath()+"/images/leave_config_on.gif' "
+" style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var strIcoMin=" <span title='"+$('_MINIMIZED').title+"'><img id='pngIcoMin' src='"+Light.getThemePath()+"/images/min_on.gif' "
+" style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var strIcoRestore=" <span title='"+$('_RESTORE').title+"'><img id='pngIcoMax' src='"+Light.getThemePath()+"/images/restore_on.gif' "
+"style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var strIcoMax=" <span title='"+$('_MAXIMIZED').title+"'><img id='pngIcoMax' src='"+Light.getThemePath()+"/images/max_on.gif' "
+"style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var strIcoCls=" <span title='"+$('_CLOSE').title+"'><img id='pngIcoClose' src='"+Light.getThemePath()+"/images/close_on.gif' "
+"style='border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50);' height='14' width='14'"
+" onmouseover='this.style.MozOpacity=1;this.filters.alpha.opacity=100'"
+" onmouseout='this.style.MozOpacity=0.5;this.filters.alpha.opacity=50'/></span>";var vButton=document.createElement('div');vButton.className="portlet2-header-button";vButton.style.visibility="hidden";if(document.all){if(portlet.refreshMode){var refresh=document.createElement('a');refresh.innerHTML=strIcoRefresh;refresh.href="javascript:void(0)";refresh.onclick=function(){portlet.refresh();portlet.moveAllowed();}
refresh.onmousedown=function(){portlet.moveCancel();}
vButton.appendChild(refresh);}
if(portlet.editMode){var edit=document.createElement('a');edit.href="javascript:void(0)";if(portlet.mode==Light._EDIT_MODE){edit.innerHTML=strIcoCancelEdit;edit.onclick=function(){portlet.cancelEdit();portlet.moveAllowed();}}else{edit.innerHTML=strIcoEdit;edit.onclick=function(){portlet.edit();portlet.moveAllowed();}}
edit.onmousedown=function(){portlet.moveCancel();}
vButton.appendChild(edit);}
if(portlet.helpMode){var help=document.createElement('a');help.href="javascript:void(0)";if(portlet.mode==Light._HELP_MODE){help.innerHTML=strIcoCancelHelp;help.onclick=function(){portlet.cancelHelp();portlet.moveAllowed();}}else{help.innerHTML=strIcoHelp;help.onclick=function(){portlet.help();portlet.moveAllowed();}}
help.onmousedown=function(){portlet.moveCancel();}
vButton.appendChild(help);}
if(portlet.configMode){var config=document.createElement('a');config.href="javascript:void(0)";if(portlet.mode==Light._CONFIG_MODE){config.innerHTML=strIcoCancelConfig;config.onclick=function(){portlet.cancelConfig();portlet.moveAllowed();}}else{config.innerHTML=strIcoConfig;config.onclick=function(){portlet.config();portlet.moveAllowed();}}
config.onmousedown=function(){portlet.moveCancel();}
vButton.appendChild(config);}
if(portlet.allowMinimized){var minA=document.createElement('a');if(portlet.minimized){minA.innerHTML=strIcoRestore;}else{minA.innerHTML=strIcoMin;}
minA.href="javascript:void(0)";minA.onclick=function(){portlet.minimize();portlet.moveAllowed();}
minA.onmousedown=function(){portlet.moveCancel();}
vButton.appendChild(minA);}
if(portlet.allowMaximized){var maxA=document.createElement('a');if(portlet.maximized){maxA.innerHTML=strIcoRestore;}else{maxA.innerHTML=strIcoMax;}
maxA.href="javascript:void(0)";maxA.onclick=function(){portlet.maximize();portlet.moveAllowed();}
maxA.onmousedown=function(){portlet.moveCancel();}
vButton.appendChild(maxA);}
if(portlet.closeable){var clsA=document.createElement('a');clsA.innerHTML=strIcoCls;clsA.href="javascript:void(0)";clsA.onclick=function(){portlet.close();portlet.moveAllowed();}
clsA.onmousedown=function(){portlet.moveCancel();}
vButton.appendChild(clsA);}}else{if(portlet.refreshMode){var refresh=document.createElement('input');refresh.type='image';refresh.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');refresh.src=Light.getThemePath()+"/images/refresh_on.gif";refresh.onclick=function(){portlet.refresh();portlet.moveAllowed();}
refresh.onmousedown=function(){portlet.moveCancel();}
refresh.onmouseover=function(){this.setAttribute('style','border: 0px;-MozOpacity:1;filters.alpha(opacity=100); height:14; width:14;');}
refresh.onmouseout=function(){this.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');}
vButton.appendChild(refresh);}
if(portlet.editMode){var edit=document.createElement('input');edit.type='image';edit.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');if(portlet.mode==Light._EDIT_MODE){edit.src=Light.getThemePath()+"/images/leave_edit_on.gif";edit.onclick=function(){portlet.cancelEdit();portlet.moveAllowed();}}else{edit.src=Light.getThemePath()+"/images/edit_on.gif";;edit.onclick=function(){portlet.edit();portlet.moveAllowed();}}
edit.onmousedown=function(){portlet.moveCancel();}
edit.onmouseover=function(){this.setAttribute('style','border: 0px;-MozOpacity:1;filters.alpha(opacity=100); height:14; width:14;');}
edit.onmouseout=function(){this.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');}
vButton.appendChild(edit);}
if(portlet.helpMode){var help=document.createElement('input');help.type='image';help.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');if(portlet.mode==Light._HELP_MODE){help.src=Light.getThemePath()+"/images/leave_help_on.gif";help.onclick=function(){portlet.cancelHelp();portlet.moveAllowed();}}else{help.src=Light.getThemePath()+"/images/help_on.gif";help.onclick=function(){portlet.help();portlet.moveAllowed();}}
help.onmousedown=function(){portlet.moveCancel();}
help.onmouseover=function(){this.setAttribute('style','border: 0px;-MozOpacity:1;filters.alpha(opacity=100); height:14; width:14;');}
help.onmouseout=function(){this.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');}
vButton.appendChild(help);}
if(portlet.configMode){var config=document.createElement('input');config.type='image';config.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');if(portlet.mode==Light._CONFIG_MODE){config.src=Light.getThemePath()+"/images/leave_config_on.gif";config.onclick=function(){portlet.cancelConfig();portlet.moveAllowed();}}else{config.src=Light.getThemePath()+"/images/config_on.gif";config.onclick=function(){portlet.config();portlet.moveAllowed();}}
config.onmousedown=function(){portlet.moveCancel();}
config.onmouseover=function(){this.setAttribute('style','border: 0px;-MozOpacity:1;filters.alpha(opacity=100); height:14; width:14;');}
config.onmouseout=function(){this.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');}
vButton.appendChild(config);}
if(portlet.allowMinimized){var minA=document.createElement('input');minA.type='image';minA.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');if(portlet.minimized){minA.src=Light.getThemePath()+"/images/restore_on.gif";}else{minA.src=Light.getThemePath()+"/images/min_on.gif";}
minA.onclick=function(){portlet.minimize();portlet.moveAllowed();}
minA.onmousedown=function(){portlet.moveCancel();}
minA.onmouseover=function(){this.setAttribute('style','border: 0px;-MozOpacity:1;filters.alpha(opacity=100); height:14; width:14;');}
minA.onmouseout=function(){this.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');}
vButton.appendChild(minA);}
if(portlet.allowMaximized){var maxA=document.createElement('input');maxA.type='image';maxA.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');if(portlet.maximized){maxA.src=Light.getThemePath()+"/images/restore_on.gif";}else{maxA.src=Light.getThemePath()+"/images/max_on.gif";}
maxA.onclick=function(){portlet.maximize();portlet.moveAllowed();}
maxA.onmousedown=function(){portlet.moveCancel();}
maxA.onmouseover=function(){this.setAttribute('style','border: 0px;-MozOpacity:1;filters.alpha(opacity=100); height:14; width:14;');}
maxA.onmouseout=function(){this.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');}
vButton.appendChild(maxA);}
if(portlet.closeable){var clsA=document.createElement('input');clsA.type='image';clsA.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');clsA.src=Light.getThemePath()+"/images/close_on.gif";clsA.onclick=function(){portlet.close();portlet.moveAllowed();}
clsA.onmousedown=function(){portlet.moveCancel();}
clsA.onmouseover=function(){this.setAttribute('style','border: 0px;-MozOpacity:1;filters.alpha(opacity=100); height:14; width:14;');}
clsA.onmouseout=function(){this.setAttribute('style','border: 0px;-moz-opacity:0.5;filter:alpha(opacity=50); height:14; width:14;');}
vButton.appendChild(clsA);}}
return vButton;}
WindowAppearance2.prototype.createPortletContainer=function(portlet)
{var vContainer=document.createElement('div');vContainer.id=Light._PC_PREFIX+portlet.serverId;vContainer.onmousedown=function(){portlet.focus();}
if(portlet.contentBgColor.length>0)
vContainer.style.backgroundColor=portlet.contentBgColor;else if(Light.portal.portletWindowTransparent==false&&portlet.transparent==false)
vContainer.style.backgroundColor="#ffffff";return vContainer;}
WindowAppearance3.prototype=new WindowAppearance;WindowAppearance3.prototype.constructor=WindowAppearance3;function WindowAppearance3()
{this.layout={rowBetween:10}}
WindowAppearance3.prototype.render=function(portlet)
{this.window=this.createPortletWindow(portlet);this.container=this.createPortletContainer(portlet);var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);this.window.appendChild(this.container);vdocument.appendChild(this.window);}
WindowAppearance3.prototype.focus=function(portlet)
{var index=++Light.maxZIndex;this.window.style.zIndex=index;}
WindowAppearance3.prototype.show=function(portlet)
{this.window.style.visibility="visible";}
WindowAppearance3.prototype.hide=function(portlet)
{this.window.style.visibility="hidden";}
WindowAppearance3.prototype.position=function(portlet)
{this.window.style.width=portlet.width;this.container.style.width=portlet.width;var top=portlet.top;if(portlet.popup!=null)
top=portlet.top-this.layout.rowBetween;if(document.all){this.window.style.posLeft=portlet.left;this.window.style.posTop=top;}
else{this.window.style.left=portlet.left;this.window.style.top=top;}
this.focus(portlet);}
WindowAppearance3.prototype.minimize=function(portlet)
{}
WindowAppearance3.prototype.maximize=function(portlet)
{this.position(portlet);}
WindowAppearance3.prototype.close=function(portlet)
{var vdocument=document.getElementById('panel_'+portlet.parent.tabServerId);this.window.removeChild(this.container);vdocument.removeChild(this.window);}
WindowAppearance3.prototype.refreshWindow=function(portlet)
{this.window.removeChild(this.container);this.container=this.createPortletContainer(portlet);this.window.appendChild(this.container);this.position(portlet);}
WindowAppearance3.prototype.refreshHeader=function(portlet)
{}
WindowAppearance3.prototype.refreshButtons=function(portlet)
{}
WindowAppearance3.prototype.createPortletWindow=function(portlet)
{var vWindow=document.createElement('div');vWindow.id="portlet_"+portlet.serverId;vWindow.style.position="absolute";vWindow.className="portlet2";if(Light.portal.portletWindowTransparent==false&&portlet.transparent==false)
vWindow.style.backgroundColor="#ffffff";else
vWindow.style.backgroundColor="";vWindow.style.zIndex=++Light.maxZIndex;return vWindow;}
WindowAppearance3.prototype.createPortletHeader=function(portlet,window)
{}
WindowAppearance3.prototype.createPortletHeaderButton=function(portlet)
{}
WindowAppearance3.prototype.createPortletContainer=function(portlet)
{var vContainer=document.createElement('div');vContainer.id=Light._PC_PREFIX+portlet.serverId;vContainer.onmousedown=function(){portlet.focus();}
if(portlet.contentBgColor.length>0)
vContainer.style.backgroundColor=portlet.contentBgColor;else if(Light.portal.portletWindowTransparent==false&&portlet.transparent==false)
vContainer.style.backgroundColor="#ffffff";return vContainer;}
WindowAppearance4.prototype=new WindowAppearance2;WindowAppearance4.prototype.constructor=WindowAppearance4;function WindowAppearance4(){WindowAppearance2.call(this);}
WindowAppearance4.prototype.createPortletHeaderButton=function(portlet)
{return document.createElement('div');}
WindowAppearance5.prototype=new WindowAppearance3;WindowAppearance5.prototype.constructor=WindowAppearance5;function WindowAppearance5(){WindowAppearance3.call(this);}
WindowAppearance5.prototype.createPortletWindow=function(portlet)
{var vWindow=document.createElement('div');vWindow.id="portlet_"+portlet.serverId;vWindow.style.position="absolute";vWindow.className="";if(Light.portal.portletWindowTransparent==false&&portlet.transparent==false)
vWindow.style.backgroundColor="#ffffff";else
vWindow.style.backgroundColor="";vWindow.style.zIndex=++Light.maxZIndex;return vWindow;}