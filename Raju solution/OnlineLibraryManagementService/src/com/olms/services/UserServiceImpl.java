package com.olms.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olms.models.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final AtomicLong counter = new AtomicLong();
	private static List<User> users;

	static {
		users = getDummyUsers();
	}

	@Override
	public List<User> findAllUsers() {
		return users;
	}

	private static List<User> getDummyUsers() {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User user = null;
			if (i == 3 || i == 5) {
			user=	new User("xxx" + i, "xxx" + i, "xxx" + i + "@xxx.com", false);
			} else {
			user =	new User("xxx" + i, "xxx" + i, "xxx" + i + "@xxx.com", true);
				
			}
			user.setId(counter.incrementAndGet());
			users.add(user);
		}

		return users;
	}

	@Override
	public User findById(long id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User findByName(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	@Override
	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	@Override
	public void deleteUserById(long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public boolean isUserExist(User user) {
		return findByName(user.getName()) != null;
	}

	@Override
	public void deleteAllUsers() {
		users.clear();
	}

	@Override
	public boolean isMember(User user) {
		return user.isMember();
	}

}
