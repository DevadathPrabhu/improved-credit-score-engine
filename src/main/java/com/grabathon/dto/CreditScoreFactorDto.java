/**
 * 
 */
package com.grabathon.dto;

import com.grabathon.entities.User;
import com.grabathon.enums.LocationHistoryBackground;
import com.grabathon.enums.OccupationType;

/**
 * @author dprabhu
 *
 */

public class CreditScoreFactorDto {
	
	private String emailId;
	private User user;
	private Integer paidOnTimeNum;
	private Integer delayNum;
	private Integer noOfCredits;
	private Integer totalCreditAmount;
	private Integer accountBalance;
	private Integer creditBalance;
	private Integer totalIncome;
	private Integer totalExpenses;
	private OccupationType occupationType;
	private Boolean prominentPersonality;
	private LocationHistoryBackground locationHistory;
	private Long age;
	
	public CreditScoreFactorDto() {
		super();
	}
	public CreditScoreFactorDto(String emailId) {
		super();
		this.emailId = emailId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getPaidOnTimeNum() {
		return paidOnTimeNum;
	}
	public void setPaidOnTimeNum(Integer paidOnTimeNum) {
		this.paidOnTimeNum = paidOnTimeNum;
	}
	public Integer getDelayNum() {
		return delayNum;
	}
	public void setDelayNum(Integer delayNum) {
		this.delayNum = delayNum;
	}
	public Integer getNoOfCredits() {
		return noOfCredits;
	}
	public void setNoOfCredits(Integer noOfCredits) {
		this.noOfCredits = noOfCredits;
	}
	public Integer getTotalCreditAmount() {
		return totalCreditAmount;
	}
	public void setTotalCreditAmount(Integer totalCreditAmount) {
		this.totalCreditAmount = totalCreditAmount;
	}
	public Integer getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Integer getCreditBalance() {
		return creditBalance;
	}
	public void setCreditBalance(Integer creditBalance) {
		this.creditBalance = creditBalance;
	}
	public Integer getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(Integer totalIncome) {
		this.totalIncome = totalIncome;
	}
	public Integer getTotalExpenses() {
		return totalExpenses;
	}
	public void setTotalExpenses(Integer totalExpenses) {
		this.totalExpenses = totalExpenses;
	}
	public OccupationType getOccupationType() {
		return occupationType;
	}
	public void setOccupationType(OccupationType occupationType) {
		this.occupationType = occupationType;
	}
	public Boolean getProminentPersonality() {
		return prominentPersonality;
	}
	public void setProminentPersonality(Boolean prominentPersonality) {
		this.prominentPersonality = prominentPersonality;
	}
	public LocationHistoryBackground getLocationHistory() {
		return locationHistory;
	}
	public void setLocationHistory(LocationHistoryBackground locationHistory) {
		this.locationHistory = locationHistory;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
}
