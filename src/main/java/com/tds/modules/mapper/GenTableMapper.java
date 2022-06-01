package com.tds.modules.mapper;

import com.tds.modules.domain.GenTable;
import com.tds.modules.domain.GenTableColumn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenTableMapper {
    public List<GenTable> selectDbTableListByNames(String[] tableNames);

    public int insertGenTable(GenTable genTable);

    public List<GenTable> selectGenTableList(GenTable genTable);

    public GenTable selectGenTableById(Long id);

    public List<GenTable>selectDbTableList(GenTable genTable);

    public int updateGenTable(GenTable genTable);

    public int deleteGenTableByIds(Long[] ids);


    public GenTable selectGenTableByName(String tableName);

    public long selectMenuId();
}
