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
package org.light.portal.core.portlets;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 4, 2006
 **/
import java.net.URLDecoder;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import static org.light.portal.util.Constants._CHARSET_UTF;

import org.light.portal.model.PortalTab;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

/**
 * 
 * @author Jianmin Liu
 * @version 0.5
 * Creation date: April 4, 2006
 **/
public class TabPortlet extends LightGenericPortlet {
	 
	 public void processAction (ActionRequest request, ActionResponse response) 
	    throws PortletException, java.io.IOException {		 
		 
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		StringBuffer resultBuffer = new StringBuffer();
		
		String responseId = (String)request.getParameter("responseId");
		PortalTab portalTab = getPortalTab(request);
		request.setAttribute("tab",portalTab);
		String title = "new tab";
		String widths="300,300,300";
		int columns = 3;
		int between = 10;	
		int closeable = 1;
		int defaulted = 0;
		int status = 0;
		int fitScreen = 1;
		if(portalTab != null){
			title = portalTab.getTitle();
			widths = portalTab.getWidths();
			between = portalTab.getBetween();
			closeable = portalTab.getCloseable();
			defaulted = portalTab.getDefaulted();	
			status = portalTab.getStatus();
			fitScreen = portalTab.getFitScreen();
		}				
		if(request.getParameter("title") != null)
			title = request.getParameter("title");
		    title = URLDecoder.decode(title,_CHARSET_UTF);
		if(request.getParameter("widths") != null)
			widths = request.getParameter("widths");
		if(request.getParameter("between") != null)
			between = Integer.parseInt(request.getParameter("between"));
		if(request.getParameter("closeable") != null)
			closeable = Integer.parseInt(request.getParameter("closeable"));
		if(request.getParameter("defaulted") != null)
			defaulted = Integer.parseInt(request.getParameter("defaulted"));
		if(request.getParameter("status") != null)
			defaulted = Integer.parseInt(request.getParameter("status"));
		if(request.getParameter("fitScreen") != null)
			defaulted = Integer.parseInt(request.getParameter("fitScreen"));
		String pColumns = (String)request.getParameter("columns");
		String[] widthCurrentArray = widths.split(",");
		String[] widthArray = widthCurrentArray;
		if(pColumns != null){
			columns = Integer.parseInt(pColumns);
			widthArray = new String[columns];
			for(int i=0;i<columns;i++){
				if(i < widthCurrentArray.length)
					widthArray[i]=widthCurrentArray[i];
				else
					widthArray[i]="300";
			}
		}
		resultBuffer.append("<form name='form_"+responseId+"'>");
		if(portalTab != null)
			resultBuffer.append("<div class='portlet-form-group'>");
		resultBuffer.append("<table border='0' cellpadding='0' cellspacing='0'>");
		if(portalTab != null){
			resultBuffer.append("<tr>")
						.append("<td class='portlet-table-td-left' colspan='2' >")
						.append("Following setting will take effect after next time turn on portal:")
						.append("</td>")
						.append("</tr>")
						;
		}
		resultBuffer.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("Title:")
					.append("</td>")
					.append("<td class='portlet-table-td-left'>")
					.append("<input type='text' name='ptTitle' value='"+title+"' class='portlet-form-input-field' size='16' /> ")
					.append("</td>")
					.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("Portlet Skin:")
					.append("</td>")
					.append("<td class='portlet-table-td-left'>")
					.append("<select name='ptWindow' size='1'  class='portlet-form-select' >")
					;
		if(portalTab != null && "PortletWindow".equals(portalTab.getPortletWindowType()))
			resultBuffer.append("<option selected='selected' value='PortletWindow'>Classic</option>");
		else
			resultBuffer.append("<option value='PortletWindow'>Classic</option>");
		if(portalTab != null && "PortletWindow2".equals(portalTab.getPortletWindowType()))
			resultBuffer.append("<option selected='selected' value='PortletWindow2'>Traditional</option>");
		else
			resultBuffer.append("<option value='PortletWindow2'>Traditional</option>");	
		if(portalTab != null && "PortletWindow3".equals(portalTab.getPortletWindowType()))
			resultBuffer.append("<option selected='selected' value='PortletWindow3'>None Window Style</option>");
		else
			resultBuffer.append("<option value='PortletWindow3'>None Window Style</option>");	
		resultBuffer.append("</select>")
					.append("</td>")
					.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("Allow to be Closed:")
					.append("</td>")
					.append("<td class='portlet-table-td-left'>")
					;
			if(closeable == 1)
			resultBuffer.append("<INPUT TYPE='CHECKBOX' NAME='ptClose' checked='checked' />");
			else
			resultBuffer.append("<INPUT TYPE='CHECKBOX' NAME='ptClose'/>");
			
			resultBuffer.append("</td>")
					.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("Default tab:")
					.append("</td>")
					.append("<td class='portlet-table-td-left'>")
					;
			if(defaulted == 1)
			resultBuffer.append("<INPUT TYPE='CHECKBOX' NAME='ptDefault'  checked='checked' />");
			else
			resultBuffer.append("<INPUT TYPE='CHECKBOX' NAME='ptDefault'/>");
			resultBuffer.append("</td>")
					.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					.append("Show this tab to my Public Page:")
					.append("</td>")
					.append("<td class='portlet-table-td-left'>")
					;
			if(status == 1)
			resultBuffer.append("<INPUT TYPE='CHECKBOX' NAME='ptStatus'  checked='checked' />");
			else
			resultBuffer.append("<INPUT TYPE='CHECKBOX' NAME='ptStatus'/>");
			resultBuffer.append("</td>")
						.append("</tr>")
						.append("<tr>")
						.append("<td class='portlet-table-td-left'>")
						.append("Tab page will auto fit screen width:")
						.append("</td>")
						.append("<td class='portlet-table-td-left'>")
						;
				if(fitScreen == 1)
				resultBuffer.append("<INPUT TYPE='CHECKBOX' NAME='ptFitScreen'  checked='checked' />");
				else
				resultBuffer.append("<INPUT TYPE='CHECKBOX' NAME='ptFitScreen'/>");
				resultBuffer.append("</td>")
							.append("</tr>");
				
			if(portalTab != null){
				resultBuffer.append("</table>")
							.append("</div>")
							.append("<div class='portlet-form-group'>")
							.append("<table border='0' cellpadding='0' cellspacing='0'>")
							;
			}

			if(portalTab != null){		
				resultBuffer.append("<tr>")
						.append("<td class='portlet-table-td-left' colspan='2' >")
						.append("Following setting will take effect immediately after save :")
						.append("</td>")
						.append("</tr>")
						;
			}
			resultBuffer.append("<tr>")
						.append("<td class='portlet-table-td-left'>")
						.append("Allowed Columns:")
						.append("</td>")
						.append("<td class='portlet-table-td-left'>")
						;
		if(portalTab != null)
			resultBuffer.append("<select name='ptColumns' size='1'  class='portlet-form-select' onchange=\"javascript:changeCurrentTabColumns('"+responseId+"');\" >");
		else
			resultBuffer.append("<select name='ptColumns' size='1'  class='portlet-form-select' onchange=\"javascript:changeTabColumns('"+responseId+"');\" >");
			
		for(int i=1;i<10;i++){
			if(i == widthArray.length)
				resultBuffer.append("<option selected='selected' value='"+i+"'>"+i+"</option>");
			else
				resultBuffer.append("<option value='"+i+"'>"+i+"</option>");
		}
		resultBuffer.append("</select>")
					.append("</td>")
					.append("</tr>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")			
					.append("Columns between width:")
					.append("</td>")
					.append("<td class='portlet-table-td-left'>")
					.append("<input type='text' name='ptBetween' value='"+between+"' class='portlet-form-input-field' size='10'/>")
					.append("</td>")
					.append("</tr>")
					;
		for(int i=0;i<widthArray.length;i++){
			resultBuffer.append("<tr>")
						.append("<td class='portlet-table-td-left'>")			
						.append("Column "+(i+1)+" width:")
						.append("</td>")
						.append("<td class='portlet-table-td-left'>")
						.append("<input type='text' name='ptWidth"+i+"' value='"+widthArray[i]+"' class='portlet-form-input-field' size='10'/>")
						.append("</td>")
						.append("</tr>")						
						;
		}	
		
		resultBuffer.append("</table>");
		if(portalTab != null)
			resultBuffer.append("</div>");
		resultBuffer.append("<table border='0' cellpadding='0' cellspacing='0'>")
					.append("<tr>")
					.append("<td class='portlet-table-td-left'>")
					;
		if(portalTab != null)
			resultBuffer.append("<input name='Submit' type='button' value='Save' class='portlet-form-button'")
						.append(" onclick=\"javascript:editTab('"+responseId+"');\" />");
		else
			resultBuffer.append("<input name='Submit' type='button' value='Add' class='portlet-form-button'")
						.append(" onclick=\"javascript:addTab('"+responseId+"');\" />");
		resultBuffer.append("</td>")
					.append("</tr>")						
					.append(" </table>")		
			        ;
		resultBuffer.append("</form>");
		response.getWriter().print(resultBuffer.toString());
	 }	
}
