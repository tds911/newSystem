package com.tds.modules.service.impl;

import com.tds.modules.domain.User;
import com.tds.modules.mapper.UserLoginMapper;
import com.tds.modules.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;
    
    @Override
    public User findByUsername(String username) {
      //  System.out.println(userLoginMapper.findByUsername(username));
        return userLoginMapper.findByUsername(username);
    }
}
