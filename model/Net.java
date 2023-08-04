package com.net.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Net {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int net_id;
	double latitute;
	double longitude;
	int size;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	Person reported_by=null;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Person recovered_by=null;
	
	@OneToOne(cascade=CascadeType.ALL)
	Status net_status = new Status();

	public int getNet_id() {
		return net_id;
	}

	public void setNet_id(int net_id) {
		this.net_id = net_id;
	}

	public double getLatitute() {
		return latitute;
	}

	public void setLatitute(double latitute) {
		this.latitute = latitute;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Person getReported_by() {
		return reported_by;
	}

	public void setReported_by(Person reported_by) {
		this.reported_by = reported_by;
	}

	public Person getRecovered_by() {
		return recovered_by;
	}

	public void setRecovered_by(Person recovered_by) {
		this.recovered_by = recovered_by;
	}

	public Status getNet_status() {
		return net_status;
	}

	public void setNet_status(Status net_status) {
		this.net_status = net_status;
	}
	
	
	
}
