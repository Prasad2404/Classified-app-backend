package com.test.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.test.model.User;
import com.test.model.UserRole;


public interface UserService {
	
	public User addUser(User user);
	public Optional<User> getUserById(Long id);

	User login(String username, String password) throws Exception;

	public List<User> getAllUser();
	public void deleteUser(Long id);
	public User updateUser(User user);
	public User getUserById(String username);

	User getUserByUsername(String username);

	public User createUser(User user, Set<UserRole> roles) throws Exception;

}
