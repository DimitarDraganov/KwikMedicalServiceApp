package com.KwikMedicaldemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calloutdetails")
public class CalloutDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "registernum")
	private String registernum;
	
	@Column(name = "whodetail")
	private String whodetail;
	
	@Column(name = "whatdetail")
	private String whatdetail;
	
	@Column(name = "whendetail")
	private String whendetail;
	
	@Column(name = "actiontaken")
	private String actiontaken;
	
	@Column(name = "calllength")
	private String calllength;
	

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

	public String getWhodetail() {
		return whodetail;
	}

	public void setWhodetail(String whodetail) {
		this.whodetail = whodetail;
	}

	public String getWhatdetail() {
		return whatdetail;
	}

	public void setWhatdetail(String whatdetail) {
		this.whatdetail = whatdetail;
	}

	public String getWhendetail() {
		return whendetail;
	}

	public void setWhendetail(String whendetail) {
		this.whendetail = whendetail;
	}

	public String getActiontaken() {
		return actiontaken;
	}

	public void setActiontaken(String actiontaken) {
		this.actiontaken = actiontaken;
	}

	public String getCalllength() {
		return calllength;
	}

	public void setCalllength(String calllength) {
		this.calllength = calllength;
	}
	
	
}
