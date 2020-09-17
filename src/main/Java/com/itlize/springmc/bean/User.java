package com.itlize.springmc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ita_user")
public class User {

	@Id
	@Column(name = "uid", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "name")
	String name;

	@Column(name = "username")
	String username;

	@Column(name = "password")
	String password;

	@Column(name = "type")
	String type;

	@Column(name = "active")
	boolean active;

	@Column(name = "email")
	String email;

	@Column(name = "sex")
	String sex;

	@Column(name = "phone")
	String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(int id, String name, String username, String password, String type, boolean active, String email,
			String sex, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.type = type;
		this.active = active;
		this.email = email;
		this.sex = sex;
		this.phone = phone;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", type="
				+ type + ", active=" + active + ", email=" + email + ", sex=" + sex + ", phone=" + phone + "]";
	}
	
}
