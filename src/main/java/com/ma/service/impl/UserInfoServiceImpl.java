package com.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.UserInfo;
import com.ma.repository.UserInfoRepository;
import com.ma.service.UserInfoService;
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoRepository userInfoRepository;
	@Override
	public UserInfo updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
	
		return userInfoRepository.updateUserInfo(userInfo);
	}

}
