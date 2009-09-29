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

import com.poprlz.entity.company.Company;
import com.poprlz.entity.company.Process;
import com.poprlz.entity.company.Task;
import com.poprlz.entity.security.User;
import com.poprlz.service.ServiceException;
import com.poprlz.service.company.CompanyManager;
import com.poprlz.service.company.ProcessManager;
import com.poprlz.service.company.TaskManager;
import com.poprlz.web.CrudActionSupport;

/**
 * 用户管理Action.
 * 
 * 使用Struts2 convention-plugin annotation定义Action参数.
 * 
 * @author calvin
 */
@SuppressWarnings("serial")
@Results( { @Result(name = CrudActionSupport.RELOAD, location = "task.action", type = "redirect") })
public class TaskAction extends CrudActionSupport<Task> {

	@Autowired
	private TaskManager taskManager;

	@Autowired
	private ProcessManager processManager;
	
	@Autowired
	private CompanyManager companyManager;

	// 基本属性
	private Task entity;
	

	private Long id;
	private Page<Task> page = new Page<Task>(10);// 每页5条记录

	private List<Process> processList;
	private List<Company> companyList;
	
	private Long companyId;

	// 基本属性访问函数 //

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Task getModel() {
		return entity;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (id != null) {
			entity = taskManager.get(id);
		} else {
			entity = new Task();
			entity.setStatus("A");
			entity.setCreateUser(this.getUser());
		}
	}

	private User getUser() {
		// TODO Auto-generated method stub

		// TODO MODIFY
		User user = new User();
		user.setId(new Long(1));
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Page<Task> getPage() {
		return page;
	}

	// CRUD Action 函数 //

	@Override
	public String list() throws Exception {
		HttpServletRequest request = Struts2Utils.getRequest();
		List<PropertyFilter> filters = HibernateWebUtils
				.buildPropertyFilters(request);

		page = taskManager.search(page, filters);

		return SUCCESS;
	}

	@Override
	public String input() throws Exception {
		companyList = companyManager.getAll();
		
		processList = processManager.getAll();
		

		return INPUT;
	}

	public String view() throws Exception {

		return INPUT;
	}

	@Override
	public String save() throws Exception {
		// 根据页面上的checkbox 整合User的Roles Set
		// HibernateWebUtils.mergeByCheckedIds(entity.getRoles(),
		// checkedRoleIds,
		// Role.class);

		// this.companyManager.get(companyId);
		// if (companyId > 0) {
		Company company = new Company();
		company.setId(new Long(3));
		entity.setCompany(company);
		// }

		taskManager.save(entity);
		addActionMessage("保存任务成功");
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		try {
			taskManager.delete(id);
			addActionMessage("删除任务成功");
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			addActionMessage(e.getMessage());
		}
		return RELOAD;
	}

	public List<Process> getProcessList() {
		 
		return processList;
	}
	
	public List<Company> getCompanyList() {
		 
		return companyList;
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
