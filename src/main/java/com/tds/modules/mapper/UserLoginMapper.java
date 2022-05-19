package com.tds.modules.mapper;

import com.tds.modules.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper {

    User findByUsername(String username);
}
