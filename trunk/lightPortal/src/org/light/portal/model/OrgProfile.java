package org.light.portal.model;

public class OrgProfile extends Entity{

	private long orgId;
	private String language;
	private String title;
	private String view;
	private String maxView;
	
	public OrgProfile(){
		super();
	}
	
	public OrgProfile(String language, String view, String maxView){
		this.language = language;
		this.view = view;
		this.maxView = maxView;
	}
	
	public OrgProfile(long orgId,String language, String view, String maxView){
		this.orgId = orgId;
		this.language = language;
		this.view = view;
		this.maxView = maxView;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMaxView() {
		return maxView;
	}

	public void setMaxView(String maxView) {
		this.maxView = maxView;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
