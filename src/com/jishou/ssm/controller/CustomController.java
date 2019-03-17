package com.jishou.ssm.controller;
/*
 *�ͻ�����*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jishou.ssm.pojo.BaseDict;
import com.jishou.ssm.pojo.Customer;
import com.jishou.ssm.pojo.QueryVo;
import com.jishou.ssm.service.BaseDictService;
import com.jishou.ssm.service.CustomerService;
import com.jishou.ssm.utils.Page;

@Controller
public class CustomController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;

	//���
	@RequestMapping(value="/customer/list")//���س���customer/list���������(�����������ļ�����/�Ļ���Ҳ������css��js��Щ)
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode("002");
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//ͨ��������ѯ
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page",page);
		
		//����(��ѯ��󣬲�ѯ������ʾ)
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custSource",vo.getCustSource());
		model.addAttribute("custIndustry",vo.getCustIndustry());
		model.addAttribute("custLevel",vo.getCustLevel());
		return "customer";
	}
	
	//����޸İ�ť�����ֵ����򣬰����ݷ��뵯������
	@RequestMapping(value="/customer/edit.action")
	@ResponseBody
	public Customer edit(Integer id){
		return customerService.selectCustomer(id);
	}
	
	//��������޸İ�ť
	@RequestMapping(value="/customer/update.action")
	@ResponseBody
	public void update(Customer customer){
		customerService.updateCustomer(customer);
	}
	
	//���ɾ��
	@RequestMapping(value="/customer/delete.action")
	@ResponseBody
	public String delete(Integer id){
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
