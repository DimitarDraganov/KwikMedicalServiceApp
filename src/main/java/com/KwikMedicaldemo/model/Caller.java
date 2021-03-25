package com.KwikMedicaldemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//caller table model
@Entity
@Table(name = "callers")
public class Caller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "register_num")
	private String registernum;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "medcondition")
	private String medcondition;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRegisternum() {
		return registernum;
	}
	public void setRegisternum(String registernum) {
		this.registernum = registernum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMedcondition() {
		return medcondition;
	}
	public void setMedcondition(String medcondition) {
		this.medcondition = medcondition;
	}
	
	
}



