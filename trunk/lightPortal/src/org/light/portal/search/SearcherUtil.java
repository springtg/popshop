package org.light.portal.search;

import static org.light.portal.util.Constants._FILE_PATH;
import static org.light.portal.util.Constants._INDEX_PATH;

import org.light.portal.util.OrganizationThreadLocal;
import org.light.portal.util.PropUtil;

public class SearcherUtil {
	public static String getKeyword(String keyword){
		return (keyword == null) ? null : keyword + ((keyword.length() > 0 && !keyword.endsWith("*")) ? "*" : "");
	}
	
	public static String getPath(){
		return _FILE_PATH+OrganizationThreadLocal.getOrganizationId()+System.getProperty("file.separator")+_INDEX_PATH;
	}
	
	public static int top(){
		int top = 1000;
		try{
			top =Integer.parseInt(PropUtil.getString("search.result.top.numbers")); 
		}catch(Exception e){}
		return top;
	}
}
