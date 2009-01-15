/*
 * Copyright (c) 2006 Jianmin Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.light.portlets.email;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._MAX_ROW_PER_PAGE;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import org.light.portal.portlet.core.impl.LightGenericPortlet;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class EmailPortletBac extends LightGenericPortlet {
		  
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {
		 String action = request.getParameter("action");
	       if("send".equals(action)){
	    	   String toEmail = request.getParameter("toEmail");
	    	   String cc = request.getParameter("cc");
	    	   String bcc = request.getParameter("bcc");
			   String subject = request.getParameter("subject");
			   String content = request.getParameter("content");
			   if(subject == null || subject.length() <= 0 || toEmail == null || toEmail.length() <= 0 ){
				   request.setAttribute("error","Message's to and subject are required field.");
				   response.setPortletMode(PortletMode.EDIT);
				   response.setRenderParameter("type","create");
				   return;
			   }
			   if(toEmail != null) toEmail = URLDecoder.decode(toEmail,_CHARSET_UTF);
			   if(cc != null) cc = URLDecoder.decode(cc,_CHARSET_UTF);
			   if(bcc != null) bcc = URLDecoder.decode(bcc,_CHARSET_UTF);
			   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
			   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF).replaceAll("\n","").trim();
			   try{
				   	 PortletPreferences portletPreferences = request.getPreferences();
				   	 String incomingType = portletPreferences.getValue("incomingType",null);
					 String incoming = portletPreferences.getValue("incoming",null);
					 String incomingPort = portletPreferences.getValue("incomingPort",null);
			    	 String incomingSSL = portletPreferences.getValue("incomingSSL",null);
					 String outgoing = portletPreferences.getValue("outgoing",null);
					 String outgoingPort = portletPreferences.getValue("outgoingPort",null);
					 String outgoingSSL = portletPreferences.getValue("outgoingSSL",null);
					 String email = portletPreferences.getValue("email",null);
					 String password = portletPreferences.getValue("password",null);
					
					 EmailClient client = new EmailClient(email,password,incomingType,incoming,incomingPort,incomingSSL,outgoing,outgoingPort,outgoingPort);
					 client.sendMessage(toEmail,cc,bcc,subject,content);				     				
				 }catch(Exception e){
					 request.setAttribute("error",e.getMessage());				 
				 }
	       }else if("reply".equals(action)){
	    	   String page = request.getParameter("pageId");
			   if(page == null) page = "1";
			   int pageId = Integer.parseInt(page);
			   String toEmail = request.getParameter("toEmail");			   
			   String subject = request.getParameter("subject");
			   String content = request.getParameter("content");			   
			   if(toEmail != null) toEmail = URLDecoder.decode(toEmail,_CHARSET_UTF);			   
			   if(subject != null) subject = URLDecoder.decode(subject,_CHARSET_UTF);		   	
			   if(content != null) content = URLDecoder.decode(content,_CHARSET_UTF).replaceAll("\n","").trim();
			   request.setAttribute("toEmail",toEmail);
			   request.setAttribute("subject","Re: "+subject);
			   request.setAttribute("content",content);
			   request.setAttribute("pageId",pageId);
			   response.setPortletMode(PortletMode.EDIT);
			   response.setRenderParameter("type","create");
	       }else if("config".equals(action)){
	    	   String incomingType = request.getParameter("incomingType");
	    	   String incoming = request.getParameter("incoming");
	    	   String incomingPort = request.getParameter("incomingPort");
	    	   String incomingSSL = request.getParameter("incomingSSL");
	    	   String outgoing = request.getParameter("outgoing");
	    	   String outgoingPort = request.getParameter("outgoingPort");
	    	   String outgoingSSL = request.getParameter("outgoingSSL");
	    	   String email = request.getParameter("email");
	    	   String password = request.getParameter("password");
	    	   String number = request.getParameter("number");
	    	   if(incoming == null || incoming.length() <= 0 
	    		 || outgoing == null || outgoing.length() <= 0
	    		 || email == null || email.length() <= 0
	    		 || password == null || password.length() <=0){
				   request.setAttribute("error","Please input all required fields.");
				   request.setAttribute("mode","config");
				   return;
			   }
	    	   if(email != null) email = URLDecoder.decode(email,_CHARSET_UTF);	    	   
	    	   PortletPreferences portletPreferences = request.getPreferences();
			   portletPreferences.setValue("incomingType",incomingType);	
			   portletPreferences.setValue("incoming",incoming);
			   portletPreferences.setValue("incomingPort",incomingPort);
			   portletPreferences.setValue("incomingSSL",incomingSSL);
			   portletPreferences.setValue("outgoing",outgoing);	
			   portletPreferences.setValue("outgoingPort",outgoingPort);	
			   portletPreferences.setValue("outgoingSSL",outgoingSSL);	
			   portletPreferences.setValue("email",email);	
			   portletPreferences.setValue("password",password);
			   portletPreferences.setValue("number",number);
			   portletPreferences.store();
			   request.getPortletSession().removeAttribute("mails",PortletSession.APPLICATION_SCOPE);
	       }else if("delete".equals(action)){
	    	   if(request.getParameter("parameter") != null){
				 int index = Integer.parseInt(request.getParameter("parameter"));
				 List<MailBean> mails = (List<MailBean>)request.getPortletSession().getAttribute("mails",PortletSession.APPLICATION_SCOPE);
				 PortletPreferences portletPreferences = request.getPreferences();
				 String incomingType = portletPreferences.getValue("incomingType",null);
				 String incoming = portletPreferences.getValue("incoming",null);
				 String incomingPort = portletPreferences.getValue("incomingPort",null);
		    	 String incomingSSL = portletPreferences.getValue("incomingSSL",null);
				 String outgoing = portletPreferences.getValue("outgoing",null);
				 String outgoingPort = portletPreferences.getValue("outgoingPort",null);
				 String outgoingSSL = portletPreferences.getValue("outgoingSSL",null);
				 String email = portletPreferences.getValue("email",null);
				 String password = portletPreferences.getValue("password",null);				 
				 EmailClient client = new EmailClient(email,password,incoming,incomingType,incomingPort,incomingSSL,outgoing,outgoingPort,outgoingPort);
				 try{
					 client.deleteMessage(mails.get(index).getMsg());
					 request.getPortletSession().removeAttribute("mails",PortletSession.APPLICATION_SCOPE);
				 }catch(Exception e){
					 request.setAttribute("error",e.getMessage());				 
				 }
			 }   
	       }else{
				 String showHtmlEditor = request.getParameter("htmlEditor");
				 if(showHtmlEditor != null)
					 request.setAttribute("showHtmlEditor",true);
				 String toEmail = request.getParameter("toEmail");
				 if(toEmail != null){
					 toEmail = URLDecoder.decode(toEmail,_CHARSET_UTF);		   			   
					 request.setAttribute("toEmail",toEmail);
				 }	
				 String cc = request.getParameter("cc");
				 if(cc != null){
					 cc = URLDecoder.decode(cc,_CHARSET_UTF);		   			   
					 request.setAttribute("cc",cc);
				 }
		    	 String bcc = request.getParameter("bcc");
		    	 if(bcc != null){
		    		 bcc = URLDecoder.decode(bcc,_CHARSET_UTF);		   			   
					 request.setAttribute("subject",bcc);
				 }
				 String subject = request.getParameter("subject");
				 if(subject != null){
					 subject = URLDecoder.decode(subject,_CHARSET_UTF);		   			   
					 request.setAttribute("subject",subject);
				 }
				 String content = request.getParameter("content");
				 if(content != null){
					 content = URLDecoder.decode(content,_CHARSET_UTF);
					 request.setAttribute("content",content);
				 }
				 response.setRenderParameter("type","create");
			}
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		 if(request.getPortletSession().getAttribute("mails",PortletSession.APPLICATION_SCOPE) == null 
		   || request.getParameter("refresh") != null){
			 PortletPreferences portletPreferences = request.getPreferences();
			 String incomingType = portletPreferences.getValue("incomingType",null);
			 String incoming = portletPreferences.getValue("incoming",null);
			 String incomingPort = portletPreferences.getValue("incomingPort",null);
	    	 String incomingSSL = portletPreferences.getValue("incomingSSL",null);
			 String outgoing = portletPreferences.getValue("outgoing",null);
			 String outgoingPort = portletPreferences.getValue("outgoingPort",null);
			 String outgoingSSL = portletPreferences.getValue("outgoingSSL",null);
			 String email = portletPreferences.getValue("email",null);
			 String password = portletPreferences.getValue("password",null);
			 String number = portletPreferences.getValue("number","10");			 
			 if(incoming == null || outgoing == null || email == null || password == null){
				 request.setAttribute("incomingPort","110");				 
				 request.setAttribute("outgoingPort","25");
				 request.setAttribute("number",number);
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/email/emailPortletConfig.jsp").include(request,response);
			 }else{
				 List<MailBean> mails = null;				 
				 EmailClient client = new EmailClient(email,password,incomingType,incoming,incomingPort,incomingSSL,outgoing,outgoingPort,outgoingPort);
				 try{
					 mails = client.checkInbox(EmailClient.SHOW_MESSAGES);
				 }catch(Exception e){
					 request.setAttribute("error",e.getMessage());				 
				 }
				 
				 int count = mails.size();
				 int pageId =1;
				 int row = Integer.parseInt(number);
			     int pages = count / row;
			     if( count % row != 0)
			    	 pages++;		
			     
			     List<MailBean> pageMails = new ArrayList<MailBean>();
			     for(int i= (pageId - 1) * row;i< pageId * row;i++){
			    	 if(i >= mails.size()) break;
			    	 pageMails.add(mails.get(i));
			     }
			     request.getPortletSession().setAttribute("mails",mails,PortletSession.APPLICATION_SCOPE);
				 request.getPortletSession().setAttribute("totalCount",count,PortletSession.APPLICATION_SCOPE);
				 request.getPortletSession().setAttribute("pages",pages,PortletSession.APPLICATION_SCOPE);
				 request.getPortletSession().setAttribute("row",row,PortletSession.APPLICATION_SCOPE);
				 request.setAttribute("pageId",pageId);
				 request.setAttribute("pageMails",pageMails);
				 if(request.getWindowState().equals(WindowState.MAXIMIZED))
					 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/email/emailPortletMaxView.jsp").include(request,response);  
				 else
					 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/email/emailPortletView.jsp").include(request,response);
			 }
		 }else{
			 if(request.getParameter("mailId") != null){
				 int index = Integer.parseInt(request.getParameter("mailId"));
				 List<MailBean> mails = (List<MailBean>)request.getPortletSession().getAttribute("mails",PortletSession.APPLICATION_SCOPE);
				 request.setAttribute("currentMail",mails.get(index));
				 String pageId = request.getParameter("pageId");
				 if(pageId == null) pageId="1";
				 request.setAttribute("pageId",Integer.parseInt(pageId));
			 }else{
				String page = request.getParameter("pageId");
				if(page == null) page = "1";
				int pageId = Integer.parseInt(page);
				List<MailBean> mails = (List<MailBean>)request.getPortletSession().getAttribute("mails",PortletSession.APPLICATION_SCOPE);
				int row = (Integer)request.getPortletSession().getAttribute("row",PortletSession.APPLICATION_SCOPE);
				List<MailBean> pageMails = new ArrayList<MailBean>();
			    for(int i= (pageId - 1) * row;i< pageId * row;i++){
			    	if(i >= mails.size()) break; 
			    	pageMails.add(mails.get(i));
			    }
			    request.setAttribute("pageId",pageId);
				request.setAttribute("pageMails",pageMails);
			 }
			 if(request.getWindowState().equals(WindowState.MAXIMIZED))
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/email/emailPortletMaxView.jsp").include(request,response);  
			 else
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/email/emailPortletView.jsp").include(request,response);
		 }
	 }
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {		
		 if(request.getParameter("type") != null 
		   && request.getParameter("type").equals("create")){
			 String page = request.getParameter("pageId");
			 if(page == null) page = "1";
			 int pageId = Integer.parseInt(page);
			 request.setAttribute("pageId",pageId);
			 if(request.getWindowState().equals(WindowState.MAXIMIZED))
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/email/emailPortletMaxEdit.jsp").include(request,response);  
			 else
				 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/email/emailPortletEdit.jsp").include(request,response);			 
		 }else{
			 PortletPreferences portletPreferences = request.getPreferences();
			 String incomingType = portletPreferences.getValue("incomingType",null);
			 String incoming = portletPreferences.getValue("incoming",null);
			 String incomingPort = portletPreferences.getValue("incomingPort",null);
	    	 String incomingSSL = portletPreferences.getValue("incomingSSL",null);
			 String outgoing = portletPreferences.getValue("outgoing",null);
			 String outgoingPort = portletPreferences.getValue("outgoingPort",null);
			 String outgoingSSL = portletPreferences.getValue("outgoingSSL",null);
			 String email = portletPreferences.getValue("email",null);
			 String password = portletPreferences.getValue("password",null);
			 String number = portletPreferences.getValue("number","10");
			 request.setAttribute("incomingType",incomingType);
			 request.setAttribute("incoming",incoming);
			 request.setAttribute("incomingPort",incomingPort);
			 request.setAttribute("incomingSSL",incomingSSL);
			 request.setAttribute("outgoing",outgoing);
			 request.setAttribute("outgoingPort",outgoingPort);
			 request.setAttribute("outgoingSSL",outgoingSSL);
			 request.setAttribute("email",email);
			 request.setAttribute("password",password);
			 request.setAttribute("number",number);
			 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/email/emailPortletConfig.jsp").include(request,response);
		 }
	 }
	 
//	 protected void doCofig (RenderRequest request, RenderResponse response)
//	   throws PortletException, java.io.IOException
//	 {			
//		 PortletPreferences portletPreferences = request.getPreferences();
//		 String incomingType = portletPreferences.getValue("incomingType",null);
//		 String incoming = portletPreferences.getValue("incoming",null);
//		 String outgoing = portletPreferences.getValue("outgoing",null);
//		 String email = portletPreferences.getValue("email",null);
//		 String password = portletPreferences.getValue("password",null);
//		 request.setAttribute("incomingType",incomingType);
//		 request.setAttribute("incoming",incoming);
//		 request.setAttribute("outgoing",outgoing);
//		 request.setAttribute("email",email);
//		 request.setAttribute("password",password);
//		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/email/emailPortletConfig.jsp").include(request,response);
//	 }
}
