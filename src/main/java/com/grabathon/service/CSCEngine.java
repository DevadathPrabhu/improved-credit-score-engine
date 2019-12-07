/**
 * 
 */
package com.grabathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabathon.entities.User;

/**
 * @author dprabhu
 *
 */

@Service
public class CSCEngine {
	
	@Autowired
	UserService userService;
	
	public Integer calculateCreditScore(String emailId) {
		
		Integer creditScore = 0;
		
		User user = this.getUserDetails(emailId);
		
		
		
		return creditScore;
		
	}
	
	private User getUserDetails(String emailId) {
		
		return userService.getUser(emailId);
		
	}

}
