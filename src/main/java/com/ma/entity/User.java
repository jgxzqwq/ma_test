package com.ma.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//数据库表
@Table(name="user")
//实体类
@Entity
public class User implements Serializable {
	
private static final long serialVersionUID = 1L;
private Integer id;
private String account;
private String password;
private String mailbox;
private User user;

@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMailbox() {
	return mailbox;
}
public void setMailbox(String mailbox) {
	this.mailbox = mailbox;
}

@OneToOne
@JoinColumn(name="user_id",unique=true)
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Override
public String toString() {
	return "User [id=" + id + ", account=" + account + ", password=" + password + ", mailbox=" + mailbox + ", user="
			+ user + "]";
}



}
