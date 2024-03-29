package com.jishou.ssm.mapper;

import com.jishou.ssm.pojo.Customer;
import com.jishou.ssm.pojo.CustomerExample;
import com.jishou.ssm.pojo.QueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

	int customerCountByQueryVo(QueryVo vo);

	List<Customer> selectCustomerListByQueryVo(QueryVo vo);

	Customer selectCustomer(Integer id);

	void updateCustomer(Customer customer);

	void deleteCustomerById(Integer id);
}