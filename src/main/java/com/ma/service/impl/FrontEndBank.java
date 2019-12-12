package com.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.repository.Front_end_bankRepository;

@Service
@Transactional
public class FrontEndBank implements com.ma.service.FrontEndBankService {

	
	@Autowired
	private Front_end_bankRepository frontEndBank;
}
