package org.light.portlets.connection;

public class ConnectionType {
	private int type;
	private int count;
	
	public static String getTitle(int type){
		String buddyType;
		if(type == 1)
			buddyType="Family";
		else if(type == 2)
			buddyType="Close Friend";
		else if(type == 3)
			buddyType="Classmate";
		else if(type == 4)
			buddyType="Colleague";
		else
			buddyType="Friend";
		
		return buddyType;
	}
	
	public ConnectionType(int type, int count){
		this.type = type;
		this.count = count;
	}
	
	public String getTitle(){
		String buddyType;
		if(type == 1)
			buddyType="Family";
		else if(type == 2)
			buddyType="Close Friend";
		else if(type == 3)
			buddyType="Classmate";
		else if(type == 4)
			buddyType="Colleague";
		else
			buddyType="Friend";
		
		return buddyType;
	}
	
	public void add(){
		this.count++;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
