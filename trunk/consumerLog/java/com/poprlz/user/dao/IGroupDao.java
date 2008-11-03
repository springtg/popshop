package com.poprlz.user.dao;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
import com.poprlz.user.entity.Group;
@ImplementedBy(GroupDaoImple.class)
public interface IGroupDao<Group>  extends IGenericDao<Group> {

	public Group loadGroupByGroupName(String groupName);

	public int getGroupCount();

	public List<Group> queryGroup(int page);

}
