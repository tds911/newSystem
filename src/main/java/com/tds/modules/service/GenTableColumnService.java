package com.tds.modules.service;

import com.tds.modules.domain.GenTableColumn;

import java.util.List;

public interface GenTableColumnService {
    List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);
}
