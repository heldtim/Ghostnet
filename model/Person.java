package com.net.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int person_id;
	String name;
	String surname;
	String phone;
	int annonymous=0;
	String email;
	String password;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="reported_by")
	List<Net> reportedby_nets;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="recovered_by")
	List<Net> recoveredby_nets;

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAnnonymous() {
		return annonymous;
	}

	public void setAnnonymous(int annonymous) {
		this.annonymous = annonymous;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Net> getReportedby_nets() {
		return reportedby_nets;
	}

	public void setReportedby_nets(List<Net> reportedby_nets) {
		this.reportedby_nets = reportedby_nets;
	}

	public List<Net> getRecoveredby_nets() {
		return recoveredby_nets;
	}

	public void setRecoveredby_nets(List<Net> recoveredby_nets) {
		this.recoveredby_nets = recoveredby_nets;
	}
	
	
	
	
}
