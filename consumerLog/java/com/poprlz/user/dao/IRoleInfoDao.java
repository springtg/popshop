package com.poprlz.user.dao;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
@ImplementedBy(RoleInfoDaoImple.class)
public interface IRoleInfoDao<RoleInfo> extends IGenericDao<RoleInfo> {

}
