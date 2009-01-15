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
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class PortalRole extends Entity {
	private String roleId;
	private int allowLookAndFeel;
	private int allowLayout;
	private int allowAddTab;
	private int allowAddContent;
	private int allowSignIn;
	private int allowTurnOff;
	private String title;
	private String theme;
	
	public PortalRole(){
		super();
	}
	public PortalRole(String roleId,int allowLookAndFeel,int allowLayout,int allowAddTab
			,int allowAddContent,int allowSignIn,int allowTurnOff, String title, String theme){
		this();
		this.roleId = roleId;
		this.allowLookAndFeel = allowLookAndFeel;
		this.allowLayout = allowLayout;
		this.allowAddTab = allowAddTab;
		this.allowAddContent = allowAddContent;
		this.allowSignIn = allowSignIn;
		this.allowTurnOff = allowTurnOff;
		this.title = title;
		this.theme = theme;
	}
	public int getAllowAddContent() {
		return allowAddContent;
	}
	public void setAllowAddContent(int allowAddContent) {
		this.allowAddContent = allowAddContent;
	}
	public int getAllowAddTab() {
		return allowAddTab;
	}
	public void setAllowAddTab(int allowAddTab) {
		this.allowAddTab = allowAddTab;
	}
	public int getAllowLayout() {
		return allowLayout;
	}
	public void setAllowLayout(int allowLayout) {
		this.allowLayout = allowLayout;
	}
	public int getAllowLookAndFeel() {
		return allowLookAndFeel;
	}
	public void setAllowLookAndFeel(int allowLookAndFeel) {
		this.allowLookAndFeel = allowLookAndFeel;
	}
	public int getAllowSignIn() {
		return allowSignIn;
	}
	public void setAllowSignIn(int allowSignIn) {
		this.allowSignIn = allowSignIn;
	}
	public int getAllowTurnOff() {
		return allowTurnOff;
	}
	public void setAllowTurnOff(int allowTurnOff) {
		this.allowTurnOff = allowTurnOff;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
		
}
