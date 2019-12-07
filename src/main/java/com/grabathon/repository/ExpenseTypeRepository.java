/**
 * 
 */
package com.grabathon.repository;

import com.grabathon.entities.ExpenseType;
import com.grabathon.entities.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dprabhu
 *
 */
public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Long> {

}
