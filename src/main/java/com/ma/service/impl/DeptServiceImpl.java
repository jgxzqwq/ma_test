package com.ma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Dept;
import com.ma.repository.DeptRepository;
import com.ma.service.DeptService;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptRepository deptRepository;
	
	/**
	 * 查询
	 */
	@Override
	public List<Dept> getListDepts() {
		List<Dept> list = deptRepository.findAll();
		return list;
	}

	/**
	 * 添加
	 */
	@Override
	public void save(Dept dept) {
		deptRepository.save(dept);
	}
	

}
