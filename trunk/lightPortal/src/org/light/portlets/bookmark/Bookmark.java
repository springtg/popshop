package org.light.portlets.bookmark;

import static org.light.portal.util.Constants._CHARSET_UTF;

import java.net.URLDecoder;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.model.Entity;

public class Bookmark extends Entity{

   private String name;
   private String url;
   private String desc;
   private String tagId;
   private String tagName;
   private long userId;

   public Bookmark(){
       super();
   }
   
   public Bookmark(String name, String url, String tagId, String tagName, String desc, long userId){
       this();
       this.name = name;
       this.url = url;
       this.tagId = tagId;
       this.tagName = tagName;
       this.desc = desc;
       this.userId = userId;
   }
   
   public Bookmark(long id,String name, String url, String tagId, String tagName, String desc, long userId){
       this();
	   this.setId(id);
       this.name = name;
       this.url = url;
       this.tagId = tagId;
       this.tagName = tagName;
       this.desc = desc;
       this.userId = userId;
   }
 
   public String getTagNameValue(){
		String tagName = PortalContextFactory.getPortalContext().getMessageByKey(this.tagName);
		return tagName;
	}
   
   /**
    * @see java.lang.Object#toString()
    */
   public String toString() {
       return getName()+"("+getUrl()+")";
   }

   /**
    * @see java.lang.Object#equals(Object)
    */
   public boolean equals(Object other) {
       if ( !(other instanceof Bookmark) ) return false;
       Bookmark castOther = (Bookmark) other;
       if(this.hashCode()!=castOther.hashCode()) return false;
       return true;
   }

   /**
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
       return getName().hashCode();
   }


   public String getName() {
       return name;
   }


   public void setName(String name) {
       this.name = name;
   }

   public String getUrl() {
       return url;
   }


   public void setUrl(String url) {
       this.url = url;
   }


   public long getUserId() {
       return userId;
   }


   public void setUserId(long userId) {
       this.userId = userId;
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

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public String getTagName() {
	return tagName;
}


}
