package com.hr.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="learner")
@Entity
public class Learner {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	private int lid;
	private String name;
	
	private String email;
	private long mobile;
	private String city;
	private String domain;
	private double salary;
	public Learner() {
		super();
	}
	public Learner(int lid, String name, String email, long mobile, String city, String domain, double salary) {
		super();
		this.lid = lid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.domain = domain;
		this.salary = salary;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
