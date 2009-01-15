package org.light.portlets.feedback;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.portlet.core.impl.PortletPreference;
import org.light.portlets.note.Note;

public class FeedbackPortlet extends LightGenericPortlet {
  
 public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
  String action = request.getParameter("action");
  if("save".equals(action)){
     String subject = request.getParameter("subject");
     String content = request.getParameter("content"); 
     if(subject == null || subject.length() <= 0 ){
      request.setAttribute("error","Feedback's subject is required field.");
      response.setPortletMode(PortletMode.EDIT);
      return;
     }
     if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);     
     if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF);
     Feedback feedback = new Feedback(subject,content,this.getUser(request).getUserId());
     this.getPortalService(request).save(feedback);
  }  
   }
  
  protected void doView (RenderRequest request, RenderResponse response)
    throws PortletException, java.io.IOException
  {
   List<Feedback> list = this.getUserService(request).getFeedback();
   List<Feedback> showList = new ArrayList<Feedback>();
   if(!request.getWindowState().equals(WindowState.MAXIMIZED) && list.size() > 6){
    for(int i=0;i<6;i++){
     showList.add(list.get(i));
    }
   }else
    showList = list;
   if(list.size() > 6)
    request.setAttribute("showMore",true);
   request.setAttribute("feebackLists",showList);
   this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/feedback/feedbackPortletView.jsp").include(request,response);     
  } 
  
  protected void doEdit (RenderRequest request, RenderResponse response)
    throws PortletException, java.io.IOException
  {     
   this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/feedback/feedbackPortletEdit.jsp").include(request,response);
  } 
  
  protected void doHelp (RenderRequest request, RenderResponse response)
    throws PortletException, java.io.IOException
  {     
   this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/feedback/feedbackPortletHelp.jsp").include(request,response);
  }
  
}

