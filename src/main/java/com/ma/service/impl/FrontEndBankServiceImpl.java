package com.ma.service.impl;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.PluginValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Front_end_bank;
import com.ma.repository.Front_end_bankRepository;

@Service
@Transactional
public class FrontEndBankServiceImpl implements com.ma.service.FrontEndBankService {

	
	@Autowired
	private Front_end_bankRepository frontEndBank;
	
	//根据该类型题该用户所做的最后一道题的id(ordinal)和要拿多少道题(quantity)返回题目集
	@Override
	public List<Front_end_bank> getSubject(@PluginValue("ordinal")Integer ordinal,@PluginValue("quantity") Integer quantity) {
		
		List<Front_end_bank> questions = frontEndBank.getQuestions(ordinal, quantity);
		for (Front_end_bank front_end_bank : questions) {
			System.out.println(front_end_bank);
		}
		return questions;
	}
}
