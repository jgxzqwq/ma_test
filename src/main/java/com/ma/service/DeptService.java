package com.ma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ma.entity.Dept;


public interface DeptService {

	/**
	 * 查询
	 * @return
	 */
	List<Dept> getListDepts();

	/**
	 * 添加
	 * @param dept
	 */
	void save(Dept dept);
}
