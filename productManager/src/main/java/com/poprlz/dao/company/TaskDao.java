package com.poprlz.dao.company;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;

import com.poprlz.entity.company.Task;

@Repository
public class TaskDao extends HibernateDao<Task, Long> {

}
