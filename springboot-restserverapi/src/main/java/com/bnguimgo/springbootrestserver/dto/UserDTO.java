package com.bnguimgo.springbootrestserver.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class UserDTO implements Serializable {

	private static final long serialVersionUID = -443589941665403890L;

	private Long id;

	private String login;
	private String password;
	private String userType;
	private Integer active;
	//private Collection<ChargeDTO> charges;
	
	public UserDTO() {
	}

	public UserDTO(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public UserDTO(String login, String password, String userType) {
		this.login = login;
		this.password = password;
		this.userType = userType;
	}

	public UserDTO(Long id, String login) {
		this.id = id;
		this.login = login;
	}

	public UserDTO(Long id, String login, String password, String userType) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.userType = userType;
	}

	
	public UserDTO(Long id, String login, String password, Integer active) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	@XmlElement
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	@XmlElement
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getActive() {
		return active;
	}

	@XmlElement
	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.format("[id=%s, mail=%s, userType=%s]", id, login, userType);
	}

//	public Collection<ChargeDTO> getCharges() {
//		return charges;
//	}
//
//	public void setCharges(Collection<ChargeDTO> charges) {
//		this.charges = charges;
//	}
	
	

}