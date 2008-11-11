package com.poprlz.user.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="userInfo")
public class UserInfo implements Serializable {
	
	public static final int STUTAS_Y=0;
	public static final int STUTAS_N=1;

	// 用户唯一标识
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="userInfoId")
	private Integer userInfoId;

/*	// 用户登陆名
	@Column(name="userName",length=50, nullable=false)
	private String userName;*/

	// 用户登陆密码
	@Column(name="userPassword",length=100, nullable=false)
	private String userPassword;

	// 用户电子邮箱
	@Column(name="userEmail",length=100, nullable=false)
	private String userEmail;

/*	// 用户所属部门
	@ManyToOne(targetEntity=com.poprlz.user.entity.Group.class)//cascade={CascadeType.REFRESH,CascadeType.MERGE}
	@JoinTable(name="group_user",joinColumns=@JoinColumn(name="userInfoId"),inverseJoinColumns=@JoinColumn(name="groupId"))
	private Group group;*/
	
	//private List<RoleInfo> roleInfoList;

	// 状态 0为有效 1为无效
	@Column(name="stutas")
	private int stutas;

	public int getStutas() {
		return stutas;
	}

	public void setStutas(int stutas) {
		this.stutas = stutas;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

 
	public Integer getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Integer userInfoId) {
		this.userInfoId = userInfoId;
	}

/*	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}*/

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		/*result = PRIME * result
				+ ((group == null) ? 0 : group.hashCode());*/
		result = PRIME * result + stutas;
		result = PRIME * result
				+ ((userEmail == null) ? 0 : userEmail.hashCode());
		result = PRIME * result + (int) (userInfoId ^ (userInfoId >>> 32));
/*		result = PRIME * result
				+ ((userName == null) ? 0 : userName.hashCode());*/
		result = PRIME * result
				+ ((userPassword == null) ? 0 : userPassword.hashCode());
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
		final UserInfo other = (UserInfo) obj;
		/*if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;*/
		if (stutas != other.stutas)
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userInfoId != other.userInfoId)
			return false;
		/*if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;*/
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

/*	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}*/

	 

}
