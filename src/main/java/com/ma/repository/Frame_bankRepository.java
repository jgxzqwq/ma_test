package com.ma.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ma.entity.Frame_bank;

public interface Frame_bankRepository extends JpaRepository<Frame_bank, Integer>{
	
	/**
	 * 查询题目
	 * @param id
	 * @return list
	 */
     //实体名
	@Query("FROM Frame_bank WHERE id> :id")
	List<Frame_bank> findId(@Param("id") Integer id);

}
