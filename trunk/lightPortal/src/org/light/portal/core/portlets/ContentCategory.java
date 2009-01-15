package org.light.portal.core.portlets;

import java.util.ArrayList;
import java.util.List;

import org.light.portal.model.PortletObjectRef;

public class ContentCategory {
	private String name;
	private String title;
	private boolean showed;
	private List<ContentSubCategory> subCategories;
	private List<PortletObjectRef> feedLists = new ArrayList<PortletObjectRef>();
	
	public ContentCategory(String name, String title){
		this.name = name;
		this.title = title;
	}
	
	public void addSub(ContentSubCategory sub){
		subCategories.add(sub);
	}
	
	public void addFeed(PortletObjectRef ref){
		feedLists.add(ref);
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
        return getName().toString();
    }

	/**
	 * @see java.lang.Object#equals(Object)
	 */
    public boolean equals(Object other) {
        if ( !(other instanceof ContentCategory) ) return false;
		ContentCategory castOther = (ContentCategory) other;
        if(this.hashCode()!=castOther.hashCode()) return false;
        return true;
    }

	/**
	 * @see java.lang.Object#hashCode()
	 */
    public int hashCode() {    	
        return getName().hashCode();
    }
	public boolean isShowed() {
		return showed;
	}
	

	public void setShowed(boolean showed) {
		this.showed = showed;
	}
	

	public List<PortletObjectRef> getFeedLists() {
		return feedLists;
	}
	

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public List<ContentSubCategory> getSubCategories() {
		return subCategories;
	}
	

	public void setSubCategories(List<ContentSubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
	
	
}
