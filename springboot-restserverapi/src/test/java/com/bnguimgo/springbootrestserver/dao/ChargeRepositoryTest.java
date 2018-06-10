package com.bnguimgo.springbootrestserver.dao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnguimgo.springbootrestserver.SpringbootRestserverapiApplicationTests;
import com.bnguimgo.springbootrestserver.dto.ChargeDTO;
import com.bnguimgo.springbootrestserver.dto.UserDTO;
import com.bnguimgo.springbootrestserver.entities.Charge;
import com.bnguimgo.springbootrestserver.service.ChargeService;
import com.bnguimgo.springbootrestserver.service.ChargeServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(classes = {ChargeServiceImpl.class,ChargeRepositoryImpl.class})
public class ChargeRepositoryTest extends SpringbootRestserverapiApplicationTests{

//	@Autowired
//	private TestEntityManager entityManager;
	
	@Autowired
	private ChargeRepositoryCostum chargeRepositoryCostum;
	
	@Autowired
	private ChargeService chargeService;
	
	@Test
	public void getChargesByUserId(){
		Collection<Charge> chargesCollection = chargeRepositoryCostum.getChargesByUserId(15L);
		List<Charge> charges = new ArrayList<>(chargesCollection);
		
		assertTrue(charges.size()>0);
	}
	
	@Test
	public void saveCharges(){
		UserDTO user = new UserDTO(15L, "mountassir", "123456", 1);
		ChargeDTO charge1 = new ChargeDTO(1L, "LOYER", 58400., user);
		ChargeDTO charge2 = new ChargeDTO(2L, "Carburant", 4000., user);
		ChargeDTO charge3 = new ChargeDTO(3L, "Internet", 33., user);
		List<ChargeDTO> charges = new ArrayList<>();
		charges.add(charge1);
		charges.add(charge2);
		charges.add(charge3);
		
		Collection<ChargeDTO> chargesSaved = chargeService.saveOrUpdateCharges(charges);
		List<ChargeDTO> chargeList = new ArrayList<>(chargesSaved);
		
		assertTrue(chargeList.size()>0);
	}
}
