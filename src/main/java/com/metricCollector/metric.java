package com.metricCollector;

import java.sql.Date ;//It inherits java.util.Date class.
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class metric {
	
	@Id
	@GeneratedValue
	int identity;
	int data;
	java.sql.Timestamp date;
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public java.sql.Timestamp getDate() {
		return date;
	}
	public void setDate(java.sql.Timestamp date) {
		this.date = date;
	}
	public metric(int identity, int data, Timestamp date) {
		super();
		this.identity = identity;
		this.data = data;
		this.date = date;
	}
	
	public metric() {
		super();
		
	}
	
	

}
