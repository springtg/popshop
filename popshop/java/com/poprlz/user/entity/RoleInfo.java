package com.poprlz.user.entity;

import java.io.Serializable;
import java.util.List;

public class RoleInfo implements Serializable {
	private Integer roleId;
	private String roleName;
	private String roleContent;
	private Integer stutas;
	
	private List<Permision> permisionList;
	private List<UserInfo> userInfoList;
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((roleContent == null) ? 0 : roleContent.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result
				+ ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((stutas == null) ? 0 : stutas.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleInfo other = (RoleInfo) obj;
		if (roleContent == null) {
			if (other.roleContent != null)
				return false;
		} else if (!roleContent.equals(other.roleContent))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (stutas == null) {
			if (other.stutas != null)
				return false;
		} else if (!stutas.equals(other.stutas))
			return false;
		return true;
	}
	public List<Permision> getPermisionList() {
		return permisionList;
	}
	public void setPermisionList(List<Permision> permisionList) {
		this.permisionList = permisionList;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleContent() {
		return roleContent;
	}
	public void setRoleContent(String roleContent) {
		this.roleContent = roleContent;
	}
	public Integer getStutas() {
		return stutas;
	}
	public void setStutas(Integer stutas) {
		this.stutas = stutas;
	}
 
	

}
