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
package org.light.portal.model;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class PortletObjectPreferences extends Entity {

	private PortletObject portletObject;
	private String name;
	private String value;
	private int status;
	private long portletId;
	
	public PortletObjectPreferences(){
		
	}
	
	public PortletObjectPreferences(String name, String value, long portletId){
		this.name = name;
		this.value = value;
		this.portletId = portletId;
	}
	
	public PortletObjectPreferences(String name, String value, long portletId, int status){
		this.name = name;
		this.value = value;
		this.portletId = portletId;
		this.status = status;
	}
	
	public PortletObjectPreferences(String name, String value, PortletObject portletObject){
		this.name = name;
		this.value = value;
		this.portletObject = portletObject;
	}
	
	public boolean isRemoved(){
		return status == 1 ? true:false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PortletObject getPortletObject() {
		return portletObject;
	}

	public void setPortletObject(PortletObject portletObject) {
		this.portletObject = portletObject;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getPortletId() {
		return portletId;
	}

	public void setPortletId(long portletId) {
		this.portletId = portletId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
