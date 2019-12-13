package com.ma.service.impl;

import java.util.List;

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

	//通过用户的id为用户初始化该用户的做题记录
	@Override
	@Transactional
	public Paper_records addRecord(Integer user_id) {
		// TODO Auto-generated method stub
		Paper_records save=null;
		try {
			Paper_records paper_records = new Paper_records();
			paper_records.setId(user_id);
			paper_records.setFrame_id(0);
			paper_records.setFront_end_id(0);
			paper_records.setJava_advanced_id(0);
			paper_records.setJava_intermediate_id(0);
			paper_records.setJava_junior_id(0);
	
			
			System.out.println(paper_records.toString());
			 save = paperRecords.saveAndFlush(paper_records);
		
			System.out.println(save.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

		return save;
	}

	
}
