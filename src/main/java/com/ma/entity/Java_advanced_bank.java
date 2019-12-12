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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
//数据库表
@Table(name="java_advanced_bank")
//实体类
@Entity
public class Java_advanced_bank  implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private Types type;
 	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private Integer answer;
	private String parse;
	//生成主键的方式 IDENTITY。主键由数据库自动生成（主要是自动增长型）。
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	public String getParse() {
		return parse;
	}
	public void setParse(String parse) {
		this.parse = parse;
	}
	@JoinColumn(name="type_id")
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action= NotFoundAction.IGNORE) //注解，找不到引用的外键数据时忽略，NotFound默认是exception
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Frame_bank [id=" + id + ", title=" + title + ", type=" + type + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer + ", parse=" + parse
				+ "]";
	}
	
	
}
