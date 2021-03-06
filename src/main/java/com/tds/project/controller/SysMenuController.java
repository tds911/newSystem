package com.tds.project.controller;

import com.tds.common.utils.SecurityUtils;
import com.tds.common.constant.Constants;
import com.tds.common.constant.UserConstants;
import com.tds.common.security.service.TokenService;
import com.tds.common.service.ISysMenuService;
import com.tds.common.utils.ServletUtils;
import com.tds.common.utils.StringUtils;
import com.tds.common.web.controller.BaseController;
import com.tds.common.web.domain.TreeSelect;
import com.tds.common.web.domain.server.AjaxResult;
import com.tds.modules.domain.SysMenu;
import com.tds.modules.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("system/menu")
public class SysMenuController extends BaseController {
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/list")
    public AjaxResult list(SysMenu menu) {
        UserEntity userEntity = tokenService.getLoginUser(ServletUtils.getRequest());
        Long userId = userEntity.getUser().getUserId();
        List<SysMenu> menus = menuService.selectMenuList(menu, userId);
        return AjaxResult.success(menus);
    }

    @GetMapping("/{menuId}")
    public AjaxResult getInfo(@PathVariable Long menuId) {
        return AjaxResult.success(menuService.selectMenuById(menuId));
    }

    @GetMapping("/treeselect")
    public AjaxResult treeselect(SysMenu menu) {
        UserEntity userEntity = tokenService.getLoginUser(ServletUtils.getRequest());
        Long userId = userEntity.getUser().getUserId();
        List<SysMenu> menus = menuService.selectMenuList(menu, userId);
        List<TreeSelect> treeSelects = menuService.buildMenuTreeSelect(menus);
        return AjaxResult.success(treeSelects);
    }

    @GetMapping(value = "/roleMenuTreeselect/{roleId}")
    public AjaxResult roleMenuTreeselect(@PathVariable("roleId") Long roleId) {
        UserEntity userEntity = tokenService.getLoginUser(ServletUtils.getRequest());
        List<SysMenu> menus = menuService.selectMenuList(userEntity.getUser().getUserId());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", menuService.selectMenuListByRoleId(roleId));
        ajax.put("menus", menuService.buildMenusTress(menus));
        return ajax;
    }

    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysMenu menu) {
        if (UserConstants.NOT_UNIQUE.equals(menuService.checkMenuNameUnique(menu))) {
            return AjaxResult.error("????????????'" + menu.getMenuName() + "'??????????????????????????????");
        } else if (UserConstants.YES_FRAME.equals(menu.getIsFrame()) && !StringUtils.startsWithAny(menu.getPath(), Constants.HTTP, Constants.HTTPS)) {
            return AjaxResult.error("????????????'" + menu.getMenuName() + "'??????,???????????????http(s)://??????");
        }
        String username = SecurityUtils.getUsername();
        System.out.println(username);
        menu.setCreateBy(SecurityUtils.getUsername());
        return toAjax(menuService.insertMenu(menu));
    }

    @PutMapping("/edit")
    public AjaxResult edit(@Validated @RequestBody SysMenu menu){
        if (UserConstants.NOT_UNIQUE.equals(menuService.checkMenuNameUnique(menu))){
            return AjaxResult.error("????????????'"+menu.getMenuName()+"'??????????????????????????????");
        }else if (UserConstants.YES_FRAME.equals(menu.getIsFrame())&&!StringUtils.startsWithAny(menu.getPath(),Constants.HTTP,Constants.HTTPS)){
            return AjaxResult.error("????????????'" + menu.getMenuName() + "'??????,???????????????http(s)://??????");
        }
        menu.setUpdateBy(SecurityUtils.getUsername());
        return  toAjax(menuService.updateMenu(menu));
    }

    @DeleteMapping("/{menuId}")
    public AjaxResult remove(@PathVariable("menuId")Long menuId){
        if (menuService.hasChildByMenuId(menuId)){
            return AjaxResult.error("?????????????????????????????????");
        }if (menuService.checkMenuExistRole(menuId)){
            return AjaxResult.error("?????????????????????????????????");
        }
        return toAjax(menuService.deleteMenuById(menuId));
    }
}
