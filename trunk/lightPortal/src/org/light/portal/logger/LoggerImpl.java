package org.light.portal.logger;

import org.light.portal.logger.Logger.Level;

public class LoggerImpl implements Logger{

	public static LoggerImpl getLogger(Class klass){
		return new LoggerImpl(klass);
	}
	
	private org.apache.log4j.Logger logger;
	
	public LoggerImpl(Class klass){
		this.logger = org.apache.log4j.Logger.getLogger(klass);
	}
	
	public void trace(Object message){
		 this.logger.trace(message);
	}
    public void debug(Object message){
		 this.logger.debug(message);
	}
    public void info(Object message){
		 this.logger.info(message);
	}
    public void warn(Object message){
		 this.logger.warn(message);
	}
    public void error(Object message){
		 this.logger.error(message);
	}
    public void fatal(Object message){
		 this.logger.fatal(message);
	}

    // generic printing method:
    public void log(Level l, Object message){
    	if(l == Logger.Level.TRACE){
    		trace(message);
    	}else if(l == Logger.Level.DEBUG){
    		debug(message);
    	}else if(l == Logger.Level.INFO){
    		info(message);
    	}else if(l == Logger.Level.WARN){
    		warn(message);
    	}else if(l == Logger.Level.ERROR){
    		error(message);
    	}else if(l == Logger.Level.FATAL){
    		fatal(message);
    	}
    }
    
    public boolean isDebugEnabled(){
    	return this.logger.isDebugEnabled();
    }
}
