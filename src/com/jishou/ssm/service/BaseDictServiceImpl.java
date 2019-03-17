package com.jishou.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jishou.ssm.mapper.BaseDictMapper;
import com.jishou.ssm.pojo.BaseDict;

@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService{
	
	@Autowired
	private BaseDictMapper baseDictMapper;

	@Override
	public List<BaseDict> selectBaseDictListByCode(String code) {
		// TODO Auto-generated method stub
		return baseDictMapper.selectBaseDictListByCode(code);
	}
}
