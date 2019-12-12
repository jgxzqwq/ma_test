package com.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.repository.Java_junior_bankRepository;
import com.ma.service.JavaJuniorBankService;

@Service
@Transactional
public class JavaJuniorBankImpl implements JavaJuniorBankService {

	@Autowired
	private Java_junior_bankRepository javaJuniorBank;
}
