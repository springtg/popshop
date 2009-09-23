package com.poprlz.entity.company;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.poprlz.entity.IdEntity;

@Entity
// 表名与类名不相同时重新定义表名.
@Table(name = "PROCESS")
// 默认的缓存策略.
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Process extends IdEntity {

	private String processName;

	 
	
	private String status;

	 

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
