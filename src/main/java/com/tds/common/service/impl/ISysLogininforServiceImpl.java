package com.tds.common.service.impl;

import com.tds.common.mapper.ISysLogininforMapper;
import com.tds.common.service.ISysLogininforService;
import com.tds.modules.domain.SysLogininfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISysLogininforServiceImpl implements ISysLogininforService {
    @Autowired
    private ISysLogininforMapper iSysLogininforMapper;

    @Override
    public void insertLogininfor(SysLogininfor loginimfor) {
        iSysLogininforMapper.insertLogininfor(loginimfor);
    }
}
