package com.springmvc.models;

import com.springmvc.entities.RoleEntity;

public class Role {
	
	private int roleId;
	
	private String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public void entity2model(RoleEntity entity) {
		this.setRoleId(entity.getRole_id());
		this.setRoleName(entity.getRole_name());
	}
}
