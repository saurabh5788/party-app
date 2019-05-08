package com.learning.springboot.partyapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARTY")
public class PartyEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Long id;
	@Column(name = "NAME", length = 64, nullable = false)
	private String name;
	@Column(name = "EMAIL", length = 64, nullable = false)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
