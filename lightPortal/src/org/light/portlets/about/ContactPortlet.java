package org.light.portlets.about;
import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portlets.feedback.Feedback;

public class ContactPortlet extends LightGenericPortlet {

    public void processAction (ActionRequest request, ActionResponse
response)
       throws PortletException, java.io.IOException {
     String action = request.getParameter("action");
     if("save".equals(action)){
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String email = request.getParameter("email");
        if(subject == null || subject.length() <= 0 ){
         request.setAttribute("error","Feedback's subject is required field.");
         return;
        }
        if(content == null || content.length() <= 0 ){
            request.setAttribute("error","Feedback's content is required field.");
            return;
        }
        if(subject != null) subject =URLDecoder.decode(subject,_CHARSET_UTF);
        if(content != null) content =URLDecoder.decode(content,_CHARSET_UTF);
        if(email != null) email = URLDecoder.decode(email,_CHARSET_UTF);
        if(this.getUser(request) != null)
            email = this.getUser(request).getEmail();
        Feedback feedback = new Feedback(subject,content,email);
        this.getPortalService(request).save(feedback);
        request.setAttribute("success","Your feedback has been saved successfully.");
     }
     else{
            String showHtmlEditor = request.getParameter("htmlEditor");
            if(showHtmlEditor != null)
                request.setAttribute("showHtmlEditor",true);
            String subject = request.getParameter("subject");
            if(subject != null){
                subject = URLDecoder.decode(subject,_CHARSET_UTF);

                request.setAttribute("subject",subject);
            }
            String email = request.getParameter("email");
            if(email != null){
                email = URLDecoder.decode(email,_CHARSET_UTF);

                request.setAttribute("email",email);
            }
            String content = request.getParameter("content");
            if(content != null){
                content = URLDecoder.decode(content,_CHARSET_UTF);
                request.setAttribute("content",content);
            }
       }
      }

     protected void doView (RenderRequest request, RenderResponse response)
       throws PortletException, java.io.IOException
     {


    	 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/about/contactPortletView.jsp").include(request,response);

     }

}
