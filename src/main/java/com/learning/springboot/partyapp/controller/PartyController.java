package com.learning.springboot.partyapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.partyapp.entity.PartyEntity;
import com.learning.springboot.partyapp.repository.PartyRepository;

@RestController
@RequestMapping(value = "/party")
public class PartyController {

	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	@Autowired
	PartyRepository repository;

	@Autowired
	@Qualifier(value = "blankParty")
	PartyEntity blankParty;

	@GetMapping(path = "/hello")
	public String helloParty() {
		LOGGER.info("Instance ID : {}",instanceId);
		return "Hello Party!!!";
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PartyController.class);

	@GetMapping(path = "/{id}")
	public ResponseEntity<PartyEntity> find(@PathVariable("id") Long id) {
		LOGGER.info("Instance ID : {}",instanceId);
		PartyEntity party = repository.findOne(id);
		if (party == null) {
			// return new ResponseEntity<PartyEntity>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<PartyEntity>(blankParty,
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PartyEntity>(party, HttpStatus.OK);
	}
}
