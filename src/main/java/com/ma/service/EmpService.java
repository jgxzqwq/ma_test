package com.ma.service;

import org.springframework.data.domain.Page;

import com.ma.entity.Emp;

public interface EmpService {
	Page<Emp> getPage(Integer pageNo, Integer pageSize);

	/**
	 * 校验用户名是否存在
	 * @param ename
	 * @return
	 */
	Emp getByName(String ename);

	/**
	 * 添加用户
	 * @param emp
	 */
	void save(Emp emp);

	/**
	 * 根据id查询
	 * @param eid
	 * @return
	 */
	Emp getById(Integer eid);
	/**
	 * 修改
	 * @param emp
	 */
	void update(Emp emp);

	/**
	 * 删除
	 * @param emp
	 */
	void deleteEmp(Integer eid);
}
