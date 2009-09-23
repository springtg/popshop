package com.poprlz.dao.company;

import org.springframework.stereotype.Repository;
import org.springside.modules.orm.hibernate.HibernateDao;

import com.poprlz.entity.company.Company;

@Repository
public class CompanyDao extends HibernateDao<Company, Long> {

}
