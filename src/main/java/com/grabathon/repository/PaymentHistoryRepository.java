/**
 * 
 */
package com.grabathon.repository;

import com.grabathon.entities.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dprabhu
 *
 */
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {

}
