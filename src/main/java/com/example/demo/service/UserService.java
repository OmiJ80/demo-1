package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	public UserRepository repo;
	
	public void saveUser(User user)
	{
		repo.save(user);
	}
	
	public String validate(User user) {
	    User u1 = repo.findByUsername(user.getUsername());
	    System.out.println("u1------" + u1);
	    if (u1 != null && u1.getUsername().equals(user.getUsername()) && u1.getPassword().equals(user.getPassword())) {
	        return "login";
	    } else {
	        return "error";
	    }
	}

	public User getUserByUsername(String username) {
        return repo.findByUsername(username);
    }

}
//	public List<User> ListAll()
//	{
//		return repo.findAll();
//	}

