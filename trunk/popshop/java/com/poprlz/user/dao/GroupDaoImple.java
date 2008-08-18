package com.poprlz.user.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.poprlz.dao.HibernateGenericDao;
import com.poprlz.util.PaginationSupport;

public class GroupDaoImple<Group> extends HibernateGenericDao<Group> implements
		IGroupDao<Group> {
	@Override
	public List<Group> queryEntity() {
		Query query = this.sessionProvider.get().createQuery(
				" from Group as group ");

		 
		return query.list();
	}

	public Group loadEntity(Serializable groupId) {
		Query query = this.sessionProvider.get().createQuery(
				"from Group as group where group.groupId =:groupId");
		query.setParameter("groupId", groupId);
		List groupList = query.list();
		if (groupList == null || groupList.size() < 1)
			return null;
		Group group = (Group) groupList.get(0);
		return group;
	}

	public Group loadGroupByGroupName(String groupName) {
		Query query = this.sessionProvider.get().createQuery(
				"from Group as group where group.groupName =:groupName");
		query.setParameter("groupName", groupName);
		List groupList = query.list();
		if (groupList == null || groupList.size() < 1)
			return null;
		Group group = (Group) groupList.get(0);
		return group;
	}

	public int getGroupCount() {
		Query query = this.sessionProvider.get().createQuery(
				"select count(*) from Group as group ");
		List list = query.list();
		if (list != null) {
			Long result = (Long) (query.list().get(0));

			return result.intValue();
		}
		return 0;
	}

	public List<Group> queryGroup(int page) {
		Query query = this.sessionProvider.get().createQuery(
				" from Group as group ");
		page = page - 1;
		if (page < 0)
			page = 0;
		query.setFirstResult(page * PaginationSupport.PAGESIZE);
		query.setMaxResults(PaginationSupport.PAGESIZE);
		return query.list();
	}

}
