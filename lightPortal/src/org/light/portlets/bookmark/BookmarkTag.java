package org.light.portlets.bookmark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.light.portal.core.PortalContextFactory;

public class BookmarkTag implements Serializable {
   private String tagId;
   private String tagName;
   private boolean expanded;
   private List<Bookmark> bookmarks = new ArrayList<Bookmark>();

   public BookmarkTag(String tagId,String tagName){
       this.tagId = tagId;
       this.tagName = tagName;
   }

   public void addBookmark(Bookmark bookmark){
       this.bookmarks.add(bookmark);
   }
   public void removeBookmark(Bookmark bookmark){
       this.bookmarks.remove(bookmark);
   }
   
   public String getTagName(){
		String tagName = PortalContextFactory.getPortalContext().getMessageByKey(this.tagName);
		return tagName;
	}
   /**
    * @see java.lang.Object#toString()
    */
   public String toString() {
       return getTagName().toString();
   }

   /**
    * @see java.lang.Object#equals(Object)
    */
   public boolean equals(Object other) {
       if ( !(other instanceof BookmarkTag) ) return false;
       BookmarkTag castOther = (BookmarkTag) other;
       if(this.hashCode()!=castOther.hashCode()) return false;
       return true;
   }

   /**
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
       return getTagId().hashCode();
   }

   public boolean isExpanded() {
       return expanded;
   }


   public void setExpanded(boolean expanded) {
       this.expanded = expanded;
   }


   public List<Bookmark> getBookmarks() {
       return bookmarks;
   }

public String getTagId() {
	return tagId;
}

public void setTagId(String tagId) {
	this.tagId = tagId;
}


public void setTagName(String tagName) {
	this.tagName = tagName;
}


}
