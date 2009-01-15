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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PreferencesValidator;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import static org.light.portal.util.Constants.*;
import org.light.portal.core.service.PortalService;
import org.light.portal.model.PortletObjectPreferences;
import org.light.portal.portlet.definition.Preference;
import org.light.portal.portlet.definition.types.ReadOnlyType;
import org.light.portal.util.Enumerator;
import org.light.portal.util.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;


/**
 * 
 * @author Jianmin Liu
 * @version 1.0.0
 * Creation date: April 14, 2006
 **/
public class PortletPreferencesImpl implements PortletPreferences
{
    //private List    preferenceSetList  = new LinkedList();
    private HashMap<String, PortletPreference> preferences = new HashMap<String, PortletPreference>();
    private HashMap<String, PortletPreference> defaultPreferences = new HashMap<String, PortletPreference>();
    private HashMap changedPreferences = new HashMap();
    private HashSet removedPreferences = new HashSet();


    // current method used for managing these preferences
    private Integer methodId = null;
    private PortletRequest request;
    private PortletWindow portletWindow = null;


    public PortletPreferencesImpl(Integer methodId, PortletRequest request, PortletWindow portletWindow)
    {
        this.methodId = methodId;
        this.request = request;
        this.portletWindow = portletWindow;
        
        //fill list of preference sets
        if(portletWindow.getDefition().getPortletPreferences() != null && 
           portletWindow.getDefition().getPortletPreferences().getPreference() != null	){
        	for(int i=0;i<portletWindow.getDefition().getPortletPreferences().getPreference().length;i++){
        		Preference p = portletWindow.getDefition().getPortletPreferences().getPreference()[i];
        		boolean readOnly = false;
        		if(p.getReadOnly() != null && p.getReadOnly().equals(ReadOnlyType.TRUE)){
        			readOnly = true;
        		}
        		defaultPreferences.put(p.getName().getContent(), new PortletPreference(p.getName().getContent(), p.getValue(), readOnly));
        	}
        }
        
        if(portletWindow.getPortletObject() != null){
	        Iterator iterator = portletWindow.getPortletObject().getPreferences().iterator();
	        while(iterator.hasNext()){
	        	PortletObjectPreferences ps = (PortletObjectPreferences)iterator.next();
	        	if(!ps.isRemoved()){
	        		if(preferences.containsKey(ps.getName())){
	        			PortletPreference pp = preferences.get(ps.getName());
	        			String[] values = pp.getValues();        			
	        			String[] newValues = new String[values.length+1];
	        			for(int i=0;i<values.length;i++){
	        				newValues[i]= values[i];
	        			}
	        			newValues[newValues.length - 1]= ps.getValue();
	        			preferences.put(ps.getName(), new PortletPreference(ps.getName(), newValues));
	        		}else{
	        			preferences.put(ps.getName(), new PortletPreference(ps.getName(), ps.getValue()));
	        		}
	        	}else{
	        		defaultPreferences.remove(ps.getName());
	        	}
	        }
        }
    }


    // javax.portlet.PortletPreferences implementation --------------------------------------------
    public boolean isReadOnly(String key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        // default is false
        boolean isReadOnly = false;
        
        if(defaultPreferences.get(key) != null){
        	isReadOnly = defaultPreferences.get(key).isReadOnly();
        }
        
        return isReadOnly;
    }

    public String getValue(String key, String def)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        String[] defStr = new String[1];
        defStr[0] = def;

        String[] values = this.getValues(key, defStr);

        // null values are allowed
        if ((values == null) || (values.length==0))
        {
            return null;
        }

        return values[0];
    }

    public String[] getValues(String key, String[] def)
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }
        
        if (removedPreferences.contains(key)){
        	return null;
        }
        // get modified preferences
        if (changedPreferences.containsKey(key)){
            return StringUtils.copy((String[]) changedPreferences.get(key));
        }
        
        // get preferences
        if (preferences.containsKey(key)){
            return StringUtils.copy((String[]) preferences.get(key).getValues());
        }
        
        // get default preferences
        if (defaultPreferences.containsKey(key)){
            return StringUtils.copy((String[]) defaultPreferences.get(key).getValues());
        }
        return def;
    }
    
    public void setValue(String key, String value) throws ReadOnlyException
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        String[] values =  new String[1];
        values[0] = value;
        setValues(key, values);
    }

    public void setValues(String key, String[] values) throws ReadOnlyException
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        if (isReadOnly(key))
        {
            throw new ReadOnlyException("Preference attribute called " + key + " may not be modified");
        }

        changedPreferences.put(key, StringUtils.copy(values));
        removedPreferences.remove(key);

    }

    public Enumeration getNames()
    {
        HashSet keyset = new HashSet();
        Iterator listIter = preferences.keySet().iterator();
        Iterator defaultListIter = defaultPreferences.keySet().iterator();
        Iterator changedIter = changedPreferences.keySet().iterator();
        Iterator removedIter = removedPreferences.iterator();

        // iterate through all modified preferences of first layer
        while (listIter.hasNext()){
            keyset.add(listIter.next());
        }
        while (defaultListIter.hasNext()){
            keyset.add(defaultListIter.next());
        }
        while (changedIter.hasNext()){
            keyset.add(changedIter.next());
        }
	    while (removedIter.hasNext()){
	        keyset.remove(removedIter.next());
	    }

        return new Enumerator(keyset.iterator());

    }

    public Map getMap()
    {
        HashMap map = new HashMap();
        Enumeration enumerator= this.getNames();
        while (enumerator.hasMoreElements())
        {
            String name = (String)enumerator.nextElement();
            map.put(name, getValues(name,null));
        }

        return map;
    }

    public void reset(String key) throws ReadOnlyException
    {
        if (key == null)
        {
            throw new IllegalArgumentException("key == null");
        }

        if (isReadOnly(key))
        {
            throw new ReadOnlyException("preference attribute called " + key + " may not be modified");
        }

        changedPreferences.remove(key);
        removedPreferences.add(key);
    }

    public void store() throws java.io.IOException,ValidatorException
    {			
        // not allowed when not called in action
        if ( ! this.methodId.equals(METHOD_ACTION))
        {
            throw new java.lang.IllegalStateException("store is only allowed inside a processAction call");
        }
        
        // validate preferences
        if(portletWindow.getDefition().getPortletPreferences() != null){
	        String validatorStr = portletWindow.getDefition().getPortletPreferences().getPreferencesValidator();
	        if (validatorStr != null) {
	        	try{
		        	PreferencesValidator validator = (PreferencesValidator)Class.forName(validatorStr).newInstance();
		            validator.validate(this);
	        	}catch(Exception e){}
	        }
        }
        Iterator iterator = changedPreferences.keySet().iterator();
        while(iterator.hasNext()){
        	String name = (String)iterator.next();
        	String[] values = (String[])changedPreferences.get(name);
        	if(values != null && values.length > 0){
        		Iterator it =  this.portletWindow.getPortletObject().getPreferences().iterator();
        		while(it.hasNext()){
    			 PortletObjectPreferences pop = (PortletObjectPreferences)it.next();
    			 if(pop.getName().equals(name)){
					 //this.portletWindow.getPortletObject().getPreferences().remove(pop);	
					 this.getPortalService(this.request).delete(pop);
    			 }
        		}        		
        		for(int i=0;i<values.length;i++){
					//this.portletWindow.getPortletObject().getPreferences().add(new PortletObjectPreferences(name,values[i],this.portletWindow.getPortletObject().getId()));					
					this.getPortalService(this.request).save(new PortletObjectPreferences(name,values[i],this.portletWindow.getPortletObject().getId()));
        		}        			        	
        	}
        }
        Iterator iterator2 = removedPreferences.iterator();
        while(iterator2.hasNext()){
        	String name = (String)iterator2.next();
        	if(preferences.containsKey(name)){
        		Iterator it =  this.portletWindow.getPortletObject().getPreferences().iterator();
        		while(it.hasNext()){
    			 PortletObjectPreferences pop = (PortletObjectPreferences)it.next();
    			 if(pop.getName().equals(name)){
    				 //this.portletWindow.getPortletObject().getPreferences().remove(pop);
					 this.getPortalService(this.request).delete(pop);
    			 }
        		}
        	}
        	if(defaultPreferences.containsKey(name)){
        		Iterator it =  this.portletWindow.getPortletObject().getPreferences().iterator();
        		while(it.hasNext()){
    			 PortletObjectPreferences pop = (PortletObjectPreferences)it.next();
    			 if(pop.getName().equals(name)){
    				 //this.portletWindow.getPortletObject().getPreferences().remove(pop);
					 this.getPortalService(this.request).delete(pop);
    			 }
        		}
        		//this.portletWindow.getPortletObject().getPreferences().add(new PortletObjectPreferences(name,"",this.portletWindow.getPortletObject().getId(), 1));
				this.getPortalService(this.request).save(new PortletObjectPreferences(name,"",this.portletWindow.getPortletObject().getId(), 1));
        	}	
        }
		this.portletWindow.setPortletObject(this.getPortalService(this.request).getPortletById(this.portletWindow.getPortletObject().getId()));		
//
//        // transfer changes to the top preference set 
//        PreferenceSet preferences = (PreferenceSet)preferenceSetList.get(0);
//        PreferenceSetCtrl preferencesCtrl = (PreferenceSetCtrl)ControllerObjectAccess.get(preferences);
//
//        // modified preferences
//        Iterator iter = changedPreferences.keySet().iterator();
//        while (iter.hasNext())
//        {
//            String key = (String) iter.next();
//            String[] values = (String[])changedPreferences.get(key);
//
//            // null values are allowed
//            List newValues = null;
//            if (values != null)
//            {
//                // convert values from string[] to collection
//                newValues = new ArrayList(values.length);
//                for (int i=0;i<values.length;i++)
//                    newValues.add(values[i]);
//            }
//
//            // transfer changings
//            Preference preference = preferences.get(key);
//            if (preference != null)
//            {
//                // change preference
//                PreferenceCtrl preferenceCtrl = (PreferenceCtrl)ControllerObjectAccess.get(preference);
//                preferenceCtrl.setValues(newValues);
//            }
//            else
//            {
//                // add new preference
//                preferencesCtrl.add(key, newValues); 
//            }
//        }
//        changedPreferences.clear();
//
//        // removed preferences
//        iter = removedPreferences.iterator();
//        while (iter.hasNext())
//        {
//            String key = (String) iter.next();
//            preferencesCtrl.remove(key);
//        }
//        removedPreferences.clear();
//
//        // store changes to the top preference set
//        if (portletEntity != null)
//        {
//            PortletEntityCtrl portletEntityCtrl = (PortletEntityCtrl)ControllerObjectAccess.get(portletEntity);
//            portletEntityCtrl.store();
//        }
//        else
//        {
//            PortletDefinitionCtrl portletDefinitionCtrl = (PortletDefinitionCtrl)ControllerObjectAccess.get(portletDefinition);
//            portletDefinitionCtrl.store();
//        }

    }
    // --------------------------------------------------------------------------------------------


    // internal methods ---------------------------------------------------------------------------
//    private String[] getValuesFromPreference(Preference preference)
//    {
//        if (preference == null)
//        {
//            return null;
//        }
//
//        Iterator values = preference.getValues();
//
//        // null values are allowed
//        if (values == null)
//        {
//            return null;
//        }
//
//        if (!values.hasNext())
//        {
//            return new String[0];
//        }
//
//        // convert values from Iterator to string[]
//        List newValues = new ArrayList();
//        while (values.hasNext())
//        {
//            newValues.add(values.next());
//        }
//
//        return(String[])newValues.toArray(new String[newValues.size()]);
//    }
    // --------------------------------------------------------------------------------------------
    protected PortalService getPortalService(PortletRequest request) {			
		return (PortalService)getService(this.getServletRequest(request), "portalService");
	}
	
	private Object getService(HttpServletRequest request, String serviceName) {
		ApplicationContext ctx = (ApplicationContext) request.getSession().getServletContext()		
        							.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);		
		return ctx.getBean(serviceName);
	}
	protected HttpServletRequest getServletRequest(PortletRequest request){
		HttpServletRequest httpServletRequest = (HttpServletRequest)request.getAttribute("httpServletRequest");		
		return httpServletRequest;
	}
}
