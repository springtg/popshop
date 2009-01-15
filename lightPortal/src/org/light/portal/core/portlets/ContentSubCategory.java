package org.light.portal.core.portlets;

import java.util.ArrayList;
import java.util.List;

import org.light.portal.model.PortletObjectRef;

public class ContentSubCategory {
	private String name;
	private String title;
	private boolean showed;
	private List<PortletObjectRef> feedLists = new ArrayList<PortletObjectRef>();
	
	public ContentSubCategory(String name, String title){
		this.name = name;
		this.title = title;
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
        if ( !(other instanceof ContentSubCategory) ) return false;
		ContentSubCategory castOther = (ContentSubCategory) other;
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
	
	
}
