package com.accion.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="upload")
public class Upload {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int uid;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="eid")
	private Event event;
	
	@Column(name="upload_file")
	private byte[]  upload;
	
	@Column(name="type")
	private String type;
	
	@Column(name="time")
	private String time;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public byte[]  getUpload() {
		return upload;
	}

	public void setUpload(byte[]  upload) {
		this.upload = upload;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Upload(int uid, Event event, byte[]  upload, String type, String time) {
		this.uid = uid;
		this.event = event;
		this.upload = upload;
		this.type = type;
		this.time = time;
	}
	
	public Upload(Event event, byte[]  upload, String type, String time) {
		this.event = event;
		this.upload = upload;
		this.type = type;
		this.time = time;
	}

	public Upload(){
		
	}

}
