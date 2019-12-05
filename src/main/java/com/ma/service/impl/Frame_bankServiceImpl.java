package com.ma.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ma.entity.Frame_bank;
import com.ma.repository.Frame_bankRepository;
import com.ma.service.Frame_bankService;
@Service
@Transactional
public class Frame_bankServiceImpl implements Frame_bankService {

	
	@Autowired
	private Frame_bankRepository frame_bankRepository;

	@Override
	public List<Frame_bank> findId(Integer id) {
		// TODO Auto-generated method stub
		List<Frame_bank> list=frame_bankRepository.findId(id);
		
		return list;
	}
	
	
	
	/**
	 * 查询
	 */

	


}
