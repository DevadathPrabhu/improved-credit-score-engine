/**
 * 
 */
package com.grabathon.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import lombok.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabathon.dto.CreditScoreFactorDto;
import com.grabathon.entities.User;
import com.grabathon.enums.FetchCreditRecords;
import com.grabathon.enums.LocationHistoryBackground;
import com.grabathon.enums.OccupationType;
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
		
		User user = this.getUserDetails(emailId);
		csfDto.setUser(user);
		csfDto.setPaidOnTimeNum(this.getPaymentDetails(user.getId(), PaymentStatus.ONTIME));
		csfDto.setDelayNum(this.getPaymentDetails(user.getId(), PaymentStatus.DELAYED));
		csfDto.setNoOfCredits(this.getCreditDetails(user.getId(), FetchCreditRecords.FREQUENCY));
		csfDto.setTotalCreditAmount(this.getCreditDetails(user.getId(), FetchCreditRecords.AMOUNT));
		csfDto.setAccountBalance(this.getAccountBalance(user.getId()));
		csfDto.setCreditBalance(this.getCreditBalance(user.getId()));
		csfDto.setTotalIncome(this.getTotalIncome(user.getId()));
		csfDto.setTotalExpenses(this.totalExpenses(user.getId()));
		csfDto.setProminentPersonality(this.getProminentPersonality(user.getId()));
		csfDto.setOccupationType(this.getOccupationType(user.getId()));
		csfDto.setLocationHistory(this.getLocationHistory(user.getId()));
		csfDto.setAge(ChronoUnit.DAYS.between(Instant.now(), user.getDob()));
		
		return creditScore;
		
	}
	
	private LocationHistoryBackground getLocationHistory(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	private OccupationType getOccupationType(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Boolean getProminentPersonality(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer totalExpenses(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer getTotalIncome(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer getCreditBalance(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer getAccountBalance(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer getCreditDetails(Long userId, FetchCreditRecords type) {
		return null;
	}

	private Integer getPaymentDetails(Long userId, PaymentStatus pmtStatus) {
		return pmtHistoryService.getPaymentDetailsByUserId(userId, pmtStatus);
	}

	private User getUserDetails(String emailId) {
		
		return userService.getUser(emailId);
		
	}

}
