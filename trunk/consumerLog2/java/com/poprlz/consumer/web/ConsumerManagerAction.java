package com.poprlz.consumer.web;

 

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.poprlz.consumer.logic.IConsumerLogic;

public class ConsumerManagerAction extends ActionSupport {
	 
	 private IConsumerLogic consumerLogic;

	public IConsumerLogic getConsumerLogic() {
		return consumerLogic;
	}

	@Autowired
	public void setConsumerLogic(IConsumerLogic consumerLogic) {
		this.consumerLogic = consumerLogic;
	}
	 
	 

}
