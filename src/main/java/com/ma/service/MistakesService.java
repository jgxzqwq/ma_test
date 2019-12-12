package com.ma.service;

import java.util.List;

import com.ma.entity.Mistakes;

public interface MistakesService {

	//统计错题数
	public Integer getStatistics(Integer user_id);
}
