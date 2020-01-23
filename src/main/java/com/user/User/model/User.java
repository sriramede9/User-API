package com.user.User.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.logging.log4j.message.Message;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@XmlRootElement
@ApiModel( description = "User model obj details")							//swagger docmtn
public class User {

	private int id;
	@Valid @NotBlank @Size(min = 3,message = "Name should not be less than 3 chars")
	@ApiModelProperty(notes="Name should not be less than 3 chars")		//swagger docmtn
	private String name;
	@Past(message = "Date should not be  present day")
	@ApiModelProperty(notes="Date should not be of present of future value") //swagger docmtn
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
