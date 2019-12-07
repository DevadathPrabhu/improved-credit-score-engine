/**
 * 
 */
package com.grabathon.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.grabathon.enums.PaymentStatus;
import com.grabathon.repository.PaymentHistoryRepository;

/**
 * @author dprabhu
 *
 */
public class PaymentHistoryService {

	@Autowired
	PaymentHistoryRepository paymentHistoryRepository;
	
	public Integer getPaymentDetails(PaymentStatus pmtStatus) {
		if(pmtStatus.equals(PaymentStatus.ONTIME)) {
			// Fetch number of records for ONTIME payment
		}
		else {
			// Fetch number of records for DELAYED payment
		}
		return null;
	}
}
