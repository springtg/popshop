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
package org.light.portal.portlet.core.impl;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import org.light.portal.model.PortletObject;
import org.light.portal.portlet.factory.PortletContainerFactory;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class PortletWindow {
	private String name;
	private WindowState windowState;
	private PortletMode portletMode;
	private String portletId;
	private String tabId;
	private String responseId;
	private PortletObject portletObject;
	
	public PortletWindow (String name, WindowState windowState, PortletMode portletMode, PortletObject portletObject) {
		this.name = name;
		this.windowState = windowState;
		this.portletMode = portletMode;
		this.portletObject = portletObject;
	}
	
	public String getName(){
		return this.name;
	}
	
	public org.light.portal.portlet.definition.Portlet getDefition(){
		return PortletContainerFactory.getPortletContainer().getPortletDefinitionByName(this.name);
	}
	
	public PortletMode getPortletMode() {
		return this.portletMode;
	}

	public void setPortletMode(PortletMode portletMode) {
		this.portletMode = portletMode;
	}

	public PortletObject getPortletObject() {
		return portletObject;
	}

	public void setPortletObject(PortletObject portletObject) {
		this.portletObject = portletObject;
	}

	public WindowState getWindowState() {
		return windowState;
	}

	public void setWindowState(WindowState windowState) {
		this.windowState = windowState;
	}
}
