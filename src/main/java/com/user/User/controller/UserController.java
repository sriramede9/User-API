package com.user.User.controller;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.user.User.exception.NosuchUserFoundException;
import com.user.User.model.User;

@RestController
public class UserController {

	private static List<User> ulist = new ArrayList();

	static {
		ulist.add(new User(1, "Sri", new Date()));
		ulist.add(new User(2, "Sri Ram", new Date()));
		ulist.add(new User(3, "Sri Ram Ede", new Date()));
	}

	// inItBinder for date param

	@InitBinder("User")
	public void customizeBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatter.setLenient(false);
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormatter, true));
	}

	@GetMapping("/Users")
	public List<User> getUser() {
		return ulist;
	}

	@GetMapping("/Users/{id}")
	public ResponseEntity<Object> getUserbyId(@PathVariable("id") int id) {

		for (User u : ulist) {
			if (u.getId() == id) {

				return new ResponseEntity(u, HttpStatus.FOUND); //sending status code

				// return u;
			} else
				throw new NosuchUserFoundException("id ->" + id); //throwing customized exception

		}

		return null;
	}

	@PostMapping("/Users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		// System.out.println(user);

		ulist.add(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest() // we are at /Users
				.path("/{id}") // appending /id to give the complete path
				.buildAndExpand(user.getId()).toUri();// appending /Users/id

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/Users/{id}")
	public User removeUser(@PathVariable int id) {

		User udel = null;

		for (User u : ulist) {
			if (u.getId() == id) {
				udel = u;
			}

		}

		ulist.remove(udel);

		return udel;

	}

}
