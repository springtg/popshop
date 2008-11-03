package com.poprlz.user.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usergroup")
public class Group implements Serializable {
	public static final int STUTAS_Y=0;
	public static final int STUTAS_N=1;

	// 部门的唯一主键
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="groupId")
	private Integer groupId;

	// 部门名称
	@Column(name="groupName",length=100, nullable=false)
	private String groupName;

	// 部门简介
	@Column(name="mark",length=255)
	private String mark;

	// 上一级部门;
	@ManyToOne(targetEntity=com.poprlz.user.entity.Group.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="parentId")
	private Group parent;

	// 状态 0为有效,1为无效
	@Column(name="stutas")
	private int stutas;
	
	//部门级别,值越小,级别就越高
	@Column(name="level")
	private int level;
	
	@ManyToMany(targetEntity=com.poprlz.user.entity.UserInfo.class,cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="group_user",joinColumns=@JoinColumn(name="groupId", referencedColumnName="groupId"),inverseJoinColumns=@JoinColumn(name="userInfoId", referencedColumnName="userInfoId"))

	private List<UserInfo> userInfoList;
	
	
	@OneToMany(targetEntity=com.poprlz.user.entity.Group.class)//cascade={CascadeType.PERSIST,CascadeType.MERGE}
	@JoinColumn(name="groupId")
	private List<Group> children;

 

	public List<Group> getChildren() {
		return children;
	}

	public void setChildren(List<Group> children) {
		this.children = children;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Group getParent() {
		return parent;
	}

	public void setParent(Group parent) {
		this.parent = parent;
	}

 

	 

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

 

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (groupId ^ (groupId >>> 32));
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + level;
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + stutas;
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
		final Group other = (Group) obj;
		if (groupId != other.groupId)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (level != other.level)
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (stutas != other.stutas)
			return false;
		return true;
	}

	public int getStutas() {
		return stutas;
	}

	public void setStutas(int stutas) {
		this.stutas = stutas;
	}

}
