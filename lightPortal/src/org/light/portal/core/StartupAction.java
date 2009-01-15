package org.light.portal.core;

import javax.servlet.ServletContext;

public interface StartupAction {
	public void execute(ServletContext servletContext) throws Exception;
}
