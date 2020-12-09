package com.expense.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.expense.entity.User;
import com.expense.entity.repository.UserRepository;
import com.expense.service.UserService;

//Service implementation with business logic and access repository

@Service
public class UserServiceImpl implements UserService {

	Logger log = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	// This method is used to save all users

	@Override
	public List<User> saveAllUser(List<User> userList) {
		return userRepository.saveAll(userList);
	}

	// This method is to get list of users
	public List<User> getUser() {
		return userRepository.findAll();
	}

	// In this method we can get user by their id
	@Override
	public User getById(Long userId) {
		return userRepository.getOne(userId);
	}

	// In this method we can get user by their password.

	@Override
	public User getByPassword(String password) {
		return userRepository.findByPassword(password);
	}

	// In this method we can get user by their userName
	@Override
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	/*
	 * this method saves users and their passwords. Then by using password encoder
	 * it converts password from a literal text to bCrypt encoded text
	 */

	@Override
	public User saveUser(User user) {
		
		// Buggy Code(UserServiceTest.saveUserTest())
		//	user.setUsername("Uth");
		//	return user;

		// Correct Code
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);

	}

	/*
	 * get current logged in user
	 */
	@Override
	public User getDefaultUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";

		log.info("principal: " + principal);
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			log.info("current user: " + username);
		} else {
			username = principal.toString();
			log.info("default user: " + username);
		}

		User user = userRepository.findByUsername(username);

		log.info("returning user: " + user);

		return user;
	}

}
