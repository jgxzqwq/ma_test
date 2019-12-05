package com.ma.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//数据库表
@Table(name="mistakes")
//实体类
@Entity
public class Mistakes implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private Integer mistakes_id;
	private Types type;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JoinColumn(name="user_id")
	@ManyToOne(fetch=FetchType.LAZY)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getMistakes_id() {
		return mistakes_id;
	}
	public void setMistakes_id(Integer mistakes_id) {
		this.mistakes_id = mistakes_id;
	}
	@JoinColumn(name="mistakes_type")
	@ManyToOne(fetch=FetchType.LAZY)
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Mistakes [id=" + id + ", user=" + user + ", mistakes_id=" + mistakes_id + ", type=" + type + "]";
	}
	
	
	
}
