package com.poprlz.zone.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="nation")
public class NationEntity implements Serializable {
	
	//唯一标识
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="nationId")
	private Integer nationId;

}
