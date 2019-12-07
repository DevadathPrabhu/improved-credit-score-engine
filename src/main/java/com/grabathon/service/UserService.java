/**
 * 
 */
package com.grabathon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabathon.entities.User;
import com.grabathon.repository.UserRepository;

/**
 * @author dprabhu
 *
 */

@Service
public class UserService {
	
	@Autowired
    UserRepository userRepository;
	
    public User getUser(String emailId){
        Optional<User> order = userRepository.findById(emailId);
        if(order.isPresent()){
            return order.get();
        }
        else
            return null;

    }

}
