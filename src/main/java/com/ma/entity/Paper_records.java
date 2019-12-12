package com.ma.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


//数据库表
@Table(name="paper_records")
//实体类
@Entity
public class Paper_records implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	@Transient
	private Integer user_id;
	private Integer frame_id;
	private Integer front_end_id;
	private Integer java_advanced_id;
	private Integer java_intermediate_id;
    private Integer java_junior_id;
    
    @OneToOne
    @JoinColumn(name="user_id",unique=true)
    private User user;
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getFrame_id() {
		return frame_id;
	}
	public void setFrame_id(Integer frame_id) {
		this.frame_id = frame_id;
	}
	public Integer getFront_end_id() {
		return front_end_id;
	}
	public void setFront_end_id(Integer front_end_id) {
		this.front_end_id = front_end_id;
	}
	public Integer getJava_advanced_id() {
		return java_advanced_id;
	}
	public void setJava_advanced_id(Integer java_advanced_id) {
		this.java_advanced_id = java_advanced_id;
	}
	public Integer getJava_intermediate_id() {
		return java_intermediate_id;
	}
	public void setJava_intermediate_id(Integer java_intermediate_id) {
		this.java_intermediate_id = java_intermediate_id;
	}
	public Integer getJava_junior_id() {
		return java_junior_id;
	}
	public void setJava_junior_id(Integer java_junior_id) {
		this.java_junior_id = java_junior_id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Paper_records [id=" + id + ", user_id=" + user_id + ", frame_id=" + frame_id + ", front_end_id="
				+ front_end_id + ", java_advanced_id=" + java_advanced_id + ", java_intermediate_id="
				+ java_intermediate_id + ", java_junior_id=" + java_junior_id + "]";
	}
	

    
    
    
}
