package com.poprlz.user.web;

import com.google.inject.Inject;
import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.user.entity.UserInfo;
import com.poprlz.user.logic.IUserLogicService;
import com.poprlz.util.PaginationSupport;

public class UserInfoQueryAction extends ActionSupport {
	@Inject
	private IUserLogicService userLogicService;
	PaginationSupport<UserInfo> paginationSupport=null;
	private int page=0;
	
	public String queryUserInfo() throws Exception {
		
		
		
		paginationSupport=userLogicService.queryUserInfo(page);
 
		return SUCCESS;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public IUserLogicService getUserLogicService() {
		return userLogicService;
	}

	public void setUserLogicService(IUserLogicService userLogicService) {
		this.userLogicService = userLogicService;
	}

	public PaginationSupport<UserInfo> getPaginationSupport() {
		return paginationSupport;
	}

	public void setPaginationSupport(PaginationSupport<UserInfo> paginationSupport) {
		this.paginationSupport = paginationSupport;
	}
	
	

}
