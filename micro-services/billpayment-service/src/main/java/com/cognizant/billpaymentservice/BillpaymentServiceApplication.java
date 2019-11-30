package com.cognizant.billpaymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class BillpaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillpaymentServiceApplication.class, args);
	}

}
