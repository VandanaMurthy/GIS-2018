package com.accion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="eventlist")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int eid;
	
	@Column(name="event_name")
	private String ename;
	
	@Column(name="event_date")
	private String edate;
	
	@Column(name="event_location")
	private  String eloc;
	
	@Column(name="event_url")
	private  String eurl;
	
	@Column(name="event_desc")
	private  String edesc;
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getEloc() {
		return eloc;
	}

	public void setEloc(String eloc) {
		this.eloc = eloc;
	}

	public String getEurl() {
		return eurl;
	}

	public void setEurl(String eurl) {
		this.eurl = eurl;
	}

	public String getEdesc() {
		return edesc;
	}

	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}

	public Event(int eid, String ename,String edate, String eloc, String eurl, String edesc) {
		this.eid = eid;
		this.ename = ename;
		this.edate = edate;
		this.eloc = eloc;
		this.eurl = eurl;
		this.edesc = edesc;
	}

	public Event() {
	}

	
}
