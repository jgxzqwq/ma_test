package com.ma.service.impl;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.PluginValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Java_intermediate_bank;
import com.ma.repository.Java_intermediate_bankRepository;
import com.ma.service.JavaIntermediateBankService;

@Service
@Transactional
public class JavaIntermediateBankImpl implements JavaIntermediateBankService {

	
	@Autowired
	private Java_intermediate_bankRepository frameBanfgk;

	//根据该类型题该用户所做的最后一道题的id(ordinal)和要拿多少道题(quantity)返回题目集
	@Override
	public List<Java_intermediate_bank> getSubject(@PluginValue("ordinal")Integer ordinal,@PluginValue("quantity") Integer quantity) {
		
		List<Java_intermediate_bank> questions = frameBanfgk.getQuestions(ordinal, quantity);
		for (Java_intermediate_bank java_intermediate_bank : questions) {
			System.out.println(java_intermediate_bank);
		}
		return questions;
	}

	
}
