package org.light.portal.model;

import java.util.ArrayList;
import java.util.List;

public class UserPictureGroup implements Comparable{
	String index;
	String name;
	List<UserPicture> pictues = new ArrayList<UserPicture>();
	
	public UserPictureGroup(String index, String name, UserPicture pic){
		this.index = index;
		this.name = name;
		this.pictues.add(pic);		
	}
	
	public int compareTo(Object obj){
	   if (this == obj)
           return 0;
       if (obj == null)
           return 1;
       if (getClass() != obj.getClass())
           return -1;
       final UserPictureGroup other = (UserPictureGroup) obj;
       return index.compareTo(other.index);          
	}
	public void addPicture(UserPicture pic){
		this.pictues.add(pic);		
	}
	
	public int getCount(){
		return this.pictues.size();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserPicture> getPictues() {
		return pictues;
	}

	public void setPictues(List<UserPicture> pictues) {
		this.pictues = pictues;
	}

}
