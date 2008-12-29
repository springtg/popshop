package com.poprlz.user.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="permissions")
public class PermissionEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="permission_id")
	private Integer permissionId;
	
	
	@Column(name="permission_code",unique=true,nullable=false)
	private String permissionCode;
	
	@Column(name="description",nullable=false)
	private String description;
	
	@Column(name="status",nullable=false,length=2)
	private String status;
	
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name="system_id", nullable=false, updatable=false)
	private SystemEntity systemEntiry;
	
	

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = com.poprlz.user.entity.RoleEntity.class)
	@JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "permission_code", referencedColumnName = "permission_code"), inverseJoinColumns = @JoinColumn(name = "role_code", referencedColumnName = "role_code"))
	private List<RoleEntity> roleList;
	
	

	public List<RoleEntity> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleEntity> roleList) {
		this.roleList = roleList;
	}

	public SystemEntity getSystemEntiry() {
		return systemEntiry;
	}

	public void setSystemEntiry(SystemEntity systemEntiry) {
		this.systemEntiry = systemEntiry;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
