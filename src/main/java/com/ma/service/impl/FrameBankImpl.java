package com.ma.service.impl;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.PluginValue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Frame_bank;
import com.ma.repository.Frame_bankRepository;
import com.ma.service.FrameBankService;

@Service
@Transactional
public class FrameBankImpl implements FrameBankService {

	@Autowired
	private Frame_bankRepository framebank;
	
	//根据该类型题该用户所做的最后一道题的id(ordinal)和要拿多少道题(quantity)返回题目集
	public List<Frame_bank> getSubject(@PluginValue("ordinal")Integer ordinal,@PluginValue("quantity") Integer quantity)
	{
			List<Frame_bank> questions = framebank.getQuestions(ordinal,quantity);
			
		return questions;
	}
}

