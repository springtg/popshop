package com.poprlz.entity.company;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.poprlz.entity.IdEntity;
import com.poprlz.entity.security.User;

@Entity
// 表名与类名不相同时重新定义表名.
@Table(name = "Process_Task")
public class ProcessTask extends IdEntity {
	private Task task;
	private Process process;
	private User operator;
	private Date operateDate;
	private int finishQuantity;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "TASK_ID", nullable = false, updatable = true, insertable = true)
	public Task getTask() {
		return task;
	}

		public void setTask(Task task) {
		this.task = task;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "PROCESS_ID", nullable = false, updatable = true, insertable = true)
	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", nullable = false, updatable = true, insertable = true)
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
