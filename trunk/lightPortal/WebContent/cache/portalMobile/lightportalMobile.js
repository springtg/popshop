
LightPortal.prototype.turnOnPortal=function(){this.layout.bgWidth=1000;this.layout.maxWidth=1000;this.layout.containerLeft=0;this.layout.barWidth=0;if($('loginUserId').title!=0){Light.setCookie(Light._LOGINED_USER_ID,$('loginUserId').title);}
Light.deleteCookie(Light._CURRENT_TAB);Light.portal.renderPortal($('portalString').title);Light.portal.renderPortalTab($('pageRoot').title);}