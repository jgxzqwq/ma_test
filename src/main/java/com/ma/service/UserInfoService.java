package com.ma.service;

import com.ma.entity.UserInfo;

public interface UserInfoService {
	UserInfo updateUserInfo(UserInfo userInfo);
	
	//根据id查询
	UserInfo conditionQuery (Integer id);

}
