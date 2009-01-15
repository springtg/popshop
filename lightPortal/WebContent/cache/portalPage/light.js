
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