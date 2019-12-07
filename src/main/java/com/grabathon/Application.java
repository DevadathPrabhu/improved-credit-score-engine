/**
 * 
 */
package com.grabathon;

import com.grabathon.service.DataCookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author dprabhu
 *
 */

@SpringBootApplication
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        ctx.getBean(DataCookingService.class).cookData();
    }

}
