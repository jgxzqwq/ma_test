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
@Table(name="paper_records")
//实体类
@Entity
public class Paper_records implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private Frame_bank frame_bank;
	private Front_end_bank front_end_bank;
	private Java_advanced_bank java_advanced_bank;
	private Java_intermediate_bank java_intermediate_bank;
    private Java_junior_bank java_junior_bank;
    
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
	@JoinColumn(name="frame_id")
	@ManyToOne(fetch=FetchType.LAZY)
	public Frame_bank getFrame_bank() {
		return frame_bank;
	}
	public void setFrame_bank(Frame_bank frame_bank) {
		this.frame_bank = frame_bank;
	}
	@JoinColumn(name="front_end_id")
	@ManyToOne(fetch=FetchType.LAZY)
	public Front_end_bank getFront_end_bank() {
		return front_end_bank;
	}
	public void setFront_end_bank(Front_end_bank front_end_bank) {
		this.front_end_bank = front_end_bank;
	}
	@JoinColumn(name="java_advanced_id")
	@ManyToOne(fetch=FetchType.LAZY)
	public Java_advanced_bank getJava_advanced_bank() {
		return java_advanced_bank;
	}
	public void setJava_advanced_bank(Java_advanced_bank java_advanced_bank) {
		this.java_advanced_bank = java_advanced_bank;
	}
	@JoinColumn(name="java_intermediate_id")
	@ManyToOne(fetch=FetchType.LAZY)
	public Java_intermediate_bank getJava_intermediate_bank() {
		return java_intermediate_bank;
	}
	public void setJava_intermediate_bank(Java_intermediate_bank java_intermediate_bank) {
		this.java_intermediate_bank = java_intermediate_bank;
	}
	@JoinColumn(name="java_junior_id")
	@ManyToOne(fetch=FetchType.LAZY)
	public Java_junior_bank getJava_junior_bank() {
		return java_junior_bank;
	}
	public void setJava_junior_bank(Java_junior_bank java_junior_bank) {
		this.java_junior_bank = java_junior_bank;
	}
	@Override
	public String toString() {
		return "Paper_records [id=" + id + ", user=" + user + ", frame_bank=" + frame_bank + ", front_end_bank="
				+ front_end_bank + ", java_advanced_bank=" + java_advanced_bank + ", java_intermediate_bank="
				+ java_intermediate_bank + ", java_junior_bank=" + java_junior_bank + "]";
	}
    
    
    
}
