/**
 * 
 */
package com.grabathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabathon.dto.CreditScoreFactorDto;
import com.grabathon.entities.User;
import com.grabathon.enums.PaymentStatus;

/**
 * @author dprabhu
 *
 */

@Service
public class CSCEngine {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PaymentHistoryService pmtHistoryService;
	
	public Integer calculateCreditScore(String emailId) {
		
		Integer creditScore = 0;
		
		CreditScoreFactorDto csfDto = new CreditScoreFactorDto();
		
		csfDto.setUser(this.getUserDetails(emailId));
		csfDto.setPaidOnTimeNum(this.getPaymentDetails(PaymentStatus.ONTIME));
		csfDto.setDelayNum(this.getPaymentDetails(PaymentStatus.DELAYED));
		
		return creditScore;
		
	}
	
	private Integer getPaymentDetails(PaymentStatus pmtStatus) {
		return pmtHistoryService.getPaymentDetails(pmtStatus);
	}

	private User getUserDetails(String emailId) {
		
		return userService.getUser(emailId);
		
	}

}
