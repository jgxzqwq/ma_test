package com.ma.service;

import com.ma.entity.Paper_records;
import com.ma.entity.User;

public interface Paper_recordsService {

	
	//通过用户id获取用户做题记录
	public Paper_records getDorecord(Integer user_id);

	
}
