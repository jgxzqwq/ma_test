package com.ma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ma.entity.Java_intermediate_bank;

public interface Java_intermediate_bankRepository extends JpaRepository<Java_intermediate_bank, Integer>{
	
	@Query(value=" SELECT * FROM java_intermediate_bank WHERE id > :ordinal LIMIT :quantity ",nativeQuery=true)
	List<Java_intermediate_bank> getQuestions(@Param("ordinal")Integer ordinal ,@Param("quantity")Integer quantity);
}
