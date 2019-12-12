package com.ma.service;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.PluginValue;

import com.ma.entity.Frame_bank;


public interface FrameBankService {

	public List<Frame_bank> getSubject(Integer ordinal,Integer quantity);
}
