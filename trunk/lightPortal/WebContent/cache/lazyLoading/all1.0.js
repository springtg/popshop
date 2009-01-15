
Light.portalSearch=function(){var keyword=document.getElementById("portalSearch").value;var portlet=new PortletPopupWindow(11,0,400,$('_MENU_SEARCH').title,"","","globalSearchPortlet",Light.portal.contextPath+"/globalSearchPortlet.lp",true,false,false,false,false,false,false,0,false,'','','#ffffff','');var id="portlet_"+portlet.tIndex+"_"+portlet.position+"_"+portlet.index;var param='action=find';if(keyword.length>0)param+=';keyword='+keyword;Light.executeProcess(id,"view","maximized",param,null);}
Light.forumSearch=function(){var keyword=document.getElementById("forumSearch").value;var portlet=new PortletPopupWindow(11,0,400,$('_MENU_SEARCH').title,"","","globalSearchPortlet",Light.portal.contextPath+"/globalSearchPortlet.lp",true,false,false,false,false,false,false,0,false,'','','#ffffff','');var id="portlet_"+portlet.tIndex+"_"+portlet.position+"_"+portlet.index;var param='action=find;type=org.light.portlets.forum.ForumPost';if(keyword.length>0)param+=';keyword='+keyword;Light.executeProcess(id,"view","maximized",param,null);}
Light.blogSearch=function(kid){var keyword=document.getElementById(kid).value;var portlet=new PortletPopupWindow(11,0,400,$('_MENU_SEARCH').title,"","","globalSearchPortlet",Light.portal.contextPath+"/globalSearchPortlet.lp",true,false,false,false,false,false,false,0,false,'','','#ffffff','');var id="portlet_"+portlet.tIndex+"_"+portlet.position+"_"+portlet.index;var param='action=find;type=org.light.portlets.blog.Blog';if(keyword.length>0)param+=';keyword='+keyword;Light.executeProcess(id,"view","maximized",param,null);}
Light.securityCheck=function(){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.login();return false;}else
return true;}
Light.loginPortal=function(id){var userId=document.forms['form_'+id]['email'].value;var password=document.forms['form_'+id]['password'].value;if(userId==null||userId.length<=0||password==null||password.length<=0){alert("please input User ID and password.");return;}
Light.userId=userId;var date=new Date();var timestamp=Date.parse(date);date.setFullYear(date.getFullYear()+1);Light.setCookie(Light._REMEMBERED_USER_ID,userId,date);if(document.forms['form_'+id]['rememberMe'].checked){Light.setCookie(Light._REMEMBERED_USER_PASSWORD,password,date);}
Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);var portlet=Light.getPortletById(id);var params="portletId="+portlet.serverId
+"&tabId="+Light.portal.tabs[portlet.tIndex].tabServerId
+"&userId="+escape(encodeURIComponent(userId))
+"&password="+escape(encodeURIComponent(password));var opt={method:'post',parameters:params,onSuccess:function(t){Light.LoginPortalHandler(t);},onFailure:function(t){alert('Error '+t.status+' -- '+t.statusText);}}
Light.ajax.sendRequest(Light.portal.contextPath+Light.loginRequest,{parameters:params,onSuccess:Light.loginPortalHandler});}
Light.loginPortalHandler=function(t){var userId=t.responseText;if(userId=="-1"){alert("This User ID is not signed up yet , please sign up first.");Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);}else if(userId=="-2"){alert("you input wrong password , please try again.");Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);}else if(userId=="-3"){alert("you Account is disabled , please contact with Administrator.");Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);}else if(userId=="-4"){alert("you Account is locked, please contact with Administrator.");Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);}else{Light.setCookie(Light._LOGINED_USER_ID,Light.userId);Light.deleteCookie(Light._CURRENT_TAB);Light.deleteCookie(Light._IS_SIGN_OUT);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);Light.portal.needReload=true;Light.refreshPortal();}}
Light.loginToPortal=function(id){var userId=document.forms['form_'+id]['email'].value;var password=document.forms['form_'+id]['password'].value;if(userId==null||userId.length<=0||password==null||password.length<=0){alert("please input User ID and password.");return;}
Light.userId=userId;if(document.forms['form_'+id]['rememberMe'].checked){var date=new Date();var timestamp=Date.parse(date);date.setFullYear(date.getFullYear()+1);Light.setCookie(Light._REMEMBERED_USER_ID,userId,date);Light.setCookie(Light._REMEMBERED_USER_PASSWORD,password,date);}else{Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);}
Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);var portlet=Light.getPortletById(id);var params="portletId="+portlet.serverId
+"&tabId="+Light.portal.tabs[portlet.tIndex].tabServerId
+"&userId="+escape(encodeURIComponent(userId))
+"&password="+escape(encodeURIComponent(password));Light.ajax.sendRequest(Light.portal.contextPath+Light.loginRequest,{parameters:params,onSuccess:Light.LoginToPortalHandler});}
Light.LoginToPortalHandler=function(t){var userId=t.responseText;if(userId=="-1"){alert("This User ID is not signed up yet , please sign up first.");Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);}else if(userId=="-2"){alert("you input wrong password , please try again.");Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);}else if(userId=="-3"){alert("you Account is disabled , please contact with Administrator.");Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);}else if(userId=="-4"){alert("you Account is locked, please contact with Administrator.");Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);}else{Light.setCookie(Light._LOGINED_USER_ID,Light.userId);Light.deleteCookie(Light._CURRENT_TAB);Light.deleteCookie(Light._IS_SIGN_OUT);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);Light.portal.latestAction.portlet.close(true);Light.setSessionTimer();Light.portal.refreshPortalMenu(null);var method=Light.portal.latestAction.method+"(null,'"+Light.portal.latestAction.id+"')";eval(method);}}
Light.resetCache=function(){Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);if(Light.getCookie(Light._LOGINED_USER_ID)==null){Light.deleteCookie(Light._GUEST_PORTAL);Light.deleteCookie(Light._GUEST_PORTAL_TAB);}}
Light.showUploader=function(id,name){var data={id:id,title:$('_CLOSE').title,popupName:name};createPopupDiv(name,name+'.jst',640,data,null,id);}
Light.closeUploader=function(id,name){hidePopupDiv(name);var portlet=Light.getPortletById(id);if(portlet!=null){portlet.mode=Light._VIEW_MODE;portlet.lastAction=null;portlet.rememberMode(0);portlet.refresh();}}
Light.backToView=function(id){var portlet=Light.getPortletById(id);if(portlet!=null){portlet.mode=Light._VIEW_MODE;portlet.lastAction=null;portlet.rememberMode(0);portlet.refresh();}}
Light.toMyAccount=function(){window.location=Light.portal.contextPath+"/index.jsp";}
Light.showLinkAction=function(e,id,itemId,itemLink,image,name){var portlet=Light.getPortletById(id);if(portlet==null)return;var old=document.getElementById(name);if(old!=null){hidePopupDiv(name);image.src=Light.portal.contextPath+"/light/images/showMod.gif";return;}
image.src=Light.portal.contextPath+"/light/images/hideMod.gif";var data={id:id,itemId:itemId,itemLink:itemLink,popupName:name};createPopupDiv(name,name+'.jst',10,data,e,id);}
Light.doLinkAction=function(id,itemId,action,name){var portlet=Light.getPortletById(id);if(portlet==null)return;var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&mode="+portlet.mode
+"&action="+action
+"&parameter="+itemId;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});hidePopupDiv(name);}
Light.showBlogAction=function(e,id,itemId,uri,anchor,itemTitle,image){var portlet=Light.getPortletById(id);if(portlet==null)return;var name="showBlogAction";var old=document.getElementById(name);if(old!=null){hidePopupDiv(name);image.src=Light.portal.contextPath+"/light/images/showMod.gif";return;}
image.src=Light.portal.contextPath+"/light/images/hideMod.gif";var data={id:id,itemId:itemId,uri:uri,anchor:anchor,itemTitle:itemTitle,popupName:name};createPopupDiv(name,name+'.jst',10,data,e,id);}
Light.changeOptions=function(){var portlet=new PortletPopupWindow(11,50,1000,$('_MENU_LOOK_AND_FEEL').title,"","","optionsPortlet",Light.portal.contextPath+"/optionsPortlet.lp",true,false,false,false,false,false,false,0,false,'','','','',false,false,false,0);portlet.refresh();}
Light.editTab=function(){var portlet=new PortletPopupWindow(11,200,400,$('_MENU_LAYOUT').title,"","","tabPortlet",Light.portal.contextPath+"/tabPortlet.lp",true,false,false,false,false,false,false,0,false,'','','','',false,false,false,0);portlet.refresh();}
Light.addTab=function(){var portlet=new PortletPopupWindow(11,200,400,$('_MENU_ADD_TAB').title,"","","tabPortlet",Light.portal.contextPath+"/tabPortlet.lp",true,false,false,false,false,false,false,0,false,'','','','',false,false,false,0);portlet.refresh();}
Light.addContent=function(){var portlet=new PortletPopupWindow(11,0,400,$('_MENU_ADD_CONTENT').title,"","","contentPortlet",Light.portal.contextPath+"/contentPortlet.lp",true,false,false,false,false,false,false,0,false,'','','','',false,false,false,1);portlet.refresh();}
Light.login=function(){var portlet=new PortletPopupWindow(11,200,400,$('_MENU_SIGN_IN').title,"","","login",Light.portal.contextPath+"/login.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();Light.portal.latestAction.portlet=portlet;}
Light.loginToMyAccount=function(){var portlet=new PortletPopupWindow(11,200,400,$('_MENU_SIGN_IN').title,"","","loginPortal",Light.portal.contextPath+"/loginPortal.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
Light.logout=function(){Light.deleteCookie(Light._LOGINED_USER_ID);Light.deleteCookie(Light._USER_ID);Light.deleteCookie(Light._CURRENT_TAB);var date=new Date();date.setFullYear(date.getFullYear()+1);Light.setCookie(Light._IS_SIGN_OUT,"true");Light.portal.needReload=true;$('loginUserId').title=0;var opt={method:'get',parameters:'',onSuccess:function(t){Light.responseLogout(t);},on404:function(t){alert('Error 404: location "'+t.statusText+'" was not found.');},onFailure:function(t){alert('Error '+t.status+' -- '+t.statusText);}}
Light.ajax.sendRequest(Light.portal.contextPath+Light.logoutRequest,opt);}
Light.responseLogout=function(t){window.location=Light.portal.contextPath+"/index.jsp";}
Light.editProfile=function(){var portlet=new PortletPopupWindow(11,50,1000,$('_MENU_MY_PROFILE').title,"/light/images/user.gif","","profileDetailPortlet",Light.portal.contextPath+"/profileDetailPortlet.lp",true,false,false,false,false,false,false,0,false,'','','','',false,false,false,0);portlet.refresh();}
Light.showChangeLanguage=function(){var portlet=new PortletPopupWindow(11,200,750,$('_TITLE_LANGUAGE').title,"","","changeLanguagePortlet",Light.portal.contextPath+"/changeLanguagePortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
Light.showSignUp=function(id){var portlet=new PortletPopupWindow(11,200,600,$('_MENU_SIGN_UP').title,"","","registrationPortlet",Light.portal.contextPath+"/registrationPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"",false,false);portlet.refresh();}
Light.cancelSignUp=function(id){Light.getPortletById(id).close();}
Light.showInboxMessage=function(){var portlet=new PortletPopupWindow(11,200,400,$('_MENU_MESSAGE_INBOX').title,"","","messagePortlet",Light.portal.contextPath+"/messagePortlet.lp",true,true,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
Light.showSentMessage=function(){var portlet=new PortletPopupWindow(11,200,400,$('_MENU_MESSAGE_SENT').title,"","","messagePortlet",Light.portal.contextPath+"/messagePortlet.lp",true,true,false,false,false,false,false,0,false,'','','',"type=sent");portlet.refresh();}
Light.showFriendRequest=function(){var portlet=new PortletPopupWindow(11,200,500,$('_MENU_FRIEND_REQUEST').title,"","","friendRequestPortlet",Light.portal.contextPath+"/friendRequestPortlet.lp",true,true,false,false,false,false,false,0,false,'','','','');portlet.refresh();}
Light.showInviteFriend=function(){var portlet=new PortletPopupWindow(11,200,400,$('_MENU_INVITE_FRIEND').title,"","","inviteFriendPortlet",Light.portal.contextPath+"/inviteFriendPortlet.lp",true,true,false,false,false,false,false,0,false,'','','','');portlet.refresh();}
Light.showPopupPortlet=function(left,width,title,image,name,request,windowState){var portlet=new PortletPopupWindow(11,left,width,title,image,"",name,Light.portal.contextPath+request,true,false,false,false,false,false,false,0,false,'','','','');portlet.refresh();}
Light.closePortlet=function(id,flag){if(flag==null)flag=true;var portlet=Light.getPortletById(id);if(portlet!=null){portlet.close(flag);}}
Light.changeLanguage=function(language){if(Light.getCookie(Light._USER_LOCALE)!=null&&Light.getCookie(Light._USER_LOCALE)!=""){Light.deleteCookie(Light._USER_LOCALE);}
var date=new Date();date.setFullYear(date.getFullYear()+1);Light.setCookie(Light._USER_LOCALE,language,date);var params="language="+language;Light.ajax.sendRequest(Light.portal.contextPath+Light.changeLanguageRequest,{parameters:params,onSuccess:Light.changeLanguageHandler});}
Light.changeLanguageHandler=function(){Light.getAllViewTemplates();Light.needRefresh=true;}
Light.saveLanguage=function(id,finished){var len=document.forms['form_'+id]['language'].length;var language=null;for(var i=0;i<len;i++){if(document.forms['form_'+id]['language'][i].checked){language=document.forms['form_'+id]['language'][i].value;}}
var params="language="+language;if(!finished)
Light.ajax.sendRequest(Light.portal.contextPath+Light.changeLanguageRequest,{parameters:params,onSuccess:Light.saveOptionHandler});else{Light.changeLanguage(language);}}
Light.saveOptionHandler=function(t){$('optionsMessage').innerHTML=(t.responseText==1)?'<br/>Option have been saved successfully.':'<br/>Option save failed, please try again';}
Light.saveRegion=function(id,finished){var len=document.forms['form_'+id]['region'].length;var region=null;for(var i=0;i<len;i++){if(document.forms['form_'+id]['region'][i].checked){region=document.forms['form_'+id]['region'][i].value;}}
var params="region="+region;if(!finished)
Light.ajax.sendRequest(Light.portal.contextPath+Light.changeRegion,{parameters:params,onSuccess:Light.saveOptionHandler});else
Light.ajax.sendRequest(Light.portal.contextPath+Light.changeRegion,{parameters:params,onSuccess:Light.refreshPortal});}
Light.saveTimeZone=function(id,finished){var len=document.forms['form_'+id]['timeZone'].length;var timeZone=null;for(var i=0;i<len;i++){if(document.forms['form_'+id]['timeZone'][i].checked){timeZone=document.forms['form_'+id]['timeZone'][i].value;}}
var params="responseId="+id+"&timeZone="+timeZone;if(!finished)
Light.ajax.sendRequest(Light.portal.contextPath+Light.changeTimeZone,{parameters:params,onSuccess:Light.saveOptionHandler});else
Light.ajax.sendRequest(Light.portal.contextPath+Light.changeTimeZone,{parameters:params,onSuccess:Light.closeOption});}
Light.closeOption=function(t){Light.closePortlet(t.responseText,true);}
Light.setTextColor=function(id,color){document.forms['form_'+id]['pcTextColor'].value=color;document.forms['form_'+id]['pcTextColor'].style.color=color;}
Light.saveGeneral=function(id){var params="";Light.portal.headerHeight=document.forms['form_'+id]['ptHeaderHeight'].value;var fontSize=document.forms['form_'+id]['ptFontSize'].value;if(Light.portal.headerHeight!=null){if(params.length>0)
params=params+"&headerHeight="+Light.portal.headerHeight;else
params="headerHeight="+Light.portal.headerHeight;}
if(fontSize!=null){Light.portal.fontSize=fontSize;if(params.length>0)
params=params+"&fontSize="+fontSize;else
params="fontSize="+fontSize;}
var textFont=document.forms['form_'+id]['pcTextFontSelect'].value;var fontInput=document.forms['form_'+id]['pcTextFont'].value
if(fontInput!=null&&fontInput.length>0)textFont=fontInput;if(textFont!=null){Light.portal.textFont=textFont;if(params.length>0)
params=params+"&textFont="+textFont;else
params="textFont="+textFont;}
var textColor=document.forms['form_'+id]['pcTextColor'].value;if(textColor!=null){Light.portal.textColor=textColor;if(params.length>0)
params=params+"&textColor="+textColor;else
params="textColor="+textColor;}
if(document.forms['form_'+id]['showSearchBar'].checked&&!Light.portal.showSearchBar){Light.portal.showSearchBar=true;if(params.length>0)
params=params+"&showSearchBar=1";else
params="showSearchBar=1";}
if(!document.forms['form_'+id]['showSearchBar'].checked&&Light.portal.showSearchBar){Light.portal.showSearchBar=false;if(params.length>0)
params=params+"&showSearchBar=0";else
params="showSearchBar=0";}
if(document.forms['form_'+id]['transparent'].checked&&!Light.portal.portletWindowTransparent){if(params.length>0)
params=params+"&transparent=1";else
params="transparent=1";}
if(!document.forms['form_'+id]['transparent'].checked&&Light.portal.portletWindowTransparent){if(params.length>0)
params=params+"&transparent=0";else
params="transparent=0";}
if((document.forms['form_'+id]['transparent'].checked&&!Light.portal.portletWindowTransparent)||(!document.forms['form_'+id]['transparent'].checked&&Light.portal.portletWindowTransparent)){Light.portal.portletWindowTransparent=!Light.portal.portletWindowTransparent;Light.refreshWindowTransparent();}
var maxShowTabs=document.forms['form_'+id]['ptMaxShowTabs'].value;if(params.length>0)
params=params+"&maxShowTabs="+maxShowTabs;else
params="maxShowTabs="+maxShowTabs;if(params.length>0){params=params+"&responseId="+id;Light.portal.refreshPortalHeader();Light.refreshTextFontSize();Light.ajax.sendRequest(Light.portal.contextPath+Light.changeGeneral,{parameters:params,onSuccess:Light.saveOptionHandler});Light.resetCache();}}
Light.defaultGeneral=function(id){Light.portal.fontSize=0;Light.portal.textFont="";Light.portal.textColor="";Light.portal.showSearchBar=true;Light.portal.headerHeight=0;Light.portal.portletWindowTransparent=false;Light.portal.maxShowTabs=10;document.forms['form_'+id]['ptHeaderHeight'].value=0;document.forms['form_'+id]['ptFontSize'].value=0;document.forms['form_'+id]['showSearchBar'].checked=true;document.forms['form_'+id]['transparent'].checked=false;document.forms['form_'+id]['pcTextFont'].value="";document.forms['form_'+id]['pcTextColor'].value="";var params="textFont=&textColor=&headerHeight=0&fontSize=0&showSearchBar=1&transparent=0&maxShowTabs=10&responseId="+id;Light.portal.refreshPortalHeader();Light.refreshWindowTransparent();Light.refreshTextFontSize();Light.ajax.sendRequest(Light.portal.contextPath+Light.changeGeneral,{parameters:params,onSuccess:Light.saveOptionHandler});Light.resetCache();}
Light.showTheme=function(e,theme,caption,id){var data={caption:caption,theme:theme};createPopupDiv('showTheme','showTheme.jst',500,data,e,id);}
Light.hideTheme=function(){hidePopupDiv('showTheme');}
Light.selectTheme=function(theme){Light.portal.themeLink=document.createElement("link");Light.portal.themeLink.setAttribute("rel","stylesheet");Light.portal.themeLink.setAttribute("type","text/css");if(document.all)
Light.portal.themeLink.setAttribute("href",Light.getThemePath(theme)+'/MSIE/theme.css');else
Light.portal.themeLink.setAttribute("href",Light.getThemePath(theme)+'/theme.css');document.getElementsByTagName("head")[0].insertBefore(Light.portal.themeLink,document.getElementsByTagName('link')[1]);}
Light.saveTheme=function(id,finished){var len=document.forms['form_'+id]['ptTheme'].length;var theme=null;for(var i=0;i<len;i++){if(document.forms['form_'+id]['ptTheme'][i].checked){theme=document.forms['form_'+id]['ptTheme'][i].value;}}
if(Light.portal.themeLink!=null){document.getElementsByTagName('link')[2].href=Light.portal.themeLink.href;document.getElementsByTagName("head")[0].removeChild(Light.portal.themeLink);Light.portal.themeLink=null;}
var bgRepeat=null;len=document.forms['form_'+id]['ptRepeat'].length;for(var i=0;i<len;i++){if(document.forms['form_'+id]['ptRepeat'][i].checked){bgRepeat=document.forms['form_'+id]['ptRepeat'][i].value;}}
if(Light.portal.bgRepeat!=bgRepeat){Light.portal.bgRepeat=bgRepeat;if(Light.portal.bgImage!="no"){var backgroundImage=Light.portal.bgImage;if(backgroundImage.indexOf("http")<0)
backgroundImage=Light.portal.contextPath+Light.portal.bgImage;if(Light.portal.bgRepeat==1)
document.body.style.background="url('"+backgroundImage+"') no-repeat "+Light.portal.bgPosition;else if(Light.portal.bgRepeat==2)
document.body.style.background="url('"+backgroundImage+"') repeat-x right top";else if(Light.portal.bgRepeat==3)
document.body.style.background="url('"+backgroundImage+"') repeat-y left top";else
document.body.style.background="url('"+backgroundImage+"')";}}
var bgImage=null;if(Light.portal.newBgImage.length>0)
bgImage=Light.portal.newBgImage;len=document.forms['form_'+id]['ptBg'].length;for(var i=0;i<len;i++){if(document.forms['form_'+id]['ptBg'][i].checked&&document.forms['form_'+id]['ptBg'][i].value!="more"){bgImage=document.forms['form_'+id]['ptBg'][i].value;}}
if(bgImage!=null&&bgImage!=Light.portal.bgImage){Light.portal.bgImage=bgImage;if(bgImage!="no"){var backgroundImage=bgImage;if(bgImage.indexOf("http")<0)
backgroundImage=Light.portal.contextPath+bgImage;if(Light.portal.bgRepeat==1)
document.body.style.background="url('"+backgroundImage+"') no-repeat "+Light.portal.bgPosition;else if(Light.portal.bgRepeat==2)
document.body.style.background="url('"+backgroundImage+"') repeat-x right top";else if(Light.portal.bgRepeat==3)
document.body.style.background="url('"+backgroundImage+"') repeat-y left top";else
document.body.style.background="url('"+backgroundImage+"')";}else{document.body.style.background="#ffffff";}}
var headerRepeat=null;len=document.forms['form_'+id]['ptHeaderRepeat'].length;for(var i=0;i<len;i++){if(document.forms['form_'+id]['ptHeaderRepeat'][i].checked){headerRepeat=document.forms['form_'+id]['ptHeaderRepeat'][i].value;}}
if(Light.portal.headerRepeat!=headerRepeat){Light.portal.headerRepeat=headerRepeat;if(Light.portal.headerImage!=null){Light.portal.refreshPortalHeader();}}
var headerImage=null;if(Light.portal.newHeaderImage.length>0)
headerImage=Light.portal.newHeaderImage;len=document.forms['form_'+id]['ptHeader'].length;for(var i=0;i<len;i++){if(document.forms['form_'+id]['ptHeader'][i].checked&&document.forms['form_'+id]['ptHeader'][i].value!="more"){headerImage=document.forms['form_'+id]['ptHeader'][i].value;}}
if(headerImage!=null){Light.portal.headerImage=headerImage;}else{Light.portal.headerImage="no";}
Light.portal.refreshPortalHeader();if((document.forms['form_'+id]['transparent'].checked&&!Light.portal.portletWindowTransparent)||(!document.forms['form_'+id]['transparent'].checked&&Light.portal.portletWindowTransparent)){Light.portal.portletWindowTransparent=!Light.portal.portletWindowTransparent;Light.refreshWindowTransparent();}
var params="responseId="+id;if(theme!=null){params=params+"&theme="+theme;Light.portal.theme=theme;}
params=params+"&bgRepeat="+bgRepeat;if(bgImage!=null){params=params+"&bgImage="+bgImage;}
params=params+"&headerRepeat="+headerRepeat;if(headerImage!=null){params=params+"&headerImage="+headerImage;}
if(document.forms['form_'+id]['transparent'].checked){params=params+"&transparent=1";}
if(params.length>0){Light.ajax.sendRequest(Light.portal.contextPath+Light.changeThemeRequest,{parameters:params,onSuccess:Light.saveOptionHandler});}
if(finished){Light.closePortlet(id,true);}}
function changeTabColumns(id){var columns=document.forms['form_'+id]['ptColumns'].value;var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&columns="+columns;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function changeCurrentTabColumns(id){var columns=document.forms['form_'+id]['ptColumns'].value;var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&columns="+columns;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function focusLeftTab(){var tabList=document.getElementById('tabList');for(i=0;i<tabList.childNodes.length;i++){if(tabList.childNodes[i]&&tabList.childNodes[i].tagName=="LI"){if(tabList.childNodes[i].getAttribute('tabColor')+"current"==tabList.childNodes[i].className){if(i>0){var previous=i+Light.portal.startTab-1;Light.portal.tabs[previous].focus();Light.portal.tabs[previous].refresh();}else if(i==0){var previous=Light.portal.startTab-1;if(previous>=0){if(!Light.portal.tabs[previous].opened){Light.portal.tabs[previous].open(Light.portal.tabs[previous],Light.portal.tabs[previous+1]);}else{tabList.insertBefore(Light.portal.tabs[previous].tabContainer,Light.portal.tabs[previous+1].tabContainer);}
Light.portal.tabs[previous].focus();Light.portal.tabs[previous].refresh();tabList.removeChild(tabList.childNodes[Light.portal.maxShowTabs]);Light.portal.startTab--;}}
return;}}}}
function focusRightTab(){var tabList=document.getElementById('tabList');for(i=0;i<tabList.childNodes.length;i++){if(tabList.childNodes[i]&&tabList.childNodes[i].tagName=="LI"){if(tabList.childNodes[i].getAttribute('tabColor')+"current"==tabList.childNodes[i].className){var lastTab=tabList.childNodes.length-1;if(Light.portal.allowAddTab)lastTab--;if(i<lastTab){var next=Light.portal.startTab+i+1;Light.portal.tabs[next].focus();Light.portal.tabs[next].refresh();}else if(i==lastTab){var next=Light.portal.startTab+i+1;if(next<=Light.portal.tabs.length-1){if(!Light.portal.tabs[next].opened){Light.portal.tabs[next].open(Light.portal.tabs[next]);}else{var lastOne=document.getElementById('tabMenuAddTab');if(lastOne!=null)
tabList.insertBefore(Light.portal.tabs[next].tabContainer,lastOne);else
tabList.appendChild(Light.portal.tabs[next].tabContainer);}
Light.portal.tabs[next].focus();Light.portal.tabs[next].refresh();tabList.removeChild(tabList.childNodes[0]);Light.portal.startTab++;}}
return;}}}}
function addAutoTab(id){var title=$('_LABEL_NEW_TAB').title;var portletWindowType="WindowAppearance2";var columns=3;var between=10;var widths="&width0=300&width1=300&width2=300";var closeable="1";var defaulted="0";var params="title="+encodeURIComponent(title)
+"&windowType="+portletWindowType
+"&columns="+columns
+widths
+"&between="+between
+"&closeable="+closeable
+"&defaulted="+defaulted
+"&parentId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.addTabRequest,{parameters:params,onSuccess:responseAddTab});}
function addTab(id){var title=document.forms['form_'+id]['ptTitle'].value;var portletWindowType=document.forms['form_'+id]['ptWindow'].value;var columns=parseInt(document.forms['form_'+id]['ptColumns'].value);var between=document.forms['form_'+id]['ptBetween'].value;var widths="";for(var i=0;i<columns;i++){widths+="&width"+i+"="+document.forms['form_'+id]['ptWidth'+i].value;}
var closeable="0";if(document.forms['form_'+id]['ptClose'].checked)
closeable="1";var defaulted="0";if(document.forms['form_'+id]['ptDefault'].checked)
defaulted="1";var params="title="+encodeURIComponent(title)
+"&windowType="+portletWindowType
+"&columns="+columns
+widths
+"&between="+between
+"&closeable="+closeable
+"&defaulted="+defaulted;Light.ajax.sendRequest(Light.portal.contextPath+Light.addTabRequest,{parameters:params,onSuccess:responseAddTab});Light.closePortlet(id);}
function responseAddTab(t){if(Light.getCookie(Light._ON)=="on"){var portalTab=t.responseText;var vPortalTab=eval(portalTab);if(vPortalTab.parentId>0){vPortalTab.parent=Light.getTabById(vPortalTab.parentId);vPortalTab.tabList="tabList"+vPortalTab.parent.tabServerId;vPortalTab.tabPanels="tabPanels"+vPortalTab.parent.tabServerId;}else{vPortalTab.parent=Light.portal;vPortalTab.tabList="tabList";vPortalTab.tabPanels="tabPanels";}
vPortalTab.insert(vPortalTab);Light.portal.tabs[vPortalTab.index]=vPortalTab;}}
function manageTab(id){var title=document.forms['form_'+id]['ptTitle'].value;var portletWindowType=document.forms['form_'+id]['ptWindow'].value;var columns=parseInt(document.forms['form_'+id]['ptColumns'].value);var between=document.forms['form_'+id]['ptBetween'].value;var widths=document.forms['form_'+id]['ptWidths'].value;var closeable="0";if(document.forms['form_'+id]['ptClose'].checked)
closeable="1";var defaulted="0";if(document.forms['form_'+id]['ptDefault'].checked)
defaulted="1";var status="0";var len=document.forms['form_'+id]['ptStatus'].length;for(var i=0;i<len;i++){if(document.forms['form_'+id]['ptStatus'][i].checked){status=document.forms['form_'+id]['ptStatus'][i].value;}}
var fitScreen="0";if(document.forms['form_'+id]['ptFitScreen'].checked)
fitScreen="1";var portlet=Light.getPortletById(id);var params="title="+encodeURIComponent(title)
+"&tabId="+Light.getCurrentTab().tabServerId
+"&windowType="+portletWindowType
+"&columns="+columns
+"&widths="+widths
+"&between="+between
+"&closeable="+closeable
+"&defaulted="+defaulted
+"&status="+status
+"&fitScreen="+fitScreen;Light.ajax.sendRequest(Light.portal.contextPath+Light.manageTabRequest,{parameters:params,onSuccess:responseEditTab});}
function editTab(id){var title=document.forms['form_'+id]['ptTitle'].value;var portletWindowType=document.forms['form_'+id]['ptWindow'].value;var columns=parseInt(document.forms['form_'+id]['ptColumns'].value);var between=document.forms['form_'+id]['ptBetween'].value;var widths="";for(var i=0;i<columns;i++){widths+="&width"+i+"="+document.forms['form_'+id]['ptWidth'+i].value;}
var closeable="0";if(document.forms['form_'+id]['ptClose'].checked)
closeable="1";var defaulted="0";if(document.forms['form_'+id]['ptDefault'].checked)
defaulted="1";var status="0";if(document.forms['form_'+id]['ptStatus'].checked)
status="1";var fitScreen="0";if(document.forms['form_'+id]['ptFitScreen'].checked)
fitScreen="1";var portlet=Light.getPortletById(id);var params="title="+encodeURIComponent(title)
+"&tabId="+Light.getCurrentTab().tabServerId
+"&windowType="+portletWindowType
+"&columns="+columns
+widths
+"&between="+between
+"&closeable="+closeable
+"&defaulted="+defaulted
+"&status="+status
+"&fitScreen="+fitScreen;Light.ajax.sendRequest(Light.portal.contextPath+Light.editTabRequest,{parameters:params,onSuccess:responseEditTab});}
function responseEditTab(){var currentTab=Light.getCookie(Light._CURRENT_TAB);Light.switchPortal();Light.setCookie(Light._CURRENT_TAB,currentTab);Light.switchPortal();}
function addContentMouseDown(el){if(el.className=='')
el.className='portlet-header';else
el.className='';}
function addContent(id,name){var column=parseInt(document.forms['form_'+id]['pcColumn'].value);var portlet=Light.getPortletById(id);var params="portletObjectRefName="+name
+"&tabId="+Light.getCurrentTab().tabServerId
+"&column="+column;Light.ajax.sendRequest(Light.portal.contextPath+Light.addContentRequest,{parameters:params,onSuccess:responseAddContent});}
function responseAddContent(t){if(Light.getCookie(Light._ON)=="on"){var currentTab=Light.getCurrentTab();var newPortlet="new PortletWindow(new "+currentTab.portletWindowAppearance+"(),"+currentTab.index+","+t.responseText+")";var portlet=eval(newPortlet);Light.executePortlet(Light._PC_PREFIX+portlet.serverId);}}
function showAddAllFeed(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,id:id,popupName:'addAllFeed'};createTopPopupDiv('addAllFeed','addAllFeed.jst',320,data,e,id);}
function showAddFeed(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,id:id,popupName:'addFeed'};createTopPopupDiv('addFeed','addFeed.jst',320,data,e,id);}
function addFeed(id){var feed=document.forms['myFeedForm']['pcFeed'].value;var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=addFeed"
+"&feed="+encodeURIComponent(feed);Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});hideTopPopupDiv('addFeed');}
function showMyFeed(id){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=showMyFeed";Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function hideMyFeed(id){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=hideMyFeed";Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function showAddFeaturedFeed(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,id:id,popupName:'addFeaturedFeed'};createTopPopupDiv('addFeaturedFeed','addFeaturedFeed.jst',300,data,e,id);}
function addFeaturedFeed(id){var feed=document.forms['myFeaturedFeedForm']['pcFeed'].value;var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=addFeaturedFeed"
+"&feed="+feed;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});hideTopPopupDiv('addFeaturedFeed');}
function showFeatured(id){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=showFeatured";Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function hideFeatured(id){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=hideFeatured";Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function showAddCategoryFeed(e,id,tag){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,id:id,tag:tag,popupName:'addCategoryFeed'};createTopPopupDiv('addCategoryFeed','addCategoryFeed.jst',300,data,e,id);}
function addCategoryFeed(id,tag){var feed=document.forms['myCategoryFeedForm']['pcFeed'].value;var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=addCategoryFeed"
+"&tag="+tag
+"&feed="+feed;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});hideTopPopupDiv('addCategoryFeed');}
function showCategory(id){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=showCategory";Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function hideCategory(id){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=hideCategory";Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function showAddSubCategoryFeed(e,id,tag,subtag){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,id:id,tag:tag,subtag:subtag,popupName:'addSubCategoryFeed'};createTopPopupDiv('addSubCategoryFeed','addSubCategoryFeed.jst',300,data,e,id);}
function addSubCategoryFeed(id,tag,subtag){var feed=document.forms['mySubCategoryFeedForm']['pcFeed'].value;var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=addSubCategoryFeed"
+"&tag="+tag
+"&subtag="+subtag
+"&feed="+feed;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});hideTopPopupDiv('addSubCategoryFeed');}
function showSubCategory(id,name){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=showSubCategory"
+"&name="+encodeURIComponent(name);Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function hideSubCategory(id,name){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=hideSubCategory"
+"&name="+encodeURIComponent(name);Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function showCategoryContent(id,name){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=showCategoryContent"
+"&name="+encodeURIComponent(name);Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function hideCategoryContent(id,name){var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=hideCategoryContent"
+"&name="+encodeURIComponent(name);Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function configPortlet(id){var portlet=Light.getPortletById(id);var title=document.forms['form_'+id]['pcTitle'].value;var windowSkin=document.forms['form_'+id]['windowSkin'].value;var transparent=0;if(portlet.transparent)
transparent=1;portlet.title=title;var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&title="+encodeURIComponent(title)
+"&barBgColor="+portlet.barBgColor
+"&barFontColor="+portlet.barFontColor
+"&contentBgColor="+portlet.contentBgColor
+"&textColor="+portlet.textColor
+"&transparent="+transparent
+"&windowSkin="+windowSkin;Light.ajax.sendRequest(Light.portal.contextPath+Light.changeMode,{parameters:params,onSuccess:responseChangeMode});}
function responseChangeMode(t){var id=t.responseText;var portlet=Light.getPortletById(id);portlet.cancelConfig();}
function defaultConfigPortlet(id){var title=document.forms['form_'+id]['pcTitle'].value;var portlet=Light.getPortletById(id);portlet.title=title;portlet.barBgColor="";portlet.barFontColor="";portlet.contentBgColor="";portlet.textColor="";portlet.transparent=false;portlet.refreshWindow();var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&title="+encodeURIComponent(title)
+"&transparent=0";Light.ajax.sendRequest(Light.portal.contextPath+Light.changeMode,{parameters:params,onSuccess:responseChangeMode});}
function validateConfigStore(form){var name=form['name'].value;var uri=form['uri'].value;var returnval;if(name!=null&&name.length>0&&uri!=null&&uri.length>0){returnval=true;}else{alert("All * fields are required.");returnval=false;}
return returnval;}
function validateSignUp(form){var userId=form['email'].value;var password=form['password'].value;var cpassword=form['confirmPassword'].value;var displayName=form['displayName'].value;var uri=form['myUri'].value;var returnval;if(displayName!=null&&displayName.length>0&&userId!=null&&userId.length>0&&password!=null&&password.length>0&&cpassword!=null&&cpassword.length>0&&uri!=null&&uri.length>0){if(password!=cpassword){alert($('_ERROR_PASSWORD_NOT_EQUAL').title);returnval=false;}else{returnval=true;}}else
{alert("All * fields are required.");returnval=false;}
if(returnval)
Light.deleteCookie(Light._REMEMBERED_USER_ID);Light.deleteCookie(Light._REMEMBERED_USER_PASSWORD);Light.deleteCookie(Light._MY_PORTAL);Light.deleteCookie(Light._MY_PORTAL_TAB);return returnval;}
function validateUserId(email,id){var filter=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;if(!filter.test(email)){alert($("_ERROR_EMAIL_FORMAT").title);return;}
var params="email="+email
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.validateUserId,{parameters:params,onSuccess:responseValidateUserId});}
function responseValidateUserId(t){var returnValue=t.responseText;if(returnValue!=1){document.forms['form_'+returnValue]['email'].value="";alert($("_ERROR_EMAIL_DUPLICATED").title);document.forms['form_'+returnValue]['email'].focus();}}
function validateMyUri(uri,id){var params="uri="+uri
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.validateMyUri,{parameters:params,onSuccess:responseValidateMyUri});}
function responseValidateMyUri(t){var returnValue=t.responseText;if(returnValue!=1){document.forms['form_'+returnValue]['myUri'].value="";alert("This URI is not available, please try a new URI.");document.forms['form_'+returnValue]['myUri'].focus();}}
function validateMyStoreUri(uri,id){var params="uri="+uri
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.validateMyStoreUri,{parameters:params,onSuccess:responseValidateMyStoreUri});}
function responseValidateMyStoreUri(t){var returnValue=t.responseText;if(returnValue!=1){document.forms['form_'+returnValue]['uri'].value="";alert("This URI is not available, please try a new URI.");document.forms['form_'+returnValue]['uri'].focus();}}
function saveProfile(id){var password=document.forms['form_'+id]['plPassword'].value;var cpassword=document.forms['form_'+id]['plConfirmPassword'].value;var firstName=document.forms['form_'+id]['plFirstName'].value;var middleName=document.forms['form_'+id]['plMiddleName'].value;var lastName=document.forms['form_'+id]['plLastName'].value;var email=document.forms['form_'+id]['plEmail'].value;if(password==null||password==""||cpassword==null||cpassword==""||firstName==null||firstName==""||lastName==null||lastName==""){alert($('_ERROR_FIELDS_REQUIRED').title);return;}
if(password!=cpassword){alert($('_ERROR_PASSWORD_NOT_EQUAL').title);return;}
var len=document.forms['form_'+id]['plChannels'].length;var channels="";for(var i=0;i<len;i++){if(document.forms['form_'+id]['plChannels'][i].checked){channels+=document.forms['form_'+id]['plChannels'][i].value+",";}}
var portlet=Light.getPortletById(id);var params="portletId="+portlet.serverId
+"&tabId="+Light.getCurrentTab().tabServerId
+"&password="+password
+"&firstName="+firstName
+"&middleName="+middleName
+"&lastName="+lastName
+"&email="+email
+"&channels="+channels;if(document.forms['form_'+id]['plShowLocale'].checked){params+="&showLocale=1";}
Light.ajax.sendRequest(Light.portal.contextPath+Light.profileRequest,{parameters:params,onSuccess:responseSaveProfile});}
function responseSaveProfile(t){var userId=t.responseText;if(userId=="-1"){alert("This User is not exist.");}else if(userId=="-2"){alert("System busy, please try later.");}else{Light.reloadPortal();}}
Light.showMoreBgImage=function(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={bgImage:Light.portal.bgImage,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id};createTopPopupDiv('moreBgImage','moreBgImage.jst',null,data,e,id);}
function saveBgImage(id){var len=document.forms['form_moreBgImage']['ptBg'].length;var bgImage="";for(var i=0;i<len;i++){if(document.forms['form_moreBgImage']['ptBg'][i].checked){bgImage=document.forms['form_moreBgImage']['ptBg'][i].value;}}
Light.portal.newBgImage=bgImage;if(bgImage.length>0){var len=document.forms['form_'+id]['ptBg'].length;for(var i=0;i<len;i++){if(document.forms['form_'+id]['ptBg'][i].value="more")
document.forms['form_'+id]['ptBg'][i].checked=true;else
document.forms['form_'+id]['ptBg'][i].checked=false;}}
cancelBgImage();}
function cancelBgImage(){hideTopPopupDiv('moreBgImage');}
Light.showMoreHeaderImage=function(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={headerImage:Light.portal.headerImage,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id};createTopPopupDiv('moreHeaderImage','moreHeaderImage.jst',null,data,e,id);}
function saveHeaderImage(id){var len=document.forms['form_moreHeaderImage']['ptHeader'].length;var headerImage="";for(var i=0;i<len;i++){if(document.forms['form_moreHeaderImage']['ptHeader'][i].checked){headerImage=document.forms['form_moreHeaderImage']['ptHeader'][i].value;}}
Light.portal.newHeaderImage=headerImage;if(headerImage.length>0){var len=document.forms['form_'+id]['ptHeader'].length;for(var i=0;i<len;i++){if(document.forms['form_'+id]['ptHeader'][i].value="more")
document.forms['form_'+id]['ptHeader'][i].checked=true;else
document.forms['form_'+id]['ptHeader'][i].checked=false;}}
cancelHeaderImage();}
function cancelHeaderImage(){hideTopPopupDiv('moreHeaderImage');}
function subscribeChannels(id){var len=document.forms['form_'+id]['channels'].length;var channels="";for(var i=0;i<len;i++){if(document.forms['form_'+id]['channels'][i].checked){channels+=document.forms['form_'+id]['channels'][i].value+",";}}
var portlet=Light.getPortletById(id);var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=channels"
+"&channels="+channels;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:params});}
function trackRssItem(index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.trackRssItem,{parameters:params});}
function readRecommendedItem(itemId,id){var portlet=Light.getPortletById(id);var params="itemId="+itemId
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.readRecommendedItem,{parameters:params});}
function readPopItem(itemId,id){var portlet=Light.getPortletById(id);var params="itemId="+itemId
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.readPopItem,{parameters:params});}
function readViewedItem(itemId,id){var portlet=Light.getPortletById(id);var params="itemId="+itemId
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.readViewedItem,{parameters:params});}
function popRssItem(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popRssItem,{parameters:params,onSuccess:responsePopItem});}
function popBlogItem(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popBlogItem,{parameters:params,onSuccess:responsePopItem});}
function popYouTubeItem(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popYouTubeItem,{parameters:params,onSuccess:responsePopItem});}
function popForumItem(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&pageId="+pageId
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popForumItem,{parameters:params,onSuccess:responsePopItem});}
function popTopicItem(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&pageId="+pageId
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popTopicItem,{parameters:params,onSuccess:responsePopItem});}
function popGroupForumItem(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&pageId="+pageId
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popGroupForumItem,{parameters:params,onSuccess:responsePopItem});}
function popGroupTopicItem(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&pageId="+pageId
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popGroupTopicItem,{parameters:params,onSuccess:responsePopItem});}
function popDeliItem(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popDeliItem,{parameters:params,onSuccess:responsePopItem});}
function popBookmarkItem(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popBookmarkItem,{parameters:params,onSuccess:responsePopItem});}
function responsePopItem(t){var id=t.responseText;var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,popupName:'popItem'};createPopupDiv('popItem','popItem.jst',280,data,null,id);}
function forwardRssToFriend(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardRssToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function forwardBlogToFriend(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardBlogToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function forwardYouTubeToFriend(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardYouTubeToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function forwardForumToFriend(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&pageId="+pageId
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardForumToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function forwardTopicToFriend(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&pageId="+pageId
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardTopicToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function forwardGroupForumToFriend(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&pageId="+pageId
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardGroupForumToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function forwardGroupTopicToFriend(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&pageId="+pageId
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardGroupTopicToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function forwardDeliToFriend(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardDeliToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function forwardBookmarkToFriend(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardBookmarkToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function forwardAdToFriend(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardAdToFriend,{parameters:params,onSuccess:responseForwardToFriend});}
function responseForwardToFriend(t){var id=t.responseText;var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,popupName:'forwardToFriend'};createPopupDiv('forwardToFriend','forwardToFriend.jst',280,data,null,id);}
function saveToHeader(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveToHeader,{parameters:params,onSuccess:responseSaveToHeader});}
function responseSaveToHeader(t){var headerImage=t.responseText;Light.portal.headerImage=headerImage;Light.portal.refreshPortalHeader();}
function saveToBackground(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveToBackground,{parameters:params,onSuccess:responseSaveToBackground});}
function responseSaveToBackground(t){var bgImage=t.responseText;Light.portal.bgImage=bgImage;var backgroundImage=bgImage;if(bgImage.indexOf("http")<0)
backgroundImage=Light.portal.contextPath+bgImage;if(Light.portal.bgRepeat==1)
document.body.style.background="url('"+backgroundImage+"') no-repeat "+Light.portal.bgPosition;else
document.body.style.background="url('"+backgroundImage+"')";}
function saveToBookmark(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveToBookmark,{parameters:params,onSuccess:responseSaveToBookmark});}
function saveToMyPicture(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveToMyPicture,{parameters:params,onSuccess:responseSaveToPicture});}
function saveBlogToBookmark(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveBlogToBookmark,{parameters:params,onSuccess:responseSaveToBookmark});}
function saveYouTubeToBookmark(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveYouTubeToBookmark,{parameters:params,onSuccess:responseSaveToBookmark});}
function saveForumToBookmark(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&pageId="+pageId
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveForumToBookmark,{parameters:params,onSuccess:responseSaveToBookmark});}
function saveTopicToBookmark(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&pageId="+pageId
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveTopicToBookmark,{parameters:params,onSuccess:responseSaveToBookmark});}
function saveGroupForumToBookmark(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&pageId="+pageId
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveGroupForumToBookmark,{parameters:params,onSuccess:responseSaveToBookmark});}
function saveGroupTopicToBookmark(e,index,pageId,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&pageId="+pageId
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveGroupTopicToBookmark,{parameters:params,onSuccess:responseSaveToBookmark});}
function saveAdToBookmark(e,index,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var params="index="+index
+"&"+portlet.parameter
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveAdToBookmark,{parameters:params,onSuccess:responseSaveToBookmark});}
function responseSaveToBookmark(t){var id=t.responseText;var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,popupName:'saveToBookmark'};createPopupDiv('saveToBookmark','saveToBookmark.jst',280,data,null,id);}
function responseSaveToPicture(t){var id=t.responseText;var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,popupName:'saveToPicture'};createPopupDiv('saveToPicture','saveToPicture.jst',280,data,null,id);}
function showRecommendedItemDesc(e,index,link,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('recommendedItemDesc');if(old!=null)vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="recommendedItemDesc";vRssDesc.name=link;vRssDesc.style.position="absolute";vRssDesc.onmouseout=function(){hideRecommendedItemDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft-80;y=event.clientY+document.body.scrollTop-68;}else{x=e.pageX-80;y=e.pageY-68;}
if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
if(Light.cacheArray[link]!=null){var width=300;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-20;vRssDesc.style.width=width;vRssDesc.className="portlet-popup";vRssDesc.innerHTML=Light.cacheArray[link];if(y<=100)y=100;if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}}
vRssDesc.style.zIndex=Light.maxZIndex+1000;vdocument.appendChild(vRssDesc);vRssDesc=null;if(Light.cacheArray[link]==null){var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getRecommendedItemDesc,{parameters:params,onSuccess:responseRecommendedItemDesc});}}
hideRecommendedItemDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('recommendedItemDesc');if(old!=null)vdocument.removeChild(old);}
function responseRecommendedItemDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('recommendedItemDesc');var x=100;var y=100;var zindex=Light.maxZIndex+1000;if(old!=null){link=old.name;if(Light.cacheArray[link]==null){Light.cacheArray[link]=desc;}
zindex=old.style.zIndex;if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=300;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-20;vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="recommendedItemDesc";vRssDesc.style.position="absolute";vRssDesc.style.width=width;vRssDesc.onmouseout=function(){hideRecommendedItemDesc();}
vRssDesc.className="portlet-popup";vRssDesc.innerHTML=desc;if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=zindex;vdocument.appendChild(vRssDesc);vRssDesc=null;}}
function showViewedItemDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('viewedItemDesc');if(old!=null)vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="viewedItemDesc";vRssDesc.style.position="absolute";vRssDesc.onmouseout=function(){hideViewedItemDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop-100;}else{x=e.pageX+10;y=e.pageY-100;}
if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=Light.maxZIndex;vdocument.appendChild(vRssDesc);vRssDesc=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getViewedItemDesc,{parameters:params,onSuccess:responseViewedItemDesc});}
hideViewedItemDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('viewedItemDesc');if(old!=null)vdocument.removeChild(old);}
function responseViewedItemDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('viewedItemDesc');var x=100;var y=100;var zindex=Light.maxZIndex+200;if(old!=null){zindex=old.style.zIndex;if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=300;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="viewedItemDesc";vRssDesc.style.position="absolute";vRssDesc.style.width=width;vRssDesc.onmouseout=function(){hideViewedItemDesc();}
vRssDesc.className="portlet-popup";vRssDesc.innerHTML=desc;if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=zindex;vdocument.appendChild(vRssDesc);vRssDesc=null;}}
function showPopItemDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('popItemDesc');if(old!=null)vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="popItemDesc";vRssDesc.style.position="absolute";vRssDesc.onmouseout=function(){hidePopItemDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop-100;}else{x=e.pageX+10;y=e.pageY-100;}
if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=Light.maxZIndex;vdocument.appendChild(vRssDesc);vRssDesc=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getPopItemDesc,{parameters:params,onSuccess:responsePopItemDesc});}
hidePopItemDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('popItemDesc');if(old!=null)vdocument.removeChild(old);}
function responsePopItemDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('popItemDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=300;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="popItemDesc";vRssDesc.style.position="absolute";vRssDesc.style.width=width;vRssDesc.onmouseout=function(){hidePopItemDesc();}
vRssDesc.className="portlet-popup";vRssDesc.innerHTML=desc;if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=Light.maxZIndex+10;vdocument.appendChild(vRssDesc);vRssDesc=null;}}
function showRssDesc(e,index,link,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('rssDesc');if(old!=null)vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="rssDesc";vRssDesc.name=link;vRssDesc.style.position="absolute";vRssDesc.onmouseout=function(){hideRssDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft-80;y=event.clientY+document.body.scrollTop-68;}else{x=e.pageX-80;y=e.pageY-68;}
if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=Light.maxZIndex+1000;if(Light.cacheArray[link]!=null){var width=300;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-20;vRssDesc.style.width=width;vRssDesc.className="portlet-popup";vRssDesc.innerHTML=Light.cacheArray[link];if(y<=100)y=100;if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}}
vdocument.appendChild(vRssDesc);vRssDesc=null;if(Light.cacheArray[link]==null){var params="index="+index
+"&feed="+encodeURIComponent(portlet.parameter.substring(5,portlet.parameter.length));Light.ajax.sendRequest(Light.portal.contextPath+Light.getRssDesc,{parameters:params,onSuccess:responseRssDesc});}}
hideRssDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('rssDesc');if(old!=null)vdocument.removeChild(old);}
function responseRssDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('rssDesc');var x=100;var y=100;if(old!=null){link=old.name;if(Light.cacheArray[link]==null){Light.cacheArray[link]=desc;}
if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=360;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-20;vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="rssDesc";vRssDesc.style.position="absolute";vRssDesc.style.width=width;vRssDesc.onmouseout=function(){hideRssDesc();}
vRssDesc.className="portlet-popup";vRssDesc.innerHTML=desc;if(y<=100)y=100;if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=Light.maxZIndex+10000;vdocument.appendChild(vRssDesc);vRssDesc=null;}}
function editRssPortlet(id){var feed=document.forms['form_'+id]['prFeed'].value;var title=document.forms['form_'+id]['prTitle'].value;var icon=document.forms['form_'+id]['prIcon'].value;var url=document.forms['form_'+id]['prUrl'].value;var autoRefresh=document.forms['form_'+id]['prAuto'].value;var minute=document.forms['form_'+id]['prMinute'].value;var showType=document.forms['form_'+id]['prShowType'].value;var items=document.forms['form_'+id]['prItems'].value;if(autoRefresh=='1'&&minute=='0'){alert($('_ERROR_MINUTE_RATE').title);return;}
var portlet=Light.getPortletById(id);portlet.title=title;portlet.icon=icon;portlet.url=url;portlet.parameter="feed="+feed;portlet.mode=Light._VIEW_MODE;portlet.refreshHeader();portlet.refreshButtons();portlet.rememberMode(0);portlet.lastAction=null;if(autoRefresh=="1")
portlet.autoRefreshed=true;else
portlet.autoRefreshed=false;portlet.periodTime=minute*60000;portlet.autoRefresh();var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=edit"
+"&title="+title
+"&url="+url
+"&icon="+icon
+"&autoRefresh="+autoRefresh
+"&minute="+minute
+"&showType="+showType
+"&items="+items
+"&feed="+encodeURIComponent(feed);Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function showBookmarkDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('bookmarkDesc');if(old!=null)vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="bookmarkDesc";vRssDesc.style.position="absolute";vRssDesc.onmouseout=function(){hideBookmarkDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop-100;}else{x=e.pageX+10;y=e.pageY-100;}
if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=Light.maxZIndex;vdocument.appendChild(vRssDesc);vRssDesc=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getBookmarkDesc,{parameters:params,onSuccess:responseBookmarkDesc});}
hideBookmarkDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('bookmarkDesc');if(old!=null)vdocument.removeChild(old);}
function responseBookmarkDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('bookmarkDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=300;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="bookmarkDesc";vRssDesc.style.position="absolute";vRssDesc.style.width=width;vRssDesc.onmouseout=function(){hideBookmarkDesc();}
vRssDesc.className="portlet-popup";vRssDesc.innerHTML=desc;if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=Light.maxZIndex+10;vdocument.appendChild(vRssDesc);vRssDesc=null;}}
function showDeliDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('bookmarkDesc');if(old!=null)vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="bookmarkDesc";vRssDesc.style.position="absolute";vRssDesc.onmouseout=function(){hideDeliDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop-100;}else{x=e.pageX+10;y=e.pageY-100;}
if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=Light.maxZIndex;vdocument.appendChild(vRssDesc);vRssDesc=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getDeliDesc,{parameters:params,onSuccess:responseDeliDesc});}
hideDeliDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('bookmarkDesc');if(old!=null)vdocument.removeChild(old);}
function responseDeliDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('bookmarkDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=300;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;vdocument.removeChild(old);var vRssDesc=document.createElement('div');vRssDesc.id="bookmarkDesc";vRssDesc.style.position="absolute";vRssDesc.style.width=width;vRssDesc.onmouseout=function(){hideDeliDesc();}
vRssDesc.className="portlet-popup";vRssDesc.innerHTML=desc;if(document.all){vRssDesc.style.posLeft=x;vRssDesc.style.posTop=y;}else{vRssDesc.style.left=x;vRssDesc.style.top=y;}
vRssDesc.style.zIndex=Light.maxZIndex+10;vdocument.appendChild(vRssDesc);vRssDesc=null;}}
function showInternalNewsDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('internalNewsDesc');if(old!=null)vdocument.removeChild(old);var vDesc=document.createElement('div');vDesc.id="internalNewsDesc";vDesc.style.position="absolute";vDesc.onmouseout=function(){hideInternalNewsDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft-80;y=event.clientY+document.body.scrollTop-68;}else{x=e.pageX-80;y=e.pageY-68;}
if(document.all){vDesc.style.posLeft=x;vDesc.style.posTop=y;}else{vDesc.style.left=x;vDesc.style.top=y;}
vDesc.style.zIndex=Light.maxZIndex;vdocument.appendChild(vDesc);vDesc=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getInternalNewsDesc,{parameters:params,onSuccess:responseInternalNewsDesc});}
hideInternalNewsDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('internalNewsDesc');if(old!=null)vdocument.removeChild(old);}
function responseInternalNewsDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('internalNewsDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=300;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;vdocument.removeChild(old);var vDesc=document.createElement('div');vDesc.id="internalNewsDesc";vDesc.style.position="absolute";vDesc.style.width=width;vDesc.onmouseout=function(){hideInternalNewsDesc();}
vDesc.className="portlet-popup";vDesc.innerHTML=desc;if(document.all){vDesc.style.posLeft=x;vDesc.style.posTop=y;}else{vDesc.style.left=x;vDesc.style.top=y;}
vDesc.style.zIndex=Light.maxZIndex+10;vdocument.appendChild(vDesc);vDesc=null;}}
function keyDownSearchWeather(e,id){var KeyID;if(window.event){keyID=window.event.keyCode;}else{keyID=e.which;}
if(keyID==13){searchWeatherLocation(id);}
return!(keyID==13);}
function searchWeatherLocation(id){var locName=document.forms['form_'+id]['pwLocation'].value;var portlet=Light.getPortletById(id);var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&locName="+locName;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:params});}
function selectWeatherLocation(id){var locId=document.forms['form_'+id]['pwLocId'].value;if(!locId){var len=document.forms['form_'+id]['pwLocId'].length;for(var i=0;i<len;i++){if(document.forms['form_'+id]['pwLocId'][i].checked){locId=document.forms['form_'+id]['pwLocId'][i].value;}}}
var unit=document.forms['form_'+id]['pwUnit'].value;var portlet=Light.getPortletById(id);var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=select"
+"&locId="+locId
+"&unit="+unit;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:params});}
function keyDownEditWeather(e,id){var KeyID;if(window.event){keyID=window.event.keyCode;}else{keyID=e.which;}
if(keyID==13){editWeatherLocation(id);}
return!(keyID==13);}
function editWeatherLocation(id){var locName=document.forms['form_'+id]['pwLocation'].value;var portlet=Light.getPortletById(id);var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&mode=EDIT"
+"&locName="+locName;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:params});}
function refreshPortletTitle(id){var portlet=Light.getPortletById(id);if(portlet!=null){portlet.refreshPortletTitle();}}
function refreshTodoPortletTitle(portlet,status){if(portlet.title.indexOf("(")>0){var index=portlet.title.indexOf("(");var oldTitle=portlet.title;portlet.title=oldTitle.substring(0,index);var count=parseInt(oldTitle.substring(index+1,oldTitle.length));if(status==null)status=1;if(parseInt(status)==1)
count++;else
count--;portlet.title=portlet.title+"("+count+")";}else{portlet.title=portlet.title+"(1)";}
portlet.refreshHeader();}
function increaseTodoPortletTitle(id,todoId){if(todoId==0){var portlet=Light.getPortletById(id);if(portlet.title.indexOf("(")>0){var index=portlet.title.indexOf("(");var oldTitle=portlet.title;portlet.title=oldTitle.substring(0,index);var count=parseInt(oldTitle.substring(index+1,oldTitle.length));count++;portlet.title=portlet.title+"("+count+")";}else{portlet.title=portlet.title+"(1)";}
portlet.refreshHeader();}}
function increaseMyStorePortletTitle(id,productId){if(productId==0){var portlet=Light.getPortletById(id);if(portlet.title.indexOf("(")>0){var index=portlet.title.indexOf("(");var oldTitle=portlet.title;portlet.title=oldTitle.substring(0,index);var count=parseInt(oldTitle.substring(index+1,oldTitle.length));count++;portlet.title=portlet.title+"("+count+")";}else{portlet.title=portlet.title+"(1)";}
portlet.refreshHeader();}}
function decreasePortletTitle(id){var portlet=Light.getPortletById(id);if(portlet.title.indexOf("(")>0){var index=portlet.title.indexOf("(");var oldTitle=portlet.title;portlet.title=oldTitle.substring(0,index);var count=parseInt(oldTitle.substring(index+1,oldTitle.length));count--;if(count!=0)
portlet.title=portlet.title+"("+count+")";portlet.refreshHeader();}}
changeStatus=function(id,name,status){var portlet=Light.getPortletById(id);var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&state="+portlet.state
+"&action=changeStatus"
+"&name="+encodeURIComponent(name);Light.ajax.sendRequestAndUpdate(portlet.request,id,{method:'post',evalScripts:portlet.allowJS,parameters:params});refreshTodoPortletTitle(portlet,status);}
function previousItem(id,number){number=parseInt(number)-1;var portlet=Light.getPortletById(id);var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&"+portlet.parameter
+"&action=changeStatus"
+"&number="+number;Light.ajax.sendRequestAndUpdate(portlet.request,id,{method:'post',evalScripts:portlet.allowJS,parameters:params});}
function nextItem(id,number){number=parseInt(number)+1;var portlet=Light.getPortletById(id);var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&"+portlet.parameter
+"&action=changeStatus"
+"&number="+number;Light.ajax.sendRequestAndUpdate(portlet.request,id,{method:'post',evalScripts:portlet.allowJS,parameters:params});}
function editViewerPortlet(id){var feed=document.forms['form_'+id]['prFeed'].value;var title=document.forms['form_'+id]['prTitle'].value;var icon=document.forms['form_'+id]['prIcon'].value;var url=document.forms['form_'+id]['prUrl'].value;var portlet=Light.getPortletById(id);portlet.title=title;portlet.icon=icon;portlet.url=url;portlet.parameter="feed="+feed;portlet.refreshHeader();var params="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=edit"
+"&mode=EDIT"
+"&title="+title
+"&url="+url
+"&icon="+icon
+"&feed="+feed;Light.ajax.sendRequestAndUpdate(portlet.request,id,{method:'post',evalScripts:portlet.allowJS,parameters:params});}
function countDownload(e,id,type){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=e;Light.portal.latestAction.id=id;Light.portal.latestAction.method="countDownload";Light.portal.latestAction.type=type;Light.login();return;}
if(type==null){type=Light.portal.latestAction.type;}
var params="type="+type;Light.ajax.sendRequest(Light.portal.contextPath+Light.countDownloadRequest,{parameters:params});if(type==1)
window.open('http://www.lightportal.org/download/lightPortal.war','mywindow','width=400,height=200');else
window.open('http://www.lightportal.org/download/LightPortalV1.0Beta1.zip','mywindow','width=400,height=200');}
function showFeedbackDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('feedbackDesc');if(old!=null)vdocument.removeChild(old);var vDesc=document.createElement('div');vDesc.id="feedbackDesc";vDesc.style.position="absolute";vDesc.onmouseout=function(){hideFeedbackDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop-100;}else{x=e.pageX+10;y=e.pageY-100;}
if(document.all){vDesc.style.posLeft=x;vDesc.style.posTop=y;}else{vDesc.style.left=x;vDesc.style.top=y;}
vDesc.style.zIndex=Light.maxZIndex;vdocument.appendChild(vDesc);vDesc=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getFeedbackDesc,{parameters:params,onSuccess:responseFeedbackDesc});}
hideFeedbackDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('feedbackDesc');if(old!=null)vdocument.removeChild(old);}
function responseFeedbackDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('feedbackDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
vdocument.removeChild(old);var vDesc=document.createElement('div');vDesc.id="feedbackDesc";vDesc.style.position="absolute";vDesc.style.width=300;vDesc.onmouseout=function(){hideFeedbackDesc();}
vDesc.className="portlet-popup";vDesc.innerHTML=desc;if(document.all){vDesc.style.posLeft=x;vDesc.style.posTop=y;}else{vDesc.style.left=x;vDesc.style.top=y;}
vDesc.style.zIndex=Light.maxZIndex+10;vdocument.appendChild(vDesc);vDesc=null;}}
function showForumDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('forumDesc');if(old!=null)vdocument.removeChild(old);var vForumDesc=document.createElement('div');vForumDesc.id="forumDesc";vForumDesc.style.position="absolute";var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop-100;}else{x=e.pageX+10;y=e.pageY-100;}
if(document.all){vForumDesc.style.posLeft=x;vForumDesc.style.posTop=y;}else{vForumDesc.style.left=x;vForumDesc.style.top=y;}
vForumDesc.style.zIndex=Light.maxZIndex;vdocument.appendChild(vForumDesc);vForumDesc=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getForumDesc,{parameters:params,onSuccess:responseForumDesc});}
hideForumDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('forumDesc');if(old!=null)vdocument.removeChild(old);}
function responseForumDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('forumDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
vdocument.removeChild(old);var vForumDesc=document.createElement('div');vForumDesc.id="forumDesc";vForumDesc.style.position="absolute";vForumDesc.style.width=300;vForumDesc.className="portlet-popup";vForumDesc.innerHTML=desc;if(document.all){vForumDesc.style.posLeft=x;vForumDesc.style.posTop=y;}else{vForumDesc.style.left=x;vForumDesc.style.top=y;}
vForumDesc.style.zIndex=Light.maxZIndex+10;vdocument.appendChild(vForumDesc);vForumDesc=null;}}
function showForumDetail(e,index,id){hideForumDesc();if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('forumDetail');if(old!=null)vdocument.removeChild(old);var vForumDetail=document.createElement('div');vForumDetail.id="forumDetail";vForumDetail.style.position="absolute";var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop-200;}else{x=e.pageX+10;y=e.pageY-200;}
if(document.all){vForumDetail.style.posLeft=x;vForumDetail.style.posTop=y;}else{vForumDetail.style.left=x;vForumDetail.style.top=y;}
vForumDetail.style.zIndex=Light.maxZIndex;vdocument.appendChild(vForumDetail);vForumDetail=null;var params="index="+index
+"&responseId="+id
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getForumDetail,{parameters:params,onSuccess:responseForumDetail});}
hideForumDetail=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('forumDetail');if(old!=null)vdocument.removeChild(old);}
function responseForumDetail(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('forumDetail');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
vdocument.removeChild(old);var vForumDetail=document.createElement('div');vForumDetail.id="forumDetail";vForumDetail.style.position="absolute";vForumDetail.style.width=400;vForumDetail.className="portlet-popup";vForumDetail.innerHTML=desc;if(document.all){vForumDetail.style.posLeft=x;vForumDetail.style.posTop=y;}else{vForumDetail.style.left=x;vForumDetail.style.top=y;}
vForumDetail.style.zIndex=Light.maxZIndex+10;vdocument.appendChild(vForumDetail);vForumDetail=null;}}
function replyForum(parentId,topId,subject,portletId){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('forumReply');if(old!=null)vdocument.removeChild(old);var forumDetail=document.getElementById('forumDetail');var x=100;var y=100;if(forumDetail!=null){if(document.all){x=forumDetail.style.posLeft;y=forumDetail.style.posTop;}else{x=forumDetail.style.left;y=forumDetail.style.top;}}
var vForumReply=document.createElement('span');vForumReply.id="forumReply";vForumReply.style.position="absolute";vForumReply.className="portlet-popup";if(document.all){vForumReply.style.posLeft=x;vForumReply.style.posTop=y;}else{vForumReply.style.left=x;vForumReply.style.top=y;}
vForumReply.style.width=400;var inHtml="<span title='"+$('_CLOSE').title+"'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideForumReply();'><img src='"+Light.portal.contextPath+"/light/images/close_on.gif' style='border: 0px;'/></a></span>"
+"<form name='forumReplyForm'>"
+"<input type='hidden' name='parentId' value='"+parentId+"'/>"
+"<input type='hidden' name='topId' value='"+topId+"'/>"
+"<table border='0' cellpadding='0' cellspacing='0' >"
+"<tr>"
+"<td class='portlet-table-td-left'>"
+$('_LABEL_SUBJECT').title+":"
+"</td>"
+"<td class='portlet-table-td-left'>"
+"<input type='text' name='subject' value='"+subject+"' class='portlet-form-input-field' size='50' />"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+$('_LABEL_CONTENT').title+":"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+"<textarea name='content' class='portlet-form-textarea-field' rows='5' cols='60' >"
+"</textarea>"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-right' colspan='2' >"
+"<input type='button' name='action' onClick='javascript:saveForumReply(\""+portletId+"\");'"
+" value='"+$('_BUTTON_OK').title+"' class='portlet-form-button' />"
+"<input type='button' name='action' onClick='javascript:hideForumReply();' value='"
+$('_BUTTON_CANCEL').title+"' class='portlet-form-button' />"
+"</td>"
+"</tr>"
+"</table>"
+"</form>";vForumReply.innerHTML=inHtml;vForumReply.style.zIndex=forumDetail.style.zIndex+1;vdocument.appendChild(vForumReply);vForumReply=null;}
saveForumReply=function(portletId){var subject=document.forms['forumReplyForm']['subject'].value;var content=document.forms['forumReplyForm']['content'].value;if(subject==null||subject.length<=0){alert("Please input Forum's subject.");return;}
if(content==null||content.length<=0){alert("Please input Forum's content.");return;}
var parentId=document.forms['forumReplyForm']['parentId'].value;var topId=document.forms['forumReplyForm']['topId'].value;var params="subject="+subject
+"&content="+content
+"&parentId="+parentId
+"&topId="+topId
+"&responseId="+portletId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveForumReply,{parameters:params,onSuccess:responseForumReply});}
function responseForumReply(t){var portletId=t.responseText;var portlet=Light.getPortletById(portletId);if(portlet!=null)portlet.refresh();hideForumReply();hideForumDetail();}
hideForumReply=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('forumReply');if(old!=null)vdocument.removeChild(old);}
function showProductDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('vDesc');if(old!=null)vdocument.removeChild(old);var vDesc=document.createElement('div');vDesc.id="vDesc";vDesc.style.position="absolute";vDesc.onmouseout=function(){hideDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft-80;y=event.clientY+document.body.scrollTop-68;}else{x=e.pageX-80;y=e.pageY-68;}
if(document.all){vDesc.style.posLeft=x;vDesc.style.posTop=y;}else{vDesc.style.left=x;vDesc.style.top=y;}
vDesc.style.zIndex=Light.maxZIndex;vdocument.appendChild(vDesc);vDesc=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getProductDesc,{parameters:params,onSuccess:responseProductDesc});}
function responseProductDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('vDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
vdocument.removeChild(old);var vDesc=document.createElement('div');vDesc.id="vDesc";vDesc.style.position="absolute";vDesc.style.width=300;vDesc.onmouseout=function(){hideDesc();}
vDesc.className="portlet-popup";vDesc.innerHTML=desc;if(document.all){vDesc.style.posLeft=x;vDesc.style.posTop=y;}else{vDesc.style.left=x;vDesc.style.top=y;}
vDesc.style.zIndex=Light.maxZIndex+10;vdocument.appendChild(vDesc);vDesc=null;}}
function showTodoDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('vDesc');if(old!=null)vdocument.removeChild(old);var vDesc=document.createElement('div');vDesc.id="vDesc";vDesc.style.position="absolute";vDesc.onmouseout=function(){hideDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft-80;y=event.clientY+document.body.scrollTop-68;}else{x=e.pageX-80;y=e.pageY-68;}
if(document.all){vDesc.style.posLeft=x;vDesc.style.posTop=y;}else{vDesc.style.left=x;vDesc.style.top=y;}
vDesc.style.zIndex=Light.maxZIndex;vdocument.appendChild(vDesc);vDesc=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getTodoDesc,{parameters:params,onSuccess:responseTodoDesc});}
function responseTodoDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('vDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
vdocument.removeChild(old);var vDesc=document.createElement('div');vDesc.id="vDesc";vDesc.style.position="absolute";vDesc.style.width=300;vDesc.onmouseout=function(){hideDesc();}
vDesc.className="portlet-popup";vDesc.innerHTML=desc;if(document.all){vDesc.style.posLeft=x;vDesc.style.posTop=y;}else{vDesc.style.left=x;vDesc.style.top=y;}
vDesc.style.zIndex=Light.maxZIndex+10;vdocument.appendChild(vDesc);vDesc=null;}}
function showDesc(e,desc,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('vDesc');if(old!=null)vdocument.removeChild(old);var vDesc=document.createElement('div');vDesc.id="vDesc";vDesc.style.position="absolute";vDesc.innerHTML=desc;vDesc.onmouseout=function(){hideFAQDesc();}
vDesc.style.width=300;vDesc.className="portlet-popup3";var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft-80;y=event.clientY+document.body.scrollTop-68;}else{x=e.pageX-80;y=e.pageY-68;}
if(document.all){vDesc.style.posLeft=x;vDesc.style.posTop=y;}else{vDesc.style.left=x;vDesc.style.top=y;}
vDesc.style.zIndex=Light.maxZIndex+1000;vdocument.appendChild(vDesc);vDesc=null;}
hideDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('vDesc');if(old!=null)vdocument.removeChild(old);}
function editMyUrl(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id};createPopupDiv('editMyUrl','editMyUrl.jst',280,data,e,id);}
hideEditMyUrl=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('editMyUrl');if(old!=null)vdocument.removeChild(old);}
function saveMyUrl(id){var uri=document.forms['editMyUrlForm']['uri'].value;if(uri==null||uri.length==0){alert("please input your desired URI.");return;}
var params="uri="+uri+"&id="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.checkMyUrl,{parameters:params,onSuccess:responseCheckMyUrl});}
function responseCheckMyUrl(t){var id=t.responseText;if(id=="-1"){alert("this uri is not available, please input another desired URI.");return;}
var warnyou=confirm("Do you really want to change URL, you only can change one time!");if(!warnyou)
{return;}
var uri=document.forms['editMyUrlForm']['uri'].value;var params="uri="+uri+"&id="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveMyUrl,{parameters:params,onSuccess:responseSaveMyUrl});}
function responseSaveMyUrl(t){var id=t.responseText;var portlet=Light.getPortletById(id);portlet.refresh();hideEditMyUrl();}
function editProfilePhoto(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id};createPopupDiv('editProfilePhoto','editProfilePhoto.jst',300,data,e,id);}
hideEditProfilePhoto=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('editProfilePhoto');if(old!=null)vdocument.removeChild(old);}
function createTopPopupDiv(name,templateName,width,data,e,id){var old=document.getElementById(name);if(old!=null)return;var currentTabId=Light.getCurrentTabId();var vPopupDiv=document.createElement('div');vPopupDiv.id=name;vPopupDiv.style.position="absolute";vPopupDiv.className="portlet-popup";if(width!=null)
vPopupDiv.style.width=width;vPopupDiv.innerHTML=TrimPath.processDOMTemplate(templateName,data);var x=200;var y=200;if(window.event){x=event.clientX+document.body.scrollLeft-80;y=event.clientY+document.body.scrollTop-68;}else if(e!=null){x=e.pageX-80;y=e.pageY-68;}else if(id!=null){portlet=Light.getPortletById(id);if(portlet!=null){x=portlet.left+100;y=portlet.top;}}
if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width;if(x<200)x=200;if(document.all){vPopupDiv.style.posLeft=x;vPopupDiv.style.posTop=y;}else{vPopupDiv.style.left=x;vPopupDiv.style.top=y;}
var zIndex=Light.maxZIndex+1000;vPopupDiv.style.zIndex=zIndex;document.body.appendChild(vPopupDiv);vPopupDiv=null;}
function createPopupDiv(name,templateName,width,data,e,id){var old=document.getElementById(name);if(old!=null)return;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var vPopupDiv=document.createElement('div');vPopupDiv.id=name;vPopupDiv.style.position="absolute";vPopupDiv.className="portlet-popup";if(width!=null)
vPopupDiv.style.width=width;vPopupDiv.innerHTML=TrimPath.processDOMTemplate(templateName,data);var x=200;var y=200;if(window.event){x=event.clientX+document.body.scrollLeft-80;y=event.clientY+document.body.scrollTop-68;}else if(e!=null){x=e.pageX-80;y=e.pageY-68;}else if(id!=null){portlet=Light.getPortletById(id);if(portlet!=null){x=portlet.left+100;y=portlet.top;}}
if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width;if(document.all){vPopupDiv.style.posLeft=x;vPopupDiv.style.posTop=y;}else{vPopupDiv.style.left=x;vPopupDiv.style.top=y;}
var zIndex=Light.maxZIndex+1000;vPopupDiv.style.zIndex=zIndex;vdocument.appendChild(vPopupDiv);vPopupDiv=null;}
function createPopupDiv2(name,width,content,id){var old=document.getElementById(name);if(old!=null)return;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var vPopupDiv=document.createElement('div');vPopupDiv.id=name;vPopupDiv.style.position="absolute";vPopupDiv.className="portlet-popup";if(width!=null)
vPopupDiv.style.width=width;vPopupDiv.innerHTML=content;var x=20;var y=100;if(document.all){vPopupDiv.style.posLeft=x;vPopupDiv.style.posTop=y;}else{vPopupDiv.style.left=x;vPopupDiv.style.top=y;}
var portlet=null;var zIndex=Light.maxZIndex+1000;vPopupDiv.style.zIndex=zIndex;vdocument.appendChild(vPopupDiv);vPopupDiv=null;Light.portal.footer.style.visibility="hidden";}
function hideTopPopupDiv(name){var old=document.getElementById(name);if(old!=null){document.body.removeChild(old);}}
function hidePopupDiv(name){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById(name);if(old!=null){vdocument.removeChild(old);}
Light.portal.footer.style.visibility="visible";}
setColor=function(id,which,color){var portlet=Light.getPortletById(id);if(portlet==null)return;if(which==1){portlet.barBgColor=color;portlet.refreshHeader();}
if(which==2){portlet.barFontColor=color;portlet.refreshHeader();}
if(which==3){portlet.contentBgColor=color;var pcContentBgColor=document.forms['form_'+id];pcContentBgColor.style.background=color;}
if(which==4){portlet.textColor=color;portlet.refreshTextColor();}}
setTransparent=function(id,value){var portlet=Light.getPortletById(id);if(portlet==null)return;if(value.checked)
portlet.transparent=true;else
portlet.transparent=false;portlet.refreshWindowTransparent();}
showMyPicture=function(){var portlet=new PortletPopupWindow(11,280,400,$('_MENU_MY_PICTURE').title,"/light/images/picture.gif","","myPicturePortlet",Light.portal.contextPath+"/myPicturePortlet.lp",true,false,false,false,false,true,true,50,false,'','','',"");portlet.refresh();}
showMyMusic=function(){var portlet=new PortletPopupWindow(11,280,600,$('_MENU_MY_MUSIC').title,"/light/images/music.png","","myMusicPortlet",Light.portal.contextPath+"/myMusicPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
showMyFile=function(){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=null;Light.portal.latestAction.id=null;Light.portal.latestAction.method="showMyFile";Light.portal.login();return;}
var portlet=new PortletPopupWindow(11,280,600,$('_MENU_MY_FILE').title,"/light/images/file.gif","","myFilePortlet",Light.portal.contextPath+"/myFilePortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
showMyFavorites=function(){var portlet=new PortletPopupWindow(11,280,400,$('_MENU_MY_FAVOURITE').title,"/light/images/user.gif","","favouritePortlet",Light.portal.contextPath+"/favouritePortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
showMyBlog=function(){var portlet=new PortletPopupWindow(11,200,500,$('_MENU_MY_BLOG').title,"/light/images/blog.gif","","blogPortlet",Light.portal.contextPath+"/blogPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
showMyViewed=function(){var portlet=new PortletPopupWindow(11,200,500,$('_MENU_MY_VIEWED').title,"/light/images/viewed.gif","","myViewedItemPortlet",Light.portal.contextPath+"/myViewedItemPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
showMyRecommended=function(){var portlet=new PortletPopupWindow(200,500,$('_MENU_MY_RECOMMENDED').title,"/light/images/recommended.gif","","recommendedItemPortlet",Light.portal.contextPath+"/recommendedItemPortlet.lp",true,true,true,false,false,false,false,0,false,'','','',"");portlet.refresh();}
function showAdDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('adDesc');if(old!=null)document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="adDesc";vPopup.style.position="absolute";vPopup.onmouseout=function(){hideAdDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop;}else{x=e.pageX+10;y=e.pageY;}
if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getAdDesc,{parameters:params,onSuccess:responseAdDesc});}
hideAdDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('adDesc');if(old!=null)document.body.removeChild(old);}
function responseAdDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('adDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="adDesc";vPopup.style.position="absolute";vPopup.style.width=500;vPopup.className="portlet-popup";vPopup.onmouseout=function(){hideAdDesc();}
vPopup.innerHTML=desc;if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;}}
function showBlogDesc(e,index,id){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogDesc');if(old!=null)document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="blogDesc";vPopup.style.position="absolute";vPopup.onmouseout=function(){hideBlogDesc();}
var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop;}else{x=e.pageX+10;y=e.pageY;}
if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;var params="index="+index
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getBlogDesc,{parameters:params,onSuccess:responseBlogDesc});}
hideBlogDesc=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogDesc');if(old!=null)document.body.removeChild(old);}
function responseBlogDesc(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogDesc');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=500;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="blogDesc";vPopup.style.position="absolute";vPopup.style.width=width;vPopup.className="portlet-popup";vPopup.onmouseout=function(){hideBlogDesc();}
vPopup.innerHTML=desc;if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;}}
function showBlogDetail(e,index,id){hideBlogDesc();if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('forumDetail');if(old!=null)document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="blogDetail";vPopup.style.position="absolute";var x=0;var y=0;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop;}else{x=e.pageX+10;y=e.pageY;}
x=100;if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;var params="index="+index
+"&responseId="+id
+"&"+portlet.parameter;Light.ajax.sendRequest(Light.portal.contextPath+Light.getBlogDetail,{parameters:params,onSuccess:responseBlogDetail});}
hideBlogDetail=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogDetail');if(old!=null)document.body.removeChild(old);}
function responseBlogDetail(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogDetail');var x=100;var y=100;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=800;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="blogDetail";vPopup.style.position="absolute";vPopup.style.width=width;vPopup.className="portlet-popup2";vPopup.innerHTML=desc;if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;}}
function showBlogComment(e,blogId){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogComments');if(old!=null)document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="blogComments";vPopup.style.position="absolute";var blogDetail=document.getElementById('blogDetail');var x=120;var y=120;if(window.event){y=event.clientY+document.body.scrollTop;}else{y=e.pageY;}
if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;var params="index="+blogId;Light.ajax.sendRequest(Light.portal.contextPath+Light.getBlogComments,{parameters:params,onSuccess:responseBlogComments});}
hideBlogComments=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogComments');if(old!=null)document.body.removeChild(old);}
function responseBlogComments(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogComments');var x=120;var y=120;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="blogComments";vPopup.style.position="absolute";vPopup.style.width=800;vPopup.className="portlet-popup3";vPopup.innerHTML=desc;if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;}}
function popBlog(blogId,portletId){var params="&blogId="+blogId
+"&responseId="+portletId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popBlog,{parameters:params,onSuccess:responsePopBlog});}
function responsePopBlog(t){alert("This Blog has been Poped.");}
function addBlogComment(e,blogId,portletId){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogComment');if(old!=null)document.body.removeChild(old);var blogDetail=document.getElementById('blogDetail');var x=100;var y=100;if(window.event){x=event.clientX+document.body.scrollLeft-300;y=event.clientY+document.body.scrollTop-150;}else{x=e.pageX-300;y=e.pageY-150;}
var width=400;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;var vPopup=document.createElement('span');vPopup.id="blogComment";vPopup.style.position="absolute";vPopup.className="portlet-popup";if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.width=width;var inHtml="<span title='"+$('_CLOSE').title+"'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideBlogComment();'><img src='"+Light.portal.contextPath+"/light/images/close_on.gif' style='border: 0px;'/></a></span>"
+"<form name='blogCommentForm'>"
+"<input type='hidden' name='blogId' value='"+blogId+"'/>"
+"<table border='0' cellpadding='0' cellspacing='0' width='100%' >";if(Light.getCookie(Light._LOGINED_USER_ID)==null||Light.getCookie(Light._LOGINED_USER_ID)==""){inHtml=inHtml+"<tr>"
+"<td class='portlet-table-td-left' >"
+$('_LABEL_NAME').title+":"
+"</td>"
+"<td class='portlet-table-td-left' >"
+"<input type='text' name='userName'  value='' class='portlet-form-input-field' size='18' /> "
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-left' >"
+$('_LABEL_EMAIL').title+":"
+"</td>"
+"<td class='portlet-table-td-left' >"
+"<input type='text' name='email'  value='' class='portlet-form-input-field' size='18' /> "
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-left' >"
+$('_LABEL_URL').title+":"
+"</td>"
+"<td class='portlet-table-td-left' >"
+"<input type='text' name='url'  value='' class='portlet-form-input-field' size='18' /> "
+"</td>"
+"</tr>";}
inHtml=inHtml+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+$('_LABEL_COMMENT').title+":"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+"<textarea name='comment' class='portlet-form-textarea-field' rows='5' cols='48' >"
+"</textarea>"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-right' colspan='2' >"
+"<input type='button' name='action' onClick='javascript:saveBlogComment(\""+portletId+"\");'"
+" value='"+$('_BUTTON_OK').title+"' class='portlet-form-button' />"
+"<input type='button' name='action' onClick='javascript:hideBlogComment();' value='"
+$('_BUTTON_CANCEL').title+"' class='portlet-form-button' />"
+"</td>"
+"</tr>"
+"</table>"
+"</form>";vPopup.innerHTML=inHtml;vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;}
saveBlogComment=function(responseId){var comment=document.forms['blogCommentForm']['comment'].value;if(comment==null||comment.length<=0){alert("Please input blog's comment.");return;}
var blogId=document.forms['blogCommentForm']['blogId'].value;var params="&comment="+comment
+"&blogId="+blogId
+"&responseId="+responseId;if(Light.getCookie(Light._LOGINED_USER_ID)==null||Light.getCookie(Light._LOGINED_USER_ID)==""){var userName=document.forms['blogCommentForm']['userName'].value;var email=document.forms['blogCommentForm']['email'].value;var url=document.forms['blogCommentForm']['url'].value;params=params+"&userName="+userName
+"&email="+email
+"&url="+url;}
Light.ajax.sendRequest(Light.portal.contextPath+Light.saveBlogComment,{parameters:params,onSuccess:responseBlogComment});}
function responseBlogComment(t){var responseId=t.responseText;var portlet=Light.getPortletById(responseId);if(portlet!=null)portlet.refresh();hideBlogComment();}
hideBlogComment=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('blogComment');if(old!=null)document.body.removeChild(old);}
function showAdComment(e,adId){if(Light.portal==null)return;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('adComments');if(old!=null)document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="adComments";vPopup.style.position="absolute";var x=120;var y=120;if(window.event){y=event.clientY+document.body.scrollTop;}else{y=e.pageY;}
if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;var params="index="+adId;Light.ajax.sendRequest(Light.portal.contextPath+Light.getAdComments,{parameters:params,onSuccess:responseAdComments});}
hideAdComments=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('adComments');if(old!=null)document.body.removeChild(old);}
function responseAdComments(t){var desc=t.responseText;var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('adComments');var x=120;var y=120;if(old!=null){if(document.all){x=old.style.posLeft;y=old.style.posTop;}else{x=old.style.left;y=old.style.top;}
var width=800;if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;if(x<=0)x=10;document.body.removeChild(old);var vPopup=document.createElement('div');vPopup.id="adComments";vPopup.style.position="absolute";vPopup.style.width=800;vPopup.className="portlet-popup3";vPopup.innerHTML=desc;if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;}}
function popAd(adId,portletId){var params="&adId="+adId
+"&responseId="+portletId;Light.ajax.sendRequest(Light.portal.contextPath+Light.popAd,{parameters:params,onSuccess:responsePopAd});}
function responsePopAd(t){alert("This Ad has been Poped.");}
function addAdComment(e,adId,portletId){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('adComment');if(old!=null)document.body.removeChild(old);var x=100;var y=100;if(window.event){x=event.clientX+document.body.scrollLeft;y=event.clientY+document.body.scrollTop;}else{x=e.pageX;y=e.pageY;}
var vPopup=document.createElement('span');vPopup.id="adComment";vPopup.style.position="absolute";vPopup.className="portlet-popup";if(document.all){vPopup.style.posLeft=x;vPopup.style.posTop=y;}else{vPopup.style.left=x;vPopup.style.top=y;}
vPopup.style.width=400;var inHtml="<span title='"+$('_CLOSE').title+"'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideBlogComment();'><img src='"+Light.portal.contextPath+"/light/images/close_on.gif' style='border: 0px;'/></a></span>"
+"<form name='adCommentForm'>"
+"<input type='hidden' name='adId' value='"+adId+"'/>"
+"<table border='0' cellpadding='0' cellspacing='0' >"
+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+$('_LABEL_COMMENT').title+":"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+"<textarea name='comment' class='portlet-form-textarea-field' rows='5' cols='60' >"
+"</textarea>"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-right' colspan='2' >"
+"<input type='button' name='action' onClick='javascript:saveAdComment(\""+portletId+"\");'"
+" value='"+$('_BUTTON_OK').title+"' class='portlet-form-button' />"
+"<input type='button' name='action' onClick='javascript:hideAdComment();' value='"
+$('_BUTTON_CANCEL').title+"' class='portlet-form-button' />"
+"</td>"
+"</tr>"
+"</table>"
+"</form>";vPopup.innerHTML=inHtml;vPopup.style.zIndex=Light.maxZIndex+1000;document.body.appendChild(vPopup);vPopup=null;}
saveAdComment=function(responseId){var comment=document.forms['adCommentForm']['comment'].value;if(comment==null||comment.length<=0){alert("Please input Ad's comment.");return;}
var adId=document.forms['adCommentForm']['adId'].value;var params="&comment="+comment
+"&adId="+adId
+"&responseId="+responseId;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveAdComment,{parameters:params,onSuccess:responseAdComment});}
function responseAdComment(t){var responseId=t.responseText;var portlet=Light.getPortletById(responseId);if(portlet!=null)portlet.refresh();hideAdComment();}
hideAdComment=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('adComment');if(old!=null)document.body.removeChild(old);}
function validateGroup(form){var displayName=form['displayName'].value;var country=form['country'].value;var province=form['province'].value;var city=form['city'].value;var shortDesc=form['shortDesc'].value;var uri=form['uri'].value;var returnval;if(displayName!=null&&displayName.length>0&&country!=null&&country.length>0&&province!=null&&province.length>0&&city!=null&&city.length>0&&shortDesc!=null&&shortDesc.length>0&&uri!=null&&uri.length>0)
returnval=true;else
{alert("All * fields are required.");returnval=false;}
return returnval;}
function validateGroupUri(uri){var params="uri="+uri;Light.ajax.sendRequest(Light.portal.contextPath+Light.validateGroupUri,{parameters:params,onSuccess:responseValidateGroupUri});}
function responseValidateGroupUri(t){var returnValue=t.responseText;if(returnValue!=0){alert("This Group URI is not available, please try a new URI.");}}
function joinToGroup(e,groupId,responseId){var params="groupId="+groupId+"&responseId="+responseId;Light.ajax.sendRequest(Light.portal.contextPath+Light.joinToGroup,{parameters:params,onSuccess:responseJoinToGroup});}
function responseJoinToGroup(t){var params=t.responseText.split(";");if(params[0]=='1'){var data={title:$('_CLOSE').title,popupName:'joinToGroup'};createPopupDiv('joinToGroup','joinToGroup1.jst',280,data,null,params[1]);}
if(params[0]=='2'){var data={title:$('_CLOSE').title,popupName:'joinToGroup'};createPopupDiv('joinToGroup','joinToGroup2.jst',280,data,null,params[1]);}
if(params[0]=='0'){var data={title:$('_CLOSE').title,popupName:'joinToGroup'};createPopupDiv('joinToGroup','joinToGroup0.jst',280,data,null,params[1]);}}
function selectInvitedFriends(id){var listField=document.forms['form_'+id]['from'];if(listField.length==-1){alert("There are no friends which can be removed from invited list!");}else{var selected=listField.selectedIndex;if(selected==-1){alert("You must select an friend to be removed!");}else{newValue=listField.options[selected].value;newText=listField.options[selected].text;var replaceTextArray=new Array(listField.length-1);var replaceValueArray=new Array(listField.length-1);for(var i=0;i<listField.length;i++){if(i<selected){replaceTextArray[i]=listField.options[i].text;}
if(i>selected){replaceTextArray[i-1]=listField.options[i].text;}
if(i<selected){replaceValueArray[i]=listField.options[i].value;}
if(i>selected){replaceValueArray[i-1]=listField.options[i].value;}}
listField.length=replaceTextArray.length;for(i=0;i<replaceTextArray.length;i++){listField.options[i].value=replaceValueArray[i];listField.options[i].text=replaceTextArray[i];}
var len=document.forms['form_'+id]['to'].length++;document.forms['form_'+id]['to'].options[len].value=newValue;document.forms['form_'+id]['to'].options[len].text=newText;}}}
function unselectInvitedFriends(id){var listField=document.forms['form_'+id]['to'];if(listField.length==-1){alert("There are no friends which can be removed from invited list!");}else{var selected=listField.selectedIndex;if(selected==-1){alert("You must select an friend to be removed!");}else{newValue=listField.options[selected].value;newText=listField.options[selected].text;var replaceTextArray=new Array(listField.length-1);var replaceValueArray=new Array(listField.length-1);for(var i=0;i<listField.length;i++){if(i<selected){replaceTextArray[i]=listField.options[i].text;}
if(i>selected){replaceTextArray[i-1]=listField.options[i].text;}
if(i<selected){replaceValueArray[i]=listField.options[i].value;}
if(i>selected){replaceValueArray[i-1]=listField.options[i].value;}}
listField.length=replaceTextArray.length;for(i=0;i<replaceTextArray.length;i++){listField.options[i].value=replaceValueArray[i];listField.options[i].text=replaceTextArray[i];}
var len=document.forms['form_'+id]['from'].length++;document.forms['form_'+id]['from'].options[len].value=newValue;document.forms['form_'+id]['from'].options[len].text=newText;}}}
function inviteToGroup(e,id){var params="groupId="+document.forms['form_'+id]['groupId'].value+"&responseId="+id;var len=document.forms['form_'+id]['to'].length;if(len<=0){alert("You have to choose your friends first.");return;}
var friends="";for(var i=0;i<len;i++){friends+=document.forms['form_'+id]['to'][i].value+";"}
params+="&friends="+friends;Light.ajax.sendRequest(Light.portal.contextPath+Light.inviteToGroup,{parameters:params,onSuccess:responseInviteToGroup});}
function responseInviteToGroup(t){var params=t.responseText.split(";");var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,friendsName:params[0],popupName:'inviteToGroup'};createPopupDiv('inviteToGroup','inviteToGroup.jst',280,data,null,params[1]);var portlet=Light.getPortletById(params[1]);if(portlet!=null)portlet.close(true);}
function viewGroupPictures(e,groupId,id){var portlet=new PortletPopupWindow(11,300,400,$('_MENU_GROUP_PICTURES').title,"","","groupPicturePortlet",Light.portal.contextPath+"/groupPicturePortlet.lp",true,false,false,false,false,true,true,10000,false,'','','',"groupId="+groupId);portlet.refresh();}
function viewGroupMembers(e,groupId,id){var portlet=new PortletPopupWindow(11,300,400,$('_MENU_GROUP_MEMBERS').title,"","","groupMembersPortlet",Light.portal.contextPath+"/groupMembersPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"groupId="+groupId);portlet.refresh();}
function viewGroupBulletins(e,groupId,id){var portlet=new PortletPopupWindow(11,300,400,$('_MENU_GROUP_BULLETIN').title,"","","groupBulletinPortlet",Light.portal.contextPath+"/groupBulletinPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"groupId="+groupId);portlet.refresh();}
function inviteOthers(e,groupId,id){var portlet=new PortletPopupWindow(11,300,400,$('_MENU_GROUP_INVITE').title,"","","groupInvitePortlet",Light.portal.contextPath+"/groupInvitePortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"groupId="+groupId);portlet.refresh();}
function resign(e,groupId,id){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,popupName:'resign',responseId:id,groupId:groupId};createPopupDiv('resign','resign.jst',280,data,e,id);}
function resignGroup(groupId,responseId){var params="groupId="+groupId+"&responseId="+responseId;Light.ajax.sendRequest(Light.portal.contextPath+Light.resignGroup,{parameters:params,onSuccess:responseResignGroup});}
function editGroupProfile(e,groupId,id){var portlet=new PortletPopupWindow(11,300,500,$('_MENU_GROUP_EDIT').title,"","","groupEditPortlet",Light.portal.contextPath+"/groupEditPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"groupId="+groupId);portlet.refresh();}
function deleteGroupProfile(e,groupId,name,id){var data={title:$('_CLOSE').title,ok:$('_BUTTON_DELETE').title,cancel:$('_BUTTON_CANCEL').title,popupName:'deleteGroupProfile',responseId:id,groupId:groupId,groupName:name};createPopupDiv('deleteGroupProfile','deleteGroupProfile.jst',280,data,e,id);}
function confirmDeleteGroupProfile(groupId,responseId){var params="&groupId="+groupId+"&responseId"+responseId;Light.ajax.sendRequest(Light.portal.contextPath+Light.deleteGroupProfile,{parameters:params,onSuccess:responseDeleteGroupProfile});}
function showInstantMessageMember(e,userId,responseId){var params="&userId="+userId+"&responseId"+responseId;Light.ajax.sendRequest(Light.portal.contextPath+Light.chatWithMember,{parameters:params,onSuccess:responseChatWithMember});}
responseChatWithMember=function(t){var chatParams=t.responseText.split(",");if(chatParams[1]==0){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,userName:chatParams[0],popupName:'isBlockUser'};createPopupDiv('isBlockUser','isBlockUser.jst',360,data,null,null);return;}
if(chatParams[1]=="n"){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,userName:chatParams[0],popupName:'noIM'};createPopupDiv('noIM','noIM.jst',360,data,null,null);return;}
if(chatParams[1]=="f"){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,userName:chatParams[0],popupName:'friendOnlyIM'};createPopupDiv('friendOnlyIM','friendOnlyIM.jst',360,data,null,null);return;}
var currentTab=Light.getCurrentTab();var portlet=new PortletChatWindow(currentTab.index,0,11,$('_TITLE_CHAT').title+chatParams[0],"","","chattingPortlet",Light.portal.contextPath+"/chattingPortlet.lp",true,false,false,false,false,true,5000,true,'','','',"chattingId="+chatParams[1]);var id=Light._PC_PREFIX+vPortlet.serverId;var params="responseId="+id
+"&tabId="+currentTab.tabServerId
+"&portletId="+portlet.serverId
+"&"+portlet.parameter;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:params});document.forms['form_'+Light._PC_PREFIX+vPortlet.serverId]['chat'].focus();}
showSendMessageMember=function(id,buddyId,buddyName,e){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id,popupName:'sendMessage',buddyId:buddyId,buddyName:buddyName};createPopupDiv('sendMessage','sendMessage.jst',400,data,e,id);}
viewPicture=function(id,pictureUrl,caption,pictureId,width,height){picSpan=document.getElementById("picture_"+id);var data={id:id,url:Light.portal.contextPath+pictureUrl,caption:caption,width:width,height:height};var portlet=Light.getPortletById(id);portlet.parameter="pictureId="+pictureId;picSpan.innerHTML=TrimPath.processDOMTemplate("viewPicture.jst",data);}
function createPopupPic(name,templateName,width,data,e,id){var old=document.getElementById(name);if(old!=null)hidePopupDiv(name);var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var vPopupDiv=document.createElement('div');vPopupDiv.id=name;vPopupDiv.style.position="absolute";vPopupDiv.className="portlet-popup4";if(width!=null)
vPopupDiv.style.width=width;var portlet=Light.getPortletById(id);if(portlet.myPictures[data.url]!=null){portlet.myPictures[data.url].width=data.width;portlet.myPictures[data.url].height=data.height;portlet.myPictures[data.url].style.cursor="url('light/images/zoomout.cur'), pointer";vPopupDiv.appendChild(portlet.myPictures[data.url]);vPopupDiv.innerHTML+="<br/>"+data.caption;}else
vPopupDiv.innerHTML=TrimPath.processDOMTemplate(templateName,data);var x=200;var y=200;if(window.event){x=event.clientX+document.body.scrollLeft+10;y=event.clientY+document.body.scrollTop-300;}else if(e!=null){x=e.pageX+10;y=e.pageY-300;}else if(id!=null){portlet=Light.getPortletById(id);x=portlet.left+100;y=portlet.top+50;}
if(parseInt(x)+width>document.body.clientWidth)
x=parseInt(x)-width-150;if(x<0)x=200;if(document.all){vPopupDiv.style.posLeft=x;vPopupDiv.style.posTop=y;}else{vPopupDiv.style.left=x;vPopupDiv.style.top=y;}
var portlet=null;var zIndex=Light.maxZIndex+1000;vPopupDiv.style.zIndex=zIndex;vPopupDiv.onmouseover=function(e){this.style.border='2px solid #83C2CD';}
vPopupDiv.onmouseout=function(e){this.style.border='';;}
vPopupDiv.onclick=function(e){hidePopupDiv(name);}
vdocument.appendChild(vPopupDiv);vPopupDiv=null;}
viewMaxPictureAtClient=function(e,id,pictureId,pictureUrl,caption,width,height){var data={title:$('_CLOSE').title,id:id,url:pictureUrl,caption:caption,width:width,height:height,popupName:'viewMaxPicture'};createPopupPic('viewMaxPicture','viewMaxPicture.jst',width,data,e,id);}
viewMaxPictureAtClientById=function(e,id){var portlet=Light.getPortletById(id);var pic=document.getElementById("userPicture_"+portlet.myPictureIndex);var params=pic.name.split(";");var data={title:$('_CLOSE').title,id:id,url:params[5],caption:pic.value,width:params[3],height:params[4],popupName:'viewMaxPicture'};createPopupPic('viewMaxPicture','viewMaxPicture.jst',params[3],data,e,id);}
viewGroupPicture=function(id,groupId,pictureUrl,caption,pictureId,width,height){picSpan=document.getElementById("picture_"+id);var data={id:id,url:Light.portal.contextPath+pictureUrl,caption:caption,width:width,height:height};var portlet=Light.getPortletById(id);portlet.parameter="pictureId="+pictureId+"&groupId="+groupId;picSpan.innerHTML=TrimPath.processDOMTemplate("viewPicture.jst",data);}
viewMaxGroupPictureAtClient=function(e,id,pictureId,pictureUrl,caption,width,height){var data={title:$('_CLOSE').title,id:id,url:Light.portal.contextPath+pictureUrl,caption:caption,width:width,height:height,popupName:'viewMaxPicture'};createPopupPic('viewMaxPicture','viewMaxPicture.jst',width,data,e,id);}
saveNote=function(id){var content=document.forms['form_'+id]['content'].value;var params="content="+encodeURIComponent(content);Light.ajax.sendRequest(Light.portal.contextPath+Light.saveNote,{parameters:params,onSuccess:null});}
changeNoteRow=function(e,id){var note=document.forms['form_'+id]['content'];var content=note.value;var row=parseInt(content.length/note.cols);for(var i=0;i<content.length;i++){if(content.charAt(i)=='\n')row++;}
note.rows=row+2;var portlet=Light.getPortletById(id);Light.getCurrentTab().rePositionPortlets(portlet);}
function configNote(id){var title=document.forms['form_'+id]['pcTitle'].value;var barBgColor=document.forms['form_'+id]['pcBarBgColor'].value;var barFontColor=document.forms['form_'+id]['pcBarFontColor'].value;var contentBgColor=document.forms['form_'+id]['pcContentBgColor'].value;var textColor=document.forms['form_'+id]['pcTextColor'].value;var portlet=Light.getPortletById(id);portlet.title=title;portlet.barBgColor=barBgColor;portlet.barFontColor=barFontColor;portlet.contentBgColor=contentBgColor;portlet.refreshWindow();portlet.mode=Light._VIEW_MODE;portlet.refreshButtons();var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=config"
+"&title="+encodeURIComponent(title)
+"&barBgColor="+barBgColor
+"&barFontColor="+barFontColor
+"&contentBgColor="+contentBgColor
+"&textColor="+textColor;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function resetNote(id){var title=document.forms['form_'+id]['pcTitle'].value;var portlet=Light.getPortletById(id);portlet.title=title;portlet.barBgColor="";portlet.barFontColor="";portlet.contentBgColor="";portlet.refreshWindow();portlet.mode=Light._VIEW_MODE;portlet.refreshButtons();var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=reset"
+"&title="+encodeURIComponent(title);Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function changeEmailConfig(form){if(form['incomingType'].value=="pop3"){if(form['incomingSSL'].checked)
form['incomingPort'].value=995;else
form['incomingPort'].value=110;}else{if(form['incomingSSL'].checked)
form['incomingPort'].value=993;else
form['incomingPort'].value=143;}
if(form['outgoingSSL'].checked)
form['outgoingPort'].value=465;else
form['outgoingPort'].value=25;}
function addChannelColumn0(id){var refs=document.forms['form_'+id]['refs'];var portlets=document.forms['form_'+id]['portlets0'];var len=refs.length;for(var i=0;i<len;i++){if(refs.options[i].selected){aText=refs.options[i].text;aValue=refs.options[i].value;var newOpt=new Option(aText,aValue);var selLength=portlets.length;portlets.options[selLength]=newOpt;refs.options[i].selected=false;}}}
function delChannelColumn0(id){var portlets=document.forms['form_'+id]['portlets0'];var len=portlets.length;for(var i=0;i<len;i++){if(portlets.options[i].selected){portlets.options[i]=null;}}}
function upChannelColumn0(id){var portlets=document.forms['form_'+id]['portlets0'];var len=portlets.length;var move=0;var index=0;var allOptions=new Array();for(var i=0;i<len;i++){allOptions[i]=portlets.options[i];if(portlets.options[i].selected){index=i;}}
if(index>0){var optionUp=portlets.options[index];var index2=0;for(var j=index-1;j>=0;j--){if(portlets.options[j]!=null){index2=j;move=1;break;}}}
if(move==1){for(var k=0;k<len;k++){if(k==index){portlets.options[k]=allOptions[index2];}else if(k==index2){portlets.options[k]=allOptions[index];}else{portlets.options[k]=allOptions[k];}}}}
function downChannelColumn0(id){var portlets=document.forms['form_'+id]['portlets0'];var len=portlets.length;var move=0;var index=0;var allOptions=new Array();for(var i=0;i<len;i++){allOptions[i]=portlets.options[i];if(portlets.options[i].selected){index=i;}}
if(index<len-1){var index2=0;for(var j=index+1;j<len;j++){if(portlets.options[j]!=null){index2=j;move=1;break;}}}
if(move==1){for(var k=0;k<len;k++){if(k==index){portlets.options[k]=allOptions[index2];}else if(k==index2){portlets.options[k]=allOptions[index];}else{portlets.options[k]=allOptions[k];}}}}
function addChannelColumn1(id){var refs=document.forms['form_'+id]['refs'];var portlets=document.forms['form_'+id]['portlets1'];var len=refs.length;for(var i=0;i<len;i++){if(refs.options[i].selected){aText=refs.options[i].text;aValue=refs.options[i].value;var newOpt=new Option(aText,aValue);var selLength=portlets.length;portlets.options[selLength]=newOpt;refs.options[i].selected=false;}}}
function delChannelColumn1(id){var portlets=document.forms['form_'+id]['portlets1'];var len=portlets.length;for(var i=0;i<len;i++){if(portlets.options[i].selected){portlets.options[i]=null;}}}
function upChannelColumn1(id){var portlets=document.forms['form_'+id]['portlets1'];var len=portlets.length;var move=0;var index=0;var allOptions=new Array();for(var i=0;i<len;i++){allOptions[i]=portlets.options[i];if(portlets.options[i].selected){index=i;}}
if(index>0){var optionUp=portlets.options[index];var index2=0;for(var j=index-1;j>=0;j--){if(portlets.options[j]!=null){index2=j;move=1;break;}}}
if(move==1){for(var k=0;k<len;k++){if(k==index){portlets.options[k]=allOptions[index2];}else if(k==index2){portlets.options[k]=allOptions[index];}else{portlets.options[k]=allOptions[k];}}}}
function downChannelColumn1(id){var portlets=document.forms['form_'+id]['portlets1'];var len=portlets.length;var move=0;var index=0;var allOptions=new Array();for(var i=0;i<len;i++){allOptions[i]=portlets.options[i];if(portlets.options[i].selected){index=i;}}
if(index<len-1){var index2=0;for(var j=index+1;j<len;j++){if(portlets.options[j]!=null){index2=j;move=1;break;}}}
if(move==1){for(var k=0;k<len;k++){if(k==index){portlets.options[k]=allOptions[index2];}else if(k==index2){portlets.options[k]=allOptions[index];}else{portlets.options[k]=allOptions[k];}}}}
function addChannelColumn2(id){var refs=document.forms['form_'+id]['refs'];var portlets=document.forms['form_'+id]['portlets2'];var len=refs.length;for(var i=0;i<len;i++){if(refs.options[i].selected){aText=refs.options[i].text;aValue=refs.options[i].value;var newOpt=new Option(aText,aValue);var selLength=portlets.length;portlets.options[selLength]=newOpt;refs.options[i].selected=false;}}}
function delChannelColumn2(id){var portlets=document.forms['form_'+id]['portlets2'];var len=portlets.length;for(var i=0;i<len;i++){if(portlets.options[i].selected){portlets.options[i]=null;}}}
function upChannelColumn2(id){var portlets=document.forms['form_'+id]['portlets2'];var len=portlets.length;var move=0;var index=0;var allOptions=new Array();for(var i=0;i<len;i++){allOptions[i]=portlets.options[i];if(portlets.options[i].selected){index=i;}}
if(index>0){var optionUp=portlets.options[index];var index2=0;for(var j=index-1;j>=0;j--){if(portlets.options[j]!=null){index2=j;move=1;break;}}}
if(move==1){for(var k=0;k<len;k++){if(k==index){portlets.options[k]=allOptions[index2];}else if(k==index2){portlets.options[k]=allOptions[index];}else{portlets.options[k]=allOptions[k];}}}}
function downChannelColumn2(id){var portlets=document.forms['form_'+id]['portlets2'];var len=portlets.length;var move=0;var index=0;var allOptions=new Array();for(var i=0;i<len;i++){allOptions[i]=portlets.options[i];if(portlets.options[i].selected){index=i;}}
if(index<len-1){var index2=0;for(var j=index+1;j<len;j++){if(portlets.options[j]!=null){index2=j;move=1;break;}}}
if(move==1){for(var k=0;k<len;k++){if(k==index){portlets.options[k]=allOptions[index2];}else if(k==index2){portlets.options[k]=allOptions[index];}else{portlets.options[k]=allOptions[k];}}}}
function saveChannel(id){var channel=document.forms['form_'+id]['channel'].value;var region=document.forms['form_'+id]['region'].value;var portlets0=document.forms['form_'+id]['portlets0'];var portlets1=document.forms['form_'+id]['portlets1'];var portlets2=document.forms['form_'+id]['portlets2'];var name0="";for(var i=0;i<portlets0.length;i++){if(name0=="")
name0=portlets0.options[i].value;else
name0=name0+"#"+portlets0.options[i].value;}
var name1="";for(var i=0;i<portlets1.length;i++){if(name1=="")
name1=portlets1.options[i].value;else
name1=name1+"#"+portlets1.options[i].value;}
var name2="";for(var i=0;i<portlets2.length;i++){if(name2=="")
name2=portlets2.options[i].value;else
name2=name2+"#"+portlets2.options[i].value;}
var portlet=Light.getPortletById(id);var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=save"
+"&channel="+channel
+"&region="+region
+"&name0="+name0
+"&name1="+name1
+"&name2="+name2;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
function popupToDo(id){var portlet=new PortletPopupWindow(11,150,400,$('_MENU_TODO').title,"/light/images/todolist.gif","","todoListPortlet",Light.portal.contextPath+"/todoListPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
function popupCalendar(id){var portlet=new PortletPopupWindow(11,150,600,$('_MENU_CALENDAR').title,"/light/images/calendar.gif","","calendarPortlet",Light.portal.contextPath+"/calendarPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
function validateCalendarEvent(form){if(form.name.value==null||form.name.value.length<=0){alert(" Please input event name first.");return false;}else
return true;}
function validateTodo(form){if(form.name.value==null||form.name.value.length<=0){alert(" Please input event name first.");return false;}else
return true;}
function validateBlogAction(form){if(document.pressed=="delete"){var confirmDelete=confirm($('_DELETE_BLOG').title);if(!confirmDelete)
return false;else
return true;}
return true;}
function editPortletRef(id){var refs=document.forms['form_'+id]['refs'];var len=refs.length;for(var i=0;i<len;i++){if(refs.options[i].selected){aText=refs.options[i].text;aValue=refs.options[i].value;var portlet=Light.getPortletById(id);Light.ajax.sendRequest(portlet.request,"responseId="+id,"tabId="+Light.getCurrentTab().tabServerId,"portletId="+portlet.serverId,"mode=edit","name="+aValue);break;}}}
function beforeUpload(id){var portlet=Light.getPortletById(id);portlet.rememberMode(0);return true;}
function startCallback(id){var portlet=Light.getPortletById(id);portlet.mode=Light._VIEW_MODE;portlet.refreshButtons();portlet.lastAction=null;portlet.rememberMode(0);return true;}
function completeCallback(id){var portlet=Light.getPortletById(id);portlet.refresh();hideEditProfilePhoto();hideTopPopupDiv("addFeed");hideTopPopupDiv("addAllFeed");}
function showAddItemComments(e,id,itemId){var userId=Light.getCookie(Light._LOGINED_USER_ID);var currentTabId=Light.getCurrentTabId();var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('comment');if(old!=null)vdocument.removeChild(old);var vPopupDiv=document.createElement('div');vPopupDiv.id="comment";vPopupDiv.style.width=360;vPopupDiv.style.position="absolute";vPopupDiv.className="portlet-popup";var x=200;var y=200;if(window.event){x=event.clientX+document.body.scrollLeft;y=event.clientY+document.body.scrollTop-150;}else if(e!=null){x=e.pageX;y=e.pageY-150;}
if(document.all){vPopupDiv.style.posLeft=x;vPopupDiv.style.posTop=y;}else{vPopupDiv.style.left=x;vPopupDiv.style.top=y;}
var inHtml="<span title='"+$('_CLOSE').title+"'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideAddComment();'><img src='"+Light.portal.contextPath+"/light/images/close_on.gif' style='border: 0px;'/></a></span>"
+"<form name='addCommentForm'>"
+"<table border='0' cellpadding='0' cellspacing='0' >"
+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+$('_LABEL_COMMENT').title+":"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+"<textarea name='comment' class='portlet-form-textarea-field' rows='5' cols='50' >"
+"</textarea>"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-right' colspan='2' >"
+"<input type='button' name='action' onClick='javascript:saveComment(\""+id+"\",\""+itemId+"\");'"
+" value='"+$('_BUTTON_OK').title+"' class='portlet-form-button' />"
+"<input type='button' name='action' onClick='javascript:hideAddComment();' value='"
+$('_BUTTON_CANCEL').title+"' class='portlet-form-button' />"
+"</td>"
+"</tr>"
+"</table>"
+"</form>";vPopupDiv.innerHTML=inHtml;vPopupDiv.style.zIndex=Light.maxZIndex;vdocument.appendChild(vPopupDiv);vPopupDiv=null;}
saveComment=function(id,itemId){var comment=document.forms['addCommentForm']['comment'].value;if(comment==null||comment.length<=0){alert("Please input comment.");return;}
var params="comment="+comment
+"&itemId="+itemId
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveItemComment,{parameters:params,onSuccess:responseSaveComment});}
function responseSaveComment(t){var id=t.responseText;var portlet=Light.getPortletById(id);if(portlet!=null)portlet.refresh();hideAddComment();}
hideAddComment=function(){var currentTabId=Light.getCurrentTabId();var vdocument=document.getElementById('panel_'+currentTabId);var old=document.getElementById('comment');if(old!=null)vdocument.removeChild(old);}
deleteKeywords=function(id){var keywords=document.forms['form_'+id]['keywords'];var len=keywords.length;var words="";var deleted=0;for(var i=0;i<len;i++){if(keywords.options[i].selected){aValue=keywords.options[i].value;words+=aValue+",";deleted++;}}
if(deleted>0){var params="words="+words
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.deleteKeywords,{parameters:params,onSuccess:responseKeywords});}else{alert("Please select keywords which you want to delete first.");}}
function responseKeywords(t){var id=t.responseText;var portlet=Light.getPortletById(id);if(portlet!=null)portlet.refresh();}
function addKeywords(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,id:id,popupName:'addKeywords'};createPopupDiv('addKeywords','addKeywords.jst',400,data,e,id);}
function saveKeywords(id){var keyword1=document.forms['myKeywordsForm']['keyword1'].value;var keyword2=document.forms['myKeywordsForm']['keyword2'].value;var keyword3=document.forms['myKeywordsForm']['keyword3'].value;var keyword4=document.forms['myKeywordsForm']['keyword4'].value;var keyword5=document.forms['myKeywordsForm']['keyword5'].value;var keyword6=document.forms['myKeywordsForm']['keyword6'].value;var keyword7=document.forms['myKeywordsForm']['keyword7'].value;var keyword8=document.forms['myKeywordsForm']['keyword8'].value;var keyword9=document.forms['myKeywordsForm']['keyword9'].value;var keyword10=document.forms['myKeywordsForm']['keyword10'].value;var words="";if(keyword1!=null&&keyword1.length>0)words+=keyword1+",";if(keyword2!=null&&keyword2.length>0)words+=keyword2+",";if(keyword3!=null&&keyword3.length>0)words+=keyword3+",";if(keyword4!=null&&keyword4.length>0)words+=keyword4+",";if(keyword5!=null&&keyword5.length>0)words+=keyword5+",";if(keyword6!=null&&keyword6.length>0)words+=keyword6+",";if(keyword7!=null&&keyword7.length>0)words+=keyword7+",";if(keyword8!=null&&keyword8.length>0)words+=keyword8+",";if(keyword9!=null&&keyword9.length>0)words+=keyword9+",";if(keyword10!=null&&keyword10.length>0)words+=keyword10;if(words.length>0){var params="words="+words
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.addKeywords,{parameters:params,onSuccess:responseKeywords});hidePopupDiv('addKeywords');}else{alert("Please input keywords first.");}}
deleteNotKeywords=function(id){var keywords=document.forms['form_'+id]['keywords'];var len=keywords.length;var words="";var deleted=0;for(var i=0;i<len;i++){if(keywords.options[i].selected){aValue=keywords.options[i].value;words+=aValue+",";deleted++;}}
if(deleted>0){var params="words="+words
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.deleteNotKeywords,{parameters:params,onSuccess:responseKeywords});}else{alert("Please select keywords which you want to delete first.");}}
deleteNotWords=function(id){var keywords=document.forms['form_'+id]['words'];var len=keywords.length;var words="";var deleted=0;for(var i=0;i<len;i++){if(keywords.options[i].selected){aValue=keywords.options[i].value;words+=aValue+"A";deleted++;}}
if(deleted>0){var params="words="+words
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.deleteNotWords,{parameters:params,onSuccess:responseKeywords});}else{alert("Please select words which you want to delete first.");}}
function addNotKeywords(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,id:id,popupName:'addNotKeywords'};createPopupDiv('addNotKeywords','addNotKeywords.jst',400,data,e,id);}
function saveNotKeywords(id){var keyword1=document.forms['myNotKeywordsForm']['keyword1'].value;var keyword2=document.forms['myNotKeywordsForm']['keyword2'].value;var keyword3=document.forms['myNotKeywordsForm']['keyword3'].value;var keyword4=document.forms['myNotKeywordsForm']['keyword4'].value;var keyword5=document.forms['myNotKeywordsForm']['keyword5'].value;var keyword6=document.forms['myNotKeywordsForm']['keyword6'].value;var keyword7=document.forms['myNotKeywordsForm']['keyword7'].value;var keyword8=document.forms['myNotKeywordsForm']['keyword8'].value;var keyword9=document.forms['myNotKeywordsForm']['keyword9'].value;var keyword10=document.forms['myNotKeywordsForm']['keyword10'].value;var words="";if(keyword1!=null&&keyword1.length>0)words+=keyword1+",";if(keyword2!=null&&keyword2.length>0)words+=keyword2+",";if(keyword3!=null&&keyword3.length>0)words+=keyword3+",";if(keyword4!=null&&keyword4.length>0)words+=keyword4+",";if(keyword5!=null&&keyword5.length>0)words+=keyword5+",";if(keyword6!=null&&keyword6.length>0)words+=keyword6+",";if(keyword7!=null&&keyword7.length>0)words+=keyword7+",";if(keyword8!=null&&keyword8.length>0)words+=keyword8+",";if(keyword9!=null&&keyword9.length>0)words+=keyword9+",";if(keyword10!=null&&keyword10.length>0)words+=keyword10;if(words.length>0){var params="words="+words
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.addNotKeywords,{parameters:params,onSuccess:responseKeywords});hidePopupDiv('addNotKeywords');}else{alert("Please input keywords first.");}}
function addNotWords(e,id){var portlet=Light.getPortletById(id);if(portlet==null)return;var data={title:$('_CLOSE').title,id:id,popupName:'addNotWords'};createPopupDiv('addNotWords','addNotWords.jst',400,data,e,id);}
function saveNotWords(id){var keyword1=document.forms['myNotWordsForm']['keyword1'].value;var keyword2=document.forms['myNotWordsForm']['keyword2'].value;var keyword3=document.forms['myNotWordsForm']['keyword3'].value;var keyword4=document.forms['myNotWordsForm']['keyword4'].value;var keyword5=document.forms['myNotWordsForm']['keyword5'].value;var keyword6=document.forms['myNotWordsForm']['keyword6'].value;var keyword7=document.forms['myNotWordsForm']['keyword7'].value;var keyword8=document.forms['myNotWordsForm']['keyword8'].value;var keyword9=document.forms['myNotWordsForm']['keyword9'].value;var keyword10=document.forms['myNotWordsForm']['keyword10'].value;var words="";if(keyword1!=null&&keyword1.length>0)words+=keyword1+"A";if(keyword2!=null&&keyword2.length>0)words+=keyword2+"A";if(keyword3!=null&&keyword3.length>0)words+=keyword3+"A";if(keyword4!=null&&keyword4.length>0)words+=keyword4+"A";if(keyword5!=null&&keyword5.length>0)words+=keyword5+"A";if(keyword6!=null&&keyword6.length>0)words+=keyword6+"A";if(keyword7!=null&&keyword7.length>0)words+=keyword7+"A";if(keyword8!=null&&keyword8.length>0)words+=keyword8+"A";if(keyword9!=null&&keyword9.length>0)words+=keyword9+"A";if(keyword10!=null&&keyword10.length>0)words+=keyword10;if(words.length>0){var params="words="+words
+"&responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.addNotWords,{parameters:params,onSuccess:responseKeywords});hidePopupDiv('addNotWords');}else{alert("Please input words first.");}}
Light.keyDownLogin=function(e,id){var KeyID;if(window.event){keyID=window.event.keyCode;}else{keyID=e.which;}
if(keyID==13){Light.loginPortal(id);}
return!(keyID==13);}
Light.keyDownLoginTo=function(e,id){var KeyID;if(window.event){keyID=window.event.keyCode;}else{keyID=e.which;}
if(keyID==13){Light.loginToPortal(id);}
return!(keyID==13);}
function editPicPortlet(id){var autoRefresh=document.forms['form_'+id]['auto'].value;var seconds=document.forms['form_'+id]['seconds'].value;var items=document.forms['form_'+id]['items'].value;var columns=document.forms['form_'+id]['columns'].value;var status=0;var len=document.forms['form_'+id]['status'].length;for(var i=0;i<len;i++){if(document.forms['form_'+id]['status'][i].checked){status=document.forms['form_'+id]['status'][i].value;break;}}
var portlet=Light.getPortletById(id);portlet.mode=Light._VIEW_MODE;portlet.refreshHeader();portlet.periodTime=seconds*1000;portlet.lastAction=null;portlet.rememberMode(0);if(autoRefresh=="2"){portlet.autoRefreshed=true;portlet.refreshAtClient=true;portlet.firstTimeAutoRefreshed=true;portlet.autoRefresh();}else
portlet.autoRefreshed=false;var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=config"
+"&autoRefresh="+autoRefresh
+"&seconds="+seconds
+"&columns="+columns
+"&items="+items
+"&status="+status
+"&portletClientWidth="+portlet.width;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
deleteCalendarEvent=function(id,eventId,eventParentId){var deleteEvent=confirm($('_COMMAND_DELETE_CALENDAR_EVENT').title);if(!deleteEvent)
{return;}
var portlet=Light.getPortletById(id);var parameter=eventId;if(eventParentId!=0){var deleteEvents=confirm($('_COMMAND_DELETE_CALENDAR_EVENTS').title);if(deleteEvents)
{parameter+="-"+eventParentId}}
var pars="responseId="+id
+"&tabId="+Light.getCurrentTab().tabServerId
+"&portletId="+portlet.serverId
+"&action=delete"
+"&parameter="+parameter;Light.ajax.sendRequestAndUpdate(portlet.request,id,{evalScripts:portlet.allowJS,parameters:pars});}
playMusic=function(url){if(Light.music!=null)
document.body.removeChild(Light.music);var vMusic=document.createElement('div');Light.music=vMusic;vMusic.innerHTML="<embed src='"+url+"' autostart='true' loop='true' onreadystatechange='javascript:checkMusic(this);' width='2' height='0'></embed><noembed><bgsound src='"+url+"' loop='1' onreadystatechange='javascript:checkMusic(this);'></noembed>";document.body.appendChild(vMusic);}
stopMusic=function(url){if(Light.music!=null){document.body.removeChild(Light.music);Light.music=null;}}
checkMusic=function(player){alert(plyer.readyState);}
nextSlideShow=function(id,count)
{stopSlideShow(id);var portlet=Light.getPortletById(id);var picSpan=document.getElementById("picture_"+id);picSpan.innerHTML="";if(portlet.myGroupPictureName!=null){portlet.myGroupPictureIndex++;if(portlet.myGroupPictureIndex>=portlet.myGroupPictureCount)portlet.myGroupPictureIndex=0;var pic=document.getElementById(portlet.myGroupPictureName+"_"+portlet.myGroupPictureIndex);var params=pic.name.split(";");portlet.parameter="pictureId="+params[0];var data={width:params[1],height:params[2],url:params[3],caption:pic.value};if(portlet.myPictures[data.url]==null){portlet.myPictures[data.url]=new Image(data.width,data.height);portlet.myPictures[data.url].id='currentMyPicture_'+id;portlet.myPictures[data.url].src=data.url;portlet.myPictures[data.url].className='portlet';portlet.myPictures[data.url].style.border="0px";}
picSpan.innerHTML="";if(portlet.myPictures[data.url]!=null){portlet.myPictures[data.url].width=data.width;portlet.myPictures[data.url].height=data.height;portlet.myPictures[data.url].style.cursor="";picSpan.appendChild(portlet.myPictures[data.url]);picSpan.innerHTML+="<br/>"+data.caption;}else
picSpan.innerHTML=TrimPath.processDOMTemplate("slidePicture.jst",data);}else{portlet.myPictureIndex++;if(portlet.myPictureIndex>=count)portlet.myPictureIndex=0;var pic=document.getElementById("pictures_"+portlet.myPictureIndex);var params=pic.name.split(";");portlet.parameter="pictureId="+params[0];var data={width:params[1],height:params[2],url:params[3],caption:pic.value};if(portlet.myPictures[data.url]==null){portlet.myPictures[data.url]=new Image(data.width,data.height);portlet.myPictures[data.url].id='currentMyPicture_'+id;portlet.myPictures[data.url].src=data.url;portlet.myPictures[data.url].className='portlet';portlet.myPictures[data.url].style.border="0px";}
if(portlet.myPictures[data.url]!=null){portlet.myPictures[data.url].width=data.width;portlet.myPictures[data.url].height=data.height;portlet.myPictures[data.url].style.cursor="";picSpan.appendChild(portlet.myPictures[data.url]);picSpan.innerHTML+="<br/>"+data.caption;}else
picSpan.innerHTML=TrimPath.processDOMTemplate("slidePicture.jst",data);}
Light.getCurrentTab().repositionFooter();}
previousSlideShow=function(id,count)
{stopSlideShow(id);var portlet=Light.getPortletById(id);var picSpan=document.getElementById("picture_"+id);picSpan.innerHTML="";if(portlet.myGroupPictureName!=null){portlet.myGroupPictureIndex--;if(portlet.myGroupPictureIndex<0)portlet.myGroupPictureIndex=portlet.myGroupPictureCount-1;var pic=document.getElementById(portlet.myGroupPictureName+"_"+portlet.myGroupPictureIndex);var params=pic.name.split(";");portlet.parameter="pictureId="+params[0];var data={width:params[1],height:params[2],url:params[3],caption:((pic.value)?pic.value:"")};if(portlet.myPictures[data.url]==null){portlet.myPictures[data.url]=new Image(data.width,data.height);portlet.myPictures[data.url].id='currentMyPicture_'+id;portlet.myPictures[data.url].src=data.url;portlet.myPictures[data.url].className='portlet';portlet.myPictures[data.url].style.border="0px";}
if(portlet.myPictures[data.url]!=null){portlet.myPictures[data.url].width=data.width;portlet.myPictures[data.url].height=data.height;portlet.myPictures[data.url].style.cursor="";picSpan.appendChild(portlet.myPictures[data.url]);picSpan.innerHTML+="<br/>"+data.caption;}else
picSpan.innerHTML=TrimPath.processDOMTemplate("slidePicture.jst",data);}else{portlet.myPictureIndex--;if(portlet.myPictureIndex<0)portlet.myPictureIndex=count-1;var pic=document.getElementById("pictures_"+portlet.myPictureIndex);var params=pic.name.split(";");portlet.parameter="pictureId="+params[0];var data={width:params[1],height:params[2],url:params[3],caption:((pic.value)?pic.value:"")};if(portlet.myPictures[data.url]==null){portlet.myPictures[data.url]=new Image(data.width,data.height);portlet.myPictures[data.url].id='currentMyPicture_'+id;portlet.myPictures[data.url].src=data.url;portlet.myPictures[data.url].className='portlet';portlet.myPictures[data.url].style.border="0px";}
if(portlet.myPictures[data.url]!=null){portlet.myPictures[data.url].width=data.width;portlet.myPictures[data.url].height=data.height;portlet.myPictures[data.url].style.cursor="";picSpan.appendChild(portlet.myPictures[data.url]);picSpan.innerHTML+="<br/>"+data.caption;}else
picSpan.innerHTML=TrimPath.processDOMTemplate("slidePicture.jst",data);}
Light.getCurrentTab().repositionFooter();}
startAllSlideShow=function(id,count)
{stopSlideShow(id);var portlet=Light.getPortletById(id);portlet.myGroupPictureName=null;portlet.myGroupPictureCount=-1;if(!portlet.autoShow){portlet.autoShow=true;autoSlideShow(id,count);}}
startSlideShow=function(id,count)
{stopSlideShow(id);var portlet=Light.getPortletById(id);if(!portlet.autoShow){portlet.autoShow=true;if(portlet.myGroupPictureName!=null)
autoGroupSlideShow(id,portlet.myGroupPictureName,portlet.myGroupPictureCount);else
autoSlideShow(id,count);}}
autoSlideShow=function(id,count){var portlet=Light.getPortletById(id);if(portlet.autoShow){var picSpan=document.getElementById("picture_"+id);if(portlet.fade=="out")
portlet.opacity=portlet.opacity-1;else
portlet.opacity=portlet.opacity+1;if(portlet.opacity>=100)
portlet.fade="out";picSpan.style.filter="alpha(opacity="+portlet.opacity+")";picSpan.style.MozOpacity=portlet.opacity/100;if(portlet.opacity<=0){portlet.fade="in";portlet.myPictureIndex++;if(portlet.myPictureIndex>=count)portlet.myPictureIndex=0;var pic=document.getElementById("pictures_"+portlet.myPictureIndex);var params=pic.name.split(";");portlet.parameter="pictureId="+params[0];var data={width:params[1],height:params[2],url:params[3],caption:((pic.value)?pic.value:"")};picSpan.innerHTML="";if(portlet.myPictures[data.url]==null){portlet.myPictures[data.url]=new Image(data.width,data.height);portlet.myPictures[data.url].id='currentMyPicture_'+id;portlet.myPictures[data.url].src=data.url;portlet.myPictures[data.url].className='portlet';portlet.myPictures[data.url].style.border="0px";}
if(portlet.myPictures[data.url]!=null){portlet.myPictures[data.url].width=data.width;portlet.myPictures[data.url].height=data.height;portlet.myPictures[data.url].style.cursor="";picSpan.appendChild(portlet.myPictures[data.url]);picSpan.innerHTML+="<br/>"+data.caption;}else
picSpan.innerHTML=TrimPath.processDOMTemplate("slidePicture.jst",data);}
portlet.autoShowId=setTimeout((function(){autoSlideShow(id,count)}),50);Light.getCurrentTab().repositionFooter();}}
startGroupSlideShow=function(id,name,count){stopSlideShow(id);var portlet=Light.getPortletById(id);portlet.myGroupPictureIndex=-1;portlet.myGroupPictureName=name;portlet.myGroupPictureCount=count;if(!portlet.autoShow){portlet.autoShow=true;autoGroupSlideShow(id,name,count);}}
autoGroupSlideShow=function(id,name,count){var portlet=Light.getPortletById(id);if(portlet.autoShow){var picSpan=document.getElementById("picture_"+id);if(portlet.fade=="out")
portlet.opacity=portlet.opacity-1;else
portlet.opacity=portlet.opacity+1;if(portlet.opacity>=100)
portlet.fade="out";picSpan.style.filter="alpha(opacity="+portlet.opacity+")";picSpan.style.MozOpacity=portlet.opacity/100;if(portlet.opacity<=0){portlet.fade="in";portlet.myGroupPictureIndex++;if(portlet.myGroupPictureIndex>=count)portlet.myGroupPictureIndex=0;var pic=document.getElementById(name+"_"+portlet.myGroupPictureIndex);var params=pic.name.split(";");portlet.parameter="pictureId="+params[0];var data={width:params[1],height:params[2],url:params[3],caption:pic.value};picSpan.innerHTML="";if(portlet.myPictures[data.url]==null){portlet.myPictures[data.url]=new Image(data.width,data.height);portlet.myPictures[data.url].id='currentMyPicture_'+id;portlet.myPictures[data.url].src=data.url;portlet.myPictures[data.url].className='portlet';portlet.myPictures[data.url].style.border="0px";}
if(portlet.myPictures[data.url]!=null){portlet.myPictures[data.url].width=data.width;portlet.myPictures[data.url].height=data.height;portlet.myPictures[data.url].style.cursor="";picSpan.appendChild(portlet.myPictures[data.url]);picSpan.innerHTML+="<br/>"+data.caption;}else
picSpan.innerHTML=TrimPath.processDOMTemplate("slidePicture.jst",data);}
portlet.autoShowId=setTimeout((function(){autoGroupSlideShow(id,name,count)}),50);Light.getCurrentTab().repositionFooter();}}
stopSlideShow=function(id){var portlet=Light.getPortletById(id);portlet.fade="out";var picSpan=document.getElementById("picture_"+id);picSpan.style.filter="alpha(opacity=100)";picSpan.style.MozOpacity=1.0;portlet.autoShow=false;if(portlet.autoShowId!=null){clearTimeout(portlet.autoShowId);}}
function refreshAfterConfig(id){var portlet=Light.getPortletById(id);portlet.refresh();}
function ConfigAllViewedPic(id,count){var portlet=Light.getPortletById(id);var cpic=document.getElementById("userCurrentPicture");var params=cpic.name.split(";");var cdata={pictureId:params[0],width:params[1],height:params[2],url:params[3],caption:cpic.value};if(portlet.myPictures[cdata.url]==null){portlet.myPictures[cdata.url]=new Image(cdata.width,cdata.height);portlet.myPictures[cdata.url].id='currentMyPicture_'+id;portlet.myPictures[cdata.url].src=cdata.url;portlet.myPictures[cdata.url].className='portlet';portlet.myPictures[cdata.url].style.border="0px";portlet.myPictures[cdata.url].style.cursor="url('light/images/zoomin.cur'), pointer";}
var data=new Array();for(var i=0;i<count;i++){var pic=document.getElementById("pictures_"+i);var params=pic.name.split(";");data[i]={pictureId:params[0],width:params[1],height:params[2],url:params[3],status:params[4],tag:params[5],caption:pic.value};}
var innerHtml="";innerHtml+="<span title='' width='100%' style='clear: both;display: block; text-align:right;'>";innerHtml+="<a href='javascript:void(0);' onclick=\"javascript:hidePopupDiv('configAll');refreshAfterConfig('"+id+"');\">";innerHtml+="<img src='light/images/close_on.gif' style='border: 0px;'/></a>";innerHtml+="</span>";innerHtml+="<table border='0' cellpadding='0' cellspacing='0' width='100%'>";for(var j=0;j<data.length;j++){if(j%4==0)innerHtml+="<tr valign='top'>";innerHtml+="<td class='portlet-table-td-left'>";if(portlet.myPictures[data[j].url]!=null){portlet.myPictures[data[j].url].width=data[j].width/3;portlet.myPictures[data[j].url].height=data[j].height/3;portlet.myPictures[data[j].url].style.cursor="";var picSpan=document.createElement('span');picSpan.appendChild(portlet.myPictures[data[j].url]);innerHtml+=picSpan.innerHTML;innerHtml+="<br/>";innerHtml+="Caption:<br/>"+"<input type='text'  id='caption"+j+"' class='portlet-form-input-field' value='"+data[j].caption+"' size='40' onchange=\"ConfigMyPicture('"+id+"','caption"+j+"',"+data[j].pictureId+","+j+");\"/>";innerHtml+="<br/>";innerHtml+="Tag:<br/>"+"<input type='text' id='tag"+j+"' class='portlet-form-input-field' value='"+data[j].tag+"' size='40' onchange=\"ConfigMyPicture('"+id+"','tag"+j+"',"+data[j].pictureId+","+j+");\"/>";innerHtml+="<br/>";innerHtml+="Privacy:<br/>";innerHtml+="<input type='radio' id='status0"+j+"' name='status"+j+"' value='0' class='portlet-form-radio' onchange=\"ConfigMyPicture('"+id+"','status0"+j+"',"+data[j].pictureId+","+j+");\"";if(data[j].status==0)innerHtml+="checked='checked'";innerHtml+=">Just for me</input><br/>";innerHtml+="<input type='radio' id='status1"+j+"' name='status"+j+"' value='1' class='portlet-form-radio' onchange=\"ConfigMyPicture('"+id+"','status1"+j+"',"+data[j].pictureId+","+j+");\"";if(data[j].status==1)innerHtml+="checked='checked'";innerHtml+=">Also for my friends</input><br/>";innerHtml+="<input type='radio' id='status2"+j+"' name='status"+j+"' value='2' class='portlet-form-radio' onchange=\"ConfigMyPicture('"+id+"','status2"+j+"',"+data[j].pictureId+","+j+");\"";if(data[j].status==2)innerHtml+="checked='checked'";innerHtml+=">Open to public</input><br/>";innerHtml+="<span id= 'configPictureHeader"+j+"' width='100%' style='text-align:left; color: #FF0000;'></span>";}
if(j%4==3)innerHtml+="</tr>";}
if(portlet.myPictures.length%4!=0)innerHtml+="</tr>";innerHtml+="</table>";createPopupDiv2("configAll",1000,innerHtml,id);}
function ConfigMyPicture(id,name,pictureId,index){document.getElementById('configPictureHeader'+index).innerHTML="saving";var portlet=Light.getPortletById(id);portlet.pictureConfigIndex=index;var value=document.getElementById(name).value;var params="pictureId="+pictureId
+"&name="+name
+"&value="+value
+"&responseId="+id
+"&portletId="+portlet.serverId;Light.ajax.sendRequest(Light.portal.contextPath+Light.configMyPicture,{parameters:params,onSuccess:responseConfigMyPicture});}
function responseConfigMyPicture(t){var id=t.responseText;var portlet=Light.getPortletById(id);document.getElementById('configPictureHeader'+portlet.pictureConfigIndex).innerHTML="saved successfully";portlet.autoShowId=setTimeout((function(){resetConfigMyPictureStatus(id)}),1000);}
function resetConfigMyPictureStatus(id){var portlet=Light.getPortletById(id);document.getElementById('configPictureHeader'+portlet.pictureConfigIndex).innerHTML="";}
function showAddComments(e,id){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=e;Light.portal.latestAction.id=id;Light.portal.latestAction.method="showAddComments";Light.login();return;}
var portlet=Light.getPortletById(id);if(portlet==null)return;var vdocument=document.getElementById('panel_'+Light.getCurrentTabId());var old=document.getElementById('comment');if(old!=null)vdocument.removeChild(old);var vPopupDiv=document.createElement('div');vPopupDiv.id="comment";vPopupDiv.style.width=360;vPopupDiv.style.position="absolute";vPopupDiv.className="portlet-popup";var x=200;var y=200;if(window.event){x=event.clientX+document.body.scrollLeft-100;y=event.clientY+document.body.scrollTop-100;}else if(e!=null){x=e.pageX-100;y=e.pageY-100;}
if(document.all){vPopupDiv.style.posLeft=x;vPopupDiv.style.posTop=y;}else{vPopupDiv.style.left=x;vPopupDiv.style.top=y;}
var inHtml="<span title='"+$('_CLOSE').title+"'  width='100%' style='clear: both;  display: block; text-align:right;'><a href='javascript:void(0);' onclick='javascript:hideAddComment();'><img src='"+Light.getThemePath()+"/images/close_on.gif' style='border: 0px;'/></a></span>"
+"<form name='addCommentForm'>"
+"<table border='0' cellpadding='0' cellspacing='0' >"
+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+$('_LABEL_COMMENT').title+":"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-left' colspan='2'>"
+"<textarea name='comment' class='portlet-form-textarea-field' rows='5' cols='50' >"
+"</textarea>"
+"</td>"
+"</tr>"
+"<tr>"
+"<td class='portlet-table-td-right' colspan='2' >"
+"<input type='button' name='action' onClick='javascript:saveComment(\""+id+"\");'"
+" value='"+$('_BUTTON_OK').title+"' class='portlet-form-button' />"
+"<input type='button' name='action' onClick='javascript:hideAddComment();' value='"
+$('_BUTTON_CANCEL').title+"' class='portlet-form-button' />"
+"</td>"
+"</tr>"
+"</table>"
+"</form>";vPopupDiv.innerHTML=inHtml;vPopupDiv.style.zIndex=Light.maxZIndex;vdocument.appendChild(vPopupDiv);document.forms['addCommentForm']['comment'].focus();}
saveComment=function(id){var comment=document.forms['addCommentForm']['comment'].value;if(comment==null||comment.length<=0){alert("Please input comment.");return;}
var params="responseId="+id
+"&comment="+comment;Light.ajax.sendRequest(Light.portal.contextPath+Light.saveComment,{parameters:params,onSuccess:responseSaveComment});}
function responseSaveComment(t){var id=t.responseText;var portlet=Light.getPortletById(id);if(portlet!=null)portlet.refresh();hideAddComment();}
hideAddComment=function(){var vdocument=document.getElementById('panel_'+Light.getCurrentTabId());var old=document.getElementById('comment');if(old!=null)vdocument.removeChild(old);}
function showInstantMessage(e,id){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=e;Light.portal.latestAction.id=id;Light.portal.latestAction.method="showInstantMessage";Light.login();return;}
chatWithProfile();}
chatWithProfile=function(){Light.ajax.sendRequest(Light.portal.contextPath+Light.chatWithProfile,{parameters:null,onSuccess:responseChatWithProfile});}
responseChatWithProfile=function(t){var chatParams=t.responseText.split(",");if(chatParams[1]==0){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,userName:chatParams[0],popupName:'isBlockUser'};createPopupDiv('isBlockUser','isBlockUser.jst',360,data,null,null);return;}
if(chatParams[1]=="n"){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,userName:chatParams[0],popupName:'noIM'};createPopupDiv('noIM','noIM.jst',360,data,null,null);return;}
if(chatParams[1]=="f"){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,userName:chatParams[0],popupName:'friendOnlyIM'};createPopupDiv('friendOnlyIM','friendOnlyIM.jst',360,data,null,null);return;}
var portlet=new PortletChatWindow(12,$('_TITLE_CHAT').title+chatParams[0],"","","chattingPortlet",Light.portal.contextPath+"/chattingPortlet.lp",true,false,false,false,false,true,5000,true,'','','',"chattingId="+chatParams[1]);portlet.refresh();document.forms['form_'+Light.getCurrentTabId()]['chat'].focus();}
Light.showSendMessage=function(e,id,buddyId,buddyName){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=e;Light.portal.latestAction.id=id;Light.portal.latestAction.buddyId=buddyId;Light.portal.latestAction.buddyName=buddyName;Light.portal.latestAction.method="Light.showSendMessage";Light.login();return;}
if(buddyId==null){if(Light.portal.latestAction.buddyId!=null)
buddyId=Light.portal.latestAction.buddyId;else
buddyId=0;}
if(buddyName==null&&Light.portal.latestAction.buddyName!=null)
buddyName=Light.portal.latestAction.buddyName;var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id,popupName:'sendMessage',buddyId:buddyId,buddyName:buddyName};createPopupDiv('sendMessage','sendMessage.jst',400,data,e,id);}
Light.sendMessageAction=function(id,buddyId,popupName){var form=$('sendMessageForm');var subject=$F(form['subject']);if(subject==null||subject.length<=0){alert("Please input subject.");return;}
var content=$F(form['content']);if(content==null||content.length<=0){alert("Please input content.");return;}
var params="responseId="+id
+"&toUserId="+buddyId
+"&subject="+subject
+"&content="+content;Light.ajax.sendRequest(Light.portal.contextPath+Light.sendMessageRequest,{parameters:params,onSuccess:Light.sendMessageActionHandler});hidePopupDiv(popupName);}
Light.sendMessageActionHandler=function(t){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,popupName:'responseSendMessageAction',value:t.responseText};createPopupDiv(data.popupName,data.popupName+'.jst',280,data,null,null);}
Light.showForwardToFriends=function(e,id){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=e;Light.portal.latestAction.id=id;Light.portal.latestAction.method="Light.showForwardToFriends";Light.login();return;}
var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id,popupName:'forwardToFriends'};createPopupDiv('forwardToFriends','forwardToFriends.jst',280,data,e,id);}
Light.saveForwardToFriends=function(id){var params="responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.forwardToFriends,{parameters:params,onSuccess:Light.saveForwardToFriendsHandler});}
Light.saveForwardToFriendsHandler=function(t){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,popupName:'responseForwardToFriends'};createPopupDiv('responseForwardToFriends','responseForwardToFriends.jst',280,data,null,t.responseText);}
Light.showAddToFriend=function(e,id,buddyId,buddyName){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=e;Light.portal.latestAction.id=id;Light.portal.latestAction.buddyId=buddyId;Light.portal.latestAction.buddyName=buddyName;Light.portal.latestAction.method="Light.showAddToFriend";Light.login();return;}
if(buddyId==null){if(Light.portal.latestAction.buddyId!=null)
buddyId=Light.portal.latestAction.buddyId;else
buddyId=0;}
if(buddyName==null&&Light.portal.latestAction.buddyName!=null)
buddyName=Light.portal.latestAction.buddyName;var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id,popupName:'addToFriend',buddyId:buddyId,buddyName:buddyName};createPopupDiv('addToFriend','addToFriend.jst',360,data,e,id);}
Light.saveAddToFriend=function(id,buddyId){var params="responseId="+id
+"&buddyId="+buddyId;Light.ajax.sendRequest(Light.portal.contextPath+Light.addFriendRequest,{parameters:params,onSuccess:Light.saveAddToFriendHandler});}
Light.saveAddToFriendHandler=function(t){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,popupName:'responseAddToFriend'};createPopupDiv('responseAddToFriend','responseAddToFriend.jst',280,data,null,t.responseText);}
Light.showAddToFavorites=function(e,id){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=e;Light.portal.latestAction.id=id;Light.portal.latestAction.method="Light.showAddToFavorites";Light.login();return;}
var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id,popupName:'addToFavorites'};createPopupDiv('addToFavorites','addToFavorites.jst',280,data,e,id);}
Light.saveAddToFavorites=function(id){var params="responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.addToFavorites,{parameters:params,onSuccess:Light.saveAddToFavoritesHandler});}
Light.saveAddToFavoritesHandler=function(t){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,popupName:'responseAddToFavorites'};createPopupDiv('responseAddToFavorites','responseAddToFavorites.jst',280,data,null,t.responseText);}
Light.showRankUser=function(e,id){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=e;Light.portal.latestAction.id=id;Light.portal.latestAction.method="Light.showRankUser";Light.login();return;}
var portlet=new PortletPopupWindow(11,300,400,$('_MENU_RANK').title,"","","rankPortlet",Light.portal.contextPath+"/rankPortlet.lp",true,false,false,false,false,false,false,0,false,'','','',"");portlet.refresh();}
Light.showBlockUser=function(e,id){var userId=Light.getCookie(Light._LOGINED_USER_ID);if(userId==null||userId==""){Light.portal.latestAction.event=e;Light.portal.latestAction.id=id;Light.portal.latestAction.method="Light.showBlockUser";Light.login();return;}
var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,id:id,popupName:'blockUser'};createPopupDiv('blockUser','blockUser.jst',280,data,e,id);}
Light.saveBlockUser=function(id){var params="responseId="+id;Light.ajax.sendRequest(Light.portal.contextPath+Light.blockUser,{parameters:params,onSuccess:Light.saveBlockUserHandler});}
Light.saveBlockUserHandler=function(t){var data={title:$('_CLOSE').title,ok:$('_BUTTON_OK').title,cancel:$('_BUTTON_CANCEL').title,popupName:'responseBlockUser'};createPopupDiv('responseBlockUser','responseBlockUser.jst',280,data,null,t.responseText);}
function moveSliderBarBegin(e,slider,sliderBar){if(slider.move!=null&&slider.move)return;sliderBar.move=true;slider.oldLeft=slider.style.left;moveSliderBar(e,slider,sliderBar);}
function moveSliderBar(e,slider,sliderBar,positionX){if(sliderBar.move==null||!sliderBar.move)return;if(slider.move!=null&&slider.move)return;var left=0;if(positionX!=null){left=positionX;}else{if(window.event){left=event.clientX;}else{if(e!=null){left=e.pageX;}}}
var newPositonX=left;left-=getX(sliderBar);var original=slider.style.left;original=parseInt(original.substring(0,original.length-2));if(left>original)
left=original+10;else
left=original-10;if(left<30)left=30;if(left>650)left=650;slider.style.left=left+"px";setTimeout((function(){moveSliderBar(e,slider,sliderBar,newPositonX)}),100);}
function moveSliderBarEnd(slider,sliderBar,id,page,pages,viewType){if(slider.move!=null&&slider.move)return;if(sliderBar.move!=null&&sliderBar.move){sliderBar.move=false;var original=slider.style.left;original=parseInt(original.substring(0,original.length-2));var each=(650-30)/pages;var newPage=parseInt(original/each);if(newPage>=pages)newPage=pages-1;if(newPage==page){var old=slider.oldLeft;old=parseInt(old.substring(0,old.length-2));if(original>old)
newPage++;else if(original<old)
newPage--;}
if(newPage<0)newPage=0;if(newPage>=pages)newPage=pages-1;Light.executeRender(id,'','maximized','viewType='+viewType+'&page='+newPage);}}
function moveSliderBegin(e,slider,id,page,pages){slider.move=true;slider.oldLeft=slider.style.left;var left=0;if(window.event){left=event.clientX;}else if(e!=null){left=e.pageX;}
slider.left=left;}
function moveSlider(e,slider){if(slider.move==null||!slider.move)return;var left=0;if(window.event){left=event.clientX;}else if(e!=null){left=e.pageX;}
if(slider.left==null){slider.left=left;}else{var temp=left;var original=slider.style.left;original=parseInt(original.substring(0,original.length-2));if(left<slider.left)
left=original-(slider.left-left);else
left=original+(left-slider.left);slider.left=temp;}
if(left<30)left=30;if(left>650)left=650;slider.style.left=left+"px";}
function moveSliderEnd(slider,id,page,pages,viewType){if(slider.move!=null&&slider.move){slider.move=false;var original=slider.style.left;original=parseInt(original.substring(0,original.length-2));var each=(650-30)/pages;var newPage=parseInt(original/each);if(newPage>=pages)newPage=pages-1;if(newPage==page){var old=slider.oldLeft;old=parseInt(old.substring(0,old.length-2));if(original>old)
newPage++;else if(original<old)
newPage--;}
if(newPage<0)newPage=0;if(newPage>=pages)newPage=pages-1;Light.executeRender(id,'','maximized','viewType='+viewType+'&page='+newPage);}}
function changeNumber(id,obj,number,original,viewType){if(number<original)
moveToRight(obj);else
moveToLeft(obj);Light.executeRender(id,'','maximized','viewType='+viewType+'&number='+number);}
function moveToRight(obj){var original=obj.style.marginLeft;original=parseInt(original.substring(0,original.length-2));original+=10;obj.style.marginLeft=original+"px";setTimeout((function(){moveToRight(obj)}),1);}
function moveToLeft(obj){var original=obj.style.marginLeft;original=parseInt(original.substring(0,original.length-2));original-=10;obj.style.marginLeft=original+"px";setTimeout((function(){moveToLeft(obj)}),1);}
function buyNow(total,paymentReason){window.location=Light.portal.contextPath+"/checkout/payment.jsp?Amount="+total+"&paymentReason="+paymentReason;}
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