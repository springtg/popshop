
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