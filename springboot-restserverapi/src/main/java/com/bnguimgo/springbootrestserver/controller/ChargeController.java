package com.bnguimgo.springbootrestserver.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnguimgo.springbootrestserver.dto.ChargeDTO;
import com.bnguimgo.springbootrestserver.service.ChargeService;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RequestMapping("/charges/*")
public class ChargeController {

	@Autowired
	private ChargeService chargeService;
	
	@GetMapping(value = "/user/{id}")
	public Collection<ChargeDTO> getChargeByUserId(@PathVariable Long id){
		Collection<ChargeDTO> charges = chargeService.getChargesByUserId(id);
		return charges;
	}
	
	@PostMapping(value = "/send")
	public Collection<ChargeDTO> sendCharges(@RequestBody Collection<ChargeDTO> charges){
		Collection<ChargeDTO> chargeSaved = chargeService.saveOrUpdateCharges(charges);
		return chargeSaved;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteCharge(@PathVariable Long id){
		chargeService.deleteCharge(id);
		return new ResponseEntity<String> ("Suppression de Charge [id = "+id+"]",HttpStatus.OK);
	}
}
