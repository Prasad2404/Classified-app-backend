package com.test.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.test.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.User;
import com.test.model.UserRole;
import com.test.repository.UserRepository;
import com.test.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		
		return userRepository.findById(id);
	}

	@Override
	public User login(String username, String password) throws Exception {
		User user =  userRepository.findByUsername(username);
		if (user == null) {
			throw new Exception("Invalid username or password");
		}
		if (user.getPassword() == null || !user.getPassword().equals(password)) {
			throw new Exception("Invalid username or password");
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User getUserById(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User createUser(User user, Set<UserRole> roles) throws Exception {
		User existingUser = this.userRepository.findByUsername(user.getUsername());
		System.out.println(existingUser);
		if (existingUser != null) {
			throw new Exception("User already present!");
		}
		System.out.println("Saving user");
		return userRepository.save(user);
	}

	
	
}

