package org.light.portal.model;


public class UserKeyword extends Entity{

	   private String keyword;
	   private int weight;
	   private long userId;
	   
	   public UserKeyword(){
	       super();
	   }

	   public UserKeyword(String keyword,long userId){
		   this();
		   this.keyword = keyword;
		   this.userId = userId;
	   }
	   public UserKeyword(String keyword,long userId, int weight){
		   this();
		   this.keyword = keyword;
		   this.userId = userId;
		   this.weight = weight;
	   }
	   public void weighIt(){
	       this.weight++;
	   }
	   public void weighIt(int howMany){
	       this.weight+=howMany;
	   }

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	   
}
