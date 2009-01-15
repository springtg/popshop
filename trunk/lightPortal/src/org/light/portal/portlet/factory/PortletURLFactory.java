package org.light.portal.portlet.factory;

import javax.portlet.PortletURL;

import org.light.portal.portlet.core.impl.PortletURLImpl;
import org.light.portal.portlet.core.impl.PortletWindow;

import static org.light.portal.util.Constants._LIGHT_PORTAL;
public class PortletURLFactory {
	private static PortletURLFactory instance = new PortletURLFactory();
	public static PortletURLFactory getInstance(){
		return instance;
	}
	public PortletURL getPortletURL(PortletWindow portletWindow, 
			 javax.servlet.http.HttpServletRequest request,
			 javax.servlet.http.HttpServletResponse response,
			 boolean isAction){		

		return new PortletURLImpl(portletWindow, request, response, isAction);
	}
}

