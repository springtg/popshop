package org.light.portal.model;

public class NotKeyword extends Entity{
	
	private String word;
	public NotKeyword(){
		super();
	}
	
	public NotKeyword(String word){
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
