package com.test.controller;

import com.test.model.User;
import com.test.model.Role;
import com.test.model.UserRole;
import com.test.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;


	@PostMapping("/login")
	public User login(@RequestBody User user) throws Exception {
		try {
			String username = user.getUsername();
			String password = user.getPassword();
			return userService.login(username, password);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
		try {
			Set<UserRole> roles = new HashSet<>();

			Role role = new Role();
			role.setRoleId(45L);
			role.setRoleName("NORMAL");

			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);

			roles.add(userRole);

			return this.userService.createUser(user, roles);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUserById(username);
    }

    //delete the user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }
    

    //update api
    @PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id)
	{
		
		Optional<User> existingUser=userService.getUserById(id);
		
		Map<String,String> response = new HashMap<>();
		if(existingUser.isPresent())
		{
			if(user.getAddress()!=null)
			{
				existingUser.get().setAddress(user.getAddress());
			}
			if(user.getCity()!=null)
			{
				existingUser.get().setCity(user.getCity());
			}
			if(user.getCountry()!=null)
			{
				existingUser.get().setCountry(user.getCountry());
			}
			if(user.getEmail()!=null)
			{
				existingUser.get().setEmail(user.getEmail());
			}
			if(user.getGender()!=null)
			{
				existingUser.get().setGender(user.getGender());
			}
			
			if(user.getName()!=null)
			{
				existingUser.get().setName(user.getName());
			}
			if(user.getPassword()!=null)
			{
				existingUser.get().setPassword(user.getPassword());
			}
			if(user.getPincode()!=0)
			{
				existingUser.get().setPincode(user.getPincode());
			}
			
			if(user.getState()!=null)
			{
				existingUser.get().setState(user.getState());
			}
			userService.updateUser(existingUser.get());
			response.put("Status", "Success");
			response.put("Message","User Information Updated");
			return new ResponseEntity<Map>(response,HttpStatus.OK);
		}
		else
		{
			response.put("Status", "Failed");
			response.put("Message","User Id Not Found...");
			return new ResponseEntity<Map>(response,HttpStatus.NOT_FOUND);
		}
	}


  

    @ExceptionHandler(UserPrincipalNotFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserPrincipalNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }


}
