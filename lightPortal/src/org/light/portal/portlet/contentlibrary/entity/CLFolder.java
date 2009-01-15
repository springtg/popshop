package org.light.portal.portlet.contentlibrary.entity;

import java.util.Date;

import org.light.portal.model.Entity;

public class CLFolder extends Entity{
	
	private long id;
	private long parentId;
	private long orgId;
	private long userId;
	private String name;
	private String relPath;
	private String fullPath;
	private String description;
	private Date lastUpdated;
	private Date createdDate;
	private long createdByUserId;
	private long lastUpdatedByUserId;
	private long privacy = -1;
	private boolean deleted;
	private Date deletedDate;
	private long deletedByUserId = -1;
		
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public long getDeletedByUserId() {
		return deletedByUserId;
	}

	public void setDeletedByUserId(long deletedByUserId) {
		this.deletedByUserId = deletedByUserId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getPrivacy() {
		return privacy;
	}

	public void setPrivacy(long privacy) {
		this.privacy = privacy;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRelPath() {
		return relPath;
	}
	
	public void setRelPath(String relPath) {
		this.relPath = relPath;
	}
	
	public String getFullPath() {
		return fullPath;
	}
	
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getLastUpdated() {
		return lastUpdated;
	}
	
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public long getLastUpdatedByUserId() {
		return lastUpdatedByUserId;
	}

	public void setLastUpdatedByUserId(long lastUpdatedByUserId) {
		this.lastUpdatedByUserId = lastUpdatedByUserId;
	}

	public long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}
}
