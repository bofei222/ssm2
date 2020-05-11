package com.bf.mapper;

import com.bf.pojo.CustomOrders;
import com.bf.pojo.Orders;
import com.bf.pojo.QueryVo;
import com.bf.pojo.User;

import java.util.List;

public interface UserMapper {
	User findUserById(Integer id);
	
	// 动态代理形式中，当返回结果集为List，mybatis在生成实现类的时候会自动调用selectList方法
	List<User> findUserByUserName(String username);
	
	List<User> findUserByVo(QueryVo vo);
	
	Integer findUserCount();
	
	List<User> findUserByUserNameAndSex(User user);
	
	List<User> findUserByIds(QueryVo vo);
	
	List<CustomOrders> findOrdersAndUser1();
	
	List<Orders> findOrdersAndUser2();
	
	List<User> findUserAndOrders();
}
