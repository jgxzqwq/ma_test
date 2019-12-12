package com.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Paper_records;
import com.ma.repository.Paper_recordsRepository;
import com.ma.service.Paper_recordsService;

@Service
@Transactional
public class Paper_recordsServiceImpl implements Paper_recordsService {

	@Autowired
	private Paper_recordsRepository paperRecords;

	@Override
	public Paper_records getDorecord(Integer userId) {
		return null;
		
	}
	
}
