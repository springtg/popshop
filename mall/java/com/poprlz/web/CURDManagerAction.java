package com.poprlz.web;

import java.io.Serializable;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.poprlz.logic.ILogicService;

public abstract class CURDManagerAction<T,ID extends Serializable> extends ActionSupport implements
		Preparable, ModelDriven<T> {

 

	 
	
	 
	/**
	 * Action函数,新增或修改Entity. 
	 * 建议return RELOAD.
	 */
	public abstract String save() throws Exception;

	/**
	 * Action函数,删除Entity.
	 * 建议return RELOAD.
	 */
	public abstract String delete() throws Exception;
	
	public abstract String input() throws Exception;

	// Preparable函数 //
	/**
	 * 在delete()前执行二次绑定.
	 */
	public void prepareDelete() throws Exception {
		prepareModel();
	}

	
	

	/**
	 * 在save()前执行二次绑定.
	 */
	public void prepareSave() throws Exception {
		prepareModel();
	}

	/**
	 * 在input()前执行二次绑定.
	 */
	public void prepareInput() throws Exception {
		prepareModel();
	}

	/**
	 * 等同于prepare()的内部函数,供prepardMethodName()函数调用. 
	 */
	protected abstract void prepareModel() throws Exception;

}
