package com.ma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ma.entity.Front_end_bank;



public interface Front_end_bankRepository extends JpaRepository<Front_end_bank, Integer>{
	@Query(value=" SELECT * FROM front_end_bank WHERE id > :ordinal LIMIT :quantity ",nativeQuery=true)
	List<Front_end_bank> getQuestions(@Param("ordinal")Integer ordinal ,@Param("quantity")Integer quantity);
}
