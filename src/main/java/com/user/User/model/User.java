package com.user.User.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.message.Message;

public class User {

	private int id;
	@Valid @NotBlank @Size(min = 3,message = "Name should not be less than 3 chars")
	private String name;
	@Past(message = "Date should not be  present day")
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
