package com.tds.project.task;

import com.tds.common.utils.StringUtils;
import com.tds.project.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ryTask")
public class Rytask {
    @Autowired
    private DemoService demoService;

    /**
     * 测试
     */
    public void demo(){
        demoService.demo();
    }


    public void ryMultipleParams(String s,boolean b,Long l,Double d,Integer i){
        System.out.println(StringUtils.format("执行多参方法: 字符串类型{},布尔类型{},整形{}",s,b,l,d,i));
    }
    public void ryParams(String params){
        System.out.println("执行有参方法:"+params);
    }
}
