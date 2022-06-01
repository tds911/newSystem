package com.tds.modules.mapper;

import com.tds.modules.domain.GenTable;
import com.tds.modules.domain.GenTableColumn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GenTableColumnMapper {
    List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);

    public List<GenTableColumn>selectDbTableColumnsByName(String tableName);



    public int  insertGenTableColumn(GenTableColumn genTableColumn);

    public int updateGenTableColumn(GenTableColumn genTableColumn);

    public int deleteGenTableColumnByIds(Long[] ids);
}
