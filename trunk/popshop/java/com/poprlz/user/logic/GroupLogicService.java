package com.poprlz.user.logic;

import java.util.List;

import com.google.inject.Inject;
import com.poprlz.user.dao.IGroupDao;
import com.poprlz.user.entity.Group;
import com.poprlz.user.entity.UserInfo;
import com.poprlz.util.PaginationSupport;

public class GroupLogicService implements IGroupLogicService {

	@Inject
	private IGroupDao<Group> groupDao;

	public Group createGroup(Group group) {
		Group parent = group.getParent();
		Integer parentId = parent.getGroupId();
		parent = groupDao.loadEntity(parentId);
		if (null == parent) {
			parent = new Group();
		}

		group.setParent(parent);
		group.setStutas(Group.STUTAS_Y);

		group = groupDao.saveAndLoadEntity(group);

		return group;
	}

	public boolean isHasGroupName(String groupName) {
		Group group = groupDao.loadGroupByGroupName(groupName);
		if (group != null)
			return true;
		return false;
	}

	public Group loadGroup(int groupId) {

		return groupDao.loadEntity(groupId);
	}

	public void logicRemoveGroup(int groupId) {
		Group group = groupDao.loadEntity(groupId);
		group.setStutas(Group.STUTAS_N);
		groupDao.modifyEntity(group);

	}

	public Group saveGroup(Group group) {
		Group parent = group.getParent();
		Integer parentId = parent.getGroupId();
		parent = groupDao.loadEntity(parentId);
		if (null == parent) {
			parent = new Group();
		}

		Group target = groupDao.loadEntity(group.getGroupId());

		target.setParent(parent);
		target.setLevel(group.getLevel());
		target.setMark(group.getMark());

		target = groupDao.modifyEntity(target);

		return target;
	}

	public PaginationSupport<Group> queryGroup(int page) {
		int totalCount=groupDao.getGroupCount();
		List<Group> groupList=groupDao.queryGroup(page);
		
		PaginationSupport<Group> pagination=new PaginationSupport<Group>(groupList,totalCount);
		return pagination;
	}

}
