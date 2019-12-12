package com.ma.service;

import java.util.List;

import com.ma.entity.User;

public interface QuestionsBankService {

	
	//获取试题
	public List getQuestions(User user,Integer questionType);
}
