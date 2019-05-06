package com.superface.example.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

/**
 * Permission
 * 授权
 */
@Entity
@Table(name = "sys_permission")
public class Permission {

    @Id
	private Integer id;
	private String url;
	private String name;

	@ManyToMany(mappedBy = "rolePermission")
	private List<Role> permissionRole;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the permissionRole
	 */
	public List<Role> getPermissionRole() {
		return permissionRole;
	}

	/**
	 * @param permissionRole the permissionRole to set
	 */
	public void setPermissionRole(List<Role> permissionRole) {
		this.permissionRole = permissionRole;
	}
    
}