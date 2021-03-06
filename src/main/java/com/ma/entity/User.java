package com.ma.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;




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

private Paper_records paper_records;
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
@JoinColumn(name="id",unique=true)
@NotFound(action= NotFoundAction.IGNORE) //注解，找不到引用的外键数据时忽略，NotFound默认是exception
public Paper_records getPaper_records() {
	return paper_records;
}
public void setPaper_records(Paper_records paper_records) {
	this.paper_records = paper_records;
}
@Override
public String toString() {
	return "User [id=" + id + ", account=" + account + ", password=" + password + ", mailbox=" + mailbox + ", "+ "]";
}



}
