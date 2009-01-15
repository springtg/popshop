package org.light.portlets.group;

import org.light.portal.core.PortalContextFactory;
import org.light.portal.model.Entity;

public class GroupCategory extends Entity {

	private String name;
	private long orgId;
	//read only
	private int groupCount;
	
	public GroupCategory(){
		super();
	}
	
	public GroupCategory(String name,long orgId){
		this();
		this.name = name;
		this.orgId = orgId;
	}
	
	public String getDisplayName(){
		String displayName = PortalContextFactory.getPortalContext().getMessageByKey(this.name);
		return displayName;
	}
		

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public int getGroupCount() {
		return groupCount;
	}
	

	public void setGroupCount(int groupCount) {
		this.groupCount = groupCount;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	
	

}
