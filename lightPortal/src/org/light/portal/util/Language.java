package org.light.portal.util;


public class Language{
	
	private String id;
	private String desc;
	private boolean supported;
	
	public Language(){
		super();
	}
	
	public Language(String id,String desc){
		this();
		this.id = id;
		this.desc = desc;		
	}
	
	public Language(String id,String desc,boolean supported){
		this();
		this.id = id;
		this.desc = desc;		
		this.supported = supported;
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

	public boolean isSupported() {
		return supported;
	}
	

	public void setSupported(boolean supported) {
		this.supported = supported;
	}
	
	
}
