package com.tds.common.mapper;

import com.tds.modules.domain.SysLogininfor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISysLogininforMapper {

    public void insertLogininfor(SysLogininfor loginimfor);
}
