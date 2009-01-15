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

import org.dom4j.Document;
import org.dom4j.Node;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class Weather {
	private Document document;
	private String tmp;
	private String tmpUnit;
	private String icon;
	private String location;
	private String time;
	private String status;
	private String speed;
	private String speedUnit;
	private String trend;
	private String hmid;
	private String vis;
	private String error;
	private boolean errorFound;
	private long lastRefreshTime;
	
	public Weather(Document document){
		this.setDocument(document);
	}
	
	public void setDocument(Document document) {
		this.lastRefreshTime = System.currentTimeMillis();	
		this.document = document;
		Node node = document.selectSingleNode( "//weather/cc/tmp" );	
        if(node != null){
			this.tmp = node.getText();//.valueOf( "@name" );
		    Node node1 = document.selectSingleNode( "//weather/head/ut" );
		    this.tmpUnit = node1.getText();			
		    Node node2 = document.selectSingleNode( "//weather/cc/icon" );
		    this.icon = node2.getText();
		    Node node3 = document.selectSingleNode( "//weather/loc/dnam" );
		    this.location = node3.getText();
		    Node node4 = document.selectSingleNode( "//weather/cc/lsup" );
		    this.time = node4.getText();
		    if(this.time.indexOf("Local") > 0){
		    	int index = this.time.indexOf("Local");
		    	this.time = this.time.substring(0,index);
		    }	        	
		    Node node5 = document.selectSingleNode( "//weather/cc/t" );
		    this.status = node5.getText();
		    Node node6 = document.selectSingleNode( "//weather/cc/wind/s" );
		    this.speed = node6.getText();
		    Node node61 = document.selectSingleNode( "//weather/head/us" );
		    this.speedUnit = node61.getText();
		    Node node7 = document.selectSingleNode( "//weather/cc/wind/t" );
		    this.trend = node7.getText();
		    Node node8 = document.selectSingleNode( "//weather/cc/hmid" );
		    this.hmid = node8.getText();
		    Node node9 = document.selectSingleNode( "//weather/cc/vis" );
		    this.vis = node9.getText();
        }else{
        	this.errorFound = true;
        	Node node1 = document.selectSingleNode( "//error/err" );
		    this.error = node1.getText();	
        }
	}
	
	public Document getDocument() {
		return document;
	}
	
	public String getHmid() {
		return hmid;
	}
	public String getIcon() {
		return icon;
	}
	public String getLocation() {
		return location;
	}
	public String getSpeed() {
		return speed;
	}
	public String getSpeedUnit() {
		return speedUnit;
	}
	public String getStatus() {
		return status;
	}
	public String getTime() {
		return time;
	}
	public String getTmp() {
		return tmp;
	}
	public String getTmpUnit() {
		return tmpUnit;
	}
	public String getTrend() {
		return trend;
	}
	public String getVis() {
		return vis;
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
