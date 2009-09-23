package com.poprlz.entity.company;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.poprlz.entity.security.User;

@Entity
// 表名与类名不相同时重新定义表名.
@Table(name = "ProcessTask")
public class ProcessTask {
	private Task task;
	private Process process;
	private User operator;
	private Date operateDate;
	private int finishQuantity;
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public int getFinishQuantity() {
		return finishQuantity;
	}

	public void setFinishQuantity(int finishQuantity) {
		this.finishQuantity = finishQuantity;
	}
	
	
	
}
