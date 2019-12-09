package com.ma.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//数据库表
@Table(name="userinfo")
//实体类
@Entity(name = "userInfo")
public class UserInfo implements Serializable {
	
private static final long serialVersionUID = 1L;

private Integer id;
private String name;
private String clazz;
private String grade;
private Integer experience;
private String head_img;
private Integer score;
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
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
public String getClazz() {
	return clazz;
}
public void setClazz(String clazz) {
	this.clazz = clazz;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public Integer getExperience() {
	return experience;
}
public void setExperience(Integer experience) {
	this.experience = experience;
}
public String getHead_img() {
	return head_img;
}
public void setHead_img(String head_img) {
	this.head_img = head_img;
}
public Integer getScore() {
	return score;
}
public void setScore(Integer score) {
	this.score = score;
}
@Override
public String toString() {
	return "UserInfo [id=" + id + ", name=" + name + ", clazz=" + clazz + ", grade=" + grade + ", experience="
			+ experience + ", head_img=" + head_img + ", score=" + score + "]";
}



}
