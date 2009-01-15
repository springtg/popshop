package org.light.portal.model;

import static org.light.portal.util.Constants._DEFAULT_GROUP_PREFIX;
import static org.light.portal.util.Constants._DEFAULT_ROLE;
import static org.light.portal.util.Constants._DEFAULT_SPACE_PREFIX;

import java.util.Date;

import org.light.portal.util.DateFormatter;

public class Organization extends Entity{
	
	private String webId;
	private String virtualHost;
	private String mx;
	private String logoUrl;
	private String logoIcon;
	private long userId;
	private String role=_DEFAULT_ROLE;
	private int type=1; //1 normal org;
	private int status = 1; //1 activated; 0 disabled; -1 deleted
		
	//readonly
	private String defaultUserId;
	
	//transient
	private String defaultMalePortrait;
	private String defaultFemalePortrait;
	
	public Organization(){
		super();
	}
	
	public Organization(String webId,String virtualHost,String mx,String logoUrl,String logoIcon){
		this();
		this.webId = webId;
		this.virtualHost = virtualHost;
		this.mx = mx;
		this.logoUrl = logoUrl;
		this.logoIcon = logoIcon;
	}
	
	public Organization(String webId,String virtualHost,String mx,String logoUrl, String logoIcon, long userId){
		this();
		this.webId = webId;
		this.virtualHost = virtualHost;
		this.mx = mx;
		this.logoUrl = logoUrl;
		this.logoIcon = logoIcon;
		this.userId = userId;
	}
	
	public String getSpace(){
		return getWebId()+_DEFAULT_SPACE_PREFIX;
	}
	public String getGroupPrefix(){
		return _DEFAULT_GROUP_PREFIX;
	}
	public String getCurrentYear(){
		return DateFormatter.format(new Date(),"yyyy");
	}
	public String getMx() {
		return mx;
	}
	public void setMx(String mx) {
		this.mx = mx;
	}
	public String getVirtualHost() {
		return virtualHost;
	}
	public void setVirtualHost(String virtualHost) {
		this.virtualHost = virtualHost;
	}
	public String getWebId() {
		return webId;
	}
	public void setWebId(String webId) {
		this.webId = webId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getDefaultUserId() {
		return defaultUserId;
	}

	public void setDefaultUserId(String defaultUserId) {
		this.defaultUserId = defaultUserId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getLogoIcon() {
		return logoIcon;
	}

	public void setLogoIcon(String logoIcon) {
		this.logoIcon = logoIcon;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDefaultFemalePortrait() {
		return defaultFemalePortrait;
	}

	public void setDefaultFemalePortrait(String defaultFemalePortrait) {
		this.defaultFemalePortrait = defaultFemalePortrait;
	}

	public String getDefaultMalePortrait() {
		return defaultMalePortrait;
	}

	public void setDefaultMalePortrait(String defaultMalePortrait) {
		this.defaultMalePortrait = defaultMalePortrait;
	}

}
