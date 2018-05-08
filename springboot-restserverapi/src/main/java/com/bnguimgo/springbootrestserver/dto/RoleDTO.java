package com.bnguimgo.springbootrestserver.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable{

	private static final long serialVersionUID = -3287376071597661618L;
	
	private Long idRole;
	private String roleName;
	
	public RoleDTO() {
		super();
	}

	public RoleDTO(Long idRole, String roleName) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleDTO [idRole=" + idRole + ", roleName=" + roleName + "]";
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
