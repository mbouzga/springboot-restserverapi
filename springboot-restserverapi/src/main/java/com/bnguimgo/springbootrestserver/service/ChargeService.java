package com.bnguimgo.springbootrestserver.service;

import java.util.Collection;

import com.bnguimgo.springbootrestserver.dto.ChargeDTO;

public interface ChargeService {

	Collection<ChargeDTO> getChargesByUserId(Long id);
	Collection<ChargeDTO> getChargesByName(String nom);
	Collection<ChargeDTO> saveOrUpdateCharges(Collection<ChargeDTO> charges);
	void deleteCharge(Long id);
	
}
