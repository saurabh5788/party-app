package com.learning.springboot.partyapp.helper;

import com.learning.springboot.partyapp.entity.PartyEntity;

public class PartyFactory {
	public PartyEntity getNewParty(){
		return new PartyEntity();
	}
}
