package com.poprlz.user.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.poprlz.dao.HibernateGenericDao;
import com.poprlz.user.entity.UserInfo;
import com.poprlz.util.PaginationSupport;

public class UserDaoImple extends HibernateGenericDao implements IUserDao {

	public List<UserInfo> queryEntity() {
		Query query = this.sessionProvider.get().createQuery(
				" from UserInfo as userInfo ");
		return query.list();
	}

	public UserInfo loadUserInfoByUserEmail(String userEmail) {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from UserInfo as userInfo where userInfo.userEmail =:userEmail");
		query.setParameter("userEmail", userEmail);
		List userList = query.list();
		if (userList == null || userList.size() < 1)
			return null;
		UserInfo userInfo = (UserInfo) userList.get(0);
		return userInfo;
	}

	public int getUserInfoCount() {

		Query query = this.sessionProvider.get().createQuery(
				"select count(*) from UserInfo as userInfo ");
		List list = query.list();
		if (list != null) {
			Long result = (Long) (query.list().get(0));

			return result.intValue();
		}
		return 0;
	}

	public List<UserInfo> queryUserInfo(int page) {
		Query query = this.sessionProvider.get().createQuery(
				" from UserInfo as userInfo ");
		page = page - 1;
		if (page < 0)
			page = 0;
		query.setFirstResult(page * PaginationSupport.PAGESIZE);
		query.setMaxResults(PaginationSupport.PAGESIZE);
		return query.list();
	}

	public UserInfo loadEntity(Serializable key) {
		Query query = this.sessionProvider
				.get()
				.createQuery(
						"from UserInfo as userInfo where userInfo.userInfoId =:userInfoId");
		query.setParameter("userInfoId", key);
		List userList = query.list();
		if (userList == null || userList.size() < 1)
			return null;
		UserInfo userInfo = (UserInfo) userList.get(0);
		return userInfo;
	}

}
