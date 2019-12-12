package com.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.repository.Java_intermediate_bankRepository;
import com.ma.service.JavaIntermediateBankService;

@Service
@Transactional
public class JavaIntermediateBankImpl implements JavaIntermediateBankService {

	
	@Autowired
	private Java_intermediate_bankRepository frameBanfgk;

	
}
