/*
 * Copyright (c) 2006 Jianmin Liu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.light.portal.core;

import org.light.portal.logger.Logger;
import org.light.portal.logger.LoggerFactory;

/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: July 16, 2006
 **/
public class PortalContextFactory {
	/** Thread Local variable available in whole Thread to keep PortalContext */
	private static final ThreadLocal threadSession = new ThreadLocal();
	/** Logger for this class and subclasses */
	protected static Logger logger = LoggerFactory.getLogger(PortalContextFactory.class);
	
	public static PortalContext getPortalContext() {
		PortalContext sc = (PortalContext) threadSession.get();		
		if (sc == null) {
			logger.debug("Opening new ServiceContext for this thread.");
			sc = new PortalContext();
			threadSession.set(sc);
		}		
		return sc;
	}	
}
