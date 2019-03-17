package com.jishou.ssm.service;

import com.jishou.ssm.pojo.Customer;
import com.jishou.ssm.pojo.QueryVo;
import com.jishou.ssm.utils.Page;


public interface CustomerService {
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	
	public Customer selectCustomer(Integer id);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomerById(Integer id);
	
}
