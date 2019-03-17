package com.jishou.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jishou.ssm.mapper.CustomerMapper;
import com.jishou.ssm.pojo.Customer;
import com.jishou.ssm.pojo.QueryVo;
import com.jishou.ssm.utils.Page;



/*
 * 客户管理*/

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		page.setSize(5);
		vo.setSize(5);
		if (null != vo) {
			if (null != vo.getPage()) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() -1)*vo.getSize());
			}
			if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			page.setTotal(customerMapper.customerCountByQueryVo(vo));
			page.setRows(customerMapper.selectCustomerListByQueryVo(vo));
		}
		return page;

	}

	@Override
	public Customer selectCustomer(Integer id) {
		return customerMapper.selectCustomer(id);
	}
	@Override
	public void updateCustomer(Customer customer){
		customerMapper.updateCustomer(customer);
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
	}
	
}
