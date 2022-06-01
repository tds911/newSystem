package com.tds.modules.service.impl;

import com.tds.modules.domain.GenTableColumn;
import com.tds.modules.mapper.GenTableColumnMapper;
import com.tds.modules.service.GenTableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenTableColumnServiceImpl implements GenTableColumnService {
    @Autowired
    private GenTableColumnMapper genTableColumnMapper;
    @Override
    public List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId) {
        return genTableColumnMapper.selectGenTableColumnListByTableId(tableId);
    }
}
