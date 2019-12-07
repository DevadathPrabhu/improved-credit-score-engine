/**
 * 
 */
package com.grabathon.repository;

import com.grabathon.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dprabhu
 *
 */
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
