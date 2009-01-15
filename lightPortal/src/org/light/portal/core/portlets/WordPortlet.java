package org.light.portal.core.portlets;

import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.NotKeyword;
import org.light.portal.model.NotWord;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class WordPortlet extends LightGenericPortlet {

    public void processAction (ActionRequest request, ActionResponse response)
       throws PortletException, java.io.IOException {
        String action = request.getParameter("action");
    }
    
    protected void doView (RenderRequest request, RenderResponse response)
    throws PortletException, java.io.IOException
  {
    	List<NotKeyword> notKeywords = this.getPortalService(request).getNotKeywords();
    	List<NotWord> notWords = this.getPortalService(request).getNotWords();
    	request.setAttribute("notKeywords",notKeywords);
    	request.setAttribute("notKeywordsTotal",notKeywords.size());
    	request.setAttribute("notWords",notWords);
    	request.setAttribute("notWordsTotal",notWords.size());
    	this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/core/word.jsp").include(request,response);
  }

}
