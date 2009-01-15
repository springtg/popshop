package org.light.portal.portlet.core;

import java.util.Map;

public interface InternalActionResponse {
	public Map getRenderParameters();
	public String getRenderParameter(String key);
}
