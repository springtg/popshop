package org.light.portal.logger;

public interface Logger {
	
	public enum Level {TRACE,DEBUG,INFO,WARN,ERROR,FATAL};
	
    // printing methods:
    public void trace(Object message);
    public void debug(Object message);
    public void info(Object message);
    public void warn(Object message);
    public void error(Object message);
    public void fatal(Object message);

    // generic printing method:
    public void log(Level l, Object message);
    
    public boolean isDebugEnabled();
}

