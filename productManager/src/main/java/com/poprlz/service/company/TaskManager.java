package com.poprlz.service.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poprlz.dao.company.TaskDao;
import com.poprlz.entity.company.Task;
import com.poprlz.service.EntityManager;

//Spring Service Bean的标识.
@Service
// 默认将类中的所有函数纳入事务管理.
@Transactional
public class TaskManager extends EntityManager<Task, Long> {

	@Autowired
	private TaskDao taskDao;
	@Override
	protected TaskDao getEntityDao() {
		// TODO Auto-generated method stub
		return taskDao;
	}
	
	/**
	 * 重载delte函数,演示异常处理及用户行为日志.
	 */
	@Override
	public void delete(Long id) {
		Task task = taskDao.get(id);
		task.setStatus("N");
		taskDao.save(task);

	}

}
