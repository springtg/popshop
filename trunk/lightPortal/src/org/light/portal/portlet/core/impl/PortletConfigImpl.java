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
package org.light.portal.portlet.core.impl;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletMode;

import org.light.portal.portlet.core.InternalPortletConfig;
import org.light.portal.portlet.definition.InitParam;
import org.light.portal.portlet.definition.SupportedLocale;
import org.light.portal.portlet.definition.Supports;

/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/

public class PortletConfigImpl implements PortletConfig,InternalPortletConfig
{
    private javax.servlet.ServletConfig servletConfig;
    private PortletContext portletContext;
    private org.light.portal.portlet.definition.Portlet portletDefinition;

    public PortletConfigImpl(javax.servlet.ServletConfig servletConfig,
                             PortletContext portletContext
                             ,org.light.portal.portlet.definition.Portlet portletDefinition
                             )
    {
        this.servletConfig = servletConfig;
        this.portletContext = portletContext;
        this.portletDefinition = portletDefinition;
    }

    // javax.portlet.PortletConfig implementation -------------------------------------------------
    public String getPortletName()
    {
        return portletDefinition.getPortletName().getContent();
    }

    public PortletContext getPortletContext()
    {
        return portletContext;
    }

    public ResourceBundle getResourceBundle(java.util.Locale locale)
    {   
    	String rb = portletDefinition.getPortletTypeChoice().getPortletTypeChoiceSequence().getResourceBundle().getContent();
    	if(locale == null){ 
			SupportedLocale[] locales =portletDefinition.getSupportedLocale();
			if(locales != null && locales.length > 0)
				locale = new Locale(locales[0].getContent());
			if(locale == null)
				locale = Locale.getDefault();
    	}
    	ResourceBundle res = ResourceBundle.getBundle(rb,locale);
    	if (res == null)
    	{
          res = ResourceBundle.getBundle(rb,Locale.getDefault());  
    	}
        return res; 
    }

    public String getInitParameter(String name)
    {	
		if (name == null)
        {
            throw new IllegalArgumentException("Parameter name == null");
        }
		String value=null;
    	InitParam[] initParam = portletDefinition.getInitParam();
    	if(initParam != null && initParam.length > 0){
    		for(int i=0;i<initParam.length;i++){
    			if(initParam[i].getName().getContent().equals(name)){
    				value = initParam[i].getValue().getContent();
    				break;
    			}
    		}
    	}
    	return value;
    	
    }

    public java.util.Enumeration getInitParameterNames()
    {
    	return new java.util.Enumeration()
      {   
          private InitParam[] initParam = portletDefinition.getInitParam();
          private int curr = 0;
  		  private int end = portletDefinition.getInitParam().length;

          public boolean hasMoreElements()
          {
              return (curr < end);
          }

          public Object nextElement()
          {        	 
              if (hasMoreElements())
              {
            	  return initParam[curr++].getName().getContent();
              }
              else
              {
                  return null;
              }
          }
      };      
    }
    //-----------------------------internal
	public java.util.Enumeration getSupportedPortletModes(){
		Supports[] supports = portletDefinition.getSupports();
		if(supports == null || supports.length == 0) return null;
		return new java.util.Enumeration()
	      {   
			Supports[] supports = portletDefinition.getSupports();
	          private int curr = 0;
	  		  private int end = supports[0].getPortletModeCount();

	          public boolean hasMoreElements()
	          {
	              return (curr < end);
	          }

	          public Object nextElement()
	          {        	 
	              if (hasMoreElements())
	              {
	            	  return new PortletMode(supports[0].getPortletMode(curr++).getContent());
	              }
	              else
	              {
	                  return null;
	              }
	          }
	      }; 
	}
	public java.util.Enumeration getSupportedWindowStates(){
		return null;
	}
    public javax.servlet.ServletConfig getServletConfig()
    {
        return servletConfig;
    }

}
