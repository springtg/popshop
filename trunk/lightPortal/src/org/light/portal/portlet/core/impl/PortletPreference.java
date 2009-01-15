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

import org.light.portal.portlet.definition.Value;

/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/

public class PortletPreference {
	
	private String name;
	private String[] values;	
	private boolean readOnly;
	private boolean selected;
	private int index;
	
	public PortletPreference(String name, String[] values){
		this.name = name;
		this.values = values;
	}
	public PortletPreference(String name, String value){
		this.name = name;
		String[] values = new String[1];
		values[0]=value;
		this.values = values;
	}
	public PortletPreference(String name, String value, int index){
		this.name = name;
		String[] values = new String[1];
		values[0]=value;
		this.values = values;
		this.index = index;
	}
	public PortletPreference(String name, String value, boolean selected, int index){
		this.name = name;
		String[] values = new String[1];
		values[0]=value;
		this.values = values;
		this.selected = selected;
		this.index = index;
	}
	public PortletPreference(String name, Value[] value, boolean readOnly){
		this.name = name;
		if(value != null && value.length >0){
			String[] values = new String[value.length];
			for(int i=0;i<value.length;i++){
				values[i]= value[i].getContent();
			}
			this.values = values;
		}		
		this.readOnly = readOnly;		
	}
	
	public String toString(){		
		return name;
	}
	
	 /**
	  * @see java.lang.Object#hashCode()
	  */
	public int hashCode() {
		
		return getName().hashCode();
	} 
   
   	/**
   	 * @see java.lang.Object#equals(Object)
   	 */
    public boolean equals(Object other) {
        if ( !(other instanceof PortletPreference) ) return false;
        PortletPreference castOther = (PortletPreference) other;
        if(this.hashCode()!=castOther.hashCode()) return false;
        return true;
    }
    
//    public String getSelected() {
//		return selected ? "yes":"no";
//	}
    
    public String getValue() {
		return values == null ? null:values[0];
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getValues() {
		return values;
	}

	public void setValue(String[] values) {
		this.values = values;
	}
	public boolean isReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	public boolean isSelected() {
		return selected;
	}
	public int getIndex() {
		return index;
	}
	
}
