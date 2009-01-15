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
package org.light.portlets.weather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class WeatherLocations {
	private Document document;
	private List<WeatherLocation> locations = new ArrayList<WeatherLocation>();
	private String error;
	private boolean errorFound;
	private long lastRefreshTime;
	
	public WeatherLocations(Document document){
		this.setDocument(document);		
	}
	
	public void setDocument(Document document) {
		this.lastRefreshTime = System.currentTimeMillis();
		this.document = document;
		List list = document.selectNodes( "//search/loc" );
		if(list != null){
			if(list.size() > 0){
				for (Iterator iter = list.iterator(); iter.hasNext(); ) {
		            Node node = (Node) iter.next();
		            String name = node.getText();
		            String id = node.valueOf( "@id" );
		            this.locations.add(new WeatherLocation(id,name));
		        }
			}else{
				this.errorFound = true;
				this.error = "The location which you just input is not avaliable in The Weather Channel, please check the locaiton.";
			}
		}else{
        	this.errorFound = true;
        	Node node1 = document.selectSingleNode( "//error/err" );
		    this.error = node1.getText();	
        }
	}
	
	public Document getDocument() {
		return document;
	}
	
	public List<WeatherLocation> getLocations() {
		return locations;
	}

	public String getError() {
		return error;
	}

	public boolean isErrorFound() {
		return errorFound;
	}

	public long getLastRefreshTime() {
		return lastRefreshTime;
	}
	
}
