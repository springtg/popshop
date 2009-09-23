package com.poprlz.dao.security;

import org.springframework.stereotype.Repository;
import com.poprlz.entity.security.User;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * 用户泛型DAO类.
 * 
 * @author calvin
 */
@Repository
public class UserDao extends HibernateDao<User, Long> {
}
