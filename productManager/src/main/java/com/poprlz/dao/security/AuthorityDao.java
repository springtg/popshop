package com.poprlz.dao.security;

import org.springframework.stereotype.Repository;
import com.poprlz.entity.security.Authority;
import org.springside.modules.orm.hibernate.HibernateDao;

@Repository
public class AuthorityDao extends HibernateDao<Authority, Long> {
}
