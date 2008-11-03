package com.poprlz.user.dao;

import com.google.inject.ImplementedBy;
import com.poprlz.dao.IGenericDao;
@ImplementedBy(PermissionDaoImple.class)
public interface IPermissionDao<Permision> extends IGenericDao<Permision> {

}
