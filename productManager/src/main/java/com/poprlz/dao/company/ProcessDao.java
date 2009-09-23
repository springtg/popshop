package com.poprlz.dao.company;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;

import com.poprlz.entity.company.Process;

@Repository
public class ProcessDao extends HibernateDao<Process, Long> {

}
