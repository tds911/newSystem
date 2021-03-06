package com.tds.common.service.impl;

import com.tds.common.service.ISysUserService;
import com.tds.modules.domain.SysUser;
import com.tds.modules.domain.UserEntity;
import com.tds.modules.mapper.ISysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISysUserServiceImpl implements ISysUserService {
    private static final Logger log= LoggerFactory.getLogger(ISysUserServiceImpl.class);
    @Autowired
    private ISysUserMapper iSysUserMapper;
    @Override
    public SysUser selectUserByUserName(String UserName) {
        SysUser user = iSysUserMapper.selectUserByUserName(UserName);
        System.out.println(user);
        return user;
    }

    @Override
    public int addUser(SysUser sysUser) {
        return iSysUserMapper.addUser(sysUser);
    }

    @Override
    public int selectByName(String userName) {
        return iSysUserMapper.selectByName(userName);
    }
}
