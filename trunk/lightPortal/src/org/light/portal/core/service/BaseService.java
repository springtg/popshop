package org.light.portal.core.service;

import org.light.portal.model.Entity;

public interface BaseService {
	public Entity create(Entity entity);
	public void save(Entity entity);
	public void delete(Entity entity);
}
