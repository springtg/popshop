package com.poprlz.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.poprlz.dao.security.AuthorityDao;
import com.poprlz.entity.security.Authority;
import com.poprlz.service.EntityManager;

/**
 * 授权管理类.
 * 
 * @author calvin
 */
@Service
@Transactional
public class AuthorityManager extends EntityManager<Authority, Long> {
	@Autowired
	private AuthorityDao authorityDao;

	@Override
	protected AuthorityDao getEntityDao() {
		return authorityDao;
	}
}
