package com.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ma.entity.Paper_records;

public interface Paper_recordsRepository extends JpaRepository<Paper_records, Integer>{

	

}
