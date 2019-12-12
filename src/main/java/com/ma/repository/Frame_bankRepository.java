package com.ma.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ma.entity.Frame_bank;


public interface Frame_bankRepository extends JpaRepository<Frame_bank, Integer>{
	
	@Query(value=" SELECT * FROM frame_bank WHERE id > :ordinal LIMIT :quantity ",nativeQuery=true)
	List<Frame_bank> getQuestions(@Param("ordinal")Integer ordinal ,@Param("quantity")Integer quantity);
	
	

}
