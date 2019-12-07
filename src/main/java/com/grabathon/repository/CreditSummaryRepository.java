/**
 * 
 */
package com.grabathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabathon.entities.CreditSummary;

/**
 * @author dprabhu
 *
 */
public interface CreditSummaryRepository extends JpaRepository<CreditSummary, Long>{

}
