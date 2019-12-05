package com.ma.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
//数据库表
@Table(name="emp")
//实体类
@Entity
public class Emp implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer eid;
	private String ename;
	private String eage;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date time;
	private Dept dept;
	//生成主键的方式 IDENTITY。主键由数据库自动生成（主要是自动增长型）。
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	//@Column("Eid",length=50,nullable=false,unique=false)如果字段名和属性名一致则不用写 长度 不为空 不重复
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEage() {
		return eage;
	}
	public void setEage(String eage) {
		this.eage = eage;
	}
/*	@Temporal Date类型的属性
	@Temporal(TemporalType.TIMESTAMP)
	在页面端取值：2016-09-28 15:52:32:000*/
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
/*	@JoinColumn 注解的作用：用来指定与所操作实体或实体集合相关联的数据库表中的列字段。
	相当于外键
	name属性指定了外键的名称 did　
	(注意：如果我们不通过JoinColum来指定外键的名称，系统会给我们声明一个名称)
	 @ManyToOne（多对一）
	 fetch=FetchType.LAZY属性表示在多的那一方通过延迟加载的方式加载对象
	 (默认不是延迟加载)*/
	
	@JoinColumn(name="did")
	@ManyToOne(fetch=FetchType.LAZY)
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	//@Transient 可以不需要映射为数据表的一列 
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", time=" + time + ", dept=" + dept + "]";
	}
}
