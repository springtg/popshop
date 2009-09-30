package com.poprlz.web.company;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.orm.hibernate.HibernateWebUtils;
import org.springside.modules.web.struts2.Struts2Utils;

import com.poprlz.entity.company.ProcessTask;
import com.poprlz.entity.security.User;
import com.poprlz.service.company.ProcessManager;
import com.poprlz.service.company.ProcessTaskManager;
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
@Results( {
		@Result(name = CrudActionSupport.RELOAD, location = "process-task.action", type = "redirect"),
		@Result(name = "TaskList", location = "task.action", type = "redirect") })
public class ProcessTaskAction extends CrudActionSupport<ProcessTask> {

	@Autowired
	private TaskManager taskManager;

	@Autowired
	private ProcessManager processManager;
	
	@Autowired
	private ProcessTaskManager processTaskManager;

	// 基本属性
	private ProcessTask entity;
	

	private Long id;
	private Page<ProcessTask> page = new Page<ProcessTask>(10);// 每页5条记录

 
	
	private Long taskId;
	
	private Long processId;

	// 基本属性访问函数 //

 

	public ProcessTask getModel() {
		return entity;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (id != null) {
			entity = processTaskManager.get(id);
		} else {
			entity = new ProcessTask();
			entity.setProcess(processManager.get(processId));
			entity.setTask(taskManager.get(taskId));
			 
			 
			
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

	public Page<ProcessTask> getPage() {
		return page;
	}

	// CRUD Action 函数 //

	@Override
	public String list() throws Exception {
		HttpServletRequest request = Struts2Utils.getRequest();
		List<PropertyFilter> filters = HibernateWebUtils
				.buildPropertyFilters(request);

		page = processTaskManager.search(page, filters);
		 
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

		entity.setOperator(this.getUser());
		entity.setOperateDate(new Date());
		

		processTaskManager.save(entity);
		addActionMessage("保存任务成功");
		return "TaskList";
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

 

 
}
