/**
 * 
 */
package com.grabathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grabathon.repository.CreditSummaryRepository;

/**
 * @author dprabhu
 *
 */

@Service
public class CreditSummaryService {

	@Autowired
	CreditSummaryRepository creditSummaryRepository;
	
	
	
}
