package com.bnguimgo.springbootrestserver.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CHARGE")
@XmlRootElement(name = "charge")
public class Charge implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHARGE_ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "montant")
	private Double montant;

	@ManyToOne
    @JoinColumn(name = "USER_ID")
	private User user;

	public Charge() {
		super();
	}

	public Charge(Long id, String nom, Double montant, User user) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
