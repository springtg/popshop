package com.poprlz.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="systems")
public class SystemEntity implements Serializable {
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="system_id")
	private Integer systemId;
	
	
	@Column(name="system_code",unique=true,nullable=false)
	private String systemCode;
	
	@Column(name="description",nullable=false)
	private String description;
	
	@Column(name="status",nullable=false,length=2)
	private String status;
	
 

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	


}
