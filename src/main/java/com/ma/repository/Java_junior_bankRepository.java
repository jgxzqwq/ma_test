package com.ma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ma.entity.Java_junior_bank;

public interface Java_junior_bankRepository extends JpaRepository<Java_junior_bank, Integer>{

	@Query(value=" SELECT * FROM java_junior_bank WHERE id > :ordinal LIMIT :quantity ",nativeQuery=true)
	List<Java_junior_bank> getQuestions(@Param("ordinal")Integer ordinal ,@Param("quantity")Integer quantity);
}
