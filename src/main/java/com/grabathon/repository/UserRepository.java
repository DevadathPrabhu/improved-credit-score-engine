/**
 * 
 */
package com.grabathon.repository;

import com.grabathon.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dprabhu
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
