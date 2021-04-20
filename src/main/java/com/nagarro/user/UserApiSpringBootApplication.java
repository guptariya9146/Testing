package com.nagarro.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
@ServletComponentScan
public class UserApiSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiSpringBootApplication.class, args);
		
		
	}

}
