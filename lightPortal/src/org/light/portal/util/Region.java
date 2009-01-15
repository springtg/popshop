package org.light.portal.util;


public class Region {
	
	private String id;
	private String desc;
	
	public Region(){
		super();
	}
	
	public Region(String desc,String id){
		this();
		this.id = id;
		this.desc = desc;		
	}

	public String getDesc() {
		return desc;
	}
	

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}
	
}
