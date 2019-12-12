package com.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.repository.Java_advanced_bankRepository;
import com.ma.service.JavaAdvancedBankService;

@Service
@Transactional
public class JavaAdvancedBankImpl implements JavaAdvancedBankService {

	
	@Autowired
	private Java_advanced_bankRepository javaAdvancedBank;
}
