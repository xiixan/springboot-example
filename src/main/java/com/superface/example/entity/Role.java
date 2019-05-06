package com.superface.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.superface.example.repositories.PermissionReposity;

/**
 * Role 角色model
 */
@Entity
@Table(name = "sys_role")
public class Role implements Serializable {

	private static final long serialVersionUID = -227437593919820521L;
	@Id
	private Integer id;
	private String name;
	private String memo;

	@ManyToMany
	private List<Permission> rolePermission;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the rolePermission
	 */
	public List<Permission> getRolePermission() {
		return rolePermission;
	}

	/**
	 * @param rolePermission the rolePermission to set
	 */
	public void setRolePermission(List<Permission> rolePermission) {
		this.rolePermission = rolePermission;
	}
	
    
}