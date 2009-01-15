package org.light.portal.logger;

public class LoggerFactory {

	public static Logger getLogger(Class klass){
		return new LoggerImpl(klass);
	}
}
