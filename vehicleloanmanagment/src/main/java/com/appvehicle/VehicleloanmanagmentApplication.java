package com.appvehicle;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.appvehicle.controller")
public class VehicleloanmanagmentApplication {
    
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(VehicleloanmanagmentApplication.class, args);
	}

}
