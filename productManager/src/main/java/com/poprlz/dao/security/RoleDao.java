package com.poprlz.dao.security;

import org.springframework.stereotype.Repository;
import com.poprlz.entity.security.Role;
import com.poprlz.entity.security.User;
import org.springside.modules.orm.hibernate.HibernateDao;

@Repository
public class RoleDao extends HibernateDao<Role, Long> {

	/**
	 * 重载函数，在删除角色时进行特殊处理删除与用户多对多关联的中间表.
	 */
	@Override
	public void delete(Long id) {
		Role role = get(id);
		for (User user : role.getUsers()) {
			user.getRoles().remove(role);
		}
		super.delete(role);
	}
}
