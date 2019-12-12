package com.ma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Mistakes;
import com.ma.repository.MistakesRepository;
import com.ma.service.MistakesService;

@Service
@Transactional
public class MistakesServiceImpl implements MistakesService{

	
	@Autowired
	private MistakesRepository mistakesRepository;
	
	
	//统计该用户该类型的错题数量
	@Override
	public Integer getStatistics(Integer user_id) {
		Integer quantity = 10;
		Integer statistics = mistakesRepository.Statistics(user_id);
		if (statistics>3) {
			return quantity;
		}
		return quantity;
	}

}
