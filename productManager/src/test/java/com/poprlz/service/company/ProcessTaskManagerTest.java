package com.poprlz.service.company;

import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.test.junit4.SpringTxTestCase;

import com.poprlz.entity.company.Process;
import com.poprlz.entity.company.ProcessTask;
import com.poprlz.entity.company.Task;
import com.poprlz.entity.security.User;

public class ProcessTaskManagerTest extends SpringTxTestCase {

	@Autowired
	private TaskManager taskManager;

	@Autowired
	private ProcessTaskManager processTaskManager;

	@Autowired
	private ProcessManager processManager;
	@Test
	public void testSave() {
		Task task = taskManager.get(new Long(1));
		Process process = processManager.get(new Long(1));
		User user = new User();
		user.setId(new Long(1));
		
		
		ProcessTask processTask = new ProcessTask();
		processTask.setFinishQuantity(0);
		processTask.setOperateDate(new Date());
		processTask.setOperator(user);
		processTask.setProcess(process);
		processTask.setTask(task);
		processTaskManager.save(processTask);
		assertNotNull(processTask.getId());
		
		task = taskManager.get(new Long(1));
		Map<Process, ProcessTask> map = task.getProcessTaskMap();
		ProcessTask expTask = map.get(process);

		assertEquals(expTask.getId(), processTask.getId());
		
		
		
		
		
	}

}
