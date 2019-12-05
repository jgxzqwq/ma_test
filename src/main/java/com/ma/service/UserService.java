package com.ma.service;
import com.ma.entity.User;

public interface UserService {
	    //通过名字校验
		User getName(String account);
		//寻找用户
		User getUser(String account , String password );
		void save(User user);
		void updateUser(String account ,String password );
		User findOne(Integer id);
}
