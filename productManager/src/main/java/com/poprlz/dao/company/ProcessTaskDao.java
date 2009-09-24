package com.poprlz.dao.company;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;

import com.poprlz.entity.company.ProcessTask;

@Repository
public class ProcessTaskDao extends HibernateDao<ProcessTask, Long> {

}
