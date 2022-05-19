package com.tds.common.service.impl;

import com.tds.common.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ISysRoleServiceImpl implements ISysRoleService {
    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        return null;
    }
}
