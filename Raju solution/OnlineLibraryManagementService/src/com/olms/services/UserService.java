package com.olms.services;

import java.util.List;

import com.olms.models.User;

public interface UserService {

	public List<User> findAllUsers();

	public User findById(long id);

	public User findByName(String name);

	public void saveUser(User user);

	public void updateUser(User user);

	public void deleteUserById(long id);

	public boolean isUserExist(User user);

	public void deleteAllUsers();

	public boolean isMember(User user);

}
