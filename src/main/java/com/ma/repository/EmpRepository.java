package com.ma.repository;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ma.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

	/**
	 * 根据用户名查询
	 * @param ename
	 * @return
	 */
	@Query("from Emp where ename= :ename")
	Emp getname(@Param("ename") String ename);
	
	/**
	 * 分页查询，添加,修改：不需要定义方法，直接调用父接口中的save()方法
	 */
	
	/**
	 * 删除：也可以不定义方法，和上面一样，可以直接电涌父接口中的方法
	 * @return 
	 */
	/*@Modifying
	@Query("delete from Emp where eid= :eid")
	void delete(@Param("eid") Integer eid);*/
	
	
}
