package com.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Emp;
import com.ma.repository.EmpRepository;
import com.ma.service.EmpService;


@Service
@Transactional
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepository empRepository;
	
	/**
	 * 分页查询
	 */
	@Override
	public Page<Emp> getPage(Integer pageNo,Integer pageSize) {
		PageRequest pageRequest = new PageRequest(pageNo-1, pageSize);
		Page<Emp> page =empRepository.findAll(pageRequest);
		return page;
	}

	/**
	 * 校验用户名是否存在
	 */
	@Override
	public Emp getByName(String ename) {
		Emp emp = empRepository.getname(ename);
		return emp;
	}

	/**
	 * 添加用户
	 */
	@Override
	public void save(Emp emp) {
		empRepository.save(emp);
	}

	/**
	 * 根据id查询
	 */
	@Override
	public Emp getById(Integer eid) {
		Emp emp = empRepository.findOne(eid);
		return emp;
	}

	/**
	 * 修改
	 */
	@Override
	public void update(Emp emp) {
		empRepository.saveAndFlush(emp);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteEmp(Integer eid) {
		empRepository.delete(eid);
		
	}
}
