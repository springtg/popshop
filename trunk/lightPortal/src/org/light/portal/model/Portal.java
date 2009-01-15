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

import static org.light.portal.util.Constants._DEFAULT_SEARCH_ENGINE;
import static org.light.portal.util.Constants._DEFAULT_THEME;
import static org.light.portal.util.Constants._PORTAL_TITLE_DEFAULT_KEY;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.util.PropUtil;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class Portal extends Entity{
	private String userId;
	private String title = _PORTAL_TITLE_DEFAULT_KEY;
	private String theme = _DEFAULT_THEME;
	//private String language;
	//private String region;
	//private String  timeZone;
	private String bgImage;
	private String bgPosition;
	private int bgRepeat; //0 repeat 1 no repeat 2 repeat x 3 repeat y
	private String headerImage;
	private String headerPosition;
	private int headerRepeat; //0 repeat 1 no repeat 2 repeat x 3 repeat y
	private int headerHeight;
	private String textFont;
	private int fontSize;
	private String textColor;
	private int showLocaleBar;
	private int transparent = 0;
	private int showSearchBar = Integer.parseInt(PropUtil.getString("default.user.searchBar.show"));
	private int maxShowTabs = Integer.parseInt(PropUtil.getString("default.user.maxShowTabs"));
	private String defaultSearchEngine = PropUtil.getString("default.search.engine");
	private int count;	
	private Date createDate = new Date(System.currentTimeMillis());
	private Set<PortalTab> tabs =new HashSet<PortalTab>();
	
	public Portal(){
		super();		
	}
	
	public Portal( String userId, String title, String theme,int showLocaleBar){
		this();
		this.userId = userId;
		if(title != null && !"".equals(title.trim())) this.title = title;
		if(theme != null && !"".equals(theme.trim())) this.theme = theme;
		this.showLocaleBar = showLocaleBar;		
	}
	
	public Portal( String userId, String theme, Set<PortalTab> tabs){
		this();
		this.userId = userId;
		this.theme = theme;
		this.tabs = tabs;
		for(PortalTab tab : this.tabs){
			tab.setPortal(this);
		}
	}
	
	public boolean isShowLocale(){
		boolean ret = false;
		if(this.showLocaleBar == 1)
			ret = true;		
		return ret;
    }
	
	public PortalTab getTabById(int id){
		PortalTab portalTab = null;	
		Iterator<PortalTab> tabs = this.getTabs().iterator();
		while(tabs.hasNext()){
			PortalTab tab = tabs.next();			
			if(tab.getId() == id){	
				portalTab = tab;
				break;
			}
		}
		return portalTab;
	}
	
	public void addTab(PortalTab tab){
		this.tabs.add(tab);
		tab.setPortal(this);
		
	}
	
	public String getPortalTitle(){
		String title = this.title;
		String[] titles = this.title.split("_");
		if(titles.length > 1){
			String title1= PortalContextFactory.getPortalContext().getMessageByKey(titles[1]);			
			title = titles[0] + title1;
		}else{
			title = PortalContextFactory.getPortalContext().getMessageByKey(this.title);				
		}

		return title;
	}
	
//	public String getCountryCode(){
//		String countryCode=_DEFAULT_COUNTRY;
//		if(this.region != null && this.region.indexOf("_") > 0){
//			int index = this.region.indexOf("_");
//			countryCode = this.region.substring(index+1);
//		}
//		return countryCode;
//	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Set<PortalTab> getTabs() {
		return tabs;
	}
	public void setTabs(Set<PortalTab> tabs) {
		this.tabs = tabs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getShowLocaleBar() {
		return showLocaleBar;
	}	
	public void setShowLocaleBar(int showLocaleBar) {
		this.showLocaleBar = showLocaleBar;
	}
	public String getBgImage() {
		return bgImage;
	}
	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public int getHeaderHeight() {
		return headerHeight;
	}
	public void setHeaderHeight(int headerHeight) {
		this.headerHeight = headerHeight;
	}
	public String getHeaderImage() {
		return headerImage;
	}
	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}
	public int getTransparent() {
		return transparent;
	}
	public void setTransparent(int transparent) {
		this.transparent = transparent;
	}
	public String getDefaultSearchEngine() {
		return defaultSearchEngine;
	}
	public void setDefaultSearchEngine(String defaultSearchEngine) {
		this.defaultSearchEngine = defaultSearchEngine;
	}
	public int getShowSearchBar() {
		return showSearchBar;
	}
	public void setShowSearchBar(int showSearchBar) {
		this.showSearchBar = showSearchBar;
	}
	public String getTextColor() {
		return (textColor == null ? "":textColor);
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getBgPosition() {
		return bgPosition;
	}
	public void setBgPosition(String bgPosition) {
		this.bgPosition = bgPosition;
	}
	public int getBgRepeat() {
		return bgRepeat;
	}
	public void setBgRepeat(int bgRepeat) {
		this.bgRepeat = bgRepeat;
	}
	public String getHeaderPosition() {
		return headerPosition;
	}
	public void setHeaderPosition(String headerPosition) {
		this.headerPosition = headerPosition;
	}
	public int getHeaderRepeat() {
		return headerRepeat;
	}
	public void setHeaderRepeat(int headerRepeat) {
		this.headerRepeat = headerRepeat;
	}
	public String getTextFont() {
		return (textFont == null ? "":textFont);
	}
	public void setTextFont(String textFont) {
		this.textFont = textFont;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getMaxShowTabs() {
		return maxShowTabs;
	}

	public void setMaxShowTabs(int maxShowTabs) {
		this.maxShowTabs = maxShowTabs;
	}
}
