package com.bnguimgo.springbootrestserver.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.bnguimgo.springbootrestserver.dto.ChargeDTO;
import com.bnguimgo.springbootrestserver.dto.RoleDTO;
import com.bnguimgo.springbootrestserver.dto.UserDTO;
import com.bnguimgo.springbootrestserver.entities.Charge;
import com.bnguimgo.springbootrestserver.entities.Role;
import com.bnguimgo.springbootrestserver.entities.User;

public class UserUtils {

	public static UserDTO mapUserEntityToDto(User userEntity){
		if(userEntity == null){
			return null;
		} else {
			
			UserDTO userDto = new UserDTO();
			
			userDto.setId(userEntity.getId());
			userDto.setLogin(userEntity.getLogin());
			userDto.setPassword(userEntity.getPassword());
			userDto.setUserType("");
			
//			if(!userEntity.getCharges().isEmpty()){
//				List<ChargeDTO> chargesDTO = new ArrayList<>();
//				for(Charge charge : userEntity.getCharges()){
//					chargesDTO.add(ChargeUtils.mapChargeEntityToDto(charge));
//				}
//				userDto.setCharges(chargesDTO);
//			}
			return userDto;
		}
	}
	
	public static User mapUserDtoToEntity(UserDTO userDto){
		if(userDto == null){
			return null;
		} else {
			User userEntity = new User();
			userEntity.setId(userDto.getId());
			userEntity.setLogin(userDto.getLogin());
			userEntity.setPassword(userDto.getPassword());
			userEntity.setActive(1);
			Set<Role> roles = new HashSet<>();
			if(userDto.getUserType() != null && "ROLE_ADMIN".equals(userDto.getUserType())){
				roles.add(new Role(1L,"ROLE_ADMIN"));
				userEntity.setRoles(roles);
			}else {
				roles.add(new Role(2L,"ROLE_USER"));
			}
			userEntity.setRoles(roles);
			return userEntity;
		}
	}
	
	public static RoleDTO mapRoleEntityToDto(Role roleEntity){
		if(roleEntity == null){
			return null;
		} else {
			RoleDTO roleDto = new RoleDTO();
			roleDto.setIdRole(roleEntity.getId());
			roleDto.setRoleName(roleEntity.getRoleName());
			return roleDto;
		}
	}
	
	public static Role mapRoleDtoToEntity(RoleDTO roleDto){
		if(roleDto == null){
			return null;
		} else {
			Role roleEntity = new Role();
			roleEntity.setId(roleDto.getIdRole());
			roleEntity.setRoleName(roleEntity.getRoleName());
			return roleEntity;
		}
	}
}
