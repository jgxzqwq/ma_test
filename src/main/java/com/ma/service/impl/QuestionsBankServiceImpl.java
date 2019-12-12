package com.ma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Paper_records;
import com.ma.entity.User;
import com.ma.service.FrameBankService;
import com.ma.service.FrontEndBankService;
import com.ma.service.JavaAdvancedBankService;
import com.ma.service.JavaIntermediateBankService;
import com.ma.service.JavaJuniorBankService;
import com.ma.service.MistakesService;
import com.ma.service.QuestionsBankService;
import com.ma.service.UserService;

@Service
@Transactional
public class QuestionsBankServiceImpl implements QuestionsBankService {
	@Autowired
	private FrameBankService frameBank;

	@Autowired
	private FrontEndBankService frontEndBankService;
	
	@Autowired
	private JavaAdvancedBankService javaAdvancedBankService;
	
	@Autowired
	private JavaIntermediateBankService javaIntermediateBankService;
	
	@Autowired 
	private JavaJuniorBankService javaJuniorBankService;

	
	@Autowired
	private MistakesService mistakesService;

	
	//获取试题
	@Override
	public List getQuestions(User user, Integer questionType) {
		
		Integer statistics = mistakesService.getStatistics(user.getId());
		List types = type(questionType,user.getPaper_records(),statistics);
	
		return types;
	
	
	}


	public  List type(Integer id,Paper_records pa,Integer quantity){

		List sd = null;

		switch (id) {
		case 1:
	
			sd = frameBank.getSubject(pa.getFrame_id(), quantity);
			break;
		case 2:
			System.out.println(2);
			sd = frontEndBankService.getSubject(pa.getFront_end_id(), quantity);
			break;
		case 3:
			System.out.println("**********************");
			sd = javaJuniorBankService.getSubject(pa.getJava_junior_id(), quantity);
			System.out.println("**********************");
			System.out.println(sd.toString());
			System.out.println("**********************");
			break;
		case 4:
			sd = javaIntermediateBankService.getSubject(pa.getJava_junior_id(), quantity);
			break;
		case 5:
			sd = javaAdvancedBankService.getSubject(pa.getJava_advanced_id(), quantity);
			break;		
		default:
			break;
		}
		return sd;
		
	}

}
