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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.PortalContext;
import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.light.portal.portlet.core.InternalPortletConfig;
import org.light.portal.portlet.definition.InitParam;

import static org.light.portal.util.Constants._PORTLET_MODE_CONFIG;
import static org.light.portal.util.Constants._PORTL_SERVER_INFO;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/

public class PortalContextImpl implements PortalContext
{
   private InternalPortletConfig portletConfig;
   
   public PortalContextImpl() 
   {
      
   }
   
   public PortalContextImpl(InternalPortletConfig portletConfig) 
   {
      this.portletConfig = portletConfig;
   }
   // javax.portlet.PortalContext implementation -------------------------------------------------
   public java.lang.String getProperty(java.lang.String name)
   {
       if (name == null)
       {
           throw new IllegalArgumentException("Property name == null");
       }

       return name;
   }


   public java.util.Enumeration getPropertyNames()
   {
       return null;
   }

   public java.util.Enumeration getSupportedPortletModes()
   {   
	   Enumeration enume = portletConfig.getSupportedPortletModes(); 
	   if(enume != null)
		   return enume;
	   return new java.util.Enumeration()
	      {   	         
	          private int curr = 0;
	  		  private int end = 4;
			  private PortletMode[] states=new PortletMode[]{PortletMode.VIEW,
				  											 PortletMode.EDIT,
				  											 PortletMode.HELP,
				  											 new PortletMode(_PORTLET_MODE_CONFIG)};


	          public boolean hasMoreElements()
	          {
	              return (curr < end);
	          }

	          public Object nextElement()
	          {        	 
	              if (hasMoreElements())
	              {
	            	  return states[curr++];
	              }
	              else
	              {
	                  return null;
	              }
	          }
	      };      
   }

   public java.util.Enumeration getSupportedWindowStates()
   {
	   return new java.util.Enumeration()
	      {   	         
	          private int curr = 0;
	  		  private int end = 3;
			  private WindowState[] states=new WindowState[]{WindowState.NORMAL,WindowState.MINIMIZED,WindowState.MAXIMIZED};


	          public boolean hasMoreElements()
	          {
	              return (curr < end);
	          }

	          public Object nextElement()
	          {        	 
	              if (hasMoreElements())
	              {
	            	  return states[curr++];
	              }
	              else
	              {
	                  return null;
	              }
	          }
	      };      
   }

   public String getPortalInfo()
   {
	   return _PORTL_SERVER_INFO;
   }
   
}
