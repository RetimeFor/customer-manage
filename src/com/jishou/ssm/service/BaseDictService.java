package com.jishou.ssm.service;

import java.util.List;

import com.jishou.ssm.pojo.BaseDict;

public interface BaseDictService {

	//��ѯ
		public List<BaseDict> selectBaseDictListByCode(String code); 
}
