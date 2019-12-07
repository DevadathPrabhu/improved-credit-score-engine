/**
 * 
 */
package com.grabathon.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dprabhu
 *
 */

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHistory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Integer loanNumber;
	private Instant dueDate;
	private Instant paymentDate;
	private Double amount;
	private Long userId;
	
}
