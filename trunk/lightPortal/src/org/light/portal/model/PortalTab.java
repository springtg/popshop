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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.light.portal.core.PortalContextFactory;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class PortalTab extends Entity {

	private String label;
	private String url;
	private int closeable;
	private int editable;
	private int moveable;
	private int allowAddContent;
	private String color;
	private int defaulted;
	private int between;
	private String widths;
	private String portletWindowType;	
	private String userId;
	private int fitScreen =1;
	private int status;//0 just for me; 1 profile page; 2 available for friends; 3 open to public;
	private long parentId;//0 top level page;
	private Set<PortletObject> portlets = new HashSet<PortletObject>();
	private Portal portal;
	
	//read only
	private int portletsCount;
	
	public PortalTab(){
		super();		
	}

	public PortalTab(String label
			,String url
			,int closeable			
			,String color
			,int defaulted
			,int between
			,String widths
			,String portletWindowType					
			,String userId				
			){
		this();
		try{			
			this.label =label;
			if(url == null)
				this.url="";
			else
				this.url = url;
			this.closeable = closeable;
			this.editable = 1;
			this.moveable = 1;
			this.allowAddContent = 1;
			if(color == null)
				this.color="";
			else
				this.color = color;
			this.defaulted = defaulted;
			this.between = between;
			this.widths = widths;
			this.portletWindowType = portletWindowType;		
			this.userId = userId;
		}catch(Exception e){			
		}
					
	}
	
	public PortalTab(String label
			,String url
			,int closeable
			,int editable
			,int moveable
			,int allowAddContent
			,String color
			,int defaulted
			,int between
			,String widths
			,String portletWindowType					
			,String userId	
			,int parentId
			){
			this();
			try{			
				this.label = label;
				if(url == null)
					this.url="";
				else
					this.url = url;
				this.closeable = closeable;
				this.editable = editable;
				this.moveable = moveable;
				this.allowAddContent = allowAddContent;
				if(color == null)
					this.color="";
				else
					this.color = color;
				this.defaulted = defaulted;
				this.between = between;
				this.widths = widths;
				this.portletWindowType = portletWindowType;		
				this.userId = userId;
				this.parentId = parentId;
			}catch(Exception e){
				
			}
					
	}
	public PortalTab(String label
			,String url
			,int closeable			
			,String color
			,int defaulted
			,int between
			,String widths
			,String portletWindowType					
			,String userId	
			,int parentId
			){
		this();
		try{			
			this.label =label;
			if(url == null)
				this.url="";
			else
				this.url = url;
			this.closeable = closeable;
			this.editable = 1;
			this.moveable = 1;
			this.allowAddContent = 1;
			if(color == null)
				this.color="";
			else
				this.color = color;
			this.defaulted = defaulted;
			this.between = between;
			this.widths = widths;
			this.portletWindowType = portletWindowType;		
			this.userId = userId;
			this.parentId = parentId;
		}catch(Exception e){			
		}
					
	}
	public PortalTab( PortalTab parent){
		this();
		this.label = parent.getLabel();
		this.url = parent.getUrl();
		this.closeable = parent.getCloseable();
		this.allowAddContent = parent.getAllowAddContent();
		this.between = parent.getBetween();
		this.color = parent.getColor();
		this.defaulted = parent.getDefaulted();
		this.editable = parent.getEditable();
		this.fitScreen = parent.getFitScreen();
		this.moveable = parent.getMoveable();
		this.parentId = parent.getId();
		this.status = parent.getStatus();
		this.portletWindowType = parent.getPortletWindowType();
		this.widths = parent.getWidths();
		this.userId = parent.getUserId();
	}
	public String getTitle(){
		String title = PortalContextFactory.getPortalContext().getMessageByKey(this.label);
		return title;
	}
	public int getColumnTotal(){
		String[] widthCurrentArray = widths.split(",");
		return widthCurrentArray.length;
	}
	public List<String> getColumnWidths(){
		String[] widthCurrentArray = widths.split(",");
		return java.util.Arrays.asList(widthCurrentArray);
	}
	public boolean isTabCloseable(){
		boolean ret = false;
		if(this.closeable == 1)
			ret = true;
		return ret;
	}
	public boolean isTabEditable(){
		boolean ret = false;
		if(this.editable == 1)
			ret = true;
		return ret;
	}	
	public boolean isTabMoveable(){
		boolean ret = false;
		if(this.moveable == 1)
			ret = true;
		return ret;
	}
	public boolean isTabAllowAddContent(){
		boolean ret = false;
		if(this.allowAddContent == 1)
			ret = true;
		return ret;
	}
	public boolean isTabDefaulted(){
		boolean ret = false;
		if(this.defaulted == 1)
			ret = true;
		return ret;
	}
	
	public int getCloseable() {
		return closeable;
	}
	
	public void setCloseable(int closeable) {
		this.closeable = closeable;
	}
	public int getDefaulted() {
		return defaulted;
	}
	
	public void setDefaulted(int defaulted) {
		this.defaulted = defaulted;
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
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Set<PortletObject> getPortlets() {
		return portlets;
	}
	public void setPortlets(Set<PortletObject> portlets) {
		this.portlets = portlets;
	}
	public int getBetween() {
		return between;
	}
	public void setBetween(int between) {
		this.between = between;
	}
	public String getWidths() {
		return widths;
	}
	public void setWidths(String widths) {
		this.widths = widths;
	}
	
	public String getPortletWindowType() {
		return portletWindowType;
	}
	public void setPortletWindowType(String portletWindowType) {
		this.portletWindowType = portletWindowType;
	}
	public Portal getPortal() {
		return portal;
	}
	public void setPortal(Portal portal) {
		this.portal = portal;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAllowAddContent() {
		return allowAddContent;
	}

	public void setAllowAddContent(int allowAddContent) {
		this.allowAddContent = allowAddContent;
	}

	public int getEditable() {
		return editable;
	}

	public void setEditable(int editable) {
		this.editable = editable;
	}

	public int getMoveable() {
		return moveable;
	}
	

	public void setMoveable(int moveable) {
		this.moveable = moveable;
	}

	public int getPortletsCount() {
		return portletsCount;
	}

	public void setPortletsCount(int portletsCount) {
		this.portletsCount = portletsCount;
	}

	public int getFitScreen() {
		return fitScreen;
	}

	public void setFitScreen(int fitScreen) {
		this.fitScreen = fitScreen;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	

}
