package com.KwikMedicaldemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//existing patient table model
@Entity
@Table(name = "existingpatients")
public class ExistingPatient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "height")
	private String height;
	
	@Column(name = "weight")
	private String weight;
	
	@Column(name = "alergy")
	private String alergy;
	
	@Column(name = "bloodtype")
	private String bloodtype;
	
	@Column(name = "preexistingcondition")
	private String preexistingcondition;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getAlergy() {
		return alergy;
	}

	public void setAlergy(String alergy) {
		this.alergy = alergy;
	}

	public String getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getPreexistingcondition() {
		return preexistingcondition;
	}

	public void setPreexistingcondition(String preexistingcondition) {
		this.preexistingcondition = preexistingcondition;
	}
	
	
}
