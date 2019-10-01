package com.springmvc.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`Role`")
public class RoleEntity {

	@Id
	@Column(name = "`role_id`")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int role_id;
	
	@Column(name = "role_name")
	private String role_name;

	//=====================================================================
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	public Set<UserEntity> users;
	
	//=====================================================================
	
	public int getRole_id() {
		return role_id;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
}
