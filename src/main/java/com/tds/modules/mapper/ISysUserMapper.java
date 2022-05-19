package com.tds.modules.mapper;

import com.tds.modules.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISysUserMapper {
    public SysUser selectUserByUserName(String UserName);

    public int addUser(SysUser sysUser);

    public int selectByName(String userName);
}
