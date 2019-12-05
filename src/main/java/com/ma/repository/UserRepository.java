package com.ma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ma.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	//通过名字校验
	@Query("from User where account= :account")
	User getName(@Param("account") String account);
	
	//寻找用户
	@Query("from User where account= :account and password= :password")
	User getUser(@Param("account") String account , @Param("password") String password );

	
	@Transactional
	@Modifying
	@Query("update User set password=:password  where account= :account")
	void updateUser(@Param("account") String account , @Param("password") String password );
}
