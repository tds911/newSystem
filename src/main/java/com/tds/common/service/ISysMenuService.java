package com.tds.common.service;



import com.tds.common.web.domain.TreeSelect;
import com.tds.modules.domain.SysMenu;
import com.tds.project.vo.RouterVo;

import javax.servlet.http.PushBuilder;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface ISysMenuService {
    public Set<String> selectMenuPermsByUserId(Long userId);

    public List<SysMenu> selectMenuList(SysMenu menu,Long userId);

    public List<SysMenu> selectMenuList(Long userId);

    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    public List<Integer> selectMenuListByRoleId(Long roleId);

    public List<RouterVo> buildMenus(List<SysMenu> menus);

    public List<SysMenu> buildMenusTress(List<SysMenu>menus);

    public List<TreeSelect>buildMenuTreeSelect(List<SysMenu>menus);

    public SysMenu selectMenuById(Long menuId);

    public boolean hasChildByMenuId(Long menuId);

    public boolean checkMenuExistRole(Long menuId);

    public int insertMenu(SysMenu menu);

    public int updateMenu(SysMenu menu);

    public int deleteMenuById(Long menuId);

    public String checkMenuNameUnique(SysMenu menu);
}
