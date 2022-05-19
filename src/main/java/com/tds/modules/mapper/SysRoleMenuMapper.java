package com.tds.modules.mapper;

import com.tds.modules.domain.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysRoleMenuMapper {
    int checkMenuExistRole(Long menuId);

    int deleteRoleMenuByRoleId(Long roleId);

    int batchRoleMenu(List<SysRoleMenu> roleMenuList);
}
