package com.poprlz.consumer.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poprlz.common.CommonConstant;
import com.poprlz.consumer.dao.ICategoryDao;
import com.poprlz.consumer.dao.IConsumerDao;
import com.poprlz.consumer.entity.CategoryEntity;


@Service("consumerLogic")
@Transactional(readOnly = true)
public class ConsumerLogic implements IConsumerLogic {
	
	private IConsumerDao consumerDao;

	public IConsumerDao getConsumerDao() {
		return consumerDao;
	}
	@Autowired
	public void setConsumerDao(IConsumerDao consumerDao) {
		this.consumerDao = consumerDao;
	}

 

	 
}
