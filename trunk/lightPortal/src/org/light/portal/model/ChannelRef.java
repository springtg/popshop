package org.light.portal.model;

import org.light.portal.core.PortalContextFactory;

public class ChannelRef extends Entity {
	
	private String name;
	private String descKey;
	private int selected;
	
	public ChannelRef(){
		super();
	}
	public ChannelRef(String name, String descKey){
		this();
		this.name = name;
		this.descKey = descKey;
	}
	public ChannelRef(String name, String descKey,int selected){
		this();
		this.name = name;
		this.descKey = descKey;
		this.selected = selected;
	}
	public String getDesc(){
		String locatedDesc = PortalContextFactory.getPortalContext().getMessageByKey(this.descKey);
		return locatedDesc;
	}
	
//	public boolean isSelected() {
//		return (selected == 1) ? true : false;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescKey() {
		return descKey;
	}

	public void setDescKey(String descKey) {
		this.descKey = descKey;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
}
