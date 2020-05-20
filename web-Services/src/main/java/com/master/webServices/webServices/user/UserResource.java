package com.master.webServices.webServices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> retrievAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrievSingleUser(@PathVariable int id) {
		return userDaoService.findOne(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> postUsers(@Validated @RequestBody User user) {

		User saved = userDaoService.saveUser(user);

		URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(loc).build();

	}

	@DeleteMapping("/users/{id}")
	public User deleteSingleUser(@PathVariable int id) {
		User u = userDaoService.deleteById(id);
		if (u == null)
			throw new UserNotFoundException("No user found for id : " + id);
		return u;
	}

}
