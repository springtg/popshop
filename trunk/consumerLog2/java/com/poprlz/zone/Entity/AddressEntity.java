package com.poprlz.zone.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class AddressEntity implements Serializable {
	
	//唯一标识
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="addressId")
	private Integer addressId;
	
	@Column(name="information")
	private String information;

}
