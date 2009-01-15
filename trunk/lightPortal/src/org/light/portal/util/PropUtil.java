package org.light.portal.util;

import com.germinus.easyconf.EasyConf;

public class PropUtil {
	private final static String _BASE = "portal";
	
	public static String getString(String name){
		String value = null;
		if(getOrgWebId() != null)
			value = EasyConf.getConfiguration(getOrgWebId(),_BASE).getProperties().getString(name);
		else
			value = EasyConf.getConfiguration(_BASE).getProperties().getString(name);
		return value;
	}
	
	public static String getString(String name,String orgWebId){
		String value = null;
		if(orgWebId != null)
			value = EasyConf.getConfiguration(orgWebId,_BASE).getProperties().getString(name);
		else
			value = EasyConf.getConfiguration(_BASE).getProperties().getString(name);
		return value;
	}
	
	public static String getOrgWebId(){
		return OrganizationThreadLocal.getWebId();
	}
}
