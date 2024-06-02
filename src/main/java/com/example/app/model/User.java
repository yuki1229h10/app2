//package com.example.app.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//
//	@Column(length = 50, nullable = false, name = "username")
//	private String username;
//
//	@Column(length = 255, nullable = false, name = "password")
//	private String password;
//
//	@Column(nullable = false, name = "enabled")
//	private boolean enabled;
//
//	public User() {
//	}
//
//	public User(Integer id, String username, String password, Boolean enabled) {
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.enabled = enabled;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public boolean getEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(Boolean enabled) {
//		this.enabled = enabled;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
//	}
//
//}
