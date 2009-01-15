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

import org.light.portal.core.PortalContextFactory;


/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class PortletObjectRef extends Entity {
	
	private String name;
	private String path;
	private String label;
	private String icon;
	private String url;
	private String subTag;
	private String tag;
	private String language;
	private int refreshMode;
	private int editMode;
	private int helpMode;
	private int configMode;
	private int minimized;
	private int maximized;
	private String windowSkin;
	private int autoRefreshed;
	private int allowJS;
	private int pageRefreshed;
	private int periodTime;
	private int showNumber;
	private int showType;
	private int windowStatus;
	private int mode;
	private int type;
	private String parameter;		
	private String userId;
	private String createdBy;
	private long orgId;
	
	public PortletObjectRef(){
		super();
	}
	public PortletObjectRef(String name
						,String path
						,String label
						,String icon
						,String url	
						,String subTag
						,String tag	
						,String language
						,int refreshMode
						,int editMode
						,int helpMode
						,int configMode
						,int minimized
						,int maximized
						,String windowSkin
						,int autoRefreshed
						,int periodTime
						,int allowJS
						,int pageRefreshed
						,int showNumber
						,int showType
						,int windowStatus
						,int mode
						,int type
						,String parameter
						,String userId){
	   this.name = name;
	   this.path = path;
	   this.label = label;
	   this.icon = icon;
	   this.url = url;	
	   this.subTag = subTag;
	   this.tag = tag;
	   this.language = language;
	   this.refreshMode = refreshMode;
	   this.editMode = editMode;
	   this.helpMode = helpMode;
	   this.configMode = configMode;
	   this.minimized = minimized;
	   this.maximized = maximized;
	   this.windowSkin = windowSkin;
	   this.autoRefreshed = autoRefreshed;
	   this.periodTime = periodTime;
	   this.allowJS = allowJS;
	   this.pageRefreshed = pageRefreshed;
	   this.showNumber = showNumber;
	   this.showType = showType;
	   this.windowStatus = windowStatus;
	   this.mode = mode;
	   this.type = type;
	   this.parameter = parameter;
	   this.userId = userId;
	}
	public PortletObjectRef(String name
			,String path
			,String label
			,String icon
			,String url	
			,String subTag
			,String tag	
			,String language
			,int refreshMode
			,int editMode
			,int helpMode
			,int configMode
			,int minimized
			,int maximized
			,String windowSkin
			,int autoRefreshed
			,int periodTime
			,int allowJS
			,int pageRefreshed
			,int showNumber
			,int showType
			,int windowStatus
			,int mode
			,int type
			,String parameter
			,String userId
			,String createdBy){
	this.name = name;
	this.path = path;
	this.label = label;
	this.icon = icon;
	this.url = url;	
	this.subTag = subTag;
	this.tag = tag;
	this.language = language;
	this.refreshMode = refreshMode;
	this.editMode = editMode;
	this.helpMode = helpMode;
	this.configMode = configMode;
	this.minimized = minimized;
    this.maximized = maximized;
    this.windowSkin = windowSkin;
	this.autoRefreshed = autoRefreshed;
	this.periodTime = periodTime;
	this.allowJS = allowJS;
	this.pageRefreshed = pageRefreshed;
	this.showNumber = showNumber;
	this.showType = showType;
	this.windowStatus = windowStatus;
	this.mode = mode;
	this.type = type;
	this.parameter = parameter;
	this.userId = userId;
	this.createdBy = createdBy;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getTagTitle()+":"+getTitle();
    }

	/**
	 * @see java.lang.Object#equals(Object)
	 */
    public boolean equals(Object other) {
        if ( !(other instanceof PortletObjectRef) ) return false;
        PortletObjectRef castOther = (PortletObjectRef) other;
        if(this.hashCode()!=castOther.hashCode()) return false;
        return true;
    }

	/**
	 * @see java.lang.Object#hashCode()
	 */
    public int hashCode() {    	
        return getName().hashCode();
    }
		
	public boolean isNeedPrefix(){
		boolean ret = false;
		if(this.icon != null)
			ret = this.icon.startsWith("/");
		return ret;
	}
	
	public PortletObjectRef(PortletObjectRef ref, String userId){
		this.name = ref.getName();
		this.path = ref.getPath();
		this.label = ref.getLabel();
		this.icon = ref.getIcon();
		this.url = ref.getUrl();
		this.subTag = ref.getSubTag();
		this.tag = ref.getTag();
		this.language = ref.getLanguage();
		this.refreshMode = ref.getRefreshMode();
		this.editMode = ref.getEditMode();
		this.helpMode = ref.getHelpMode();
		this.configMode = ref.getConfigMode();
		this.autoRefreshed = ref.getAutoRefreshed();
		this.periodTime = ref.getPeriodTime();
		this.allowJS = ref.getAllowJS();
		this.pageRefreshed = ref.getPageRefreshed();
		this.showNumber = ref.getShowNumber();
		this.showType = ref.getShowType();
		this.windowStatus = ref.getWindowStatus();
		this.mode = ref.getMode();
		this.type = ref.getType();
		this.parameter = ref.getParameter();
		this.userId = userId;
	}
	
	public String getSubTagTitle(){
		String title = PortalContextFactory.getPortalContext().getMessageByKey(this.subTag);		
		return title;
	}
	
	public String getTagTitle(){
		String title = PortalContextFactory.getPortalContext().getMessageByKey(this.tag);		
		return title;
	}
	
	public String getTitle(){
		String title = PortalContextFactory.getPortalContext().getMessageByKey(this.label);		
		return title;
	}
	
	public int getAllowJS() {
		return allowJS;
	}

	public void setAllowJS(int allowJS) {
		this.allowJS = allowJS;
	}

	public int getAutoRefreshed() {
		return autoRefreshed;
	}

	public void setAutoRefreshed(int autoRefreshed) {
		this.autoRefreshed = autoRefreshed;
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

	public int getRefreshMode() {
		return refreshMode;
	}

	public void setRefreshMode(int refreshMode) {
		this.refreshMode = refreshMode;
	}


	public int getShowNumber() {
		return showNumber;
	}

	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public int getConfigMode() {
		return configMode;
	}
	public void setConfigMode(int configMode) {
		this.configMode = configMode;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
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
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSubTag() {
		return subTag;
	}
	
	public void setSubTag(String subTag) {
		this.subTag = subTag;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	public long getOrgId() {
		return orgId;
	}
	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	
	
	
		
}

