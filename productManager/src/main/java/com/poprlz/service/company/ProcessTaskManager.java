package com.poprlz.service.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poprlz.dao.company.ProcessTaskDao;
import com.poprlz.entity.company.ProcessTask;
import com.poprlz.service.EntityManager;

/**
 * 用户管理类.
 * 
 * 实现领域对象用户的所有业务管理函数.
 *  
 * 通过泛型声明继承EntityManager,默认拥有CRUD管理方法.
 * 使用Spring annotation定义事务管理.
 * 
 * @author calvin
 */
//Spring Service Bean的标识.
@Service
//默认将类中的所有函数纳入事务管理.
@Transactional
public class ProcessTaskManager extends EntityManager<ProcessTask, Long> {
	@Autowired
	private ProcessTaskDao processTaskDao;

	@Override
	protected ProcessTaskDao getEntityDao() {
		return this.processTaskDao;
	}

	/**
	 * 重载delte函数,演示异常处理及用户行为日志.
	 */
	@Override
	public void delete(Long id) {
		/*
		 * ProcessTask processTask = processTaskDao.get(id);
		 * processTask.setStatus("N"); processTaskDao.save(processTask);
		 */
		 
	}

	 
}
