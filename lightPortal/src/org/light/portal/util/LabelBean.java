package org.light.portal.util;

public class LabelBean{
	
	private String id;
	private String desc;
	private boolean defaulted;
	
	public LabelBean(){
		super();
	}
	
	public LabelBean(String id){
		this();
		this.id = id;
		this.desc = id;		
	}
	
	public LabelBean(String id,String desc){
		this();
		this.id = id;
		this.desc = desc;	
		this.defaulted = false;
	}
	
	public LabelBean(String id,String desc, boolean defaulted){
		this();
		this.id = id;
		this.desc = desc;	
		this.defaulted = defaulted;
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

	public boolean isDefaulted() {
		return defaulted;
	}

	public void setDefaulted(boolean defaulted) {
		this.defaulted = defaulted;
	}
	
}
