package com.tds.common.service;

import org.springframework.stereotype.Component;

import java.util.Set;


public interface ISysRoleService {
    public Set<String> selectRolePermissionByUserId(Long userId);
}
