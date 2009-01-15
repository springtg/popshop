package org.light.portal.core.portlets;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.ChannelRef;
import org.light.portal.model.Portal;
import org.light.portal.model.PortalTab;
import org.light.portal.model.PortletObject;
import org.light.portal.model.PortletObjectRef;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.LocaleUtil;

public class ChannelPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		 String action = request.getParameter("action");
		 if("search".equals(action)){
			 String channel = request.getParameter("channel");
			 String region = request.getParameter("region");
			 if(channel == null || region == null){
				 request.setAttribute("error", "Please choose Channel and Region first.");
				 return;
			 }
			 String regionChannel=channel;
			 if(!region.equals("en")) regionChannel+="_"+region;
			 List<PortletObjectRef> refs = this.getPortalService(request).getPortletRefByRegion(region);
			 
			 Portal portal = this.getPortalService(request).getPortalByUser(regionChannel);
			 ChannelRef ref = this.getPortalService(request).getChannelByName(channel);			
			 if(portal == null){
				 Portal po = this.getPortalService(request).getPortalByUser(channel);
				 portal = new Portal(regionChannel,po.getTitle(),po.getTheme(),po.getShowLocaleBar());
				 this.getPortalService(request).save(portal);				 	 
				 PortalTab tab = new PortalTab(ref.getDescKey(),null,0,null,0,10,"300,300,300","PortletWindow",regionChannel);
				 this.getPortalService(request).save(tab);
			 }			 
			 List<PortalTab> tabs = this.getPortalService(request).getPortalTabByNameAndUser(ref.getDescKey(),regionChannel);
			 List<PortletObject> portlets =  this.getPortalService(request).getPortletsByTab(tabs.get(0).getId());
			 List<PortletObject> portlets0 = new ArrayList<PortletObject>();
			 List<PortletObject> portlets1 = new ArrayList<PortletObject>();
			 List<PortletObject> portlets2 = new ArrayList<PortletObject>();
			 for(PortletObject p : portlets){
				 if(p.getColumn() == 0)
					 portlets0.add(p);
				 else if(p.getColumn() == 1)
					 portlets1.add(p);
				 else if(p.getColumn() == 2)
					 portlets2.add(p);
			 }
			 request.setAttribute("portletRefs",refs);
			 request.setAttribute("portlets0",portlets0);
			 request.setAttribute("portlets1",portlets1);
			 request.setAttribute("portlets2",portlets2);
			 request.setAttribute("channel",channel);
			 request.setAttribute("region",region);
		 }
		 else if("save".equals(action)){
			 String channel = request.getParameter("channel");
			 String region = request.getParameter("region");
			 String name0 = request.getParameter("name0"); 
			 String name1 = request.getParameter("name1");
			 String name2 = request.getParameter("name2");
			 String[] portletsId0 = name0.split("#");
			 String[] portletsId1 = name1.split("#");
			 String[] portletsId2 = name2.split("#");
			 String regionChannel=channel;
			 if(!region.equals("en")) regionChannel+="_"+region;
			 List<PortletObjectRef> refs = this.getPortalService(request).getPortletRefByRegion(region);
			 
			 Portal portal = this.getPortalService(request).getPortalByUser(regionChannel);
			 ChannelRef ref = this.getPortalService(request).getChannelByName(channel);			
			 if(portal == null){
				 Portal po = this.getPortalService(request).getPortalByUser(channel);
				 portal = new Portal(regionChannel,po.getTitle(),po.getTheme(),po.getShowLocaleBar());
				 this.getPortalService(request).save(portal);				 	 
				 PortalTab tab = new PortalTab(ref.getDescKey(),null,0,null,0,10,"300,300,300","PortletWindow",regionChannel);
				 this.getPortalService(request).save(tab);
			 }			 
			 List<PortalTab> tabs = this.getPortalService(request).getPortalTabByNameAndUser(ref.getDescKey(),regionChannel);
			 List<PortletObject> portlets =  this.getPortalService(request).getPortletsByTab(tabs.get(0).getId());
			 List<PortletObject> portlets0 = new ArrayList<PortletObject>();
			 List<PortletObject> portlets1 = new ArrayList<PortletObject>();
			 List<PortletObject> portlets2 = new ArrayList<PortletObject>();
			 for(PortletObject p : portlets){
				 if(p.getColumn() == 0)
					 portlets0.add(p);
				 else if(p.getColumn() == 1)
					 portlets1.add(p);
				 else if(p.getColumn() == 2)
					 portlets2.add(p);
			 }
			 for(int i=0;i<portletsId0.length;i++){
				 boolean isNew = true;
				 for(PortletObject p : portlets0){
					 if(String.valueOf(p.getId()).equals(portletsId0[i])){
						 p.setRow(i);
						 this.getPortalService(request).save(p);
						 isNew = false;
					 }
				 }
				 if(isNew){
					 PortletObjectRef r = null;
					 for(PortletObjectRef pr : refs){
						 if(pr.getName().equals(portletsId0[i])){
							 r= pr;
							 break;
						 }
					 }
					 PortletObject p = new PortletObject(tabs.get(0).getId(),0,i,r,false,false); 
					 this.getPortalService(request).save(p);
				 }
			 }
			 for(PortletObject p : portlets0){
				 boolean isDelete = true;
				 for(int i=0;i<portletsId0.length;i++){
					 if(String.valueOf(p.getId()).equals(portletsId0[i])){ 
						 isDelete = false;
						 break;
					 }
				 }
				 if(isDelete){
					 this.getPortalService(request).delete(p);
				 }
			 }
			 
			 for(int i=0;i<portletsId1.length;i++){
				 boolean isNew = true;
				 for(PortletObject p : portlets1){
					 if(String.valueOf(p.getId()).equals(portletsId1[i])){
						 p.setRow(i);
						 this.getPortalService(request).save(p);
						 isNew = false;
					 }
				 }
				 if(isNew){
					 PortletObjectRef r = null;
					 for(PortletObjectRef pr : refs){
						 if(pr.getName().equals(portletsId1[i])){
							 r= pr;
							 break;
						 }
					 }
					 PortletObject p = new PortletObject(tabs.get(0).getId(),1,i,r,false,false); 
					 this.getPortalService(request).save(p);
				 }
			 }
			 for(PortletObject p : portlets1){
				 boolean isDelete = true;
				 for(int i=0;i<portletsId1.length;i++){
					 if(String.valueOf(p.getId()).equals(portletsId1[i])){ 
						 isDelete = false;
						 break;
					 }
				 }
				 if(isDelete){
					 this.getPortalService(request).delete(p);
				 }
			 }
			 
			 for(int i=0;i<portletsId2.length;i++){
				 boolean isNew = true;
				 for(PortletObject p : portlets2){
					 if(String.valueOf(p.getId()).equals(portletsId2[i])){
						 p.setRow(i);
						 this.getPortalService(request).save(p);
						 isNew = false;
					 }
				 }
				 if(isNew){
					 PortletObjectRef r = null;
					 for(PortletObjectRef pr : refs){
						 if(pr.getName().equals(portletsId2[i])){
							 r= pr;
							 break;
						 }
					 }
					 PortletObject p = new PortletObject(tabs.get(0).getId(),2,i,r,false,false); 
					 this.getPortalService(request).save(p);
				 }
			 }
			 for(PortletObject p : portlets2){
				 boolean isDelete = true;
				 for(int i=0;i<portletsId2.length;i++){
					 if(String.valueOf(p.getId()).equals(portletsId2[i])){ 
						 isDelete = false;
						 break;
					 }
				 }
				 if(isDelete){
					 this.getPortalService(request).delete(p);
				 }
			 }
			 request.setAttribute("success", "This Channel's contents have been saved successfully.");
		 }
		 else if("edit".equals(action)){
             String name = request.getParameter("name");
             if(name != null) name = URLDecoder.decode(name,_CHARSET_UTF);
             String label = request.getParameter("label");
             if(label != null) label = URLDecoder.decode(label,_CHARSET_UTF);
             String icon = request.getParameter("icon");
             if(icon != null) icon = URLDecoder.decode(icon,_CHARSET_UTF);
             String url = request.getParameter("url");
             if(url != null) url = URLDecoder.decode(url,_CHARSET_UTF);
             String tag = request.getParameter("tag");
             if(tag != null) tag = URLDecoder.decode(tag,_CHARSET_UTF);
             String subTag = request.getParameter("subTag");
             if(subTag != null) subTag = URLDecoder.decode(subTag,_CHARSET_UTF);
             String language = request.getParameter("language");
             String path = request.getParameter("path");
             if(path != null) path = URLDecoder.decode(path,_CHARSET_UTF);
             String userId = request.getParameter("refUserId");
             String parameter = request.getParameter("parameter");
             if(parameter != null) parameter =URLDecoder.decode(parameter,_CHARSET_UTF);
             int refreshMode =0;
             if(request.getParameter("refreshMode") != null) refreshMode = 1;
             int editMode =0;
             if(request.getParameter("editMode") != null) editMode = 1;
             int helpMode =0;
             if(request.getParameter("helpMode") != null) helpMode = 1;
             int configMode =0;
             if(request.getParameter("configMode") != null) configMode = 1;
             int autoRefresh =0;
             if(request.getParameter("autoRefresh") != null) autoRefresh = 1;
             int pageRefresh =0;
             if(request.getParameter("pageRefresh") != null) pageRefresh = 1;
             int allowJS =0;
             if(request.getParameter("allowJS") != null) allowJS = 1;
             int periodTime =0;
             if(request.getParameter("periodTime") != null) periodTime =Integer.parseInt(request.getParameter("periodTime"));
             int showNumber =0;
             if(request.getParameter("showNumber") != null) showNumber =Integer.parseInt(request.getParameter("showNumber"));
             int windowStatus =0;
             if(request.getParameter("windowStatus") != null) windowStatus =Integer.parseInt(request.getParameter("windowStatus"));
             int showType =0;
             if(request.getParameter("showType") != null) showType =Integer.parseInt(request.getParameter("showType"));
             int mode =0;
			 if(request.getParameter("refMode") != null) mode = Integer.parseInt(request.getParameter("refMode"));
			 int type =0;
			 if(request.getParameter("refType") != null) type = Integer.parseInt(request.getParameter("refType"));


             PortletObjectRef ref = this.getPortalService(request).getPortletRefByName(name);
             if(ref != null){
                     ref.setLabel(label);
                     ref.setIcon(icon);
                     ref.setUrl(url);
                     ref.setPath(path);
                     ref.setTag(tag);
                     ref.setSubTag(subTag);
                     ref.setLanguage(language);
                     ref.setParameter(parameter);
                     ref.setUserId(userId);
                     ref.setRefreshMode(refreshMode);
                     ref.setEditMode(editMode);
                     ref.setHelpMode(helpMode);
                     ref.setConfigMode(configMode);
                     ref.setAutoRefreshed(autoRefresh);
                     ref.setPageRefreshed(pageRefresh);
                     ref.setAllowJS(allowJS);
                     ref.setPeriodTime(periodTime);
                     ref.setShowNumber(showNumber);
                     ref.setShowType(showType);
                     ref.setType(type);
                     ref.setWindowStatus(windowStatus);
                     ref.setMode(mode);

                     this.getPortalService(request).save(ref);
             }
     }
	 }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		if(request.getPortletSession().getAttribute("channels",PortletSession.APPLICATION_SCOPE) == null){
		 List<ChannelRef> channels = this.getPortalService(request).getChannelRef();
		 request.getPortletSession().setAttribute("channels",channels,PortletSession.APPLICATION_SCOPE);
		 request.getPortletSession().setAttribute("regions",LocaleUtil.getSupportedRegions(),PortletSession.APPLICATION_SCOPE);
		}
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/channel.jsp").include(request,response);
	 }
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
     throws PortletException, java.io.IOException
   {
      String name = request.getParameter("name");
      if(name != null) name = URLDecoder.decode(name,_CHARSET_UTF);
      PortletObjectRef ref =this.getPortalService(request).getPortletRefByName(name);
      if(ref != null){
          request.setAttribute("ref",ref);
          this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/channelEdit.jsp").include(request,response);
      }else
          this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/channel.jsp").include(request,response);
   }
}
