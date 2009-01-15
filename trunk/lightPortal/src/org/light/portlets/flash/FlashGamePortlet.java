package org.light.portlets.flash;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.FlashGame;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: Jun 2, 2007
 **/
public class FlashGamePortlet extends LightGenericPortlet {
	
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
	 String action = request.getParameter("action");
	 if("add".equals(action)){	
  	   String link = request.getParameter("link");
  	   String title = request.getParameter("title");
  	   String desc = request.getParameter("desc");
  	   String instructions = request.getParameter("instructions");
  	   String tag = request.getParameter("tag");
  	   int width = Integer.parseInt(request.getParameter("width"));
  	   int height = Integer.parseInt(request.getParameter("height"));  	   
  	   if( link == null || link.length() <= 0 || title== null || title.length() <= 0){
			   request.setAttribute("error","Please input all required fields.");
			   request.setAttribute("mode","edit");
			   return;
		   }
  	   if(link != null) link = URLDecoder.decode(link,_CHARSET_UTF);
  	   if(title != null) title = URLDecoder.decode(title,_CHARSET_UTF);
  	   if(tag != null) tag = URLDecoder.decode(tag,_CHARSET_UTF);
  	   if(desc != null) desc = URLDecoder.decode(desc,_CHARSET_UTF);
  	   if(instructions != null) instructions = URLDecoder.decode(instructions,_CHARSET_UTF);
  	   FlashGame game = new FlashGame(link,title,tag,desc,instructions,width,height,this.getUser(request).getId());
  	   this.getPortalService(request).save(game);
	 }
	}
	
	protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		List<FlashGame> games = this.getPortalService(request).getFlashGames();
		request.setAttribute("games",games);
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/flash/flashGameView.jsp").include(request,response);
		
	 }
	
	protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		String id = request.getParameter("parameter");
		if(id != null){
			FlashGame game = (FlashGame)this.getPortalService(request).getEntityById(FlashGame.class,Integer.parseInt(id));
			request.setAttribute("entity",game);			
		}
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/flash/flashGameEdit.jsp").include(request,response);
		
	 }
	
	protected void doConfig (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {			
		String id = request.getParameter("id");
		if(id != null){
			FlashGame game = (FlashGame)this.getPortalService(request).getEntityById(FlashGame.class,Integer.parseInt(id));
			if(game != null){
				request.setAttribute("game",game);
				this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/flash/flashGameStart.jsp").include(request,response);
			}else
				doView(request,response);	
		}
		else
			doView(request,response);
	 }
}
