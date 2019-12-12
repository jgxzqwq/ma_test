package com.ma.service.impl;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.PluginValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Java_advanced_bank;
import com.ma.repository.Java_advanced_bankRepository;
import com.ma.service.JavaAdvancedBankService;

@Service
@Transactional
public class JavaAdvancedBankImpl implements JavaAdvancedBankService {

	
	@Autowired
	private Java_advanced_bankRepository javaAdvancedBank;

	
	//根据该类型题该用户所做的最后一道题的id(ordinal)和要拿多少道题(quantity)返回题目集
	@Override
	public List<Java_advanced_bank> getSubject(@PluginValue("ordinal")Integer ordinal,@PluginValue("quantity") Integer quantity) {
	List<Java_advanced_bank> questions = javaAdvancedBank.getQuestions(ordinal, quantity);
		return questions;
	}
	
	
}
