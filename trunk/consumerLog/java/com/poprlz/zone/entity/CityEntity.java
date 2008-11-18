package com.poprlz.zone.entity;

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
public class CityEntity implements Serializable {
	
	//唯一标识
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="cityId")
	private Integer cityId;
	
	@ManyToOne
	@JoinColumn(name="provinceId")
	private ProvinceEntity province;
	
	@Column(name="cityCode",length=100, nullable=false)
	private String cityCode;
	
	@Column(name="cityName",length=200, nullable=false)
	private String cityName;

}
