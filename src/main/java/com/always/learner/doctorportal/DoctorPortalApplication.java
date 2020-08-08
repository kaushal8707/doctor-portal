package com.always.learner.doctorportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DoctorPortalApplication
{
	public static void main(String[] args) {
		SpringApplication.run(DoctorPortalApplication.class, args);
	}

}
