package com.bnguimgo.springbootrestserver.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bnguimgo.springbootrestserver.dto.ChargeDTO;
import com.bnguimgo.springbootrestserver.entities.Charge;

public class ChargeUtils {

	public static ChargeDTO mapChargeEntityToDto(Charge charge) {

		if (charge == null)
			return null;

		ChargeDTO chargeDTO = new ChargeDTO();
		chargeDTO.setId(charge.getId());
		chargeDTO.setNom(charge.getNom());
		chargeDTO.setMontant(charge.getMontant());
		chargeDTO.setUser(UserUtils.mapUserEntityToDto(charge.getUser()));
		return chargeDTO;
	}

	public static Collection<ChargeDTO> mapChargeEntityToDto(Collection<Charge> charges) {
		List<ChargeDTO> chargesDTO = new ArrayList<>();
		if(!charges.isEmpty()){
			for(Charge charge : charges){
				chargesDTO.add(mapChargeEntityToDto(charge));
			}
		}
		return chargesDTO;
	}

	public static Charge mapChargeDtoToEntity(ChargeDTO chargeDTO) {

		if (chargeDTO == null)
			return null;

		Charge charge = new Charge();
		charge.setId(chargeDTO.getId());
		charge.setNom(chargeDTO.getNom());
		charge.setMontant(chargeDTO.getMontant());
		charge.setUser(UserUtils.mapUserDtoToEntity(chargeDTO.getUser()));
		return charge;
	}
	
	public static Collection<Charge> mapChargeDtoToEntity(Collection<ChargeDTO> chargesDTO) {
		Collection<Charge> charges = new ArrayList<>();
		
		if(!chargesDTO.isEmpty()){
			for(ChargeDTO chargeDTO : chargesDTO){
				charges.add(mapChargeDtoToEntity(chargeDTO));
			}
		}
		return charges;
	}
}
