package com.poprlz.web.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.orm.hibernate.HibernateWebUtils;
import org.springside.modules.web.struts2.Struts2Utils;

import com.poprlz.entity.company.Process;
import com.poprlz.service.ServiceException;
import com.poprlz.service.company.ProcessManager;
import com.poprlz.web.CrudActionSupport;

/**
 * 用户管理Action.
 * 
 * 使用Struts2 convention-plugin annotation定义Action参数.
 * 
 * @author calvin
 */
@SuppressWarnings("serial")
@Results( { @Result(name = CrudActionSupport.RELOAD, location = "process.action", type = "redirect") })
public class ProcessAction extends CrudActionSupport<Process> {

	@Autowired
	private ProcessManager processManager;

	// 基本属性
	private Process entity;
	private Long id;
	private Page<Process> page = new Page<Process>(5);// 每页5条记录

	 
	// 基本属性访问函数 //

	public Process getModel() {
		return entity;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (id != null) {
			entity = processManager.get(id);
		} else {
			entity = new Process();
			entity.setStatus("A");
		}
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Page<Process> getPage() {
		return page;
	}

	// CRUD Action 函数 //

	@Override
	public String list() throws Exception {
		HttpServletRequest request = Struts2Utils.getRequest();
		List<PropertyFilter> filters = HibernateWebUtils
				.buildPropertyFilters(request);

		page = processManager.search(page, filters);
		 
		return SUCCESS;
	}
	
	@Override
	public String input() throws Exception {

		return INPUT;
	}

 

	@Override
	public String save() throws Exception {
		// 根据页面上的checkbox 整合User的Roles Set
		// HibernateWebUtils.mergeByCheckedIds(entity.getRoles(),
		// checkedRoleIds,
		// Role.class);

		processManager.save(entity);
		addActionMessage("保存加工工序成功");
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		try {
			processManager.delete(id);
			addActionMessage("删除加工工序成功");
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			addActionMessage(e.getMessage());
		}
		return RELOAD;
	}

 

	/**
	 * 支持使用Jquery.validate Ajax检验用户名是否重复.
	 * 
	 * public String checkLoginName() { HttpServletRequest request =
	 * ServletActionContext.getRequest(); String loginName =
	 * request.getParameter("loginName"); String oldLoginName =
	 * request.getParameter("oldLoginName");
	 * 
	 * if (userManager.isLoginNameUnique(loginName, oldLoginName)) {
	 * Struts2Utils.renderText("true"); } else {
	 * Struts2Utils.renderText("false"); } //因为直接输出内容而不经过jsp,因此返回null. return
	 * null; }
	 */
}
