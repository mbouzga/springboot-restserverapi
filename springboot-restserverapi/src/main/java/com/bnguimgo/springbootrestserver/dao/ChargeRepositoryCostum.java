package com.bnguimgo.springbootrestserver.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bnguimgo.springbootrestserver.entities.Charge;

public interface ChargeRepositoryCostum extends JpaRepository<Charge, Long>{

	@Query("FROM Charge c WHERE c.user.id = ?1")
	Collection<Charge> getChargesByUserId(Long id);
	
	@Query("FROM Charge c WHERE c.nom = ?1")
	Collection<Charge> getChargesByName(String nom);
	
	@Modifying
	@Transactional(readOnly = false)
	@Query("DELETE FROM Charge c WHERE c.id = ?1")
	void deleteCharge(Long id);
	
}
