package com.iafoot.activity;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Copyright: iAfoot.
 * @Description:
 * @author: RX.HAN
 * @since: 2020/11/11 11:07 AM
 */

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityApplication.class, args);
	}

}
