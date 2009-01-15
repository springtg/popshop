package org.light.portal.model;

public class NotWord extends Entity{
	
	private String word;
	public NotWord(){
		super();
	}
	public NotWord(String word){
		this();
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
