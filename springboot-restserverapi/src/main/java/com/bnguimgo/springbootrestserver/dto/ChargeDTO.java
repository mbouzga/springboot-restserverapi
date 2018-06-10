package com.bnguimgo.springbootrestserver.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


public class ChargeDTO implements Serializable {

	private static final long serialVersionUID = -443589941665403890L;
	
	private Long id;
	
	private String nom;

	private Double montant;
	
	private UserDTO user;

	public ChargeDTO() {
		super();
	}

	public ChargeDTO(Long id, String nom, Double montant, UserDTO user) {
		super();
		this.id = id;
		this.nom = nom;
		this.montant = montant;
		this.user = user;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}
