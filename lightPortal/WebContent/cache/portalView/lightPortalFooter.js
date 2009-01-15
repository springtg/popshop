
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