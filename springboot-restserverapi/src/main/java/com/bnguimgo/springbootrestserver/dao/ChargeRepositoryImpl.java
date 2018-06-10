package com.bnguimgo.springbootrestserver.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnguimgo.springbootrestserver.entities.Charge;

@Service(value ="chargeRepository")
public class ChargeRepositoryImpl implements ChargeRepository{

	@Autowired
	private ChargeRepositoryCostum chargeRepositoryCostum;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly = false)
	public Collection<Charge> saveOrUpdateCharges(Collection<Charge> charges) {
//		for(Charge charge : charges){
//			entityManager.merge(charge);
//		}
//		entityManager.flush();
//		return charges;
		
		/* Avec Spring DATA*/
		
		Collection<Charge> chargesSaved = chargeRepositoryCostum.saveAll(charges);
		chargeRepositoryCostum.flush();
		return chargesSaved;
	}

}
