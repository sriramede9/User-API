package com.user.User.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.User.model.User;

@RestController
public class UserController {

	private List<User> ulist = Arrays.asList(new User(1, "Sri", new Date()), new User(2, "Sri Ram", new Date()));

	// inItBinder for date param

	@InitBinder("User")
	public void customizeBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatter.setLenient(false);
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormatter, true));
	}

	@GetMapping("/hi")
	public String test() {
		return "YOLO!!";
	}

	@GetMapping("/Users")
	public List getUser() {
		return ulist;
	}

	@GetMapping("/Users/{id}")
	public User getUserbyId(@PathVariable("id") int id) {

		// ulist.stream().filter()

		boolean anyMatch = ulist.stream().anyMatch(x -> (x.getId() == id));

		if (anyMatch) {
			return ulist.get(id);
		} else
			return null;
	}

	@PostMapping("/Users")
	public void addUser(@RequestBody User user) {
		// System.out.println(user);

	}

	@DeleteMapping("/Users/{id}")
	public User removeUser(@PathVariable int id) {
		boolean anyMatch = ulist.stream().anyMatch(x -> x.getId() == id);

		if (anyMatch) {
			User u = ulist.get(id);
			ulist.remove(u);
			return u;
		} else
			return null;

	}

}
