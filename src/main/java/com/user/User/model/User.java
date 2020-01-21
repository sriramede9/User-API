package com.user.User.model;

import java.util.Date;

public class User {

	private int id;
	private String name;
	private Date dateOfBirth;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return dateOfBirth;
	}

	public void setDate(Date date) {
		this.dateOfBirth = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + dateOfBirth + "]";
	}

}
