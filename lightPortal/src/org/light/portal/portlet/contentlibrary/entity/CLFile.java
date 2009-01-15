package org.light.portal.portlet.contentlibrary.entity;

import java.io.InputStream;
import java.util.Date;

import org.light.portal.model.Entity;


public class CLFile extends Entity{
		
	private long id;
	private long parentId;
	private long orgId;
	private long userId;
	private String name;
	private String title;
	private String relPath;
	private String description;
	private Date lastUpdated;
	private long lastUpdatedByUserId;
	private String mimeType;
	private InputStream is;
	private Date createdDate;
	private long createdByUserId;
	private long privacy;
	private long size;
	private long accessCount;
	private boolean deleted;
	private Date deletedDate;
	private long deletedByUserId;
		
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

	public long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(long createdByUserId) {
		this.createdByUserId = createdByUserId;
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

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public InputStream getInputStream() {
		return is;
	}

	public void setInputStream(InputStream is) {
		this.is = is;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(long accessCount) {
		this.accessCount = accessCount;
	}

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
}
