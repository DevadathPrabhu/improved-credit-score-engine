/**
 * 
 */
package com.grabathon.repository;

import org.springframework.data.repository.CrudRepository;

import com.grabathon.entities.User;

/**
 * @author dprabhu
 *
 */
public interface UserRepo extends CrudRepository<User, String>{

}
