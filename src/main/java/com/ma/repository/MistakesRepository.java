package com.ma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ma.entity.Mistakes;

public interface MistakesRepository extends JpaRepository<Mistakes, Integer>{
	

	@Query(value="select count(id) from mistakes  where user_id = :user_id and mistakes_type = :mistakes_type  ",nativeQuery=true)
	Integer Statistics(@Param("user_id")Integer user_id,@Param("mistakes_type") Integer mistakes_type);

}
