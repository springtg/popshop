package com.poprlz.zone.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="province")
public class ProvinceEntity implements Serializable {
	//唯一标识
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="provinceId")
	private Integer provinceId;
	
	@ManyToOne
	@JoinColumn(name="nationId")
	private NationEntity nation;
	
	@Column(name="provinceCode",length=100, nullable=false)
	private String provinceCode;
	
	@Column(name="provinceName",length=200, nullable=false)
	private String provinceName;

}
