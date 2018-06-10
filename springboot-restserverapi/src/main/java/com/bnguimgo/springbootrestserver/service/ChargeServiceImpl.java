package com.bnguimgo.springbootrestserver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnguimgo.springbootrestserver.dao.ChargeRepository;
import com.bnguimgo.springbootrestserver.dao.ChargeRepositoryCostum;
import com.bnguimgo.springbootrestserver.dto.ChargeDTO;
import com.bnguimgo.springbootrestserver.entities.Charge;
import com.bnguimgo.springbootrestserver.utils.ChargeUtils;

@Service(value = "chargeService")
public class ChargeServiceImpl implements ChargeService {

	@Autowired
	private ChargeRepositoryCostum chargeRepositoryCostum;
	
	@Autowired
	private ChargeRepository chargeRepository;

	@Override
	public Collection<ChargeDTO> getChargesByUserId(Long id) {
		Collection<Charge> charges = chargeRepositoryCostum.getChargesByUserId(id);

		if (charges.isEmpty())
			return null;

		List<ChargeDTO> chargesDTO = new ArrayList<>();
		for (Charge charge : charges) {
			chargesDTO.add(ChargeUtils.mapChargeEntityToDto(charge));
		}
		return chargesDTO;
	}

	@Override
	public Collection<ChargeDTO> getChargesByName(String nom) {
		Collection<Charge> charges = chargeRepositoryCostum.getChargesByName(nom);

		if (charges.isEmpty())
			return null;

		List<ChargeDTO> chargesDTO = new ArrayList<>();
		for (Charge charge : charges) {
			chargesDTO.add(ChargeUtils.mapChargeEntityToDto(charge));
		}
		return chargesDTO;
	}

	@Override
	public Collection<ChargeDTO> saveOrUpdateCharges(Collection<ChargeDTO> charges) {
		Collection<Charge> chargeList = chargeRepository.saveOrUpdateCharges(ChargeUtils.mapChargeDtoToEntity(charges));
		return ChargeUtils.mapChargeEntityToDto(chargeList);
	}

	@Override
	public void deleteCharge(Long id) {
		chargeRepositoryCostum.deleteCharge(id);
	}

}
