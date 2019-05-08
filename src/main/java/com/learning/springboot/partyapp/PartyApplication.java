package com.learning.springboot.partyapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.config.java.annotation.aop;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.learning.springboot.partyapp.entity.PartyEntity;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class PartyApplication implements ApplicationRunner, CommandLineRunner {
	@Value("${spring.application.name}")
	private String applicationName;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PartyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PartyApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		LOGGER.info("ApplicationRunner - {}", applicationName);
	}

	@Override
	public void run(String... arg0) throws Exception {
		LOGGER.info("CommandLineRunner - {}", applicationName);
	}

	@Bean(name = "blankParty")
	// @Scope("session")
	// @ScopedProxy
	public PartyEntity getBlankPartyEntity() {
		return new PartyEntity();
	}

	@Bean(name = "dummyParty")
	// @Scope("session")
	// @ScopedProxy
	public PartyEntity getDummyPartyEntity() {
		PartyEntity pe = new PartyEntity();
		pe.setId(123L);
		pe.setName("Saurabh");
		pe.setEmail("xyz@gma.com");
		return pe;
	}
}
