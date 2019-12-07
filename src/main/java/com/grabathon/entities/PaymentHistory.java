/**
 * 
 */
package com.grabathon.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author dprabhu
 *
 */

@Data
@Entity
public class PaymentHistory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Integer loanNumber;
	private Instant dueDate;
	private Instant paymentDate;
	private Double amount;
	
}
