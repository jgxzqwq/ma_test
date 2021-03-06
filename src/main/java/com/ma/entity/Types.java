package com.ma.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//数据库表
@Table(name="types")
//实体类
@Entity
public class Types implements Serializable {
	
private static final long serialVersionUID = 1L;

private Integer id;
private String type;
private String table_name;
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public String getTable_name() {
	return table_name;
}
public void setTable_name(String table_name) {
	this.table_name = table_name;
}
@Override
public String toString() {
	return "Types [id=" + id + ", type=" + type + ", table_name=" + table_name + "]";
}


}	
