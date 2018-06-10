package com.bnguimgo.springbootrestserver.dao;

import java.util.Collection;

import com.bnguimgo.springbootrestserver.entities.Charge;

public interface ChargeRepository {

	Collection<Charge> saveOrUpdateCharges(Collection<Charge> charges);
}
