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
package org.light.portlets.note;

import org.light.portal.model.Entity;
/**
 * 
 * @author Jianmin Liu
 * @version 0.9.0
 * Creation date: April 14, 2006
 **/
public class Note extends Entity{
	
	private String color;
	private String bgColor;
	private String content;
	private long userId;
	private int width;
	private int height;
	
	public Note(){
		super();
	}
		
	public Note(long userId, String content, int width, int height, String color, String bgColor){
		this();
		this.color = color;
		this.bgColor = bgColor;
		this.content = content;
		this.userId = userId;
		this.width = width;
		this.height = height;
	}
	public Note(long userId, String content, int width, int height){
		this();	
		this.content = content;
		this.userId = userId;
		this.width = width;
		this.height = height;
	}
	public String getDisplayContent() {
		String name = this.content;		
		return name;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
}
