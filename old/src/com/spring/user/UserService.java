package com.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.service.BaseService;

@Service
public class UserService extends BaseService<User> {
  @Autowired
  private UserDao dao;
  
  @Override
  public UserDao cuDao() {
	 
	  return dao;
  }
  
  public Boolean login(String name,String pass,String code) {
	  
	  return true;
  }
  
  
}
