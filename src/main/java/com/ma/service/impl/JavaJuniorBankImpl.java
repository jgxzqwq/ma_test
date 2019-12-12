package com.ma.service.impl;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.PluginValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Java_junior_bank;
import com.ma.repository.Java_junior_bankRepository;
import com.ma.service.JavaJuniorBankService;

@Service
@Transactional
public class JavaJuniorBankImpl implements JavaJuniorBankService {

	@Autowired
	private Java_junior_bankRepository javaJuniorBank;

	//根据该类型题该用户所做的最后一道题的id(ordinal)和要拿多少道题(quantity)返回题目集
	@Override
	public List<Java_junior_bank> getSubject(@PluginValue("ordinal")Integer ordinal,@PluginValue("quantity") Integer quantity) {
		List<Java_junior_bank> questions = javaJuniorBank.getQuestions(ordinal, quantity);	
		return questions;
	}
}
