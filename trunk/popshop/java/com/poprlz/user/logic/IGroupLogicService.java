package com.poprlz.user.logic;

import com.google.inject.ImplementedBy;
import com.poprlz.user.entity.Group;
import com.poprlz.util.PaginationSupport;

@ImplementedBy(GroupLogicService.class)
public interface IGroupLogicService {

	public Group saveGroup(Group group);

	public Group createGroup(Group group);

	public boolean isHasGroupName(String groupName);

	public Group loadGroup(int groupId);

	public void logicRemoveGroup(int groupId);

	public PaginationSupport<Group> queryGroup(int page);

}
