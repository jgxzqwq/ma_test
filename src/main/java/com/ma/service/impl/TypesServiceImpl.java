package com.ma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.Types;
import com.ma.repository.TypesRepository;
import com.ma.service.TypesService;
@Service
@Transactional
public class TypesServiceImpl implements TypesService{

	@Autowired
	private TypesRepository typesRepository;
	@Override
	public List<Types> findAll() {
		// TODO Auto-generated method stub
		List<Types> list=typesRepository.findAll();
		return list;
	}

}
