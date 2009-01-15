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

import static org.light.portal.util.Constants._DEFAULT_RESOURCE_BUNDLE;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: July 16, 2006
 **/
public class PortalContext {
	private Locale currentLocale;
	private ResourceBundle resourceBundle;
	private Map<String,String> valueKeyMap = new HashMap<String,String>();
	private ResourceBundle enResourceBundle = ResourceBundle.getBundle(_DEFAULT_RESOURCE_BUNDLE, new Locale("en"));
	public String getMessageByKey(String key){		
		String value = null;
		try{
			if(resourceBundle == null)
				this.setResourceBundle(enResourceBundle);
			value = resourceBundle.getString(key);
		}catch(MissingResourceException e){
			value = key;
		}
		
		return value;			
	}
	
	public String getActionName(String value){		
		String action = this.getKeyByValue(value);
		try{
			action = enResourceBundle.getString(action);
		}catch(MissingResourceException e){			
		}
		return action;			
	}
	
	public String getKeyByValue(String value){		
		String key = null;
		try{
			key = valueKeyMap.get(value);
		}catch(MissingResourceException e){
			key = value;
		}
		
		return key;			
	}
	
	public Locale getCurrentLocale() {
		return currentLocale;
	}
	

	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
		Enumeration keys =  this.resourceBundle.getKeys();
		while(keys.hasMoreElements()){
			String key = (String)keys.nextElement();
			String value = this.resourceBundle.getString(key);
			this.valueKeyMap.put(value,key);
		}
		
	}
		

}
