package com.tds.common.service;

import com.tds.modules.domain.SysUser;

public interface ISysUserService {

    public SysUser selectUserByUserName(String UserName);

    public int addUser(SysUser sysUser);

    public int selectByName(String userName);


}
