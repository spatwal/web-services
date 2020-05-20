package com.master.webServices.webServices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> userList = new ArrayList<User>();

	private static int userCount = 4;
	static {
		userList.add(new User(1, "Sudarshan", "Patwal", new Date()));
		userList.add(new User(2, "Neha", "Patwal", new Date()));
		userList.add(new User(3, "Sushma", "Patwal", new Date()));
		userList.add(new User(4, "Akash", "Patwal", new Date()));
	}

	public List<User> findAll() {
		return userList;

	}

	public User saveUser(User user) {
		if (user.getId() == null || user.getId() == 0) {
			user.setId(++userCount);
		}

		userList.add(user);
		return user;
	}

	public User findOne(Integer id) {
		User user = null;
		for (User u : userList) {
			if (u.getId() == id) {
				user = u;
				System.out.println("Found User :" + u.getfName());
			}

		}
		if (user == null)
			throw new UserNotFoundException("No user Found : " + id);

		return user;
	}

	public User deleteById(int id) {
		User user = null;
		Iterator<User> iter = userList.iterator();
		while (iter.hasNext()) {
			User u = iter.next();
			if (u.getId() == id) {
				user = u;
				iter.remove();

			}
		}

		return user;
	}

}
