package com.ma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.User;
import com.ma.repository.UserRepository;
import com.ma.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public User getName(String account) {
		// TODO Auto-generated method stub
		return userRepository.getName(account);
	}
	@Override
	public User getUser(String account, String password) {
		// TODO Auto-generated method stub
		return userRepository.getUser(account, password);
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	@Override
	public void updateUser(String account, String password) {
		// TODO Auto-generated method stub
		userRepository.updateUser(account, password);
	}
	@Override
	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}
	

}
