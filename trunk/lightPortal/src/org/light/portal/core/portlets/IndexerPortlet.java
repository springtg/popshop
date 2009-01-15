package org.light.portal.core.portlets;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.LinkedList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.util.LabelBean;
import org.light.portal.util.PropUtil;

public class IndexerPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {	
		 String action = request.getParameter("action");
		 if("reIndex".equals(action)){
			 String type = request.getParameter("type");
			 if(!type.equals("all")){	
				 try{
					 this.getUserService(request).reIndex(Class.forName(type));
				 }catch(Exception e){}
			 }else{
				 this.getUserService(request).reIndex();
			 }
			 List<LabelBean> beans = (List<LabelBean>)request.getPortletSession().getAttribute("searchTypes",PortletSession.APPLICATION_SCOPE);
			   for(LabelBean bean : beans){
				   if(bean.getId().equals(type))
					   bean.setDefaulted(true);
				   else
					   bean.setDefaulted(false);
			   }
			 request.setAttribute("success", "ReIndex has been successfully finished");
		 }
	 }
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		 initSearch(request);
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/indexer.jsp").include(request,response);
	 }
	 
	 private void initSearch(RenderRequest request){
			if(request.getPortletSession().getAttribute("searchTypes",PortletSession.APPLICATION_SCOPE) == null){
				List<LabelBean> types = new LinkedList<LabelBean>();
				types.add(new LabelBean("all","All"));
				String value=PropUtil.getString("portlet.search.list");
				String[] lists = value.split(";");
				int i = 0;
				for(String list : lists){
					String[] unit = list.split(",");							
					if(unit.length >= 4){
						if(i == 0)
							types.add(new LabelBean(unit[0],unit[3],true));
						else
							types.add(new LabelBean(unit[0],unit[3]));
					}
					i++;
				}
				request.getPortletSession().setAttribute("searchTypes",types,PortletSession.APPLICATION_SCOPE);
			}
		}

}
