package com.superface.example.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * User
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable{
    private static final long serialVersionUID = -5440372534300871944L;
	
	@Id
	private Integer id;
	private String userName;
	private String password;
	private Date createTime;
	private String status;

	@ManyToMany
	private List<Role> userRole;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the userRole
	 */
	public List<Role> getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(List<Role> userRole) {
		this.userRole = userRole;
	}
}