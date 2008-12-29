package com.poprlz.consumer.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.poprlz.consumer.entity.CategoryEntity;
import com.poprlz.consumer.entity.ConsumerEntity;
import com.poprlz.dao.HibernateGenericDao;
import com.poprlz.user.entity.SystemEntity;


@Repository("consumerDao")
public class ConsumerHibernateDao extends HibernateGenericDao<ConsumerEntity,Integer>    implements IConsumerDao {

 
	 

}
