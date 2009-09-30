package com.poprlz.service.company;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.test.junit4.SpringTxTestCase;

import com.poprlz.entity.company.Company;
import com.poprlz.entity.company.Task;
import com.poprlz.entity.security.User;

public class TaskManagerTest extends SpringTxTestCase {


	@Autowired
	private TaskManager taskManager;
	@Test
	public void testSave() {
		Task task = new Task();
		task.setColor("RED");
		task.setCreateDate(new Date());
		task.setProductName("PEN");
		task.setQuantity(10);
		task.setStatus("Y");
		User user = new User();
		user.setId(new Long(1));
		
		Company com = new Company();
		com.setId(new Long(1));

		task.setCompany(com);
		task.setCreateUser(user);
		this.taskManager.save(task);
		
		assertNotNull(task.getId());

		// 删除用户并验证
		taskManager.delete(task.getId());
		flush();
	}

}
