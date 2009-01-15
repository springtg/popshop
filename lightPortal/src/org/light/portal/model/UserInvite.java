package org.light.portal.model;

import java.util.Date;


public class UserInvite extends Entity{

	private long userId;
	private String inviteEmail;
	private int status; //0 waiting; 1 accept invite and become a member
	private Date createDate = new Date(System.currentTimeMillis());

	
	public UserInvite(){
		super();
	}
	
	public UserInvite(long userId, String inviteEmail){
		this();
		this.userId = userId;
		this.inviteEmail = inviteEmail;	
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getInviteEmail() {
		return inviteEmail;
	}

	public void setInviteEmail(String inviteEmail) {
		this.inviteEmail = inviteEmail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
