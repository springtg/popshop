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
package org.light.portal.model;

import java.util.Set;

import org.light.portal.core.PortalContextFactory;

/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class PortletObject extends Entity {
	
	private int column;
	private int row;
	private String label;
	private String icon;
	private String url;
	private String name;
	private String path;
	private int closeable;
	private int refreshMode;
	private int editMode;
	private int helpMode;
	private int configMode;
	private int minimized = 1;
	private int maximized = 1;
	private String windowSkin;
	private int autoRefreshed;
	private int periodTime;
	private int showNumber;
	private int showType;
	private int windowStatus;
	private int mode;
	private int type; //render type 0 asyn load using ajax, 1 sync load at server side, client get portlet view from JSP 
	private String parameter;
	private int allowJS;
	private int pageRefreshed;
	private long tabId;
	private String barBgColor="";
	private String barFontColor="";
	private String contentBgColor="";
	private String textColor="";
	private int transparent = 0;
	private int mobile = 0;
	private Set preferences;
	
	public PortletObject(){
		super();		
	}
	
	public PortletObject(long tabId, PortletObject portletObject){
		this();
		this.tabId = tabId;
		this.column = portletObject.getColumn();
		this.row = portletObject.getRow();
		this.label = portletObject.getLabel();
		this.icon = portletObject.getIcon();
		this.url = portletObject.getUrl();
		this.name = portletObject.getName();
		this.path = portletObject.getPath();
		this.closeable = portletObject.getCloseable();
		this.refreshMode = portletObject.getRefreshMode();
		this.editMode = portletObject.getEditMode();
		this.helpMode = portletObject.getHelpMode();
		this.configMode = portletObject.getConfigMode();
		this.minimized = portletObject.getMinimized();
		this.maximized = portletObject.getMaximized();
		this.windowSkin = portletObject.getWindowSkin();
		this.autoRefreshed = portletObject.getAutoRefreshed();
		this.periodTime = portletObject.getPeriodTime();
		this.showNumber = portletObject.getShowNumber();
		this.showType = portletObject.getShowType();
		this.windowStatus = portletObject.getWindowStatus();
		this.mode = portletObject.getMode();
		this.type = portletObject.getType();
		this.pageRefreshed = portletObject.getPageRefreshed();
		this.allowJS = portletObject.getAllowJS();
		this.parameter = portletObject.getParameter();
		this.barBgColor = portletObject.getBarBgColor();
		this.barFontColor = portletObject.getBarFontColor();
		this.contentBgColor = portletObject.getContentBgColor();
	}
	
	public PortletObject(long tabId, int column, int row, PortletObject portletObject){
		this();
		this.tabId = tabId;
		this.column = column;
		this.row = row;
		this.label = portletObject.getLabel();
		this.icon = portletObject.getIcon();
		this.url = portletObject.getUrl();
		this.name = portletObject.getName();
		this.path = portletObject.getPath();
		this.closeable = portletObject.getCloseable();
		this.refreshMode = portletObject.getRefreshMode();
		this.editMode = portletObject.getEditMode();
		this.helpMode = portletObject.getHelpMode();
		this.configMode = portletObject.getConfigMode();
		this.minimized = portletObject.getMinimized();
		this.maximized = portletObject.getMaximized();
		this.windowSkin = portletObject.getWindowSkin();
		this.autoRefreshed = portletObject.getAutoRefreshed();
		this.periodTime = portletObject.getPeriodTime();
		this.showNumber = portletObject.getShowNumber();
		this.showType = portletObject.getShowType();
		this.windowStatus = portletObject.getWindowStatus();
		this.mode = portletObject.getMode();
		this.type = portletObject.getType();
		this.pageRefreshed = portletObject.getPageRefreshed();
		this.allowJS = portletObject.getAllowJS();
		this.parameter = portletObject.getParameter();
		this.barBgColor = portletObject.getBarBgColor();
		this.barFontColor = portletObject.getBarFontColor();
		this.contentBgColor = portletObject.getContentBgColor();
	}
	
//	public PortletObject(long tabId, int column, int row, PortletObjectRef ref){
//		this();
//		this.tabId = tabId;
//		this.column = column;
//		this.row = row;
//		this.label = ref.getLabel();
//		this.icon = ref.getIcon();
//		this.url = ref.getUrl();
//		this.name = ref.getName();
//		this.path = ref.getPath();
//		this.closeable = 1;
//		this.refreshMode = ref.getRefreshMode();
//		this.editMode = ref.getEditMode();
//		this.helpMode = ref.getHelpMode();
//		this.configMode = ref.getConfigMode();
//		this.minimized = ref.getMinimized();
//		this.maximized = ref.getMaximized();
//		//this.windowSkin = ref.getWindowSkin();
//		this.autoRefreshed = ref.getAutoRefreshed();
//		this.periodTime = ref.getPeriodTime();
//		this.showNumber = ref.getShowNumber();
//		this.showType = ref.getShowType();
//		this.windowStatus = ref.getWindowStatus();
//		this.mode = ref.getMode();
//		this.type = ref.getType();
//		this.pageRefreshed = ref.getPageRefreshed();
//		this.allowJS = ref.getAllowJS();
//		this.parameter = ref.getParameter();
//	}
	public PortletObject(long tabId, int column, int row, PortletObjectRef ref, boolean flag,boolean skin){
		this();
		this.tabId = tabId;
		this.column = column;
		this.row = row;
		this.label = ref.getLabel();
		this.icon = ref.getIcon();
		this.url = ref.getUrl();
		this.name = ref.getName();
		this.path = ref.getPath();
		this.closeable = flag? 1:0;
		this.refreshMode = ref.getRefreshMode();
		this.editMode = flag? 1:0;
		this.helpMode = flag? 1:0;
		this.configMode = flag? 1:0;
		this.minimized = ref.getMinimized();
		this.maximized = ref.getMaximized();
		if(skin)
			this.windowSkin = ref.getWindowSkin();
		this.autoRefreshed = ref.getAutoRefreshed();
		this.periodTime = ref.getPeriodTime();
		this.showNumber = ref.getShowNumber();
		this.showType = ref.getShowType();
		this.windowStatus = ref.getWindowStatus();
		this.mode = ref.getMode();
		this.type = ref.getType();
		this.pageRefreshed = ref.getPageRefreshed();
		this.allowJS = ref.getAllowJS();
		this.parameter = ref.getParameter();
	}
	
	public PortletObject(long tabId, int column, int row, boolean notCloseable, boolean noEditMode, boolean noConfigMode, String barBgColor, String barFontColor, String contentBgColor, PortletObjectRef ref){
		this();
		this.tabId = tabId;
		this.column = column;
		this.row = row;
		if(!notCloseable) this.closeable = 1;
		if(barBgColor != null) this.barBgColor = barBgColor;
		if(barFontColor != null) this.barFontColor = barFontColor;
		if(contentBgColor != null) this.contentBgColor = contentBgColor;
		this.label = ref.getLabel();
		this.icon = ref.getIcon();
		this.url = ref.getUrl();
		this.name = ref.getName();
		this.path = ref.getPath();
		this.refreshMode = ref.getRefreshMode();
		this.editMode = ref.getEditMode();
		if(this.editMode == 1 && noEditMode) this.editMode =0;
		this.helpMode = ref.getHelpMode();
		this.configMode = ref.getConfigMode();
		if(this.configMode == 1 && noConfigMode) this.configMode = 0;
		this.minimized = ref.getMinimized();
		this.maximized = ref.getMaximized();
		this.windowSkin = ref.getWindowSkin();
		this.autoRefreshed = ref.getAutoRefreshed();
		this.periodTime = ref.getPeriodTime();
		this.showNumber = ref.getShowNumber();
		this.showType = ref.getShowType();
		this.windowStatus = ref.getWindowStatus();
		this.mode = ref.getMode();
		this.type = ref.getType();
		this.pageRefreshed = ref.getPageRefreshed();
		this.allowJS = ref.getAllowJS();
		this.parameter = ref.getParameter();
	}
	
	public String getTitle(){
	    String title = PortalContextFactory.getPortalContext().getMessageByKey(this.label);	  
	    return title;
	}
	
	public boolean isSupportCloseable(){
		boolean ret = false;
		if(this.closeable == 1)
			ret = true;		
		return ret;
    }
	
	public boolean isSupportRefreshMode(){
		boolean ret = false;
		if(this.refreshMode == 1)
			ret = true;
		
		return ret;
    }
	public boolean isSupportEditMode(){
		boolean ret = false;
		if(this.editMode == 1)
			ret = true;
		
		return ret;
    }
	public boolean isSupportHelpMode(){
		boolean ret = false;
		if(this.helpMode == 1)
			ret = true;
		
		return ret;
    }
	public boolean isSupportConfigMode(){
		boolean ret = false;
		if(this.configMode == 1)
			ret = true;
		
		return ret;
    }
	public boolean isSupportMinimized(){
		boolean ret = false;
		if(this.minimized == 1)
			ret = true;
		
		return ret;
    }
	public boolean isSupportMaximized(){
		boolean ret = false;
		if(this.maximized == 1)
			ret = true;
		
		return ret;
    }
	public boolean isSupportAutoRefreshed(){
		boolean ret = false;
		if(this.autoRefreshed >= 1)
			ret = true;
		
		return ret;
    }
	public boolean isSupportRefreshAtClient(){
		boolean ret = false;
		if(this.autoRefreshed == 2)
			ret = true;
		
		return ret;
    }
	public boolean isSupportJS(){
		boolean ret = false;
		if(this.allowJS == 1)
			ret = true;
		
		return ret;
    }
	public boolean isSupportPageRefreshed(){
		boolean ret = false;
		if(pageRefreshed == 1)
			ret = true;
		
		return ret;
    }
		   
	public int getAutoRefreshed() {
		return autoRefreshed;
	}
	
	public void setAutoRefreshed(int autoRefreshed) {
		this.autoRefreshed = autoRefreshed;
	}
	
	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public int getPeriodTime() {
		return periodTime;
	}

	public void setPeriodTime(int periodTime) {
		this.periodTime = periodTime;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public int getShowNumber() {
		return showNumber;
	}

	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getAllowJS() {
		return allowJS;
	}

	public void setAllowJS(int allowJS) {
		this.allowJS = allowJS;
	}

	public int getEditMode() {
		return editMode;
	}

	public void setEditMode(int editMode) {
		this.editMode = editMode;
	}

	public int getHelpMode() {
		return helpMode;
	}

	public void setHelpMode(int helpMode) {
		this.helpMode = helpMode;
	}

	public int getPageRefreshed() {
		return pageRefreshed;
	}

	public void setPageRefreshed(int pageRefreshed) {
		this.pageRefreshed = pageRefreshed;
	}

	public int getRefreshMode() {
		return refreshMode;
	}

	public void setRefreshMode(int refreshMode) {
		this.refreshMode = refreshMode;
	}

	public long getTabId() {
		return tabId;
	}

	public void setTabId(long tabId) {
		this.tabId = tabId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getBarBgColor() {
		return barBgColor;
	}

	public void setBarBgColor(String barBgColor) {
		this.barBgColor = barBgColor;
	}

	public String getBarFontColor() {
		return barFontColor;
	}

	public void setBarFontColor(String barFontColor) {
		this.barFontColor = barFontColor;
	}

	public String getContentBgColor() {
		return contentBgColor;
	}

	public void setContentBgColor(String contentBgColor) {
		this.contentBgColor = contentBgColor;
	}

	public int getConfigMode() {
		return configMode;
	}

	public void setConfigMode(int configMode) {
		this.configMode = configMode;
	}

	public Set getPreferences() {
		return preferences;
	}

	public void setPreferences(Set preferences) {
		this.preferences = preferences;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getCloseable() {
		return closeable;
	}

	public void setCloseable(int closeable) {
		this.closeable = closeable;
	}

	public int getMode() {
		return mode;
	}
	
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public int getShowType() {
		return showType;
	}
	
	public void setShowType(int showType) {
		this.showType = showType;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}	

	public int getWindowStatus() {
		return windowStatus;
	}
	
	public void setWindowStatus(int windowStatus) {
		this.windowStatus = windowStatus;
	}

	public int getTransparent() {
		return transparent;
	}

	public void setTransparent(int transparent) {
		this.transparent = transparent;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public int getMaximized() {
		return maximized;
	}

	public void setMaximized(int maximized) {
		this.maximized = maximized;
	}

	public int getMinimized() {
		return minimized;
	}

	public void setMinimized(int minimized) {
		this.minimized = minimized;
	}

	public String getWindowSkin() {
		return windowSkin;
	}

	public void setWindowSkin(String windowSkin) {
		this.windowSkin = windowSkin;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	

}
