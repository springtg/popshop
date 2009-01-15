package org.light.portal.core.dao;

import org.light.portal.model.Entity;

public interface BaseDao {
	public Entity create(Entity entity);
	public void save(Entity entity);
	public void delete(Entity entity);
}
