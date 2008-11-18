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
@Table(name="zone")
public class ZoneEntity implements Serializable {
	//唯一标识
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="zoneId")
	private Integer zoneId;
	
	@ManyToOne
	@JoinColumn(name="parentId")
	private ZoneEntity parentZone;
	
	@ManyToOne
	@JoinColumn(name="cityId")
	private CityEntity city;
}
