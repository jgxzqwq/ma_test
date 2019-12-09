package com.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.User;
import com.ma.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{

//	@Transactional
//	@Modifying(clearAutomatically = true)
//	@Query(value="update UserInfo  set name= :#{#userInfo.name},clazz= :#{#userInfo.clazz},grade= :#{#userInfo.grade},experience= :#{#userInfo.experience},head_img= :#{#userInfo.head_img},score= :#{#userInfo.score}  where id=  :#{#userInfo.id}",nativeQuery=true)
//	void updateUserInfo(@Param("userInfo") UserInfo userInfo);
	
	
	
	@Query(value="select * from UserInfo  where id= ?#{#userInfo.getId()}",nativeQuery=true)
	void updateUserInfo(UserInfo userInfo);
	
	
	

}
