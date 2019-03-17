package com.jishou.ssm.controller;
/*
 *客户管理*/

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

	//入口
	@RequestMapping(value="/customer/list")//拦截除了customer/list以外的请求(由于在配置文件中是/的话，也会拦截css，js那些)
	public String list(QueryVo vo,Model model){
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode("002");
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//通过条件查询
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page",page);
		
		//回显(查询完后，查询条件显示)
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custSource",vo.getCustSource());
		model.addAttribute("custIndustry",vo.getCustIndustry());
		model.addAttribute("custLevel",vo.getCustLevel());
		return "customer";
	}
	
	//点击修改按钮，出现弹出框，把内容放入弹出框里
	@RequestMapping(value="/customer/edit.action")
	@ResponseBody
	public Customer edit(Integer id){
		return customerService.selectCustomer(id);
	}
	
	//点击保存修改按钮
	@RequestMapping(value="/customer/update.action")
	@ResponseBody
	public void update(Customer customer){
		customerService.updateCustomer(customer);
	}
	
	//点击删除
	@RequestMapping(value="/customer/delete.action")
	@ResponseBody
	public String delete(Integer id){
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
